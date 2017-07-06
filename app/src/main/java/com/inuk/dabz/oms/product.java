package com.inuk.dabz.oms;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by CWR.Deepak.Zambre on 6/25/2017.
 */

public class product implements Parcelable {
    int productId;
    String productTitle;
    String productDesc;
    String unitOfMeasure;
    double rate;

    public double getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(double availableQty) {
        this.availableQty = availableQty;
    }

    double availableQty;
    int productIcon;

    public product(){}

    public product(int productId, String productTitle, String productDesc, String unitOfMeasure, double rate, int productIcon,double availableQty) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productDesc = productDesc;
        this.unitOfMeasure = unitOfMeasure;
        this.rate = rate;
        this.productIcon = productIcon;
        this.availableQty = availableQty;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public double getRate() {
        return rate;
    }

    public String getRate_String() {
        String currency = "Rs.";
        String rateInString = currency;
        double dRate = getRate();
        //rateInString = rateInString + (new DecimalFormat("#.##").format(dRate)) + "/"+getUnitOfMeasure();
        if (dRate % 1 == 0)
        {
            rateInString = rateInString +String.format("%d",(int) dRate) + "/"+getUnitOfMeasure();
        }
        else
        {
            rateInString = rateInString + String.format("%.2f",dRate) + "/"+getUnitOfMeasure();
        }

        return rateInString;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(int productIcon) {
        this.productIcon = productIcon;
    }

    // Extra Methods after extended to implement Parcelable interface

    /** Used to give additional hints on how to process the received parcel.*/
    @Override
    public int describeContents() {
// ignore for now
        return 0;
    }

    @Override
    public void writeToParcel(Parcel pc, int flags) {
        pc.writeInt(productId);
        pc.writeString(productDesc);
        pc.writeString(productTitle);
        pc.writeInt(productIcon);
        pc.writeDouble(rate);
        pc.writeString(unitOfMeasure);
        pc.writeDouble(availableQty);
    }

    /** Static field used to regenerate object, individually or as arrays */
    public static final Parcelable.Creator<product> CREATOR = new Parcelable.Creator<product>() {
        @Override
        public product createFromParcel(Parcel pc) {
            return new product(pc);
        }
        @Override
        public product[] newArray(int size) {
            return new product[size];
        }
    };

    private product(Parcel pc){

        // IMPORTANT NOTE - Following Read Order MUST match with WriteToParcel method object order
        this.productId = pc.readInt();
        this.productDesc = pc.readString();
        this.productTitle = pc.readString();
        this.productIcon = pc.readInt();
        this.rate = pc.readDouble();
        this.unitOfMeasure = pc.readString();
        this.availableQty = pc.readDouble();
       /* setProductId(pc.readInt());
        setProductDesc(pc.readString());
        setProductTitle(pc.readString());
        setProductIcon(pc.readInt());
        setRate(pc.readDouble());
        setUnitOfMeasure(pc.readString());*/
    }
}
