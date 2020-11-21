package ac.uk.napier.set07110Coursework.PersonalClasses;

/**
 * @author Giacomo Lorenzi 40510576
 *
 */
/**
 * @author Giacomo
 *
 */
public class WeatherReading {

	private int year;
	private int month;
	private int date;
	private int hour;
	private int windSpeed;
	private double temperature;

	/**
	 * @param year  the year parameter
	 * @param month  the month parameter
	 * @param date  the date parameter
	 * @param hour  the hour parameter
	 * @param windSpeed  the wind speed parameter
	 * @param temperature  the temperature parameter
	 */
	public WeatherReading(int year, int month, int date, int hour, int windSpeed, double temperature) {
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.windSpeed = windSpeed;
		this.temperature = temperature;
	}

	/**
	 * Gets the year.
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Gets the month.
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Gets the date.
	 * @return the date
	 */
	public int getDate() {
		return date;
	}
	
	/**
	 * Gets the wind speed.
	 * @return the windSpeed
	 */
	public int getWindSpeed() {
		return windSpeed;
	}

	/**
	 * Gets the temperature.
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	@Override
	public String toString() {
		return "WeatherReading [year=" + year + ", month=" + month + ", date=" + date + ", hour=" + hour
				+ ", windSpeed=" + windSpeed + ", temperature=" + temperature + "]";
	}
}
