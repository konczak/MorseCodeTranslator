package pl.konczak.morsecodetranslator;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author konczak
 */
public class IMorseCodeTranslatorTest {

    private final IMorseCodeTranslator morseCodeTranslator;

    public IMorseCodeTranslatorTest() {
        morseCodeTranslator = new MorseCodeTranslator();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldReturnMorseCodeInEncode() {
        //given
        String input = "Marry had a little lamb";

        //when
        String result = morseCodeTranslator.encode(input);

        //then
        assertEquals("-- .- .-. .-. -.--  .... .- -..  .-  .-.. .. - - .-.. .  .-.. .- -- -...", result);
    }

    @Test
    public void shouldReturnMorseCodeInEncodeEvenWhenItContainsDot() {
        //given
        String input = "Well I am going to learn a lot.";

        //when
        String result = morseCodeTranslator.encode(input);

        //then
        assertEquals(".-- . .-.. .-..  ..  .- --  --. --- .. -. --.  - ---  .-.. . .- .-. -.  .-  .-.. --- - .-.-.-", result);
    }

    @Test
    public void shouldReturnMorseCodeInEncodeEvenWhenItContainsComma() {
        //given
        String input = "It will be a lot of fun, everyone should do that";

        //when
        String result = morseCodeTranslator.encode(input);

        //then
        assertEquals(".. -  .-- .. .-.. .-..  -... .  .-  .-.. --- -  --- ..-.  ..-. ..- -. --..--  . ...- . .-. -.-- --- -. .  ... .... --- ..- .-.. -..  -.. ---  - .... .- -", result);
    }

    @Test
    public void shouldReturnMorseCodeInEncodeEvenWhenItContainsQuestionMark() {
        //given
        String input = "What are you going to do on ATP?";

        //when
        String result = morseCodeTranslator.encode(input);

        //then
        assertEquals(".-- .... .- -  .- .-. .  -.-- --- ..-  --. --- .. -. --.  - ---  -.. ---  --- -.  .- - .--. ..--..", result);
    }

    @Test
    public void shouldReturnMorseCodeInEncodeFromDigits() {
        //given
        String input = "0123456789";

        //when
        String result = morseCodeTranslator.encode(input);

        //then
        assertEquals("----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.", result);
    }

    @Test
    public void shouldReturnMorseCodeInEncodeFromAlphabet() {
        //given
        String input = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //when
        String result = morseCodeTranslator.encode(input);

        //then
        assertEquals(".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. .- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..", result);
    }

    @Test
    public void shouldReturnEmptyResultInEncodeWhenInputIsEmpty() {
        //given
        String input = "";

        //when
        String result = morseCodeTranslator.encode(input);

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnEmptyResultInEncodeWhenInputIsSingleSpace() {
        //given
        String input = " ";

        //when
        String result = morseCodeTranslator.encode(input);

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnEmptyResultInEncodeWhenInputIsDoubleSpace() {
        //given
        String input = "  ";

        //when
        String result = morseCodeTranslator.encode(input);

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnEmptyResultInEncodeWhenInputContainsOnlySpaces() {
        //given
        String input = "                                ";

        //when
        String result = morseCodeTranslator.encode(input);

        //then
        assertTrue(result.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIlegalArgumentExceptionInEncodeWhenInputIsNull() {
        //given
        String input = null;
        //when
        morseCodeTranslator.encode(input);
        //then
    }

    @Test
    public void shouldReturnEnglishTextInDecode() {
        //given
        String input = "-- .- .-. .-. -.--  .... .- -..  .-  .-.. .. - - .-.. .  .-.. .- -- -...";

        //when
        String result = morseCodeTranslator.decode(input);

        //then
        assertEquals("marry had a little lamb", result);
    }

    @Test
    public void shouldReturnEnglishTextInDecodeEvenWhenItContainsDot() {
        //given
        String input = ".-- . .-.. .-..  ..  .- --  --. --- .. -. --.  - ---  .-.. . .- .-. -.  .-  .-.. --- - .-.-.-";

        //when
        String result = morseCodeTranslator.decode(input);

        //then
        assertEquals("well i am going to learn a lot.", result);
    }

    @Test
    public void shouldReturnEnglishTextInDecodeEvenWhenItContainsComma() {
        //given
        String input = ".. -  .-- .. .-.. .-..  -... .  .-  .-.. --- -  --- ..-.  ..-. ..- -. --..--  . ...- . .-. -.-- --- -. .  ... .... --- ..- .-.. -..  -.. ---  - .... .- -";

        //when
        String result = morseCodeTranslator.decode(input);

        //then
        assertEquals("it will be a lot of fun, everyone should do that", result);
    }

    @Test
    public void shouldReturnEnglishTextInDecodeEvenWhenItContainsQuestionMark() {
        //given
        String input = ".-- .... .- -  .- .-. .  -.-- --- ..-  --. --- .. -. --.  - ---  -.. ---  --- -.  .- - .--. ..--..";

        //when
        String result = morseCodeTranslator.decode(input);

        //then
        assertEquals("what are you going to do on atp?", result);
    }

    @Test
    public void shouldReturnEnglishTextInDecodeToDigits() {
        //given
        String input = "----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.";

        //when
        String result = morseCodeTranslator.decode(input);

        //then
        assertEquals("0123456789", result);
    }

    @Test
    public void shouldReturnEnglishTextInDecodeToAlphabet() {
        //given
        String input = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";

        //when
        String result = morseCodeTranslator.decode(input);

        //then
        assertEquals("abcdefghijklmnopqrstuvwxyz", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIlegalArgumentExceptionInDecodeWhenInputIsNull() {
        //given
        String input = null;

        //when
        morseCodeTranslator.decode(input);

        //then
    }

    @Test
    public void shouldReturnEmptyResultInDecodeWhenInputIsEmpty() {
        //given
        String input = "";

        //when
        String result = morseCodeTranslator.decode(input);

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnEmptyResultInDecodeWhenInputIsSingleSpace() {
        //given
        String input = " ";

        //when
        String result = morseCodeTranslator.decode(input);

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnEmptyResultInDecodeWhenInputIsDoubleSpace() {
        //given
        String input = "  ";

        //when
        String result = morseCodeTranslator.decode(input);

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnEmptyResultInDecodeWhenInputContainsOnlySpaces() {
        //given
        String input = "                                ";

        //when
        String result = morseCodeTranslator.decode(input);

        //then
        assertTrue(result.isEmpty());
    }
}
