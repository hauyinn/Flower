/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AL
 */
@Entity
@Table(name = "PROMOTIONPRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotionproduct.findAll", query = "SELECT p FROM Promotionproduct p")
    , @NamedQuery(name = "Promotionproduct.findByPromotiomitemid", query = "SELECT p FROM Promotionproduct p WHERE p.promotiomitemid = :promotiomitemid")
    , @NamedQuery(name = "Promotionproduct.findByProductname", query = "SELECT p FROM Promotionproduct p WHERE p.productname = :productname")
    , @NamedQuery(name = "Promotionproduct.findByPromotionname", query = "SELECT p FROM Promotionproduct p WHERE p.promotionname = :promotionname")
    , @NamedQuery(name = "Promotionproduct.findByDiscountprice", query = "SELECT p FROM Promotionproduct p WHERE p.discountprice = :discountprice")})
public class Promotionproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROMOTIOMITEMID")
    private String promotiomitemid;
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Column(name = "PROMOTIONNAME")
    private String promotionname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISCOUNTPRICE")
    private Double discountprice;

    public Promotionproduct() {
    }

    public Promotionproduct(String promotiomitemid) {
        this.promotiomitemid = promotiomitemid;
    }
    
        public Promotionproduct(String promotiomitemid,String productname,String promotionname,double discountprice) {
        this.promotiomitemid = promotiomitemid;
        this.productname= productname;
        this.promotionname=promotionname;
        this.discountprice=discountprice;
    }

    public String getPromotiomitemid() {
        return promotiomitemid;
    }

    public void setPromotiomitemid(String promotiomitemid) {
        this.promotiomitemid = promotiomitemid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPromotionname() {
        return promotionname;
    }

    public void setPromotionname(String promotionname) {
        this.promotionname = promotionname;
    }

    public Double getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(Double discountprice) {
        this.discountprice = discountprice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promotiomitemid != null ? promotiomitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotionproduct)) {
            return false;
        }
        Promotionproduct other = (Promotionproduct) object;
        if ((this.promotiomitemid == null && other.promotiomitemid != null) || (this.promotiomitemid != null && !this.promotiomitemid.equals(other.promotiomitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Domain.Promotionproduct[ promotiomitemid=" + promotiomitemid + " ]";
    }
    
}
