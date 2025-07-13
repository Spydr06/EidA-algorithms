package graphs;

public class GraphNode<K> {
    public enum Color {
        WHITE,
        GRAY,
        BLACK
    }

    private final K key;
    private float d;
    private Color c;
    private GraphNode<K> pi;

    public GraphNode(K key) {
        this(key, Float.POSITIVE_INFINITY, Color.WHITE, null);
    }

    public GraphNode(K key, float d, Color c, GraphNode<K> pi) {
        this.key = key;
        this.d = d;
        this.c = c;
        this.pi = pi;
    }

    public float getD() {
        return d;
    }

    public void setD(float d) {
        this.d = d;
    }

    public K getKey() {
        return key;
    }

    public Color getColor() {
        return c;
    }

    public void setColor(Color c) {
        this.c = c;
    }

    public GraphNode<K> getPi() {
        return pi;
    }

    public void setPi(GraphNode<K> pi) {
        this.pi = pi;
    }
}
