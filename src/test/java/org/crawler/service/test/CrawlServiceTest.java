package org.crawler.service.test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Set;

import org.crawler.service.CrawlService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CrawlServiceTest {
    
	private CrawlService crawlService;
	
	@Before
	public void setUp() throws Exception {
		crawlService = new CrawlService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLinksFromUrl() throws IOException {
		Set<String> links = crawlService.getLinksFromUrl("http://wiprodigital.com");
		assertNotNull(links);
		assertThat(links, hasItem("https://wiprodigital.com/what-we-do"));
		assertThat(links, hasItem("https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo.png"));
	}

}
