package com.adaptavist.kieranjw.wordcount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

@SpringBootApplication
public class WordcountApplication {

	public static void main(String[] args) throws FileNotFoundException  {
//		SpringApplication.run(WordcountApplication.class, args);

		// Welcome message
		System.out.println("File word counter");

		// Let's check to see if the user has run with a command line argument
		if (args.length < 1) {
			System.out.println("ERROR - no filename specified");
			System.out.println("Usage: java wordcount.jar <filename>");
			System.exit(1);
		}
		else {
			System.out.println("Filename: " + args[0]);
		}

		// Create hashmap which we'll use to store word counts
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// Invoke the file scanner to scan the contents of our input file
		try (Scanner inputFile = new Scanner(new FileInputStream(args[0])).useDelimiter("[ ,!?.\n\r]+")) {

			// Process words within our inputFile
			while (inputFile.hasNext()) {
				// Let's convert to lowercase to prevent duplicates
				String thisWord = inputFile.next().toLowerCase();
				if (map.containsKey(thisWord)) {
					// Looks like the word already exists in the map, so we'll increase the count by +1
					int count = map.get(thisWord) + 1;
					map.put(thisWord, count);
				} else {
					// The word does not yet exist in the map, so let's add it with a count of 1
					map.put(thisWord, 1);
				}
			}
		}
		catch (Exception e) {
			// Something went wrong opening the file, possible incorrect name/path or permissions
			System.out.println("Error opening file - check filename, path and permissions");
			System.exit(1);
		}

		// We'll now create a LinkedHashMap which we'll use to sort our results
		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

		map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			// Print a line for each entry in the map to return our results
			System.out.println(entry);
		}
		System.out.println("End of results");
		//System.out.println("Map contents : " + map);
	}

}
