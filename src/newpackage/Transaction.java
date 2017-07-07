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
@Table(name = "transaction", catalog = "Airline", schema = "")
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findByDiscounts", query = "SELECT t FROM Transaction t WHERE t.discounts = :discounts"),
    @NamedQuery(name = "Transaction.findByCards", query = "SELECT t FROM Transaction t WHERE t.cards = :cards"),
    @NamedQuery(name = "Transaction.findByNetBanking", query = "SELECT t FROM Transaction t WHERE t.netBanking = :netBanking"),
    @NamedQuery(name = "Transaction.findByMobileWallets", query = "SELECT t FROM Transaction t WHERE t.mobileWallets = :mobileWallets"),
    @NamedQuery(name = "Transaction.findByChargeID", query = "SELECT t FROM Transaction t WHERE t.chargeID = :chargeID")})
public class Transaction implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Discounts")
    private String discounts;
    @Basic(optional = false)
    @Column(name = "Cards")
    private String cards;
    @Basic(optional = false)
    @Column(name = "NetBanking")
    private String netBanking;
    @Basic(optional = false)
    @Column(name = "MobileWallets")
    private String mobileWallets;
    @Id
    @Basic(optional = false)
    @Column(name = "ChargeID")
    private Integer chargeID;

    public Transaction() {
    }

    public Transaction(Integer chargeID) {
        this.chargeID = chargeID;
    }

    public Transaction(Integer chargeID, String discounts, String cards, String netBanking, String mobileWallets) {
        this.chargeID = chargeID;
        this.discounts = discounts;
        this.cards = cards;
        this.netBanking = netBanking;
        this.mobileWallets = mobileWallets;
    }

    public String getDiscounts() {
        return discounts;
    }

    public void setDiscounts(String discounts) {
        String oldDiscounts = this.discounts;
        this.discounts = discounts;
        changeSupport.firePropertyChange("discounts", oldDiscounts, discounts);
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        String oldCards = this.cards;
        this.cards = cards;
        changeSupport.firePropertyChange("cards", oldCards, cards);
    }

    public String getNetBanking() {
        return netBanking;
    }

    public void setNetBanking(String netBanking) {
        String oldNetBanking = this.netBanking;
        this.netBanking = netBanking;
        changeSupport.firePropertyChange("netBanking", oldNetBanking, netBanking);
    }

    public String getMobileWallets() {
        return mobileWallets;
    }

    public void setMobileWallets(String mobileWallets) {
        String oldMobileWallets = this.mobileWallets;
        this.mobileWallets = mobileWallets;
        changeSupport.firePropertyChange("mobileWallets", oldMobileWallets, mobileWallets);
    }

    public Integer getChargeID() {
        return chargeID;
    }

    public void setChargeID(Integer chargeID) {
        Integer oldChargeID = this.chargeID;
        this.chargeID = chargeID;
        changeSupport.firePropertyChange("chargeID", oldChargeID, chargeID);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chargeID != null ? chargeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.chargeID == null && other.chargeID != null) || (this.chargeID != null && !this.chargeID.equals(other.chargeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Transaction[ chargeID=" + chargeID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
