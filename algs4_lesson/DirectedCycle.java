import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;
    public DirectedCycle(Digraph digraph){
    	onStack =new boolean[digraph.V()];
    	edgeTo =new int[digraph.V()];
    	marked =new boolean[digraph.V()];
    	for(int v=0;v<digraph.V();v++)
    		if(!marked[v]) dfs(digraph,v);
    }
    private void dfs(Digraph G,int v){
    	onStack[v] =true;
    	marked[v] =true;
    	for(int w:G.adj(v))
    		if(this.hasCycle()) return;
    		else if(!marked[w]){
    			edgeTo[w] =v;
    			dfs(G,w);
    		}
    		else if(onStack[w]){
    			cycle =new Stack<Integer>();
    			for(int x =v;x!=w;x=edgeTo[x])
    				cycle.push(x);
    			cycle.push(w);
    			cycle.push(v);
    		}
    	onStack[v] =false;
    	
    }
    
    public boolean hasCycle(){
    	return cycle!=null;
    }
    public Iterable<Integer> cycle(){
    	return cycle;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
