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
@Table(name = "passenger", catalog = "Airline", schema = "")
@NamedQueries({
    @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p"),
    @NamedQuery(name = "Passenger.findByAge", query = "SELECT p FROM Passenger p WHERE p.age = :age"),
    @NamedQuery(name = "Passenger.findByName", query = "SELECT p FROM Passenger p WHERE p.name = :name"),
    @NamedQuery(name = "Passenger.findByAddress", query = "SELECT p FROM Passenger p WHERE p.address = :address"),
    @NamedQuery(name = "Passenger.findByMobile", query = "SELECT p FROM Passenger p WHERE p.mobile = :mobile"),
    @NamedQuery(name = "Passenger.findByPassengerID", query = "SELECT p FROM Passenger p WHERE p.passengerID = :passengerID")})
public class Passenger implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Age")
    private String age;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "Mobile")
    private String mobile;
    @Id
    @Basic(optional = false)
    @Column(name = "PassengerID")
    private Integer passengerID;

    public Passenger() {
    }

    public Passenger(Integer passengerID) {
        this.passengerID = passengerID;
    }

    public Passenger(Integer passengerID, String age, String name, String address, String mobile) {
        this.passengerID = passengerID;
        this.age = age;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        String oldAge = this.age;
        this.age = age;
        changeSupport.firePropertyChange("age", oldAge, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        String oldMobile = this.mobile;
        this.mobile = mobile;
        changeSupport.firePropertyChange("mobile", oldMobile, mobile);
    }

    public Integer getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Integer passengerID) {
        Integer oldPassengerID = this.passengerID;
        this.passengerID = passengerID;
        changeSupport.firePropertyChange("passengerID", oldPassengerID, passengerID);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passengerID != null ? passengerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passenger)) {
            return false;
        }
        Passenger other = (Passenger) object;
        if ((this.passengerID == null && other.passengerID != null) || (this.passengerID != null && !this.passengerID.equals(other.passengerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Passenger[ passengerID=" + passengerID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
