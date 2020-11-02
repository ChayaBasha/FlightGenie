package domain.flights;

/**
 * enumeration of airlines with their codes as specified in the project specification 
 * @author johannablumenthal
 *
 */

public enum Airline {
	ALASKA_AIRLINES("AS"),
	ALOHA_AIR("AQ"),
	AMERICA_WEST_AIRLINES("HP"),
	AMERICAN_AIRLINES("AA"),
	AIR_ONE("AP"),
	CONTINENTAL_AIRLINES("CO"),
	DELTA_AIRLINES("DL"),
	HAWAIIAN_AIRLINES("HA"),
	MIDWEST_EXPRESS("YX"),
	NORTHWEST_AIRLINES("NW"),
	SOUTHWEST_AIRLINES("WN"),
	TOWER_AIR("FF"),
	TRANS_WORLD_AIRLINES("TW"),
	UNITED_AIRLINES("UA"),
	US_AIRWAYS("US"),
	AIRTRANN("FL");
	
	
	private String airlineCode;
	
	private Airline(String airlineCode) {
		this.airlineCode = airlineCode;

    }
	
	/**
	 * method to get the codes based on airline 
	 * @return the two letter code
	 */
	public String getAirlineCode() {
		return airlineCode;
	}
}
