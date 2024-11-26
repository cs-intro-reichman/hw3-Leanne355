import javax.print.DocFlavor.STRING;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String Word1 = preProcess(str1);
		String Word2 = preProcess(str2);
		int counter1;
		int counter2;
		String Letters = "abcdefghijklmnopqrstuvwxyz";
		int x = 0;
		boolean anagram = false;
		while (x < 26) {
			counter1 = 0;
			counter2 = 0;
			for (int i = 0; i < Word1.length(); i++) {
				if (Letters.charAt(x) == Word1.charAt(i)) {
					counter1++;
				}
			}
				for (int j = 0; j < Word2.length(); j++) {
					if (Letters.charAt(x) == Word2.charAt(j)) {
						counter2++;
					}
				}
					if (counter1 == counter2) {
						anagram = true;
						x++;
					} else {
						anagram = false;
						x = Letters.length();
					}
				}
		return anagram;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String NewStr = "";
		String Letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char Char;
		for (int i = 0; i < str.length(); i++) {
			Char = str.charAt(i);
			if (Letters.indexOf(Char) != -1) {
				NewStr = NewStr + Char;
			} else {
				if (Char == ' ') {
					NewStr = NewStr + Char;
				}
			}
		}
		NewStr = NewStr.toLowerCase();
		return NewStr;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		String anagram = ""; 
		double r;
		int charNum;
		while(str.length() > 0){
		r = Math.random();
		charNum = (int) (r * (str.length() -1));
		anagram = anagram + str.charAt(charNum);
		str = str.replace(Character.toString(str.charAt(charNum)), "");
		}
		return anagram;
	}
}
