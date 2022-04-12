/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class Sarkilar {
    private String sarki_adi;
    private String sarki_tur;
    private int sarki_id;
    private String album_adi;
    private String sanatci_adi;
    private int dinlenme_sayisi;

  

    public Sarkilar(String sarki_adi, String sarki_tur, int sarki_id, String album_adi, String sanatci_adi, int dinlenme_sayisi) {
        this.sarki_adi = sarki_adi;
        this.sarki_tur = sarki_tur;
        this.sarki_id = sarki_id;
        this.album_adi = album_adi;
        this.sanatci_adi = sanatci_adi;
        this.dinlenme_sayisi = dinlenme_sayisi;
    }

    
    
    
    
    
     
    
    
    
    
    public int getDinlenme_sayisi() {
        return dinlenme_sayisi;
    }

    public void setDinlenme_sayisi(int dinlenme_sayisi) {
        this.dinlenme_sayisi = dinlenme_sayisi;
    }
    
    
    
    public String getSarki_adi() {
        return sarki_adi;
    }

    public void setSarki_adi(String sarki_adi) {
        this.sarki_adi = sarki_adi;
    }

    public String getSarki_tur() {
        return sarki_tur;
    }

    public void setSarki_tur(String sarki_tur) {
        this.sarki_tur = sarki_tur;
    }

    public int getSarki_id() {
        return sarki_id;
    }

    public void setSarki_id(int sarki_id) {
        this.sarki_id = sarki_id;
    }

    public String getAlbum_adi() {
        return album_adi;
    }

    public void setAlbum_adi(String album_adi) {
        this.album_adi = album_adi;
    }

    public String getSanatci_adi() {
        return sanatci_adi;
    }

    public void setSanatci_adi(String sanatci_adi) {
        this.sanatci_adi = sanatci_adi;
    }
    
    
    
  
}
