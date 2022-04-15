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
public class DanhSachNhanVienDTO {
    public String MaNhanVien;
    public String TenNhanVien;
    public String Mail;
    public String Sdt;
    public String DiaChi;
    public int Gt;
    public int Cv;
    public int tt;

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }

    public int getCv() {
        return Cv;
    }

    public void setCv(int Cv) {
        this.Cv = Cv;
    }

    public int getGt() {
        return Gt;
    }

    public void setGt(int Gt) {
        this.Gt = Gt;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    public String NgaySinh;
    

    

    
    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public String getMail() {
        return Mail;
    }

    public String getSdt() {
        return Sdt;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
}
