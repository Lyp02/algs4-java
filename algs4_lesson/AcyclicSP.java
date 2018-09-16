
public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
    public AcyclicSP(EdgeWeightedDigraph G,int s){
    	edgeTo =new DirectedEdge[G.V()];
    	distTo =new double[G.V()];
    	for(int v=0;v<G.V();v++){
    		distTo[v] =Double.POSITIVE_INFINITY;
    	}
    	distTo[s]=0.0;
    	Topological top =new Topological(G);
    	for(int v:top.order())
    		relax(G,v);
    }
    private void relax(EdgeWeightedDigraph G,int v){
    	for(DirectedEdge e:G.adj(v)){
    		int w =e.to();
    		if(distTo[w]>distTo[v]+e.weight()){
    			distTo[w]=distTo[v]+e.weight();
    			edgeTo[w]=e;
    			if(pq.contains(w)) pq.change(w,distTo[w]);
    			else pq.insert(w, distTo[w]);
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
