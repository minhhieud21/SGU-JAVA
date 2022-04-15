
package DHLmoto.BUS;

import DHLmoto.DAO.DanhSachTaiKhoanDAO;
import DHLmoto.DTO.DanhSachTaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author MINH HIEU
 */
public class DanhSachTaiKhoanBUS {
    DanhSachTaiKhoanDAO tkDAO=new DanhSachTaiKhoanDAO();
    
    public ArrayList<DanhSachTaiKhoanDTO> TaiKhoan(){
        return tkDAO.TaiKhoan();
    }
    
//    public String getIDcuoi(){
//        return nvDAO.getIDcuoi();
//    }
//    
    public void addTaiKhoan(DanhSachTaiKhoanDTO tk){
        tkDAO.addTaiKhoan(tk);
    }
    public boolean Checktk(String manv){
        return tkDAO.CheckMaNV(manv);
    }
       public int LayTT(String name){
           return tkDAO.LayTT(name);
       }
    public ArrayList<DanhSachTaiKhoanDTO> SearchTK(String manv){
        return tkDAO.SearchTK(manv);
    }
    public boolean Checkname(String name){
        return tkDAO.Name(name);
    }
    
    public ArrayList<DanhSachTaiKhoanDTO> Searchname(String name){
        return tkDAO.Searchname(name);
    }
    public String kt(String mdn,String mk){
        return tkDAO.kt(mdn, mk);
    }
    public void deletetk(String User){
        tkDAO.deleteTaiKhoan(User);
    }
    public void Sua(DanhSachTaiKhoanDTO ds){
        tkDAO.Sua(ds);
    }
    public boolean kttrung(String x){
        return tkDAO.kttrung(x);
    }
    public String LayName(String msnv){
        return  tkDAO.LayName(msnv);
    }
    public String Kttt(String msnv){
        return  tkDAO.Kttt(msnv);
    }
    public DanhSachTaiKhoanDTO Lay1(String manv){
        return tkDAO.lay1(manv);
  }
    public String LayMK(String Manv){
        return tkDAO.LayMK(Manv);
    }
     public String ktcv(String msnv){
        return  tkDAO.ktcv(msnv);
    }
      public String kttontai(String msnv){
        return  tkDAO.kttontai(msnv);
    }
}
