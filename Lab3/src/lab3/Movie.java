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



class Movie {
	private HashSet<FeedMessage> messages;
	private int DaysCount;
	
	public Movie(int maxCountDays) {
		this.messages = new HashSet<FeedMessage>();
		this.DaysCount = maxCountDays;
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
          		
          		if (message.isCorrect() && !message.isNotNew(DaysCount) && !messages.contains(message)) {
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
		
		FileInputStream fileIn = new FileInputStream(file);
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
			
			if (m.isNotNew(DaysCount)) {
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
	

	
	public void printTopMessages(Map<FeedMessage, Integer> map, String phrase, int limit) {
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


