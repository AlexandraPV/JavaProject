package lab3;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import java.net.URL;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.text.ParseException;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;
import java.util.Date;

class FeedMessage implements Serializable {	
	private static final long serialVersionUID = 1345894148743632510L;
	
	public String title;
	public String description;
	public String pubDate;
	
	public int getIndex(String phrase) {
		return countWords(title, phrase) + countWords(description, phrase);
	}
	
	private int countWords(String str1, String str2) {
		str1 = str1.replaceAll("\\s", "  ").trim().toLowerCase();
		str2 = str2.replaceAll("\\s{2,}", " ").trim().toLowerCase();
		
		Pattern p = Pattern.compile("(^| )"+str2+"( |$)");
		Matcher match = p.matcher(str1);		
		int count = 0;	
		while (match.find()) {count++;};
		
		return count;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		FeedMessage other = (FeedMessage) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (pubDate == null) {
			if (other.pubDate != null) {
				return false;
			}
		} else if (!pubDate.equals(other.pubDate)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}
	
	public boolean isCorrect() {
		if (title == null || description == null || pubDate == null) {
			return false;
		}
		if (pubDate.isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	public boolean isNotNew(int maxCountDays) throws ParseException { 
		SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss", java.util.Locale.ENGLISH);
		format.setTimeZone(TimeZone.getTimeZone("EEST"));
		
	
		Date date = format.parse(pubDate);
		Date now = new Date();
		
		long diffTime = now.getTime() - date.getTime();
		int countDays = (int) TimeUnit.DAYS.convert(diffTime, TimeUnit.MILLISECONDS);
		
		if (countDays >= maxCountDays) {
			return true;
		}
		return false;
	}
	
	
	public void printAllInfo() {
		System.out.println("Title:   " + title);
		System.out.println("Description:   " + description);
		System.out.println("PubDate:   " + pubDate);
		System.out.println();
	 }
  }
