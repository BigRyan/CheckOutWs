package com.example.demo.model;

/**
 * Created by renliang on 2019/9/8.
 */
public class Watch {
    private int id;
    private String watchNo;
    private String watchName;
    private int unitPrice;
    private int discountEligibleCount;
    private int discountPrice;

    public Watch(int id, String watchNo, String watchName, int unitPrice, int discountEligibleCount, int discountPrice) {
        this.id = id;
        this.watchNo = watchNo;
        this.watchName = watchName;
        this.unitPrice = unitPrice;
        this.discountEligibleCount = discountEligibleCount;
        this.discountPrice = discountPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWatchNo() {
        return watchNo;
    }

    public void setWatchNo(String watchNo) {
        this.watchNo = watchNo;
    }

    public String getWatchName() {
        return watchName;
    }

    public void setWatchName(String watchName) {
        this.watchName = watchName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscountEligibleCount() {
        return discountEligibleCount;
    }

    public void setDiscountEligibleCount(int discountEligibleCount) {
        this.discountEligibleCount = discountEligibleCount;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return String.format("Watch [id=%s, watchNo=%s, watchName=%s, unitPrice=%s, " +
                "discountEligibleCount=%s, discountPrice=%s]"
                , id, watchNo, watchName, unitPrice, discountEligibleCount, discountPrice);
    }
}
