package com.tiy.listOfCountries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountryAppDisplay {
	
	CountryApp toMenu = new CountryApp();
	
	public void displayListOfCountries(){
		
		System.out.println("Your list of countries:");
		
		ArrayList<String> listOfCountries = new ArrayList<>();
		
		Path myNewPath =  Paths.get("\\Users\\admin\\newWorkspace\\DayElevenAssignment\\src\\com\\tiy\\listOfCountries\\countryList");
		
		File aNewFile =  myNewPath.toFile();
		
		try(BufferedReader in = new BufferedReader(new FileReader(aNewFile))){
			
			String countriesList;
			
			while((countriesList = in.readLine()) != null){
				
				listOfCountries.add(countriesList);
				
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		for (int i = 0; i < listOfCountries.size(); i++){
			System.out.println(listOfCountries.get(i));
		}
		
	}
	
	

}
