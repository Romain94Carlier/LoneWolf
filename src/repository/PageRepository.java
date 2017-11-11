package repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;

import model.Page;
import service.Game;
import service.PageService;

@ApplicationScoped
public class PageRepository {
	
	private List<Page> pages = new ArrayList<Page>();
	private static PageRepository instance = new PageRepository();
	private String projectFolder = "C:/Users/User/git/LoneWolf/";
	
	private PageRepository() {
		try {
			readPageFromJson("resources/Page1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static PageRepository getInstance() {
		return instance;
	}
	
	public Page getPageByNumber(int number) {
		return null;
	}
	
	public void readPageFromJson(String uri) throws IOException {
		try {
			 byte[] encoded = Files.readAllBytes(Paths.get(uri));
			 System.out.println("read from "+uri);
			 System.out.println(new String(encoded, Charset.defaultCharset()));
		} catch (NoSuchFileException e) {
			byte[] encoded = Files.readAllBytes(Paths.get(projectFolder+uri));
			System.out.println("read from "+projectFolder+uri);
			System.out.println(new String(encoded, Charset.defaultCharset()));
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
