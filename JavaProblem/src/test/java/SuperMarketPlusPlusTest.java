

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class SuperMarketPlusPlusTest {
	
	private static List<Item> items = new ArrayList<Item>();
	private Item organicBanana = null;
	
	
	@Test
	public void testOrganicBananaDegradesTwiceAsFast() {
		organicBanana = new Item(ItemNames.ORGANIC_BANANA.getItenName(),5,10);
		items.add(organicBanana);
		SuperMarketPlusPlus.setItems(items);
		SuperMarketPlusPlus.updateQuality();
		assertEquals(8,organicBanana.getQuality());
	}
}
