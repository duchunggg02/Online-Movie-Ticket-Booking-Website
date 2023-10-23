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
@Table(name = "nguoidung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoidung.findAll", query = "SELECT n FROM Nguoidung n"),
    @NamedQuery(name = "Nguoidung.findByNguoiDungID", query = "SELECT n FROM Nguoidung n WHERE n.nguoiDungID = :nguoiDungID"),
    @NamedQuery(name = "Nguoidung.findByUsername", query = "SELECT n FROM Nguoidung n WHERE n.username = :username"),
    @NamedQuery(name = "Nguoidung.findByPassword", query = "SELECT n FROM Nguoidung n WHERE n.password = :password"),
    @NamedQuery(name = "Nguoidung.findByHo", query = "SELECT n FROM Nguoidung n WHERE n.ho = :ho"),
    @NamedQuery(name = "Nguoidung.findByTen", query = "SELECT n FROM Nguoidung n WHERE n.ten = :ten"),
    @NamedQuery(name = "Nguoidung.findByHinhDaiDien", query = "SELECT n FROM Nguoidung n WHERE n.hinhDaiDien = :hinhDaiDien")})
public class Nguoidung implements Serializable {

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungID")
    private Set<Ve> veSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NguoiDungID")
    private Integer nguoiDungID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ho")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ten")
    private String ten;
    @Size(max = 200)
    @Column(name = "HinhDaiDien")
    private String hinhDaiDien;
    @JoinColumn(name = "VaiTroID", referencedColumnName = "VaiTroID")
    @ManyToOne(optional = false)
    private Vaitro vaiTroID;
    @Transient
    private String confirmPassword;
    @Transient
    private MultipartFile file;

    public Nguoidung() {
    }

    public Nguoidung(Integer nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    public Nguoidung(Integer nguoiDungID, String username, String password, String ho, String ten) {
        this.nguoiDungID = nguoiDungID;
        this.username = username;
        this.password = password;
        this.ho = ho;
        this.ten = ten;
    }

    public Integer getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(Integer nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinhDaiDien() {
        return hinhDaiDien;
    }

    public void setHinhDaiDien(String hinhDaiDien) {
        this.hinhDaiDien = hinhDaiDien;
    }

    public Vaitro getVaiTroID() {
        return vaiTroID;
    }

    public void setVaiTroID(Vaitro vaiTroID) {
        this.vaiTroID = vaiTroID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nguoiDungID != null ? nguoiDungID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nguoidung)) {
            return false;
        }
        Nguoidung other = (Nguoidung) object;
        if ((this.nguoiDungID == null && other.nguoiDungID != null) || (this.nguoiDungID != null && !this.nguoiDungID.equals(other.nguoiDungID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndh.pojo.Nguoidung[ nguoiDungID=" + nguoiDungID + " ]";
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    @XmlTransient
    public Set<Ve> getVeSet() {
        return veSet;
    }

    public void setVeSet(Set<Ve> veSet) {
        this.veSet = veSet;
    }

}
