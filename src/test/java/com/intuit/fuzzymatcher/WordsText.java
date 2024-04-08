package com.intuit.fuzzymatcher;

import com.intuit.fuzzymatcher.domain.Element;
import com.intuit.fuzzymatcher.domain.ElementType;
import com.intuit.fuzzymatcher.domain.Token;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.intuit.fuzzymatcher.function.TokenizerFunction.wordsTokenizer;
import static org.junit.Assert.assertEquals;

public class WordsText {
    @Test
    public void testWordsTokenizer() {
        String[] valueStr = {"Horror Drama", "Romance", "Comedy"};
        Element<String[]> elem2 = new Element.Builder<String>().setType(ElementType.WORDS).setValue(valueStr).createElement();

        Token[] tokenArray = wordsTokenizer().apply(elem2).toArray(Token[]::new);

        List<Token> expectedTokens = Arrays.asList(
                new Token("horror", elem2),
                new Token("drama", elem2),
                new Token("romance", elem2),
                new Token("comedy", elem2)
        );

        for (int i = 0; i < tokenArray.length; i++) {
            assertEquals(expectedTokens.get(i), tokenArray[i]);
        }

        assertEquals(4, tokenArray.length);
    }
}
