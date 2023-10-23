/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.pojo;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "phanhoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phanhoi.findAll", query = "SELECT p FROM Phanhoi p"),
    @NamedQuery(name = "Phanhoi.findByPhanHoiID", query = "SELECT p FROM Phanhoi p WHERE p.phanHoiID = :phanHoiID"),
    @NamedQuery(name = "Phanhoi.findByNoiDung", query = "SELECT p FROM Phanhoi p WHERE p.noiDung = :noiDung"),
    @NamedQuery(name = "Phanhoi.findByNgayTao", query = "SELECT p FROM Phanhoi p WHERE p.ngayTao = :ngayTao")})
public class Phanhoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PhanHoiID")
    private Integer phanHoiID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NoiDung")
    private String noiDung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayTao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayTao;
    @JoinColumn(name = "VeID", referencedColumnName = "VeID")
    @ManyToOne(optional = false)
    private Ve veID;

    public Phanhoi() {
    }

    public Phanhoi(Integer phanHoiID) {
        this.phanHoiID = phanHoiID;
    }

    public Phanhoi(Integer phanHoiID, String noiDung, Date ngayTao) {
        this.phanHoiID = phanHoiID;
        this.noiDung = noiDung;
        this.ngayTao = ngayTao;
    }

    public Integer getPhanHoiID() {
        return phanHoiID;
    }

    public void setPhanHoiID(Integer phanHoiID) {
        this.phanHoiID = phanHoiID;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
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
        hash += (phanHoiID != null ? phanHoiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phanhoi)) {
            return false;
        }
        Phanhoi other = (Phanhoi) object;
        if ((this.phanHoiID == null && other.phanHoiID != null) || (this.phanHoiID != null && !this.phanHoiID.equals(other.phanHoiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.Phanhoi[ phanHoiID=" + phanHoiID + " ]";
    }
    
}
