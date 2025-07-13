package graphs;

public class GraphEdge<K> {
    private K from;
    private K to;
    private boolean directed;

    public GraphEdge(K from, K to, boolean directed) {
        this.from = from;
        this.to = to;
        this.directed = directed;
    }

    public K getFrom() {
        return this.from;
    }

    public K getTo() {
        return this.to;
    }

    public boolean isDirected() {
        return this.directed;
    }
}
