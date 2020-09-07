package com.test.validate;

public class InputNodeValidator {
    private static final String NULL_INPUT_NODE_MESSAGE = "Null input node";
    private static final String EMPTY_INPUT_NODE_MESSAGE = "Empty input node";
    private static final String INVALID_BRACKET_COUNT_MESSAGE = "Invalid bracket count";
    private static final char OPEN_BRACKET = '(';
    private static final char CLOSED_BRACKET = ')';

    public void validate(String inputNode) {
        if (inputNode == null) {
            throw new RuntimeException(NULL_INPUT_NODE_MESSAGE);
        }

        if (inputNode.isEmpty()) {
            throw new RuntimeException(EMPTY_INPUT_NODE_MESSAGE);
        }

        if (countLetterInString(OPEN_BRACKET, inputNode) != countLetterInString(CLOSED_BRACKET, inputNode)) {
            throw new RuntimeException(INVALID_BRACKET_COUNT_MESSAGE);
        }
    }

    private int countLetterInString(char letterToFind, String inputString) {
        int count = 0;
        for (char letter: inputString.toCharArray()) {
            if (letter == letterToFind) {
                ++count;
            }
        }

        return count;
    }
}
