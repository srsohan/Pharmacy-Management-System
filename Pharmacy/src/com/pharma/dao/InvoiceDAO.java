
package com.pharma.dao;

import com.pharma.common.ICommonInterface;
import com.pharma.model.Invoice;
import com.pharma.util.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InvoiceDAO implements ICommonInterface<Invoice>{
    Connection con;
    PreparedStatement ps;

    @Override
    public int save(Invoice t) {
        String sql = "insert into invoice (invoice_no, product_order_code, supplier_name, supplier_contract, supplier_address, issue_date, due_date, product_names, product_prices, category_name, total_price, discount, unit_price) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        String sql = "insert into invoice (invoice_no, product_order_code) values( ?, ?)";
        int status = 0;
        try {
            System.out.println("Well it's printing");
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getInvoiceNo());
            ps.setString(2, t.getProductOrderCode());
            System.out.println(t.getInvoiceNo() +" " + t.getProductOrderCode());
            ps.setString(3, t.getSupplierName());
            ps.setString(4, t.getSupplierContract());
            ps.setString(5, t.getSupplierAddress());
            ps.setDate(6, new Date(t.getIssueDate().getTime()));
            ps.setDate(7, new Date(t.getDueDate().getTime()));
            ps.setString(8, t.getProductNames());
            ps.setString(9, t.getProductPrices());
            ps.setString(10, t.getCategoryName());
            ps.setString(11, t.getTotalPrice());
            ps.setString(12, t.getDiscount());
            ps.setString(13, t.getUnitPrice());
            status = ps.executeUpdate();
        } catch (Exception e) {
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }

    @Override
    public Invoice edit(Invoice t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Invoice t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Invoice getbyCode(int code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Invoice> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Invoice t) {
        String sql = "update invoice set invoice_no = ?, product_order_code = ?, supplier_name = ?, supplier_contract = ?, supplier_address = ?, issue_date = ?, due_date = ?, product_names = ?, product_prices = ?, category_name = ?, total_price = ?, discount = ?, unit_price = ? where invoice_no = ?";
        int status = 0;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getInvoiceNo());
            ps.setString(2, t.getProductOrderCode());
            System.out.println(t.getInvoiceNo() +" " + t.getProductOrderCode());
            ps.setString(3, t.getSupplierName());
            ps.setString(4, t.getSupplierContract());
            ps.setString(5, t.getSupplierAddress());
            ps.setDate(6, new Date(t.getIssueDate().getTime()));
            ps.setDate(7, new Date(t.getDueDate().getTime()));
            ps.setString(8, t.getProductNames());
            ps.setString(9, t.getProductPrices());
            ps.setString(10, t.getCategoryName());
            ps.setString(11, t.getTotalPrice());
            ps.setString(12, t.getDiscount());
            ps.setString(13, t.getUnitPrice());
            ps.setString(14, t.getInvoiceNo());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }
    }

    