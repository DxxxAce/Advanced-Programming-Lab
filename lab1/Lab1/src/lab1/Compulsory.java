package lab1;

//Author: Hirtopanu Tudor-Alin
public class Compulsory {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
		
		int n = (int) (Math.random() * 1_000_000);	
		n *= 3;
		n += Integer.parseInt("10101", 2);
		n += Integer.parseInt("FF", 16);
		n *= 6;
		
		int result = n, copy;
		while (result > 9) {
			copy = result;
			result = 0;
			
			while (copy != 0) {
				result += copy % 10;
				copy /= 10;
			}
		}
		
		System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
	}
}
