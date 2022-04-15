/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.DTO;

/**
 *
 * @author Thang Hung Duc
 */
public class KhoDTO {
    public String MaSanPham;
    public KhoDTO(){}
    public int SoLuong;
    public int Tt;

    public int getTt() {
        return Tt;
    }

    public void setTt(int Tt) {
        this.Tt = Tt;
    }
    

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}
