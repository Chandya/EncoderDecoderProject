package implementations;

import interfaces.Encoder;
import utils.exceptions.InvalidOffsetCharacterException;
import utils.exceptions.InvalidTextException;

/**
 * Encapsulation: Each class (TextEncoder, TextDecoder) encapsulates its own
 * logic and data.
 * For example, TextEncoder encapsulates the encoding logic.
 */

// Implementation of the Encoder interface
public class TextEncoder implements Encoder {
    private final String referenceTable;

    public TextEncoder(String referenceTable) {
        this.referenceTable = referenceTable;
    }

    @Override
    public String encode(String plainText, char offsetChar)
            throws InvalidOffsetCharacterException, InvalidTextException {

        if (plainText.isEmpty()) {
            throw new InvalidTextException("Invalid Plain Text");
        }

        if (referenceTable.indexOf(offsetChar) == -1) {
            throw new InvalidOffsetCharacterException("Invalid offset character");
        }
        StringBuilder encodedText = new StringBuilder();
        encodedText.append(offsetChar);

        // Find the index of the offset character in the reference table
        int offsetIndex = referenceTable.indexOf(offsetChar);

        for (char c : plainText.toCharArray()) {
            int index = referenceTable.indexOf(c);

            if (index != -1) {
                int refTableLen = referenceTable.length();
                // Shift the index based on the offset
                int shiftedIndex = (index - offsetIndex + refTableLen) % refTableLen;
                encodedText.append(referenceTable.charAt(shiftedIndex));
            } else {
                // Character not in the reference table, keep it as is
                encodedText.append(c);
            }
        }

        return encodedText.toString();
    }
}
