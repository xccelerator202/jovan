package datakaryawan;

public class ModelKaryawan {
    private String nik;  // NIK (Nomor Induk Karyawan)
    private String nama; 
    private int usia;  // Mengganti tinggi menjadi usia
    private String statusKaryawan;  // Mengganti pindahan menjadi status karyawan

    public ModelKaryawan(String nik, String nama, int usia, String statusKaryawan){
        this.nik = nik;
        this.nama = nama;
        this.usia = usia;
        this.statusKaryawan = statusKaryawan;
    }

    public String getNIK() {
        return nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getStatusKaryawan() {
        return statusKaryawan;
    }

    public void setStatusKaryawan(String statusKaryawan) {
        this.statusKaryawan = statusKaryawan;
    }
}