package graphes;

import javax.swing.JFrame;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import java.util.ArrayList;
import java.util.regex.*;

public class JGraph extends JFrame {

    /** Pour éviter un warning venant du JFrame */
    private static final long serialVersionUID = -8123406571694511514L;

    public JGraph() {
        super("JGrapghX tutoriel: Exemple 1");

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        Arc.listArc = new ArrayList<>();
        Sommet.listSommet = new ArrayList<>();

        Sommet s1 = new Sommet("s1", 20, 20);
        Sommet s2 = new Sommet("s2", 200, 200);
        Sommet s3 = new Sommet("s3", 100, 200);

        Arc a1 = new Arc(s1, s2, 5);
        Arc a2 = new Arc(s2, s3, 5);


        graph.getModel().beginUpdate();
        try {
            for (Sommet s : Sommet.listSommet) {
                s.displaySommet(graph, parent);
            }
            for (Arc a : Arc.listArc) {
                a.displayArc(graph, parent);
            }
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }

}