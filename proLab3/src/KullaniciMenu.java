
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class KullaniciMenu extends javax.swing.JFrame {

    /**
     * Creates new form KullaniciMenu
     */
    ArrayList<Kullanicilar> girenKisi; 
     ArrayList<Kullanicilar> kullanicilar; 
    DefaultTableModel sarkiTablo = new DefaultTableModel();
    DefaultTableModel jazzTablo = new DefaultTableModel();
    DefaultTableModel kulPopTablo = new DefaultTableModel();
    DefaultTableModel kulJazzTablo= new DefaultTableModel();
    DefaultTableModel kulKlasikTablo = new DefaultTableModel();
    DefaultTableModel takipModel = new DefaultTableModel();
    DefaultTableModel genelTop = new DefaultTableModel();
    DefaultTableModel popTopModel = new DefaultTableModel();
    DefaultTableModel jazzTopModel = new DefaultTableModel();
    DefaultTableModel klasikTopModel = new DefaultTableModel();
     ArrayList<JButton> onlarinCalmaButonlari = new ArrayList<>();
        ArrayList<JButton> takipEtButonlari = new ArrayList<>();
    CardLayout cardLayout1;
    int hangisi=-5;
    public KullaniciMenu() {
        initComponents();
        girenKisi= Kullanicilar.girisYapan;
        kullanicilar = Kullanicilar.tumKullanicilar;
//         ImageIcon img = new ImageIcon("src/siyahlan.png");
//         jLabel1.setIcon(img);
cardLayout1= (CardLayout) (cardLayout.getLayout());
hosGeldiniz();
tabloyuGetir();
ArrayListelereAlma();

kul1CalmaBtn.setVisible(false);
    // girenKisi.get(0).takipcileri.add(new Kullanicilar("aa", "bb", 10, true, "  sads"));        
    kullanicininTakipcileri();
 
 System.out.println("Takipçilerinin sayısı : : " + girenKisi.get(0).takipcileri.size()); // giren kişinin takipçileri *****
  

   


    }
    
    
    public void acikKapali()
    {
        for(int i=0; i<kullanicilar.size();i++)
        {
            for(int j=0; j<girenKisi.get(0).takipcileri.size(); j++)
            {
                if(girenKisi.get(0).takipcileri.get(j) == kullanicilar.get(i))
                {
                    onlarinCalmaButonlari.get(i).setVisible(true);
                   
                }
                else
                {
                
                }
            }
        }
    }
    public void genelTop10()
    {
        genelTop = (DefaultTableModel) genelTop10Tablo.getModel();
           genelTop.setRowCount(0);
         Connection connection=null;
        Statement statement = null;
        ResultSet resultSet;
        int sinir=0;
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select sarki_adi,kategori_adi,sarki_id,album_adi,sanatci,dinlenme_sayisi from kategoriler,albumler,\n" +
"sarkilar  where sarkilar.album_id = albumler.album_id and albumler.kategori_id = kategoriler.kategori_id  ORDER BY dinlenme_sayisi DESC");
           
            while(resultSet.next())
            {
            
               Object[]row ={resultSet.getString("sarki_adi"), resultSet.getString("kategori_adi"), /*resultSet.getInt("sarki_id"), */
                  resultSet.getString("album_adi"), resultSet.getString("sanatci"),resultSet.getInt("dinlenme_sayisi")};
               genelTop.addRow(row);
               sinir++;
               
               if(sinir>=10)
               {
                   break;
               }
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
                 Logger.getLogger(KullaniciMenu.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
    public void turTop10(int tur,DefaultTableModel tabloModel, JTable tablo)
    {
         tabloModel = (DefaultTableModel) tablo.getModel();
           tabloModel.setRowCount(0);
         Connection connection=null;
        Statement statement = null;
        ResultSet resultSet;
        int sayac=0;
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select sarki_adi,kategori_adi,sarki_id,album_adi,sanatci,dinlenme_sayisi from kategoriler,albumler,\n" +
"sarkilar  where sarkilar.album_id = albumler.album_id and albumler.kategori_id = kategoriler.kategori_id and  kategoriler.kategori_id='"+tur+"' ORDER BY dinlenme_sayisi DESC");
           
            while(resultSet.next())
            {
            
               Object[]row ={resultSet.getString("sarki_adi"), resultSet.getString("kategori_adi"), /*resultSet.getInt("sarki_id"), */
                  resultSet.getString("album_adi"), resultSet.getString("sanatci"),resultSet.getInt("dinlenme_sayisi")};
               tabloModel.addRow(row);
               sayac++;
               
               if(sayac>=10)
               {
                   break;
               }
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
                 Logger.getLogger(KullaniciMenu.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         
    }
    public void butonlariKapa()
    {
          
 for(int i= 0; i<girenKisi.get(0).takipcileri.size(); i++)
 {
     if(girenKisi.get(0).takipcileri.get(i).isPremiumMu()==true)//
     {
         for(int j=0; j<kullanicilar.size(); j++)
    {
        
        
         if(girenKisi.get(0).takipcileri.get(i) == kullanicilar.get(j))                    // takip ettiklerinde takip et butonu yok!
     {
        takipEtButonlari.get(j).setVisible(false);
     }
//         else
//         {
//              if(kullanicilar.get(j).isPremiumMu()==true)
//              {
//                  takipEtButonlari.get(j).setVisible(true);
//              }
//         }
        
    }
    
     
     
     }//
     
    
 }
    }
    
     public void kullanicininTakipcileri()
     {
     
         
         
         
        Connection connection=null;
        Statement statement = null;
        ResultSet resultSet;
        
      
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select kullanicilar.kullanici_id,takip_ettigi,kullanicilar.kullanici_adi from takip,"
                    + "kullanicilar where takip.kullanici_id=kullanicilar.kullanici_id and kullanicilar.kullanici_adi ='"+girenKisi.get(0).getKullaniciAd()+"'");
            
            girenKisi.get(0).takipcileri.clear();
            while(resultSet.next())
            {
               int sayacim = resultSet.getInt("takip_ettigi");
           
              //  girenKisi.get(0).takipcileri.clear();
               
               for(int i = 0; i<kullanicilar.size(); i++)
               {
                   if(sayacim == kullanicilar.get(i).getKullaniciID())
                   {
                   //    girenKisi.get(0).takipcileri.add(new Kullanicilar("aa", "bb", 10, true, "  sads"));
                       girenKisi.get(0).takipcileri.add(kullanicilar.get(i));
               //        System.out.println("allah llah : " +girenKisi.get(0).takipcileri.get(1).getKullaniciAd());
                    
                     
                   }
               }
               
            }
        
            
            System.out.println("Bağlantı oluştu!");
          
            
          for(int i=0; i<girenKisi.get(0).takipcileri.size(); i++)
{
    System.out.println(" <<<-->>>>> " + girenKisi.get(0).takipcileri.get(i).getKullaniciAd());
}
            
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
                 Logger.getLogger(KullaniciMenu.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         
         
     }
    
    public void takipEdilenCalmaListeleri(DefaultTableModel hangiTabloModel, JTable tablo, int kimTakipseOnunIndex, int kategoriID)
    {
         hangiTabloModel = (DefaultTableModel) tablo.getModel();
        
        hangiTabloModel.setRowCount(0);
         Connection connection=null;
        Statement statement = null;
        ResultSet resultSet;
        try{
             DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            statement = connection.createStatement();
             resultSet = statement.executeQuery("select  sarkilar.sarki_id, sarki_adi,album_adi,sanatci,kategori_adi,dinlenme_sayisi from albumler,calmalisteleri,kategoriler,kullanicilar,sarkilar where albumler.kategori_id=kategoriler.kategori_id and \n" +
"calmalisteleri.kullanici_id =kullanicilar.kullanici_id and calmalisteleri.sarki_id=sarkilar.sarki_id and\n" +
"sarkilar.album_id= albumler.album_id and kullanici_adi =  '"+kullanicilar.get(kimTakipseOnunIndex).getKullaniciAd()+"' and kategoriler.kategori_id = '"+kategoriID+"'");
             int i=0;
             while(resultSet.next())
             {
            Object[]row={resultSet.getInt("sarki_id"),resultSet.getString("sarki_adi"),resultSet.getString("album_adi"),resultSet.getString("sanatci"),
            resultSet.getString("kategori_adi"),resultSet.getInt("dinlenme_sayisi")};
                hangiTabloModel.addRow(row);
                i++;
                
             }
            
        }
        catch(SQLException exception){
                 System.out.println(exception.getMessage());
        }
        finally{
            try {
                connection.close();
            } catch (SQLException ex) {
               // Logger.getLogger(giris.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void jazzTabloGetir(int kategoriID)
    {
         jazzTablo = (DefaultTableModel) jazzListesiTablo.getModel();
        
        jazzTablo.setRowCount(0);
         Connection connection=null;
        Statement statement = null;
        ResultSet resultSet;
        try{
             DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            statement = connection.createStatement();
             resultSet = statement.executeQuery("select  sarkilar.sarki_id, sarki_adi,album_adi,sanatci,kategori_adi,dinlenme_sayisi from albumler,calmalisteleri,kategoriler,kullanicilar,sarkilar where albumler.kategori_id=kategoriler.kategori_id and \n" +
"calmalisteleri.kullanici_id =kullanicilar.kullanici_id and calmalisteleri.sarki_id=sarkilar.sarki_id and\n" +
"sarkilar.album_id= albumler.album_id and kullanici_adi =  '"+girenKisi.get(0).getKullaniciAd()+"' and kategoriler.kategori_id = '"+kategoriID+"'");
             int i=0;
             while(resultSet.next())
             {
            Object[]row={resultSet.getInt("sarki_id"),resultSet.getString("sarki_adi"),resultSet.getString("album_adi"),resultSet.getString("sanatci"),
            resultSet.getString("kategori_adi"),resultSet.getInt("dinlenme_sayisi")};
                jazzTablo.addRow(row);
                i++;
                
             }
            
        }
        catch(SQLException exception){
                 System.out.println(exception.getMessage());
        }
        finally{
            try {
                connection.close();
            } catch (SQLException ex) {
               // Logger.getLogger(giris.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    public void tabloyuGetir()
    {
        sarkiTablo = (DefaultTableModel)sarkiListesi.getModel();
        sarkiTablo.setRowCount(0);
        try {
            ArrayList<Sarkilar> sarkim = sarkilariAl();
            for(Sarkilar sarki1: sarkim)
            {
                Object[]row={sarki1.getSarki_id(),sarki1.getSarki_adi(),sarki1.getAlbum_adi(),sarki1.getSanatci_adi(),
                sarki1.getSarki_tur(),sarki1.getDinlenme_sayisi()};
                sarkiTablo.addRow(row);
            }
        } catch (SQLException ex) {
          //  Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    public ArrayList<Sarkilar> sarkilariAl() throws SQLException
{
   Connection connection =null;
   DbHelper dbHelper = new DbHelper();
   Statement statement=null;
   ResultSet resultSet;
   ArrayList<Sarkilar> sarkiListem =null;
   
   try{
       connection = dbHelper.getConnection();
       statement = connection.createStatement();
       resultSet = statement.executeQuery("select sarki_adi,kategori_adi,sarki_id,album_adi,sanatci,dinlenme_sayisi from kategoriler,albumler,\n" +
"sarkilar  where sarkilar.album_id = albumler.album_id and albumler.kategori_id = kategoriler.kategori_id ");
       sarkiListem =new ArrayList<>();
       
       while(resultSet.next())
       {
          sarkiListem.add(new Sarkilar(resultSet.getString("sarki_adi"), resultSet.getString("kategori_adi"), resultSet.getInt("sarki_id"), 
                  resultSet.getString("album_adi"), resultSet.getString("sanatci"),resultSet.getInt("dinlenme_sayisi")));
       }
       
   }
   catch(SQLException exception){
       dbHelper.showErrorMessage(exception);
   }
   finally{
       statement.close();
       connection.close();
       
       
   }
   
   return sarkiListem;
}
    
    
    
    public void hosGeldiniz()
    {
        if(girenKisi.get(0).isPremiumMu()== true)
        {
            premiumLabel.setText("Premium Kullanıcı");
        }
        else
        {
            premiumLabel.setText("Normal Kullanıcı"); 
        }
        
        kullaniciAdiLabel.setText(girenKisi.get(0).getKullaniciAd());
    }
    
    public void OnlarinCalmaListesindenEkle(JTable hangiTablo)
    {
        int sayac = hangiTablo.getSelectedRow();
         int eklenilecekSarki =Integer.valueOf(hangiTablo.getValueAt(sayac, 0).toString());
               Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="insert into calmalisteleri (kullanici_id,sarki_id) values (?,?)";
            statement = connection.prepareStatement(sql);
          statement.setInt(1,girenKisi.get(0).getKullaniciID());
          statement.setInt(2,eklenilecekSarki );
//          statement.setInt(3, albumTur);
          
          
          statement.executeUpdate();
           
            
            System.out.println("Kayıt eklendi");
            
        }
        
        catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
           
        }
        finally
        {       try {
            statement.close();
            connection.close();
            } catch (SQLException ex) {
              
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        anaPanel = new javax.swing.JPanel();
        solPanel = new javax.swing.JPanel();
        anaSayfaBtn = new javax.swing.JButton();
        kesfetBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        benJazzBtn = new javax.swing.JButton();
        benPopBtn = new javax.swing.JButton();
        benKlasBtn = new javax.swing.JButton();
        takipEttiklerinBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        kullaniciAdiLabel = new javax.swing.JLabel();
        premiumLabel = new javax.swing.JLabel();
        playPanel = new javax.swing.JPanel();
        labelim = new javax.swing.JLabel();
        cardLayout = new javax.swing.JPanel();
        anaSayfaPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sarkiListesi = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        calmaListeneEkle = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jazzListesi = new javax.swing.JPanel();
        kiminCalmaListesiLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jazzListesiTablo = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        kullanicilarPanel = new javax.swing.JPanel();
        kullanici1Label = new javax.swing.JLabel();
        takip1 = new javax.swing.JButton();
        kullanici2Label = new javax.swing.JLabel();
        takip2 = new javax.swing.JButton();
        kullanici3Label = new javax.swing.JLabel();
        takip3 = new javax.swing.JButton();
        kullanici5Label = new javax.swing.JLabel();
        kullanici4Label = new javax.swing.JLabel();
        kullanici6Label = new javax.swing.JLabel();
        takip5 = new javax.swing.JButton();
        takip4 = new javax.swing.JButton();
        takip6 = new javax.swing.JButton();
        kul1CalmaBtn = new javax.swing.JButton();
        kullanici7Label = new javax.swing.JLabel();
        takip7 = new javax.swing.JButton();
        kul1CalmaBtn1 = new javax.swing.JButton();
        kul1CalmaBtn2 = new javax.swing.JButton();
        kul1CalmaBtn3 = new javax.swing.JButton();
        kul1CalmaBtn4 = new javax.swing.JButton();
        kul1CalmaBtn5 = new javax.swing.JButton();
        kul1CalmaBtn6 = new javax.swing.JButton();
        kullanici8Label = new javax.swing.JLabel();
        kullanici9Label = new javax.swing.JLabel();
        kullanici10Label = new javax.swing.JLabel();
        takip8 = new javax.swing.JButton();
        takip9 = new javax.swing.JButton();
        takip10 = new javax.swing.JButton();
        kul1CalmaBtn7 = new javax.swing.JButton();
        kul1CalmaBtn8 = new javax.swing.JButton();
        kul1CalmaBtn9 = new javax.swing.JButton();
        top10Btn = new javax.swing.JButton();
        turTop10Btn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        kullanici11Label = new javax.swing.JLabel();
        takip11 = new javax.swing.JButton();
        kul1CalmaBtn10 = new javax.swing.JButton();
        kullanicilarCalmaListeleriPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        kullanicilarPopTablo = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        kullanicilarJazzTablo = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        kullanicilarKlasikTablo = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kulCalmaListLabel = new javax.swing.JLabel();
        butonKulCalEkle = new javax.swing.JButton();
        butonKulCalEkle1 = new javax.swing.JButton();
        butonKulCalEkle2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        takipEttiklerinPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        takipEdilenTablo = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        takiptenCikBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        turTop10Panel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        bir = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        iki = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        uc = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        top10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        genelTop10Tablo = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 900));
        setMinimumSize(new java.awt.Dimension(1400, 1000));
        setPreferredSize(new java.awt.Dimension(1000, 900));

        solPanel.setBackground(new java.awt.Color(87, 75, 75));

        anaSayfaBtn.setText("ANA SAYFA");
        anaSayfaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anaSayfaBtnActionPerformed(evt);
            }
        });

        kesfetBtn.setText("Keşfet");
        kesfetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kesfetBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("Çalma Listelerin");

        benJazzBtn.setText("Jazz");
        benJazzBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benJazzBtnActionPerformed(evt);
            }
        });

        benPopBtn.setText("Pop");
        benPopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benPopBtnActionPerformed(evt);
            }
        });

        benKlasBtn.setText("Klasik");
        benKlasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benKlasBtnActionPerformed(evt);
            }
        });

        takipEttiklerinBtn.setText("Takip Ettiklerin");
        takipEttiklerinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takipEttiklerinBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("HOŞ GELDİNİZ");

        kullaniciAdiLabel.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        kullaniciAdiLabel.setText("jLabel3");

        premiumLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        premiumLabel.setText("jLabel3");

        javax.swing.GroupLayout solPanelLayout = new javax.swing.GroupLayout(solPanel);
        solPanel.setLayout(solPanelLayout);
        solPanelLayout.setHorizontalGroup(
            solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(anaSayfaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kesfetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(benJazzBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(benPopBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(benKlasBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(takipEttiklerinBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(solPanelLayout.createSequentialGroup()
                        .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kullaniciAdiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(premiumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        solPanelLayout.setVerticalGroup(
            solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(anaSayfaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(kesfetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(benJazzBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(benPopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(benKlasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(takipEttiklerinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kullaniciAdiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(premiumLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        playPanel.setBackground(new java.awt.Color(255, 102, 102));

        labelim.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelim.setText("jLabel15");

        javax.swing.GroupLayout playPanelLayout = new javax.swing.GroupLayout(playPanel);
        playPanel.setLayout(playPanelLayout);
        playPanelLayout.setHorizontalGroup(
            playPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playPanelLayout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(labelim, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        playPanelLayout.setVerticalGroup(
            playPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelim, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        cardLayout.setLayout(new java.awt.CardLayout());

        anaSayfaPanel.setBackground(new java.awt.Color(0, 225, 195));

        sarkiListesi.setBackground(new java.awt.Color(240, 240, 240));
        sarkiListesi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sarkiListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Adı", "Albüm Adı", "Sanatçı", "Tür", "Dinlenme"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sarkiListesi.setGridColor(new java.awt.Color(204, 0, 102));
        jScrollPane1.setViewportView(sarkiListesi);
        if (sarkiListesi.getColumnModel().getColumnCount() > 0) {
            sarkiListesi.getColumnModel().getColumn(0).setMinWidth(25);
            sarkiListesi.getColumnModel().getColumn(0).setPreferredWidth(25);
            sarkiListesi.getColumnModel().getColumn(0).setMaxWidth(25);
            sarkiListesi.getColumnModel().getColumn(4).setPreferredWidth(30);
            sarkiListesi.getColumnModel().getColumn(5).setPreferredWidth(50);
            sarkiListesi.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jLabel3.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel3.setText("ANA SAYFA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setText("ŞARKI LİSTESİ");

        calmaListeneEkle.setText("Çalma Listene Ekle");
        calmaListeneEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calmaListeneEkleActionPerformed(evt);
            }
        });

        jButton1.setText("ÇAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout anaSayfaPanelLayout = new javax.swing.GroupLayout(anaSayfaPanel);
        anaSayfaPanel.setLayout(anaSayfaPanelLayout);
        anaSayfaPanelLayout.setHorizontalGroup(
            anaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anaSayfaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(anaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(anaSayfaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(anaSayfaPanelLayout.createSequentialGroup()
                        .addGap(0, 150, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(anaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(calmaListeneEkle, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(85, 85, 85))))
        );
        anaSayfaPanelLayout.setVerticalGroup(
            anaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, anaSayfaPanelLayout.createSequentialGroup()
                .addGroup(anaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(anaSayfaPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)))
                .addGroup(anaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(anaSayfaPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(calmaListeneEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(anaSayfaPanelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        cardLayout.add(anaSayfaPanel, "card2");

        jazzListesi.setBackground(new java.awt.Color(0, 225, 195));

        kiminCalmaListesiLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kiminCalmaListesiLabel.setText("JAZZ ÇALMA LİSTESİ");

        jazzListesiTablo.setBackground(new java.awt.Color(240, 240, 240));
        jazzListesiTablo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jazzListesiTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Adı", "Albüm Adı", "Sanatçı", "Tür", "Dinlenme"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jazzListesiTablo.setGridColor(new java.awt.Color(204, 0, 102));
        jScrollPane2.setViewportView(jazzListesiTablo);
        if (jazzListesiTablo.getColumnModel().getColumnCount() > 0) {
            jazzListesiTablo.getColumnModel().getColumn(0).setMinWidth(25);
            jazzListesiTablo.getColumnModel().getColumn(0).setPreferredWidth(25);
            jazzListesiTablo.getColumnModel().getColumn(0).setMaxWidth(25);
            jazzListesiTablo.getColumnModel().getColumn(4).setPreferredWidth(30);
            jazzListesiTablo.getColumnModel().getColumn(5).setPreferredWidth(50);
            jazzListesiTablo.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jButton3.setText("LİSTEDEN ÇIKAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("ÇAL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jazzListesiLayout = new javax.swing.GroupLayout(jazzListesi);
        jazzListesi.setLayout(jazzListesiLayout);
        jazzListesiLayout.setHorizontalGroup(
            jazzListesiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jazzListesiLayout.createSequentialGroup()
                .addGroup(jazzListesiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jazzListesiLayout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addComponent(kiminCalmaListesiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jazzListesiLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addGroup(jazzListesiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jazzListesiLayout.setVerticalGroup(
            jazzListesiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jazzListesiLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(kiminCalmaListesiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jazzListesiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jazzListesiLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jazzListesiLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton3)
                        .addGap(33, 33, 33)
                        .addComponent(jButton5)))
                .addContainerGap(249, Short.MAX_VALUE))
        );

        cardLayout.add(jazzListesi, "card3");

        kullanicilarPanel.setBackground(new java.awt.Color(0, 225, 195));

        kullanici1Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici1Label.setText("Kullanıcı 1");

        takip1.setLabel("Takip Et");
        takip1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip1ActionPerformed(evt);
            }
        });

        kullanici2Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici2Label.setText("Kullanıcı 2");

        takip2.setLabel("Takip Et");
        takip2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip2ActionPerformed(evt);
            }
        });

        kullanici3Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici3Label.setText("Kullanıcı 3");

        takip3.setLabel("Takip Et");
        takip3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip3ActionPerformed(evt);
            }
        });

        kullanici5Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici5Label.setText("Kullanıcı 5");

        kullanici4Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici4Label.setText("Kullanıcı 4");

        kullanici6Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici6Label.setText("Kullanıcı 6");

        takip5.setLabel("Takip Et");
        takip5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip5ActionPerformed(evt);
            }
        });

        takip4.setLabel("Takip Et");
        takip4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip4ActionPerformed(evt);
            }
        });

        takip6.setLabel("Takip Et");
        takip6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip6ActionPerformed(evt);
            }
        });

        kul1CalmaBtn.setText("Çalma Listelerine Git");
        kul1CalmaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtnActionPerformed(evt);
            }
        });

        kullanici7Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici7Label.setText("Kullanıcı 7");

        takip7.setLabel("Takip Et");
        takip7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip7ActionPerformed(evt);
            }
        });

        kul1CalmaBtn1.setText("Çalma Listelerine Git");
        kul1CalmaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtn1ActionPerformed(evt);
            }
        });

        kul1CalmaBtn2.setText("Çalma Listelerine Git");
        kul1CalmaBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtn2ActionPerformed(evt);
            }
        });

        kul1CalmaBtn3.setText("Çalma Listelerine Git");
        kul1CalmaBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtn3ActionPerformed(evt);
            }
        });

        kul1CalmaBtn4.setText("Çalma Listelerine Git");
        kul1CalmaBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtn4ActionPerformed(evt);
            }
        });

        kul1CalmaBtn5.setText("Çalma Listelerine Git");
        kul1CalmaBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtn5ActionPerformed(evt);
            }
        });

        kul1CalmaBtn6.setText("Çalma Listelerine Git");
        kul1CalmaBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtn6ActionPerformed(evt);
            }
        });

        kullanici8Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici8Label.setText("Kullanıcı 8");

        kullanici9Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici9Label.setText("Kullanıcı 9");

        kullanici10Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici10Label.setText("Kullanıcı 10");

        takip8.setLabel("Takip Et");
        takip8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip8ActionPerformed(evt);
            }
        });

        takip9.setLabel("Takip Et");
        takip9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip9ActionPerformed(evt);
            }
        });

        takip10.setLabel("Takip Et");
        takip10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip10ActionPerformed(evt);
            }
        });

        kul1CalmaBtn7.setText("Çalma Listelerine Git");
        kul1CalmaBtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtn7ActionPerformed(evt);
            }
        });

        kul1CalmaBtn8.setText("Çalma Listelerine Git");
        kul1CalmaBtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtn8ActionPerformed(evt);
            }
        });

        kul1CalmaBtn9.setText("Çalma Listelerine Git");
        kul1CalmaBtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtn9ActionPerformed(evt);
            }
        });

        top10Btn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        top10Btn.setText("TOP10");
        top10Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                top10BtnActionPerformed(evt);
            }
        });

        turTop10Btn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        turTop10Btn.setText("TÜRLERE GÖRE TOP 10 LİSTELERİ");
        turTop10Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turTop10BtnActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("NOT: KIRMIZI İLE GÖSTERİLENLER PREMİUM ÜYEDİR");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("TAKİP ET");

        kullanici11Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kullanici11Label.setText("Kullanıcı 10");

        takip11.setLabel("Takip Et");
        takip11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takip11ActionPerformed(evt);
            }
        });

        kul1CalmaBtn10.setText("Çalma Listelerine Git");
        kul1CalmaBtn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kul1CalmaBtn10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kullanicilarPanelLayout = new javax.swing.GroupLayout(kullanicilarPanel);
        kullanicilarPanel.setLayout(kullanicilarPanelLayout);
        kullanicilarPanelLayout.setHorizontalGroup(
            kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                .addComponent(kullanici1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(takip1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                .addComponent(kullanici2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(takip2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                .addComponent(kullanici3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(takip3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kullanici4Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(kullanici5Label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kullanici6Label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kullanici7Label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kullanici8Label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kullanici9Label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kullanici10Label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kullanici11Label, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(takip5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takip4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takip6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takip7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takip8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takip9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takip10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takip11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kul1CalmaBtn3)
                            .addComponent(kul1CalmaBtn2)
                            .addComponent(kul1CalmaBtn1)
                            .addComponent(kul1CalmaBtn)
                            .addComponent(kul1CalmaBtn4)
                            .addComponent(kul1CalmaBtn9)
                            .addComponent(kul1CalmaBtn8)
                            .addComponent(kul1CalmaBtn5)
                            .addComponent(kul1CalmaBtn7)
                            .addComponent(kul1CalmaBtn6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(top10Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(turTop10Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(109, 109, 109))
                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                        .addComponent(kul1CalmaBtn10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        kullanicilarPanelLayout.setVerticalGroup(
            kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kullanicilarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(takip8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kul1CalmaBtn7))
                        .addGap(41, 41, 41)
                        .addComponent(kullanici9Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(takip9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kul1CalmaBtn8))
                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kullanici1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takip1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kul1CalmaBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kullanici2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(takip2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kul1CalmaBtn1))
                                .addGap(18, 18, 18)
                                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kullanici3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(takip3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kul1CalmaBtn2))
                                .addGap(27, 27, 27)
                                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(takip4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kullanici4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kul1CalmaBtn3))
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kullanicilarPanelLayout.createSequentialGroup()
                                .addComponent(top10Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(takip5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kullanici5Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kul1CalmaBtn4))
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(takip6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(kul1CalmaBtn5))
                                    .addComponent(kullanici6Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(kullanici7Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(takip7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kul1CalmaBtn6))))
                                .addGap(32, 32, 32)
                                .addComponent(kullanici8Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(turTop10Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)))
                .addGap(38, 38, 38)
                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kullanici10Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(takip10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kul1CalmaBtn9)))
                .addGap(42, 42, 42)
                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kullanici11Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(takip11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kul1CalmaBtn10)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        cardLayout.add(kullanicilarPanel, "card4");

        kullanicilarCalmaListeleriPanel.setBackground(new java.awt.Color(0, 225, 195));

        kullanicilarPopTablo.setBackground(new java.awt.Color(240, 240, 240));
        kullanicilarPopTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Adı", "Tür", "Albüm", "Sanatçı", "Dinlenme"
            }
        ));
        kullanicilarPopTablo.setMinimumSize(new java.awt.Dimension(80, 64));
        kullanicilarPopTablo.setRowHeight(15);
        jScrollPane3.setViewportView(kullanicilarPopTablo);

        kullanicilarJazzTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Adı", "Tür", "Albüm", "Sanatçı", "Dinlenme"
            }
        ));
        jScrollPane4.setViewportView(kullanicilarJazzTablo);

        kullanicilarKlasikTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Adı", "Tür", "Albüm", "Sanatçı", "Dinlenme"
            }
        ));
        jScrollPane5.setViewportView(kullanicilarKlasikTablo);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("POP");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("JAZZ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("KLASİK");

        kulCalmaListLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kulCalmaListLabel.setText("KULLANICININ ÇALMA LİSTELERİ");

        butonKulCalEkle.setText("ÇALMA LİSTENE EKLE");
        butonKulCalEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonKulCalEkleActionPerformed(evt);
            }
        });

        butonKulCalEkle1.setText("ÇALMA LİSTENE EKLE");
        butonKulCalEkle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonKulCalEkle1ActionPerformed(evt);
            }
        });

        butonKulCalEkle2.setText("ÇALMA LİSTENE EKLE");
        butonKulCalEkle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonKulCalEkle2ActionPerformed(evt);
            }
        });

        jButton4.setText("ÇAL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kullanicilarCalmaListeleriPanelLayout = new javax.swing.GroupLayout(kullanicilarCalmaListeleriPanel);
        kullanicilarCalmaListeleriPanel.setLayout(kullanicilarCalmaListeleriPanelLayout);
        kullanicilarCalmaListeleriPanelLayout.setHorizontalGroup(
            kullanicilarCalmaListeleriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullanicilarCalmaListeleriPanelLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(185, 185, 185))
            .addGroup(kullanicilarCalmaListeleriPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(kullanicilarCalmaListeleriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonKulCalEkle))
                .addGap(139, 139, 139)
                .addGroup(kullanicilarCalmaListeleriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonKulCalEkle1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(kullanicilarCalmaListeleriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonKulCalEkle2))
                .addGap(70, 70, 70))
            .addGroup(kullanicilarCalmaListeleriPanelLayout.createSequentialGroup()
                .addGroup(kullanicilarCalmaListeleriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kullanicilarCalmaListeleriPanelLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(kulCalmaListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kullanicilarCalmaListeleriPanelLayout.createSequentialGroup()
                        .addGap(501, 501, 501)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kullanicilarCalmaListeleriPanelLayout.setVerticalGroup(
            kullanicilarCalmaListeleriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullanicilarCalmaListeleriPanelLayout.createSequentialGroup()
                .addGroup(kullanicilarCalmaListeleriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kullanicilarCalmaListeleriPanelLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(kulCalmaListLabel)
                        .addGap(73, 73, 73)
                        .addGroup(kullanicilarCalmaListeleriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kullanicilarCalmaListeleriPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(37, 37, 37)))
                .addGroup(kullanicilarCalmaListeleriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(kullanicilarCalmaListeleriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonKulCalEkle)
                    .addComponent(butonKulCalEkle1)
                    .addComponent(butonKulCalEkle2))
                .addGap(107, 107, 107)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        cardLayout.add(kullanicilarCalmaListeleriPanel, "card6");

        takipEttiklerinPanel.setBackground(new java.awt.Color(0, 225, 195));

        takipEdilenTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "İSİM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(takipEdilenTablo);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("TAKİP ETTİKLERİN");

        takiptenCikBtn.setText("TAKİPTEN ÇIKAR");
        takiptenCikBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takiptenCikBtnActionPerformed(evt);
            }
        });

        jButton2.setText("ÇALMA LİSTELERİNE GİT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout takipEttiklerinPanelLayout = new javax.swing.GroupLayout(takipEttiklerinPanel);
        takipEttiklerinPanel.setLayout(takipEttiklerinPanelLayout);
        takipEttiklerinPanelLayout.setHorizontalGroup(
            takipEttiklerinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(takipEttiklerinPanelLayout.createSequentialGroup()
                .addGroup(takipEttiklerinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(takipEttiklerinPanelLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addGroup(takipEttiklerinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(takiptenCikBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(takipEttiklerinPanelLayout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        takipEttiklerinPanelLayout.setVerticalGroup(
            takipEttiklerinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(takipEttiklerinPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel10)
                .addGap(116, 116, 116)
                .addGroup(takipEttiklerinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(takipEttiklerinPanelLayout.createSequentialGroup()
                        .addComponent(takiptenCikBtn)
                        .addGap(39, 39, 39)
                        .addComponent(jButton2)))
                .addContainerGap(267, Short.MAX_VALUE))
        );

        cardLayout.add(takipEttiklerinPanel, "card5");

        turTop10Panel.setBackground(new java.awt.Color(0, 225, 195));

        bir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Adı", "Tür", "Albüm", "Sanatçı", "Dinlenme"
            }
        ));
        jScrollPane8.setViewportView(bir);

        iki.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Adı", "Tür", "Albüm", "Sanatçı", "Dinlenme"
            }
        ));
        jScrollPane9.setViewportView(iki);

        uc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Adı", "Tür", "Albüm", "Sanatçı", "Dinlenme"
            }
        ));
        jScrollPane10.setViewportView(uc);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("TÜRLERE GÖRE TOP 10 LİSTELERİ");

        jLabel12.setText("POP");

        jLabel13.setText("JAZZ");

        jLabel14.setText("KLASİK");

        javax.swing.GroupLayout turTop10PanelLayout = new javax.swing.GroupLayout(turTop10Panel);
        turTop10Panel.setLayout(turTop10PanelLayout);
        turTop10PanelLayout.setHorizontalGroup(
            turTop10PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(turTop10PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(turTop10PanelLayout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(turTop10PanelLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel12)
                .addGap(386, 386, 386)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(192, 192, 192))
        );
        turTop10PanelLayout.setVerticalGroup(
            turTop10PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, turTop10PanelLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(turTop10PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(47, 47, 47)
                .addGroup(turTop10PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(275, 275, 275))
        );

        cardLayout.add(turTop10Panel, "card8");

        top10.setBackground(new java.awt.Color(0, 225, 195));

        genelTop10Tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane7.setViewportView(genelTop10Tablo);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("GENEL TOP 10 LİSTESİ");

        javax.swing.GroupLayout top10Layout = new javax.swing.GroupLayout(top10);
        top10.setLayout(top10Layout);
        top10Layout.setHorizontalGroup(
            top10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top10Layout.createSequentialGroup()
                .addGroup(top10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(top10Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(top10Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(412, Short.MAX_VALUE))
        );
        top10Layout.setVerticalGroup(
            top10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top10Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel8)
                .addGap(116, 116, 116)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        cardLayout.add(top10, "card7");

        javax.swing.GroupLayout anaPanelLayout = new javax.swing.GroupLayout(anaPanel);
        anaPanel.setLayout(anaPanelLayout);
        anaPanelLayout.setHorizontalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anaPanelLayout.createSequentialGroup()
                .addComponent(solPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        anaPanelLayout.setVerticalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(solPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, anaPanelLayout.createSequentialGroup()
                .addComponent(cardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calmaListeneEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calmaListeneEkleActionPerformed
       int sayac = sarkiListesi.getSelectedRow(); 
   
        
       
        System.out.println(" +++ " + sayac);
           
            int eklenilecekSarki =Integer.valueOf(sarkiTablo.getValueAt(sayac, 0).toString());
            String eklenenTur =sarkiTablo.getValueAt(sayac, 2).toString();
            int albumTur=-1;
             
            if(eklenenTur == "Pop")
            {
                albumTur = 1;
            }
            
            else if(eklenenTur=="Jazz")
            {
                albumTur = 2;
            }
            
            else if(eklenenTur=="Klasik")
            {
                albumTur = 3;
            }
            
       
            
              Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="insert into calmalisteleri (kullanici_id,sarki_id) values (?,?)";
            statement = connection.prepareStatement(sql);
          statement.setInt(1,girenKisi.get(0).getKullaniciID());
          statement.setInt(2,eklenilecekSarki );
//          statement.setInt(3, albumTur);
          
          
          statement.executeUpdate();
           
            
            System.out.println("Kayıt eklendi");
            
        }
        
        catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
           
        }
        finally
        {       try {
            statement.close();
            connection.close();
            } catch (SQLException ex) {
              
            }
        }
    }//GEN-LAST:event_calmaListeneEkleActionPerformed

    private void benJazzBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_benJazzBtnActionPerformed
        // TODO add your handling code here:
        cardLayout.removeAll();
        cardLayout.add(jazzListesi);
        cardLayout.repaint();
        cardLayout.revalidate();
        jazzTabloGetir(2);
        hangisi= 2;
    }//GEN-LAST:event_benJazzBtnActionPerformed

    private void anaSayfaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anaSayfaBtnActionPerformed
        // TODO add your handling code here:
          cardLayout.removeAll();
        cardLayout.add(anaSayfaPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        tabloyuGetir();
    }//GEN-LAST:event_anaSayfaBtnActionPerformed

    public void takipEtButonFonksiyonu(int a)
    {
            Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="insert into takip (kullanici_id,takip_ettigi) values(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, girenKisi.get(0).getKullaniciID());
            statement.setInt(2, kullanicilar.get(a).getKullaniciID());
            System.out.println("-->>>> : " + kullanicilar.get(a).getKullaniciAd());
            
        
//          statement.setInt(3, albumTur);
          
          
          statement.executeUpdate();
           
            
            System.out.println("Kayıt eklendi");
            System.out.println("-->>>> : " + kullanicilar.get(a).getKullaniciAd());
        }
        
        catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
           
        }
        finally
        {       try {
            statement.close();
            connection.close();
            } catch (SQLException ex) {
              
            }
        }   
    }
    
    
    public void ArrayListelereAlma()
    {
       
        
        onlarinCalmaButonlari.add(kul1CalmaBtn);
        onlarinCalmaButonlari.add(kul1CalmaBtn1);
        onlarinCalmaButonlari.add(kul1CalmaBtn2);
        onlarinCalmaButonlari.add(kul1CalmaBtn3);
        onlarinCalmaButonlari.add(kul1CalmaBtn4);
        onlarinCalmaButonlari.add(kul1CalmaBtn5);
        onlarinCalmaButonlari.add(kul1CalmaBtn6);
        onlarinCalmaButonlari.add(kul1CalmaBtn7);
        onlarinCalmaButonlari.add(kul1CalmaBtn8);
        onlarinCalmaButonlari.add(kul1CalmaBtn9);
        
        
        takipEtButonlari.add(takip1);
        takipEtButonlari.add(takip2);
        takipEtButonlari.add(takip3);
        takipEtButonlari.add(takip4);
        takipEtButonlari.add(takip5);
        takipEtButonlari.add(takip6);
        takipEtButonlari.add(takip7);
        takipEtButonlari.add(takip8);
        takipEtButonlari.add(takip9);
        takipEtButonlari.add(takip10);
        
        for(int i=0; i<onlarinCalmaButonlari.size(); i++)
        {
            onlarinCalmaButonlari.get(i).setVisible(false);
        }
        
        
        for(int i=0; i<kullanicilar.size(); i++)
        {
            if(kullanicilar.get(i).isPremiumMu()==true)
            {
                takipEtButonlari.get(i).setVisible(true);
            }
            
            else
            {
                takipEtButonlari.get(i).setVisible(false);
            }
        }
        
    }
    
    private void takip1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip1ActionPerformed
        takipEtButonFonksiyonu(0);
        kul1CalmaBtn.setVisible(true);
            
    }//GEN-LAST:event_takip1ActionPerformed

    private void takip2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip2ActionPerformed
        takipEtButonFonksiyonu(1);
        kul1CalmaBtn1.setVisible(true);
    }//GEN-LAST:event_takip2ActionPerformed

    private void takip3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip3ActionPerformed
        // TODO add your handling code here:
        takipEtButonFonksiyonu(2);
        kul1CalmaBtn2.setVisible(true);
    }//GEN-LAST:event_takip3ActionPerformed

    private void kesfetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kesfetBtnActionPerformed
        // TODO add your handling code here:
       
         cardLayout.removeAll();
        cardLayout.add(kullanicilarPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        ArrayList<JLabel> isimler = new ArrayList<>();
     
        isimler.add(kullanici1Label);
        isimler.add(kullanici2Label);   
        isimler.add(kullanici3Label);
        isimler.add(kullanici4Label);
        isimler.add(kullanici5Label);
        isimler.add(kullanici6Label);
        isimler.add(kullanici7Label);
        isimler.add(kullanici8Label);
        isimler.add(kullanici9Label);
        isimler.add(kullanici10Label);
        
        
        for(int i=0; i<kullanicilar.size(); i++)  // kırmızılar premium olsun
        {
            if(kullanicilar.get(i).isPremiumMu()==true)
            {
               isimler.get(i).setText(kullanicilar.get(i).getKullaniciAd());
               isimler.get(i).setForeground(Color.red);
            }
            
            else
            {
                 isimler.get(i).setText(kullanicilar.get(i).getKullaniciAd());
                   isimler.get(i).setForeground(Color.black);
            }
            if(kullanicilar.size()>10)
            {
                if(kullanicilar.get(i).isPremiumMu()==true)
            {
               isimler.get(i).setText(kullanicilar.get(i).getKullaniciAd());
               isimler.get(i).setForeground(Color.red);
            }
            
            else
            {
                 isimler.get(i).setText(kullanicilar.get(i).getKullaniciAd());
                   isimler.get(i).setForeground(Color.black);
            }
                
            }
            
        }
        

      kullanicininTakipcileri();
        butonlariKapa();
        acikKapali();
        
        
        
        
        
        
    }//GEN-LAST:event_kesfetBtnActionPerformed

    private void takip5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip5ActionPerformed
         takipEtButonFonksiyonu(4);
        kul1CalmaBtn4.setVisible(true);
    }//GEN-LAST:event_takip5ActionPerformed

    private void takip4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip4ActionPerformed
        // TODO add your handling code here:
         takipEtButonFonksiyonu(3);
        kul1CalmaBtn3.setVisible(true);
    }//GEN-LAST:event_takip4ActionPerformed

    private void takip6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip6ActionPerformed
       takipEtButonFonksiyonu(5);
        kul1CalmaBtn5.setVisible(true);
    }//GEN-LAST:event_takip6ActionPerformed

    private void benPopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_benPopBtnActionPerformed
        // TODO add your handling code here:
        cardLayout.removeAll();
        cardLayout.add(jazzListesi);
        cardLayout.repaint();
        cardLayout.revalidate();
        jazzTabloGetir(1);
        hangisi=1;
    }//GEN-LAST:event_benPopBtnActionPerformed

    private void benKlasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_benKlasBtnActionPerformed
        // TODO add your handling code here:
          cardLayout.removeAll();
        cardLayout.add(jazzListesi);
        cardLayout.repaint();
        cardLayout.revalidate();
        jazzTabloGetir(3);
        hangisi=3;
    }//GEN-LAST:event_benKlasBtnActionPerformed

    private void kul1CalmaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtnActionPerformed
        // TODO add your handling code here:
         cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, 0, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, 0, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo, 0, 3);
 kulCalmaListLabel.setText(kullanicilar.get(0).getKullaniciAd() + " " + "ÇALMA LİSTESİ");
       
    }//GEN-LAST:event_kul1CalmaBtnActionPerformed

    private void butonKulCalEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonKulCalEkleActionPerformed

        OnlarinCalmaListesindenEkle(kullanicilarPopTablo);
        
        
    }//GEN-LAST:event_butonKulCalEkleActionPerformed

    private void butonKulCalEkle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonKulCalEkle1ActionPerformed
        // TODO add your handling code here:
        OnlarinCalmaListesindenEkle(kullanicilarJazzTablo);
    }//GEN-LAST:event_butonKulCalEkle1ActionPerformed

    private void butonKulCalEkle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonKulCalEkle2ActionPerformed
        // TODO add your handling code here:
        OnlarinCalmaListesindenEkle(kullanicilarKlasikTablo);
    }//GEN-LAST:event_butonKulCalEkle2ActionPerformed

    private void takip7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip7ActionPerformed
         takipEtButonFonksiyonu(6);
        kul1CalmaBtn6.setVisible(true);
    }//GEN-LAST:event_takip7ActionPerformed

    private void kul1CalmaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtn1ActionPerformed
         cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, 1, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, 1, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo, 1, 3);
 kulCalmaListLabel.setText(kullanicilar.get(1).getKullaniciAd() + " " + "ÇALMA LİSTESİ");
    }//GEN-LAST:event_kul1CalmaBtn1ActionPerformed

    private void kul1CalmaBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtn2ActionPerformed
      cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, 2, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, 2, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo, 2, 3);
 kulCalmaListLabel.setText(kullanicilar.get(2).getKullaniciAd() + " " + "ÇALMA LİSTESİ");
    }//GEN-LAST:event_kul1CalmaBtn2ActionPerformed

    private void kul1CalmaBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtn3ActionPerformed
            cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, 3, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, 3, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo, 3, 3);
 kulCalmaListLabel.setText(kullanicilar.get(3).getKullaniciAd() + " " + "ÇALMA LİSTESİ");
    }//GEN-LAST:event_kul1CalmaBtn3ActionPerformed

    private void kul1CalmaBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtn4ActionPerformed
               cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, 4, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, 4, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo, 4, 3);
 kulCalmaListLabel.setText(kullanicilar.get(4).getKullaniciAd() + " " + "ÇALMA LİSTESİ");
    }//GEN-LAST:event_kul1CalmaBtn4ActionPerformed

    private void kul1CalmaBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtn5ActionPerformed
        cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, 5, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, 5, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo, 5, 3);
 kulCalmaListLabel.setText(kullanicilar.get(5).getKullaniciAd() + " " + "ÇALMA LİSTESİ");
    }//GEN-LAST:event_kul1CalmaBtn5ActionPerformed

    private void kul1CalmaBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtn6ActionPerformed
         cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, 6, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, 6, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo, 6, 3);
 kulCalmaListLabel.setText(kullanicilar.get(6).getKullaniciAd() + " " + "ÇALMA LİSTESİ");
    }//GEN-LAST:event_kul1CalmaBtn6ActionPerformed

    private void takip8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip8ActionPerformed
        takipEtButonFonksiyonu(7);
        kul1CalmaBtn7.setVisible(true);
    }//GEN-LAST:event_takip8ActionPerformed

    private void takip9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip9ActionPerformed
       takipEtButonFonksiyonu(8);
        kul1CalmaBtn8.setVisible(true);
    }//GEN-LAST:event_takip9ActionPerformed

    private void takip10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip10ActionPerformed
        takipEtButonFonksiyonu(9);
        kul1CalmaBtn9.setVisible(true);
    }//GEN-LAST:event_takip10ActionPerformed

    private void kul1CalmaBtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtn7ActionPerformed
           cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, 7, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, 7, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo, 7, 3);
 kulCalmaListLabel.setText(kullanicilar.get(7).getKullaniciAd() + " " + "ÇALMA LİSTESİ");
    }//GEN-LAST:event_kul1CalmaBtn7ActionPerformed

    private void kul1CalmaBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtn8ActionPerformed
    cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, 8, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, 8, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo, 8, 3);
 kulCalmaListLabel.setText(kullanicilar.get(8).getKullaniciAd() + " " + "ÇALMA LİSTESİ");
    }//GEN-LAST:event_kul1CalmaBtn8ActionPerformed

    private void kul1CalmaBtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtn9ActionPerformed
   cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, 9, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, 9, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo, 9, 3);
 kulCalmaListLabel.setText(kullanicilar.get(9).getKullaniciAd() + " " + "ÇALMA LİSTESİ");
    }//GEN-LAST:event_kul1CalmaBtn9ActionPerformed
public void takipListesiniGetir()
{
    takipModel = (DefaultTableModel) takipEdilenTablo.getModel();
        
        takipModel.setRowCount(0);
        
        for(int i=0; i<girenKisi.get(0).takipcileri.size(); i++)
        {
            Object[]row ={girenKisi.get(0).takipcileri.get(i).getKullaniciAd()};
            takipModel.addRow(row);
        }
}
    private void takipEttiklerinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takipEttiklerinBtnActionPerformed
cardLayout.removeAll();
        cardLayout.add(takipEttiklerinPanel);
        cardLayout.repaint();
        cardLayout.revalidate(); 
        
  
        
        kullanicininTakipcileri();
         takipModel = (DefaultTableModel) takipEdilenTablo.getModel();
        
        takipModel.setRowCount(0);
        
      takipEttiklerinTabloListesi();
        
     
        
        
    }//GEN-LAST:event_takipEttiklerinBtnActionPerformed

    public void takipEttiklerinTabloListesi()
    {
      
        takipModel.getDataVector().removeAllElements();
        takipEdilenTablo.repaint();
        for(int i=0; i<girenKisi.get(0).takipcileri.size(); i++)
        {
            Object[]row ={girenKisi.get(0).takipcileri.get(i).getKullaniciID(),girenKisi.get(0).takipcileri.get(i).getKullaniciAd()};
            takipModel.addRow(row);
        }
    }
    
    private void takiptenCikBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takiptenCikBtnActionPerformed
         int sayac = takipEdilenTablo.getSelectedRow(); 
        int silenecekTakipci =Integer.valueOf(takipModel.getValueAt(sayac, 0).toString());
        
  Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="DELETE from takip where kullanici_id='"+girenKisi.get(0).getKullaniciID()+"' and  takip_ettigi= ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, silenecekTakipci);  // 1 ilk soru işareti demek !
            
          
          statement.executeUpdate();
           
            
            System.out.println("Kayıt silindi");
            
        }
        
        catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
           
        }
        finally
        {       try {
            statement.close();
            connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(KullaniciMenu.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        
        kullanicininTakipcileri();
      takipEttiklerinTabloListesi();

        
        
    }//GEN-LAST:event_takiptenCikBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   int sayac = sarkiListesi.getSelectedRow();  
    int updateSarki =Integer.valueOf(sarkiTablo.getValueAt(sayac, 0).toString());
     String calinan = sarkiTablo.getValueAt(sayac, 1).toString();
   
        
        Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="update sarkilar set dinlenme_sayisi=dinlenme_sayisi+1 where sarki_id =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, updateSarki);  // 1 ilk soru işareti demek !
         
          
          statement.executeUpdate();
           
            
            System.out.println("Kayıt güncellendi");
            
        }
        
        catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
           
        }
        finally
        {       try {
            statement.close();
            connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(KullaniciMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tabloyuGetir();
        labelim.setText("Şu anda çalınan : " +calinan);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void top10BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_top10BtnActionPerformed
  cardLayout.removeAll();
        cardLayout.add(top10);
        cardLayout.repaint();
        cardLayout.revalidate();
        genelTop10();
    }//GEN-LAST:event_top10BtnActionPerformed

    private void turTop10BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turTop10BtnActionPerformed
        cardLayout.removeAll();
        cardLayout.add(turTop10Panel);
        cardLayout.repaint();
        cardLayout.revalidate();
        
        turTop10(1, popTopModel, bir);
        turTop10(2, jazzTopModel, iki);
        turTop10(3, klasikTopModel, uc);
    }//GEN-LAST:event_turTop10BtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   int sayac = takipEdilenTablo.getSelectedRow(); 
   int kim =Integer.valueOf(takipModel.getValueAt(sayac, 0).toString());
   int index=0;
   for(int i=0; i<kullanicilar.size(); i++)
   {
       if(kullanicilar.get(i).getKullaniciID() == kim)
       {
           index=i;
       }
       
   }
         
   
   
   cardLayout.removeAll();
        cardLayout.add(kullanicilarCalmaListeleriPanel);
        cardLayout.repaint();
        cardLayout.revalidate(); 
        
     
        System.out.println("Sessizkşjk :Ç  " + kim);
        
      takipEdilenCalmaListeleri(kulPopTablo, kullanicilarPopTablo, index, 1); // 0 ilk kullanıcı 1 ise pop türü
        takipEdilenCalmaListeleri(kulJazzTablo, kullanicilarJazzTablo, index, 2);
        takipEdilenCalmaListeleri(kulKlasikTablo, kullanicilarKlasikTablo,index, 3);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  int sayac = jazzListesiTablo.getSelectedRow();  
    int sill =Integer.valueOf(jazzTablo.getValueAt(sayac, 0).toString());      
        
        
        
        Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="delete from calmalisteleri where kullanici_id='"+girenKisi.get(0).getKullaniciID()+"' and sarki_id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,sill );  // 1 ilk soru işareti demek !
            
          
          statement.executeUpdate();
           
            
            System.out.println("Kayıt silindi");
            
        }
        
        catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
           
        }
        finally
        {       try {
            statement.close();
            connection.close();
           } catch (SQLException ex) {
               Logger.getLogger(KullaniciMenu.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        jazzTabloGetir(hangisi);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void takip11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takip11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_takip11ActionPerformed

    private void kul1CalmaBtn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kul1CalmaBtn10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kul1CalmaBtn10ActionPerformed
public void cal(JTable tablo)
{
     int sayac = tablo.getSelectedRow();  
    int updateSarki =Integer.valueOf(tablo.getValueAt(sayac, 0).toString());
     String calinan = tablo.getValueAt(sayac, 1).toString();
   
        
        Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="update sarkilar set dinlenme_sayisi=dinlenme_sayisi+1 where sarki_id =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, updateSarki);  // 1 ilk soru işareti demek !
         
          
          statement.executeUpdate();
           
            
            System.out.println("Kayıt güncellendi");
            
        }
        
        catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
           
        }
        finally
        {       try {
            statement.close();
            connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(KullaniciMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        labelim.setText("Şu anda çalınan : " +calinan);
}
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//      

        cal(kullanicilarPopTablo);
        cal( kullanicilarKlasikTablo);
        cal(kullanicilarJazzTablo);
//int sayac = kullanicilarPopTablo.getSelectedRow();  
//    int updateSarki =Integer.valueOf(kullanicilarPopTablo.getValueAt(sayac, 0).toString());
//     String calinan = kullanicilarPopTablo.getValueAt(sayac, 1).toString();
//   
//        
//        Connection connection=null;
//        PreparedStatement statement = null;
//        ResultSet resultSet;
//        
//        
//        
//        try{
//            DbHelper helper = new DbHelper();
//           
//            connection =  helper.getConnection();
//            String sql="update sarkilar set dinlenme_sayisi=dinlenme_sayisi+1 where sarki_id =?";
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, updateSarki);  // 1 ilk soru işareti demek !
//         
//          
//          statement.executeUpdate();
//           
//            
//            System.out.println("Kayıt güncellendi");
//            
//        }
//        
//        catch(SQLException exception)
//        {
//            System.out.println(exception.getMessage());
//           
//        }
//        finally
//        {       try {
//            statement.close();
//            connection.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(KullaniciMenu.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        tabloyuGetir();
//        labelim.setText("Şu anda çalınan : " +calinan);
    }//GEN-LAST:event_jButton4ActionPerformed
public void calma(JTable tab)
{
      int sayac = tab.getSelectedRow();  
    int updateSarki =Integer.valueOf(tab.getValueAt(sayac, 0).toString());
     String calinan = tab.getValueAt(sayac, 1).toString();
   
        
        Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="update sarkilar set dinlenme_sayisi=dinlenme_sayisi+1 where sarki_id =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, updateSarki);  // 1 ilk soru işareti demek !
         
          
          statement.executeUpdate();
           
            
            System.out.println("Kayıt güncellendi");
            
        }
        
        catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
           
        }
        finally
        {       try {
            statement.close();
            connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(KullaniciMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        labelim.setText("Şu anda çalınan : " +calinan);
}
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    if(hangisi==2)
    {
        calma(jazzListesiTablo);
        jazzTabloGetir(2);
    }
    
    else if(hangisi==1)
    {
       calma(jazzListesiTablo);
        jazzTabloGetir(1);
    }
    
    else if(hangisi==3)
    {
         calma(jazzListesiTablo);
        jazzTabloGetir(3);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KullaniciMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KullaniciMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KullaniciMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KullaniciMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullaniciMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel anaPanel;
    private javax.swing.JButton anaSayfaBtn;
    private javax.swing.JPanel anaSayfaPanel;
    private javax.swing.JButton benJazzBtn;
    private javax.swing.JButton benKlasBtn;
    private javax.swing.JButton benPopBtn;
    private javax.swing.JTable bir;
    private javax.swing.JButton butonKulCalEkle;
    private javax.swing.JButton butonKulCalEkle1;
    private javax.swing.JButton butonKulCalEkle2;
    private javax.swing.JButton calmaListeneEkle;
    private javax.swing.JPanel cardLayout;
    private javax.swing.JTable genelTop10Tablo;
    private javax.swing.JTable iki;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jazzListesi;
    private javax.swing.JTable jazzListesiTablo;
    private javax.swing.JButton kesfetBtn;
    private javax.swing.JLabel kiminCalmaListesiLabel;
    private javax.swing.JButton kul1CalmaBtn;
    private javax.swing.JButton kul1CalmaBtn1;
    private javax.swing.JButton kul1CalmaBtn10;
    private javax.swing.JButton kul1CalmaBtn2;
    private javax.swing.JButton kul1CalmaBtn3;
    private javax.swing.JButton kul1CalmaBtn4;
    private javax.swing.JButton kul1CalmaBtn5;
    private javax.swing.JButton kul1CalmaBtn6;
    private javax.swing.JButton kul1CalmaBtn7;
    private javax.swing.JButton kul1CalmaBtn8;
    private javax.swing.JButton kul1CalmaBtn9;
    private javax.swing.JLabel kulCalmaListLabel;
    private javax.swing.JLabel kullanici10Label;
    private javax.swing.JLabel kullanici11Label;
    private javax.swing.JLabel kullanici1Label;
    private javax.swing.JLabel kullanici2Label;
    private javax.swing.JLabel kullanici3Label;
    private javax.swing.JLabel kullanici4Label;
    private javax.swing.JLabel kullanici5Label;
    private javax.swing.JLabel kullanici6Label;
    private javax.swing.JLabel kullanici7Label;
    private javax.swing.JLabel kullanici8Label;
    private javax.swing.JLabel kullanici9Label;
    private javax.swing.JLabel kullaniciAdiLabel;
    private javax.swing.JPanel kullanicilarCalmaListeleriPanel;
    private javax.swing.JTable kullanicilarJazzTablo;
    private javax.swing.JTable kullanicilarKlasikTablo;
    private javax.swing.JPanel kullanicilarPanel;
    private javax.swing.JTable kullanicilarPopTablo;
    private javax.swing.JLabel labelim;
    private javax.swing.JPanel playPanel;
    private javax.swing.JLabel premiumLabel;
    private javax.swing.JTable sarkiListesi;
    private javax.swing.JPanel solPanel;
    private javax.swing.JButton takip1;
    private javax.swing.JButton takip10;
    private javax.swing.JButton takip11;
    private javax.swing.JButton takip2;
    private javax.swing.JButton takip3;
    private javax.swing.JButton takip4;
    private javax.swing.JButton takip5;
    private javax.swing.JButton takip6;
    private javax.swing.JButton takip7;
    private javax.swing.JButton takip8;
    private javax.swing.JButton takip9;
    private javax.swing.JTable takipEdilenTablo;
    private javax.swing.JButton takipEttiklerinBtn;
    private javax.swing.JPanel takipEttiklerinPanel;
    private javax.swing.JButton takiptenCikBtn;
    private javax.swing.JPanel top10;
    private javax.swing.JButton top10Btn;
    private javax.swing.JButton turTop10Btn;
    private javax.swing.JPanel turTop10Panel;
    private javax.swing.JTable uc;
    // End of variables declaration//GEN-END:variables
}
