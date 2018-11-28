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
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByProductname", query = "SELECT p FROM Product p WHERE p.productname = :productname")
    , @NamedQuery(name = "Product.findByProductdesciption", query = "SELECT p FROM Product p WHERE p.productdesciption = :productdesciption")
    , @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Product.findByProducttype", query = "SELECT p FROM Product p WHERE p.producttype = :producttype")
    , @NamedQuery(name = "Product.findByProductprice", query = "SELECT p FROM Product p WHERE p.productprice = :productprice")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Column(name = "PRODUCTDESCIPTION")
    private String productdesciption;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "PRODUCTTYPE")
    private String producttype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRODUCTPRICE")
    private Double productprice;

    public Product() {
    }

    public Product(String productname) {
        this.productname = productname;
    }
    
    public Product(String productname,String productDescription,int quantity,String producttype,double productprice) {
        this.productname = productname;
        this.productdesciption=productDescription;
        this.quantity=quantity;
        this.producttype=producttype;
        this.productprice=productprice;
    }


    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdesciption() {
        return productdesciption;
    }

    public void setProductdesciption(String productdesciption) {
        this.productdesciption = productdesciption;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productname != null ? productname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productname == null && other.productname != null) || (this.productname != null && !this.productname.equals(other.productname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Product[ productname=" + productname + " ]";
    }
    
}
