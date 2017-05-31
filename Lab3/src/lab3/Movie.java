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
	
	
	public boolean isNew(int maxCountDays) throws ParseException {
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
	
	/*public void printInfo() {
		System.out.println("Title:\n   " + title);
		System.out.println("Description:\n   " + description);
		System.out.println();
	}*/
	
	public void printAllInfo() {
		System.out.println("Title:   " + title);
		System.out.println("Description:   " + description);
		System.out.println("PubDate:   " + pubDate);
		System.out.println();
	 }
  }

class Movie {
	private HashSet<FeedMessage> messages;
	private int maxCountDays;
	
	public Movie(int maxCountDays) {
		this.messages = new HashSet<FeedMessage>();
		this.maxCountDays = maxCountDays;
	}

	public int count() {
		return messages.size();
	}
	
	public void parse(String link) throws Exception {
		URL url = new URL(link);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String line, xml = "";
        while ((line = in.readLine()) != null) xml += line;
        in.close();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		ByteArrayInputStream input =  new ByteArrayInputStream(xml.getBytes("UTF-8"));
		Document doc = builder.parse(input);
		
		NodeList items = doc.getElementsByTagName("item");
		
		for (int i = 0; i < items.getLength(); i++) {
        	Node itemNode = items.item(i);
        	
          	if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
          		Element itemElement = (Element) itemNode;
          		
          		FeedMessage message = new FeedMessage();
          		message.title = itemElement.getElementsByTagName("title").item(0).getTextContent(); 
          		
          		if(itemElement.getElementsByTagName("description").item(0)!=null){
          			message.description = itemElement.getElementsByTagName("description").item(0).getTextContent();	
          		}
          		else {
          			message.description = "";
          			}
          		
          		message.pubDate = itemElement.getElementsByTagName("pubDate").item(0).getTextContent();
          		
          		if (message.isCorrect() && !message.isNew(maxCountDays) && !messages.contains(message)) {
          			messages.add(message);
          		}
          	}
        }
	}
	
	public void serialize() throws IOException {
		File file = new File("src/Movie.txt");
		file.createNewFile();
		
		FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(messages);
		out.close();
		fileOut.close();
	}
	
	public void deserialize() throws IOException {
		File file = new File("src/Movie.txt");
		file.createNewFile();
		
		FileInputStream fileIn = new FileInputStream("src/Movie.txt");
		try {
			ObjectInputStream in = new ObjectInputStream(fileIn);
			messages = (HashSet<FeedMessage>) in.readObject();
			in.close();
		}
		catch (Exception e) {}
		fileIn.close();
	}
	
	public void clean() throws ParseException {
		Iterator<FeedMessage> iter = messages.iterator();
		
		while (iter.hasNext()) {
			FeedMessage m = iter.next();
			
			if (m.isNew(maxCountDays)) {
				iter.remove();
			}
		}
	}
	
	public HashMap<FeedMessage, Integer> getIndexingResult(String phrase) {
		return sortByValues(getMessagesWithIndexes(phrase));
	}
	
	public HashMap<FeedMessage, Integer> getMessagesWithIndexes(String phrase) {
		HashMap<FeedMessage, Integer> map = new HashMap<FeedMessage, Integer>();

		for (FeedMessage m : messages) {
			int index = m.getIndex(phrase);
			map.put(m, index);
		}
		return map;
	}
	
	public HashMap<FeedMessage, Integer> sortByValues(HashMap<FeedMessage, Integer> map) {
		List<Entry<FeedMessage, Integer>> list = new LinkedList<Entry<FeedMessage, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<FeedMessage, Integer>>() {
        	public int compare(Map.Entry<FeedMessage, Integer> o1, Map.Entry<FeedMessage, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        map = new LinkedHashMap<FeedMessage, Integer>();
        
        for(Map.Entry<FeedMessage, Integer> entry : list) {
        	map.put(entry.getKey(), entry.getValue());
        }
        return map;
	}
	
	public void print() {
		for (FeedMessage m : messages) {
			m.printAllInfo();
		}
	}
	
	public void printTopMessages(HashMap<FeedMessage, Integer> map, String phrase, int limit) {
		int i = 1;
		for (FeedMessage key : map.keySet()) {
			int count = map.get(key);

			if (count > 0) {
				System.out.println("Count(" + phrase + "): " + count);
				key.printAllInfo();
			}
			if (i == limit) break;
			i++;
		}
	}
}


