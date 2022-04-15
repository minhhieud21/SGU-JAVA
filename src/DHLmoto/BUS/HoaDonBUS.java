/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.BUS;

import DHLmoto.DAO.HoaDonDAO;
import DHLmoto.DTO.HoaDonDTO;

import java.util.ArrayList;

/**
 *
 * @author MINH HIEU
 */
public class HoaDonBUS {
    static HoaDonDAO hoadondao = new HoaDonDAO();
    static HoaDonBUS hdbll = new HoaDonBUS();
    public ArrayList<HoaDonDTO>showhd(){
        return hoadondao.showhd();
    }
    public ArrayList<HoaDonDTO>SearchTK(String manv) {
        return hoadondao.SearchTK(manv);
       }
    public boolean CheckMaNVs(String manv){
        return  hoadondao.CheckMaNV(manv);
    }
    public boolean adddhd(HoaDonDTO cthd){
        return hoadondao.adddhd(cthd);
    }
    
    public boolean CheckMahd(String mahd){
       return HoaDonDAO.CheckMahd(mahd);
    }
    public java.lang.String taohd(){
        return hoadondao.taohd();
    }
    public String Laydate(String mahd){
        return hoadondao.Laydate(mahd);
    }
    
   public String LayMaKH(String mahd){
       return hoadondao.LayMaKH(mahd);
   }
   public String LayMANV(String mahd){
       return hoadondao.LayMANV(mahd);
   }
    
    public String Deletehd(String mahd){
        if(hoadondao.Deletehd1(mahd)){
            return "Xóa Thành Công";
        }else{
            return "Xóa Thất Bại";
        }
    }
    
    public String MaSanPhamHoaDon(String mahd){
        return hoadondao.MaSanPhamHoaDon(mahd);
    }
    
    public String SoLuongHoaDon(String mahd){
        return hoadondao.SoLuongHoaDon(mahd);
    }
    
    public String UpdateTT(String mahdString,long tt){
        if(hoadondao.UpdateTT(mahdString, tt)){
            return "Update Tiền Thành Công";
        }else{
            return "Update Tiền Thất Bại";
        }
    }
    
   
}
