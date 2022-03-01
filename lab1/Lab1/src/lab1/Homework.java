//Author: Hirtopanu Tudor-Alin (2E1)
package lab1;
import java.util.Random;

public class Homework {
	
	public static void print(String text) {
		
		System.out.print(text);
	}
	
	public static void println(String text) {
		
		System.out.println(text);
	}	
	
	public static boolean isNumeric(String string) {
		
		try {
			
	        Integer.parseInt(string);
	        return true;
	    }
		catch (NumberFormatException e) {
			
	        return false;
	    }
	}
	
	public static boolean validateArguments(String[] args) {
		
		if (args.length < 3) {
			
			println("The program needs at least 3 arguments to run.");
			return false;
		}
		
		if (!isNumeric(args[0])) {
			
			println("First argument has to be an integer.");
			return false;
		}
		
		if (!isNumeric(args[1])) {
			
			println("Second argument has to be an integer.");
			return false;
		}
		
		for (int i = 2; i <  args.length; i++) {
			
			if (args[i].length() != 1) {
				
				println("All arguments excepting the first two have to be single characters.");
				return false;
			}
		}
		
		return true;
	}
	
	public static void createAlphabetArray(int size, char[] alphabet, String[] source) {
		
		for (int i = 2; i < source.length; i++) {
			
			alphabet[i - 2] = source[i].charAt(0);
		}
	}
	
	public static void generateWords(int size, int length, String[] words, char[] alphabet) {
		
		Random rand = new Random();
		int select;
		
		for (int i = 0; i < size; i++) {
			
			words[i] = "";
			
			for (int j = 0; j < length; j++) {
				
				select = rand.nextInt(alphabet.length);
				words[i] += alphabet[select];
			}
		}
	}
	
	public static void printWords(int size, String[] words) {
		
		for (int i = 0; i < size; i++) {
			
			println(words[i]);
		}
	}

	public static boolean checkForCommonChar(String s1, String s2) {
		
		for (int i = 0; i < s1.length(); i++) {
			
			for (int j = 0; j < s2.length(); j++) {
				
				if (s1.charAt(i) == s2.charAt(j)) {
				
					return true;
				}
			}
		}
		
		return false;
	}

	public static void linkNeighbors(int size, String[] words, boolean[][] neighbors) {

		for (int i = 0; i < size; i++) {
			
			neighbors[i][i] = true;
			
			for(int j = i + 1; j < size; j++) {
				
				neighbors[i][j] = neighbors[j][i] = checkForCommonChar(words[i], words[j]);
			}
				
		}
	}
	
	public static void createNeighborsDataStruct(int size, String[] source, boolean[][] link, String[][] dataStruct) {
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				if (!link[i][j]) {
					
					dataStruct[i][j] = null;
				}
				else {
					
					dataStruct[i][j] = source[j];
				}
			}
		}
	}
	
	public static void printNeighborsDataStruct(int size, String[][] dataStruct) {
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				print(dataStruct[i][j] + " ");
			}
			
			println("");
		}
	}
	
	public static void main(String[] args) {
		
		if (!validateArguments(args)) {
			
			return;
		}
		
		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);
		
		int m = args.length - 2;
		char[] C = new char[m];
		createAlphabetArray(m, C, args);
		
		String[] words = new String[n];
		generateWords(n, p, words, C);
		printWords(n, words);
		
		boolean[][] neighbors = new boolean[n][n];
		linkNeighbors(n, words, neighbors);
		
		String[][] neighborsDataStruct = new String[n][n];
		
		if (n > 30_000) {
			
		}
		else {
			
			createNeighborsDataStruct(n, words, neighbors, neighborsDataStruct);
			printNeighborsDataStruct(n, neighborsDataStruct);
		}
	}
}
