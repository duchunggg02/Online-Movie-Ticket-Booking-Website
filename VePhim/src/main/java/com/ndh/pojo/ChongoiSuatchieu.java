/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Duc Hung
 */
@Entity
@Table(name = "chongoi_suatchieu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChongoiSuatchieu.findAll", query = "SELECT c FROM ChongoiSuatchieu c"),
    @NamedQuery(name = "ChongoiSuatchieu.findByChoNgoiSuatChieuID", query = "SELECT c FROM ChongoiSuatchieu c WHERE c.choNgoiSuatChieuID = :choNgoiSuatChieuID"),
    @NamedQuery(name = "ChongoiSuatchieu.findByTrangThai", query = "SELECT c FROM ChongoiSuatchieu c WHERE c.trangThai = :trangThai")})
public class ChongoiSuatchieu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ChoNgoiSuatChieuID")
    private Integer choNgoiSuatChieuID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TrangThai")
    private boolean trangThai;
    @JoinColumn(name = "ChoNgoiID", referencedColumnName = "ChoNgoiID")
    @ManyToOne(optional = false)
    private Chongoi choNgoiID;
    @JoinColumn(name = "SuatChieuID", referencedColumnName = "SuatChieuID")
    @ManyToOne(optional = false)
    private Suatchieu suatChieuID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "choNgoiSuatChieuID")
    @JsonIgnore
    private Set<ChongoiVe> chongoiVeSet;

    public ChongoiSuatchieu() {
    }

    public ChongoiSuatchieu(Integer choNgoiSuatChieuID) {
        this.choNgoiSuatChieuID = choNgoiSuatChieuID;
    }

    public ChongoiSuatchieu(Integer choNgoiSuatChieuID, boolean trangThai) {
        this.choNgoiSuatChieuID = choNgoiSuatChieuID;
        this.trangThai = trangThai;
    }

    public Integer getChoNgoiSuatChieuID() {
        return choNgoiSuatChieuID;
    }

    public void setChoNgoiSuatChieuID(Integer choNgoiSuatChieuID) {
        this.choNgoiSuatChieuID = choNgoiSuatChieuID;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Chongoi getChoNgoiID() {
        return choNgoiID;
    }

    public void setChoNgoiID(Chongoi choNgoiID) {
        this.choNgoiID = choNgoiID;
    }

    public Suatchieu getSuatChieuID() {
        return suatChieuID;
    }

    public void setSuatChieuID(Suatchieu suatChieuID) {
        this.suatChieuID = suatChieuID;
    }

    @XmlTransient
    public Set<ChongoiVe> getChongoiVeSet() {
        return chongoiVeSet;
    }

    public void setChongoiVeSet(Set<ChongoiVe> chongoiVeSet) {
        this.chongoiVeSet = chongoiVeSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (choNgoiSuatChieuID != null ? choNgoiSuatChieuID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChongoiSuatchieu)) {
            return false;
        }
        ChongoiSuatchieu other = (ChongoiSuatchieu) object;
        if ((this.choNgoiSuatChieuID == null && other.choNgoiSuatChieuID != null) || (this.choNgoiSuatChieuID != null && !this.choNgoiSuatChieuID.equals(other.choNgoiSuatChieuID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.ChongoiSuatchieu[ choNgoiSuatChieuID=" + choNgoiSuatChieuID + " ]";
    }
    
}
