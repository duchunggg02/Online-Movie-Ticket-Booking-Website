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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Duc Hung
 */
@Entity
@Table(name = "rapphim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rapphim.findAll", query = "SELECT r FROM Rapphim r"),
    @NamedQuery(name = "Rapphim.findByRapPhimID", query = "SELECT r FROM Rapphim r WHERE r.rapPhimID = :rapPhimID"),
    @NamedQuery(name = "Rapphim.findByTenRapPhim", query = "SELECT r FROM Rapphim r WHERE r.tenRapPhim = :tenRapPhim"),
    @NamedQuery(name = "Rapphim.findByDiaChi", query = "SELECT r FROM Rapphim r WHERE r.diaChi = :diaChi"),
    @NamedQuery(name = "Rapphim.findByAnhRap", query = "SELECT r FROM Rapphim r WHERE r.anhRap = :anhRap")})
public class Rapphim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RapPhimID")
    private Integer rapPhimID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenRapPhim")
    private String tenRapPhim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DiaChi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "AnhRap")
    private String anhRap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rapPhimID")
    @JsonIgnore
    private Set<Phongchieu> phongchieuSet;

    @Transient
    private MultipartFile file;

    public Rapphim() {
    }

    public Rapphim(Integer rapPhimID) {
        this.rapPhimID = rapPhimID;
    }

    public Rapphim(Integer rapPhimID, String tenRapPhim, String diaChi, String anhRap) {
        this.rapPhimID = rapPhimID;
        this.tenRapPhim = tenRapPhim;
        this.diaChi = diaChi;
        this.anhRap = anhRap;
    }

    public Integer getRapPhimID() {
        return rapPhimID;
    }

    public void setRapPhimID(Integer rapPhimID) {
        this.rapPhimID = rapPhimID;
    }

    public String getTenRapPhim() {
        return tenRapPhim;
    }

    public void setTenRapPhim(String tenRapPhim) {
        this.tenRapPhim = tenRapPhim;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getAnhRap() {
        return anhRap;
    }

    public void setAnhRap(String anhRap) {
        this.anhRap = anhRap;
    }

    @XmlTransient
    public Set<Phongchieu> getPhongchieuSet() {
        return phongchieuSet;
    }

    public void setPhongchieuSet(Set<Phongchieu> phongchieuSet) {
        this.phongchieuSet = phongchieuSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rapPhimID != null ? rapPhimID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rapphim)) {
            return false;
        }
        Rapphim other = (Rapphim) object;
        if ((this.rapPhimID == null && other.rapPhimID != null) || (this.rapPhimID != null && !this.rapPhimID.equals(other.rapPhimID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.Rapphim[ rapPhimID=" + rapPhimID + " ]";
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
