package com.test.validate;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InputNodeValidatorTest {
    private static final String NULL_INPUT_NODE_MESSAGE = "Null input node";
    private static final String EMPTY_INPUT_NODE_MESSAGE = "Empty input node";
    private static final String INVALID_BRACKET_COUNT_MESSAGE = "Invalid bracket count";
    private static final String VALID_STRING = "(id,created,employee(id,firstname,employeeType(id), lastname),location)";
    private static final String INVALID_STRING = "(id,created,employee((id,firstname,employeeType(id), lastname),location)";
    private InputNodeValidator validator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        validator = new InputNodeValidator();
    }

    @Test
    public void shouldAcceptStringIfNoIssues() {
        validator.validate(VALID_STRING);
    }

    @Test
    public void shouldThrowExceptionWhenNullString() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(NULL_INPUT_NODE_MESSAGE);

        validator.validate(null);
    }

    @Test
    public void shouldThrowExceptionWhenEmptyString() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(EMPTY_INPUT_NODE_MESSAGE);

        validator.validate("");
    }

    @Test
    public void shouldThrowExceptionWhenInvalidCountOfBracketString() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(INVALID_BRACKET_COUNT_MESSAGE);

        validator.validate(INVALID_STRING);
    }

}