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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Duc Hung
 */
@Entity
@Table(name = "ve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ve.findAll", query = "SELECT v FROM Ve v"),
    @NamedQuery(name = "Ve.findByVeID", query = "SELECT v FROM Ve v WHERE v.veID = :veID"),
    @NamedQuery(name = "Ve.findByNgayDat", query = "SELECT v FROM Ve v WHERE v.ngayDat = :ngayDat"),
    @NamedQuery(name = "Ve.findByPhuongThucThanhToan", query = "SELECT v FROM Ve v WHERE v.phuongThucThanhToan = :phuongThucThanhToan"),
    @NamedQuery(name = "Ve.findByTinhTrang", query = "SELECT v FROM Ve v WHERE v.tinhTrang = :tinhTrang"),
    @NamedQuery(name = "Ve.findByGia", query = "SELECT v FROM Ve v WHERE v.gia = :gia")})
public class Ve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VeID")
    private Integer veID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayDat")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayDat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PhuongThucThanhToan")
    private String phuongThucThanhToan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TinhTrang")
    private boolean tinhTrang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gia")
    private int gia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veID")
    @JsonIgnore
    private Set<Phanhoi> phanhoiSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veID")
    @JsonIgnore
    private Set<ChongoiVe> chongoiVeSet;
    @JoinColumn(name = "NguoiDungID", referencedColumnName = "NguoiDungID")
    @ManyToOne(optional = false)
    private Nguoidung nguoiDungID;
    @JoinColumn(name = "SuatChieuID", referencedColumnName = "SuatChieuID")
    @ManyToOne(optional = false)
    private Suatchieu suatChieuID;

    public Ve() {
    }

    public Ve(Integer veID) {
        this.veID = veID;
    }

    public Ve(Integer veID, Date ngayDat, String phuongThucThanhToan, boolean tinhTrang, int gia) {
        this.veID = veID;
        this.ngayDat = ngayDat;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.tinhTrang = tinhTrang;
        this.gia = gia;
    }

    public Integer getVeID() {
        return veID;
    }

    public void setVeID(Integer veID) {
        this.veID = veID;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public Nguoidung getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(Nguoidung nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    public Suatchieu getSuatChieuID() {
        return suatChieuID;
    }

    public void setSuatChieuID(Suatchieu suatChieuID) {
        this.suatChieuID = suatChieuID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (veID != null ? veID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ve)) {
            return false;
        }
        Ve other = (Ve) object;
        if ((this.veID == null && other.veID != null) || (this.veID != null && !this.veID.equals(other.veID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.Ve[ veID=" + veID + " ]";
    }

    /**
     * @return the phanhoiSet
     */
    public Set<Phanhoi> getPhanhoiSet() {
        return phanhoiSet;
    }

    /**
     * @param phanhoiSet the phanhoiSet to set
     */
    public void setPhanhoiSet(Set<Phanhoi> phanhoiSet) {
        this.phanhoiSet = phanhoiSet;
    }

    /**
     * @return the chongoiVeSet
     */
    public Set<ChongoiVe> getChongoiVeSet() {
        return chongoiVeSet;
    }

    /**
     * @param chongoiVeSet the chongoiVeSet to set
     */
    public void setChongoiVeSet(Set<ChongoiVe> chongoiVeSet) {
        this.chongoiVeSet = chongoiVeSet;
    }
    
}
