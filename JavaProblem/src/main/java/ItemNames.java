/**
 *  @author Priyadarshini Krishna
 *  The below class is an enum class to hold all the Item names.
 *  This class can be used as a centralized location to hold all the names. Makes it more maintainable for future changes.
 */

public enum ItemNames {
	
	THERMAL_VEST("Thermal Vest"),
	
	AGED_BRIE("Aged Brie"),
	
	CHICKEN("Chicken"),
	
	SULFURAS("SULFURAS"),
	
	BACKSTAGE_PASSES("Backstage Passes"),
	
	GINGER_CAKE("Ginger Cake"),
	
	ORGANIC_BANANA("Organic Banana");
	
	private final String value;	
	
	ItemNames(String v) {
		value = v;
	 }

	public String getItenName() {
		return value;
	}
	
	public static ItemNames fromValue(String v) {
        for (ItemNames itemName : ItemNames.values()) {
            if (itemName.value.equals(itemName)) {
                return itemName;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
