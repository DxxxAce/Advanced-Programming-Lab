//Author: Hirtopanu Tudor-Alin (2E1)
package lab1;
import java.util.Arrays;
import java.util.Random;

public class Homework {
	
	public static void print(String text) {
		
		System.out.println(text);
	}	
	
	public static void validateArguments(String[] args) {
		
		
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
			
			System.out.println(words[i]);
		}
	}

	public static void initNeighbors(int size, boolean[][] neighbors) {
		
			for (int i = 0; i < size; i++) {
			
				Arrays.fill(neighbors[i], false);
		}
	}
	
	public static void linkNeighbors(int size, int length, char[] alphabet, String[] words, boolean[][] neighbors) {
		
		char[] aux = new char[length];
		int k;
		boolean accept;
		
		for (int i = 0; i < size; i++) {
			
			neighbors[i][i] = true;
			k = 0;
			accept = false;
			
			for(int j = i + 1; j < size; j++) {
				
				while (k < length && !accept) {
					
					
				}
			}
				
		}
	}
	
	public static void main(String[] args) {
		
		validateArguments(args);
		
		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);
		
		int m = args.length - 2;
		char[] C = new char[m];
		
		int i, j;
		
		for (i = 2; i < args.length; i++) {
			
			C[i - 2] = args[i].charAt(0);
		}
		
		String[] words = new String[n];
		generateWords(n, p, words, C);
		printWords(n, words);
		
		boolean[][] neighbors = new boolean[n][n];
		initNeighbors(n, neighbors);
		linkNeighbors(n, p, C, words, neighbors);
		
	}
}
