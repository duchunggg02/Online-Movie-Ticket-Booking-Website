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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Duc Hung
 */
@Entity
@Table(name = "phim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phim.findAll", query = "SELECT p FROM Phim p"),
    @NamedQuery(name = "Phim.findByPhimID", query = "SELECT p FROM Phim p WHERE p.phimID = :phimID"),
    @NamedQuery(name = "Phim.findByTenPhim", query = "SELECT p FROM Phim p WHERE p.tenPhim = :tenPhim"),
    @NamedQuery(name = "Phim.findByMoTa", query = "SELECT p FROM Phim p WHERE p.moTa = :moTa"),
    @NamedQuery(name = "Phim.findByNgayPhatHanh", query = "SELECT p FROM Phim p WHERE p.ngayPhatHanh = :ngayPhatHanh"),
    @NamedQuery(name = "Phim.findByThoiLuong", query = "SELECT p FROM Phim p WHERE p.thoiLuong = :thoiLuong"),
    @NamedQuery(name = "Phim.findByAnhPhim", query = "SELECT p FROM Phim p WHERE p.anhPhim = :anhPhim")})
public class Phim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PhimID")
    private Integer phimID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TenPhim")
    private String tenPhim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "MoTa")
    private String moTa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayPhatHanh")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayPhatHanh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ThoiLuong")
    private String thoiLuong;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "AnhPhim")
    private String anhPhim;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phimID")
    @JsonIgnore
    private Set<Suatchieu> suatchieuSet;

    @Transient
    private MultipartFile file;

    public Phim() {
    }

    public Phim(Integer phimID) {
        this.phimID = phimID;
    }

    public Phim(Integer phimID, String tenPhim, String moTa, Date ngayPhatHanh, String thoiLuong, String anhPhim) {
        this.phimID = phimID;
        this.tenPhim = tenPhim;
        this.moTa = moTa;
        this.ngayPhatHanh = ngayPhatHanh;
        this.thoiLuong = thoiLuong;
        this.anhPhim = anhPhim;
    }

    public Integer getPhimID() {
        return phimID;
    }

    public void setPhimID(Integer phimID) {
        this.phimID = phimID;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(Date ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getAnhPhim() {
        return anhPhim;
    }

    public void setAnhPhim(String anhPhim) {
        this.anhPhim = anhPhim;
    }

    @XmlTransient
    public Set<Suatchieu> getSuatchieuSet() {
        return suatchieuSet;
    }

    public void setSuatchieuSet(Set<Suatchieu> suatchieuSet) {
        this.suatchieuSet = suatchieuSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phimID != null ? phimID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phim)) {
            return false;
        }
        Phim other = (Phim) object;
        if ((this.phimID == null && other.phimID != null) || (this.phimID != null && !this.phimID.equals(other.phimID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.Phim[ phimID=" + phimID + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
