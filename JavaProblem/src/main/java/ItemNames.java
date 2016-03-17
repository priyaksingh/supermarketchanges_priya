// TODO: Auto-generated Javadoc
/**
 * The Enum ItemNames.
 *
 * @author Priyadarshini Krishna
 *  The below class is an enum class to hold all the Item names.
 *  This class can be used as a centralized location to hold all the names. Makes it more maintainable for future changes.
 */

public enum ItemNames {
	
	/** The thermal vest. */
	THERMAL_VEST("Thermal Vest"),
	
	/** The aged brie. */
	AGED_BRIE("Aged Brie"),
	
	/** The chicken. */
	CHICKEN("Chicken"),
	
	/** The sulfuras. */
	SULFURAS("SULFURAS"),
	
	/** The backstage passes. */
	BACKSTAGE_PASSES("Backstage Passes"),
	
	/** The ginger cake. */
	GINGER_CAKE("Ginger Cake"),
	
	/** The organic banana. */
	ORGANIC_BANANA("Organic Banana");
	
	/** The value. */
	private final String value;	
	
	/**
	 * Instantiates a new item names.
	 *
	 * @param v the v
	 */
	ItemNames(String v) {
		value = v;
	 }

	/**
	 * Gets the iten name.
	 *
	 * @return the iten name
	 */
	public String getItenName() {
		return value;
	}
	
	/**
	 * From value.
	 *
	 * @param v the v
	 * @return the item names
	 */
	public static ItemNames fromValue(String v) {
        for (ItemNames itemName : ItemNames.values()) {
            if (itemName.value.equals(itemName)) {
                return itemName;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
