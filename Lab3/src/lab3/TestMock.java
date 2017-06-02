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
 
        String phrase = "star";
		HashMap<FeedMessage, Integer> map = new HashMap<FeedMessage, Integer>();
		when(movie.getMessagesWithIndexes(phrase)).thenReturn(map);
		
	
	}
	
	
	@Test
	public void testSortByValues() {
		String phrase = "star";
		HashMap<FeedMessage, Integer> map = new HashMap<FeedMessage, Integer>();

		when(movie.getMessagesWithIndexes(phrase)).thenReturn(map);
		HashMap<FeedMessage, Integer> result = movie.sortByValues(map);
		verify(movie).sortByValues(result);
		
	}
	
	
	
	@Test
	public void testGetIndexingResult() {
		String phrase = "star";
		HashMap<FeedMessage, Integer> map = new HashMap<FeedMessage, Integer>();
		HashMap<FeedMessage, Integer> sortedMap = new LinkedHashMap<FeedMessage, Integer>();
		
		
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
