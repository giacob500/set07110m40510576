package ac.uk.napier.set07110Coursework.PersonalClasses;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import weather.WeatherData;

/**
 * @author Giacomo Lorenzi 40510576
 *
 */
public class WeatherStation extends Coordinate {

	private int siteId;
	private String siteName;
	private ArrayList<WeatherReading> weatherReadings = new ArrayList<>();
	
	/**
	 * @param lat  the latitude parameter
	 * @param lon  the longitude parameter
	 */
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

	/**
	 * Gets the site id.
	 * @return the siteId
	 */
	public int getSiteId() {
		return siteId;
	}

	/**
	 * Gets the site name.
	 * @return the SiteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * Gets all the weather readings.
	 * @return the weatherReadings
	 */
	public ArrayList<WeatherReading> getWeatherReadings() {
		return weatherReadings;
	}
	
	/**
	 * Gets all the wind speeds observed from the weather readings.
	 * @return the windSpeed
	 */
	public  ArrayList<Integer> getWeatherReadingsWindSpeed(){
		ArrayList<Integer> windSpeed = new ArrayList<>();
		for (WeatherReading i : weatherReadings) {
			windSpeed.add(i.getWindSpeed());
		}
		return windSpeed;
	}
	
	/**
	 * Gets all the temperatures observed from the weather readings in march.
	 * @return the windSpeed
	 */
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
