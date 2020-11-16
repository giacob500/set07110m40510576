package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import ac.uk.napier.set07110Coursework.PersonalClasses.Postcode;
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
		
		double loss = 0;
		int lossCount = 0;
		double edgo = 0;
		int edgoCount = 0;
		WeatherStation edgoOnMap = null;
		WeatherStation lossOnMap = null;
		ArrayList<Coordinate> coordinates = new ArrayList<>();

		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			if (Integer.parseInt(data[5]) == 3) {
				if (data[1].equals("EDINBURGH/GOGARBANK (3166)") && edgoOnMap == null) {
					edgoOnMap = new WeatherStation(Double.parseDouble(data[2]), Double.parseDouble(data[3]));
				} else if (data[1].equals("LOSSIEMOUTH (3068)") && lossOnMap == null) {
					lossOnMap = new WeatherStation(Double.parseDouble(data[2]), Double.parseDouble(data[3]));
				}
			}
		}
		
		for (double d : edgoOnMap.getWeatherReadingsTemperatureInMarch()) {
			edgo += d;
		}
		edgoCount = edgoOnMap.getWeatherReadingsTemperatureInMarch().size();
		for (double p : lossOnMap.getWeatherReadingsTemperatureInMarch()) {
			loss += p;
		}
		lossCount = lossOnMap.getWeatherReadingsTemperatureInMarch().size();
		
		coordinates.add(edgoOnMap);
		coordinates.add(lossOnMap);
		System.out.println(
				"The difference in mean temperature during March between LOSSIEMOUTH (3068) and EDINBURGH/GOGARBANK (3166) is "
						+ Math.abs((loss / lossCount) - (edgo / edgoCount)));
		MapGui.showMap(coordinates);
		/*
		double loss = 0;
		int lossCount = 0;
		double edgo = 0;
		int edgoCount = 0;

		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			if (Integer.parseInt(data[5]) == 3) {
				if (data[1].equals("EDINBURGH/GOGARBANK (3166)")) {
					edgo += Double.parseDouble(data[data.length - 1]);
					edgoCount++;
				} else if (data[1].equals("LOSSIEMOUTH (3068)")) {
					loss += Double.parseDouble(data[data.length - 1]);
					lossCount++;
				}
			}
		}
		System.out.println(
				"The difference in mean temperature during March between LOSSIEMOUTH (3068) and EDINBURGH/GOGARBANK (3166) is "
						+ Math.abs((loss / lossCount) - (edgo / edgoCount)));*/
	}
	
}
