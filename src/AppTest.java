import implementations.TextDecoder;
import implementations.TextEncoder;
import interfaces.Decoder;
import interfaces.Encoder;
import main.EncoderDecoder;
import utils.enums.ReferenceTable;
import utils.exceptions.InvalidOffsetCharacterException;
import utils.exceptions.InvalidTextException;

public class AppTest {

    public static void test1() {
        ReferenceTable referenceTable = ReferenceTable.CUSTOM;
        Encoder encoder = new TextEncoder(referenceTable.getTable());
        Decoder decoder = new TextDecoder(referenceTable.getTable());
        EncoderDecoder encoderDecoder = new EncoderDecoder(encoder, decoder);
        char offsetChar = 'F';
        String plainText = "HELLO WORLD";

        // Encode the plaintext
        String encodedText;
        try {
            encodedText = encoderDecoder.encode(plainText, offsetChar);

            // Encode the plain text
            System.out.println("Encoded: " + encodedText);
            // Decode the encoded text
            String decodedText = encoderDecoder.decode(encodedText);
            System.out.println("Decoded: " + decodedText);

            // Add assertions to validate the results
            if ("FC/GGJ RJMG.".equals(encodedText) && plainText.equals(decodedText)) {
                System.out.println("Test1 Passed: Encode with F");
            } else {
                System.out.println("Test Failed: Encode with F");
            }
        } catch (InvalidOffsetCharacterException e) {
            System.out.println(e.getMessage());
        } catch (InvalidTextException e) {
            System.out.println(e.getMessage());
        }        
    }

    public static void test2() {
        ReferenceTable referenceTable = ReferenceTable.CUSTOM;
        Encoder encoder = new TextEncoder(referenceTable.getTable());
        Decoder decoder = new TextDecoder(referenceTable.getTable());
        EncoderDecoder encoderDecoder = new EncoderDecoder(encoder, decoder);
        char offsetChar = 'B';
        String plainText = "HELLO WORLD";

        // Encode the plaintext
        String encodedText;
        try {
            encodedText = encoderDecoder.encode(plainText, offsetChar);

            // Encode the plain text
            System.out.println("Encoded: " + encodedText);
            // Decode the encoded text
            String decodedText = encoderDecoder.decode(encodedText);
            System.out.println("Decoded: " + decodedText);

            // Add assertions to validate the results
            if ("BGDKKN VNQKC".equals(encodedText) && plainText.equals(decodedText)) {
                System.out.println("Test Passed: Encode with B");
            } else {
                System.out.println("Test Failed: Encode with B");
            }
        } catch (InvalidOffsetCharacterException e) {
            System.out.println(e.getMessage());
        } catch (InvalidTextException e) {
            System.out.println(e.getMessage());
        }        
    }

    public static void test3() {
        ReferenceTable referenceTable = ReferenceTable.CUSTOM;
        Encoder encoder = new TextEncoder(referenceTable.getTable());
        Decoder decoder = new TextDecoder(referenceTable.getTable());
        EncoderDecoder encoderDecoder = new EncoderDecoder(encoder, decoder);
        char offsetChar = 'F';
        String plainText = "";

        try {
            // This code will throw an exception
            encoderDecoder.encode(plainText, offsetChar);

            // If no exception is thrown, the test failed
            System.out.println("Test Failed: Test InvalidTextException");
        } catch (InvalidOffsetCharacterException e) {
            System.out.println("Expected exception: " + e.getMessage());
            System.out.println("Test Passed: Test InvalidOffsetCharacterException");
        } catch (InvalidTextException e) {
            System.out.println("Expected exception: " + e.getMessage());
            System.out.println("Test Passed: Test InvalidTextException");
        }
    }

    public static void test4() {
        ReferenceTable referenceTable = ReferenceTable.CUSTOM;
        Encoder encoder = new TextEncoder(referenceTable.getTable());
        Decoder decoder = new TextDecoder(referenceTable.getTable());
        EncoderDecoder encoderDecoder = new EncoderDecoder(encoder, decoder);
        char offsetChar = 'f';
        String plainText = "HELLO WORLD";

        try {
            // This code will throw an exception
            encoderDecoder.encode(plainText, offsetChar);

            // If no exception is thrown, the test failed
            System.out.println("Test Failed: Test InvalidTextException");
        } catch (InvalidOffsetCharacterException e) {
            System.out.println("Expected exception: " + e.getMessage());
            System.out.println("Test Passed: Test InvalidOffsetCharacterException");
        } catch (InvalidTextException e) {
            System.out.println("Expected exception: " + e.getMessage());
            System.out.println("Test Passed: Test InvalidTextException");
        }
    }
}
