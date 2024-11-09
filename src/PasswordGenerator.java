import java.util.Random;

/**
 * The PasswordGenerator class provides functionality to generate random passwords
 * based on user-defined criteria, such as including uppercase letters, lowercase letters,
 * numbers, and special symbols. This class serves as the backend component in
 * a password generation application.
 */
public class PasswordGenerator {

    // Character pools for password generation
    /** String containing lowercase alphabet characters. */
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    /** String containing uppercase alphabet characters. */
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /** String containing numeric characters from 0 to 9. */
    public static final String NUMBERS = "0123456789";
    /** String containing special symbol characters. */
    public static final String SPECIAL_SYMBOLS = "`~!@#$%^&*()_+=-[]{}'?/.,<>";

    // Random number generator for selecting characters
    /** Instance of Random used to generate random indices for selecting characters. */
    private final Random random;

    /**
     * Constructor for PasswordGenerator.
     * Initializes the Random instance for generating random characters.
     */
    public PasswordGenerator() {
        random = new Random();
    }

    /**
     * Generates a random password based on the specified criteria.
     *
     * @param length            the desired length of the password
     * @param includeUppercase  whether to include uppercase letters in the password
     * @param includeLowercase  whether to include lowercase letters in the password
     * @param includeNumbers    whether to include numeric characters in the password
     * @param includeSpecialSymbols whether to include special symbols in the password
     * @return a randomly generated password as a String
     */
    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                   boolean includeNumbers, boolean includeSpecialSymbols) {
        // Use StringBuilder for efficient password construction
        StringBuilder passwordBuilder = new StringBuilder();

        // String that accumulates all valid characters based on user criteria
        String validCharacters = "";
        if (includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if (includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if (includeNumbers) validCharacters += NUMBERS;
        if (includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        // Main loop to build the password character by character
        for (int i = 0; i < length; i++) {
            // Generate a random index within the valid characters
            int randomIndex = random.nextInt(validCharacters.length());

            // Retrieve a character from validCharacters at randomIndex
            char randomChar = validCharacters.charAt(randomIndex);

            // Append the randomly selected character to passwordBuilder
            passwordBuilder.append(randomChar);

            // Repeat this process until the desired password length is achieved
        }

        // Return the complete password as a String
        return passwordBuilder.toString();
    }
}

