import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.io.IOException;  
import java.util.Map; 
import java.util.HashSet;
import java.util.Set;

public class wordcount {

public class CountWords {

    public static void main (String args[]) throws Exception {
    
     
               try {
            	   Set<String> predefinedWords = new HashSet<>();
                   
                   BufferedReader predefinedWordsreader = new BufferedReader(new FileReader("/Users/anvi/Desktop/predefindWords.txt"));
                   String predefinedWordsline;
                   while ((predefinedWordsline = predefinedWordsreader.readLine()) != null) {
                       String[] words1 = predefinedWordsline.split("\\s+"); // Split by whitespace
                       for (String word : words1) {
                          
                        	   predefinedWords.add(word.toLowerCase());
                           
                       }
                   }
                   predefinedWordsreader.close();
                   
            	   
                   Map<String, Integer> matchCount = new HashMap<>();
                   // Initialize matchCount with predefined words
                   for (String word : predefinedWords) {
                       matchCount.put(word.toLowerCase(), 0);
                   }

                   BufferedReader reader = new BufferedReader(new FileReader("/Users/anvi/Desktop/file.txt"));
                   String line;
                   while ((line = reader.readLine()) != null) {
                       String[] words = line.split("\\s+"); // Split by whitespace
                       for (String word : words) {
                           if (predefinedWords.contains(word.toLowerCase())) {
                               matchCount.put(word.toLowerCase(), matchCount.get(word.toLowerCase()) + 1);
                           }
                       }
                   }
                   reader.close();

                   // Print matches found
                   System.out.println("Matches found in the file:");
                   for (String word : predefinedWords) {
                	   
                   int count = matchCount.get(word.toLowerCase());
                     
                   System.out.println("Predefined word : "+word + " Match count " + count + " occurrences");
                    	  
                   }

               } catch (IOException e) {
                   System.err.println("Error reading the file: " + e.getMessage());
               }
           
       


       }}}

        
       