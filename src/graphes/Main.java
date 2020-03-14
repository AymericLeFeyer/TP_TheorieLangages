package graphes;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    /**
     * @param args "arguments"
     */
    public static void main(String[] args) throws Exception {
        JGraph frame = new JGraph();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
