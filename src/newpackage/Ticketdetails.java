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
@Table(name = "ticketdetails", catalog = "Airline", schema = "")
@NamedQueries({
    @NamedQuery(name = "Ticketdetails.findAll", query = "SELECT t FROM Ticketdetails t"),
    @NamedQuery(name = "Ticketdetails.findByNumberOfTravellers", query = "SELECT t FROM Ticketdetails t WHERE t.numberOfTravellers = :numberOfTravellers"),
    @NamedQuery(name = "Ticketdetails.findByDepDate", query = "SELECT t FROM Ticketdetails t WHERE t.depDate = :depDate"),
    @NamedQuery(name = "Ticketdetails.findByFromLoc", query = "SELECT t FROM Ticketdetails t WHERE t.fromLoc = :fromLoc"),
    @NamedQuery(name = "Ticketdetails.findByToLoc", query = "SELECT t FROM Ticketdetails t WHERE t.toLoc = :toLoc"),
    @NamedQuery(name = "Ticketdetails.findByClass1", query = "SELECT t FROM Ticketdetails t WHERE t.class1 = :class1"),
    @NamedQuery(name = "Ticketdetails.findByTicketID", query = "SELECT t FROM Ticketdetails t WHERE t.ticketID = :ticketID")})
public class Ticketdetails implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NumberOfTravellers")
    private int numberOfTravellers;
    @Basic(optional = false)
    @Column(name = "DepDate")
    private String depDate;
    @Basic(optional = false)
    @Column(name = "FromLoc")
    private String fromLoc;
    @Basic(optional = false)
    @Column(name = "ToLoc")
    private String toLoc;
    @Basic(optional = false)
    @Column(name = "Class")
    private String class1;
    @Id
    @Basic(optional = false)
    @Column(name = "TicketID")
    private Integer ticketID;

    public Ticketdetails() {
    }

    public Ticketdetails(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Ticketdetails(Integer ticketID, int numberOfTravellers, String depDate, String fromLoc, String toLoc, String class1) {
        this.ticketID = ticketID;
        this.numberOfTravellers = numberOfTravellers;
        this.depDate = depDate;
        this.fromLoc = fromLoc;
        this.toLoc = toLoc;
        this.class1 = class1;
    }

    public int getNumberOfTravellers() {
        return numberOfTravellers;
    }

    public void setNumberOfTravellers(int numberOfTravellers) {
        int oldNumberOfTravellers = this.numberOfTravellers;
        this.numberOfTravellers = numberOfTravellers;
        changeSupport.firePropertyChange("numberOfTravellers", oldNumberOfTravellers, numberOfTravellers);
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        String oldDepDate = this.depDate;
        this.depDate = depDate;
        changeSupport.firePropertyChange("depDate", oldDepDate, depDate);
    }

    public String getFromLoc() {
        return fromLoc;
    }

    public void setFromLoc(String fromLoc) {
        String oldFromLoc = this.fromLoc;
        this.fromLoc = fromLoc;
        changeSupport.firePropertyChange("fromLoc", oldFromLoc, fromLoc);
    }

    public String getToLoc() {
        return toLoc;
    }

    public void setToLoc(String toLoc) {
        String oldToLoc = this.toLoc;
        this.toLoc = toLoc;
        changeSupport.firePropertyChange("toLoc", oldToLoc, toLoc);
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        String oldClass1 = this.class1;
        this.class1 = class1;
        changeSupport.firePropertyChange("class1", oldClass1, class1);
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        Integer oldTicketID = this.ticketID;
        this.ticketID = ticketID;
        changeSupport.firePropertyChange("ticketID", oldTicketID, ticketID);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketID != null ? ticketID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticketdetails)) {
            return false;
        }
        Ticketdetails other = (Ticketdetails) object;
        if ((this.ticketID == null && other.ticketID != null) || (this.ticketID != null && !this.ticketID.equals(other.ticketID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Ticketdetails[ ticketID=" + ticketID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
