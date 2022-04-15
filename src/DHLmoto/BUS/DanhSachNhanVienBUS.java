/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.BUS;

import DHLmoto.DAO.DanhSachKhachHangDAO;
import DHLmoto.DAO.DanhSachNhanVienDAO;
import DHLmoto.DTO.DanhSachNhanVienDTO;
import DHLmoto.DTO.DanhSachTaiKhoanDTO;
import java.util.ArrayList;
/**
 *
 * @author MINH HIEU
 */
public class DanhSachNhanVienBUS {
    
    DanhSachNhanVienDAO dsnvdao = new DanhSachNhanVienDAO();
    
    public ArrayList<DanhSachNhanVienDTO>showqldsnv(){
        return dsnvdao.showqldsnv();
    }
   
   
    
    public String adddsnvql(DanhSachNhanVienDTO dsnv){
        if(dsnvdao.adddsnvql(dsnv)){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }
    public String LayName(String x) {
        return dsnvdao.LayName(x);
    }
    public java.lang.String taonv(){
        return dsnvdao.taonv();
    }
    
    public String Xoadsnv(String manv){
        if(DanhSachNhanVienDAO.Xoanv(manv)){
            return "Xóa thành công !!!";
        }else{
            return "Xóa thất bại !!!";
        }
    }
    
    public String Updatedsnv(DanhSachNhanVienDTO dsnvdto){
        if(dsnvdao.Updatedsnvql(dsnvdto)){
            return "Chỉnh sửa thành công !!!";
        }else{
            return "Chỉnh sửa thất bại !!!";
        }
    }
    
    public ArrayList<DanhSachNhanVienDTO>Searchdsnv(String manv){
        return dsnvdao.Searchdsnv(manv);
    }
    
    public boolean Checkmanv(String manv){
        return dsnvdao.Checkmanv(manv);
    }
  
  public boolean CheckMaNV(String manv){
        return dsnvdao.CheckMaNV(manv);
    }
  public ArrayList<DanhSachNhanVienDTO> SearchTK(String manv){
        return dsnvdao.SearchTK(manv);
    }
  public DanhSachNhanVienDTO Lay1(String manv){
        return dsnvdao.lay1(manv);
  }
}
