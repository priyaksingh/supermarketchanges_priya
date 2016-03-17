import java.util.ArrayList;
import java.util.List;

public class SuperMarketPlusPlus {

	private List<Item> items = new ArrayList<Item>();

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void updateQuality1() {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName() != null && !items.get(i).getName().isEmpty()) {
				switch (ItemNames.valueOf(items.get(i).getName())) {
				// To Do
				case THERMAL_VEST:
					decrementSellIn(items.get(i));
				case AGED_BRIE:
				case CHICKEN:
				case BACKSTAGE_PASSES:
				case GINGER_CAKE:
				case ORGANIC_BANANA:

				case SULFURAS:

				}
			}
		}
	}

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

	private int degradeQuality(Item item) {
		if (!ItemNames.SULFURAS.getItenName().equals(item.getName())
				&& !ItemNames.ORGANIC_BANANA.getItenName().equals(item.getName())) {
			item.setQuality(item.getQuality() - 1);
		} else if (ItemNames.ORGANIC_BANANA.getItenName().equals(item.getName())) {
			item.setQuality(item.getQuality() - 2);
		}
		return item.getQuality();
	}

	private boolean isQualityDegradationRequired(Item item) {
		boolean isDegradeQuality = false;
		if ((!ItemNames.AGED_BRIE.getItenName().equals(item.getName()))
				&& !ItemNames.BACKSTAGE_PASSES.getItenName().equals(item.getName()) && item.getQuality() > 0) {
			isDegradeQuality = true;
		}
		return isDegradeQuality;
	}

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

	private int decrementSellIn(Item item) {
		if (isSellInDecrementRequired(item)) {
			item.setSellIn(item.getSellIn() - 1);
		}
		return item.getSellIn();
	}

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