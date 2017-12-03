package main.java.repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import javax.faces.bean.ApplicationScoped;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import main.java.model.InventoryItem;
import main.java.model.InventoryItemFactory;
import main.java.model.Monster;
import main.java.model.Page;
import main.java.model.PageOption;

//import javax.json.Json;
//import javax.json.JsonArray;
//import javax.json.JsonObject;
//import javax.json.JsonReader;

@ApplicationScoped
public class PageRepository {

	private Page[] pages = new Page[400];
	private static PageRepository instance = new PageRepository();
	private String projectFolder = "C:/Users/User/git/LoneWolf/";
	private int[] supportedPages = {1, 54, 181, 260, 261, 303, 399};

	private PageRepository() {
		for(int i : supportedPages)
			readPageFromJson("./src/main/resources/Page"+i+".json");
	}

	public static PageRepository getInstance() {
		return instance;
	}

	public Page getPageByNumber(int number) {
		return pages[number];
	}

	public void readPageFromJson(String uri) {
		String stringContent = "";
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream("uri");
			byte[] encoded = Files.readAllBytes(Paths.get(uri));
			stringContent = new String(encoded, Charset.defaultCharset());
			System.out.println("read from "+uri);
			System.out.println(stringContent);
		} catch (NoSuchFileException e) {
			try {byte[] encoded = Files.readAllBytes(Paths.get(projectFolder+uri));
			System.out.println("read from "+projectFolder+uri);
			stringContent = new String(encoded, Charset.defaultCharset());
			System.out.println(stringContent); } catch (IOException ex) {}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		//		File jsonInputFile = new File(projectFolder+uri);
		//        InputStream is;
		try {
			//            is = new FileInputStream(jsonInputFile);
			// Create JsonReader from Json.
			//            JsonReader reader = Json.createReader(is);
			// Get the JsonObject structure from JsonReader.
			JSONObject root = new JSONObject(stringContent);

			int pageNumber = root.getInt("pageNumber");
			System.out.println("Page number: " + pageNumber);
			
			String description = root.getString("mainDescription");
//			System.out.println("Main description: " + description);

			JSONArray optionsObj = root.getJSONArray("pageOptions");
			PageOption[] options = new PageOption[optionsObj.length()];
			for(int i = 0; i < optionsObj.length(); i++) {
				JSONObject optionObj = optionsObj.getJSONObject(i);
				options[i] = new PageOption(optionObj.getInt("pageOptionNumber"), optionObj.getString("pageOptionDescription"));
			}
			
			JSONArray monstersObj = root.getJSONArray("monsters");
			Monster[] monsters = new Monster[monstersObj.length()];
			for(int i = 0; i < monstersObj.length(); i++) {
				JSONObject monsterObj = monstersObj.getJSONObject(i);
				monsters[i] = new Monster(monsterObj.getString("name"), monsterObj.getString("description"), monsterObj.getInt("stamina"), monsterObj.getInt("skill"), monsterObj.getBoolean("flee"));
			}
			
			JSONArray itemsFoundObj = root.getJSONArray("itemsFound");
			InventoryItem[] itemsFound = new InventoryItem[itemsFoundObj.length()];
			for(int i = 0; i < itemsFoundObj.length(); i++) {
				JSONObject itemFoundObj = itemsFoundObj.getJSONObject(i);
				itemsFound[i] = InventoryItemFactory.createInventoryItemBuilder().name(itemFoundObj.getString("name")).description(itemFoundObj.getString("description")).build();
			}
			
			JSONArray itemsToBuyObj = root.getJSONArray("monsters");
			InventoryItem[] itemsToBuy = new InventoryItem[itemsToBuyObj.length()];
			for(int i = 0; i < itemsToBuyObj.length(); i++) {
				JSONObject itemToBuy = itemsToBuyObj.getJSONObject(i);
				itemsToBuy[i] = InventoryItemFactory.createInventoryItemBuilder().name(itemToBuy.getString("name")).description(itemToBuy.getString("description")).price(itemToBuy.getInt("price")).build();
			}
			
			pages[pageNumber] = new Page(pageNumber, description, monsters, options);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
