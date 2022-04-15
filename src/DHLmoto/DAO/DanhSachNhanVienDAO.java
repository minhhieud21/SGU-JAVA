
package DHLmoto.DAO;


import static DHLmoto.DAO.HoaDonDAO.close;
import static DHLmoto.DAO.HoaDonDAO.connecthd;
import static DHLmoto.DAO.KhoDAO.close;

import java.sql.*;
import DHLmoto.DTO.DanhSachNhanVienDTO;
import DHLmoto.DTO.DanhSachTaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author MINH HIEU
 */
public class DanhSachNhanVienDAO {
    private static Connection con;
    
    public DanhSachNhanVienDAO(){}
    public static boolean connectdsnv() {
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
   
        public ArrayList<DanhSachNhanVienDTO>showqldsnv(){
		ArrayList<DanhSachNhanVienDTO> dsnv = new ArrayList();
		if(connectdsnv()) {
			try {
				String sql = "SELECT * FROM NhanVien";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                   if(rs.getString(9).equals("1")){
                                   DanhSachNhanVienDTO dsnv1 = new DanhSachNhanVienDTO();
                                   dsnv1.setMaNhanVien(rs.getString(1));
                                   dsnv1.setTenNhanVien(rs.getString(2));
                                   dsnv1.setNgaySinh(rs.getString(3));
                                   dsnv1.setGt(rs.getInt(4));
                                   dsnv1.setDiaChi(rs.getString(5));
                                   dsnv1.setSdt(rs.getString(6));
                                   dsnv1.setCv(rs.getInt(7));
                                   dsnv1.setMail(rs.getString(8));
                                   dsnv.add(dsnv1);
                                   }
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            close();
                        }
		}
                return dsnv;
	}
        
        public boolean adddsnv(DanhSachNhanVienDTO dsnv){
            boolean result = false;
            if(connectdsnv()){
                try{
                    String sql = "INSERT INTO DanhSachNhanVien VALUES(?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,dsnv.getMaNhanVien());
                    ps.setString(2,dsnv.getTenNhanVien());
                    ps.setString(3,dsnv.getMail());
                    ps.setString(4,dsnv.getSdt());
                    ps.setString(5,dsnv.getDiaChi());
                  
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
        
         public boolean adddsnvql(DanhSachNhanVienDTO dsnv){
            boolean result = false;
            if(connectdsnv()){
                try{
                    String sql = "INSERT INTO NhanVien VALUES(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,dsnv.getMaNhanVien());
                    ps.setString(2,dsnv.getTenNhanVien());
                    ps.setString(3,dsnv.getNgaySinh());
                    ps.setInt(4,dsnv.getGt());
                    ps.setString(5,dsnv.getDiaChi());
                    ps.setString(6,dsnv.getSdt());
                    ps.setInt(7,dsnv.getCv());
                    ps.setString(8,dsnv.getMail());
                    ps.setString(9,"1");
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
        
        public boolean finddsnv(String MaNhanVien){
            boolean result = false;
            if(connectdsnv()){
                try{
                    String sql = "SELECT * FROM DanhSachNhanVien WHERE MaNhanVien ="+MaNhanVien;
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
        
        public boolean Checkmanv(String manv){
            if(connectdsnv()){
                try{
                    String sql = "SELECT * FROM DanhSachNhanVien ";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                        if(manv.equals(rs.getString("MaNhanVien"))){
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
        
        public boolean Updatedsnvql(DanhSachNhanVienDTO dsnv){
            if(connectdsnv()){
                try{
                    String sql = "UPDATE NhanVien SET MaNhanVien = N'"+dsnv.getMaNhanVien()+"' , TenNhanVien = N'"+dsnv.getTenNhanVien()+"' , NgaySinh = '"+dsnv.getNgaySinh()+"' , GioiTinh = '"+dsnv.getGt()+"' , DiaChi = '"+dsnv.getDiaChi()+"' , SoDienThoai = '"+dsnv.getSdt()+"', ChucVu = '"+dsnv.getCv()+"' , Mail = '"+dsnv.getMail()+"'  , TT = '"+dsnv.getTt()+"' WHERE MaNhanVien = '"+dsnv.getMaNhanVien()+"'";
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
       
        public static boolean Xoanv(String manv){
            if(connectdsnv()) {
                try{
                    String sql = "DELETE FROM DanhSachNhanVien WHERE MaNhanVien = '"+manv+"'"; 
                    PreparedStatement ps = con.prepareStatement(sql);
                    if(ps.executeUpdate() >=1){
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
        
        public static ArrayList<DanhSachNhanVienDTO>Searchdsnv(String manv) {
		ArrayList<DanhSachNhanVienDTO>  dsnv = new ArrayList();
		if(connectdsnv()) {
			try {
				String sql = "SELECT * FROM DanhSachNhanVien WHERE MaNhanVien LIKE '"+manv+"%'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    DanhSachNhanVienDTO dsnv1 = new DanhSachNhanVienDTO();
                                    dsnv1.setMaNhanVien(rs.getString("MaNhanVien"));
                                    dsnv1.setTenNhanVien(rs.getString("TenNhanVien"));
                                    dsnv1.setDiaChi(rs.getString("DiaChi"));
                                    dsnv1.setMail(rs.getString("Mail"));
                                    dsnv1.setSdt(rs.getString("SoDienThoai"));
                             
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
        
        
        
    public java.lang.String taonv(){
        int so ;
        String kt = null;
        if(connectdsnv()){
            try{
                int max = 1;
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM NhanVien");
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
                if(connectdsnv()){
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM NhanVien");
                    while(rs.next()){
                        if(rs.getString(1).trim().startsWith(manv) && rs.getInt(9) != 0){
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
         
    public ArrayList<DanhSachNhanVienDTO>SearchTK(String manv) {
		ArrayList<DanhSachNhanVienDTO>  ds = new ArrayList();
		if(connectdsnv()) {
			try {
				String sql = "SELECT * FROM NhanVien WHERE MaNhanVien LIKE '%"+manv+"%'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    DanhSachNhanVienDTO dsnv1 = new DanhSachNhanVienDTO();
                                        dsnv1.setMaNhanVien(rs.getString(1));
                                        dsnv1.setTenNhanVien(rs.getString(2));
                                        dsnv1.setNgaySinh(rs.getString(3));
                                        dsnv1.setGt(rs.getInt(4));
                                        dsnv1.setDiaChi(rs.getString(5));
                                        dsnv1.setSdt(rs.getString(6));
                                        dsnv1.setCv(rs.getInt(7));
                                        dsnv1.setMail(rs.getString(8));
                                        dsnv1.setTt(rs.getInt(9));
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
    public DanhSachNhanVienDTO lay1(String manv){
            if(connectdsnv()) {
		try {
                    String sql = "SELECT * FROM NhanVien WHERE MaNhanVien LIKE '%"+manv+"%'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         DanhSachNhanVienDTO dsnv1 = new DanhSachNhanVienDTO();
                         dsnv1.setMaNhanVien(rs.getString(1));
                         dsnv1.setTenNhanVien(rs.getString(2));
                         dsnv1.setNgaySinh(rs.getString(3));
                         dsnv1.setGt(rs.getInt(4));
                         dsnv1.setDiaChi(rs.getString(5));
                         dsnv1.setSdt(rs.getString(6));
                         dsnv1.setCv(rs.getInt(7));
                         dsnv1.setMail(rs.getString(8));
                         dsnv1.setTt(rs.getInt(9));
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
   public String LayName(String x) {
        if(connectdsnv()){
            try{
                String sql = "SELECT * FROM NhanVien WHERE MaNhanVien LIKE '%"+x+"%'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         return rs.getString(2);
                                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                close();
            }
        }
        return null;
    } 
}
