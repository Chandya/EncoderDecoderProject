package main;
import interfaces.Encoder;
import utils.exceptions.InvalidOffsetCharacterException;
import utils.exceptions.InvalidTextException;
import interfaces.Decoder;

/**
 * Dependency Injection: You apply dependency injection when you pass instances of 
 * Encoder and Decoder into the EncoderDecoder constructor. 
 * This helps decouple the creation of objects from their usage and makes your code more flexible.
 */
public class EncoderDecoder {
    private final Encoder encoder;
    private final Decoder decoder;

    public EncoderDecoder(Encoder encoder, Decoder decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }

    public String encode(String plainText, char offsetChar) throws InvalidOffsetCharacterException, InvalidTextException {
        return encoder.encode(plainText, offsetChar);
    }

    public String decode(String encodedText) throws InvalidTextException {
        return decoder.decode(encodedText);
    }
}
