import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperMarketPlusPlus.
 */
public class SuperMarketPlusPlus {

	/** The items. */
	private List<Item> items = new ArrayList<Item>();

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
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * Update quality.
	 */
	public void updateQuality() {
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
	private int degradeQuality(Item item) {
		if (!ItemNames.SULFURAS.getItenName().equals(item.getName())
				&& !ItemNames.ORGANIC_BANANA.getItenName().equals(item.getName())) {
			item.setQuality(item.getQuality() - 1);
		} else if (ItemNames.ORGANIC_BANANA.getItenName().equals(item.getName())) {
			item.setQuality(item.getQuality() - 2);
		}
		return item.getQuality();
	}

	/**
	 * Checks if is quality degradation required.
	 *
	 * @param item the item
	 * @return true, if is quality degradation required
	 */
	private boolean isQualityDegradationRequired(Item item) {
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
	private int upgradeQuality(Item item) {
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
		return item.getQuality();
	}

	/**
	 * Decrement sell in.
	 *
	 * @param item the item
	 * @return the int
	 */
	private int decrementSellIn(Item item) {
		if (isSellInDecrementRequired(item)) {
			item.setSellIn(item.getSellIn() - 1);
		}
		return item.getSellIn();
	}

	/**
	 * Update quality based on sellin.
	 *
	 * @param item the item
	 * @return the item
	 */
	private Item updateQualityBasedOnSellin(Item item) {
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
		return item;
	}

	/**
	 * Checks if is sell in decrement required.
	 *
	 * @param item the item
	 * @return true, if is sell in decrement required
	 */
	private boolean isSellInDecrementRequired(Item item) {
		boolean isSellInDecrementRequired = false;
		if (!ItemNames.SULFURAS.getItenName().equals(item.getName())) {
			isSellInDecrementRequired = false;
		} else {
			isSellInDecrementRequired = true;
		}
		return isSellInDecrementRequired;
	}

}