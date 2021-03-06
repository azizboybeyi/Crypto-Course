import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class wordFrequencies {

	private static ArrayList<String> myWords = new ArrayList<String>();
	private static ArrayList<Integer> myFreqs = new ArrayList<Integer>();
	private static ArrayList<String> example;

	public wordFrequencies() {
		myWords = new ArrayList<String>();
		myFreqs = new ArrayList<Integer>();
	}

	public static void findUnique(String fileName) {
		// myWords.clear();
		// myFreqs.clear();

		// This will reference one line at a time
		String line = null;
		// String firstWord = null;

		// wordFrequencies wf = new wordFrequencies();

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// while ((line = bufferedReader.readLine()) != null) {
			for (line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
				// System.out.println(line); //what does your function do? we
				// need to fill the while loop - do it. it is long

				// System.out.println("before replacing numbers: " + line);
				// //what does your function do? we need to fill the while loop
				// - do it. it is long
				// line = line.replaceAll("\\d", "");

				// System.out.println("after replacing: " + line);

				line = line.trim();
				line = line.toLowerCase();

				// System.out.println("after trimming: " + line);
				if (!line.isEmpty()) {

					String[] words = line.split("\\s+");
					for (int k = 0; k < words.length; k++) {
						String str = words[k]; // .trim();
						// System.out.println(words[k]);

						if (!myWords.contains(str)) {

							myWords.add(str);
							myFreqs.add(1);
						} else {
							int val = myFreqs.get(myWords.indexOf(str));
							myFreqs.set(myWords.indexOf(str), val + 1);

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
		System.out.println(Arrays.toString(myWords.toArray()));
		System.out.println(Arrays.toString(myFreqs.toArray()));
		System.out.println(myWords.size());

	}

	public static void tester(String fileName) {
		// String fileName;

		findUnique(fileName);

		System.out.println("number of unique words is: " + myWords.size());
		for (int k = 0; k < myWords.size(); k++) {
			// System.out.println(myWords.get(k) + " " + myFreqs.get(k));
		}
		int idx = findIndexOfMax();
		System.out.println("the word that occurs the most is: " + myWords.get(idx) + " -it occured: " + myFreqs.get(idx)
				+ " time(s)");
	}

	public static int findIndexOfMax() {
		int currVal = Integer.MIN_VALUE;
		int indexOfMax = 0;
		for (int k = 0; k < myFreqs.size(); k++) {
			if (myFreqs.get(k) > currVal) {
				currVal = myFreqs.get(k);
				indexOfMax = k;
			}
		}
		return indexOfMax;
	}

	public static void main(String[] args) {
		tester("errors.txt");
	}

}

// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Scanner;
//
// public class wordFrequencies {
//
// private static ArrayList<String> myWords;
// private static ArrayList<Integer> myFreqs;
//
// public wordFrequencies() {
// myWords = new ArrayList<String>();
// myFreqs = new ArrayList<Integer>();
// }
//
//// public static void findUnique(String fileName) {
//// // myWords.clear();
//// // myFreqs.clear();
////
//// wordFrequencies wf = new wordFrequencies();
////
//// Scanner input = new Scanner(fileName); //Scanner object
//// int count = 0; //current position in file
//// while (input.hasNext()) { //loops until no items remain
//// String line = input.nextLine();
//// System.out.println(line);
//// String word = input.next(); //reads next item in file, delimitted by space
//// System.out.println(word);
////
//// if(!myWords.contains(word)){ //if array list doesnt already contain this
// word
//// myWords.add(count, word); //adds word at index count
//// myFreqs.add(count, 1); //first time being added
//// }
//// else{
//// int elementPos = myWords.indexOf(word);
//// int inc = myFreqs.get(elementPos)+1; //increment frequency
//// myFreqs.set(elementPos, inc); //replace array list at same position with
// new frequency value
//// }
//// count++;
//// }
////
//// input.close();
////
//// }
//
//
// public static void tester (String fileName){
// //String fileName;
//
// findUnique(fileName);
//
// System.out.println("number of unique words is: " + myWords.size());
// for (int k=0; k < myWords.size(); k++){
// System.out.println(myWords.get(k) + myFreqs.get(k));
// }
// int idx = findIndexOfMax();
// System.out.println("the word that occurs the most is: " + myWords.get(idx) +
// "it occured: " + myFreqs.get(idx) + "times");
// }
//
//
// public static int findIndexOfMax(){
// int currVal = Integer.MIN_VALUE;
// int indexOfMax = 0;
// for (int k=0; k < myFreqs.size(); k++){
// if (myFreqs.get(k) > currVal ){
// currVal = myFreqs.get(k);
// indexOfMax = k;
// }
// } return indexOfMax;
// }
//
// public static void main (String[] args){
// tester ("errors.txt");
// }
//
// }
