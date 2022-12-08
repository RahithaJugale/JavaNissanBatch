package com.nissan.col;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class DemoQuizCollection {

	private static Scanner scanner = new Scanner(System.in);
	private static Scanner scanner1 = new Scanner(System.in);

	private static HashMap<String, String> statesAndCapitals = new HashMap<String, String>();
	private static HashMap<Integer, String> indexAndStates = new HashMap<Integer, String>();
	private static HashMap<String, String> quiz = new HashMap<String, String>();
	private static HashMap<String, String> answers = new HashMap<String, String>();
	private static int score = 0;
	private static String playerName;

	private static void initializeHashMap() {
		// inserting values
		statesAndCapitals.put("Andhra Pradesh", "Hyderabad");
		statesAndCapitals.put("Arunachal Pradesh", "Itanagar");
		statesAndCapitals.put("Assam", "Dispur");
		statesAndCapitals.put("Bihar", "Patna");
		statesAndCapitals.put("Chhattisgarh", "Raipur");
		statesAndCapitals.put("Goa", "Panaji");
		statesAndCapitals.put("Gujarat", "Gandhinagar");
		statesAndCapitals.put("Haryana", "Chandigarh");
		statesAndCapitals.put("Himachal Pradesh", "Shimla");
		statesAndCapitals.put("Jammu and Kashmir", "Srinagar");
		statesAndCapitals.put("Jharkhand", "Ranchi");
		statesAndCapitals.put("Karnataka", "Bengaluru");
		statesAndCapitals.put("Kerala", "Thiruvananthapuram");
		statesAndCapitals.put("Madhya Pradesh", "Bhopal");
		statesAndCapitals.put("Maharashtra", "Mumbai");
		statesAndCapitals.put("Manipur", "Imphal");
		statesAndCapitals.put("Meghalaya", "Shillong");
		statesAndCapitals.put("Mizoram", "Aizawl");
		statesAndCapitals.put("Nagaland", "Kohima");
		statesAndCapitals.put("Orissa", "Bhubaneswar");
		statesAndCapitals.put("Punjab", "Chandigarh");
		statesAndCapitals.put("Rajasthan", "Jaipur");
		statesAndCapitals.put("Sikkim", "Gangtok");
		statesAndCapitals.put("Tamil Nadu", "Chennai");
		statesAndCapitals.put("Telangana", "Hyderabad");
		statesAndCapitals.put("Tripura", "Agartala");
		statesAndCapitals.put("Uttar Pradesh", "Lucknow");
		statesAndCapitals.put("Uttarakhand", "Dehradun");
		statesAndCapitals.put("West Bengal", "Kolkata");

		indexAndStates.put(1, "Andhra Pradesh");
		indexAndStates.put(2, "Arunachal Pradesh");
		indexAndStates.put(3, "Assam");
		indexAndStates.put(4, "Bihar");
		indexAndStates.put(5, "Chhattisgarh");
		indexAndStates.put(6, "Goa");
		indexAndStates.put(7, "Gujarat");
		indexAndStates.put(8, "Haryana");
		indexAndStates.put(9, "Himachal Pradesh");
		indexAndStates.put(10, "Jammu and Kashmir");
		indexAndStates.put(11, "Jharkhand");
		indexAndStates.put(12, "Karnataka");
		indexAndStates.put(13, "Kerala");
		indexAndStates.put(14, "Madhya Pradesh");
		indexAndStates.put(15, "Maharashtra");
		indexAndStates.put(16, "Manipur");
		indexAndStates.put(17, "Meghalaya");
		indexAndStates.put(18, "Mizoram");
		indexAndStates.put(19, "Nagaland");
		indexAndStates.put(20, "Orissa");
		indexAndStates.put(21, "Punjab");
		indexAndStates.put(22, "Rajasthan");
		indexAndStates.put(23, "Sikkim");
		indexAndStates.put(24, "Tamil Nadu");
		indexAndStates.put(25, "Telangana");
		indexAndStates.put(26, "Tripura");
		indexAndStates.put(27, "Uttar Pradesh");
		indexAndStates.put(28, "Uttarakhand");
		indexAndStates.put(29, "West Bengal");
	}

	public static void mainMenu() {
		initializeHashMap();
		try {
			char choice = 'n';
			int menuChoice;

			// getting user name
			System.out.print("Please enter your name: ");
			playerName = scanner.nextLine();
			System.out.println("\nWelcome, " + playerName + "!");

			do {
				System.out.print("1. Start Quiz\n2. Display Report\n3. Exit\nChoose an option: ");
				menuChoice = Integer.parseInt(scanner.nextLine());

				// menu processing
				processMenuSelection(menuChoice);

				System.out.print("Do you want to continue(Y/N): ");
				choice = scanner1.next().charAt(0);

			} while ((choice == 'y') || (choice == 'Y'));

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

	}

	private static void processMenuSelection(int menuChoice) {
		switch (menuChoice) {
		case 1:
			startQuiz();
			break;
		case 2:
			displayReport();
			break;
		case 3:
			System.out.println("Thank you. Exiting...");
			System.exit(0);
		default:
			System.out.println("Invalid selection. Exiting...");
		}
	}

	private static void startQuiz() {

		try {
			Random random = new Random();
			String playerAnswer;
			System.out.println("\nStarting your quiz...\n");
			for (int i = 1; i <= 5; i++) {
				String state;
				String capital;
				Integer temp = (random.nextInt(1, 29));
				
				if (indexAndStates.containsKey(temp)) {
					state = indexAndStates.get(temp);
					if (statesAndCapitals.containsKey(state)) {
						System.out.print("Q"+ i + ": What is the capital of " + state + "?");
						playerAnswer = scanner.nextLine();
						capital = statesAndCapitals.get(state);
						quiz.put(state, capital);
						answers.put(state, playerAnswer);
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

	}

	private static void displayReport() {
		
		String state;
		String capital;
		int number = 1;
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%45s", playerName + "'s Report"));
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-10s%-45s%-18s%-18s%-9s", "Q.No", "Question", "Correct Answer", "Your Answer", "Points"));
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		
		int point = 0;
		for(Map.Entry m : quiz.entrySet()) {
			for(Map.Entry n : answers.entrySet()) {
				if(m.getKey().equals(n.getKey())) {
					if(m.getValue().equals(n.getValue())) {
						point++;
						score++;
						System.out.println(String.format("%-10s%-45s%-18s%-18s%-9s", number++, "What is the capital of "+n.getKey()+"?", m.getValue(), n.getValue(), point));
						point = 0;
					}else {
						System.out.println(String.format("%-10s%-45s%-18s%-18s%-9s", number++, "What is the capital of "+n.getKey()+"?", m.getValue(), n.getValue(), point));
						point = 0;
					}
				}
			}
		}
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%45s", "Total Score: "+score));
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		if(score == 5)
			System.out.println(playerName + "! You are extra brilliant");
		else if(score == 0)
			System.out.println(playerName + "! Try again");
		else
			System.out.println(playerName + "! Good effort");
			
	}

}
