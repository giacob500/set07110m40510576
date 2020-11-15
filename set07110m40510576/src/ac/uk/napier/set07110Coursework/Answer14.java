package ac.uk.napier.set07110Coursework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import ac.uk.napier.set07110Coursework.PersonalClasses.Postcode;
import gui.MapGui;
import weather.WeatherData;

/**
 * QUESTION 14
 * 
 * If you decide to answer question 14 then the main method below should be used
 * as the entry point for your application You may use as many other classes as
 * you feel necessary as long as all code is supplied
 * 
 * Remember to add -Xmx1024m to the VM arguments using menu run --> run
 * configurations in eclipse
 */
public class Answer14 {
	public static void main(String[] args) {
		System.out.println("Question 14");
		/*
		 * Add your code below
		 */
		
		Postcode finalPostcode = null;
		double distance1 = 0;
		double distance2 = 0;
		Postcode postcode = null;
		ArrayList<Postcode> postcodes = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/fy.csv")));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				postcode = new Postcode(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
				postcodes.add(postcode);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		//fin qui funziona		
		
		
		for (Postcode j : postcodes) {
			distance1 = 1000000;
			for (Postcode n : postcodes) {
				if (j != n) {
					if (WeatherData.getDistanceBetweenPoints(j.getLat(), j.getLon(), n.getLat(), n.getLon()) < distance1) {
						distance1 = WeatherData.getDistanceBetweenPoints(j.getLat(), j.getLon(), n.getLat(), n.getLon());
					}
				}
			}
			if (distance1 > distance2) {
				distance2 = distance1;
				finalPostcode = j;
			}
		}
		
		System.out.println(distance2 + " " + finalPostcode);
		MapGui.showMap(finalPostcode);
		/*
		for (String i : postcodesRow) {
			String[] data = i.split(",");
			postcode = new Postcode(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
			postcodes.add(postcode);
		}
		//fin qui funziona
		/*
		double distancePointToPoint = 0;
//		Coordinate c1 = null;
//		Coordinate c2 = null;
		double porcodio = 0;
		for (int j = 0; j < postcodes.size(); j++) {
			for (int g = 0; g < postcodes.size(); g++) {
				//System.out.println(!(postcodes.get(j).getCode()).equals(postcodes.get(g).getCode()));
				//break;
				if (j == 0 && g == 0) {
					distancePointToPoint = Math.abs(WeatherData.getDistanceBetweenPoints(postcodes.get(j).getLat(), postcodes.get(j).getLon(), postcodes.get(g + 1).getLat(), postcodes.get(g + 1).getLon()));
					postcodename = postcodes.get(j).getCode();
					porcodio = distancePointToPoint;
//					c1 = new Coordinate(postcodes.get(j).getLat(), postcodes.get(j).getLon());
//					c1 = new Coordinate(postcodes.get(g).getLat(), postcodes.get(g).getLon());
//					System.out.println(distancePointToPoint);
				} else if (!(postcodes.get(j).getCode()).equals(postcodes.get(g).getCode())) {
					//System.out.println(WeatherData.getDistanceBetweenPoints(postcodes);	
					
					if (Math.abs(WeatherData.getDistanceBetweenPoints(postcodes.get(j).getLat(), postcodes.get(j).getLon(), postcodes.get(g).getLat(), postcodes.get(g).getLon())) < distancePointToPoint) {
						distancePointToPoint = Math.abs(WeatherData.getDistanceBetweenPoints(postcodes.get(j).getLat(), postcodes.get(j).getLon(), postcodes.get(g).getLat(), postcodes.get(g).getLon()));
						//postcodename = postcodes.get(j).getCode() + ","  + postcodes.get(g).getCode();
						//System.out.println("PORCODIOAKUNAMATATA");
						//System.out.println(postcodename + " " + distancePointToPoint);
					}
				}
			}
			System.out.println(distancePointToPoint + " " + distance);
			if (distancePointToPoint > distance) {		
				distance = distancePointToPoint;
				postcodename = postcodes.get(j).getCode();
			}
		}
		
		Coordinate ciao = null;
		Coordinate ciao1 = null;
//		String[] diocane = postcodename.split(",");
		for (Postcode o : postcodes) {
			//System.out.println(o.getCode() + " " + diocane[0] + " " + diocane[1]);
			if (o.getCode().equals(postcodename)) {
				//System.out.println("PORCAMADONNA");
				ciao = new Coordinate(o.getLat(), o.getLon());
//			} else if (o.getCode().equals(diocane[1])) {
//				ciao1 = new Coordinate(o.getLat(), o.getLon());
				//System.out.println("PORCODDIO");
			}
		}
		
		System.out.println(postcodename + " " + distance + " " + ciao + " " + ciao1 + " " + porcodio);
		
		ArrayList<Coordinate> coordinates = new ArrayList<>();
		coordinates.add(ciao);
		coordinates.add(ciao1);
		MapGui.showMap(ciao);
		
		
		
		/*
		 * ---------------------------
		 * 
		
		orderList(postcodes);
		
		for (int c = 0; c < postcodes.size()-1; c++) {
			if(WeatherData.getDistanceBetweenPoints(postcodes.get(c).getLat(), postcodes.get(c).getLon(), postcodes.get(c + 1).getLat(), postcodes.get(c + 1).getLon()) > distance) {
				distance = WeatherData.getDistanceBetweenPoints(postcodes.get(c).getLat(), postcodes.get(c).getLon(), postcodes.get(c + 1).getLat(), postcodes.get(c + 1).getLon());
				postcodename = postcodes.get(c).getCode();
			}
		}
		System.out.println(postcodename + " " + distance);
		*/
		
	}
	
	/*
	public static ArrayList<Postcode> orderList(ArrayList<Postcode> postcodes){
		ArrayList<Double> lats = new ArrayList<>();
		ArrayList<Double> lons = new ArrayList<>();
		for (Postcode e : postcodes) {
			lats.add(e.getLat());
			lons.add(e.getLon());
		}
		Collections.sort(lats);
		Collections.sort(lons);
		return postcodes;
	} */
}
