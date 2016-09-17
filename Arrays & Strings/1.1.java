// Imprement an algorithm to determine if a string has all unique characters.

class AllUniqueCharacters {

	// Might vary depending on what you need exactly
	public static int ALLOWED_CHARACTERS_FROM_ASCII = 256;

	public static boolean allUnique(char[] string) {
		if ( string.length == 0) {
			// Do you consider this a special case?
		}
		boolean[] seen = new boolean[ALLOWED_CHARACTERS_FROM_ASCII];
		for(int i = 0; i < string.length; i++) {
			int currentValue = string[i];
			if ( seen[currentValue] ) {
				// We did see this character before
				return false;
			}
			seen[currentValue] = true;
		}
		// We did not see any duplicates
		return true;
	}

	public static void test(String input) {
		System.out.println("Input='" + input + "'; isUnique=" + allUnique(input.toCharArray()));
	}

	public static void main(String[] args) {
		test("");
		test("a");
		test("ab");
		test("aa");
		test("abab");
		test("aabb");
	}
}

// We traverse the array once at most, so the time complexity is O(n) where n is the length of the input.
// With m equal to the number of allowed ascii characters, we allocate an array of that size. Space
// complexity is the O(m)
