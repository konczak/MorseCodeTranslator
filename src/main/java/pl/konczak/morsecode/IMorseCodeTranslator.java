package pl.konczak.morsecode;

public interface IMorseCodeTranslator {

    String encode(String english);

    String decode(String morseCode);
}
