/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.DAO;


import DHLmoto.DTO.PhieuNhapDTO;
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
public class PhieuNhapDAO {
    private static Connection con;
    public PhieuNhapDAO(){
        
    }
    public static boolean connectpn() {
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
        public int LaySL(String x) {
        if(connectpn()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM PhieuNhap");
                while(rs.next()){
                       if(rs.getString(3).trim().equals(x)){
                           return rs.getInt(6);
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
        public int TongSoLuong(){
        int tt = 0;
         if(connectpn()){
            try {
				String sql = "SELECT * FROM PhieuNhap";
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
        public Long TongGiaNhap(){
        long tt = 0;
         if(connectpn()){
            try {
				String sql = "SELECT * FROM PhieuNhap";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    tt = tt + rs.getInt("SoLuong")*rs.getLong("GiaNhap");
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
        }
        return tt;

    }
        public ArrayList<PhieuNhapDTO>showpn(){
		ArrayList<PhieuNhapDTO> dsnv = new ArrayList();
		if(connectpn()) {
			try {
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery("SELECT * FROM PhieuNhap");
                        while(rs.next()){
                                   PhieuNhapDTO dsnv1 = new PhieuNhapDTO();
                                   dsnv1.setMaPhieuNhap(rs.getString(1));
                                   dsnv1.setNgayNhap(rs.getString(2));
                                   dsnv1.setMaSanPham(rs.getString(3));
                                   dsnv1.setTenSanPham(rs.getString(4));
                                   dsnv1.setGiaNhap(rs.getLong(5));
                                   dsnv1.setSoLuong(rs.getInt(6));
                                   dsnv1.setNamRaMat(rs.getInt(7));
                                   dsnv1.setTongTien(rs.getLong(8));
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
        
        public java.lang.String taoPN(){
        int so ;
        String kt = null;
        if(connectpn()){
            try{
                int max = 1;
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM PhieuNhap");
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
        public boolean addPN(PhieuNhapDTO nv) {
        boolean result=false;
        if(connectpn()){
            try{
                PreparedStatement prst=con.prepareStatement("INSERT INTO PhieuNhap(MaPhieuNhap,NgayNhap,MaSanPham,TenSanPham,GiaNhap,SoLuong,NamRaMat,TongGia) VALUES (?,?,?,?,?,?,?,?)");
                prst.setString(1,nv.getMaPhieuNhap());
                prst.setString(2,nv.getNgayNhap());
                prst.setString(3,nv.getMaSanPham());
                prst.setString(4,nv.getTenSanPham());
                prst.setLong(5,nv.getGiaNhap());
                prst.setInt(6,nv.getSoLuong());
                prst.setInt(7,nv.getNamRaMat());
                prst.setLong(8,nv.getTongTien());
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
    
}
