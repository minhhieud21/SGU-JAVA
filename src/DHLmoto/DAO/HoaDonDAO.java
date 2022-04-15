/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.DAO;

import static DHLmoto.DAO.KhoDAO.close;
import DHLmoto.DTO.HoaDonDTO;
import DHLmoto.DTO.KhoDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MINH HIEU
 */
public class HoaDonDAO {
    private static Connection con;
    public static boolean connecthd() {
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
	public ArrayList<HoaDonDTO>showhd(){
		ArrayList<HoaDonDTO> dsnv = new ArrayList();
		if(connecthd()) {
			try {
				String sql = "SELECT * FROM HoaDon";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                   HoaDonDTO dsnv1 = new HoaDonDTO();
                                   dsnv1.setMaHoaDon(   rs.getString(1));
                                   dsnv1.setMaNhanVien(rs.getString(2));
                                   dsnv1.setMaKhachHang(rs.getString(3));
                                   dsnv1.setNgayLap(rs.getString(4));
                                   dsnv1.setTongTien(rs.getLong(5));
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
        
        public boolean adddhd(HoaDonDTO cthd){
            boolean result = false;
            if(connecthd()){
                try{
                    String sql = "INSERT INTO HoaDon VALUES(?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,cthd.getMaHoaDon());
                    ps.setString(2,cthd.getMaNhanVien());
                    ps.setString(3,cthd.getMaKhachHang());
                    ps.setString(4,cthd.getNgayLap());
                    ps.setLong(5,cthd.getTongTien());
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
        public boolean findhd(String MaHoaDon){
            boolean result = false;
            if(connecthd()){
                try{
                    String sql = "SELECT * FROM HoaDon WHERE MaHoaDon ="+MaHoaDon;
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    result = rs.next();
                    
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    close();
                }
            }
            return result;
        }
        
        public static boolean CheckMahd(String mahd){
            try{
                if(connecthd()){
                    String sql = "SELECT * FROM HoaDon";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                        if(mahd.startsWith(rs.getString("MaHoaDon"))){
                            return true;
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                close();
            }
             return false;
        }
        
       public String LayMaKH(String mahd){
        if(connecthd()){
                 try{
                    String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = '"+mahd+"'";
                     Statement s = con.createStatement();
                     ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                        return rs.getString(3);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                     close();
                 }
             }
             return null;
    }
       public String Laydate(String mahd){
        if(connecthd()){
                 try{
                    String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = '"+mahd+"'";
                     Statement s = con.createStatement();
                     ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                        return rs.getString(4);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                     close();
                 }
             }
             return null;
    }
       public String LayMANV(String mahd){
        if(connecthd()){
                 try{
                    String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = '"+mahd+"'";
                     Statement s = con.createStatement();
                     ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                        return rs.getString(2);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                     close();
                 }
             }
             return null;
    }
       
        
         
    
    public String MaSanPhamHoaDon(String mahd){
        String masp = "";
        if(connecthd()){
                 try{
                    String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = '"+mahd+"'";
                     Statement s = con.createStatement();
                     ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                        masp = rs.getString("MaSanPham");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                     close();
                 }
             }
             return masp;
    }
    
     public String SoLuongHoaDon(String mahd){
        String sl = "";
        if(connecthd()){
                 try{
                    String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = '"+mahd+"'";
                     Statement s = con.createStatement();
                     ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                        sl = rs.getString("SoLuong");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                     close();
                 }
             }
             return sl;
    }
     
     public boolean UpdateTT(String mahd,long tt){
         if(connecthd()){
                 try{
                    String sql = "UPDATE HoaDon SET ThanhTien = "+tt+" WHERE MaHoaDon = '"+mahd+"'";
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
     
     public boolean Deletehd1(String mahd){
         if(connecthd()){
                 try{
                    String sql = "DELETE HoaDon WHERE MaHoaDon = '"+mahd+"'";
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
     
     
     
    
    public java.lang.String taohd(){
        int so ;
        String kt = null;
        if(connecthd()){
            try{
                int max = 1;
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM HoaDon");
                while(rs.next()){
                    so = Integer.parseInt(rs.getString(1))+1;
                    if(max < so ){
                        max = so;
                    }
                    
                    }
                if(max < 10){
                    kt = "0000"+max;
                }
                else if(max < 100){
                    kt = "000"+max;
                }
                else if(max < 1000){
                    kt = "00"+max;
                }
                else if(max < 10000){
                    kt = "0" + max;
                }
                else {kt = "" + max;}
                
                }
                catch(Exception e){
                System.out.println(e);
            }finally{
                close();
            }
           
        }
        return kt;
    }
     
    
    public boolean CheckMaNV(String manv){
            try{
                if(connecthd()){
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM HoaDon");
                    while(rs.next()){
                        if(rs.getString(1).trim().startsWith(manv)){
                            return true;
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                close();
            }
             return false;
        }
 public ArrayList<HoaDonDTO>SearchTK(String manv) {
		ArrayList<HoaDonDTO>  ds = new ArrayList();
		if(connecthd()) {
			try {
				String sql = "SELECT * FROM HoaDon WHERE MaHoaDon LIKE '%"+manv+"%'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    HoaDonDTO tk = new HoaDonDTO();
                                    tk.setMaHoaDon(rs.getString(1));
                                    tk.setMaNhanVien(rs.getString(2));
                                    tk.setMaKhachHang(rs.getString(3));
                                    tk.setNgayLap(rs.getString(4));
                                    tk.setTongTien(rs.getLong(5));
                                    ds.add(tk);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
                return ds;
        }
   
    
}
