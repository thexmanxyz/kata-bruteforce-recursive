/*#######################################################
 #                                                      #
 #   Recursive BruteForce (Java)                        #
 #                                                      #
 #   Purpose: Small Kata project to recursively         #
 #            find / brute force a predefined string.   #
 #                                                      #
 #   Author: Andreas Kar (thex) <andreas.kar@gmx.at>    #
 #   Repository: https://git.io/fAHyK                   #
 #                                                      #
/#######################################################*/

package thex.kata.bf;

import java.util.ArrayList;
import java.util.List;

public class Bruteforce {	
	private final static String ALPHA_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String ALPHA_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private final static String ALPHA_NUMERIC = "0123456789";
	private final static String ALPHA_SPECIAL = " !\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~";
	
	private boolean output = false;
	private boolean store = false;
	
	private final char[] charset;
	private int iterations = 0;
	
	private List<String> passStore = new ArrayList<String>();
	
	public Bruteforce(String charset) {
		this.charset = charset.toCharArray();
	}
	
	public final static Bruteforce getBFAlphaLower(){
		return new Bruteforce(ALPHA_LOWER);
	}
	
	public final static Bruteforce getBFAlphaUpper(){
		return new Bruteforce(ALPHA_UPPER);
	}
	
	public final static Bruteforce getBFNumeric(){
		return new Bruteforce(ALPHA_NUMERIC);
	}
	
	public final static Bruteforce getBFSpecial(){
		return new Bruteforce(ALPHA_SPECIAL);
	}
	
	public final static Bruteforce getBFAlphaNumericUpper(){
		return new Bruteforce(ALPHA_UPPER + ALPHA_NUMERIC);
	}
	
	public final static Bruteforce getBFAlphaNumericLower(){
		return new Bruteforce(ALPHA_LOWER + ALPHA_NUMERIC);
	}
	
	public final static Bruteforce getBFAlphaNumeric(){
		return new Bruteforce(ALPHA_LOWER + ALPHA_UPPER + ALPHA_NUMERIC);
	}
	
	public final static Bruteforce getBFAll(){
		return new Bruteforce(ALPHA_LOWER + ALPHA_UPPER + ALPHA_NUMERIC + ALPHA_SPECIAL);
	}
	
	private char[] bruteRecursive(String searchWord, int maxLength){
		char[] find = new char[0];
		
		// go on as long as max length not reached
		for(int i = 0; i < maxLength; i++){
			find = this.bruteRecursiveInner(searchWord, "", i);
			
			// if result not empty, it must be a find
			if(find.length > 0){
				return find;
			}
		}
		return find;
	}
	
	private char[] bruteRecursiveInner(String searchWord, String currWord, int depth){
		String hWord = "";
		char[] retWord = new char[0];
		
		for(int i = 0; i < charset.length; i++){
			hWord = currWord + charset[i];
			
			// if current depth is not a leaf
			if(depth > 0){
				retWord = this.bruteRecursiveInner(searchWord, hWord, depth-1);
				
				// don't wait on other results if accordance found
				if(retWord.length > 0)
					return retWord;
				
			// current depth is leaf
			}else if(depth == 0){
				
				// update iterations
				this.iterations++;
				
				// handle output
				if(output){
					System.out.println(hWord);
				}
				
				// handle storage
				if(store){
					passStore.add(hWord);
					
				// check if search word equals current word 
				} else if(hWord.equals(searchWord)){
					return hWord.toCharArray();
				}
			}
		}
		return retWord;
	}
	
	
	public void find(String word, int maxLength){
		long startTime = System.currentTimeMillis();
		String find = "";
		
		// reset iterations on reuse
		this.iterations = 0;
		
		// start the brute forcing
		find = new String(bruteRecursive(word, maxLength));
		
		// output on result
		System.out.println("Time needed: " + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println("Iterations required: " + iterations);
		
		// no output on store because no matching took place
		if(!store){
			if(word.equals(find))
			    System.out.println("Password: " + find);
			else
			    System.out.println("Password not found!");
		}
	}
	
	public void setOutput(boolean output){
		this.output = output;
	}
	
	public void setStore(boolean store){
		this.store = store;
	}
	
	public List<String> getPassStore(){
		return this.passStore;
	}
}
