package org.crawler.service;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlService {
 
	static final Logger logger = LogManager.getLogger(CrawlService.class.getName());
	private static Set<String> links = new HashSet<>();
	
	public Set<String>getLinksFromUrl(String url) throws IOException{
		URL miUrl = new URL(url);
		String baseUrl = miUrl.getHost();
		logger.debug( miUrl + " : "+ baseUrl);
		return  getLinksFromUrl(url, baseUrl);
	}
	
	
	
	private Set<String> getLinksFromUrl(String url, String baseUrl) throws IOException{
		final String mbaseUrl = baseUrl;
		
		if (!links.contains(url)) {
			Document document = Jsoup.connect(url)
									 .userAgent("Mozilla")
									 .get();
			
			Elements pageLinks = document.select("a[href]");
			
			pageLinks.stream().map(p  -> p.attr("abs:href"))
			                  .forEach(l -> { 
				                              links.add(l);
				                              if (l.contains(mbaseUrl)) {
				                            	 try {
													getLinksFromUrl(l, mbaseUrl);
												} catch (IOException e) {
													e.getMessage();
												}
				                              }
			                                 });
		}
		
		return links;
	}
	
}
