
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class Albumler {
    private int album_id;
    private String album_adi;
    private String sanatci;
    private String tarih;
    private int kategori_id;
    private String kategori_adi;

    public Albumler(int album_id, String album_adi, String sanatci, String tarih, int kategori_id,String kategori_adi) {
        this.album_id = album_id;
        this.album_adi = album_adi;
        this.sanatci = sanatci;
        this.tarih = tarih;
        this.kategori_id = kategori_id;
        this.kategori_adi = kategori_adi;
       
    }
    public Albumler()
    {
        albumListeleri();
    }

   
    
    
    public static ArrayList<Albumler> albumler = new ArrayList<Albumler>();
    
    public void albumListeleri()
    {
        
        albumler.clear();
          Connection connection=null;
        Statement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from albumler,kategoriler where albumler.kategori_id=kategoriler.kategori_id");
            
            while(resultSet.next())
            {
             albumler.add(new Albumler(resultSet.getInt("album_id"), resultSet.getString("album_adi"), resultSet.getString("sanatci"), 
                     resultSet.getString("tarih"), resultSet.getInt("kategori_id"),resultSet.getString("kategori_adi")));
                
            }
            
            System.out.println("Bağlantı oluştu!");
          
            
        }
        
        catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
           
        }
        finally
        {
              try {
                  connection.close();
              } catch (SQLException ex) {
                  Logger.getLogger(Albumler.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
    }

  
    
    
    
    
    
    
    
    
    
    public String getKategori_adi() {
        return kategori_adi;
    }

    public void setKategori_adi(String kategori_adi) {
        this.kategori_adi = kategori_adi;
    }

    
    
    
    
    
    
    
    
    
    
    
 
    
    
    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_adi() {
        return album_adi;
    }

    public void setAlbum_adi(String album_adi) {
        this.album_adi = album_adi;
    }

    public String getSanatci() {
        return sanatci;
    }

    public void setSanatci(String sanatci) {
        this.sanatci = sanatci;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }
    
    
    
            
    
}
