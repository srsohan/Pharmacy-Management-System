
package com.pharma.dao;

import com.pharma.common.ICommonInterface;
import com.pharma.model.Category;
import com.pharma.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CategoryDAO implements ICommonInterface<Category>{
    Connection con;
    PreparedStatement ps;

    @Override
    public int save(Category t) {
        String sql = "insert into category (category_code, category_name) values (?,?)";
        int status = 0;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getCategoryCode());
            ps.setString(2, t.getCategoryName());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public Category edit(Category t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Category t) {
        String sql = "delete from category where category_code = ?";
        int status = 0;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getCategoryCode());

            status = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public Category getbyCode(int code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> getAll() {
        String sql = "select * from category";
        List<Category> Categories = new ArrayList<Category>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                Category showCategory = new Category();
                showCategory.setCategoryName(rs.getString("category_name"));
                showCategory.setCategoryCode(rs.getString("category_code"));
                Categories.add(showCategory);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Categories;
    }

    @Override
    public int update(Category t) {
        String sql = "update category set category_name = ?, category_code = ? where category_code = ?";
        int status = 0;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getCategoryCode());
            ps.setString(2, t.getCategoryName());
            ps.setString(3, t.getCategoryCode());
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
