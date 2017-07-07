/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Samarth Gupta
 */
@Entity
@Table(name = "flightschedules", catalog = "Airline", schema = "")
@NamedQueries({
    @NamedQuery(name = "Flightschedules.findAll", query = "SELECT f FROM Flightschedules f"),
    @NamedQuery(name = "Flightschedules.findByFlightTime", query = "SELECT f FROM Flightschedules f WHERE f.flightTime = :flightTime"),
    @NamedQuery(name = "Flightschedules.findByCapacity", query = "SELECT f FROM Flightschedules f WHERE f.capacity = :capacity"),
    @NamedQuery(name = "Flightschedules.findByFlightName", query = "SELECT f FROM Flightschedules f WHERE f.flightName = :flightName"),
    @NamedQuery(name = "Flightschedules.findByPrice", query = "SELECT f FROM Flightschedules f WHERE f.price = :price"),
    @NamedQuery(name = "Flightschedules.findByFlightID", query = "SELECT f FROM Flightschedules f WHERE f.flightID = :flightID")})
public class Flightschedules implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "FlightTime")
    private String flightTime;
    @Basic(optional = false)
    @Column(name = "Capacity")
    private int capacity;
    @Basic(optional = false)
    @Column(name = "FlightName")
    private String flightName;
    @Basic(optional = false)
    @Column(name = "Price")
    private int price;
    @Id
    @Basic(optional = false)
    @Column(name = "FlightID")
    private Integer flightID;

    public Flightschedules() {
    }

    public Flightschedules(Integer flightID) {
        this.flightID = flightID;
    }

    public Flightschedules(Integer flightID, String flightTime, int capacity, String flightName, int price) {
        this.flightID = flightID;
        this.flightTime = flightTime;
        this.capacity = capacity;
        this.flightName = flightName;
        this.price = price;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        String oldFlightTime = this.flightTime;
        this.flightTime = flightTime;
        changeSupport.firePropertyChange("flightTime", oldFlightTime, flightTime);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        int oldCapacity = this.capacity;
        this.capacity = capacity;
        changeSupport.firePropertyChange("capacity", oldCapacity, capacity);
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        String oldFlightName = this.flightName;
        this.flightName = flightName;
        changeSupport.firePropertyChange("flightName", oldFlightName, flightName);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        int oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public Integer getFlightID() {
        return flightID;
    }

    public void setFlightID(Integer flightID) {
        Integer oldFlightID = this.flightID;
        this.flightID = flightID;
        changeSupport.firePropertyChange("flightID", oldFlightID, flightID);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightID != null ? flightID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flightschedules)) {
            return false;
        }
        Flightschedules other = (Flightschedules) object;
        if ((this.flightID == null && other.flightID != null) || (this.flightID != null && !this.flightID.equals(other.flightID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Flightschedules[ flightID=" + flightID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
