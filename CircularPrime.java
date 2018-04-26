/*
 * *NOTE*
 * This program should not be used with large inputs (larger than about 200,000).
 *
 * Java program to determine all circular primes up to a given input
 * A circular prime is defined as a number such that all of its cycles are also prime
 * The definition of a cycle is also given below
 * 
 * @author: Sam Kravitz
 */
import java.util.*;

public class CircularPrime {
	
	/*
	 *  Gets all cycles of a string input (will be an integer represented as a String)
	 *  A cycle of a number is any number formed by taking the first digit
	 *  of the number and placing it at the end of that number.
	 *  
	 *  The cycles of the number 1297:
	 *  1297
	 *  2971
	 *  9712
	 *  7129
	 *  
	 *  @param: the String to find all cycles 
	 */
	public static ArrayList<String> getCycles(String n) {
		
		ArrayList<String> numCycles = new ArrayList<String>();
	
		if(n.length() == 1) {
			numCycles.add(n);
			return numCycles;
		}
		
		for(int i = 0; i < n.length(); i++) {
			String firstLetter = n.substring(0, 1);
			n = n.substring(1) + firstLetter;
			numCycles.add(n);
		}
		
		return numCycles;
	}
	
	
	/*
	 * determines if a number is prime
	 * @param: the number to determine its primalty
	 */
	public static boolean isPrime(int n) {
		
		if(n == 0 || n == 1) {
			return true;
		}
		
		for(int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
	
	/*
	 * determines if a number is a circular prime
	 * @param: an ArrayList of permutations of a number
	 */
	public static boolean isCircularPrime(ArrayList<String> perms) {
		
		for(String num : perms) {
			int current = Integer.parseInt(num);
			
			if(! isPrime(current)) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("To use: java CircularPrime [int]");
			System.exit(0);
		}
	
		int goal = Integer.parseInt(args[0]);
		
		for(int i = 0; i <= goal; i++) {
			ArrayList<String> cyclesOfCurrent = getCycles(Integer.toString(i));
			
			if(isCircularPrime(cyclesOfCurrent)) {
				System.out.println(i + " is a circular prime");
			}
		}
	}
}
