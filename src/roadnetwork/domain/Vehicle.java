/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadnetwork.domain;

import java.util.Objects;

/**
 *
 * @author André Pedrosa, Hélder Faria, José Miranda, Rubén Rosário
 */

public class Vehicle {
      
    private String id;
    private String name;
    private double mass;
    private TypeOfVehicle type;
    private double load;
    private double drag_Coefficient;
    private double maxSpeed;

    /**
     * 
     */
    public Vehicle()
    {
        this.id = "";
        this.name = "";
        this.mass = 0;
        this.type = null;
        this.load = 0;
        this.drag_Coefficient = 0;
        this.maxSpeed=0;
    }
    
    /**
     * 
     * @param id id
     * @param name name
     * @param mass mass
     * @param type type
     * @param load load
     * @param drag_Coefficient drag coefficient 
     * @param maxSpeed maximum speed
     */
    public Vehicle(String id, String name, double mass, TypeOfVehicle type, double load, double drag_Coefficient, double maxSpeed) {
        this.id = id;
        this.name = name;
        this.mass = mass;
        this.type = type;
        this.load = load;
        this.drag_Coefficient = drag_Coefficient;
        this.maxSpeed=maxSpeed;
    }
    
    /**
     * 
     * @param v Vechicle copy 
     */
    public Vehicle(Vehicle v)
    {
        v.id = this.id;
        v.load = this.load;
        v.mass = this.mass;
        v.name = this.name;
        v.type = this.type;
        v.drag_Coefficient = this.drag_Coefficient;
        v.maxSpeed = this.maxSpeed;
    }

    /**
     * 
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * 
     * @param mass mass
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * 
     * @return type
     */
    public TypeOfVehicle getType() {
        return type;
    }

    /**
     * 
     * @return load
     */
    public double getLoad() {
        return load;
    }

    /**
     * 
     * @param load load
     */
    public void setLoad(double load) {
        this.load = load;
    }

    /**
     * 
     * @return frag coefficient
     */
    public double getDrag_Coefficient() {
        return drag_Coefficient;
    }

    /**
     * 
     * @param drag_Coefficient drag_Coefficient
     */
    public void setDrag_Coefficient(double drag_Coefficient) {
        this.drag_Coefficient = drag_Coefficient;
    }

    /**
     * 
     * @return maxSpeed
     */
    public double getMaximumSpeed() {
        return maxSpeed;
    }

    /**
     * 
     * @param maxSpeed maxSpeed 
     */
    public void setMaximumSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    

    /**
     * 
     * @param obj object
     * @return result
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.mass) != Double.doubleToLongBits(other.mass)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (Double.doubleToLongBits(this.load) != Double.doubleToLongBits(other.load)) {
            return false;
        }
        if (Double.doubleToLongBits(this.drag_Coefficient) != Double.doubleToLongBits(other.drag_Coefficient)) {
            return false;
        }
        return true;
    }
    

    /**
     * 
     * @return string
     */
    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", mass=" + mass + ", type=" + type + ", load=" + load + ", drag_Coefficient=" + drag_Coefficient + ", maximum speed=" + maxSpeed +'}';
    }

  
  
}
