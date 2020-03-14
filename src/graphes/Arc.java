package graphes;

import com.mxgraph.view.mxGraph;

import java.util.List;

public class Arc {
    Sommet s1;
    Sommet s2;
    int cout;

    static List<Arc> listArc;

    public Arc(Sommet s1, Sommet s2, int cout) {
        this.s1 = s1;
        this.s2 = s2;
        this.cout = cout;
        listArc.add(this);
    }

    public void displayArc(mxGraph graph, Object parent) {
        graph.insertEdge(parent, null, this.cout, this.s1.s, this.s2.s);
    }
}
