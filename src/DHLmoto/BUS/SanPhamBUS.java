/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DHLmoto.BUS;


import DHLmoto.DAO.SanPhamDAO;
import DHLmoto.DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author MINH HIEU
 */
public class SanPhamBUS {
    SanPhamDAO ds = new SanPhamDAO();
    public SanPhamBUS(){}
    
    public ArrayList<SanPhamDTO>showsanpham(){
        return ds.showsanpham();
    }
   public int laynam(String ma){
       return ds.laynam(ma);
   }
   
    
   
    
    public String Updated(SanPhamDTO dsnvdto){
        if(ds.Updated(dsnvdto)){
            return "Chỉnh sửa thành công !!!";
        }else{
            return "Chỉnh sửa thất bại !!!";
        }
    }
  public boolean Updatett(String d,int tt){
      return ds.Updatett(d, tt);
  }
  public boolean Checkname(String name){
        return ds.Name(name);
    }
    public ArrayList<SanPhamDTO> Searchname(String name){
        return ds.Searchname(name);
    }
  public SanPhamDTO Lay1(String ma){
        return ds.lay1(ma);
  }
  public long laygia(String ma){
        return ds.laygia(ma);
  }
  public String layname(String ma){
      return ds.layname(ma);
  }
  public boolean ktName(String name,int nam){
      return ds.ktName(name,nam);
  }
   public String layMA(String name){
       return ds.layMA(name);
   }
   public boolean addSP(SanPhamDTO nv) {
       return ds.addSP(nv);
       
   }
   public java.lang.String taosp(){
       return ds.taosp();
   }
}
