package ac.uk.napier.set07110Coursework;

import ac.uk.napier.set07110Coursework.PersonalClasses.WeatherStation;
import weather.WeatherData;

/**
 * 
 * Example Question / Answer
 * 
 * Question 00
 * 
 * Print out the header data (index 0) and the 100th record (index 100) on
 * separate lines for the data returned from WeatherData.getData();
 * 
 * Split the 100th element which is a comma delimited string into its individual
 * fields and print each element
 *
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer00 {
	public static void main(String[] args) {
		System.out.println("Question 01");

		/*
		 * Add your code below
		 */

		// get the data
		String[] weatherData = WeatherData.getData();

		// print out header information (index 0)
		System.out.println(weatherData[0]);

		// print out record 100 (index 100)
		System.out.println(weatherData[1]);

		// split a line of data to its individual fields (these are still
		// strings and will need parsed to the correct data type specified in
		// the coursework document.
		String[] data = weatherData[100].split(",");

		// print each element of the array
		for (String element : data) {
			//System.out.println(element);
		}
		
		for (int i = 0; i<100; i++) {
			//System.out.println(weatherData[i]);
		}
		
		WeatherStation bo = new WeatherStation(56.88, -3.42);
		System.out.println(bo.getWeatherReadings().get(10));
		
		int a = 1;
		int b = 2;
		int c = 3;
		
		if (a == 1 && b == 1 || b == 2) {
			System.out.println(a);
		}
	}
}
