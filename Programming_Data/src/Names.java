/**
 * Names class
 * This class contains tasks related to the use of the Strings class.
 *
 * @author Dr Suzy Atfield-Cutts adapted from Melanie Coles
 * @since 2020
 */

public class Names {

	// Task 1
    public String upperCaseName(String name) {
        return name.toUpperCase();
	}

	// Task 2
	public String fullName(String firstName, String lastName) {
        return firstName + " " + lastName;
	}

	// Task 3
	public int letterCount(String word) {
		return word.length();
	}

	// Task 4
	public boolean theSameName(String nameOne, String nameTwo) {
		nameOne = nameOne.toUpperCase(); nameTwo = nameTwo.toUpperCase();
		return nameOne.equals(nameTwo);
	}

	// Task 5
	public String properCaseName(String name) {
		String firstLetter = name.substring(0,1).toUpperCase();
		String restOfName = name.substring(1).toLowerCase();
		return firstLetter + restOfName;
	}
}
