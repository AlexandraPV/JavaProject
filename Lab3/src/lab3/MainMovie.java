package lab3;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMovie {
	public static void main(String[] args) throws Exception {
		Movie news = new Movie(100);
		
		
		deserialization(news);
		int before = news.count();
		System.out.println("All news: " + before + "\n");
		
		
		parsing(news);
		int after = news.count();
		System.out.println("All news: " + after );
		System.out.println("Added: "+(after - before) );
		
		
		clearOldNews(news);
		int count = news.count();
		System.out.println("Deleted: "+ (after - count) + "\n");
		
		
		serialization(news);
		System.out.println();
		HashSet<String> stopWords = getStopWords();
		
        Scanner sc = new Scanner(System.in);	
		String command = getCommand(sc);

		while (!command.equals("exit")) {
			if (command.length() > 0) {
				if (stopWords.contains(command)) {
					System.out.println("Can`t use!\n");
				}
				else {
					news.printTopMessages(news.getIndexingResult(command), command, 5);
				}
			}
		command = getCommand(sc);
		}
		sc.close();
	}

	
	private static void deserialization(Movie news) {
		boolean isError = false;
		try {
			news.deserialize();
		} catch (Exception e) {
			System.out.println("ERROR deserialization");
			
		}
		
	}
	
	private static void parsing(Movie news) {
		try {
			File file = new File("src/web.txt");
			file.createNewFile();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String link;
			System.out.println("RSS: ");
			while ((link = reader.readLine()) != null) {
				System.out.print(link);
				int count = news.count();
				news.parse(link);
				System.out.println("");
			}
			System.out.println("");
	        reader.close();
		}
		catch (Exception e) {
			//isError = true;
			System.out.println("ERROR parsing");
		}
		//printErrorStatus(isError);
		//System.out.println("ERROR parsing");
	}
	
	private static void clearOldNews(Movie news) {
		try {
			news.clean();
		} catch (Exception e) {
			System.out.println("ERROR clean");
		}
	}
	
	private static void serialization(Movie news) {
		try {
			news.serialize();
		} catch (Exception e) {
			System.out.println("Not update");
		}
	}
	
	
	private static String getCommand(Scanner console) {
		System.out.print("Enter:  ");
		return console.nextLine().replaceAll("\\s{2,}", " ").trim().toLowerCase();
	}
	
	private static HashSet<String> getStopWords() {
		HashSet<String> stopWords = new HashSet<String>();
		
		try {
			File file = new File("src/stop-words.txt");
			file.createNewFile();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String word;
	        while ((word = reader.readLine()) != null) stopWords.add(word);
	        reader.close();
		}
		catch (Exception e) {}
        
        return stopWords;
	}
}




