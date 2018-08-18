import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class wordsInFiles {

	private static HashMap<String, ArrayList<String>> myMap;

	public wordsInFiles() {
		myMap = new HashMap<String, ArrayList<String>>();
	}

	public static void addWordsFromFile(String fileName) {

		// changing this fnc about to fit with the ones from later on. changed the parameter it takes in 
		// from String fileName -> String line. will comment out the things about reading files. 
		
		
		String filename = fileName;
		String line = null;
		// ArrayList<String> words = new ArrayList<String>();
//		wordsInFiles wif = new wordsInFiles();
 
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			for (line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
				line.trim();

				String[] words = line.split("\\s+");
				System.out.println(Arrays.toString(words));
				
				if (myMap.isEmpty()){
					ArrayList<String> first = new ArrayList<String>();
					first.add(filename);
					myMap.put(words[0],first);
				}
				
//				for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()){
//					System.out.println(entry.getKey() + entry.getValue());
//				}
			//	ArrayList<String> wordAL = new ArrayList<String>();
				
				for (int k = 0; k < words.length; k++) {
					if (!myMap.containsKey(words[k])) {
						
						ArrayList<String> wordAL = new ArrayList<String>();
						wordAL.clear();
					//	myMap.get(words[k]).add(filename); 
						wordAL.add(filename);
					//	myMap.put(words[k], myMap.get(words[k]));
						myMap.put(words[k], wordAL);
						
					} else {
						if (!myMap.get(words[k]).contains(filename)) {
							myMap.get(words[k]).add(filename);
						}
					}
				}
			}
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}

		for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
			System.out.println(entry.getKey() + entry.getValue());
		}
		System.out.println("--------------------------------------");

	}	

	public static void buildWordFileMap() {

		wordsInFiles wif = new wordsInFiles();
		myMap.clear();

		FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
		dialog.setMode(FileDialog.LOAD);
		dialog.setVisible(true);
		String file = dialog.getFile().toString();
		System.out.println(file + " chosen.");

		addWordsFromFile(file);
	}

	public static int maxNumber() {

		int currVal = Integer.MIN_VALUE;

		for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
			if (entry.getValue().size() > currVal) {
				currVal = entry.getValue().size();

			}
		}
		System.out.println("MaxNumber returns:	" + currVal);
		return currVal;

		// for (HashMap.Entry<String, ArrayList<String>> entry2 :
		// myMap.entrySet()){
		// if (entry2.getValue().size() == currVal){
		// System.out.println(entry2.getKey() + " " +
		// Arrays.toString(entry2.getValue().toArray()));
		// }
		// }
	}

	public static ArrayList<String> wordsInNumFiles(Integer number) {
		ArrayList<String> wordsInNumFilesAL = new ArrayList<String>();

		for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
			if (entry.getValue().size() == number) {
				wordsInNumFilesAL.add(entry.getKey());
				System.out.println(entry.getKey() + "	" + Arrays.toString(entry.getValue().toArray()));
			}
		} 
		System.out.println("****************************************");
		System.out.println(Arrays.toString(wordsInNumFilesAL.toArray()));
		System.out.println(wordsInNumFilesAL.size());
		return wordsInNumFilesAL;
	}

	public static void printFilesIn(String word) {

		System.out.println(Arrays.toString(myMap.get(word).toArray()));
	}

	public static void tester() {
		// buildWordFileMap();
		String[] filenames = { "caesar.txt","confucius.txt","errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt" };
		wordsInFiles wif = new wordsInFiles();
	//	String totalSentences = "";

		for (String s : filenames) {
//			try {
//
//				String line = "";
//
//				// FileReader reads text files in the default encoding.
//				FileReader fileReader = new FileReader(s);
//
//				// Always wrap FileReader in BufferedReader.
//				BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//				for (line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
//
//					totalSentences += " " + line;
//				}

				addWordsFromFile(s);
		}
				int x = maxNumber();
				wordsInNumFiles(4);

				// Always close files.
//				bufferedReader.close();
//			} catch (FileNotFoundException ex) {
//				System.out.println("Unable to open file '" + filenames + "'");
//			} catch (IOException ex) {
//				System.out.println("Error reading file '" + filenames + "'");
//				// Or we could just do this:
//				// ex.printStackTrace();
//			}
//		}
	}

	public static void printMap() {
		for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
			System.out.println(entry.getKey() + "	" + entry.getValue());
		}
	}

	public static void main(String args[]) {

		// buildWordFileMap();
		tester();
		//System.out.println("the following is PrintMap FUNC:      ");
		//printMap();
		System.out.println("SIZE OF MAP:	"+myMap.size());
		
		if (myMap.containsKey("tree")){
			System.out.println(Arrays.toString(myMap.get("tree").toArray()));
		}
	}
} 
