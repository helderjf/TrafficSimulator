/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadnetwork.domain;

/**
 *
 * @author André Pedrosa, Hélder Faria, José Miranda, Rubén Rosário
 */
public class SimPathParcel {
    
    private Section m_section;
    private Segment m_segment;
    private SimDirection m_direction;
    private double m_theoreticalTravelTime;
    private double m_simInTime;
    private double m_simExitTime;

    /**
     * @return the m_section
     */
    public Section getSection() {
        return m_section;
    }

    /**
     * @return the m_segment
     */
    public Segment getSegment() {
        return m_segment;
    }

    /**
     * @return the m_direction
     */
    public SimDirection getDirection() {
        return m_direction;
    }

    /**
     * @return the m_theoreticalExitTime
     */
    public Double getTheoreticalTravelTime() {
        return m_theoreticalTravelTime;
    }

    /**
     * @param m_section the m_section to set
     */
    public void setSection(Section m_section) {
        this.m_section = m_section;
    }

    /**
     * @param m_segment the m_segment to set
     */
    public void setSegment(Segment m_segment) {
        this.m_segment = m_segment;
    }

    /**
     * @param m_direction the m_direction to set
     */
    public void setDirection(SimDirection m_direction) {
        this.m_direction = m_direction;
    }

    /**
     * @param m_exitTime the m_theoreticalExitTime to set
     */
    public void setTheoreticalExitTime(Double m_exitTime) {
        this.m_theoreticalTravelTime = m_exitTime;
    }

    double getSimInTime() {
        return m_simInTime;
    }
    
    
    
    
    
 
}
