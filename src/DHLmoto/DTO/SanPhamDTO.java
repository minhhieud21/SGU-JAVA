/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.DTO;

/**
 *
 * @author MINH HIEU
 */
public class SanPhamDTO {
    public SanPhamDTO(){}
    public String MaSanPham;
    public String TenSanPham;
    public Long GiaBanRa;
    public int NamRaMat;
    public int TT;

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public Long getGiaBanRa() {
        return GiaBanRa;
    }

    public void setGiaBanRa(Long GiaBanRa) {
        this.GiaBanRa = GiaBanRa;
    }

    public int getNamRaMat() {
        return NamRaMat;
    }

    public void setNamRaMat(int NamRaMat) {
        this.NamRaMat = NamRaMat;
    }

    public int getTT() {
        return TT;
    }

    public void setTT(int TT) {
        this.TT = TT;
    }
    
}
