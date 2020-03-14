package graphes;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import java.util.ArrayList;
import java.util.regex.*;
import java.util.Scanner;
import java.io.File;

public class JGraph extends JFrame {

    /**
     * Pour éviter un warning venant du JFrame
     */
    private static final long serialVersionUID = -8123406571694511514L;

    public JGraph() throws Exception {
        super("TP THEORIE LANGAGES");

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

//        Importation des informations
        importGraph();

        graph.getModel().beginUpdate();
        try {
//            Affichage du graphe
            displayGraph(graph, parent);
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }

    public void displayGraph(mxGraph graph, Object parent) {
        for (Sommet s : Sommet.listSommet) {
            s.displaySommet(graph, parent);
        }
        for (Arc a : Arc.listArc) {
            a.displayArc(graph, parent);
        }
    }

    public void importGraph() throws Exception {
        Arc.listArc = new ArrayList<>();
        Sommet.listSommet = new ArrayList<>();

        File text = new File("src/input.txt");
        Scanner sc = new Scanner(text);

//      Number of the line
        int lineNumber = 1;
//      If true, char, else number
        boolean state = true;
        int numberChar = 0;
//      Test is sommets exists
        Sommet sommet1 = new Sommet("", 0, 0);
        Sommet sommet2 = new Sommet("", 0, 0);
//      Additional test
        boolean arcExiste = false;
        boolean arc2 = false;

        Pattern p = Pattern.compile("^[a-z]{1,3}[0-9]+$");
        Pattern chiffre = Pattern.compile("^[0-9]+$");
        Matcher m;

        while (sc.hasNextLine()) {
            arcExiste = false;
            arc2 = false;
            String line = sc.nextLine();
            if (lineNumber == 1) {
//              Lecture des sommets
                String[] result = line.split(" ");

                if (result[0].equals("sommets")) {
                    for (int i = 1; i < result.length; i++) {
//                      Pour chaque mot
                        m = p.matcher(result[i]);
                        if (m.find()) {
//                          Il n'y a pas d'erreur, on ajoute le sommet
                            Sommet.listSommet.add(new Sommet(m.group(), (int) (Math.random() * (400)), (int) (Math.random() * (400))));

                        } else throw new Exception("Probleme de format sur le sommet " + result[i]);
                    }

                } else {
                    throw new Exception("Pas de sommet");
                }
            } else {
//                Lecture des arcs
                String[] result = line.split(" ");
                if (result.length == 4) {
                    m = chiffre.matcher(result[3]);
                    if (!m.find()) throw new Exception("La valeur finale n'est pas un entier ! : " + result[3]);
                    if (result[0].equals("arc")) {
//                  On parcours la liste des sommets pour voir s'ils existent
                        for (Sommet s : Sommet.listSommet) {
                            if (s.name.equals(result[1])) sommet1 = s;
                            if (s.name.equals(result[2])) sommet2 = s;
                        }
                        if (!(sommet1.name.equals("") || sommet2.name.equals(""))) {
//                      Les deux sommets existent
                            for (Arc a : Arc.listArc) {
                                if (a.s1 == sommet1 && a.s2 == sommet2) {
                                    arcExiste = true;
                                    a.cout = a.cout + "," + result[3];
                                    break;
                                }
                                else if (a.s1 == sommet2 && a.s2 == sommet1) {
                                    arc2 = true;
                                    break;
                                }
                            }
                            if (!arcExiste && !arc2) {
                                Arc.listArc.add(new Arc(sommet1, sommet2, "\n\n"+result[3]));
                            }
                            if (arc2) Arc.listArc.add(new Arc(sommet1, sommet2, "\n\n\n\n                 "+result[3]));
                        } else
                            throw new Exception("Au moins un des sommets n'existe pas " + result[1] + ", " + result[2]);

                    } else throw new Exception("Probleme sur le premier mot " + result[0]);
                } else throw new Exception("Probleme de parametre sur l'arc de la ligne : " + lineNumber);

            }
//


            lineNumber++;

        }


    }

}