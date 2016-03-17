import java.util.ArrayList;
import java.util.List;

public class SuperMarketPlusPlus {

	private static List<Item> items = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

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

	public static void updateQuality1() {
		for (int i = 0; i < items.size(); i++) {
			switch (ItemNames.valueOf(items.get(i).getName())) {
			//To Do
			

			}
		}
	}
	
	
	public static void updateQuality() {
		for (int i = 0; i < items.size(); i++) {
			if ((!ItemNames.AGED_BRIE.getItenName().equals(items.get(i).getName()))
					&& !ItemNames.BACKSTAGE_PASSES.getItenName().equals(items.get(i).getName())) {
				if (items.get(i).getQuality() > 0) {
					if (!ItemNames.SULFURAS.getItenName().equals(items.get(i).getName())
							&& !ItemNames.ORGANIC_BANANA.getItenName().equals(items.get(i).getName())) {
						items.get(i).setQuality(items.get(i).getQuality() - 1);
					} else if (ItemNames.ORGANIC_BANANA.getItenName().equals(items.get(i).getName())) {
						items.get(i).setQuality(items.get(i).getQuality() - 2);
					}
				}
			} else {
				if (items.get(i).getQuality() < 50) {
					items.get(i).setQuality(items.get(i).getQuality() + 1);

					if (ItemNames.BACKSTAGE_PASSES.getItenName().equals(items.get(i).getName())) {
						if (items.get(i).getSellIn() < 11) {
							if (items.get(i).getQuality() < 50) {
								items.get(i).setQuality(items.get(i).getQuality() + 1);
							}
						}

						if (items.get(i).getSellIn() < 6) {
							if (items.get(i).getQuality() < 50) {
								items.get(i).setQuality(items.get(i).getQuality() + 1);
							}
						}
					}
				}
			}

			if (!ItemNames.SULFURAS.getItenName().equals(items.get(i).getName())) {
				items.get(i).setSellIn(items.get(i).getSellIn() - 1);
			}

			if (items.get(i).getSellIn() < 0) {
				if (!ItemNames.AGED_BRIE.getItenName().equals(items.get(i).getName())) {
					if (!ItemNames.BACKSTAGE_PASSES.getItenName().equals(items.get(i).getName())) {
						if (items.get(i).getQuality() > 0) {
							if (!ItemNames.SULFURAS.getItenName().equals(items.get(i).getName())
									&& !ItemNames.ORGANIC_BANANA.getItenName().equals(items.get(i).getName())) {
								items.get(i).setQuality(items.get(i).getQuality() - 1);
							} else if (ItemNames.ORGANIC_BANANA.getItenName().equals(items.get(i).getName())) {
								items.get(i).setQuality(items.get(i).getQuality() - 2);
							}
						}
					} else {
						items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
					}
				} else {
					if (items.get(i).getQuality() < 50) {
						items.get(i).setQuality(items.get(i).getQuality() + 1);
					}
				}
			}
		}
	}

	public static List<Item> getItems() {
		return items;
	}

	public static void setItems(List<Item> items) {
		SuperMarketPlusPlus.items = items;
	}

}