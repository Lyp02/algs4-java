import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;
    public EdgeWeightedDigraph(int V){
    	this.V =V;
    	this.E =0;
    	adj =(Bag<DirectedEdge>[]) new Bag[V];
    	for(int v =0;v<V;v++){
    		adj[v] = new Bag<DirectedEdge>();
    	}
    }
    public EdgeWeightedDigraph(int V,int E){
    	this(V);
    	if(E<0) throw new IllegalArgumentException("Number of edges in a Digraph must be nonnegative");
    	for(int i=0;i<E;i++){
    		int v =StdRandom.uniform(V);
    		int w =StdRandom.uniform(V);
    		double weight =0.01 *StdRandom.uniform(100);
    		DirectedEdge e =new DirectedEdge(v, w, weight);
    		addEdge(e);
    	}
    }
    
    public EdgeWeightedDigraph(In in){
    	this(in.readInt());
    	int E =in.readInt();
    	if(E < 0) throw new IllegalArgumentException("Nummber of edges must be nonnegative");
    	for(int i=0;i<E;i++){
    		int v =in.readInt();
    		int w =in.readInt();
    		double weight =in.readDouble();
    		addEdge(new DirectedEdge(v, w, weight));
    	}
    }
    public int V(){
    	return V;
    }
    public int E(){
    	return E;
    }
    public void addEdge(DirectedEdge e){
    	adj[e.from()].add(e);
    	E++;
    }
    public Iterable<DirectedEdge> adj(int v){
    	return adj[v];
    }
    public Iterable<DirectedEdge> edges(){
    	Bag<DirectedEdge> bag =new Bag<DirectedEdge>();
    	for(int v =0;v<V;v++)
    		for(DirectedEdge e:adj[v])
    			bag.add(e);
    	return bag;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
