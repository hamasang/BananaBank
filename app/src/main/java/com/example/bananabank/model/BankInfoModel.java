package com.example.bananabank.model;

/**
 * Bank 관련 데이터
 */
public class BankInfoModel {

    // home bank
    private String homeBank = "";

    // safe bank
    private String safeBank = "";

    public void setHomeBank(String homeBank) {
        this.homeBank = homeBank;
    }

    public void setSafeBank(String safeBank) {
        this.safeBank = safeBank;
    }

    public String getHomeBank() {
        return homeBank;
    }

    public String getSafeBank() {
        return safeBank;
    }
}
