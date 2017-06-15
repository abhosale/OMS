package com.inuk.dabz.oms;

/**
 * Created by Home on 13/06/2017.
 */

public class UserOrder {

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSrep() {
        return srep;
    }

    public void setSrep(String srep) {
        this.srep = srep;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public  String product;
    public  String srep;
    public  String qty;
    public  String rate;
    public  String total;
}
