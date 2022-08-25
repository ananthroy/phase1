package com.phase1.project;

import java.util.*;
import java.io.IOException;

public class Menus {
	Scanner in = new Scanner(System.in);
	Operations dao = new Operations();

	public void introScreen() {
		System.out.println();
		System.out.println("	 				DEVELOPED BY Ananth Roy");
		System.out.println("   		 				LOCKEDME.COM");
		System.out.println("     		Directory: " + main.path);
		System.out.println();
	}

	public void exitScreen() {
		System.out.println("			THANK YOU FOR VISITING LOCKEDME.COM        ");

	}

	public void mainMenuOptions() {
		System.out.println("       				 Main Menu");
		System.out.println("			Select any one of the following:");
		System.out.println("			  1 - List All Files           ");
		System.out.println("			  2 - More Options              ");
		System.out.println("			  3 - Exit                      ");
		System.out.println("			Enter your choice : ");
	}

	public void subMenuOptions() {

		System.out.println("			           SUB MENU               ");

		System.out.println("			Select any one of the following: ");
		System.out.println("			   1 - Add a file                  ");
		System.out.println("			   2 - Delete a file               ");
		System.out.println("			   3 - Search a file               ");
		System.out.println("			   4 - Go Back                     ");
		System.out.println("			Enter your choice : ");

	}

	public void mainMenu() { // here defining the main menu option

		int choice = 0;
		char decision = 0;
		do {

			mainMenuOptions(); // calling the main menu

			try {
				choice = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input \nValid Input Integers:(1-3)\n");
				mainMenu();
			}

			switch (choice) {

				case 1:
					System.out.println();
					try {
						dao.listAllFiles(main.path);
					} catch (NullPointerException e) {
						System.out.println(e.getMessage());
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

					break;

				case 2:
					System.out.println();
					subMenu();
					break;

				case 3:
					System.out.println("\n			 Are you sure you want to exit ? ");
					System.out.println(" 			 (Y) ==> Yes    (N) ==> No        ");
					decision = in.nextLine().toUpperCase().charAt(0);
					if (decision == 'Y') {
						System.out.println("\n");
						exitScreen();
						System.exit(1);
					} else if (decision == 'N') {
						System.out.println("\n");
						mainMenu();
					} else {
						System.out.println("\n			Invalid Input \nValid Inputs :(Y/N)\n");
						mainMenu();
					}

				default:
					System.out.println("\n			Invalid Input \nValid Input Integers:(1-3)\n");
					mainMenu();

			}

		} while (true);

	}

	public void subMenu() { // defining the Submenu
		String file = null;
		String fileName = null;
		int choice = 0;

		do {

			subMenuOptions();

			try {
				choice = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("			Invalid Input \nValid Input Integers:(1-4)");
				subMenu();
			}

			switch (choice) {
				case 1:
					System.out.println("\n==> 			Adding a File...");
					System.out.println("			Please enter a file name : ");
					file = in.nextLine();
					fileName = file.trim();
					try {
						dao.createNewFile(main.path, fileName);
					} catch (NullPointerException e) {
						System.out.println(e.getMessage());
					} catch (IOException e) {
						System.out.println("			Error occurred while adding file..");
						System.out.println("			Please try again...");
					} catch (Exception e) {
						System.out.println("			Error occurred while adding file..");
						System.out.println("			Please try again...");
					}

					break;

				case 2:
					System.out.println("\n			==> Deleting a File...");
					System.out.println("			Please enter a file name to Delete : ");
					file = in.nextLine();
					fileName = file.trim();
					try {
						dao.deleteFile(main.path, fileName);
					} catch (NullPointerException e) {
						System.out.println(e.getMessage());
					} catch (IOException e) {
						System.out.println("			Error occurred while Deleting File..");
						System.out.println("			Please try again...");
					} catch (Exception e) {
						System.out.println("			Error occurred while Deleting File..");
						System.out.println("			Please try again...");
					}

					break;

				case 3:
					System.out.println("\n			==> Searching a File...");
					System.out.println("			Using Linear Search Algorithm to Search");
					System.out.println("			Please enter a file name to Search : ");
					file = in.nextLine();
					fileName = file.trim();
					try {
						dao.searchFile(main.path, fileName);
					} catch (NullPointerException e) {
						System.out.println(e.getMessage());
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

					break;
				case 4:
					mainMenu();
					break;

				default:
					System.out.println("			Invalid Input \nValid Input Integers:(1-4)");
					subMenu();

			}

			file = null;
			fileName = null;

		} while (true);

	}
}
