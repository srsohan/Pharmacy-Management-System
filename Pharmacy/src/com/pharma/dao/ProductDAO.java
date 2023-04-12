package com.pharma.dao;

import com.pharma.common.ICommonInterface;
import com.pharma.model.Product;
import com.pharma.util.DBConnection;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ProductDAO implements ICommonInterface<Product>{
    Connection con;
    PreparedStatement ps;

    @Override
    public int save(Product t) {
        String sql = "insert into product (product_code, product_name, product_price, category_name, category_code) values (?, ?, ?, ?, ?)";
        int status = 0;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            System.out.println(t.getProductName());
            ps.setInt(1, t.getProductCode());
            ps.setString(2, t.getProductName());
            ps.setDouble(3, t.getPrice());
            
            ps.setString(4, t.getCategoryName());
            ps.setInt(5, t.getCategoryCode());
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
    public Product edit(Product t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Product t) {
            String sql = "delete from product where product_code = ?";
            int status =0;
            try {
                PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
                status = ps.executeUpdate();
                ps.setInt(1, t.getProductCode());
            } catch (SQLException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }   
            return status;
 
    }

    @Override
    public Product getbyCode(int code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAll() {
        String sql = "select * from product";
        List<Product> products = new ArrayList<Product>(); 
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                Product product = new Product();
                product.setProductCode(rs.getInt("product_code"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("product_price"));
                product.setCategoryName(rs.getString("category_name"));
                product.setCategoryCode(rs.getInt("product_code"));
                i++;
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public int update(Product t) {
        String sql = "update product set product_code = ?, product_name = ?, product_price = ?, category_name =?, category_code = ? where product_code = ?";
        int status = 0;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, t.getProductCode());
            ps.setString(2, t.getProductName());
            ps.setDouble(3, t.getPrice());
            ps.setString(4, t.getCategoryName());
            ps.setInt(5, t.getCategoryCode());
            ps.setInt(6, t.getProductCode());
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
