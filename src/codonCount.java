import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class codonCount {

	private static HashMap<String, Integer> myMap;

	public codonCount() {
		myMap = new HashMap<String, Integer>();
	}

	public static void buildCodonMap(int start, String dna) {
		// need to read the files and then read the string

		myMap.clear();

		for (int k = start; (dna.length() - k) >= 3; k += 3) {
			// System.out.println(k);
			String codon = dna.substring(k, k + 3);
			System.out.println("Codon is:   " + codon);

			if (codon.length() == 3) {

				if (!myMap.containsKey(codon)) {
					myMap.put(codon, 1);
					// printMap();
				} else {
					myMap.put(codon, myMap.get(codon) + 1);
					// printMap();
				}
			}
			// printMap();
		}
	}

	public static String getMostCommonCodon() {

		// printMap();

		String mostCommon = "";
		int currMaxVal = Integer.MIN_VALUE;
		System.out.println(" CHECK 1");
		for (HashMap.Entry<String, Integer> entry : myMap.entrySet()) {
			System.out.println("FOR LOOP CHECK 1");

			// printMap();

			if (entry.getValue() > currMaxVal) {

				// printMap();

				System.out.println("IF LOOP CHECK 1");
				currMaxVal = entry.getValue();
				mostCommon = entry.getKey();
				System.out.println("IF LOOP CHECK 2");

				// printMap();
			}
			// printMap();

			System.out.println("FOR LOOP CHECK 1");
		}
		// printMap();

		System.out.println("Most Common Codon: " + mostCommon + "\t" + "     Count: " + myMap.get(mostCommon));
		return mostCommon;
	}

	public void printCodonCounts(int start, int end) {

		// printMap();

		for (HashMap.Entry<String, Integer> entry : myMap.entrySet()) {

			// printMap();

			if (entry.getValue() >= start && entry.getValue() <= end) {
				System.out.println("Codon: " + entry.getKey() + "t/" + entry.getValue());
			}
		}
	}

	public static void tester(String fileName, int start, int end) {
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// while ((line = bufferedReader.readLine()) != null) {
			for (line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
				// System.out.println(line); //what does your function do? we
				// need to fill the while loop - do it. it is long

				line.toUpperCase();
				line.trim();

				codonCount cc = new codonCount();

				for (int k = 0; k < 3; k++) {
					int x = k;
					System.out.println(x);
					System.out.println(line);

					cc.buildCodonMap(x, line);
					cc.getMostCommonCodon();
					// cc.printCodonCounts(start, end);

					System.out.println("-------------------------------------------------------------");
					System.out.println("myMap: ");
					printMap();
					System.out.println("-------------------------------------------------------------");

				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	public static void printMap() {
		for (HashMap.Entry<String, Integer> entry : myMap.entrySet()) {
			System.out.println("MAP KEY: " + entry.getKey() + "\t" + "MAP VALUE: " + entry.getValue());
		}
	}

	public static void main(String args[]) {
		tester("dnaMystery2.txt", 1, 5);
		// getMostCommonCodon();
		// printMap();
	}
}
