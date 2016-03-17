

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SuperMarketPlusPlusTest {
	
	private static List<Item> items = null;
	private SuperMarketPlusPlus superMarket;
	
	@Before
	 public void setup() {
		items = new ArrayList<Item>();
		superMarket = new SuperMarketPlusPlus();
	}
	
	@After
	public void destroy(){
		items = null;
	}
	
	@Test
	public void testOrganicBananaDegradesTwiceAsFast() {
		Item organicBanana = new Item(ItemNames.ORGANIC_BANANA.getItenName(),5,10);
		items.add(organicBanana);
		superMarket.setItems(items);
		superMarket.updateQuality();
		assertEquals(8,organicBanana.getQuality());
	}
	
	@Test
	public void testThermalVest() {
		Item thermalVest = new Item(ItemNames.THERMAL_VEST.getItenName(),10, 20);
		items.add(thermalVest);
		superMarket.setItems(items);
		superMarket.updateQuality();
		assertEquals(19,thermalVest.getQuality());
	}
	
	@Test
	public void testAgedBrieUpgrades() {
		Item agedBrie = new Item(ItemNames.AGED_BRIE.getItenName(), 2, 0);
		items.add(agedBrie);
		superMarket.setItems(items);
		superMarket.updateQuality();
		assertEquals(1,agedBrie.getQuality());
	}
	
	@Test
	public void testChickenDegrades() {
		Item chicken = new Item(ItemNames.CHICKEN.getItenName(), 5, 7);
		items.add(chicken);
		superMarket.setItems(items);
		superMarket.updateQuality();
		assertEquals(6,chicken.getQuality());
	}
	
	@Test
	public void testSulfurasNoChange() {
		Item sulfuras = new Item(ItemNames.SULFURAS.getItenName(), 0, 80);
		items.add(sulfuras);
		superMarket.setItems(items);
		superMarket.updateQuality();
		assertEquals(80,sulfuras.getQuality());
	}
	
	@Test
	public void testGingerCakeDegrades() {
		Item gingerCake = new Item(ItemNames.GINGER_CAKE.getItenName(), 3, 6);
		items.add(gingerCake);
		superMarket.setItems(items);
		superMarket.updateQuality();
		assertEquals(5,gingerCake.getQuality());
	}
	
	@Test
	public void testBackstagePassesUpgrades() {
		Item backStagePasses = new Item(ItemNames.BACKSTAGE_PASSES.getItenName(), 15, 20);
		items.add(backStagePasses);
		superMarket.setItems(items);
		superMarket.updateQuality();
		assertEquals(21,backStagePasses.getQuality());
	}
	
	@Test
	public void testBackstagePassesUpgradesTwiceAsFast() {
		Item backStagePasses = new Item(ItemNames.BACKSTAGE_PASSES.getItenName(), 5, 20);
		items.add(backStagePasses);
		superMarket.setItems(items);
		superMarket.updateQuality();
		assertEquals(23,backStagePasses.getQuality());
	}
}
