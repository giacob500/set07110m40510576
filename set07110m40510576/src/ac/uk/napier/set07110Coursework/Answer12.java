package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;
import java.util.Collections;

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
		
		//WeatherStation ws = null;
		ArrayList<WeatherStation> weatherStations = new ArrayList<>();
		ArrayList<String[]> weatherDataList = new ArrayList<>();
		int windSpeedCount = 0;
		int consecutiveReadings = 0;
		String wsId = null;
		int count = 0;
		int oldCount = 0;
		boolean countConsecutive = false;
		String locationName = null;
		WeatherStation weatherStation = null;;
		
		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			weatherDataList.add(data);
		}
		
		System.out.println(weatherDataList.get(0)[0] + " " + (int)Double.parseDouble(weatherDataList.get(0)[8]));
		
		for (String[] wr : weatherDataList) {
			
				if (Integer.parseInt(wr[8]) > 50 && countConsecutive == false) {
					count++;
					countConsecutive = true;
				} else if (Integer.parseInt(wr[8]) > 50 && countConsecutive == true) {
					
					count++;
					if (count > oldCount) {
						oldCount = count;
						locationName = wr[1];
						weatherStation = new WeatherStation(Double.parseDouble(wr[2]), Double.parseDouble(wr[3]));
					}
				} else {
					count = 0;
					countConsecutive = false;
				}
		}		
		
		System.out.println(oldCount + " " + weatherStation.toString());
		
		MapGui.showMap(weatherStation);
		
		/*
		for (String[] o : weatherDataList) {			
			if (Integer.parseInt(o[8]) > 50) {
				while (o[0] != null && o[0].equals(wsId)) {
					windSpeedCount++;
				}
				if (!(o[0].equals(wsId))) {
					windSpeedCount = 0;
				}
			}
			if (windSpeedCount > consecutiveReadings) {
				consecutiveReadings = windSpeedCount;
				ws = new WeatherStation(Double.parseDouble(o[2]), Double.parseDouble(o[3]));
				wsList.add(ws);
			}
			wsId = o[0];			
		}
		
		System.out.println(wsList + " " + consecutiveReadings);
		
		------------------
		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			
			if (Integer.parseInt(data[8]) > 50) {
				if (data[0] != null && data[0].equals(wsId)) {					
					windSpeedCount++;
				}				
			}
			if (windSpeedCount > consecutiveReadings) {
				consecutiveReadings = windSpeedCount;
				ws = new WeatherStation(Double.parseDouble(data[2]), Double.parseDouble(data[3]));
				wsList.add(ws);
			}
			wsId = data[0];
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++)
			System.out.println(weatherData[i]);		
		
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
		*/
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
