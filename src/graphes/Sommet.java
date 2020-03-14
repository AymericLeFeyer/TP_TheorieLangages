package graphes;

import com.mxgraph.view.mxGraph;

import java.util.List;

public class Sommet {
    String name;
    int x;
    int y;
    Object s;

    static List<Sommet> listSommet;

    public Sommet(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void displaySommet(mxGraph graph, Object parent) {
        this.s = graph.insertVertex(parent, null, this.name, this.x, this.y, 30, 30);
    }
}
