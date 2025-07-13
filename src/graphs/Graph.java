package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Graph<K> {
    private float time;

    public abstract List<GraphNode<K>> getNodes();
    public abstract GraphNode<K> getNode(K key);

    public abstract List<GraphEdge<K>> getAdjacent(K nodeKey);

    public abstract void addEdge(GraphEdge<K> edge);

    public void bfs(K startKey) {
        List<GraphNode<K>> vs = getNodes();

        for(GraphNode<K> u : vs) {
            u.setColor(GraphNode.Color.WHITE);
            u.setD(Float.POSITIVE_INFINITY);
            u.setPi(null);
        }

        GraphNode<K> s = getNode(startKey);

        s.setColor(GraphNode.Color.GRAY);
        s.setD(0);
        s.setPi(null);

        Queue<GraphNode<K>> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()) {
            GraphNode<K> u = q.remove();
            for(GraphEdge<K> e : getAdjacent(u.getKey())) {
                GraphNode<K> v = getNode(e.getTo());

                if(v.getColor() == GraphNode.Color.WHITE) {
                    v.setColor(GraphNode.Color.GRAY);
                    v.setD(u.getD() + 1);
                    v.setPi(u);
                    q.add(v);
                }
            }

            u.setColor(GraphNode.Color.BLACK);
        }
    }

    public void dfsVisit(GraphNode<K> u, List<GraphNode<K>> finished) {
        time++;
        u.setD(time);
        u.setColor(GraphNode.Color.GRAY);

        for(GraphEdge<K> e : getAdjacent(u.getKey())) {
            GraphNode<K> v = getNode(e.getTo());

            if(v.getColor() == GraphNode.Color.WHITE) {
                v.setPi(u);
                dfsVisit(v);
            }
        }

        time++;
        u.setColor(GraphNode.Color.BLACK);

        if(finished != null)
            finished.add(u);
    }

    public void dfs() {
        List<GraphNode<K>> vs = getNodes();
        for(GraphNode<K> u : vs) {
            u.setColor(GraphNode.Color.WHITE);
            u.setPi(null);
        }

        time = 0.0f;
        for(GraphNode<K> u : vs) {
            if(u.getColor() == GraphNode.Color.WHITE)
                dfsVisit(u, null);
        }
    }

    public List<GraphNode<K>> topologicalSort() {
        List<GraphNode<K>> sorted = new LinkedList<>();

        List<GraphNode<K>> vs = getNodes();
        for(GraphNode<K> u : vs) {
            u.setColor(GraphNode.Color.WHITE);
            u.setPi(null);
        }

        time = 0.0f;
        for(GraphNode<K> u : vs) {
            if(u.getColor() == GraphNode.Color.WHITE)
                dfsVisit(u, sorted);
        }

        return sorted;
    }
}
