package pl.konczak.morsecode;

public interface IMorseCodeTranslator {

    /**
     * Translates English text into Morse code.
     *
     * @param english input text. Allowed characters are " ,.?0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" but upper case
     * characters are replaced with their lower case equivalent.
     * @return encoded String with MorseCode where single space indicates end of the letter and two subsequent spaces indicates end of the
     * word.
     * @throws IllegalArgumentException when input is null or contains unsupported characters
     */
    String encode(String english);

    /**
     * Translates Morse code into English text.
     *
     * @param morseCode input Morse code. Single space indicates end of the letter/digit/character and two subsequent spaces indicates end
     * of the word.
     * @return decoded String with English text. Note Morse code does not recognize size of the letters so output will be always written
     * with lower case characters.
     * @throws IllegalArgumentException when input is null or contains unsupported characters
     */
    String decode(String morseCode);
}
