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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

/**
 *
 * @author Duc Hung
 */
@Entity
@Table(name = "chongoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chongoi.findAll", query = "SELECT c FROM Chongoi c"),
    @NamedQuery(name = "Chongoi.findByChoNgoiID", query = "SELECT c FROM Chongoi c WHERE c.choNgoiID = :choNgoiID"),
    @NamedQuery(name = "Chongoi.findBySoGhe", query = "SELECT c FROM Chongoi c WHERE c.soGhe = :soGhe")})
public class Chongoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ChoNgoiID")
    private Integer choNgoiID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SoGhe")
    private String soGhe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "choNgoiID")
    @JsonIgnore
    private Set<ChongoiSuatchieu> chongoiSuatchieuSet;
    @JoinColumn(name = "PhongChieuID", referencedColumnName = "PhongChieuID")
    @ManyToOne(optional = false)
    private Phongchieu phongChieuID;

    public Chongoi() {
    }

    public Chongoi(Integer choNgoiID) {
        this.choNgoiID = choNgoiID;
    }

    public Chongoi(Integer choNgoiID, String soGhe) {
        this.choNgoiID = choNgoiID;
        this.soGhe = soGhe;
    }

    public Integer getChoNgoiID() {
        return choNgoiID;
    }

    public void setChoNgoiID(Integer choNgoiID) {
        this.choNgoiID = choNgoiID;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public Phongchieu getPhongChieuID() {
        return phongChieuID;
    }

    public void setPhongChieuID(Phongchieu phongChieuID) {
        this.phongChieuID = phongChieuID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (choNgoiID != null ? choNgoiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chongoi)) {
            return false;
        }
        Chongoi other = (Chongoi) object;
        if ((this.choNgoiID == null && other.choNgoiID != null) || (this.choNgoiID != null && !this.choNgoiID.equals(other.choNgoiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.Chongoi[ choNgoiID=" + choNgoiID + " ]";
    }

    /**
     * @return the chongoiSuatchieuSet
     */
    public Set<ChongoiSuatchieu> getChongoiSuatchieuSet() {
        return chongoiSuatchieuSet;
    }

    /**
     * @param chongoiSuatchieuSet the chongoiSuatchieuSet to set
     */
    public void setChongoiSuatchieuSet(Set<ChongoiSuatchieu> chongoiSuatchieuSet) {
        this.chongoiSuatchieuSet = chongoiSuatchieuSet;
    }
    
}
