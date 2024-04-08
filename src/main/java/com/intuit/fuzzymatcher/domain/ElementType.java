package com.intuit.fuzzymatcher.domain;


import java.util.function.Function;

import static com.intuit.fuzzymatcher.domain.MatchType.*;
import static com.intuit.fuzzymatcher.function.PreProcessFunction.*;
import static com.intuit.fuzzymatcher.function.TokenizerFunction.*;

/**
 * Enum to define different types of Element.
 * This is used only to categorize the data, and apply functions at different stages of match.
 * The functions, can be overridden from Element class using the appropriate setters at the time of creation.
 */
public enum ElementType {
    WORDS,
    NAME,
    TEXT,
    ADDRESS,
    EMAIL,
    PHONE,
    NUMBER,
    DATE,
    AGE;

    protected Function getPreProcessFunction() {
        switch (this) {
            case WORDS:
                return wordsPreProcessing();
            case TEXT:
                return removeSpecialChars();
            case NAME:
                return namePreprocessing();
            case ADDRESS:
                return addressPreprocessing();
            case EMAIL:
                return removeDomain();
            case PHONE:
                return usPhoneNormalization();
            case NUMBER:
            case AGE:
                return numberPreprocessing();
            default:
                return none();
        }
    }

    protected Function getTokenizerFunction() {
        switch (this) {
            case WORDS:
                return wordsTokenizer();
            case NAME:
            case ADDRESS:
                return wordSoundexEncodeTokenizer();
            case TEXT:
                return wordTokenizer();
            case EMAIL:
                return triGramTokenizer();
            case PHONE:
                return decaGramTokenizer();
            default:
                return valueTokenizer();
        }
    }

    protected MatchType getMatchType() {
        switch (this) {
            case NUMBER:
            case DATE:
            case AGE:
                return NEAREST_NEIGHBORS;
            default:
                return EQUALITY;
        }
    }
}