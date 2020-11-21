package ac.uk.napier.set07110Coursework.PersonalClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Postcode extends Coordinate {

	private String code;

	public Postcode(double lat, double lon) {
		super(lat, lon);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/postcodes.csv")));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if (Double.parseDouble(data[1]) == lat && Double.parseDouble(data[2]) == lon) {
					code = data[0];
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public Postcode(String code, double lat, double lon) {
		super(lat, lon);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "Postcode [code=" + code + " latitude=" +  getLat() + " longitude=" +  getLon() + "]";
	}

}
