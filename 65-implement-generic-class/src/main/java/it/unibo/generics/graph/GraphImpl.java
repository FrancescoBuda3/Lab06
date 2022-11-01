package it.unibo.generics.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private final Set<N> nodes;
    private final Map<N, Set<N>> edges;

    public GraphImpl(Set<N> nodes){
        this.nodes = nodes;
        this.edges = new HashMap<>();
    }

    public GraphImpl(){
        this(new HashSet<N>());
    }

    @Override
    public void addNode(N node) {
        if (node != null) {
            this.nodes.add(node);
        }  
    }

    @Override
    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            this.edges.putIfAbsent(source, new HashSet<>());
            this.edges.get(source).add(target);
            this.edges.putIfAbsent(target, new HashSet<>());
            this.edges.get(target).add(source);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return Set.copyOf(nodes);
    }

    @Override
    public Set<N> linkedNodes(Object node) {
        return Set.copyOf(edges.get(node));
    }

    @Override
    public List<N> getPath(Object source, Object target) {
        List<N> path = new ArrayList<>();

        return path;
    }

   

   

    

    
    
}

