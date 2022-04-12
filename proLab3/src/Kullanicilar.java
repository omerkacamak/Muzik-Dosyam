
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class Kullanicilar {
    private String kullaniciAd;
    private String sifre;
    private int kullaniciID;
    private boolean premiumMu;
    private String email;
    public static ArrayList<Kullanicilar> girisYapan = new ArrayList<>();
    public static ArrayList<Kullanicilar> tumKullanicilar = new ArrayList<>();
    public ArrayList<Kullanicilar> takipcileri = new ArrayList<>();
    private int takip_ettigiID;
    

    public Kullanicilar(String kullaniciAd, String sifre, int kullaniciID, boolean premiumMu, String email) {
        this.kullaniciAd = kullaniciAd;
        this.sifre = sifre;
        this.kullaniciID = kullaniciID;
        this.premiumMu = premiumMu;
        this.email = email;
    }

   
    
    
    
    
    
    
    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(int kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public boolean isPremiumMu() {
        return premiumMu;
    }

    public void setPremiumMu(boolean premiumMu) {
        this.premiumMu = premiumMu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

}
