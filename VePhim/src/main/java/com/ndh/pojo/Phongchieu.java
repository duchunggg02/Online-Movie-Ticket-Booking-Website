/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Duc Hung
 */
@Entity
@Table(name = "phongchieu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phongchieu.findAll", query = "SELECT p FROM Phongchieu p"),
    @NamedQuery(name = "Phongchieu.findByPhongChieuID", query = "SELECT p FROM Phongchieu p WHERE p.phongChieuID = :phongChieuID"),
    @NamedQuery(name = "Phongchieu.findByTenPhongChieu", query = "SELECT p FROM Phongchieu p WHERE p.tenPhongChieu = :tenPhongChieu"),
    @NamedQuery(name = "Phongchieu.findBySoLuongGhe", query = "SELECT p FROM Phongchieu p WHERE p.soLuongGhe = :soLuongGhe")})
public class Phongchieu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PhongChieuID")
    private Integer phongChieuID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenPhongChieu")
    private String tenPhongChieu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLuongGhe")
    private int soLuongGhe;
    @JoinColumn(name = "RapPhimID", referencedColumnName = "RapPhimID")
    @ManyToOne(optional = false)
    private Rapphim rapPhimID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phongChieuID")
    @JsonIgnore
    private Set<Suatchieu> suatchieuSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phongChieuID")
    @JsonIgnore
    private Set<Chongoi> chongoiSet;

    @OneToMany(mappedBy = "phongChieuID", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Chongoi> chongoiList;

    public Phongchieu() {
    }

    public Phongchieu(Integer phongChieuID) {
        this.phongChieuID = phongChieuID;
    }

    public Phongchieu(Integer phongChieuID, String tenPhongChieu, int soLuongGhe) {
        this.phongChieuID = phongChieuID;
        this.tenPhongChieu = tenPhongChieu;
        this.soLuongGhe = soLuongGhe;
    }

    public Integer getPhongChieuID() {
        return phongChieuID;
    }

    public void setPhongChieuID(Integer phongChieuID) {
        this.phongChieuID = phongChieuID;
    }

    public String getTenPhongChieu() {
        return tenPhongChieu;
    }

    public void setTenPhongChieu(String tenPhongChieu) {
        this.tenPhongChieu = tenPhongChieu;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public Rapphim getRapPhimID() {
        return rapPhimID;
    }

    public void setRapPhimID(Rapphim rapPhimID) {
        this.rapPhimID = rapPhimID;
    }

    @XmlTransient
    public Set<Suatchieu> getSuatchieuSet() {
        return suatchieuSet;
    }

    public void setSuatchieuSet(Set<Suatchieu> suatchieuSet) {
        this.suatchieuSet = suatchieuSet;
    }

    @XmlTransient
    public Set<Chongoi> getChongoiSet() {
        return chongoiSet;
    }

    public void setChongoiSet(Set<Chongoi> chongoiSet) {
        this.chongoiSet = chongoiSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phongChieuID != null ? phongChieuID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phongchieu)) {
            return false;
        }
        Phongchieu other = (Phongchieu) object;
        if ((this.phongChieuID == null && other.phongChieuID != null) || (this.phongChieuID != null && !this.phongChieuID.equals(other.phongChieuID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.Phongchieu[ phongChieuID=" + phongChieuID + " ]";
    }

    /**
     * @return the chongoiList
     */
    public List<Chongoi> getChongoiList() {
        return chongoiList;
    }

    /**
     * @param chongoiList the chongoiList to set
     */
    public void setChongoiList(List<Chongoi> chongoiList) {
        this.chongoiList = chongoiList;
    }

}
