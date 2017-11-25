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

	private PageRepository() {
		readPageFromJson("./src/main/resources/Page1.json");
		readPageFromJson("./src/main/resources/Page54.json");
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
			System.out.println("Main description: " + description);
			// read inner json element
			JSONArray optionsObj = root.getJSONArray("pageOptions");
			PageOption[] options = new PageOption[optionsObj.length()];
			for(int i = 0; i < optionsObj.length(); i++) {
				JSONObject optionObj = optionsObj.getJSONObject(i);
				options[i] = new PageOption(optionObj.getInt("pageOptionNumber"), optionObj.getString("pageOptionDescription"));
			}
			//            pages.add(new Page(description, options));
			pages[pageNumber] = new Page(description, options);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
