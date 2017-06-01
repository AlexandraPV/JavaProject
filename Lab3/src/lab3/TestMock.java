package lab3;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TestMock {

	private Movie movie = Mockito.mock(Movie.class);
	
	
	@Test
	public void testGetMessagesWithIndexes() {
HashSet<FeedMessage> messages = new HashSet<FeedMessage>();
		
		FeedMessage message1 = new FeedMessage();
		message1.title = "Johnny Depp to Kurt Russell";
		message1.description = "How De-Aging Stars Became Hollywood's VFX Trick Du Jour";
		message1.pubDate = "Tue, 30 May 2017 05:30:00 PDT";
		messages.add(message1);
		
		FeedMessage message2 = new FeedMessage();
		message2.title = "Star 'Silicon Valley' Star";
		message2.description = "Thomas Middleditch Joins 'Godzilla' Sequel star";
		message2.pubDate = "Mon, 15 May 2017 17:29:01 +08:00";
		messages.add(message2);
		
		FeedMessage message3 = new FeedMessage();
		message3.title = "Meet UFC's newest female star";
		message3.description = "UFC women's strawweight champion, Joanna Jedrzejczyk";
		message3.pubDate = "Thu, 01 Jun 2017 16:13:46 GMT";
		messages.add(message3);

		String phrase = "star";
		HashMap<FeedMessage, Integer> map = new HashMap<FeedMessage, Integer>();
		for (FeedMessage m : messages) {
			int index = m.getIndex(phrase);
			map.put(m, index);
		}
		
		HashMap<FeedMessage, Integer> sortedMap = new LinkedHashMap<FeedMessage, Integer>();
		sortedMap.put(message3, message3.getIndex(phrase));
		sortedMap.put(message2, message2.getIndex(phrase));
		sortedMap.put(message1, message1.getIndex(phrase));
		
		HashMap<FeedMessage, Integer> result = movie.getMessagesWithIndexes(phrase);
		
		verify(movie).getMessagesWithIndexes(phrase);
		
	}
	
	
	@Test
	public void testSortByValues() {
HashSet<FeedMessage> messages = new HashSet<FeedMessage>();
		
		FeedMessage message1 = new FeedMessage();
		message1.title = "Johnny Depp to Kurt Russell";
		message1.description = "How De-Aging Stars Became Hollywood's VFX Trick Du Jour";
		message1.pubDate = "Tue, 30 May 2017 05:30:00 PDT";
		messages.add(message1);
		
		FeedMessage message2 = new FeedMessage();
		message2.title = "Star 'Silicon Valley' Star";
		message2.description = "Thomas Middleditch Joins 'Godzilla' Sequel star";
		message2.pubDate = "Mon, 15 May 2017 17:29:01 +08:00";
		messages.add(message2);
		
		FeedMessage message3 = new FeedMessage();
		message3.title = "Meet UFC's newest female star";
		message3.description = "UFC women's strawweight champion, Joanna Jedrzejczyk";
		message3.pubDate = "Thu, 01 Jun 2017 16:13:46 GMT";
		messages.add(message3);

		String phrase = "star";
		HashMap<FeedMessage, Integer> map = new HashMap<FeedMessage, Integer>();
		for (FeedMessage m : messages) {
			int index = m.getIndex(phrase);
			map.put(m, index);
		}
		
		HashMap<FeedMessage, Integer> sortedMap = new LinkedHashMap<FeedMessage, Integer>();
		sortedMap.put(message3, message3.getIndex(phrase));
		sortedMap.put(message2, message2.getIndex(phrase));
		sortedMap.put(message1, message1.getIndex(phrase));
		
		when(movie.getMessagesWithIndexes(phrase)).thenReturn(map);
		HashMap<FeedMessage, Integer> result = movie.sortByValues(map);
		verify(movie).sortByValues(map);
		
	}
	
	
	
	@Test
	public void testGetIndexingResult() {
		HashSet<FeedMessage> messages = new HashSet<FeedMessage>();
		
		FeedMessage message1 = new FeedMessage();
		message1.title = "Johnny Depp to Kurt Russell";
		message1.description = "How De-Aging Stars Became Hollywood's VFX Trick Du Jour";
		message1.pubDate = "Tue, 30 May 2017 05:30:00 PDT";
		messages.add(message1);
		
		FeedMessage message2 = new FeedMessage();
		message2.title = "Star 'Silicon Valley' Star";
		message2.description = "Thomas Middleditch Joins 'Godzilla' Sequel star";
		message2.pubDate = "Mon, 15 May 2017 17:29:01 +08:00";
		messages.add(message2);
		
		FeedMessage message3 = new FeedMessage();
		message3.title = "Meet UFC's newest female star";
		message3.description = "UFC women's strawweight champion, Joanna Jedrzejczyk";
		message3.pubDate = "Thu, 01 Jun 2017 16:13:46 GMT";
		messages.add(message3);

		String phrase = "star";
		
		HashMap<FeedMessage, Integer> map = new HashMap<FeedMessage, Integer>();
		for (FeedMessage m : messages) {
			int index = m.getIndex(phrase);
			map.put(m, index);
		}
		
		HashMap<FeedMessage, Integer> sortedMap = new LinkedHashMap<FeedMessage, Integer>();
		sortedMap.put(message3, message3.getIndex(phrase));
		sortedMap.put(message2, message2.getIndex(phrase));
		sortedMap.put(message1, message1.getIndex(phrase));
		
		when(movie.getMessagesWithIndexes(phrase)).thenReturn(map);
		when(movie.sortByValues(map)).thenReturn(sortedMap);

		HashMap<FeedMessage, Integer> result = movie.getIndexingResult(phrase);
		verify(movie).getIndexingResult(phrase);
		
	}
	
	@Test
	public void testCount() {
		when(movie.count()).thenReturn(3);
		assertEquals(3, movie .count());
	}
	
}
