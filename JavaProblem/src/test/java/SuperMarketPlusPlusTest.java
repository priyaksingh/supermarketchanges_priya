

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class SuperMarketPlusPlusTest.
 */
public class SuperMarketPlusPlusTest {
	
	/** The items. */
	private static List<Item> items = null;
	
	/** The super market. */
	//private SuperMarketPlusPlus superMarket;
	
	/**
	 * Setup.
	 */
	@Before
	 public void setup() {
		items = new ArrayList<Item>();
		//superMarket = new SuperMarketPlusPlus();
	}
	
	/**
	 * Destroy.
	 */
	@After
	public void destroy(){
		items = null;
	}
	
	/**
	 * Test organic banana degrades twice as fast.
	 */
	@Test
	public void testOrganicBananaDegradesTwiceAsFast() {
		Item organicBanana = new Item(ItemNames.ORGANIC_BANANA.getItenName(),5,10);
		items.add(organicBanana);
		SuperMarketPlusPlus.setItems(items);
		SuperMarketPlusPlus.updateQuality();
		assertEquals(8,organicBanana.getQuality());
	}
	
	/**
	 * Test thermal vest.
	 */
	@Test
	public void testThermalVest() {
		Item thermalVest = new Item(ItemNames.THERMAL_VEST.getItenName(),10, 20);
		items.add(thermalVest);
		SuperMarketPlusPlus.setItems(items);
		SuperMarketPlusPlus.updateQuality();
		assertEquals(19,thermalVest.getQuality());
	}
	
	/**
	 * Test aged brie upgrades.
	 */
	@Test
	public void testAgedBrieUpgrades() {
		Item agedBrie = new Item(ItemNames.AGED_BRIE.getItenName(), 2, 0);
		items.add(agedBrie);
		SuperMarketPlusPlus.setItems(items);
		SuperMarketPlusPlus.updateQuality();
		assertEquals(1,agedBrie.getQuality());
	}
	
	/**
	 * Test chicken degrades.
	 */
	@Test
	public void testChickenDegrades() {
		Item chicken = new Item(ItemNames.CHICKEN.getItenName(), 5, 7);
		items.add(chicken);
		SuperMarketPlusPlus.setItems(items);
		SuperMarketPlusPlus.updateQuality();
		assertEquals(6,chicken.getQuality());
	}
	
	/**
	 * Test sulfuras no change.
	 */
	@Test
	public void testSulfurasNoChange() {
		Item sulfuras = new Item(ItemNames.SULFURAS.getItenName(), 0, 80);
		items.add(sulfuras);
		SuperMarketPlusPlus.setItems(items);
		SuperMarketPlusPlus.updateQuality();
		assertEquals(80,sulfuras.getQuality());
	}
	
	/**
	 * Test ginger cake degrades.
	 */
	@Test
	public void testGingerCakeDegrades() {
		Item gingerCake = new Item(ItemNames.GINGER_CAKE.getItenName(), 3, 6);
		items.add(gingerCake);
		SuperMarketPlusPlus.setItems(items);
		SuperMarketPlusPlus.updateQuality();
		assertEquals(5,gingerCake.getQuality());
	}
	
	/**
	 * Test backstage passes upgrades.
	 */
	@Test
	public void testBackstagePassesUpgrades() {
		Item backStagePasses = new Item(ItemNames.BACKSTAGE_PASSES.getItenName(), 15, 20);
		items.add(backStagePasses);
		SuperMarketPlusPlus.setItems(items);
		SuperMarketPlusPlus.updateQuality();
		assertEquals(21,backStagePasses.getQuality());
	}
	
	/**
	 * Test backstage passes upgrades twice as fast.
	 */
	@Test
	public void testBackstagePassesUpgradesTwiceAsFast() {
		Item backStagePasses = new Item(ItemNames.BACKSTAGE_PASSES.getItenName(), 5, 20);
		items.add(backStagePasses);
		SuperMarketPlusPlus.setItems(items);
		SuperMarketPlusPlus.updateQuality();
		assertEquals(23,backStagePasses.getQuality());
	}
}
