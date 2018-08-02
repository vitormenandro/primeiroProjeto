package com.graph;


import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class GraphDisplayTest {

    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 400, 300);

        mxGraph graph = buildGraph();
        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        frame.getContentPane().add(graphComponent);
        frame.setVisible(true);
        }

        private mxGraph buildGraph() {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            Object v1 = graph.insertVertex(parent, "V1", "V1", 20, 20,
                80, 30);
            Object v2 = graph.insertVertex(parent, "V2", "V2", 240,
                150, 80, 30);
            graph.insertEdge(parent, "E1", "E1", v1, v2);
            Object v3 = graph.insertVertex(parent, "V3", "V3", 240,
                200, 80, 30);
            graph.insertEdge(parent, "E2", "E2", v1, v3);

            // apply layout to graph
            mxHierarchicalLayout layout = new mxHierarchicalLayout(
                graph);
            layout.setOrientation(SwingConstants.WEST);
            layout.execute(parent);

        } finally {
            graph.getModel().endUpdate();
        }
        return graph;
        }
    });

    }

}
