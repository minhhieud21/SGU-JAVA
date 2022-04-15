/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.BUS;

import DHLmoto.DAO.DanhSachKhachHangDAO;
import DHLmoto.DTO.DanhSachKhachHangDTO;
import DHLmoto.DTO.DanhSachNhanVienDTO;
import DHLmoto.DTO.DanhSachTaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author Thang Hung Duc
 */
public class DanhSachKhachHangBUS {
    static DanhSachKhachHangDAO dskhdao = new DanhSachKhachHangDAO();
    public ArrayList<DanhSachKhachHangDTO> showdskh(){
        return dskhdao.showdskhql();
    }
    public String add(DanhSachKhachHangDTO dskh){
        if(dskhdao.add(dskh)){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
    }
    }
    
    public ArrayList<DanhSachKhachHangDTO> Searchdskh(String makh){
        return dskhdao.Searchdskh(makh);
    }
    
    public boolean CheckMaKhachHang(String makh){
        return dskhdao.checkdskh(makh);
    }
    
    public String TenKhachHang(String makh){
        if(dskhdao.TenKhachHang(makh) != null){
            return dskhdao.TenKhachHang(makh);
        }else{
            return null;
        }
    }
    
   
    
    public String Deletedskh(String makh){
        if(dskhdao.Deletedskh(makh)){
            return "Xóa thành công !!!";
        }else{
            return "Xóa thất bại !!!";
        }
    }
    
    public java.lang.String taokh(){
        return dskhdao.taokh();
    }
    public DanhSachKhachHangDTO Lay1(String makh){
        return dskhdao.lay1(makh);
  }
    public boolean Checkname(String name){
        return dskhdao.Name(name);
    }
    public ArrayList<DanhSachKhachHangDTO> Searchname(String name){
        return dskhdao.Searchname(name);
    }
    public String Updatedskh(DanhSachKhachHangDTO dsnvdto){
        if(dskhdao.Updatedskh(dsnvdto)){
            return "Chỉnh sửa thành công !!!";
        }else{
            return "Chỉnh sửa thất bại !!!";
        }
    }
    public String layname(String ma){
        return dskhdao.layname(ma);
    }
}
