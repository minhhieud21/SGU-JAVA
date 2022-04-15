/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.BUS;

import DHLmoto.DAO.GioHangDAO;
import DHLmoto.DAO.KhoDAO;
import DHLmoto.DTO.GioHangDTO;
import DHLmoto.DTO.KhoDTO;
import java.util.ArrayList;

/**
 *
 * @author Thang Hung Duc
 */
public class GioHangBUS {
     static GioHangDAO ghdao = new GioHangDAO();
     public ArrayList<GioHangDTO> showgh(){
        return ghdao.showgh();
    }
    
    public String addGioHang(GioHangDTO gh){
        if(ghdao.addGioHang(gh)){
            return "Thêm vào giỏ hàng thành công !!!";
        }else{
            return "Thêm vào giỏ hàng thất bại !!!";
        }
    }
    
    public String clearGioHang(){
        if(ghdao.clearGioHang()){
            return "Đã xóa toàn bộ sản phẩm !!!";
        }else{
            return "Đã xảy ra lỗi trong quá trình xóa !!!";
        }
    }
    
  
    public boolean DeleteGioHang(String masp){
        return ghdao.delete(masp);
    }
    
    public int LaySL(String x) {
        return ghdao.LaySL(x);
    }
    public boolean UpdateSL(String d,int Soluong){
        return  ghdao.UpdateSL(d, Soluong);
    }
}

