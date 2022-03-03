//Author: Hirtopanu Tudor-Alin (2E1)
package lab1;
import java.util.Random;

public class Homework {
	
	//constant representing the minimum number of arguments for program to run
	static final int MIN_ARGS = 3;
	
	//print text faster
	static void print(String text) {
		
		System.out.print(text);
	}
	
	//print text faster (with end of line)
	static void println(String text) {
		
		System.out.println(text);
	}	
	
	//method that returns the time of its calling
	static long getCurrentTime() {
		
		return System.nanoTime();
	}
	
	//check if a string is numeric
	static boolean isNumeric(String string) {
		
		//use exception handling so the program doesn't terminate prematurely
		try {
			
			//attempt string to integer conversion
	        Integer.parseInt(string);
	        return true;
	    }
		catch (NumberFormatException e) {
			
	        return false;
	    }
	}
	
	//check if the arguments respect the specified constraints
	static boolean validateArguments(String[] args) {
		
		//check that the number of arguments is large enough
		if (args.length < MIN_ARGS) {
			
			println("The program needs at least 3 arguments to run.");
			return false;
		}
		
		//check that the first argument is an integer
		if (!isNumeric(args[0])) {
			
			println("First argument has to be an integer.");
			return false;
		}
		
		//check that the second argument is an integer
		if (!isNumeric(args[1])) {
			
			println("Second argument has to be an integer.");
			return false;
		}
		
		//check that all other arguments are single characters
		for (int i = 2; i <  args.length; i++) {
			
			if (args[i].length() != 1) {
				
				println("All arguments excepting the first two have to be single characters.");
				return false;
			}
		}
		
		return true;
	}
	
	//store character arguments into char array
	static void createAlphabetArray(int size, char[] alphabet, String[] source) {
		
		for (int i = 2; i < source.length; i++) {
			
			alphabet[i - 2] = source[i].charAt(0);
		}
	}
	
	//use the array of characters to randomly generate words
	static void generateWords(int size, int length, String[] words, char[] alphabet) {
		
		Random rand = new Random();
		int selectChar;
		
		for (int i = 0; i < size; i++) {
			
			//initialize word to get rid of null character
			words[i] = "";
			
			for (int j = 0; j < length; j++) {
				
				//select random character from the alphabet and add it to the word
				selectChar = rand.nextInt(alphabet.length);
				words[i] += alphabet[selectChar];
			}
		}
	}
	
	//print each generated word on a separate line
	static void printWords(int size, String[] words) {
		
		for (int i = 0; i < size; i++) {
			
			println(words[i]);
		}
	}

	//check if two words have any common character
	static boolean checkForCommonChar(String s1, String s2) {
		
		for (int i = 0; i < s1.length(); i++) {
			
			for (int j = 0; j < s2.length(); j++) {
				
				if (s1.charAt(i) == s2.charAt(j)) {
				
					return true;
				}
			}
		}
		
		return false;
	}

	//create boolean type array that representing the adjacency relation of the generated words
	static void linkNeighbors(int size, String[] words, boolean[][] neighbors) {

		for (int i = 0; i < size; i++) {
			
			//link word to itself (technically speaking it satisfies the adjacency condition)
			neighbors[i][i] = true;
			
			for(int j = i + 1; j < size; j++) {
				
				//link each of the words to the other in the array if the adjacency condition is satisfied
				neighbors[i][j] = neighbors[j][i] = checkForCommonChar(words[i], words[j]);
			}
				
		}
	}
	
	//create an array type data structure that stores each word's neighbors
	static void createNeighborsDataStruct(int size, String[] source, boolean[][] link, String[][] dataStruct) {
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				//check whether the two words are neighbors
				if (!link[i][j]) {
					
					//add null to data structure if false
					dataStruct[i][j] = null;
				}
				else {
					
					//add neighboring word to data structure if true
					dataStruct[i][j] = source[j];
				}
			}
		}
	}
	
	//print out the data structure
	static void printNeighborsDataStruct(int size, String[][] dataStruct) {
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				print(dataStruct[i][j] + " ");
			}
			
			println("");
		}
	}
	
//	//find the maximum number of consecutive neighbors of a specific word
//	static int maxConsecutiveNeighborsOfWord(int size, boolean[] neighbors) {
//		
//		int count = 0, i = 0;
//		boolean link;
//		
//		do {
//			
//			link = neighbors[i++];
//		}
//		while (!link);
//		
//		int currentCount = 1;
//		
//		for (i = 0; i < size; i++) {
//            
//            if (i < size - 1 && neighbors[i+1]) {
//            
//            	currentCount++;
//            }
//            else {
//            	
//                if (currentCount > count) {
//                	
//                    count = currentCount;
//                }
//                
//                currentCount = 1;
//            }
//        }
//		
//        return count;
//    }
//	
//	//find the maximum number of consecutive neighbors overall
//	static int maxConsecutiveNeighbors(int size, boolean[][] neighbors) {
//		
//		int count = 0;
//		
//		for (int i = 0; i < size; i++) {
//			
//			count = Math.max(count, maxConsecutiveNeighborsOfWord(size, neighbors[i]));
//		}
//		
//		return count;
//	}
//	
//	//find number of neighbors for a specific word
//	static int getWordDegree(int size, boolean[] neighbors) {
//		
//		int degree = 0;
//		
//		//increment the degree for each of the word's neighbors
//		for (int i = 0; i < size; i++) {
//			
//			if (neighbors[i]) {
//				
//				degree++;
//			}
//		}
//		
//		return degree;
//	}
//	
//	//find maximum number of neighbors of the words
//	static int getMaxDegreeWord(int size, boolean[][] neighbors) {
//		
//		int currentDegree, maxDegree = 0;
//		int maxDegreeWord = 0;
//		
//		//update the maximum degree node each time a larger one is found
//		for (int i = 0; i < size; i++) {
//			
//			currentDegree = getWordDegree(size, neighbors[i]);
//			if (currentDegree > maxDegree) {
//				
//				maxDegree = currentDegree;
//				maxDegreeWord = i;
//			}
//		}
//		
//		return maxDegreeWord;
//	}
	
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
			
			long startTime, finishTime;
			
			startTime = getCurrentTime();
			createNeighborsDataStruct(n, words, neighbors, neighborsDataStruct);
			finishTime = getCurrentTime();
			
			println("The data structure is too large to be displayed on screen.");
			println("Construction time: " + (finishTime - startTime) + " nanoseconds.");
		}
		else {
			
			createNeighborsDataStruct(n, words, neighbors, neighborsDataStruct);
			printNeighborsDataStruct(n, neighborsDataStruct);
//			println("The maximum number of consecutive neighboring words is " + maxConsecutiveNeighbors(n, neighbors) + ".");
		}
	}
}
