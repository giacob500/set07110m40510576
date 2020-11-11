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
			// We use a Buffered Reader to read the file line by line
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/postcodes.csv")));

			String line;
			// continue reading until null is returned when the end of the file has been
			// reached
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");				
				if (data[1].equals(lat) && data[1].equals(lon)) {
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

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "Postcode [code=" + code + "]";
	}
}
