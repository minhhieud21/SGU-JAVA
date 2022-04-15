
package DHLmoto.DAO;


import java.sql.*;
import DHLmoto.DTO.KhoDTO;

import java.util.ArrayList;

/**
 *
 * @author MINH HIEU
 */
public class KhoDAO {
    private static Connection con;
    
    public KhoDAO(){}
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
   
        public ArrayList<KhoDTO>showkho(){
		ArrayList<KhoDTO> dsnv = new ArrayList();
		if(connect()) {
			try {
				String sql = "SELECT * FROM Kho";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                   KhoDTO dsnv1 = new KhoDTO();
                                   dsnv1.setMaSanPham(rs.getString(1));
                                   dsnv1.setSoLuong(rs.getInt(2));
                                   dsnv1.setTt(rs.getInt(3));
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
        
        
      
        public boolean UpdateSL(String d,int Soluong){
            if(connect()){
                try{
                    String sql = "UPDATE Kho SET SoLuong ='"+Soluong+"' WHERE MaSanPham = '"+d+"'";
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
       public boolean Updatett(String d,int tt){
            if(connect()){
                try{
                    String sql = "UPDATE Kho SET Tt ='"+tt+"' WHERE MaSanPham = '"+d+"'";
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
       
       public boolean kttt(String x) {
        if(connect()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM Kho");
                while(rs.next()){
                       if(rs.getString(1).trim().equals(x)){
                           return true;
                       }
                    }
                return false;
            }catch(SQLException ex){
                ex.printStackTrace();
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
                ResultSet rs=stmt.executeQuery("SELECT * FROM Kho");
                while(rs.next()){
                       if(rs.getString(1).trim().equals(x)){
                           return rs.getInt(2);
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
       public int LayTT(String x) {
        if(connect()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM Kho");
                while(rs.next()){
                       if(rs.getString(1).trim().equals(x)){
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
    public boolean CheckMa(String ma){
            try{
                if(connect()){
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM Kho");
                    while(rs.next()){
                        if(rs.getString(1).trim().startsWith(ma) ){
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
         
    public ArrayList<KhoDTO>SearchTK(String ma) {
		ArrayList<KhoDTO>  ds = new ArrayList();
		if(connect()) {
			try {
				String sql = "SELECT * FROM Kho WHERE MaSanPham LIKE '%"+ma+"%'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    KhoDTO dsnv1 = new KhoDTO();
                                        dsnv1.setMaSanPham(rs.getString(1));
                                        dsnv1.setSoLuong(rs.getInt(2));
                                        dsnv1.setTt(rs.getInt(3));
                                        ds.add(dsnv1);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
                return ds;
        }
    public KhoDTO lay1(String ma){
            if(connect()) {
		try {
                    String sql = "SELECT * FROM Kho WHERE MaSanPham = '"+ma+"'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         KhoDTO dsnv1 = new KhoDTO();
                         dsnv1.setMaSanPham(rs.getString(1));
                         dsnv1.setSoLuong(rs.getInt(2));
                         dsnv1.setTt(rs.getInt(3));
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
     public boolean addkho(KhoDTO nv) {
        boolean result=false;
        if(connect()){
            try{
                PreparedStatement prst=con.prepareStatement("INSERT INTO Kho(MaSanPham,SoLuong,Tt) VALUES (?,?,?)");
                prst.setString(1,nv.getMaSanPham());
                prst.setInt(2,nv.getSoLuong());
                prst.setInt(3,nv.getTt());
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
     public boolean CheckMASP(String masp){
            try{
                if(connect()){
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM Kho");
                    while(rs.next()){
                        if(rs.getString(1).trim().startsWith(masp)){
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
         
    public ArrayList<KhoDTO>SearchMA(String ma) {
		ArrayList<KhoDTO>  ds = new ArrayList();
		if(connect()) {
			try {
				String sql = "SELECT * FROM Kho WHERE MaSanPham LIKE '%"+ma+"%'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    KhoDTO dsnv1 = new KhoDTO();
                                        dsnv1.setMaSanPham(rs.getString(1));
                                        dsnv1.setSoLuong(rs.getInt(2));
                                        dsnv1.setTt(rs.getInt(3));
                                        ds.add(dsnv1);
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
