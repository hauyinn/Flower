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
 * @author Yong
 */
@Entity
@Table(name = "ORDERDETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o")
    , @NamedQuery(name = "Orderdetail.findByOrderid", query = "SELECT o FROM Orderdetail o WHERE o.orderid = :orderid")
    , @NamedQuery(name = "Orderdetail.findByInvoiceid", query = "SELECT o FROM Orderdetail o WHERE o.invoiceid = :invoiceid")
    , @NamedQuery(name = "Orderdetail.findByCustomerid", query = "SELECT o FROM Orderdetail o WHERE o.customerid = :customerid")
    , @NamedQuery(name = "Orderdetail.findByCustomername", query = "SELECT o FROM Orderdetail o WHERE o.customername = :customername")
    , @NamedQuery(name = "Orderdetail.findByFlowertype", query = "SELECT o FROM Orderdetail o WHERE o.flowertype = :flowertype")
    , @NamedQuery(name = "Orderdetail.findByOrderdate", query = "SELECT o FROM Orderdetail o WHERE o.orderdate = :orderdate")
    , @NamedQuery(name = "Orderdetail.findByDeliverydate", query = "SELECT o FROM Orderdetail o WHERE o.deliverydate = :deliverydate")
    , @NamedQuery(name = "Orderdetail.findByQuantity", query = "SELECT o FROM Orderdetail o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "Orderdetail.findByPrice", query = "SELECT o FROM Orderdetail o WHERE o.price = :price")
    , @NamedQuery(name = "Orderdetail.findByAddress", query = "SELECT o FROM Orderdetail o WHERE o.address = :address")})
public class Orderdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDERID")
    private String orderid;
    @Basic(optional = false)
    @Column(name = "INVOICEID")
    private String invoiceid;
    @Basic(optional = false)
    @Column(name = "CUSTOMERID")
    private String customerid;
    @Basic(optional = false)
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Basic(optional = false)
    @Column(name = "FLOWERTYPE")
    private String flowertype;
    @Basic(optional = false)
    @Column(name = "ORDERDATE")
    private String orderdate;
    @Basic(optional = false)
    @Column(name = "DELIVERYDATE")
    private String deliverydate;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private double price;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;

    public Orderdetail() {
    }

    public Orderdetail(String orderid) {
        this.orderid = orderid;
    }

    public Orderdetail(String orderid, String invoiceid, String customerid, String customername, String flowertype, String orderdate, String deliverydate, int quantity, double price, String address) {
        this.orderid = orderid;
        this.invoiceid = invoiceid;
        this.customerid = customerid;
        this.customername = customername;
        this.flowertype = flowertype;
        this.orderdate = orderdate;
        this.deliverydate = deliverydate;
        this.quantity = quantity;
        this.price = price;
        this.address = address;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getFlowertype() {
        return flowertype;
    }

    public void setFlowertype(String flowertype) {
        this.flowertype = flowertype;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Domain.Orderdetail[ orderid=" + orderid + " ]";
    }
    
}
