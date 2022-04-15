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
public class DanhSachTaiKhoanDTO {
    public int TrangThai;
    public String MatKhau;
    public String MaNhanVien;
    public String TenNhanVien;

    public int getTrangThai() {
        return TrangThai;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }
   
}
