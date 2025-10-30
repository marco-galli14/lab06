package it.unibo.generics.graph.api;

import java.util.List;

public interface Node {
    
    /**
     * @return the node name
     */
    String getNodeName();

    /**
     * Add a Node "nodo" to the list of nodes of this node
     * 
     * @param nodo
     *          node to be added to the nodeList
     */
    void createEdge(Node nodo);

    /**
     * @return a secure-copy LinkedList with all the nodes connected to this node
     */
    List<Node> getNodeList();
}
