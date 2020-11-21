package ac.uk.napier.set07110Coursework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ac.uk.napier.set07110Coursework.PersonalClasses.Postcode;
import gui.MapGui;
import weather.WeatherData;

/**
 * QUESTION 14
 * 
 * If you decide to answer question 14 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer14 {
	public static void main(String[] args) {
		System.out.println("Question 14");
		/*
		 * Add your code below
		 */
		double closestDistance = 0;
		double farthestDistance = 0;
		Postcode postcode = null;
		Postcode finalPostcode = null;		
		ArrayList<Postcode> postcodes = new ArrayList<>();
		
		// Read the fy.csv file and split each line in a array, for each create a postcode object and add it to the list
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/fy.csv")));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				postcode = new Postcode(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
				postcodes.add(postcode);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}		
		
		// For each couple of postcodes check which ones are the closest 
		for (Postcode j : postcodes) {
			closestDistance = Double.MAX_VALUE;
			for (Postcode n : postcodes) {
				if (j != n) {
					if (WeatherData.getDistanceBetweenPoints(j.getLat(), j.getLon(), n.getLat(), n.getLon()) < closestDistance) {
						closestDistance = WeatherData.getDistanceBetweenPoints(j.getLat(), j.getLon(), n.getLat(), n.getLon());
					}
				}
			}
			// If the distance just found is higher than the previous distance between the two postcodes, then one of this is more isolated
			if (closestDistance > farthestDistance) {
				farthestDistance = closestDistance;
				finalPostcode = j;
			}
		}
		
		System.out.println("The most isolated FY postcode is " + finalPostcode.getCode() + ", latitude: " + finalPostcode.getLat() + " longitude: " + finalPostcode.getLon() + "\nwith a distance from the closest of " + farthestDistance + ".");
		MapGui.showMap(finalPostcode);
	}
}
