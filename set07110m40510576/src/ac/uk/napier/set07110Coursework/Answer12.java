package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import ac.uk.napier.set07110Coursework.PersonalClasses.WeatherReading;
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
		
		/*
		String location = "";
		WeatherStation weatherStation = null;
		ArrayList<String> weatherStationReadings = new ArrayList<>();
		ArrayList<ArrayList> weatherStationsReadings = new ArrayList<>();
		
		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			System.out.println(data[0]);
			//System.out.println(location + " " + data[0]);
			while (data[0].equals(location) == true) {
				//System.out.print(j + " ");
				//System.out.println("");
				weatherStationReadings.add(data[8]);
			}
			weatherStationsReadings.add(weatherStationReadings);
			location = data[0];
		}
		System.out.println(weatherStationReadings);
		
		
		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++)
			System.out.println(weatherData[i]);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ArrayList<ArrayList> weatherStationsReadings = new ArrayList<>();
		ArrayList<Integer> weatherStationsNames = new ArrayList<>();
//		String alreadyFound = null;

		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			// System.out.println(data[0]);
			if (weatherStationsNames.isEmpty()
					|| weatherStationsNames.get(weatherStationsNames.size() - 1) != Integer.parseInt(data[0])) {
//					|| data[0] != alreadyFound) {
//				System.out.println(data[0]);
				WeatherStation weatherStation = new WeatherStation(Double.parseDouble(data[2]),
						Double.parseDouble(data[3]));
				
				weatherStationsNames.add(Integer.parseInt(data[0]));
				weatherStationsReadings.add(weatherStation.getWeatherReadingsWindSpeed());
//				alreadyFound = data[0];
			}
		}

		System.out.println(weatherStationsReadings);
		
//		-----------------------------------------
		/*
		
		String locationName = null;
		int oldCount = 0;
		int count = 0;
		boolean countConsecutive = false;
		Coordinate coordinates = null;

		for (WeatherStation ws : weatherStations) {
			for (WeatherReading wr : ws.getWeatherReadings()) {
				if (wr.getWindSpeed() > 50 && countConsecutive == false) {
					count++;
					countConsecutive = true;
				} else if (wr.getWindSpeed() > 50 && countConsecutive == true) {
					count++;
					if (count > oldCount) {
						oldCount = count;
						locationName = ws.getSiteName();
					}
				} else {
					count = 0;
					countConsecutive = false;
				}
			}
		}
		if (oldCount == 0) {
			System.out.println("No location sustained a wind speed of greater than 50 Km/h");
		}
		System.out.println(locationName + " sustained a wind speed of greater than 50 km/h with " + oldCount
				+ " consecutive readings.");

		// find and add the coordinates to the map
		for (WeatherStation j : weatherStations) {
			if (j.getSiteName().equals(locationName)) {
				coordinates = new Coordinate(j.getLat(), j.getLon());
			}
		}
//		MapGui.showMap(coordinates);
//		JOptionPane.showMessageDialog(null,
//				"Clicking on the map will save a screenshot using the current system time as the filename");
*/
	}
}
