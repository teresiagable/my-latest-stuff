package gable.helper;

import java.util.Scanner;

public class ContinueOrNot {
	private static Scanner scanner = new Scanner(System.in);

	public static boolean continueOrNot(String question) {
		System.out.println(question);	
		String input = scanner.nextLine();
		boolean returnValue = true;
		switch (input) {
		case "Y":
		case "y":
			returnValue = true;
			break;
		case "N":
		case "n":
			returnValue = false;
			break;
		default:
			System.out.println("I'll take that as a YES");
			returnValue = true;
			break;
		}
		return returnValue;
	}

	public static boolean continueOrNot()
	{
		return continueOrNot("Continue (Y/N) ?");
	}
	
}

