package com.Capagamini.entity;

public class Customer {

    private Integer customerId;

    private String customerName;

    private String customerEmail;

    public Customer() {
        super();
    }

    public Customer(Integer customerId, String customerName, String customerEmail) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }



    @Override
    public String toString() {
        return customerId + "," + customerName + "," + customerEmail;
    }
}
