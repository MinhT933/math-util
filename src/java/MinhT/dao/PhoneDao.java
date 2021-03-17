/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhT.dao;

import MinhT.controll.AddToCart;
import MinhT.dto.Categories;
import MinhT.dto.Phone;

import MinhT.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import java.util.List;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author MinhT
 */
public class PhoneDao {
    private List<Phone> allProduct;
    
    public List<Phone> getAllPhones() {
        return allProduct;
    }
    private static final Logger logger = Logger.getLogger(PhoneDao.class);
    


    public List<Phone> getAllPhone() {
        List<Phone> ListPhone = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select productID, productName,unit,price,quantity,image from TblProducts";
        try {

            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListPhone.add(new Phone(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6)));
                BasicConfigurator.configure();
                logger.debug("sai rồi");
            }
        } catch (Exception e) {
           Logger.getLogger(PhoneDao.class).error(e.getMessage());
        }
        return ListPhone;
    }

    public static void main(String[] args) {
        String CateID = "I001";
        PhoneDao dao = new PhoneDao();
        List<Phone> list = dao.getPhoneById(CateID);
        
        List<Phone> list1 = dao.getPhoneByCategory(CateID);
        List<Categories> listc = dao.getAllCate();
        

       

    }

    public List<Categories> getAllCate() {
        List<Categories> Listcate = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select categoryID, categoryName,description from TblCategories";
        try {

            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Listcate.add(new Categories(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {

        }
        return Listcate;
    }

    public Phone getLastPhone() {
        String sql = "select top 1 productID, productName,unit,price,quantity,image from TblProducts  order by unit desc";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Phone(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6));

            }
        } catch (Exception e) {
        }

        return null;
    }

    public List<Phone> getPhoneByCategory(String Cateid) {
        List<Phone> ListPhone = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "select productID, productName,unit,price,quantity,image from TblProducts where categoryID=?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setString(1, Cateid);
            rs = ps.executeQuery();

            while (rs.next()) {
                ListPhone.add(new Phone(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            
        }
        return ListPhone;
    }

    public Phone getPhoneByProID(String Proid) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "select productID, productName,unit,price,quantity,image from TblProducts where productID=?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setString(1, Proid);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Phone(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
           
        }
        return null;
    }

    public List<Phone> searchPhoneByName(String txtSearch) {
        List<Phone> ListPhone = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "select productID, productName,unit,price,quantity,image from TblProducts where productName like ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                ListPhone.add(new Phone(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
          
        }
        return ListPhone;
    }

    public List<Phone> getPhoneById(String id) {
        List<Phone> ListPhone = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "select productID, productName,unit,price,quantity,image from TblProducts where productID = ?";
        try {
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                ListPhone.add(new Phone(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            
        }
        return ListPhone;
    }
    
    public static Phone findProduct(String IDproduct, List<Phone> list) {
        for (Phone item : list) {
            if (item.getId().equals(IDproduct)) {
                return item;
            }
//            System.out.println(item+"items");
        }
        return null;
    }
    
  public void deletePhoneByid(String id) {
        String sql = "delete from TblProducts where productID like ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                ps.executeUpdate();
            }
        } catch (Exception e) {
        }
    }

    public void insertProduct(String id, String name, String unit, String img, String Quantity, String CateID, String price) {
        String sql = "insert into [dbo].[TblProducts]( [productID]\n"
                + "      ,[productName]\n"
                + "      ,[unit]\n"
                + "      ,[price]\n"
                + "      ,[quantity]\n"
                + "      ,[categoryID]\n"
                + "      ,[image])\n"
                + "   values (?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, unit);
                ps.setString(4, price);
                ps.setString(5, Quantity);
                ps.setString(6, CateID);
                ps.setString(7, img);

                ps.executeUpdate();
            }
        } catch (Exception e) {
        }

    }

    public void editProduct(String id, String name, String unit, String img, String Quantity, String CateID, String price) {
        String sql = "UPDATE [dbo].[TblProducts] SET\n"
                + "       [productName]= ?\n"
                + "      ,[unit] = ?\n"
                + "      ,[price]  = ?\n"
                + "      ,[quantity]= ?\n"
                + "      ,[categoryID]= ?\n"
                + "      ,[image]= ?\n"
                + "	   where [productID]= ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, unit);
                ps.setString(3, price);
                ps.setString(4, Quantity);
                ps.setString(5, CateID);
                ps.setString(6, img);
                ps.setString(7, id);

                ps.executeUpdate();
            }
        } catch (Exception e) {
        }

    }
}
