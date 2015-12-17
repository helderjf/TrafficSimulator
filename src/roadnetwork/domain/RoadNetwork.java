/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadnetwork.domain;

import java.util.ArrayList;

/**
 *
 * @author André Pedrosa, Hélder Faria, José Miranda, Rubén Rosário
 */
public class RoadNetwork {
    
    private ArrayList<Junction> m_nodeList;
    private ArrayList<Section> m_sectionList;
    
    public ArrayList<Junction> getNodeList() {
        return m_nodeList;
    }
    
    public ArrayList<Section> getSectionList(){
        return m_sectionList;
    }

    public void setNodeList(ArrayList<Junction> m_nodeList) {
        this.m_nodeList = m_nodeList;
    }

    public void setSectionList(ArrayList<Section> m_sectionList) {
        this.m_sectionList = m_sectionList;
    }
    
    
    
    
    
}
