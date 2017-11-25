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
import main.java.model.PageOption;
import main.java.model.Weapon;

public class InventoryRepository {
	
	private static InventoryRepository instance = new InventoryRepository();
	private List<InventoryItem> items = new ArrayList<>();
//	private String projectFolder = "C:/Users/User/git/LoneWolf/";
	
	private InventoryRepository() {
	}
	
	public static InventoryRepository getInstance() {
		return instance;
	}

	public void loadStartInventory() {
		String uri = "";
			String stringContent = "";
			try {
				 byte[] encoded = Files.readAllBytes(Paths.get(uri));
				 stringContent = new String(encoded, Charset.defaultCharset());
				 System.out.println("read from "+uri);
				 System.out.println(stringContent);
			} catch (NoSuchFileException e) {
				 try {byte[] encoded = Files.readAllBytes(Paths.get(uri));
				System.out.println("read from "+uri);
				stringContent = new String(encoded, Charset.defaultCharset());
				System.out.println(stringContent); } catch (IOException ex) {}
			} catch (IOException e) {
				e.printStackTrace();
			} 
	        try {
	            JSONObject root = new JSONObject(stringContent);
	            int pageNumber = root.getInt("pageNumber");
	            System.out.println("Page number: " + pageNumber);
	            String description = root.getString("mainDescription");
	            System.out.println("Main description: " + description);
	            // read inner json element
	            JSONArray optionsObj = root.getJSONArray("pageOptions");
	            PageOption[] options = new PageOption[optionsObj.length()];
	            for(int i = 0; i < optionsObj.length(); i++) {
	            	JSONObject optionObj = optionsObj.getJSONObject(i);
	            	options[i] = new PageOption(optionObj.getInt("pageOptionNumber"), optionObj.getString("pageOptionDescription"));
	            }
//	            pages.add(new Page(description, options));
	            items.add(new Weapon("Sword", 1));
	        } catch (JSONException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
}
