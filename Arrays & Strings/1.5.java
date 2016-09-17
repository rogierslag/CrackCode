// Write a method to replace all spaces in a String with %20

class SpaceToEncodedSpace {

	public static char[] encode(char[] string) {
		int numberOfSpaces = 0;
		for(int i = 0; i < string.length; i++) {
			char current = string[i];
			if(current == ' ') {
				numberOfSpaces += 1;
			}
		}
		int newLength = string.length + numberOfSpaces*2;
		char[] outputString = new char[newLength];
		for(int i = 0, j = 0; i < string.length; i++, j++) {
			char current = string[i];
			if(current == ' ') {
				outputString[j] = '%';
				outputString[j+1] = '2';
				outputString[j+2] = '0';
				j += 2; // Since we added two additional characters
			}
			else {
				outputString[j] = current;
			}
		}
		return outputString;
	}

	public static void test(String input) {
		System.out.println("Original='" + input + "'; Output='" + new String(encode(input.toCharArray())) + "'");
	}

	public static void main(String[] args) {
		test("");
		test("x");
		test(" ");
		test("My name is Rogier");
		test("%20");
		test("	");	// tab
		test("  ");	// two spaces
	}
}

// This method traverses the array twice. Consider the amount of characters in the array to be n. It would yield O(n).
// Considering space, we take the space of the original array twice, plus the amount of spaces. We'll define the number
// of spaces to be m. The space complexity then would be O(2n + m). Since the amount of spaces is maximized by n, this
// reduces to O(2n + n) = O(3n) = O(n). 
