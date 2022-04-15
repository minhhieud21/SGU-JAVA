/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.DAO;

import DHLmoto.DTO.GioHangDTO;
import DHLmoto.DTO.KhoDTO;
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
public class GioHangDAO {
     private static Connection con;
    public static boolean connect() {
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
	 public ArrayList<GioHangDTO>showgh(){
		ArrayList<GioHangDTO> dsnv = new ArrayList();
		if(connect()) {
			try {
				String sql = "SELECT * FROM GioHang";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                   GioHangDTO dsnv1 = new GioHangDTO();
                                   dsnv1.setMaKhachHang(rs.getString(1));
                                   dsnv1.setMaSanPham(rs.getString(2));
                                   dsnv1.setSoLuong(rs.getInt(3));
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
        
        
        public boolean addGioHang(GioHangDTO gh){
            if(connect()){
                try{
                    PreparedStatement prst=con.prepareStatement("INSERT INTO GioHang (MaKhachHang,MaSanPham,SoLuong) VALUES (?,?,?)");
                    prst.setString(1,gh.getMaKhachHang());
                    prst.setString(2,gh.getMaSanPham());
                    prst.setInt(3,gh.getSoLuong());
                    if(prst.executeUpdate()>=1)
                        return true;
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    close();
                } 
            }
            return false;
        }
        
        public boolean clearGioHang(){
            if(connect()) {
			try {
				String sql = "DELETE FROM GioHang ";
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
        
        public boolean delete(String masp){
            if(connect()) {
			try {
				String sql = "DELETE FROM GioHang WHERE MaSanPham="+masp;
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
    
         public int LaySL(String x) {
        if(connect()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM GioHang");
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
         public boolean UpdateSL(String d,int Soluong){
            if(connect()){
                try{
                    String sql = "UPDATE GioHang SET SoLuong ='"+Soluong+"' WHERE MaSanPham = '"+d+"'";
                    PreparedStatement ps = con.prepareStatement(sql);
                    if(ps.executeUpdate() >= 1){
                        return true;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    close();
                }
            }
            return false;
        }
}
