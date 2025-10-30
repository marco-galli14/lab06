package it.unibo.generics.graph.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.Node;

public class GraphImpl implements Graph<String>{
    
    private String name;
    private Set<Node> nodeSet;

    public GraphImpl(final String name) {
        this.name = name;
        this.nodeSet = new TreeSet<>();
    }

    public void addNode(final String nodeName) {
        Node appoggio = new NodeImpl(nodeName);
        if(!this.nodeSet.contains(appoggio))
            this.nodeSet.add(appoggio);
    }
    
    public void addEdge(final String source, final String target) {
        if((source != null) && (target != null)) {
            Node fonte, obiettivo;
            fonte = obiettivo = null;
            for(Node elem : this.nodeSet) {
                if(elem.getNodeName().equals(source))
                    fonte = elem;
                if(elem.getNodeName().equals(target))
                    obiettivo = elem;
            }
            if((fonte != null) && (obiettivo != null))
                fonte.createEdge(obiettivo);
        }
    }

    public Set<String> nodeSet() {
        Set<String> ris = new TreeSet<>();
        for(Node elem : this.nodeSet) {
            ris.add(elem.getNodeName());
        }
        return ris;
    }

    public Set<String> linkedNodes(final String source) {
        Set<String> ris = new TreeSet<>();
        Node appoggio = null;
        for(Node e : this.nodeSet) {
            if(e.getNodeName().equals(source))
                appoggio = e;
        }
        for(Node elem : appoggio.getNodeList()) {
            ris.add(elem.getNodeName());
        }
        return ris;
    }

    public List<String> getPath(final String source, final String target) {
        List<String> ris = new LinkedList<>();
        Node appoggio = null;
        for(Node e : this.nodeSet) {
            if(e.getNodeName().equals(source))
                appoggio = e;
        }
        while(!appoggio.getNodeList().getFirst().getNodeName().equals(target)){
            ris.add(appoggio.getNodeList().getFirst().getNodeName());
            appoggio = appoggio.getNodeList().getFirst();
        }
        return ris;
    }

    @Override
    public String toString() {
        return "GraphImpl [name=" + name + "]";
    }

    
}
