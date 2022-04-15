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
public class ChiTietHoaDonDTO {
    public String MaHoaDon;
    public String MaSanPham;
    public int SoLuong;
    public long ThanhTien;

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
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

    public long getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(long ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
}
