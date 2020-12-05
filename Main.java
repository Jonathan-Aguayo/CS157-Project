import java.util.Scanner;
import java.sql.*;

public class Main {
    // JDBC driver name and database URL
    static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "password";
    private static Connection conn = null;
    private static Statement statement = null;

    public static void main(String[] args) throws SQLException
    {
        try
        {
            conn = DriverManager.getConnection(DB_URL+"?serverTimezone=UTC", USER, PASS);
            conn = DriverManager.getConnection(DB_URL+"project?serverTimezone=UTC", USER, PASS);
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(""); // The result goes to ResultSet
            System.out.println("Displaying record ...");
            while (rs.next())
            {
                String id = rs.getNString("titleID");
                System.out.println("ID: " + id);
            }

        }
        catch(SQLException se){se.printStackTrace(); }
        catch(Exception e){ e.printStackTrace(); }
        finally
        {
            try{ if(statement!=null)statement.close(); }
            catch(SQLException se2){ }// nothing we can do

            try{ if(conn!=null) conn.close(); }
            catch(SQLException se){ se.printStackTrace(); }
        }
        System.out.println("Goodbye!");
        signIn();
        menu();
    }//end main

    private static void createDatabase() throws SQLException
    {

        // Open a connection
        System.out.println("Connecting to database...");


        // Create a database named CS
        System.out.println("Creating database...");
        statement = conn.createStatement();

        String queryDrop = "DROP DATABASE IF EXISTS cs";
        //Statement stmtDrop = conn.createStatement();
        statement.execute(queryDrop);
        String sql = "CREATE DATABASE project";
        statement.executeUpdate(sql);
        System.out.println("Database created successfully...");
    }
    private static void createTable() throws SQLException
    {
        // Open a connection and select the database named CS

        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL+"project1?serverTimezone=UTC", USER, PASS);
        statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        String queryDrop = "DROP TABLE IF EXISTS STUDENTS";
        statement.execute(queryDrop);
    }

    private static void manipulateData() throws SQLException
    { ResultSet rs = statement.executeQuery(""); // The result goes to ResultSet
        System.out.println("Displaying record ...");
        while (rs.next())
        {
            String id = rs.getNString("ID");
            String name = rs.getString("name");
            System.out.println("ID:" + id + " Name:" + name );
        }
        // Inserting a row to the ResultSet
    }


    public static int userType;

    /**
     * Shortcut of System.out.print().
     * @param text Text to display.
     */
    public static void sop(String text) {
        System.out.print(text);
    }

    /**
     * Shortcut of System.out.println().
     * @param text Text to display.
     */
    public static void sopln(String text) {
        System.out.println(text);
    }

    /**
     * Displays welcome message.
     * Asks for user type selection.
     */
    public static void signIn() {
        Scanner sc = new Scanner(System.in);

        sopln("-=+ IMDB Streaming Service +=-");
        sopln("Welcome! Our platform allows users to view any video content reviewed on IMDB.com.");
        sopln("Sign In:");
        sopln("1. User");
        sopln("2. Administrator");
        sopln("3. Database Administrator");
        boolean done = false;
        while (!done) {
            sop(">> ");
            if (sc.hasNextInt()) {
                userType = sc.nextInt();
                if (userType == 1 || userType == 2 || userType == 3) {
                    done = true;
                }
            } else {
                sc.next();
            }
        }
        String user;
        if (userType == 1) {
            user = "User";
        } else if (userType == 2) {
            user = "Administrator";
        } else {
            user = "Database Administrator";
        }
        sopln("Thank you for joining us, " + user + ".");
        sopln("");
    }

    /**
     * Displays total options.
     * Asks for user to choose an option to work with DB.
     */
    public static void menu() throws SQLException {
        Scanner sc = new Scanner(System.in);

        boolean done = false;
        while (!done) {
            int option;
            sopln("-=+ IMDB Streaming Service: Search +=-");
            sopln("Please select one of the available options: ");
            sopln("1. Display names of professionals born after a certain year.");
            sopln("2. Display names of professionals currently alive.");
            sopln("3. Display names of professionals with a certain profession.");
            sopln("4. Display titles from a certain region.");
            sopln("5. Display titles that are a certain format.");
            sopln("6. Display titles that are a certain genre. ");
            sopln("7. Display directors given an alphanumeric unique identifier of the title.");
            sopln("8. Display season number given an alphanumeric identifier of the episode.");
            sopln("9. Display job category given an alphanumeric unique identifier of the name.");
            sopln("10. Display titles that are greater than or equal to a given rating.");
            sopln("11. ");
            sopln("12. ");
            sopln("13. ");
            sopln("14. ");
            sopln("15. ");
            sop(">> ");
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                if (option == 1) {
                    option1(statement);
                } else if (option == 2) {
                    option2(statement);
                } else if (option == 3) {
                    option3(statement);
                } else if (option == 4) {
                    option4(statement);
                } else if (option == 5) {
                    option5(statement);
                } else if (option == 6) {
                    option6(statement);
                } else if (option == 7) {
                    option7(statement);
                } else if (option == 8) {
                    option8(statement);
                } else if (option == 9) {
                    option9(statement);
                } else if (option == 10) {
                    option10(statement);
                } else if (option == 11) {
                    option11(statement);
                } else if (option == 12) {
                    option12(statement);
                } else if (option == 13) {
                    option13(statement);
                } else if (option == 14) {
                    option14(statement);
                } else if (option == 15) {
                    option15(statement);
                }
            } else {
                sc.next();
            }
        }
        sopln("");
    }

    /**
     * Display names of professionals born after a certain year.
     */
    public static void option1(Statement statement) throws SQLException{
        Scanner sc = new Scanner(System.in);
        String birthyear;

        sopln("");
        sopln("Please enter the birth year: ");
        boolean done = false;
        while (!done) {
            sop(">> ");
            if (sc.hasNextLine()) {
                birthyear = sc.nextLine();
                done = true;
            } else {
                sc.next();
            }
        }

        /**
         * ENTER QUERY EXECUTION HERE 
         */
        ResultSet rs;
        String query = "select name from names where birthyear > " + birthyear;
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String name = rs.getString(2);
            sopln(name);
        }
        sopln("");
    }

    /**
     * Display names of professionals currently alive.
     */
    public static void option2(Statement statement) throws SQLException {
        sopln("");

        /**
         * ENTER QUERY EXECUTION HERE 
         */
        ResultSet rs;
        String query = "select name from names where deathyear is null";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String name = rs.getString(2);
            sopln(name);
        }

        sopln("");
    }

    /**
     * Display names of professionals with a certain profession.
     */
    public static void option3(Statement statement) throws SQLException{
        Scanner sc = new Scanner(System.in);
        String profession;

        sopln("");
        sopln("Please enter the profession: ");
        boolean done = false;
        while (!done) {
            sop(">> ");
            if (sc.hasNextLine()) {
                profession = sc.nextLine();
                done = true;
            } else {
                sc.next();
            }
        }

        /**
         * ENTER QUERY EXECUTION HERE 
         */
        ResultSet rs;
        String query = "select name from names where primaryprofession = '" + profession + "'";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String name = rs.getString(2);
            sopln(name);
        }
        sopln("");
    }

    /**
     * Display titles from a certain region.
     */
    public static void option4(Statement statement) throws SQLException{
        Scanner sc = new Scanner(System.in);
        String region;

        sopln("");
        sopln("Please enter the region: ");
        boolean done = false;
        while (!done) {
            sop(">> ");
            if (sc.hasNextLine()) {
                region = sc.nextLine();
                done = true;
            } else {
                sc.next();
            }
        }

        /**
         * ENTER QUERY EXECUTION HERE 
         */
        ResultSet rs;
        String query = "select title from title_akas where region = '" + region +"'";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String title = rs.getString(3);
            sopln(title);
        }
        sopln("");
    }

    /**
     * Display titles that are a certain format.
     */
    public static void option5(Statement statement) throws SQLException{
        Scanner sc = new Scanner(System.in);
        String format;

        sopln("");
        sopln("Please enter the format: ");
        boolean done = false;
        while (!done) {
            sop(">> ");
            if (sc.hasNextLine()) {
                format = sc.nextLine();
                done = true;
            } else {
                sc.next();
            }
        }

        /**
         * ENTER QUERY EXECUTION HERE 
         */
        ResultSet rs;
        String query = "select title from title_akas where kind = '" + format +"'";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String title = rs.getString(3);
            sopln(title);
        }

        sopln("");
    }

    /**
     * Display titles that are a certain genre.
     */
    public static void option6(Statement statement) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String genre;

        sopln("");
        sopln("Please enter the genre: ");
        boolean done = false;
        while (!done) {
            sop(">> ");
            if (sc.hasNextLine()) {
                genre = sc.nextLine();
                done = true;
            } else {
                sc.next();
            }
        }

        /**
         * ENTER QUERY EXECUTION HERE 
         */
        ResultSet rs;
        String query = "select title from title_akas join title_basics " +
                "on title_akas.titleID = title_basics.titleID where title_basics.genres = '" + genre + "'";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String title = rs.getString(3);
            sopln(title);
        }
        sopln("");
    }

    /**
     * Display directors given an alphanumeric unique identifier of the title.
     */
    public static void option7(Statement statement) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String title;

        sopln("");
        sopln("Please enter the alphanumeric unique identifier of the title: ");
        boolean done = false;
        while (!done) {
            sop(">> ");
            if (sc.hasNextLine()) {
                title = sc.nextLine();
                done = true;
            } else {
                sc.next();
            }
        }

        /**
         * ENTER QUERY EXECUTION HERE 
         */
        ResultSet rs;
        String query = "select name from names where primaryprofession = 'director' and knownForTitles ='" + title +"'";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String name = rs.getString(2);
            sopln(name);
        }
        sopln("");
    }

    /**
     * Display season number given an alphanumeric identifier of the episode.
     */
    public static void option8(Statement statement) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String title;

        sopln("");
        sopln("Please enter the alphanumeric identifier of the episode: ");
        boolean done = false;
        while (!done) {
            sop(">> ");
            if (sc.hasNextLine()) {
                title = sc.nextLine();
                done = true;
            } else {
                sc.next();
            }
        }

        /**
         * ENTER QUERY EXECUTION HERE 
         */
        ResultSet rs;
        String query = "select seasonNumber from title_episodes where titleID = '" + title + "'";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String sn = rs.getString(3);
            sopln(sn);
        }


    }

    /**
     * Display job category given an alphanumeric unique identifier of the name.
     */
    public static void option9(Statement statement) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String title;

        sopln("");
        sopln("Please enter the alphanumeric unique identifier of the name: ");
        boolean done = false;
        while (!done) {
            sop(">> ");
            if (sc.hasNextLine()) {
                title = sc.nextLine();
                done = true;
            } else {
                sc.next();
            }
        }

        /**
         * ENTER QUERY EXECUTION HERE 
         */
        ResultSet rs;
        String query = "select category from title_principals where titleID = '" + title + "'";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String category = rs.getString(4);
            sopln(title);
        }
        sopln("");
    }

    /**
     * Display titles that are greater than or equal to a given rating.
     */
    public static void option10(Statement statement) throws SQLException{
        Scanner sc = new Scanner(System.in);
        String rating;

        sopln("");
        sopln("Please enter the rating: ");
        boolean done = false;
        while (!done) {
            sop(">> ");
            if (sc.hasNextLine()) {
                rating = sc.nextLine();
                done = true;
            } else {
                sc.next();
            }
        }

        /**
         * ENTER QUERY EXECUTION HERE 
         */
        ResultSet rs;
        String query = "select title from title_akas join title_ratings on title_akas.titleID = title_ratings.titleID where title_ratings.averageRating >= " + rating;
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String title = rs.getString(2);
            sopln(title);
        }
        sopln("");
    }

    /**
     * Display top 5 rated movies (correlated subquery)
     */
    public static void option11(Statement statement) throws SQLException{

        ResultSet rs;
        String query = "select title from title_akas a where a.titleID = (select b.titleID from title_ratings b orderby averageRating desc limit 5";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String title = rs.getString(3);
            sopln(title);
        }
        sopln("");
    }

    /**
     * Display titleIDs with more than 10 associated titles (group by having)
     */
    public static void option12(Statement statement) throws SQLException {
        ResultSet rs;
        String query = "select titleID count(title) from title_akas group by titleID having count(title) > 10";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String title = rs.getString(3);
            sopln(title);
        }
        sopln("");
    }

    /**
     * Display the first actors in history (aggregation function min)
     */
    public static void option13(Statement statement) throws SQLException {
        ResultSet rs;
        String query = "select name from names where primaryprofession = 'actor' and min(birthyear)";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String title = rs.getString(3);
            sopln(title);
        }
        sopln("");
    }

    /**
     * set operation
     */
    public static void option14(Statement statement) throws SQLException{
        ResultSet rs;
        String query = "select";
        rs = statement.executeQuery(query);
        while(rs.next())
        {
            String title = rs.getString(3);
            sopln(title);
        }
        sopln("");
    }

    /**
     * Show titles with over 50 episodes
     */
    public static void option15(Statement statement) throws SQLException{

    }
}
