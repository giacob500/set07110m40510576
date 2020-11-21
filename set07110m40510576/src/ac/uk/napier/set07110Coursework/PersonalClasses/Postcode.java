package ac.uk.napier.set07110Coursework.PersonalClasses;
import org.openstreetmap.gui.jmapviewer.Coordinate;

/**
 * @author Giacomo Lorenzi 40510576
 *
 */
public class Postcode extends Coordinate {

	private String code;

	/**
	 * Parameterised constructor
	 * 
	 * @param code  postcode id
	 * @param lat  latitude
	 * @param lon  longitude
	 */
	public Postcode(String code, double lat, double lon) {
		super(lat, lon);
		this.code = code;
	}

	/**
	 * Returns the postcode id (named as code)
	 * 
	 * @return code the postcode id
	 */
	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "Postcode [code=" + code + " latitude=" +  getLat() + " longitude=" +  getLon() + "]";
	}

}
