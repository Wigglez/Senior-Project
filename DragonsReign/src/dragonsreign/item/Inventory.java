package dragonsreign.item;

import java.util.ArrayList;

import dragonsreign.item.consumable.Potion;
import dragonsreign.scene.DragonsReignActivity;
import dragonsreign.util.enums.ITEMTYPE;
import dragonsreign.util.enums.POTIONS;

public class Inventory {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final int MAX_INVENTORY_SIZE = 25;

	// ===========================================================
	// Fields
	// ===========================================================

	private ArrayList<Item> mInventory = new ArrayList<Item>();

	// ===========================================================
	// Constructors
	// ===========================================================
	public Inventory() {
		addItem(new Gear(ITEMTYPE.HEAVY_HELMET, 100, 100, 300, 200, 400, 100, 110, false));
		addItem(new Gear(ITEMTYPE.CROSSBOW, 1, 10, 3, 2, 4, 0, 11, false));
		addItem(new Gear(ITEMTYPE.MEDIUM_HELMET, 1, 10, 3, 2, 4, 0, 11, false));
		addItem(new Gear(ITEMTYPE.ORB, 1, 10, 3, 2, 4, 0, 11, false));
		addItem(new Potion(POTIONS.FULL_REVIVE_POTION));
		addItem(new Gear(ITEMTYPE.HEAVY_CHESTPLATE, 100, 100, 300, 200, 400, 100, 110, false));
	}
	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// Get the number of items stored in the inventory
	public int getCurrentInventorySize() {
		return mInventory.size();
	}

	// Get the max amount of inventory slots
	public int getMaxInventorySize() {
		return MAX_INVENTORY_SIZE;
	}

	// Get an item stored in the inventory by its location
	public Item getItem(int pIndex) {
		return mInventory.get(pIndex);
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// Inserts an item in the first available inventory slot
	public boolean addItem(Item pItem) {
		boolean itemAdded = false;

		if (mInventory.size() < MAX_INVENTORY_SIZE) {
			mInventory.add(pItem);

			itemAdded = true;
		}

		return itemAdded;
	}

	// Remove an item from the inventory
	public void removeItem(Item pItem) {
		if (mInventory.contains(pItem)) {
			mInventory.remove(pItem);
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
