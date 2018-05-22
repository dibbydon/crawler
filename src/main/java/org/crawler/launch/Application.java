package org.crawler.launch;

import java.io.IOException;
import java.util.Set;

import org.crawler.service.CrawlService;

public class Application {

	public static void main(String[] args) {
		CrawlService crawlService = new CrawlService();
		
		try {
			Set<String> links = crawlService.getLinksFromUrl("http://wiprodigital.com");
			links.stream().sorted().forEach(l -> {System.out.println(l);});
		} catch (IOException e) {
			e.getMessage();
		}

	}

}
