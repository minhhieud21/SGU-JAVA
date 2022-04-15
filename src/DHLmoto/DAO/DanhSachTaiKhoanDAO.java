
package DHLmoto.DAO;

import DHLmoto.DTO.DanhSachTaiKhoanDTO;
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
public class DanhSachTaiKhoanDAO {
    private Connection con;
    private static String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=DoAn";
    private static String Username="sa";
    private static String Password="123";
    
    public boolean openConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(dbUrl,Username,Password);
            System.out.println("Connect successfully!!!");
            return true;
        }catch(Exception e){
            System.out.println("Can not connect!!!");
            e.printStackTrace();
            return false;
        }
    }
    
    public void closeConnection() {
        try {
            if(con!=null)
            con.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
   public DanhSachTaiKhoanDTO lay1(String manv){
            if(openConnection()) {
		try {
                    String sql = "SELECT * FROM TaiKhoan WHERE MaNhanVien LIKE '%"+manv+"%'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         DanhSachTaiKhoanDTO dsnv1 = new DanhSachTaiKhoanDTO();
                         dsnv1.setMaNhanVien(rs.getString(1));
                         dsnv1.setTenNhanVien(rs.getString(2));
                         dsnv1.setMatKhau(rs.getString(3));
                         dsnv1.setTrangThai(rs.getInt(4));
                         return dsnv1;
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            closeConnection();
                        }
		}
            return null;
    }
   public int LayTT(String name){
            if(openConnection()) {
		try {
                    String sql = "SELECT * FROM TaiKhoan WHERE MaNhanVien LIKE '%"+name+"%'";
                    Statement s = con.createStatement();
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next()){
                         return rs.getInt(4);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            closeConnection();
                        }
		}
            return 0;
    } 
    public String LayMK(String msnv){
        if(openConnection()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM TaiKhoan");
                while(rs.next()){
                       if(rs.getString(1).trim().equals(msnv)){
                           return rs.getString(3);
                       }
                    }
                return "khong co";
                }
                catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return null;
    }
    public ArrayList<DanhSachTaiKhoanDTO> TaiKhoan(){
        ArrayList<DanhSachTaiKhoanDTO> arrnv=new ArrayList<DanhSachTaiKhoanDTO>();
        if(openConnection()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM TaiKhoan");
                while(rs.next()){
                    DanhSachTaiKhoanDTO nv=new DanhSachTaiKhoanDTO();
                    nv.setMaNhanVien(rs.getString(1));
                    nv.setTenNhanVien(rs.getString(2));
                    nv.setMatKhau(rs.getString(3));
                    nv.setTrangThai(rs.getInt(4));
                    arrnv.add(nv);
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return arrnv;
    }
    
    public String getIDcuoi(){
        String madn = null; 
        if(openConnection()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT MaNhanVien FROM TaiKhoan");
                while(rs.next()){
                    madn=rs.getString(1);
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return madn;
    }
    
    public boolean addTaiKhoan(DanhSachTaiKhoanDTO nv) {
        boolean result=false;
        if(openConnection()){
            try{
                PreparedStatement prst=con.prepareStatement("INSERT INTO TaiKhoan(MaNhanVien,TenNhanVien,PassWord,TT) VALUES (?,?,?,?)");
                prst.setString(1,nv.getMaNhanVien());
                prst.setString(2,nv.getTenNhanVien());
                prst.setString(3,nv.getMatKhau());
                prst.setInt(4,nv.getTrangThai());
                if(prst.executeUpdate()>=1)
                    return true;
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public String kt(String User,String Password){
        if(openConnection()){
            
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM TaiKhoan");
                while(rs.next()){
                    if(rs.getString(1).trim().equals(User)){
                       if(rs.getString(3).trim().equals(Password)){
                           return rs.getString(2);}
                       else{
                           return "Sai Mat Khau";
                       }
                    }
                }
                return "Sai Ma Dang Nhap";
                }
                catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return null;
    }
    public String LayName(String msnv){
        if(openConnection()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM NhanVien");
                while(rs.next()){
                       if(rs.getString(1).trim().equals(msnv)){
                           return rs.getString(2);
                       }
                    }
                return "khong co";
                }
                catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return null;
    }
    public String ktcv(String msnv){
        if(openConnection()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM NhanVien");
                while(rs.next()){
                       if(rs.getString(1).trim().equals(msnv)){
                           return rs.getString(7);
                       }
                    }
                return "2";
                }
                catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return null;
    }
    public String kttontai(String msnv){
        if(openConnection()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM NhanVien");
                while(rs.next()){
                       if(rs.getString(1).trim().equals(msnv)){
                           return rs.getString(9);
                       }
                    }
                return "khong co";
                }
                catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return null;
    }
    public String Kttt(String msnv){
        if(openConnection()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM NhanVien");
                while(rs.next()){
                       if(rs.getString(1).trim().equals(msnv)){
                           return "co";
                       }
                    }
                return "khong co";
                }
                catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return null;
    }
    
   
    public void Sua(DanhSachTaiKhoanDTO ds){
        if(openConnection()){
            try{
                    PreparedStatement prst=con.prepareStatement("UPDATE TaiKhoan SET MaNhanVien=?, TenNhanVien=?, PassWord=?, TT=? WHERE MaNhanVien='"+ds.getMaNhanVien()+"'");
                    prst.setString(1,ds.getMaNhanVien());
                    prst.setString(2,ds.getTenNhanVien());
                    prst.setString(3,ds.getMatKhau());
                    prst.setInt(4,ds.getTrangThai());
                    prst.executeUpdate(); 
                }
                catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
    }

 public void deleteTaiKhoan(String User){
        if(openConnection()){
            try{
                PreparedStatement prst=con.prepareStatement("DELETE TaiKhoan WHERE MaDangNhap=?");
                prst.setString(1,User);
                prst.executeUpdate();
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                closeConnection();
            }
        }
 }
  public boolean kttrung(String x) {
        if(openConnection()){
            try{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * FROM TaiKhoan");
                while(rs.next()){
                       if(rs.getString(1).trim().equals(x)){
                           return false;
                       }
                    }
                return true;
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        return true;
    }
  
  
 public boolean Name(String name){
            try{
                if(openConnection()){
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM TaiKhoan");
                    while(rs.next()){
                        if(rs.getString(2).trim().toLowerCase().startsWith(name.toLowerCase()) && rs.getString(2).trim().equals("quanly") == false && rs.getInt(4) != 0){
                            return true;
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
             return false;
        }
    public ArrayList<DanhSachTaiKhoanDTO>Searchname(String name) {
		ArrayList<DanhSachTaiKhoanDTO>  ds = new ArrayList();
		if(openConnection()) {
			try {
				String sql = "SELECT * FROM TaiKhoan WHERE TenNhanVien LIKE '"+name+"%'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    DanhSachTaiKhoanDTO tk = new DanhSachTaiKhoanDTO();
                                    tk.setMaNhanVien(rs.getString(1));
                                    tk.setTenNhanVien(rs.getString(2));
                                    tk.setMatKhau(rs.getString(3));
                                    tk.setTrangThai(rs.getInt(4));
                                    ds.add(tk);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            closeConnection();
                        }
		}
                return ds;
        }
public ArrayList<DanhSachTaiKhoanDTO>SearchTK(String manv) {
		ArrayList<DanhSachTaiKhoanDTO>  ds = new ArrayList();
		if(openConnection()) {
			try {
				String sql = "SELECT * FROM TaiKhoan WHERE MaNhanVien LIKE '%"+manv+"%'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()){
                                    DanhSachTaiKhoanDTO tk = new DanhSachTaiKhoanDTO();
                                    tk.setMaNhanVien(rs.getString(1));
                                    tk.setTenNhanVien(rs.getString(2));
                                    tk.setMatKhau(rs.getString(3));
                                    tk.setTrangThai(rs.getInt(4));
                                    ds.add(tk);
                                }
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
                            closeConnection();
                        }
		}
                return ds;
        }
public boolean CheckMaNV(String manv){
            try{
                if(openConnection()){
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM TaiKhoan");
                    while(rs.next()){
                        if(rs.getString(1).trim().startsWith(manv) && rs.getString(1).trim().equals("quanly") ==false && rs.getInt(4) != 0){
                            return true;
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
             return false;
        }
}

