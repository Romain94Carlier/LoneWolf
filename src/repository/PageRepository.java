package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Page;

//import javax.json.Json;
//import javax.json.JsonArray;
//import javax.json.JsonObject;
//import javax.json.JsonReader;

@ApplicationScoped
public class PageRepository {
	
	private List<Page> pages = new ArrayList<Page>();
	private static PageRepository instance = new PageRepository();
	private String projectFolder = "C:/Users/User/git/LoneWolf/";
	
	private PageRepository() {
		readPageFromJson("resources/Page1.json");
	}
	
	public static PageRepository getInstance() {
		return instance;
	}
	
	public Page getPageByNumber(int number) {
		return null;
	}
	
	public void readPageFromJson(String uri) {
		String stringContent = "";
		try {
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
		File jsonInputFile = new File(projectFolder+uri);
        InputStream is;
        try {
//            is = new FileInputStream(jsonInputFile);
            // Create JsonReader from Json.
//            JsonReader reader = Json.createReader(is);
            // Get the JsonObject structure from JsonReader.
            JSONObject root = new JSONObject(stringContent);

//            reader.close();
            // read string data
            System.out.println("Page number: " + root.getInt("pageNumber"));
            // read integer data
            System.out.println("Main description: " + root.getString("mainDescription"));
            // read inner json element
            JSONArray optionsObj = root.getJSONArray("pageOptions");
            System.out.println("Option 1 description: " + optionsObj.getJSONObject(1).getString("pageOptionDescription"));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
