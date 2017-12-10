package main.java.repository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import main.java.model.InventoryItem;
import main.java.model.InventoryItemFactory;
import main.java.model.InventoryItemFactory.InventoryItemBuilder;
import main.java.model.PageOption;
import main.java.model.Weapon;

public class InventoryRepository {
	
	private static InventoryRepository instance = new InventoryRepository();
	private List<InventoryItem> items = new ArrayList<>();
	private int gold = 0;
//	private String projectFolder = "C:/Users/User/git/LoneWolf/";
	
	private InventoryRepository() {
	}
	
	public static InventoryRepository getInstance() {
		return instance;
	}

	public void loadStartInventory() {
		InventoryItemBuilder provisionBuilder = InventoryItemFactory.createInventoryItemBuilder();
		items.add(provisionBuilder.name("Provisions").description("Eating provisions recovers 4 stamina points").quantity(10).build());
	}

	public InventoryItem[] getItems() {
		return items.toArray(new InventoryItem[items.size()]);
	}

	public void spendGold(int price) {
		this.gold  -= price;
	}

	public void addToInventory(InventoryItem item) {
		this.items.add(item);
	}

	public int getGold() {
		return gold;
	}
}
