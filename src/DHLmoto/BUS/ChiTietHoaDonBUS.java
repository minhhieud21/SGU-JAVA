/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.BUS;

import DHLmoto.DAO.ChiTietHoaDonDAO;
import DHLmoto.DTO.ChiTietHoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author Thang Hung Duc
 */
public class ChiTietHoaDonBUS {
    ChiTietHoaDonDAO cthddao  = new ChiTietHoaDonDAO();
    public ArrayList<ChiTietHoaDonDTO>showcthd(){
        return cthddao.showcthd();
    }
    public int Tongsoluong(){
        return cthddao.Tongsoluong();
    }
   public boolean adddcthd(ChiTietHoaDonDTO cthd){
        return cthddao.adddcthd(cthd);
        }
    
    public String Update(String mahdString,String maspString,int sl,long tt){
        if(cthddao.Updatecthd(mahdString, maspString, sl, tt)){
            return "Update Thành Công !!!";
        }else{
            return "Update Thất Bại !!!";
        }
    }
    public int LaySL(String x) {
        return cthddao.LaySL(x);
    }
   public long TongBan(){
       return cthddao.TongBan();
   }
    public String Deletecthd(String mahd){
        if(cthddao.Deletecthd(mahd)){
            return "Xóa Thành Công";
        }else{
            return "Xóa Thất Bại";
        }
    }
    
    public int TongSoLuong(String mahd){
        return cthddao.TongSoLuong(mahd);
    }
}
