/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhT.dao;

import MinhT.dto.UserDTO;
import MinhT.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MinhT
 */
public class UserDAO {
    public UserDTO login(String userID, String password) throws SQLException{
        UserDTO user = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con=DBUtils.getConnection();
            if(con!=null){
                String sql = "SELECT fullName, roleID "
                        + "FROM tblUsers "
                        + "WHERE userID = '" + userID + "' AND password = '" + password + "'";
                stm=con.prepareStatement(sql);
                rs=stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, password, fullName, roleID);
                }
            }
        } catch (Exception e) {
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return user;
    }
     public void insert(String User,String Pass,String Fullname) throws SQLException {
     
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO  tblUsers(userID, fullName, password) "
                        + "VALUES(?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1,User);
                stm.setString(2,Fullname);
                stm.setString(3,Pass);
                stm.executeUpdate();
            
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
     
  
    }
    
    public UserDTO checkDuplicate(String userID) throws SQLException {
      
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT userID "
                        + "FROM tblUsers "
                        + "WHERE userID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();

                while (rs.next()) {
                   return new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
  return null;
    }
}
