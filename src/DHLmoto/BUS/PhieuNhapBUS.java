/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.BUS;

import DHLmoto.DAO.PhieuNhapDAO;
import DHLmoto.DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author Thang Hung Duc
 */
public class PhieuNhapBUS {
    PhieuNhapDAO pndao = new PhieuNhapDAO();
    public ArrayList<PhieuNhapDTO>showpn(){
        return pndao.showpn();
    }
    public int TongSoLuong(){
        return pndao.TongSoLuong();
    }
           public java.lang.String taoPN(){
               return pndao.taoPN();
           }    
    public boolean addPN(PhieuNhapDTO nv) {
        return pndao.addPN(nv);
    }
    public int LaySL(String x) {
        return pndao.LaySL(x);
    }
    public Long TongGiaNhap(){
        return pndao.TongGiaNhap();
    }
}
