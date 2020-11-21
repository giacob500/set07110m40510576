package ac.uk.napier.set07110Coursework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import ac.uk.napier.set07110Coursework.PersonalClasses.Postcode;
import ac.uk.napier.set07110Coursework.PersonalClasses.WeatherStation;
import gui.MapGui;
import weather.WeatherData;

/**
 * QUESTION 11
 * 
 * If you decide to answer question 11 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer11 {
	public static void main(String[] args) {
		System.out.println("Question 11");
		/*
		 * Add your code below
		 */

		int count = 0;
		WeatherStation weatherStation = null;
		Postcode postcode = null;
		ArrayList<Coordinate> coordinates = new ArrayList<>();

		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			if (data[1].equals("INVERBERVIE (3088)")) {
				weatherStation = new WeatherStation(Double.parseDouble(data[2]), Double.parseDouble(data[3]));
				break;
			}
		}
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/postcodes.csv")));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if (WeatherData.getDistanceBetweenPoints(weatherStation.getLat(), weatherStation.getLon(),
						Double.parseDouble(data[1]), Double.parseDouble(data[2])) <= 5) {
					count++;
					postcode = new Postcode(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
					coordinates.add(postcode);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		System.out.println("There are " + count + " Post Codes");

		//use the method ShowMap which takes the list of coordinates as a parameter and shows them on a map
		MapGui.showMap(coordinates);
	}
}
