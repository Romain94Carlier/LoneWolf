package repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import repository.PageRepository;

public class PageRepositoryTest {
	
	private static PageRepository pageRepository = PageRepository.getInstance();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadFromJson() {
		pageRepository.readPageFromJson("resources/Page1.json");
	}

}
