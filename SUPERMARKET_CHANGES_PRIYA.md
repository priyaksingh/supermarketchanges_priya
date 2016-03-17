#Observations:
* Packages are missing and code needs to be organized in their packages.
* Item is a third-party class and cannot have changes. Item class looks like a bean but has no encapsulation as the fields are public. This needs to be changed.
	Also we can have our own ItemBuilder class to keep developers from changing the Item class. ItemBuilder needs to have a toString() method, which can print out the details of the item.
* Better to have logging framework like log4j
* Null & empty String checks are also required.

#Changes Done:
* Added ItemNames enum to have a centralized location for all the item names. This makes code more maintainble for future changes.
* Updated updateQuality() method under SuperMarketPlusPlus.java class for Örganic Banana" changes. It is better to have a switch case on the ItemNames enum and modularize the updateQuality() method. Too many if/else statements in this method.
* Updated SuperMarketPlusPlusTest.java with a test case for "Organic Banana".

#Assumptions:
* Quality is never negative. Hence didnt make changes to updateQuality() to verify for negative quality values.
