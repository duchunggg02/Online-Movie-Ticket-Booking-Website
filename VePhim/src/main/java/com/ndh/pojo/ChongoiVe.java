/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duc Hung
 */
@Entity
@Table(name = "chongoi_ve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChongoiVe.findAll", query = "SELECT c FROM ChongoiVe c"),
    @NamedQuery(name = "ChongoiVe.findByChoNgoiVeID", query = "SELECT c FROM ChongoiVe c WHERE c.choNgoiVeID = :choNgoiVeID")})
public class ChongoiVe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ChoNgoiVeID")
    private Integer choNgoiVeID;
    @JoinColumn(name = "ChoNgoiSuatChieuID", referencedColumnName = "ChoNgoiSuatChieuID")
    @ManyToOne(optional = false)
    private ChongoiSuatchieu choNgoiSuatChieuID;
    @JoinColumn(name = "VeID", referencedColumnName = "VeID")
    @ManyToOne(optional = false)
    private Ve veID;

    public ChongoiVe() {
    }

    public ChongoiVe(Integer choNgoiVeID) {
        this.choNgoiVeID = choNgoiVeID;
    }

    public Integer getChoNgoiVeID() {
        return choNgoiVeID;
    }

    public void setChoNgoiVeID(Integer choNgoiVeID) {
        this.choNgoiVeID = choNgoiVeID;
    }

    public ChongoiSuatchieu getChoNgoiSuatChieuID() {
        return choNgoiSuatChieuID;
    }

    public void setChoNgoiSuatChieuID(ChongoiSuatchieu choNgoiSuatChieuID) {
        this.choNgoiSuatChieuID = choNgoiSuatChieuID;
    }

    public Ve getVeID() {
        return veID;
    }

    public void setVeID(Ve veID) {
        this.veID = veID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (choNgoiVeID != null ? choNgoiVeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChongoiVe)) {
            return false;
        }
        ChongoiVe other = (ChongoiVe) object;
        if ((this.choNgoiVeID == null && other.choNgoiVeID != null) || (this.choNgoiVeID != null && !this.choNgoiVeID.equals(other.choNgoiVeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.ChongoiVe[ choNgoiVeID=" + choNgoiVeID + " ]";
    }
    
}
