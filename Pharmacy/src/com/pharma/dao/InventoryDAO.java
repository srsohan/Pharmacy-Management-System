
package com.pharma.dao;

import com.pharma.common.ICommonInterface;
import com.pharma.model.Inventory;
import com.pharma.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InventoryDAO implements ICommonInterface<Inventory>{
    Connection con;
    PreparedStatement ps;

    @Override
    public int save(Inventory t) {
        String sql = "insert into inventory (inventory_code, inventory_name, contract_no, email, location) values (?, ?, ?, ?, ?)";
        int status = 0;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getInventoryCode());
            ps.setString(2, t.getInventoryName());
            ps.setString(3, t.getContractNo());
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getLocation());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }

    @Override
    public Inventory edit(Inventory t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Inventory t) {
        String sql = "delete from inventory where inventory_code = ?";
            int status =0;
            try {
                PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
                ps.setString(1, t.getInventoryCode());
                status = ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
            }   
            return status;
    }

    @Override
    public Inventory getbyCode(int code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inventory> getAll() {
        String sql = "select * from inventory";
        List<Inventory> inventorys = new ArrayList<Inventory>(); 
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                Inventory inventory = new Inventory();
                inventory.setInventoryCode(rs.getString("inventory_code"));
                inventory.setInventoryName(rs.getString("inventory_name"));
                inventory.setContractNo(rs.getString("contract_no"));
                inventory.setEmail(rs.getString("email"));
                inventory.setLocation(rs.getString("location"));
                i++;
                inventorys.add(inventory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventorys;
    }

    @Override
    public int update(Inventory t) {
        String sql = "update inventory set inventory_code = ?, inventory_name = ?, contract_no =?, email = ?, location = ? where inventory_code = ?";
        int status = 0;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getInventoryCode());
            ps.setString(2, t.getInventoryName());
            ps.setString(3, t.getContractNo());
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getLocation());
            ps.setString(6, t.getInventoryCode());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }
}
