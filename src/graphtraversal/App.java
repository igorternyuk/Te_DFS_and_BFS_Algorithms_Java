package graphtraversal;

/**
 *
 * @author igor
 * Last edited 21-02-2018
 */

public class App {
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        Graph graph = new Graph();
        Vertex vertexA = new Vertex("A"); 
        graph.addVertex(vertexA);
        Vertex vertexB = new Vertex("B"); 
        graph.addVertex(vertexB);
        Vertex vertexC = new Vertex("C"); 
        graph.addVertex(vertexC);
        Vertex vertexD = new Vertex("D"); 
        graph.addVertex(vertexD);
        Vertex vertexE = new Vertex("E"); 
        graph.addVertex(vertexE);
        Vertex vertexF = new Vertex("F"); 
        graph.addVertex(vertexF);
        
        graph.addEdge(vertexA, vertexB);
        graph.addEdge(vertexA, vertexC);
        graph.addEdge(vertexA, vertexD);
        graph.addEdge(vertexB, vertexC);
        graph.addEdge(vertexD, vertexC);
        graph.addEdge(vertexC, vertexE);
        graph.addEdge(vertexC, vertexF);
        graph.addEdge(vertexE, vertexF);
        
        System.out.println("\n***DFS recursive***\n");
        graph.dfsRecursive(vertexA);
        graph.unvistAllVertices();
        System.out.println("\n***DFS iterative***\n");
        graph.dfsIterative(vertexA);
        System.out.println("\n***BFS***\n");
        graph.bfs(vertexA);
    }
    
    
}
