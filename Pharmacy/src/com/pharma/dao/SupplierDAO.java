
package com.pharma.dao;

import com.pharma.common.ICommonInterface;
import com.pharma.model.Product;
import com.pharma.model.Supplier;
import com.pharma.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SupplierDAO implements ICommonInterface<Supplier>{
    Connection con;
    PreparedStatement ps;

    @Override
    public int save(Supplier s) {
        String sql = "insert into supplier (supplier_code, supplier_name, company_code, company_name, supplier_address) values (?, ?, ?, ?, ?)";
        int status = 0;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            System.out.println(s.getSupplierCode());
            ps.setString(1, s.getSupplierCode());
            ps.setString(2, s.getSupplierName());
            ps.setString(3, s.getCompanyCode());
            ps.setString(4, s.getCompanyName());
            ps.setString(5, s.getAddress());
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
    public Supplier edit(Supplier t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Supplier s) {
        String sql = "delete from supplier where supplier_code = ?";
            int status =0;
            try {
                PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
                ps.setString(1, s.getSupplierCode());
                status = ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }   
            return status;
    }

    @Override
    public Supplier getbyCode(int code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Supplier> getAll() {
        String sql = "select * from supplier";
        List<Supplier> suppliers = new ArrayList<Supplier>(); 
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                Supplier supplier = new Supplier();
                supplier.setSupplierCode(rs.getString("supplier_code"));
                supplier.setSupplierName(rs.getString("supplier_name"));
                supplier.setCompanyCode(rs.getString("company_code"));
                supplier.setCompanyName(rs.getString("company_name"));
                supplier.setAddress(rs.getString("supplier_address"));
                i++;
                suppliers.add(supplier);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return suppliers;
    }

    @Override
    public int update(Supplier t) {
        String sql = "update supplier set supplier_code = ?, supplier_name = ?, company_code =?, company_name = ?, supplier_address = ? where supplier_code = ?";
        int status = 0;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getSupplierCode());
            ps.setString(2, t.getSupplierName());
            ps.setString(3, t.getCompanyCode());
            ps.setString(4, t.getCompanyName());
            ps.setString(5, t.getAddress());
            ps.setString(6, t.getSupplierCode());
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
