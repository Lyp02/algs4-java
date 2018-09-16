import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class Kruskal {
    private Queue<Edge> mst;
    private KruskalMST(EdgeWeightedGraph G){
    	mst = new Queue<Edge>();
    	MinPQ<Edge> pq =new MinPQ<>();
    	for(Edge e:G.edges()) pq.insert(e);
    	UF uf =new UF(G.V());
    	while(!pq.isEmpty() &&mst.size()<G.V()-1){
    		Edge e =pq.delMin();
    		int v =e.either(),w =e.other(v);
    		if(uf.connected(v,w)) continue;
    		uf.union(v,w);
    		mst.enqueue(e);
    	}
    }
    public Iterable<Edge> edges(){
    	return mst;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
