package com.test;

import com.test.model.Node;
import com.test.parser.NodeParser;
import com.test.print.NodePrintService;
import com.test.sort.NodeSortService;
import com.test.validate.InputNodeValidator;

public class Main {
    public static void main(String[] args) {
        NodeParser parser = new NodeParser();
        NodePrintService nodePrintService = new NodePrintService();
        NodeSortService nodeSortService = new NodeSortService();
        InputNodeValidator validator = new InputNodeValidator();

        String inputNodeString = args[0];
        validator.validate(inputNodeString);
        Node root = parser.parseFields(inputNodeString);
        nodeSortService.sortNodeAsc(root);
        nodePrintService.printNodes(root);
    }
}
