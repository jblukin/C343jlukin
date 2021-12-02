import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab08Hashing {
	
	static Hashtable wordSearcher = new Hashtable<String, List<Integer>>();
	
	
	public static void buildTable() {
		
		File file = new File("file.txt");
		
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int line = 1;
		
		while (sc.hasNextLine()) {
			
			String s = sc.nextLine();
			
			String[] sArray = s.split(" ");

//			for (int i = 0; i < sArray.length; i++) {
//
//				System.out.println(sArray[i]);
//			}
			
			for (String word : sArray) {
				
				if(word.contains(",") || word.contains(".")) {
					
					word = word.substring(0, word.length()-1);
					
				}
				
				List<Integer> ints = new ArrayList<Integer>();
				
				if (wordSearcher.containsKey(word)) {
					
					ints = (List<Integer>) wordSearcher.get(word);
					
					if (!ints.contains(line)) {
						
						ints.add(line);
						
					}
					
				} else if (ints.isEmpty()) {
					
					ints.add(line);
					
				}
				
				wordSearcher.put(word, ints);
				
			}
			
			line++;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		buildTable();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Word to find? ");
		String word = input.next();
		
		System.out.println(wordSearcher.get(word));
		
	}
	
}