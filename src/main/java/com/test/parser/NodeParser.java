package com.test.parser;


import com.test.model.Node;

import java.util.ArrayList;

public class NodeParser {

    private static final String COMMA_SEPARATOR = ",";
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";
    private static final String CLOSED_BRACKET = ")";
    private static final String OPEN_BRACKET = "(";

    public Node parseFields(String value) {
        Node root = new Node();
        if (value.startsWith(OPEN_BRACKET) && value.endsWith(CLOSED_BRACKET)) {
            parseNode(root, value.substring(1));
        }

        return root;
    }

    private void parseNode(Node root, String s) {
        if (s.contains(CLOSED_BRACKET) && s.contains(OPEN_BRACKET)) {
            if (s.indexOf(OPEN_BRACKET) < s.indexOf(CLOSED_BRACKET)) {
                if (root.getChildren() == null) {
                    root.setChildren(new ArrayList<>());
                }

                String[] values = s.substring(0, s.indexOf(OPEN_BRACKET)).split(COMMA_SEPARATOR);
                for (String value : values) {
                    if (!value.equals(EMPTY_STRING)) {
                        Node node = new Node(value.trim());
                        node.setParent(root);
                        root.getChildren().add(node);
                    }
                }

                Node lastNode = root.getChildren().get(root.getChildren().size() - 1);
                if (lastNode.getChildren() == null) {
                    lastNode.setChildren(new ArrayList<>());
                }

                parseNode(lastNode, s.substring(s.indexOf(OPEN_BRACKET) + 1));
            } else {
                String[] values = s.substring(0, s.indexOf(CLOSED_BRACKET)).split(COMMA_SEPARATOR);
                for (String value : values) {
                    if (!value.equals(EMPTY_STRING)) {
                        Node node = new Node(value.trim());
                        node.setParent(root);
                        root.getChildren().add(node);
                    }
                }

                parseNode(root.getParent(), s.substring(s.indexOf(CLOSED_BRACKET) + 1));
            }
        } else if (s.contains(CLOSED_BRACKET)) {
            String[] values = s.substring(0, s.indexOf(CLOSED_BRACKET)).replaceAll(SPACE, EMPTY_STRING).split(COMMA_SEPARATOR);
            for (String value : values) {
                if (!value.equals(EMPTY_STRING)) {
                    Node node = new Node(value.trim());
                    node.setParent(root.getParent());
                    root.getChildren().add(node);
                }
            }
            parseNode(root.getParent(), s.substring(s.indexOf(CLOSED_BRACKET) + 1));
        }
    }
}
