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
public class DanhSachKhachHangDTO {
	public String MaKhachHang;
	public String TenKhachHang;
        public String NgaySinh;
        public int Gt;
	public String DiaChi;
	public String SoDienThoai;
	public String Mail;
	public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGt() {
        return Gt;
    }

    public void setGt(int Gt) {
        this.Gt = Gt;
    }
	public DanhSachKhachHangDTO() {
		
	}

	public String getMaKhachHang() {
		return MaKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		MaKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return TenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}
	
	
}

