package com.test.print;


import com.test.model.Node;

public class NodePrintService {
    private static final String DASH = "-";
    private static final String SPACE = " ";

    public void printNodes(Node node) {
        int dashCount = 0;

        if (node.getChildren() != null && !node.getChildren().isEmpty()) {
            printNode(node, dashCount);
        }
    }

    private void printNode(Node node, int dashCount) {
        for (Node children : node.getChildren()) {
            if (dashCount > 0)
                printDashes(dashCount);

            System.out.println(children.getValue());
            if (children.getChildren() != null && !children.getChildren().isEmpty()) {
                printNode(children, dashCount + 1);
            }
        }
    }

    private void printDashes(int dashCount) {
        while (dashCount > 0) {
            System.out.print(DASH);
            --dashCount;
        }

        System.out.print(SPACE);
    }
}

