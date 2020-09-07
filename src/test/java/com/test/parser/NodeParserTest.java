package com.test.parser;

import org.junit.Before;
import org.junit.Test;
import com.test.model.Node;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class NodeParserTest {
    private static final String VALID_STRING = "(id,created,employee(id,firstname,employeeType(id), lastname),location)";
    private NodeParser parser;

    @Before
    public void setUp() {
        parser = new NodeParser();
    }

    @Test
    public void shouldParseNodeString() {
        Node expectedNode = createExpectedNode();
        Node actualNode = parser.parseFields(VALID_STRING);

        assertEquals(expectedNode.toString() ,actualNode.toString());
    }

    private Node createExpectedNode() {
        Node root = new Node();

        Node id = new Node("id");
        Node created = new Node("created");
        Node employee = new Node("employee");
        Node location = new Node("location");
        root.setChildren(Arrays.asList(id, created, employee, location));

        Node idEmployee = new Node("id");
        Node firstname = new Node("firstname");
        Node employeeType = new Node("employeeType");
        Node lastname = new Node("lastname");
        employee.setChildren(Arrays.asList(idEmployee, firstname, employeeType, lastname));

        Node idEmployeeType = new Node("id");
        employeeType.setChildren(Collections.singletonList(idEmployeeType));

        return root;
    }
}