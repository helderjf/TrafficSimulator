/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadnetwork.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import roadnetwork.controllers.BestPathSimulationContoller;
import roadnetwork.domain.BestPathAlgorithm;
import roadnetwork.domain.Junction;
import roadnetwork.domain.RoadNetwork;
import roadnetwork.domain.SimulationResult;
import roadnetwork.domain.Vehicle;

/**
 *
 * @author André Pedrosa, Hélder Faria, José Miranda, Rubén Rosário
 */
public class BestPathAnalysisFrame extends javax.swing.JFrame {

    MainFrame m_mainFrame;
    BestPathSimulationContoller m_bpSimulationController;
    ArrayList<Vehicle> m_vehiclesList;
    RoadNetwork m_roadNetwork;
    ArrayList<Junction> m_nodesList;
    SimulationResult m_results;

    /**
     * Creates new form JanelaBestPathAnalysis
     *
     * @param frame
     */
    public BestPathAnalysisFrame(MainFrame frame) {
        m_mainFrame = frame;
        m_bpSimulationController = new BestPathSimulationContoller(m_mainFrame.getManager());

        run();

    }

    private void run() {

        if (!m_bpSimulationController.projectActive()) {
            JOptionPane.showMessageDialog(this, "Can't create Simulation. There is no active project.", "No active project", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
        } else if (m_bpSimulationController.newSimulation()) {
            //get the active project's list of vehicles
            m_vehiclesList = m_bpSimulationController.newBestPathSimulation();

            initComponents();
            setLocationRelativeTo(null);

            setContentPane(new BestPathAnalysisChooseVehiclePane(this, m_vehiclesList));

            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(m_mainFrame, "The active project can not be simulated at this point!", "Error", JOptionPane.WARNING_MESSAGE);
            setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Best Path Analysis");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    public void setVehicle(Vehicle v) {
        m_bpSimulationController.setVehicle(v);
        setChooseNodesPane();
    }

    public void setChooseNodesPane() {
        m_roadNetwork = m_bpSimulationController.getRoadNetwork();
        m_nodesList = m_bpSimulationController.getNodeList();

        this.setContentPane(new BestPathChooseNodesPane(this, m_nodesList));
        this.revalidate();
    }

    public void setChooseAlgorithmPane() {

        this.setContentPane(new BestPathChooseAlgorithmPane(this, m_bpSimulationController.getBestPathAlgorithms()));
        this.revalidate();
    }

    public void runSimulation() {
        m_results = m_bpSimulationController.runSimulation();
        setContentPane(new BestPathShowResultsPane(this, m_bpSimulationController, m_results));
        this.revalidate();
    }

    void setSimulationNodes(Junction originNode, Junction destinyNode) {
        m_bpSimulationController.setSimulationNodes(originNode, destinyNode);
        setChooseAlgorithmPane();

    }

    void setAlgorithm(BestPathAlgorithm algorithm) {
        m_bpSimulationController.setAlgorithm(algorithm);
        runSimulation();
    }

}
