package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import ac.uk.napier.set07110Coursework.PersonalClasses.WeatherStation;
import gui.MapGui;
import weather.WeatherData;

/**
 * QUESTION 13
 * 
 * If you decide to answer question 13 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer13 {
	public static void main(String[] args) {
		System.out.println("Question 13");
		/*
		 * Add your code below
		 */

		double lossSum = 0;
		int lossCount = 0;
		double edGoSum = 0;
		int edGoCount = 0;
		WeatherStation edGo = null;
		WeatherStation loss = null;
		ArrayList<Coordinate> coordinates = new ArrayList<>();

		// Get the data and split them in arrays
		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			// When the correct data are found and if the object hasn't been created yet, create it
			if (data[1].equals("EDINBURGH/GOGARBANK (3166)") && edGo == null) {
				edGo = new WeatherStation(Double.parseDouble(data[2]), Double.parseDouble(data[3]));
			} else if (data[1].equals("LOSSIEMOUTH (3068)") && loss == null) {
				loss = new WeatherStation(Double.parseDouble(data[2]), Double.parseDouble(data[3]));
			}
		}

		// Get the temperature from the respective weather readings
		for (double d : edGo.getWeatherReadingsTemperatureInMarch()) {
			edGoSum += d;
		}
		edGoCount = edGo.getWeatherReadingsTemperatureInMarch().size();
		for (double p : loss.getWeatherReadingsTemperatureInMarch()) {
			lossSum += p;
		}
		lossCount = loss.getWeatherReadingsTemperatureInMarch().size();

		// Add the weather stations to the list to be tracked on map
		coordinates.add(edGo);
		coordinates.add(loss);
		System.out.println(
				"The difference in mean temperature during March between LOSSIEMOUTH (3068) and EDINBURGH/GOGARBANK (3166) is "
						+ Math.abs((lossSum / lossCount) - (edGoSum / edGoCount)) + "°C.");
		MapGui.showMap(coordinates);
	}
}
