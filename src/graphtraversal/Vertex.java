package graphtraversal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author igor
 * Last edited 21-02-2018
 */

public class Vertex {
    private String name;
    private boolean visited;
    private Set<Vertex> neighbours;
    private Vertex parent;
    
    public Vertex(String name){
        this.name = name;
        neighbours = new HashSet<>();
    }
    
    public void addNeighbour(Vertex vertex){
       neighbours.add(vertex);
    }
    
    public void removeNeighbour(Vertex vertex){
       neighbours.remove(vertex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean isVisited) {
        this.visited = isVisited;
    }

    public Set<Vertex> getNeighbours() {
        return Collections.unmodifiableSet(neighbours);
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object that) {
        if (that == null || getClass() != that.getClass() ) {
            return false;
        }        
        if (this == that) {
            return true;
        }
        final Vertex other = (Vertex) that;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return this.name;
    }    
}
