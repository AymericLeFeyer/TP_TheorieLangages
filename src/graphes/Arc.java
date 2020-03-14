package graphes;

import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.swing.mxGraphComponent;


import java.util.List;

public class Arc {
    Sommet s1;
    Sommet s2;
    String cout;

    static List<Arc> listArc;

    public Arc(Sommet s1, Sommet s2, String cout) {
        this.s1 = s1;
        this.s2 = s2;
        this.cout = cout;
    }

    public void displayArc(mxGraph graph, Object parent) {
      graph.insertEdge(parent, null, this.cout, this.s1.s, this.s2.s);
      graph.setAllowLoops(false);
    }
}
