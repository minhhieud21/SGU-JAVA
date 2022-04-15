/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.DAO;

import DHLmoto.DTO.SanPhamDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MINH HIEU
 */
public class SanPhamDAO {
    private static Connection con;
    
    public SanPhamDAO(){}
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
   public boolean Updatett(String d,int tt){
            if(connect()){
                try{
                    String sql = "UPDATE SanPham SET TT ='"+tt+"' WHERE MaSanPham = '"+d+"'";
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
       
        public ArrayList<SanPhamDTO>showsanpham(){
		ArrayList<SanPhamDTO> ds1 = new ArrayList();
		if(connect()) {
			try {
				String sql = "SELECT * FROM SanPham";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                   if(rs.getString(5).equals("1")){
                                   SanPhamDTO ds = new SanPhamDTO();
                                   ds.setMaSanPham(rs.getString(1));
                                   ds.setTenSanPham(rs.getString(2));
                                   ds.setGiaBanRa(rs.getLong(3));
                                   ds.setNamRaMat(rs.getInt(4));
                                   ds.setTT(rs.getInt(5));
                                   ds1.add(ds);
                                   }
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
                return ds1;
	}
        
        
        
        
        
        
    public long laygia(String ma){
            if(connect()) {
		try {
                    String sql = "SELECT * FROM SanPham WHERE MaSanPham LIKE '%"+ma+"%'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         return rs.getLong(3);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
            return 0;
    }
    public int laynam(String ma){
            if(connect()) {
		try {
                    String sql = "SELECT * FROM SanPham WHERE MaSanPham LIKE '%"+ma+"%'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         return rs.getInt(4);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
            return 0;
    }
        public String layname(String ma){
            if(connect()) {
		try {
                    String sql = "SELECT * FROM SanPham WHERE MaSanPham LIKE '%"+ma+"%'";
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
        public boolean addSP(SanPhamDTO nv) {
        boolean result=false;
        if(connect()){
            try{
                PreparedStatement prst=con.prepareStatement("INSERT INTO SanPham(MaSanPham,TenSanPham,GiaBanRa,NamRaMat,TT) VALUES (?,?,?,?,?)");
                prst.setString(1,nv.getMaSanPham());
                prst.setString(2,nv.getTenSanPham());
                prst.setLong(3,nv.getGiaBanRa());
                prst.setInt(4,nv.getNamRaMat());
                prst.setInt(5,nv.getTT());
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
       public String layMA(String name){
            if(connect()) {
		try {
                    String sql = "SELECT * FROM SanPham WHERE TenSanPham LIKE '%"+name+"%'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         return rs.getString(1);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
            return null;
    } 
        
        public boolean Updated(SanPhamDTO dsnv){
            if(connect()){
                try{
                    String sql = "UPDATE SanPham SET MaSanPham ='"+dsnv.getMaSanPham()+"' , TenSanPham = '"+dsnv.getTenSanPham()+"' , GiaBanRa = '"+dsnv.getGiaBanRa()+"' , NamRaMat = '"+dsnv.getNamRaMat()+"' , TT = '"+dsnv.getTT()+"' WHERE MaSanPham = '"+dsnv.getMaSanPham()+"'";
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
       
       
        
    public java.lang.String taosp(){
        int so ;
        String kt = null;
        if(connect()){
            try{
                int max = 1;
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM SanPham");
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
        
    public boolean Name(String name){
            try{
                if(connect()){
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM SanPham");
                    while(rs.next()){
                        if(rs.getString(2).trim().toLowerCase().startsWith(name.toLowerCase())  && rs.getInt(5) == 1){
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
    public boolean ktName(String name,int nam){
            try{
                if(connect()){
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM SanPham");
                    while(rs.next()){
                        if(rs.getString(2).trim().toLowerCase().startsWith(name.toLowerCase()) && rs.getInt(4) == nam){
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
         public ArrayList<SanPhamDTO>Searchname(String name) {
		ArrayList<SanPhamDTO>  ds = new ArrayList();
		if(connect()) {
			try {
				String sql = "SELECT * FROM SanPham WHERE TenSanPham LIKE '"+name+"%'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    SanPhamDTO tk = new SanPhamDTO();
                                    tk.setMaSanPham(rs.getString(1));
                                    tk.setTenSanPham(rs.getString(2));
                                    tk.setGiaBanRa(rs.getLong(3));
                                    tk.setNamRaMat(rs.getInt(4));
                                    tk.setTT(rs.getInt(5));
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
    public SanPhamDTO lay1(String ma){
            if(connect()) {
		try {
                    String sql = "SELECT * FROM SanPham WHERE MaSanPham LIKE '%"+ma+"%'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         SanPhamDTO dsnv1 = new SanPhamDTO();
                         dsnv1.setMaSanPham(rs.getString(1));
                         dsnv1.setTenSanPham(rs.getString(2));
                         dsnv1.setGiaBanRa(rs.getLong(3));
                         dsnv1.setNamRaMat(rs.getInt(4));
                         dsnv1.setTT(rs.getInt(5));
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
}
