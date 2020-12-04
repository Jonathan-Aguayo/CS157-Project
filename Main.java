import java.util.Scanner;

public class Main {
	
	public static int userType;
	
	/**
	 * Main function.
	 * @param args Array of arguments.
	 */
	public static void main(String[] args) {
		signIn();
		menu();
	}
	
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
	public static void menu() {
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
			    	option1();
			    } else if (option == 2) {
			    	option2();
			    } else if (option == 3) {
			    	option3();
			    } else if (option == 4) {
			    	option4();
			    } else if (option == 5) {
			    	option5();
			    } else if (option == 6) {
			    	option6();
			    } else if (option == 7) {
			    	option7();
			    } else if (option == 8) {
			    	option8();
			    } else if (option == 9) {
			    	option9();
			    } else if (option == 10) {
			    	option10();
			    } else if (option == 11) {
			    	option11();
			    } else if (option == 12) {
			    	option12();
			    } else if (option == 13) {
			    	option13();
			    } else if (option == 14) {
			    	option14();
			    } else if (option == 15) {
			    	option15();
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
	public static void option1() {
		Scanner sc = new Scanner(System.in);
		String birthyear;
		
		sopln("");
		sopln("Please enter the birthyear: ");
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
		
		sopln("");
	}
	
	/**
	 * Display names of professionals currently alive.
	 */
	public static void option2() {
		sopln("");
		
		/** 
		 * ENTER QUERY EXECUTION HERE 
		 */
		
		sopln("");
	}
	
	/**
	 * Display names of professionals with a certain profession.
	 */
	public static void option3() {
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
		
		sopln("");
	}
	
	/**
	 * Display titles from a certain region.
	 */
	public static void option4() {
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
		
		sopln("");
	}
	
	/**
	 * Display titles that are a certain format.
	 */
	public static void option5() {
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
		
		sopln("");
	}
	
	/**
	 * Display titles that are a certain genre.
	 */
	public static void option6() {
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
		
		sopln("");
	}
	
	/**
	 * Display directors given an alphanumeric unique identifier of the title.
	 */
	public static void option7() {
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
		
		sopln("");
	}
	
	/**
	 * Display season number given an alphanumeric identifier of the episode.
	 */
	public static void option8() {
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
		
		sopln("");
	}
	
	/**
	 * Display job category given an alphanumeric unique identifier of the name.
	 */
	public static void option9() {
		Scanner sc = new Scanner(System.in);
		String category;
		
		sopln("");
		sopln("Please enter the alphanumeric unique identifier of the name: ");
		boolean done = false;
		while (!done) {
			sop(">> ");
			if (sc.hasNextLine()) {
				category = sc.nextLine();
			    done = true;
			} else {
				sc.next();
			}
		}
		
		/** 
		 * ENTER QUERY EXECUTION HERE 
		 */
		
		sopln("");
	}
	
	/**
	 * Display titles that are greater than or equal to a given rating.
	 */
	public static void option10() {
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
		
		sopln("");
	}
	
	/**
	 * 
	 */
	public static void option11() {
		
	}
	
	/**
	 * 
	 */
	public static void option12() {
		
	}
	
	/**
	 * 
	 */
	public static void option13() {
		
	}
	
	/**
	 * 
	 */
	public static void option14() {
		
	}
	
	/**
	 * 
	 */
	public static void option15() {
		
	}

}
