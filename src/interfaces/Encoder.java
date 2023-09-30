package interfaces;

import utils.exceptions.InvalidOffsetCharacterException;
import utils.exceptions.InvalidTextException;

// Define an interface for encoding
/* 
 * Abstraction: By working with interfaces (Encoder and Decoder) instead of concrete classes, 
 * one can focus on the behavior (encoding and decoding) without 
 * worrying about specific implementations. 
 * If we have different types of encoding/decoding in the future, we can continue using
 * this interface.
*/
public interface Encoder {
    String encode(String plainText, char offsetChar) throws InvalidOffsetCharacterException, InvalidTextException;
}

