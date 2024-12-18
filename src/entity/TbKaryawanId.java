package entity;
// Generated Nov 19, 2024 5:22:21 PM by Hibernate Tools 3.6.0



/**
 * TbKaryawanId generated by hbm2java
 */
public class TbKaryawanId  implements java.io.Serializable {


     private int idKaryawan;
     private int nikKaryawan;

    public TbKaryawanId() {
    }

    public TbKaryawanId(int idKaryawan, int nikKaryawan) {
       this.idKaryawan = idKaryawan;
       this.nikKaryawan = nikKaryawan;
    }
   
    public int getIdKaryawan() {
        return this.idKaryawan;
    }
    
    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }
    public int getNikKaryawan() {
        return this.nikKaryawan;
    }
    
    public void setNikKaryawan(int nikKaryawan) {
        this.nikKaryawan = nikKaryawan;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TbKaryawanId) ) return false;
		 TbKaryawanId castOther = ( TbKaryawanId ) other; 
         
		 return (this.getIdKaryawan()==castOther.getIdKaryawan())
 && (this.getNikKaryawan()==castOther.getNikKaryawan());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdKaryawan();
         result = 37 * result + this.getNikKaryawan();
         return result;
   }   


}


