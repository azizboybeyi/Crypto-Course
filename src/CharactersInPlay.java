import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CharactersInPlay {

	private static ArrayList<String> names = new ArrayList<String>();
	private static ArrayList<Integer> numLines = new ArrayList<Integer>();

	public CharactersInPlay() {
		names = new ArrayList<String>();
		numLines = new ArrayList<Integer>();
	}

	public static void update(String person) {

		// CharactersInPlay CIP = new CharactersInPlay();

		if (!names.contains(person)) {
			names.add(person);
			numLines.add(1);
		} else {
			int val = numLines.get(names.indexOf(person));
			numLines.set(names.indexOf(person), val + 1);

		}
	}

	public static void findAllCharacters(String fileName) {

		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// while ((line = bufferedReader.readLine()) != null) {
			for (line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
				// System.out.println(line); //what does your function do? we

				line = line.trim();

				if (!line.isEmpty()) {
					if (line.contains(".")) {
						int posOfFS = line.indexOf(".");
						String name = line.substring(0, posOfFS);

						update(name);
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
	}

	public static void tester() {
		findAllCharacters("errors.txt");

		for (int k = 0; k < names.size(); k++) {
			if (numLines.get(k) > 1) {
				// System.out.println(names.get(k) + " " + numLines.get(k));
			}
		}
		charactersWithNumParts(10, 15);

	}

	public static void charactersWithNumParts(int num1, int num2) {
		for (int k = 0; k < names.size(); k++) {
			if (numLines.get(k) >= num1 && numLines.get(k) <= num2) {
				System.out.println(names.get(k) + " " + numLines.get(k));
			}
		}
	}

	public static int maxIndex() {
		int currVal = Integer.MIN_VALUE;
		int indexOfMax = 0;
		String mostSpeaking = "";
		for (int k = 0; k < numLines.size(); k++) {
			if (numLines.get(k) > currVal       && numLines.get(k) < 100) {
				currVal = numLines.get(k);
				indexOfMax = k;
				mostSpeaking = names.get(indexOfMax);
			}
		}
		System.out.println(mostSpeaking + "		" + currVal);
		return indexOfMax;
	}

	public static void main(String args[]) {
		tester();
		maxIndex();
		System.out.println(names.toString());
		System.out.println(numLines.toString());

//		Collections.sort(numLines);
//		for (int counter : numLines) {
//			System.out.println(counter);
//		}

		
	}

}
