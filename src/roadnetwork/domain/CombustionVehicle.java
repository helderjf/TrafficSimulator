/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadnetwork.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author André Pedrosa, Hélder Faria, José Miranda, Rubén Rosário
 */
public class CombustionVehicle extends Vehicle implements Combustion {
    
    private String fuel;
    private ArrayList<Double> gearRatio;



    /**
     * 
     * @param id id of CombustionVehicle
     * @param name name of CombustionVehicle
     * @param mass mass of CombustionVehicle
     * @param type type of CombustionVehicle
     * @param load load of CombustionVehicle
     * @param drag_Coefficient drag_Coefficient of CombustionVehicle
     * @param maxSpeed maximum speed of CombustionVehicle
     * @param rrc rrc of CombustionVehicle
     * @param wheelSize wheelSize of CombustionVehicle
     * @param velocityLimit velocityLimit of CombustionVehicle
     * @param torque torque of CombustionVehicle
     * @param fuel fuel of CombustionVehicle 
     * @param consuption consuption of CombustionVehicle
     * @param mostEfficientRPM mostEfficientRPM of CombustionVehicle
     * @param minRPM minRPM of CombustionVehicle
     * @param maxRPM maxRPM of CombustionVehicle
     * @param finalDriveRatio finalDriveRatio of CombustionVehicle
     * @param gearRatio gearRatio of CombustionVehicle
     */
    public CombustionVehicle(String id, String name, double mass, TypeOfVehicle type, double load, double drag_Coefficient, double maxSpeed,
                    double rrc, double wheelSize, HashMap<Segment,Double> velocityLimit, double torque, double mostEfficientRPM,
                    double consuption, double minRPM, double maxRPM, double finalDriveRatio, String fuel, ArrayList<Double> gearRatio) {
        super(id, name, mass, type, load, drag_Coefficient, maxSpeed, rrc, wheelSize, velocityLimit, torque, mostEfficientRPM, consuption,
                minRPM, maxRPM, finalDriveRatio);
        this.fuel = fuel;
        this.gearRatio = gearRatio;
    }

    /**
     * 
     * @return fuel of CombustionVehicle
     */
    public String getFuel() {
        return fuel;
    }

    /**
     * 
     * @param fuel fuel
     */
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    /**
     * 
     * @return gearRatio
     */
    public ArrayList<Double> getGearRatio() {
        return gearRatio;
    }

    /**
     * 
     * @param gearRatio gearRatio
     */
    public void setGearRatio(ArrayList<Double> gearRatio) {
        this.gearRatio = gearRatio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * 
     * @param obj object
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CombustionVehicle other = (CombustionVehicle) obj;
        if (!Objects.equals(this.fuel, other.fuel)) {
            return false;
        }
        if (!Objects.equals(this.gearRatio, other.gearRatio)) {
            return false;
        }
        return true;
    }
    
    

    /**
     * 
     * @return CombustionVehicle string
     */
    @Override
    public String toString() {
        return "CombustionVehicle{" + super.toString() + "typeOfCombustion=" + fuel + "Gear Ratio" + gearRatio +'}';
    }
    
    
}