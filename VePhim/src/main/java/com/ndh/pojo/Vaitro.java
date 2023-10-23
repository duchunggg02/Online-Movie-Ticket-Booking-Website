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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Duc Hung
 */
@Entity
@Table(name = "vaitro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vaitro.findAll", query = "SELECT v FROM Vaitro v"),
    @NamedQuery(name = "Vaitro.findByVaiTroID", query = "SELECT v FROM Vaitro v WHERE v.vaiTroID = :vaiTroID"),
    @NamedQuery(name = "Vaitro.findByTenVaiTro", query = "SELECT v FROM Vaitro v WHERE v.tenVaiTro = :tenVaiTro")})
public class Vaitro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VaiTroID")
    private Integer vaiTroID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenVaiTro")
    private String tenVaiTro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vaiTroID")
    @JsonIgnore
    private Set<Nguoidung> nguoidungSet;

    public Vaitro() {
    }

    public Vaitro(Integer vaiTroID) {
        this.vaiTroID = vaiTroID;
    }

    public Vaitro(Integer vaiTroID, String tenVaiTro) {
        this.vaiTroID = vaiTroID;
        this.tenVaiTro = tenVaiTro;
    }

    public Integer getVaiTroID() {
        return vaiTroID;
    }

    public void setVaiTroID(Integer vaiTroID) {
        this.vaiTroID = vaiTroID;
    }

    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

    @XmlTransient
    public Set<Nguoidung> getNguoidungSet() {
        return nguoidungSet;
    }

    public void setNguoidungSet(Set<Nguoidung> nguoidungSet) {
        this.nguoidungSet = nguoidungSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vaiTroID != null ? vaiTroID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vaitro)) {
            return false;
        }
        Vaitro other = (Vaitro) object;
        if ((this.vaiTroID == null && other.vaiTroID != null) || (this.vaiTroID != null && !this.vaiTroID.equals(other.vaiTroID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.Vaitro[ vaiTroID=" + vaiTroID + " ]";
    }

}
