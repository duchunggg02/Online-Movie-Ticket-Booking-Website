/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Duc Hung
 */
@Entity
@Table(name = "suatchieu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suatchieu.findAll", query = "SELECT s FROM Suatchieu s"),
    @NamedQuery(name = "Suatchieu.findBySuatChieuID", query = "SELECT s FROM Suatchieu s WHERE s.suatChieuID = :suatChieuID"),
    @NamedQuery(name = "Suatchieu.findByNgayChieu", query = "SELECT s FROM Suatchieu s WHERE s.ngayChieu = :ngayChieu"),
    @NamedQuery(name = "Suatchieu.findByGioChieu", query = "SELECT s FROM Suatchieu s WHERE s.gioChieu = :gioChieu"),
    @NamedQuery(name = "Suatchieu.findByGiaTien", query = "SELECT s FROM Suatchieu s WHERE s.giaTien = :giaTien")})
public class Suatchieu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SuatChieuID")
    private Integer suatChieuID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayChieu")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayChieu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GioChieu")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date gioChieu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GiaTien")
    private int giaTien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suatChieuID")
    @JsonIgnore
    private Set<ChongoiSuatchieu> chongoiSuatchieuSet;
    @JoinColumn(name = "PhimID", referencedColumnName = "PhimID")
    @ManyToOne(optional = false)
    private Phim phimID;
    @JoinColumn(name = "PhongChieuID", referencedColumnName = "PhongChieuID")
    @ManyToOne(optional = false)
    private Phongchieu phongChieuID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suatChieuID")
    @JsonIgnore
    private Set<Ve> veSet;

    public Suatchieu() {
    }

    public Suatchieu(Integer suatChieuID) {
        this.suatChieuID = suatChieuID;
    }

    public Suatchieu(Integer suatChieuID, Date ngayChieu, Date gioChieu, int giaTien) {
        this.suatChieuID = suatChieuID;
        this.ngayChieu = ngayChieu;
        this.gioChieu = gioChieu;
        this.giaTien = giaTien;
    }

    public Integer getSuatChieuID() {
        return suatChieuID;
    }

    public void setSuatChieuID(Integer suatChieuID) {
        this.suatChieuID = suatChieuID;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Date getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(Date gioChieu) {
        this.gioChieu = gioChieu;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    @XmlTransient
    public Set<ChongoiSuatchieu> getChongoiSuatchieuSet() {
        return chongoiSuatchieuSet;
    }

    public void setChongoiSuatchieuSet(Set<ChongoiSuatchieu> chongoiSuatchieuSet) {
        this.chongoiSuatchieuSet = chongoiSuatchieuSet;
    }

    public Phim getPhimID() {
        return phimID;
    }

    public void setPhimID(Phim phimID) {
        this.phimID = phimID;
    }

    public Phongchieu getPhongChieuID() {
        return phongChieuID;
    }

    public void setPhongChieuID(Phongchieu phongChieuID) {
        this.phongChieuID = phongChieuID;
    }

    @XmlTransient
    public Set<Ve> getVeSet() {
        return veSet;
    }

    public void setVeSet(Set<Ve> veSet) {
        this.veSet = veSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suatChieuID != null ? suatChieuID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suatchieu)) {
            return false;
        }
        Suatchieu other = (Suatchieu) object;
        if ((this.suatChieuID == null && other.suatChieuID != null) || (this.suatChieuID != null && !this.suatChieuID.equals(other.suatChieuID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.Suatchieu[ suatChieuID=" + suatChieuID + " ]";
    }

}
