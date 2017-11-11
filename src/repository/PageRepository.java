package repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;

import model.Page;

@ApplicationScoped
public class PageRepository {
	
	private List<Page> pages = new ArrayList<Page>();
	
	public PageRepository() {
	}
	
	@PostConstruct
	public void init() {
		readPageFromJson("resources/Page1");
	}
	
	public Page getPageByNumber(int number) {
		return null;
	}
	
	public void readPageFromJson(String uri) {
		try {
			 byte[] encoded = Files.readAllBytes(Paths.get(uri));
			 System.out.println(new String(encoded, Charset.defaultCharset()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
