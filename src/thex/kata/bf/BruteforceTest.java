/*#######################################################
 #                                                      #
 #   Kata - Recursive Bruteforce                        #
 #                                                      #
 #   Purpose: Small Kata project to recursively         #
 #            find / bruteforce a predefined string.    #
 #                                                      #
 #   Author: Andreas Kar (thex) <andreas.kar@gmx.at>    #
 #   Repository: https://git.io/fAHyK                   #
 #                                                      #
/#######################################################*/

package thex.kata.bf;

public class BruteforceTest {

	private final static String WORD = "+#xy";
	private final static int MAX_LENGTH = 4;
	
	public static void main(String[] args) {
		System.out.println("Start Recursive Bruteforce:");
		Bruteforce bf = Bruteforce.getAllChars();
		bf.find(WORD, MAX_LENGTH);
	}
}
