package graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ListGraph<K> extends Graph<K> {
    private HashMap<K, GraphNode<K>> nodes;
    private HashMap<K, List<GraphEdge<K>>> edges;

    public ListGraph(GraphNode<K>[] nodes) {
        this.edges = new HashMap<>();
        this.nodes = new HashMap<>();

        for(GraphNode<K> n : nodes)
            this.nodes.put(n.getKey(), n);
    }

    @Override
    public List<GraphNode<K>> getNodes() {
        return this.nodes.values()
                .stream()
                .toList();
    }

    @Override
    public GraphNode<K> getNode(K key) {
        return this.nodes.get(key);
    }

    @Override
    public List<GraphEdge<K>> getAdjacent(K nodeKey) {
        List<GraphEdge<K>> adjacent = this.edges.get(nodeKey);
        return Objects.requireNonNullElseGet(adjacent, List::of);
    }

    @Override
    public void addEdge(GraphEdge<K> edge) {
        List<GraphEdge<K>> adjacent = this.edges.get(edge.getFrom());
        if(adjacent == null)
            this.edges.put(edge.getFrom(), List.of(edge));
        else
            adjacent.add(edge);

        if(edge.isDirected()) {
            adjacent = this.edges.get(edge.getTo());
            if(adjacent == null)
                this.edges.put(edge.getTo(), List.of(edge));
            else
                adjacent.add(edge);
        }
    }
}
