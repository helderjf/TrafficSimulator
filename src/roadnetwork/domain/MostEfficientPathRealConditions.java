/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadnetwork.domain;

import graphutils.Graph;
import graphutils.GraphAlgorithms;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author josemiranda
 */
public class MostEfficientPathRealConditions implements BestPathAlgorithm{

    Graph<Junction, Section> m_graph;
    RoadNetwork m_roadNetwork;
    Junction m_originNode;
    Junction m_destinyNode;
    Vehicle m_vehicle;
    ArrayList<Section> m_fastestPath;
    ArrayList<Junction> m_fastestPathNodes;
    double m_fastestPathLength;
    ArrayList<Double> m_sectionEnergyConsumption;
    ArrayList<Double> m_sectionTime;
    ArrayList<Double> m_sectionTollCosts;
    ArrayList<PathParcel> m_pathParcelList;
    
    @Override
    public ResultStaticAnalysis getBestPathResults(RoadNetwork roadNetwork, Junction originNode, Junction destinyNode, Vehicle vehicle) {
        m_graph = new Graph<>(true);
        m_roadNetwork=roadNetwork;
        m_originNode=originNode;
        m_destinyNode=destinyNode;
        m_vehicle=vehicle;
        m_fastestPath = new ArrayList<>();
        m_fastestPathNodes=new ArrayList<>();
        
        graphConstruction(m_roadNetwork, m_vehicle);
        
        m_fastestPathLength = GraphAlgorithms.getShortestPathLength(
                m_graph, m_originNode, m_destinyNode, m_fastestPath, m_fastestPathNodes);

        //calculateSectionEnergyConsumption();
        calculateSectionTime();
        calculateSectionTollCosts();

        return constructResults();
    }
    
    @Override
    public ArrayList<PathParcel> getBestPath(RoadNetwork roadNetwork, Junction originNode, Junction destinyNode, Vehicle vehicle){
        getBestPathResults(roadNetwork, originNode, destinyNode, vehicle);
        calculatePathParcelList();
        return m_pathParcelList;
    }

    private void graphConstruction(RoadNetwork rn, Vehicle vehicle) {
        for (Section sec : rn.getSectionList()) {
            addConection(sec);
        }
    }

    private void addConection(Section section) {
        if (section.getDirection().equals(SectionDirection.unidirectional)) {
            m_graph.insertEdge(section.getBeginningNode(), section.getEndingNode(), section, calculateSectionEnergyConsumption(section));

        } else if (section.getDirection().equals(SectionDirection.bidirectional)) {
            m_graph.insertEdge(section.getBeginningNode(), section.getEndingNode(), section, calculateSectionEnergyConsumption(section));
            m_graph.insertEdge(section.getEndingNode(), section.getBeginningNode(), section, calculateSectionEnergyConsumption(section));
        }
    }
    
    private double calculateSectionEnergyConsumption(Section section) {
        //TODO
        return 0;
    }
    
    private void calculateSectionsEnergyConsumption(){
        m_sectionEnergyConsumption = new ArrayList<>();
        for (Section s : m_fastestPath) {
            m_sectionEnergyConsumption.add(calculateSectionEnergyConsumption(s));
        }
    }
    
    private void calculateSectionTime(){
        m_sectionTime=new ArrayList<>();
        
        //TODO
        
    }
    
    private void calculateSectionTollCosts(){
        m_sectionTollCosts=new ArrayList<>();
        for (Section s : m_fastestPath) {
            m_sectionTollCosts.add(s.getToll());
        }
    }
    
    private void calculatePathParcelList(){
        m_pathParcelList = new ArrayList<>();
        if (m_originNode.equals(m_fastestPath.get(0).getBeginningNode())) {
            for (Section section : m_fastestPath) {
                calculatePathParcel(section, section.getSegmentsList());
            }
        } else {
            for (Section section : m_fastestPath) {
                ArrayList<Segment> segmentsList=section.getSegmentsList();
                Collections.reverse(segmentsList);
                calculatePathParcel(section, segmentsList);
            }
        }
    }
    
    private void calculatePathParcel(Section section, ArrayList<Segment> segmentsList){
        double time = 0; //in seconds
        for (Segment it : segmentsList) {
            
            double lenght = it.getLenght();
            double travelSpeed;
            SectionTypology type = section.getSectionType();
            
            //determin if the vehicle maximum speed for this section is inferior to the section speed limit
            if (m_vehicle.getVelocityLimits().containsKey(String.valueOf(type))
                    && m_vehicle.getVelocityLimit(type)< it.getMax_Velocity()) {
                travelSpeed = m_vehicle.getVelocityLimit(type);
            }else{
                travelSpeed= it.getMax_Velocity();
            }
            
            time += lenght * 3600 / travelSpeed;
            if (m_pathParcelList!=null) {
                PathParcel pp = new PathParcel();
                
                if (section.getDirection().equals(SectionDirection.unidirectional)) {
                    pp.setDirection(SimDirection.direct);
                } else{
                    if (m_originNode.equals(m_fastestPath.get(0).getBeginningNode())) {
                        pp.setDirection(SimDirection.direct);
                    } else{
                        pp.setDirection(SimDirection.reverse);
                    }
                }
                pp.setSection(section);
                pp.setSegment(it);
                pp.setTheoreticalExitTime(lenght * 3600 / travelSpeed);
                m_pathParcelList.add(pp);
            }
            
        }
    }

    private ResultStaticAnalysis constructResults() {
        
        ResultStaticAnalysis simResult = new ResultStaticAnalysis(m_originNode, m_destinyNode);
        simResult.setPath(m_fastestPath);
        simResult.setLength(m_fastestPathLength);
        simResult.setSectionTravelTime(m_sectionTime);
        simResult.setPathNodes(m_fastestPathNodes);
        simResult.setVehicle(m_vehicle);
        simResult.setEnergyConsumption(m_sectionEnergyConsumption);
        simResult.setTollCosts(m_sectionTollCosts);
        return simResult;
    }
}
