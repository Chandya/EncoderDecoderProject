package implementations;

import interfaces.Decoder;
import utils.exceptions.InvalidTextException;

/**
 * Encapsulation: Each class (TextEncoder, TextDecoder) encapsulates its own logic and data. 
 * For example, TextDecoder encapsulates the decoding logic.
 * 
 * Polymorphism: You leverage polymorphism when you create instances of TextEncoder and TextDecoder 
 * and use them through their interfaces (Encoder and Decoder). 
 * This enables you to interchange different encoding and decoding strategies.
 * 
 * Single Responsibility Principle (SRP): Each class has a single responsibility. 
 * For example, TextEncoder is responsible for encoding, 
 * TextDecoder is responsible for decoding.
 */

// Implementation of the Decoder interface
public class TextDecoder implements Decoder {
    private final String referenceTable;

    public TextDecoder(String referenceTable) {
        this.referenceTable = referenceTable;
    }

    @Override
    public String decode(String encodedText) throws InvalidTextException {

        if (encodedText.isEmpty() || referenceTable.indexOf(encodedText.charAt(0)) == -1) {
            throw new InvalidTextException("Invalid Encoded Text");
        }

        StringBuilder decodedText = new StringBuilder();
        char offsetChar = encodedText.charAt(0);
        encodedText = encodedText.substring(1);

        // Find the index of the offset character in the reference table
        int offsetIndex = referenceTable.indexOf(offsetChar);

        for (char c : encodedText.toCharArray()) {
            int index = referenceTable.indexOf(c);

            if (index != -1) {
                // Reverse the shift based on the offset
                int shiftedIndex = (index + offsetIndex) % referenceTable.length();
                decodedText.append(referenceTable.charAt(shiftedIndex));
            } else {
                // Character not in the reference table, keep it as is
                decodedText.append(c);
            }
        }

        return decodedText.toString();
    }
}
