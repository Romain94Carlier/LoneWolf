package repository;

import static org.junit.Assert.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import repository.PageRepository;

@ManagedBean
public class PageRepositoryTest {
	
	@ManagedProperty(value="#{pageRepository}")
	private static PageRepository pageRepository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadFromJson() {
		assertEquals("stuff", pageRepository.toString());
	}

}
