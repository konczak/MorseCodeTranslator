package pl.konczak.morsecodetranslator;

public class MorseCodeTranslator
        implements IMorseCodeTranslator {

    private final String[] morseCodeArray = {"--..--", ".-.-.-", "..--..", "-----",
        ".----", "..---", "...--", "....-", ".....", "-....", "--...",
        "---..", "----.", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
        "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
        "--.."};

    private final char[] englishArray = ",.?0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Override
    public String encode(String english) {
        if (english == null) {
            throw new IllegalArgumentException("Input english text to encode can not be null");
        }
        english = english.toLowerCase().trim();
        if (english.isEmpty()) {
            return "";
        }
        String[] words = english.split(" ");

        StringBuilder morseCode = new StringBuilder();

        for (String word : words) {
            for (char englishChar : word.toCharArray()) {
                int index = searchForIndexOfEnglishCharacter(englishChar);
                morseCode.append(morseCodeArray[index]);
                morseCode.append(" ");
            }
            morseCode.append(" ");
        }

        return morseCode.substring(0, morseCode.length() - 2);
    }

    private int searchForIndexOfEnglishCharacter(char englishChar) {
        int index = -1;
        for (int i = 0; i < englishArray.length; i++) {
            if (englishChar == englishArray[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Character <" + englishChar + "> is not supported in MorseCode");
        }
        return index;
    }

    @Override
    public String decode(String morseCode) {
        if (morseCode == null) {
            throw new IllegalArgumentException("Input MorseCode to decode can not be null");
        }
        morseCode = morseCode.trim();
        if (morseCode.isEmpty()) {
            return "";
        }
        String[] words = morseCode.split("  ");

        StringBuilder englishText = new StringBuilder();

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String morseCodeChar : letters) {
                int index = searchForIndexOfMorseCodeCharacte(morseCodeChar);
                englishText.append(englishArray[index]);
            }
            englishText.append(" ");
        }

        return englishText.substring(0, englishText.length() - 1);
    }

    private int searchForIndexOfMorseCodeCharacte(String morseCodeChar) {
        int index = -1;
        for (int i = 0; i < morseCodeArray.length; i++) {
            if (morseCodeArray[i].equals(morseCodeChar)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Character <" + morseCodeChar + "> is not correct MorseCode");
        }
        return index;
    }

}
