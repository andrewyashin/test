package com.test.sort;

import org.junit.Before;
import org.junit.Test;
import com.test.model.Node;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class NodeSortServiceTest {
    private NodeSortService sortService;

    @Before
    public void setUp() {
        sortService = new NodeSortService();
    }

    @Test
    public void shouldSortByAsc() {
        Node inputNode = createInputNode();
        sortService.sortNodeAsc(inputNode);

        assertEquals(createExpectedNode(), inputNode);
    }

    private Node createInputNode() {
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

    private Node createExpectedNode() {
        Node root = new Node();

        Node created = new Node("created");
        Node employee = new Node("employee");
        Node id = new Node("id");
        Node location = new Node("location");
        root.setChildren(Arrays.asList(created, employee, id, location));

        Node employeeType = new Node("employeeType");
        Node firstname = new Node("firstname");
        Node idEmployee = new Node("id");
        Node lastname = new Node("lastname");
        employee.setChildren(Arrays.asList(employeeType, firstname, idEmployee, lastname));

        Node idEmployeeType = new Node("id");
        employeeType.setChildren(Collections.singletonList(idEmployeeType));

        return root;
    }

}