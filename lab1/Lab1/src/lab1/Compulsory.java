//Author: Hirtopanu Tudor-Alin (2E1)
package lab1;

public class Compulsory {

	static void println(String text) {
		
		System.out.println(text);
	}
	
	static int computeResult(int n) {
		
		n *= 3;
		n += Integer.parseInt("10101", 2);
		n += Integer.parseInt("FF", 16);
		n *= 6;
		
		return n;
	}
	
	static int computeDigitsSum(int n) {
		
		int copy;
		
		while (n > 9) {
			
			copy = n;
			n = 0;
			
			while (copy != 0) {
				
				n += copy % 10;
				copy /= 10;
			}
		}
		
		return n;
	}
	
	public static void main(String[] args) {
		
		println("Hello World!");

		String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};		
		int n = (int) (Math.random() * 1_000_000);

		int result;
		result = computeResult(n);
		result = computeDigitsSum(result);
		
		println("Willy-nilly, this semester I will learn " + languages[result] + ".");
	}
}
