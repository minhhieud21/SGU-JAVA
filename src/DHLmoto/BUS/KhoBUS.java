/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.BUS;

import DHLmoto.DAO.KhoDAO;
import DHLmoto.DTO.KhoDTO;
import java.util.ArrayList;

public class KhoBUS {

    
    KhoDAO khodao = new KhoDAO();
    public int LayTT(String x) {
        return khodao.LayTT(x);
    }
    public KhoDTO Lay1(String ma){
        return khodao.lay1(ma);
    }
    public ArrayList<KhoDTO> ShowKho(){
        return khodao.showkho();
    }
    public boolean UpdateSL(String d,int Soluong){
        return khodao.UpdateSL(d, Soluong);
    }
    public boolean UpdateTT(String d,int tt){
        return khodao.Updatett(d, tt);
    }
    public boolean CheckMa(String ma){
        return  khodao.CheckMa(ma);
    }
    public ArrayList<KhoDTO>SearchTK(String ma) {
        return  khodao.SearchTK(ma);
    }
    public boolean kttt(String x) {
        return khodao.kttt(x);
    }
    public int LaySL(String x) {
        return khodao.LaySL(x);
    }
    public boolean addkho(KhoDTO nv) {
        return khodao.addkho(nv);
    }
    public ArrayList<KhoDTO>Searchname(String ma) {
        return khodao.SearchMA(ma);
    }
    public boolean CheckMASP(String masp){
        return khodao.CheckMASP(masp);
    }
}
