package com.tiy.listOfCountries;

public class Validation {

	public static boolean tryCatch(String menuOption) {

		if (menuOption.equals("1") || menuOption.equals("2") || menuOption.equals("3") || menuOption.equals("4"))

			try {
				int rightOrWrong = Integer.parseInt(menuOption);

				return false;

			} catch (ArrayIndexOutOfBoundsException e) { // can change Array...
															// just Exception to
				return true; // catch any
								// possible thrown.
//				System.out.println("You made an error!");
			}
		
		return false;
	}

}
