package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;
import ac.uk.napier.set07110Coursework.PersonalClasses.WeatherStation;
import gui.MapGui;
import weather.WeatherData;

/**
 * QUESTION 12
 * 
 * If you decide to answer question 12 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer12 {
	public static void main(String[] args) {
		System.out.println("Question 12");
		/*
		 * Add your code below
		 */

		int count = 0;
		int oldCount = 0;
		boolean consecutiveRead = false;
		WeatherStation weatherStation = null;
		WeatherStation finalWeatherStation = null;
		ArrayList<WeatherStation> weatherStations = new ArrayList<>();

		// Get the data and split them in arrays
		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			// If no weather station has been found yet, create one and insert it in the
			// list
			if (weatherStations.isEmpty()) {
				weatherStation = new WeatherStation(Double.parseDouble(data[2]), Double.parseDouble(data[3]));
				weatherStations.add(weatherStation);
				// If the weather station isn't already in the list, create it and add it
			} else if (weatherStations.get(weatherStations.size() - 1).getSiteId() != Integer.parseInt(data[0])) {
				weatherStation = new WeatherStation(Double.parseDouble(data[2]), Double.parseDouble(data[3]));
				weatherStations.add(weatherStation);
			}
		}

		// For each wind speed reading of each weather station
		for (WeatherStation wr : weatherStations) {
			for (int reading : wr.getWeatherReadingsWindSpeed()) {
				// Count how many consecutive wind speed reading greater than 50 km/h does the
				// weather station have
				if (reading > 50 && consecutiveRead == false) {
					count++;
					consecutiveRead = true;
				} else if (reading > 50 && consecutiveRead == true) {
					count++;
					// If the number of consecutive readings is higher than the one from the
					// previous weather station, set it as the new record
					if (count > oldCount) {
						oldCount = count;
						finalWeatherStation = wr;
					}
				} else {
					count = 0;
					consecutiveRead = false;
				}
			}
		}

		System.out.println(finalWeatherStation.getSiteName() + " susteined a wind speed of greater than 50 Km/h for "
				+ oldCount + " consecutive readings.");
		MapGui.showMap(finalWeatherStation);
	}
}
