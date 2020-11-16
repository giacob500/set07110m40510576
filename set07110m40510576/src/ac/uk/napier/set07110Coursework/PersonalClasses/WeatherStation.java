package ac.uk.napier.set07110Coursework.PersonalClasses;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import weather.WeatherData;

public class WeatherStation extends Coordinate {

	private int siteId;
	private String siteName;
	private ArrayList<WeatherReading> weatherReadings = new ArrayList<>();
	
	public WeatherStation(double lat, double lon) {
		super(lat, lon);		
		String[] weatherData = WeatherData.getData();
		for (int i = 1; i < weatherData.length; i++) {
			String[] data = weatherData[i].split(",");
			if (data[2].equals(String.valueOf(lat)) && data[3].equals(String.valueOf(lon))) {
				siteId = Integer.parseInt(data[0]);
				siteName = data[1];
				WeatherReading weatherReading = new WeatherReading(Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8]), Double.parseDouble(data[9]));
				weatherReadings.add(weatherReading);
			}
		}
	}

	public int getSiteId() {
		return siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public ArrayList<WeatherReading> getWeatherReadings() {
		return weatherReadings;
	}
	
	public  ArrayList<Integer> getWeatherReadingsWindSpeed(){
		ArrayList<Integer> windSpeed = new ArrayList<>();
		for (WeatherReading i : weatherReadings) {
			windSpeed.add(i.getWindSpeed());
		}
		return windSpeed;
	}
	
	public  ArrayList<Double> getWeatherReadingsTemperatureInMarch(){
		ArrayList<Double> temperature = new ArrayList<>();
		for (WeatherReading i : weatherReadings) {
			if (i.getMonth() == 3) {
				temperature.add(i.getTemperature());
			}
		}
		return temperature;
	}

	@Override
	public String toString() {
		return "WeatherStation [siteId=" + siteId + ", siteName=" + siteName + ", latitude=" + getLat() + ", longitude="
				+ getLon() + ", weatherReadings=" + weatherReadings.size() + "]";
	}
	
	
}
