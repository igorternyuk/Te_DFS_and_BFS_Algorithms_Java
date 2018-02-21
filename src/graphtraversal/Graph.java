package graphtraversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author igor Last edited 21-02-2018
 */
public class Graph {

    private Set<Vertex> vertices;

    public Graph() {
        vertices = new HashSet<>();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public void removeVertex(Vertex vertex) {
        vertices.forEach((v) -> {
            v.removeNeighbour(vertex);
        });
        vertices.remove(vertex);
    }

    public void addEdge(Vertex from, Vertex to) {
        if (vertices.contains(from) && vertices.contains(to)) {
            from.addNeighbour(to);
        }
    }

    public void removeEdge(Vertex from, Vertex to) {
        if (vertices.contains(from) && vertices.contains(to)) {
            from.removeNeighbour(to);
        }
    }

    public void dfsRecursive(Vertex root) {
        System.out.println("in " + root);
        root.setVisited(true);
        root.getNeighbours().stream().filter((v) -> {
            return !v.isVisited();
        }).forEachOrdered((v) -> {
            dfsRecursive(v);
        });
        System.out.println("out " + root);
    }

    public void dfsIterative(Vertex root) {
        this.unvistAllVertices();
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        root.setVisited(true);
        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();
            currentVertex.getNeighbours().stream().filter((v) -> {
                return !v.isVisited();
            }).forEachOrdered((v) -> {
                v.setVisited(true);
                stack.push(v);
            });
            System.out.println(currentVertex);
        }
    }

    public void bfs(Vertex root) {
        this.unvistAllVertices();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.setVisited(true);
        int level = 0;
        int currentLevelSize = 0;

        while (!queue.isEmpty()) {
            ++level;
            System.out.println("\nLevel " + level + ":\n");
            currentLevelSize = queue.size();
            while (currentLevelSize > 0) {
                Vertex currentVertex = queue.poll();
                System.out.println(currentVertex);
                currentVertex.getNeighbours().stream().filter((v) -> {
                    return !v.isVisited();
                }).forEachOrdered((v) -> {
                    v.setVisited(true);
                    queue.add(v);
                });
                --currentLevelSize;
            }
        }
    }

    
    public void unvistAllVertices() {
        vertices.forEach((v) -> {
            v.setVisited(false);
        });
    }
}

/*
    void Graph::bfs(int from)
{
    if(!is_vertex_valid(from)) return;
    std::cout << "*******BFS********" << std::endl;
    std::fill(m_visited.begin(), m_visited.end(), false);
    std::queue<int> q;
    q.push(from);
    m_visited[from] = true;
    int level{0};
    int size{0};
    while(!q.empty())
    {
        std::cout << "LEVEL: " << ++level << std::endl;
        size = q.size();
        while(size--)
        {
            int v = q.front();
            q.pop();
            std::cout << v << std::endl;
            for(size_t i{0}; i < m_adj_mtr.size(); ++i)
            {
                if(m_adj_mtr[v][i] != INF && !m_visited[i])
                {
                    q.push(i);
                    m_visited[i] = true;
                }
            }
        }
    }
}
     */