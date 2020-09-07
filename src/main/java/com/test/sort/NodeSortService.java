package com.test.sort;


import com.test.model.Node;

import java.util.Comparator;
import java.util.List;

public class NodeSortService {
    public void sortNodeAsc(final Node node) {
        if (node.getChildren() != null && !node.getChildren().isEmpty()) {
            sortNode(node);
        }
    }

    private void sortNode(Node node) {
        List<Node> childrenNodes = node.getChildren();
        if (childrenNodes != null && !childrenNodes.isEmpty()) {
            childrenNodes.sort(Comparator.comparing(Node::getValue));

            for (Node children : childrenNodes) {
                if (children.getChildren() != null && !children.getChildren().isEmpty()) {
                    sortNode(children);
                }
            }
        }
    }
}
