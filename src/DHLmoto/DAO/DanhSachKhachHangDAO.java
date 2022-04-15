/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.DAO;

import static DHLmoto.DAO.DanhSachNhanVienDAO.close;
import static DHLmoto.DAO.DanhSachNhanVienDAO.connectdsnv;
import static DHLmoto.DAO.HoaDonDAO.close;
import static DHLmoto.DAO.HoaDonDAO.connecthd;
import static DHLmoto.DAO.KhoDAO.close;

import DHLmoto.DTO.DanhSachKhachHangDTO;
import DHLmoto.DTO.DanhSachNhanVienDTO;
import DHLmoto.DTO.DanhSachTaiKhoanDTO;
import DHLmoto.DTO.HoaDonDTO;
import DHLmoto.DTO.KhoDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
/**
 *
 * @author Thang Hung Duc
 */
public class DanhSachKhachHangDAO {
    private static Connection con;
    public DanhSachKhachHangDAO(){}
    public static boolean connectdskh() {
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
    public String layname(String ma){
            if(connectdskh()) {
		try {
                    String sql = "SELECT * FROM KhachHang WHERE MaKhachHang LIKE '%"+ma+"%'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         return rs.getString(2);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
            return null;
    }
        public static ArrayList<DanhSachKhachHangDTO>showdskhql(){
		ArrayList<DanhSachKhachHangDTO> dskh = new ArrayList();
		if(connectdskh()) {
			try {
				String sql = "SELECT * FROM KhachHang";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    DanhSachKhachHangDTO dskh1 = new DanhSachKhachHangDTO();
                                    dskh1.setMaKhachHang(rs.getString(1));
                                    dskh1.setTenKhachHang(rs.getString(2));
                                    dskh1.setNgaySinh(rs.getString(3));
                                    dskh1.setGt(rs.getInt(4));
                                    dskh1.setDiaChi(rs.getString(5));
                                    dskh1.setSoDienThoai(rs.getString(6));
                                    dskh1.setMail(rs.getString(7));
                                    dskh.add(dskh1);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
                return dskh;
	}
	
        public boolean add(DanhSachKhachHangDTO dskh){
            boolean result=false;
            if(connectdskh()){
                try{
                    PreparedStatement prst=con.prepareStatement("INSERT INTO KhachHang(MaKhachHang,TenKhachHang,NgaySinh,GioiTinh,DiaChi,SoDienThoai,Mail) VALUES (?,?,?,?,?,?,?)");
                    prst.setString(1,dskh.getMaKhachHang());
                    prst.setString(2,dskh.getTenKhachHang());
                    prst.setString(3,dskh.getNgaySinh());
                    prst.setInt(4,dskh.getGt());
                    prst.setString(5,dskh.getDiaChi());
                    prst.setString(6,dskh.getSoDienThoai());
                    prst.setString(7,dskh.getMail());
                    if(prst.executeUpdate()>=1)
                        return true;
                }catch(SQLException ex){
                    ex.printStackTrace();
                }finally{
                    close();
                }
        }
        return result;
        }
        
        public static ArrayList<DanhSachKhachHangDTO>Searchdskh(String makh) {
		ArrayList<DanhSachKhachHangDTO>  dskh = new ArrayList();
		if(connectdskh()) {
			try {
				String sql = "SELECT * FROM DanhSachKhachHang WHERE MaKhachHang LIKE '%"+makh+"%'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
                                while(rs.next()){
                                DanhSachKhachHangDTO dskh1 = new DanhSachKhachHangDTO();
                                dskh1.setMaKhachHang(rs.getString("MaKhachHang"));
                                dskh1.setTenKhachHang(rs.getString("TenKhachHang"));
                                dskh1.setDiaChi(rs.getString("DiaChi"));
                                dskh1.setSoDienThoai(rs.getString("SoDienThoai"));
                                dskh1.setMail(rs.getString("Mail"));
                                dskh.add(dskh1);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
                return dskh;
        }
        
        public boolean checkdskh(String MaKhachHang){
            if(connectdskh()){
                try{
                    String sql = "SELECT * FROM DanhSachKhachHang";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                        if(rs.getString("MaKhachHang").equals(MaKhachHang)){
                            return true;
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    close();
                }
            }
            return false;
        }
        
        public static String TenKhachHang(String makh) {
                String ten = null;
		if(connectdskh()) {
			try {
				String sql = "SELECT * FROM DanhSachKhachHang WHERE MaKhachHang = '"+makh+"'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    ten = rs.getString("TenKhachHang");
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
                return ten;
        }
        
        public boolean Updatedskh(DanhSachKhachHangDTO dsnv){
            if(connectdskh()){
                try{
                    String sql = "UPDATE KhachHang SET MaKhachHang ='"+dsnv.getMaKhachHang()+"' , TenKhachHang = 'N"+dsnv.getTenKhachHang()+"' , NgaySinh = '"+dsnv.getNgaySinh()+"' , GioiTinh = '"+dsnv.getGt()+"' , DiaChi = '"+dsnv.getDiaChi()+"' , SoDienThoai = '"+dsnv.getSoDienThoai()+"', Mail = '"+dsnv.getMail()+"'   WHERE MaKhachHang = '"+dsnv.getMaKhachHang()+"'";
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
        
        public boolean Deletedskh(String makh){
            if(connectdskh()) {
			try {
				String sql = "DELETE DanhSachKhachHang WHERE MaKhachHang = '"+makh+"'";
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
        
        public java.lang.String taokh(){
        int so ;
        String kt = null;
        if(connectdskh()){
            try{
                int max = 1;
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM KhachHang");
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
         public DanhSachKhachHangDTO lay1(String makh){
            if(connectdskh()) {
		try {
                    String sql = "SELECT * FROM KhachHang WHERE MaKhachHang LIKE '%"+makh+"%'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         DanhSachKhachHangDTO dsnv1 = new DanhSachKhachHangDTO();
                         dsnv1.setMaKhachHang(rs.getString(1));
                         dsnv1.setTenKhachHang(rs.getString(2));
                         dsnv1.setNgaySinh(rs.getString(3));
                         dsnv1.setGt(rs.getInt(4));
                         dsnv1.setDiaChi(rs.getString(5));
                         dsnv1.setSoDienThoai(rs.getString(6));
                         dsnv1.setMail(rs.getString(7));
                         return dsnv1;
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
            return null;
    }
         public boolean Name(String name){
            try{
                if(connectdskh()){
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM KhachHang");
                    while(rs.next()){
                        if(rs.getString(2).trim().toLowerCase().startsWith(name.toLowerCase())){
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
         public ArrayList<DanhSachKhachHangDTO>Searchname(String name) {
		ArrayList<DanhSachKhachHangDTO>  ds = new ArrayList();
		if(connectdskh()) {
			try {
				String sql = "SELECT * FROM KhachHang WHERE TenKhachHang LIKE '"+name+"%'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    DanhSachKhachHangDTO tk = new DanhSachKhachHangDTO();
                                    tk.setMaKhachHang(rs.getString(1));
                                    tk.setTenKhachHang(rs.getString(2));
                                    tk.setNgaySinh(rs.getString(3));
                                    tk.setGt(rs.getInt(4));
                                    tk.setDiaChi(rs.getString(5));
                                    tk.setSoDienThoai(rs.getString(6));
                                    tk.setMail(rs.getString(7));
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
