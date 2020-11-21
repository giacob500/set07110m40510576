package ac.uk.napier.set07110Coursework.PersonalClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openstreetmap.gui.jmapviewer.Coordinate;

/**
 * @author Giacomo Lorenzi 40510576
 *
 */
public class Postcode extends Coordinate {

	private String code;

	/**
	 * @param code postcode id
	 * @param lat latitude
	 * @param lon longitude
	 */
	public Postcode(String code, double lat, double lon) {
		super(lat, lon);
		this.code = code;
	}

	/**
	 * Returns the postcode id (named as code)
	 * 
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "Postcode [code=" + code + " latitude=" +  getLat() + " longitude=" +  getLon() + "]";
	}

}
