
package com.pharma.model;

import java.util.Date;


public class Invoice {
    private String invoiceNo;
    private String productOrderCode;
    private String supplierName;
    private String supplierContract;
    private String supplierAddress;
    private Date issueDate;
    private Date dueDate;
    private String productNames;
    private String productPrices;
    private String categoryName;
    private String totalPrice;
    private String discount;
    private String unitPrice;
    

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getProductOrderCode() {
        return productOrderCode;
    }

    public void setProductOrderCode(String productOrderCode) {
        this.productOrderCode = productOrderCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierContract() {
        return supplierContract;
    }

    public void setSupplierContract(String supplierContract) {
        this.supplierContract = supplierContract;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getProductNames() {
        return productNames;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames;
    }

    public String getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(String productPrices) {
        this.productPrices = productPrices;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String actualprice) {
        this.unitPrice = actualprice;
    }
    
}
