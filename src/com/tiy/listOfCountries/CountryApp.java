package com.tiy.listOfCountries;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CountryApp {

	static Scanner keyboard = new Scanner(System.in);

	static String menuOption;

	static CountryAppDisplay cntryDisplay = new CountryAppDisplay();

	public static void main(String[] args){
		
		boolean repeatAgain = true;
		
		do{
			do{
				System.out.println("Main Menu:" + "\nPress 1 to DISPLAY the current countries list" 
						+ "\n\tPress 2 to ADD a country to the list" + 
						"\n\tPress 3 to REMOVE a country from the list" 
						+ "\n\t\t\tPress 4 to EXIT");
				
					menuOption = keyboard.next();
				
					Validation.tryCatch(menuOption);
				
			}while(Validation.tryCatch(menuOption));		
					
				switch(menuOption){
					case "1":
						cntryDisplay.displayListOfCountries(); 
						break;
					case "2":
						addToList();
						break;
					case "3":
						removeFromList();
						break;
					case "4":
						repeatAgain = false;
						System.out.println("Goodbye");
						break;
					default:
				}
		
		}while(repeatAgain);		
				
	}

	public static void controlMenu() {

	}

	public static void addToList() {

		String aNewCountry = null;

		Path myNewPath = Paths
				.get("\\Users\\admin\\newWorkspace\\DayElevenAssignment\\src\\com\\tiy\\listOfCountries\\countryList.txt");

		File aNewFile = myNewPath.toFile();

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(aNewFile, true)))) {

			System.out.println("Enter the country you want to add to the list:");

			aNewCountry = keyboard.nextLine();

			out.println(keyboard.nextLine());

			System.out.println(aNewCountry + " was just added to the your list.");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void removeFromList() {

		ArrayList<String> listOfCountries = new ArrayList<>();

		Path myNewPath = Paths
				.get("\\Users\\admin\\newWorkspace\\DayElevenAssignment\\src\\com\\tiy\\listOfCountries\\countryList.txt");

		File aNewFile = myNewPath.toFile();

		try (BufferedReader in = new BufferedReader(new FileReader(aNewFile))) {

			String countriesList;

			while ((countriesList = in.readLine()) != null) {

				listOfCountries.add(countriesList);

			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < listOfCountries.size(); i++) {
			System.out.println(listOfCountries.get(i));
		}

		System.out.println("Enter the line index starting at zero" + "\n\tof the country you wish to remove from the list:");

		int removeACountry = keyboard.nextInt();

		listOfCountries.remove(removeACountry);

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(aNewFile)))) {
			for (int i = 0; i < listOfCountries.size(); i++) {
				out.println(listOfCountries.get(i));
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
