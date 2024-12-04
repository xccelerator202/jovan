package datakaryawan;
import entity.TbKaryawan;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class ControllerKaryawan {
    ArrayList<ModelKaryawan> ArrayData;
    DefaultTableModel tabelModel;
    
    public ControllerKaryawan(){
        ArrayData = new ArrayList<ModelKaryawan>();
    }
    
    public void InsertData(String nik, String nama, int usia, String statusKaryawan){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
        try{
            TbKaryawan mnj = new TbKaryawan(nik, nama, usia, statusKaryawan);
            session.save(mnj);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void UpdateData(String nik, String nama, int usia, String statusKaryawan){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try{
            TbKaryawan tbkaryawan = (TbKaryawan) session.get(TbKaryawan.class, nik);
            
            if (tbkaryawan != null) {
                //Update Data Produk
                tbkaryawan.setNama(nama);
                tbkaryawan.setUsia(usia);
                tbkaryawan.setStatusKaryawan(statusKaryawan);
                
                //Simpan Perubahan
                session.update(tbkaryawan);
                tx.commit();
            } else {
                System.out.println("Data dengan nik " + nik + " tidak ditemukan.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public boolean deleteData(String nik) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean isDeleted = false;
        
        try {
            tx = session.beginTransaction();
            
            TbKaryawan tbkaryawan = (TbKaryawan) session.get(TbKaryawan.class, nik);
            
            if (tbkaryawan != null) {
                //Hapus Data
                session.delete(tbkaryawan);
                tx.commit();
                isDeleted = true;
            } else {
                System.out.println("Data dengan nik " + nik + " tidak ditemukan.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return isDeleted;
    }
    
    public DefaultTableModel showData(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<TbKaryawan> krywn = null;
        
        try {
            tx = session.beginTransaction();
            krywn = session.createQuery("FROM TbKaryawan").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        String[] kolom = {"NIK", "Nama", "Usia", "Status Karyawan"};
        Object[][] objData = new Object[ArrayData.size()][4]; 
        int i = 0;

        for(ModelKaryawan k : ArrayData){
            Object[] arrData = {k.getNIK(), k.getNama(), k.getUsia(), k.getStatusKaryawan()};
            objData[i] = arrData;
            i++;
        }

        tabelModel = new DefaultTableModel(objData, kolom) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Cell tidak bisa di-edit
            }
        };
        return tabelModel;
    }
}
