// Write a method to decide if two strings are anagrams or not 

class Anagrams {

	public static int ALLOWED_ASCII_CHARACTER_RANGE = 256;

	public static boolean isAnagram(String left, String right) {
		if(left == null || right == null) {
			// I consider null values as always unequal here
			return false;
		}
	
		if(left.length() != right.length()) {
			return false;
		}

		int[] occurrenceTable = new int[ALLOWED_ASCII_CHARACTER_RANGE];
		for( int i = 0; i < left.length(); i++) {
			int currentChar = left.charAt(i);
			occurrenceTable[currentChar]++;
		}
		for( int i = 0; i < right.length(); i++) {
			int currentChar = right.charAt(i);
			occurrenceTable[currentChar]--;
		}

		// If they are anagrams, all occurrences should be 0
		for( int i = 0; i < occurrenceTable.length; i++) {
			if ( occurrenceTable[i] != 0 ) {
				return false;
			}
		}
		return true;
	}

	public static void test(String s1, String s2) {
		System.out.println("1='" + s1 + "'; 2='" + s2 + "'; isAnagram=" + isAnagram(s1, s2));
	}

	public static void main(String[] args) {
		test("lepel", "peell");
		test("a","b");
		test("a","a");
		test("apa","paa");
		test("","");
		test(null, "rogier");
		test("Rogierisgaaf", "Rogierisheelgaaf");
	}

}

// With one string being of length n and the other of length m, we see that we only perform any computation
// if those are equal. Hence n = m. We traverse both strings. We also have a table with the size of all
// allowed ASCII characters (we'll call that l). Hence we go through O(n+m+l) = O(2n+m) which reduces to O(n+m).
// The space complexity is purely determined by the table, hence O(m)
