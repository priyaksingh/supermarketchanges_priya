import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperMarketPlusPlus.
 */
public class SuperMarketPlusPlus {

	/** The items. */
	private static List<Item> items = new ArrayList<Item>();
	
	public static void main(String[] args){
		System.out.println("Starting Supermarket Plus Plus");
		items = new ArrayList<Item>();
		items.add(new Item(ItemNames.THERMAL_VEST.getItenName(), 10, 20));
		items.add(new Item(ItemNames.AGED_BRIE.getItenName(), 2, 0));
		items.add(new Item(ItemNames.CHICKEN.getItenName(), 5, 7));
		items.add(new Item(ItemNames.SULFURAS.getItenName(), 0, 80));
		items.add(new Item(ItemNames.BACKSTAGE_PASSES.getItenName(), 15, 20));
		items.add(new Item(ItemNames.GINGER_CAKE.getItenName(), 3, 6));
		/**
		 * START - Changes by Priya. Added new Item Organic Banana.
		 */
		items.add(new Item(ItemNames.ORGANIC_BANANA.getItenName(), 5, 10));
		/**
		 * END - Changes by Priya. Added new Item Organic Banana.
		 */

		updateQuality();
		
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the new items
	 */
	public static void setItems(List<Item> inputItems) {
		items = inputItems;
	}

	/**
	 * Update quality.
	 */
	public static void updateQuality() {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName() != null && !items.get(i).getName().isEmpty()) {
				if (isQualityDegradationRequired(items.get(i))) {
					degradeQuality(items.get(i));
				} else {
					upgradeQuality(items.get(i));
				}
				decrementSellIn(items.get(i));
				updateQualityBasedOnSellin(items.get(i));
			}
		}
	}

	/**
	 * Degrade quality.
	 *
	 * @param item the item
	 * @return the int
	 */
	private static void degradeQuality(Item item) {
		if (!ItemNames.SULFURAS.getItenName().equals(item.getName())
				&& !ItemNames.ORGANIC_BANANA.getItenName().equals(item.getName())) {
			item.setQuality(item.getQuality() - 1);
		} else if (ItemNames.ORGANIC_BANANA.getItenName().equals(item.getName())) {
			item.setQuality(item.getQuality() - 2);
		}
	}

	/**
	 * Checks if is quality degradation required.
	 *
	 * @param item the item
	 * @return true, if is quality degradation required
	 */
	private static boolean isQualityDegradationRequired(Item item) {
		boolean isDegradeQuality = false;
		if ((!ItemNames.AGED_BRIE.getItenName().equals(item.getName()))
				&& !ItemNames.BACKSTAGE_PASSES.getItenName().equals(item.getName()) && item.getQuality() > 0) {
			isDegradeQuality = true;
		}
		return isDegradeQuality;
	}

	/**
	 * Upgrade quality.
	 *
	 * @param item the item
	 * @return the int
	 */
	private static void upgradeQuality(Item item) {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
			if (ItemNames.BACKSTAGE_PASSES.getItenName().equals(item.getName())) {
				if (item.getSellIn() < 11) {
					if (item.getQuality() < 50) {
						item.setQuality(item.getQuality() + 1);
					}
				}
				if (item.getSellIn() < 6) {
					if (item.getQuality() < 50) {
						item.setQuality(item.getQuality() + 1);
					}
				}
			}
		}
	}

	/**
	 * Decrement sell in.
	 *
	 * @param item the item
	 * @return the int
	 */
	private static void decrementSellIn(Item item) {
		if (isSellInDecrementRequired(item)) {
			item.setSellIn(item.getSellIn() - 1);
		}
	}

	/**
	 * Update quality based on sellin.
	 *
	 * @param item the item
	 * @return the item
	 */
	private static void updateQualityBasedOnSellin(Item item) {
		if (item.getSellIn() < 0) {
			if (!ItemNames.AGED_BRIE.getItenName().equals(item.getName())) {
				if (!ItemNames.BACKSTAGE_PASSES.getItenName().equals(item.getName())) {
					if (item.getQuality() > 0) {
						if (!ItemNames.SULFURAS.getItenName().equals(item.getName())
								&& !ItemNames.ORGANIC_BANANA.getItenName().equals(item.getName())) {
							item.setQuality(item.getQuality() - 1);
						} else if (ItemNames.ORGANIC_BANANA.getItenName().equals(item.getName())) {
							item.setQuality(item.getQuality() - 2);
						}
					}
				} else {
					item.setQuality(item.getQuality() - item.getQuality());
				}
			} else {
				if (item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);
				}
			}
		}
	}

	/**
	 * Checks if is sell in decrement required.
	 *
	 * @param item the item
	 * @return true, if is sell in decrement required
	 */
	private static boolean isSellInDecrementRequired(Item item) {
		boolean isSellInDecrementRequired = false;
		if (!ItemNames.SULFURAS.getItenName().equals(item.getName())) {
			isSellInDecrementRequired = false;
		} else {
			isSellInDecrementRequired = true;
		}
		return isSellInDecrementRequired;
	}

}