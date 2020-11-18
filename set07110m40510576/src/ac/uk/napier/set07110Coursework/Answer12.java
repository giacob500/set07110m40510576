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
		
		ArrayList<WeatherStation> weatherStations = new ArrayList<>();
		int count = 0;
		int oldCount = 0;
		boolean countConsecutive = false;
		WeatherStation weatherStation = null;
		WeatherStation founded = null;
		
		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			if(weatherStations.isEmpty()) {
				weatherStation = new WeatherStation(Double.parseDouble(data[2]), Double.parseDouble(data[3]));
				weatherStations.add(weatherStation);
			} else if (weatherStations.get(weatherStations.size() - 1).getSiteId() != Integer.parseInt(data[0])) {
				weatherStation = new WeatherStation(Double.parseDouble(data[2]), Double.parseDouble(data[3]));
				weatherStations.add(weatherStation);
			}
		}
		
		for (WeatherStation wr : weatherStations) {		
			for (int reading : wr.getWeatherReadingsWindSpeed()) {
				if (reading > 50 && countConsecutive == false) {
					count++;
					countConsecutive = true;
				} else if (reading > 50 && countConsecutive == true) {
					
					count++;
					if (count > oldCount) {
						oldCount = count;
						founded = wr;
					}
				} else {
					count = 0;
					countConsecutive = false;
				}
			}				
		}		
		
		System.out.println(founded.getSiteName() + " susteined a wind speed of greater than 50 Km/h for " + oldCount + " consecutive readings");
		MapGui.showMap(founded);
		
		/*
		ArrayList<String[]> weatherDataList = new ArrayList<>();
		int count = 0;
		int oldCount = 0;
		boolean countConsecutive = false;
		String locationName = null;
		WeatherStation weatherStation = null;
		
		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			weatherDataList.add(data);
		}

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
		//MapGui.showMap(weatherStation);
		
		*/
	} 
}
