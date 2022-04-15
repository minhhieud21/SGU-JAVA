/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.DAO;

import static DHLmoto.DAO.HoaDonDAO.close;
import DHLmoto.DTO.ChiTietHoaDonDTO;
import DHLmoto.DTO.HoaDonDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thang Hung Duc
 */
public class ChiTietHoaDonDAO {
    private static Connection con;
    public static boolean connectcthd() {
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=DoAn";
			String username = "sa";
			String password = "123";
			con = DriverManager.getConnection(URL,username,password);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    public static void close() {
		try {
                    if(con != null) {
                        con.close();
                    }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    public ArrayList<ChiTietHoaDonDTO>showcthd(){
		ArrayList<ChiTietHoaDonDTO> dsnv = new ArrayList();
		if(connectcthd()) {
			try {
				String sql = "SELECT * FROM ChiTietHoaDon ";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                   ChiTietHoaDonDTO dsnv1 = new ChiTietHoaDonDTO();
                                   
                                   dsnv1.setMaHoaDon(rs.getString(1));
                                   dsnv1.setMaSanPham(rs.getString(2));
                                   dsnv1.setSoLuong(rs.getInt(3));
                                   dsnv1.setThanhTien(rs.getLong(4));
                                   dsnv.add(dsnv1);
                                   
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
                return dsnv;
	}
    
    public boolean adddcthd(ChiTietHoaDonDTO cthd){
            boolean result = false;
            if(connectcthd()){
                try{
                    String sql = "INSERT INTO ChiTietHoaDon VALUES(?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,cthd.getMaHoaDon());
                    ps.setString(2,cthd.getMaSanPham());
                    ps.setInt(3,cthd.getSoLuong());
                    ps.setLong(4,cthd.getThanhTien());
                    if(ps.executeUpdate()>=1){
                       result= true;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    close();
                } 
            }
            return result;
        }
    public int LaySL(String x) {
        if(connectcthd()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM ChiTietHoaDon");
                while(rs.next()){
                       if(rs.getString(2).trim().equals(x)){
                           return rs.getInt(3);
                       }
                    }
                return 0;
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                close();
            }
        }
        return 0;
    } 
    public boolean Updatecthd(String mahd,String masp,int sl,long tt){
        if(connectcthd()){
            try {
				String sql = "UPDATE ChiTietHoaDon SET SoLuong = "+sl+" , DonGia = "+tt+" WHERE MaHoaDon = '"+mahd+"' AND MaSanPham = '"+masp+"'";
				PreparedStatement ps = con.prepareStatement(sql);
                                if(ps.executeUpdate() >= 1){
                                    return true;
                                }
                                
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
        }
        return false;
    }
    
   
    public long TongBan(){
        long tt = 0;
         if(connectcthd()){
            try {
				String sql = "SELECT * FROM ChiTietHoaDon ";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    tt = tt + rs.getInt(3)*rs.getLong(4);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
        }
        return tt;
    }
    public int Tongsoluong(){
        int tt = 0;
         if(connectcthd()){
            try {
				String sql = "SELECT * FROM ChiTietHoaDon ";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    tt = tt + rs.getInt("SoLuong");
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
        }
        return tt;
    }
    public boolean Deletecthd(String mahd){
        if(connectcthd()){
            try {
				String sql = "DELETE ChiTietHoaDon  WHERE MaHoaDon = '"+mahd+"'";
				PreparedStatement ps = con.prepareStatement(sql);
                                if(ps.executeUpdate() >= 1){
                                    return true;
                                }
                                
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
        }
        return false;
    }
    
    public int TongSoLuong(String mahd){
        int tt = 0;
         if(connectcthd()){
            try {
				String sql = "SELECT * FROM ChiTietHoaDon WHERE MaHoaDon = '"+mahd+"'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    tt = tt + rs.getInt("SoLuong");
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
        }
        return tt;

    }
    
}
