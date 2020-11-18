package ac.uk.napier.set07110Coursework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import ac.uk.napier.set07110Coursework.PersonalClasses.Postcode;
import gui.MapGui;
import weather.WeatherData;

/**
 * QUESTION 15
 * 
 * If you decide to answer question 15 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer15 {
	public static void main(String[] args) {
		System.out.println("Question 15");
		/*
		 * Add your code below
		 */
		
		int postcodesCount = 0;
		int highestPostcodesCount = 0;
		Postcode postcode;
		Postcode finalPostcode = null;
		ArrayList<Postcode> postcodes = new ArrayList<>();
		ArrayList<Coordinate> postcodesOnMap = new ArrayList<>();

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

		for (Postcode p : postcodes) {
			for (Postcode e : postcodes) {
				if (p != e) {
					if (WeatherData.getDistanceBetweenPoints(p.getLat(), p.getLon(), e.getLat(), e.getLon()) <= 0.2) {
						postcodesCount++;						
					}
				}
				
			}
			if (postcodesCount > highestPostcodesCount) {
				highestPostcodesCount = postcodesCount;
				finalPostcode = p;
			}
			postcodesCount = 0;
		}
		
		System.out.println("The most densely populated FY postcode is " + finalPostcode.getCode() + " with " + highestPostcodesCount + " inhabitants");
		postcodesOnMap.add(finalPostcode);
		MapGui.showMap(postcodesOnMap);
	}
}
