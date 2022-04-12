
import java.awt.CardLayout;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 90545
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    CardLayout cardLayout1,cardLayout2;
    DefaultTableModel sarkiTablo = new DefaultTableModel();
    DefaultTableModel albumTablo = new DefaultTableModel();
    DefaultTableModel kullaniciModel = new DefaultTableModel();
    ArrayList<Albumler> albums ;
    ArrayList<DefaultTableModel> tabloModelleri = new ArrayList<>();
     ArrayList<JTable> jtablolar = new ArrayList<>();
    
    
    Albumler alb;
    public Admin() {
        initComponents();
        alb = new Albumler();
        albums = Albumler.albumler;
        
        cardLayout1= (CardLayout) (cardLayout.getLayout());
        cardLayout2=(CardLayout) (yeniCardLay.getLayout());
        tabloyuGetir();
        albumTablo = (DefaultTableModel)albumListe.getModel();
        tabloModelleriArray();
    }
public void veriTabaniKullanicilar()
{
     tabloModelleri.get(2).setRowCount(0);
         Connection connection =null;
   DbHelper dbHelper = new DbHelper();
   Statement statement=null;
   ResultSet resultSet;
 
   
   try{
       connection = dbHelper.getConnection();
       statement = connection.createStatement();
       resultSet = statement.executeQuery("select * from kullanicilar;");
       
       
        while(resultSet.next())
       {
          Object[] row={resultSet.getInt("kullanici_id"),resultSet.getString("kullanici_adi"),resultSet.getString("kullanici_sifre"),
       resultSet.getBoolean("premium"),resultSet.getString("kullanici_email")};
          tabloModelleri.get(2).addRow(row);
          
       }
       
   }
   catch(SQLException exception){
       dbHelper.showErrorMessage(exception);
   }
   finally{
             try {
                 statement.close();
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
       
       
   }  
}
     public void veriTabaniKategoriler()
     {
          tabloModelleri.get(1).setRowCount(0);
         Connection connection =null;
   DbHelper dbHelper = new DbHelper();
   Statement statement=null;
   ResultSet resultSet;
 
   
   try{
       connection = dbHelper.getConnection();
       statement = connection.createStatement();
       resultSet = statement.executeQuery("select * from kategoriler;");
       
       
       while(resultSet.next())
       {
          Object[] row={resultSet.getInt("kategori_id"),resultSet.getString("kategori_adi")};
           tabloModelleri.get(1).addRow(row);
          
       }
       
   }
   catch(SQLException exception){
       dbHelper.showErrorMessage(exception);
   }
   finally{
             try {
                 statement.close();
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
       
       
   }  
     }
    public void veriTabaniTakip()
    {
        tabloModelleri.get(3).setRowCount(0);
         Connection connection =null;
   DbHelper dbHelper = new DbHelper();
   Statement statement=null;
   ResultSet resultSet;
 
   
   try{
       connection = dbHelper.getConnection();
       statement = connection.createStatement();
       resultSet = statement.executeQuery("select * from takip;");
       
       
       while(resultSet.next())
       {
          Object[] row={resultSet.getInt("kullanici_id"),resultSet.getInt("takip_ettigi")};
           tabloModelleri.get(3).addRow(row);
          
       }
       
   }
   catch(SQLException exception){
       dbHelper.showErrorMessage(exception);
   }
   finally{
             try {
                 statement.close();
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
       
       
   }  
    }
    public void veriTabaniCalma()
    {
       tabloModelleri.get(0).setRowCount(0);
         Connection connection =null;
   DbHelper dbHelper = new DbHelper();
   Statement statement=null;
   ResultSet resultSet;
 
   
   try{
       connection = dbHelper.getConnection();
       statement = connection.createStatement();
       resultSet = statement.executeQuery("select * from calmalisteleri;");
       
       
       while(resultSet.next())
       {
          Object[] row={resultSet.getInt("calma_id"),resultSet.getInt("kullanici_id"),resultSet.getInt("sarki_id")};
           tabloModelleri.get(0).addRow(row);
          
       }
       
   }
   catch(SQLException exception){
       dbHelper.showErrorMessage(exception);
   }
   finally{
             try {
                 statement.close();
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
       
       
   }  
    }
    public void verTabaniAlbumler()
    {
          tabloModelleri.get(5).setRowCount(0);
         Connection connection =null;
   DbHelper dbHelper = new DbHelper();
   Statement statement=null;
   ResultSet resultSet;
 
   
   try{
       connection = dbHelper.getConnection();
       statement = connection.createStatement();
       resultSet = statement.executeQuery("select * from albumler;");
       
       
       while(resultSet.next())
       {
          Object[] row={resultSet.getInt("album_id"),resultSet.getString("album_adi"),resultSet.getString("sanatci"),
       resultSet.getString("tarih"),resultSet.getInt("kategori_id")};
           tabloModelleri.get(5).addRow(row);
          
       }
       
   }
   catch(SQLException exception){
       dbHelper.showErrorMessage(exception);
   }
   finally{
             try {
                 statement.close();
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
       
       
   }
    }
    public void veriTabaniSarkilar()
{
     
        tabloModelleri.get(4).setRowCount(0);
         Connection connection =null;
   DbHelper dbHelper = new DbHelper();
   Statement statement=null;
   ResultSet resultSet;
 
   
   try{
       connection = dbHelper.getConnection();
       statement = connection.createStatement();
       resultSet = statement.executeQuery("select * from sarkilar;");
       
       
       while(resultSet.next())
       {
          Object[] row={resultSet.getInt("sarki_id"),resultSet.getString("sarki_adi"),resultSet.getInt("album_id"),
       resultSet.getInt("dinlenme_sayisi")};
           tabloModelleri.get(4).addRow(row);
          
       }
       
   }
   catch(SQLException exception){
       dbHelper.showErrorMessage(exception);
   }
   finally{
             try {
                 statement.close();
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
       
       
   }
}
    public void kullaniciTablosuGetir()
    {
         kullaniciModel = (DefaultTableModel)kullaniciTablo.getModel();
        kullaniciModel.setRowCount(0);
         Connection connection =null;
   DbHelper dbHelper = new DbHelper();
   Statement statement=null;
   ResultSet resultSet;
   ArrayList<Sarkilar> sarkiListem =null;
   
   try{
       connection = dbHelper.getConnection();
       statement = connection.createStatement();
       resultSet = statement.executeQuery("select * from kullanicilar;");
       
       
       while(resultSet.next())
       {
          Object[] row={resultSet.getInt("kullanici_id"),resultSet.getString("kullanici_adi"),resultSet.getString("kullanici_sifre"),
       resultSet.getBoolean("premium"),resultSet.getString("kullanici_email")};
          kullaniciModel.addRow(row);
          
       }
       
   }
   catch(SQLException exception){
       dbHelper.showErrorMessage(exception);
   }
   finally{
             try {
                 statement.close();
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
       
       
   }
    }
    
    
    
    public void  tabloModelleriArray()
    {
        tabloModelleri.add((DefaultTableModel)veriTabaniCalmaListe.getModel());
        tabloModelleri.add((DefaultTableModel)veriTabaniKategorilerListe.getModel());
        tabloModelleri.add((DefaultTableModel)veriTabaniKullaniciListe.getModel());
        tabloModelleri.add((DefaultTableModel)veriTabaniTakipListe.getModel());
        tabloModelleri.add((DefaultTableModel)veritabanıSarkiListe.getModel());
         tabloModelleri.add((DefaultTableModel)veriTabaniAlbumListed.getModel());
         
          
         
         
         
         
    }
    public void albumListesiGetir()
    {
        Albumler a = new Albumler();
        
        a.albumListeleri();
      albumTablo.setRowCount(0);
        albumTablo.getDataVector().removeAllElements();
        albumListe.repaint();
        System.out.println("Abüm size : " + albums.size());
        for(Albumler album : albums)
        {
            Object [] row = {album.getAlbum_id(),album.getAlbum_adi(),album.getSanatci(),album.getTarih(),
            album.getKategori_adi()};
            albumTablo.addRow(row);
            
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anaPanel = new javax.swing.JPanel();
        solPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        cardLayout = new javax.swing.JPanel();
        sarkiEkle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sarkiListesi = new javax.swing.JTable();
        sarkiAdiTxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        albumAdiTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        silBtn = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lebel = new javax.swing.JLabel();
        sarkiUpdateTxt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        albumEkle = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        albumListe = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        albmekle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sanatciTxt = new javax.swing.JTextField();
        tarihTxt = new javax.swing.JTextField();
        turTxt = new javax.swing.JTextField();
        albumEkleBtn = new javax.swing.JButton();
        albumSil = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        guncelleTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        updateLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        kullanicilarPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        kullaniciTablo = new javax.swing.JTable();
        txAd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txSifre = new javax.swing.JTextField();
        txPre = new javax.swing.JTextField();
        txEma = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        textt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        veriTabaniPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        yeniCardLay = new javax.swing.JPanel();
        kullanicilar = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        veriTabaniKullaniciListe = new javax.swing.JTable();
        vtAlbumler = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        veriTabaniAlbumListed = new javax.swing.JTable();
        vtSarkiPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        veritabanıSarkiListe = new javax.swing.JTable();
        kategoriler = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        veriTabaniKategorilerListe = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        veriTabaniTakipListe = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        veriTabaniCalmaListe = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1400, 1000));
        setPreferredSize(new java.awt.Dimension(1400, 1000));

        solPanel.setBackground(new java.awt.Color(0, 255, 204));

        jButton1.setText("ŞARKI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Albüm Listesi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Kullanıcılar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton10.setText("VERİ TABANI");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setText("ADMİN");

        javax.swing.GroupLayout solPanelLayout = new javax.swing.GroupLayout(solPanel);
        solPanel.setLayout(solPanelLayout);
        solPanelLayout.setHorizontalGroup(
            solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(solPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel21)
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        solPanelLayout.setVerticalGroup(
            solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solPanelLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(50, 50, 50)
                .addComponent(jButton10)
                .addGap(367, 367, 367))
        );

        cardLayout.setLayout(new java.awt.CardLayout());

        sarkiEkle.setBackground(new java.awt.Color(0, 102, 102));

        sarkiListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Adı", "Albüm", "Sanatçı", "Tür", "Dinlenme"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sarkiListesi.setColumnSelectionAllowed(true);
        sarkiListesi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sarkiListesiMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sarkiListesiMouseMoved(evt);
            }
        });
        sarkiListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sarkiListesiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sarkiListesi);
        sarkiListesi.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (sarkiListesi.getColumnModel().getColumnCount() > 0) {
            sarkiListesi.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton2.setText("EKLE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Şarku Adı: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Albüm Adı: ");

        silBtn.setText("SİL");
        silBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silBtnActionPerformed(evt);
            }
        });

        jButton7.setText("GÜNCELLE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 51));
        jLabel12.setText("Güncellenecek olan :");

        lebel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 3, 28)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 255));
        jLabel20.setText("ŞARKILAR");

        jButton15.setText("DİNLENME GÜNCELLE");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel22.setText("DİNLENME SAYISI GÜNCELLEMEK İÇİN BURAYA TIKLA");

        javax.swing.GroupLayout sarkiEkleLayout = new javax.swing.GroupLayout(sarkiEkle);
        sarkiEkle.setLayout(sarkiEkleLayout);
        sarkiEkleLayout.setHorizontalGroup(
            sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sarkiEkleLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(sarkiEkleLayout.createSequentialGroup()
                .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sarkiEkleLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sarkiEkleLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(sarkiUpdateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sarkiEkleLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(lebel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sarkiEkleLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(18, 18, 18)
                .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sarkiEkleLayout.createSequentialGroup()
                        .addGap(0, 126, Short.MAX_VALUE)
                        .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sarkiEkleLayout.createSequentialGroup()
                                .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(sarkiEkleLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sarkiAdiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(sarkiEkleLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(69, 69, 69)
                                        .addComponent(albumAdiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(278, 278, 278))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sarkiEkleLayout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(176, 176, 176))))
                    .addGroup(sarkiEkleLayout.createSequentialGroup()
                        .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(silBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        sarkiEkleLayout.setVerticalGroup(
            sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sarkiEkleLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel20)
                .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sarkiEkleLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(silBtn)
                        .addGap(146, 146, 146)
                        .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sarkiAdiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(3, 3, 3)
                        .addComponent(jButton2)
                        .addGap(8, 8, 8)
                        .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(albumAdiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sarkiEkleLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lebel))
                .addGap(32, 32, 32)
                .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sarkiUpdateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(37, 37, 37)
                .addGroup(sarkiEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jLabel22))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        cardLayout.add(sarkiEkle, "card2");

        albumEkle.setBackground(new java.awt.Color(0, 102, 102));

        albumListe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Adı", "Sanatçı", "Tarih", "Tür"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        albumListe.setColumnSelectionAllowed(true);
        albumListe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                albumListeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(albumListe);
        albumListe.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Albüm Adı :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Sanatçı Adı :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Tarih :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Tür : ");

        albumEkleBtn.setText("EKLE");
        albumEkleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumEkleBtnActionPerformed(evt);
            }
        });

        albumSil.setText("SİL");
        albumSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumSilActionPerformed(evt);
            }
        });

        jButton6.setText("GÜNCELLE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("Güncellenecek olan :");

        updateLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 28)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 255));
        jLabel19.setText("ALBÜMLER");

        javax.swing.GroupLayout albumEkleLayout = new javax.swing.GroupLayout(albumEkle);
        albumEkle.setLayout(albumEkleLayout);
        albumEkleLayout.setHorizontalGroup(
            albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(albumEkleLayout.createSequentialGroup()
                .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(albumEkleLayout.createSequentialGroup()
                        .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(albumEkleLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(guncelleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, albumEkleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(albumSil, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(albumEkleLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73)
                .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(albumEkleLayout.createSequentialGroup()
                        .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(albumEkleLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(albmekle, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(albumEkleLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tarihTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(albumEkleLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(turTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(348, Short.MAX_VALUE))
                    .addGroup(albumEkleLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sanatciTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(albumEkleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
            .addGroup(albumEkleLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(updateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        albumEkleLayout.setVerticalGroup(
            albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(albumEkleLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(albmekle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(albumEkleLayout.createSequentialGroup()
                        .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(albumEkleLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(albumEkleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(albumEkleLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(sanatciTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(albumEkleLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(tarihTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(albumEkleLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(albumSil)))
                        .addGap(26, 26, 26)
                        .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(turTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(albumEkleLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateLabel))
                .addGap(44, 44, 44)
                .addGroup(albumEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guncelleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(312, 312, 312))
        );

        cardLayout.add(albumEkle, "card3");

        kullanicilarPanel.setBackground(new java.awt.Color(0, 102, 102));

        kullaniciTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Kullanıcı Adı", "Şifre", "Premium", "EMAIL"
            }
        ));
        kullaniciTablo.setColumnSelectionAllowed(true);
        kullaniciTablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kullaniciTabloMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(kullaniciTablo);
        kullaniciTablo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Kullanıcı Adı :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Şifre :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Premium Mu :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("EMAIL :");

        jButton5.setText("EKLE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setText("GÜNCELLE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 51));
        jLabel13.setText("Güncellenecek Olan :");

        lbl.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lbl.setText("jLabel14");

        jButton9.setText("SİL");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(0, 0, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("true/false");

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 28)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 255));
        jLabel18.setText("KULLANICILAR");

        javax.swing.GroupLayout kullanicilarPanelLayout = new javax.swing.GroupLayout(kullanicilarPanel);
        kullanicilarPanel.setLayout(kullanicilarPanelLayout);
        kullanicilarPanelLayout.setHorizontalGroup(
            kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                .addComponent(textt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                .addGap(0, 151, Short.MAX_VALUE)
                                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kullanicilarPanelLayout.createSequentialGroup()
                                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(149, 149, 149)
                                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txEma, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txAd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                                .addComponent(txPre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel17)))
                                        .addGap(58, 58, 58))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kullanicilarPanelLayout.createSequentialGroup()
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(253, 253, 253))))
                            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(117, 117, 117)
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                .addGap(498, 498, 498)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        kullanicilarPanelLayout.setVerticalGroup(
            kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullanicilarPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kullanicilarPanelLayout.createSequentialGroup()
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txSifre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(2, 2, 2)
                        .addComponent(jButton9)
                        .addGap(12, 12, 12)
                        .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txEma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kullanicilarPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbl))
                .addGap(31, 31, 31)
                .addGroup(kullanicilarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(textt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(356, Short.MAX_VALUE))
        );

        cardLayout.add(kullanicilarPanel, "card4");

        veriTabaniPanel.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jButton11.setText("kullanicilar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("kategoriler, takip ve calmalisteleri");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("albumler");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("sarkilar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        yeniCardLay.setLayout(new java.awt.CardLayout());

        kullanicilar.setBackground(new java.awt.Color(0, 102, 102));

        veriTabaniKullaniciListe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "kullanici_id", "kullanici_adi", "premium", "kullanici_sifre", "kullanici_email"
            }
        ));
        jScrollPane4.setViewportView(veriTabaniKullaniciListe);
        if (veriTabaniKullaniciListe.getColumnModel().getColumnCount() > 0) {
            veriTabaniKullaniciListe.getColumnModel().getColumn(2).setHeaderValue("premium");
            veriTabaniKullaniciListe.getColumnModel().getColumn(3).setHeaderValue("kullanici_sifre");
            veriTabaniKullaniciListe.getColumnModel().getColumn(4).setHeaderValue("kullanici_email");
        }

        javax.swing.GroupLayout kullanicilarLayout = new javax.swing.GroupLayout(kullanicilar);
        kullanicilar.setLayout(kullanicilarLayout);
        kullanicilarLayout.setHorizontalGroup(
            kullanicilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullanicilarLayout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(367, Short.MAX_VALUE))
        );
        kullanicilarLayout.setVerticalGroup(
            kullanicilarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullanicilarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        yeniCardLay.add(kullanicilar, "card2");

        vtAlbumler.setBackground(new java.awt.Color(0, 102, 102));

        veriTabaniAlbumListed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "album_id", "album_adi", "sanatci", "tarih", "kategori_id"
            }
        ));
        jScrollPane9.setViewportView(veriTabaniAlbumListed);

        javax.swing.GroupLayout vtAlbumlerLayout = new javax.swing.GroupLayout(vtAlbumler);
        vtAlbumler.setLayout(vtAlbumlerLayout);
        vtAlbumlerLayout.setHorizontalGroup(
            vtAlbumlerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vtAlbumlerLayout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        vtAlbumlerLayout.setVerticalGroup(
            vtAlbumlerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vtAlbumlerLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        yeniCardLay.add(vtAlbumler, "card5");

        vtSarkiPanel.setBackground(new java.awt.Color(0, 102, 102));

        veritabanıSarkiListe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "sarki_id", "sarki_adi", "album_id", "dinlenme_sayisi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        veritabanıSarkiListe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                veritabanıSarkiListeMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                veritabanıSarkiListeMouseMoved(evt);
            }
        });
        veritabanıSarkiListe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                veritabanıSarkiListeMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(veritabanıSarkiListe);
        if (veritabanıSarkiListe.getColumnModel().getColumnCount() > 0) {
            veritabanıSarkiListe.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout vtSarkiPanelLayout = new javax.swing.GroupLayout(vtSarkiPanel);
        vtSarkiPanel.setLayout(vtSarkiPanelLayout);
        vtSarkiPanelLayout.setHorizontalGroup(
            vtSarkiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vtSarkiPanelLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        vtSarkiPanelLayout.setVerticalGroup(
            vtSarkiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vtSarkiPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        yeniCardLay.add(vtSarkiPanel, "card4");

        kategoriler.setBackground(new java.awt.Color(0, 102, 102));

        veriTabaniKategorilerListe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "kategori_id", "kategori_adi"
            }
        ));
        jScrollPane5.setViewportView(veriTabaniKategorilerListe);

        veriTabaniTakipListe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "kullanici_id", "takip_ettigi"
            }
        ));
        jScrollPane6.setViewportView(veriTabaniTakipListe);

        veriTabaniCalmaListe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "kategori_id", "kategori_adi"
            }
        ));
        jScrollPane7.setViewportView(veriTabaniCalmaListe);

        jLabel14.setText("takip");

        jLabel15.setText("kategoriler");

        jLabel16.setText("calmalisteleri");

        javax.swing.GroupLayout kategorilerLayout = new javax.swing.GroupLayout(kategoriler);
        kategoriler.setLayout(kategorilerLayout);
        kategorilerLayout.setHorizontalGroup(
            kategorilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kategorilerLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(kategorilerLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel15)
                .addGap(362, 362, 362)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(227, 227, 227))
        );
        kategorilerLayout.setVerticalGroup(
            kategorilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kategorilerLayout.createSequentialGroup()
                .addGroup(kategorilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kategorilerLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel14))
                    .addGroup(kategorilerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(kategorilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))))
                .addGap(18, 18, 18)
                .addGroup(kategorilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(341, Short.MAX_VALUE))
        );

        yeniCardLay.add(kategoriler, "card3");

        javax.swing.GroupLayout veriTabaniPanelLayout = new javax.swing.GroupLayout(veriTabaniPanel);
        veriTabaniPanel.setLayout(veriTabaniPanelLayout);
        veriTabaniPanelLayout.setHorizontalGroup(
            veriTabaniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(yeniCardLay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        veriTabaniPanelLayout.setVerticalGroup(
            veriTabaniPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(veriTabaniPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yeniCardLay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardLayout.add(veriTabaniPanel, "card5");

        javax.swing.GroupLayout anaPanelLayout = new javax.swing.GroupLayout(anaPanel);
        anaPanel.setLayout(anaPanelLayout);
        anaPanelLayout.setHorizontalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anaPanelLayout.createSequentialGroup()
                .addComponent(solPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        anaPanelLayout.setVerticalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(solPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String albumAdi = albumAdiTxt.getText();
        int albumID=-5;
        String sarkiAdi = sarkiAdiTxt.getText();
        
        System.out.println(" albumlerin sayisi toplam :  " + albums.get(0).getAlbum_adi() );
        for(int i=0; i<albums.size(); i++)
        {
            if(albums.get(i).getAlbum_adi().equals(albumAdi))
            {
                System.out.println("Bunun idsi = " +albums.get(i).getAlbum_id());
                albumID =albums.get(i).getAlbum_id();
          //      System.out.println("NAASSIKLLLL");
            }
           
        }
        
        
        
        Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="insert into sarkilar(sarki_adi,album_id)  values(?,?)";
            statement = connection.prepareStatement(sql);
          statement.setString(1,sarkiAdi);
         
          statement.setInt(2,albumID);
          
          statement.executeUpdate();
           
            
            System.out.println("Kayıt eklendi");
            
        }
        
        catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
            if(exception.getMessage().equals("Cannot add or update a child row: a foreign key constraint fails "
                    + "(`prolab`.`sarkilar`, CONSTRAINT `fksprouc` FOREIGN KEY (`album_id`) REFERENCES `albumler` (`album_id`) ON DELETE SET NULL ON UPDATE CASCADE)"))
            {
                 JOptionPane panem = new JOptionPane();
            panem.showMessageDialog(null,"BÖYLE BİR ALBÜM YOK"); 
            }
           
            else{
                 JOptionPane pane = new JOptionPane();
            pane.showMessageDialog(null,"AYNI İSİMLİ ŞARKI VAR");
            }
           
           
        }
        finally
        {       try {
            statement.close();
            connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        tabloyuGetir();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void silBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silBtnActionPerformed
        // TODO add your handling code here:
     silmeIslemi("delete from sarkilar  where sarki_id = ? ",sarkiListesi,sarkiTablo);
        tabloyuGetir();

    }//GEN-LAST:event_silBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         cardLayout.removeAll();
        cardLayout.add(albumEkle);
        cardLayout.repaint();
        cardLayout.revalidate();
        albumListesiGetir();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void albumEkleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumEkleBtnActionPerformed
        // TODO add your handling code here:
       int pop=1; int jazz=2; int klasik = 3;
        
        String albumAdi = albmekle.getText();
        String sanatciAdi = sanatciTxt.getText();
        String  tarih = tarihTxt.getText();
        String  tur= turTxt.getText();
        int kategoriID=-5;
        
        
        if(tur.equals("Pop"))
        {
            kategoriID=1;
        }
        else if(tur.equals("Jazz")){
            kategoriID =2;
        }
        else if(tur.equals("Klasik")){
            kategoriID=3;
        }
        
       
        
        
        
        
        
        
        
        
        
          Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="insert into albumler (album_adi,sanatci,tarih,kategori_id)  values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
          statement.setString(1,albumAdi);
         
          statement.setString(2,sanatciAdi);
          statement.setString(3,tarih);
          statement.setInt(4,kategoriID);
          
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
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        albumListesiGetir();
    }//GEN-LAST:event_albumEkleBtnActionPerformed

    private void albumSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumSilActionPerformed
        silmeIslemi("delete from albumler where album_id =?", albumListe, albumTablo);
          albumListesiGetir();
    }//GEN-LAST:event_albumSilActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     cardLayout.removeAll();
        cardLayout.add(kullanicilarPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
        
        kullaniciTablosuGetir();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            String ad,sifre,email;
            boolean premium= Boolean.valueOf(txPre.getText());
            ad= txAd.getText();
            sifre= txSifre.getText();
            email = txEma.getText();
            
          
        
        
        Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql="insert into kullanicilar (kullanici_adi,premium,kullanici_sifre,kullanici_email) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
          statement.setString(1,ad);
          statement.setBoolean(2,premium);
         statement.setString(3,sifre);
         statement.setString(4,email);
         
        
          
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
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

kullaniciTablosuGetir();        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     cardLayout.removeAll();
        cardLayout.add(sarkiEkle);
        cardLayout.repaint();
        cardLayout.revalidate();
         tabloyuGetir();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     
        int tiklama =albumListe.getSelectedRow();
        int sarkininID = Integer.valueOf(albumTablo.getValueAt(tiklama, 0).toString()); // şarkının idsi alınıyor
        int sutun = albumListe.getSelectedColumn();
        String label = albumTablo.getValueAt(tiklama, sutun).toString();
        System.out.println("Lan::: " + label);
        updateLabel.setText(label);
        
        
        System.out.println("Sutun : " + sutun);
        System.out.println("ID'si : " + sarkininID);
        String hangisiUpdate = null;
        String veri = guncelleTxt.getText();
        String sqlVerisi=null;
        int album_ID =-4;
        
        
       
        
        if(sutun==1)
        {
            hangisiUpdate = "album_adi";
            sqlVerisi ="update albumler  set album_adi =?  where album_id =?";
        }
        
        else  if(sutun==2)
        {
            hangisiUpdate = "sanatci";
            sqlVerisi ="update albumler  set sanatci =?  where album_id =?";
        }
         
         else if(sutun==3)
        {
            hangisiUpdate = "tarih";
            sqlVerisi ="update albumler  set tarih =?  where album_id =?";
        }
        else  if(sutun==4)
        {
            sqlVerisi ="update albumler  set kategori_id =?  where album_id =?";
            for(int i=0; i<albums.size(); i++)
                {
                    if(albums.get(i).getAlbum_adi().equals(veri))
                    {
                        album_ID= albums.get(i).getAlbum_id();
                    }
                }
        }
        
        
        Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql=sqlVerisi;
            statement = connection.prepareStatement(sql);
         //statement.setString(1, hangisiUpdate);
             if(sutun==4)
            {
                 statement.setInt(1, album_ID);
                 System.out.println("BURDAYIM");
                  statement.setInt(2, sarkininID);
          
          
          statement.executeUpdate();
            } 
             else
             {
                  statement.setString(1, veri);
                   statement.setInt(2, sarkininID);
          
          
          statement.executeUpdate();
             }
         
        
         
            
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
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        albumListesiGetir();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void albumListeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_albumListeMouseClicked
         int tiklama =albumListe.getSelectedRow();
        int sarkininID = Integer.valueOf(albumTablo.getValueAt(tiklama, 0).toString()); // şarkının idsi alınıyor
        int sutun = albumListe.getSelectedColumn();
        String label = albumTablo.getValueAt(tiklama, sutun).toString();
       
       updateLabel.setText(label);
    }//GEN-LAST:event_albumListeMouseClicked
public void sirala()
{
    int a =sarkiListesi.getSelectedRow();
        int x = Integer.valueOf(sarkiTablo.getValueAt(a, 0).toString()); // şarkının idsi alınıyor
        int c = sarkiListesi.getSelectedColumn();
        String label = sarkiTablo.getValueAt(a, c).toString();
        System.out.println("Lan::: " + label);
        lebel.setText(label);
        int q = Integer.valueOf(sarkiUpdateTxt.getText());
        
        System.out.println("Sutun : " + c);
        System.out.println("ID'si : " + x);
        String b = null;
        String e = sarkiUpdateTxt.getText();
        String t=null;
        t ="update sarkilar  set dinlenme_sayisi =?  where sarki_id =?";
        
          Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql=t;
            statement = connection.prepareStatement(sql);
         //statement.setString(1, hangisiUpdate);
            statement.setInt(1, q);
             statement.setInt(2, x);
        
          
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
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
}
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
      
        int tiklama =sarkiListesi.getSelectedRow();
        int sarkininID = Integer.valueOf(sarkiTablo.getValueAt(tiklama, 0).toString()); // şarkının idsi alınıyor
        int sutun = sarkiListesi.getSelectedColumn();
        String label = sarkiTablo.getValueAt(tiklama, sutun).toString();
        System.out.println("Lan::: " + label);
        lebel.setText(label);
        
        
        System.out.println("Sutun : " + sutun);
        System.out.println("ID'si : " + sarkininID);
        String hangisiUpdate = null;
        String veri = sarkiUpdateTxt.getText();
        String sqlVerisi=null;
        
       
       
        if(sutun==1)
        {
            hangisiUpdate = "album_adi";
            sqlVerisi ="update sarkilar  set sarki_adi =?  where sarki_id =?";
        }
        
        else  if(sutun==2)
        {
           
           
            for(int i=0; i<albums.size(); i++)
            {
                if(albums.get(i).getAlbum_adi().equals(veri))
                {
                    
                }
            }
            
            sqlVerisi ="update sarkilar  set album_id =?  where sarki_id =?";
            JOptionPane  panem = new JOptionPane();
            panem.showMessageDialog(null,"Albüm Değiştiremezsiniz");
        }
         
         else if(sutun==3)
        {
            hangisiUpdate = "tarih";
            sqlVerisi ="update albumler  set sanatci =?  where sarki_id =?";
            JOptionPane pane = new JOptionPane();
            pane.showMessageDialog(null,"Sanatçı verisi sadece albüm tablosundan değiştirilebilir!");
        }
        else  if(sutun==4)
        {
         JOptionPane panex = new JOptionPane();
            panex.showMessageDialog(null,"ŞARKININ TÜRÜ ALBÜM TÜRÜYLE AYNI OLDUĞU İÇİN DEĞİŞTİRİLEMEZ. ALBÜM TABLOSUNA GİDİNİZ");
        }
        
        
        Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql=sqlVerisi;
            statement = connection.prepareStatement(sql);
         //statement.setString(1, hangisiUpdate);
            statement.setString(1, veri);
            statement.setInt(2, sarkininID);
          
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
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
       
        tabloyuGetir();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void sarkiListesiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sarkiListesiMouseMoved
 
    }//GEN-LAST:event_sarkiListesiMouseMoved

    private void sarkiListesiMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sarkiListesiMouseDragged
            
    }//GEN-LAST:event_sarkiListesiMouseDragged

    private void sarkiListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sarkiListesiMouseClicked
         int tiklama =sarkiListesi.getSelectedRow();
        int sarkininID = Integer.valueOf(sarkiTablo.getValueAt(tiklama, 0).toString()); // şarkının idsi alınıyor
        int sutun = sarkiListesi.getSelectedColumn();
        String label = sarkiTablo.getValueAt(tiklama, sutun).toString();
        System.out.println("Lan::: " + label);
        lebel.setText(label);
    }//GEN-LAST:event_sarkiListesiMouseClicked

    private void kullaniciTabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullaniciTabloMouseClicked
        int tiklama =kullaniciTablo.getSelectedRow();
        int sarkininID = Integer.valueOf(kullaniciTablo.getValueAt(tiklama, 0).toString()); // şarkının idsi alınıyor
        int sutun = kullaniciTablo.getSelectedColumn();
        String label = kullaniciTablo.getValueAt(tiklama, sutun).toString();
       
       lbl.setText(label);
    }//GEN-LAST:event_kullaniciTabloMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         int tiklama =kullaniciTablo.getSelectedRow();
        int sarkininID = Integer.valueOf(kullaniciTablo.getValueAt(tiklama, 0).toString()); // şarkının idsi alınıyor
        int sutun = kullaniciTablo.getSelectedColumn();
        String label = kullaniciTablo.getValueAt(tiklama, sutun).toString();
       
       lbl.setText(label);
        
        
        System.out.println("Sutun : " + sutun);
        System.out.println("ID'si : " + sarkininID);
        String hangisiUpdate = null;
        String veri = textt.getText();
        String sqlVerisi=null;
        
       
        
        if(sutun==1)
        {
            hangisiUpdate = "album_adi";
            sqlVerisi ="update kullanicilar  set kullanici_adi =?  where kullanici_id =?";
        }
        
        else  if(sutun==2)
        {
            hangisiUpdate = "sanatci";
      
             sqlVerisi ="update kullanicilar  set kullanici_sifre =?  where kullanici_id =?";
        }
         
         else if(sutun==3)
        {
            hangisiUpdate = "tarih";
                  sqlVerisi ="update kullanicilar  set premium =?  where kullanici_id =?";
        }
        else  if(sutun==4)
        {
            hangisiUpdate = "album_adi";
            sqlVerisi ="update kullanicilar  set kullanici_email =?  where kullanici_id =?";
        }
        
        
        Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql=sqlVerisi;
            statement = connection.prepareStatement(sql);
         //statement.setString(1, hangisiUpdate);
            statement.setString(1, veri);
            statement.setInt(2, sarkininID);
          
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
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        kullaniciTablosuGetir(); 
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        silmeIslemi("delete from kullanicilar where kullanici_id =?", kullaniciTablo, kullaniciModel);
        kullaniciTablosuGetir();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        cardLayout.removeAll();
        cardLayout.add(veriTabaniPanel);
        cardLayout.repaint();
        cardLayout.revalidate();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void veritabanıSarkiListeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_veritabanıSarkiListeMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_veritabanıSarkiListeMouseDragged

    private void veritabanıSarkiListeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_veritabanıSarkiListeMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_veritabanıSarkiListeMouseMoved

    private void veritabanıSarkiListeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_veritabanıSarkiListeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_veritabanıSarkiListeMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        yeniCardLay.removeAll();
        yeniCardLay.add(vtSarkiPanel);
        yeniCardLay.repaint();
        yeniCardLay.revalidate();
        veriTabaniSarkilar();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
 yeniCardLay.removeAll();
        yeniCardLay.add(vtAlbumler);
        yeniCardLay.repaint();
        yeniCardLay.revalidate();
        verTabaniAlbumler();

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
     yeniCardLay.removeAll();
        yeniCardLay.add(kategoriler);
        yeniCardLay.repaint();
        yeniCardLay.revalidate();
        veriTabaniCalma();
        veriTabaniTakip();
        veriTabaniKategoriler();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       yeniCardLay.removeAll();
        yeniCardLay.add(kullanicilar);
        yeniCardLay.repaint();
        yeniCardLay.revalidate();
        veriTabaniKullanicilar();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        sirala();
        tabloyuGetir();
    }//GEN-LAST:event_jButton15ActionPerformed

    public void silmeIslemi(String islem,JTable table, DefaultTableModel model)
    {
         
          int sayac = table.getSelectedRow(); 
          int sutun = table.getSelectedColumn();
          int updateVerisi = table.getSelectedRow();
          String s = model.getValueAt(updateVerisi, table.getSelectedColumn()).toString();
//          int nerde = Integer.valueOf(model.getValueAt(sayac, 1).toString());
         System.out.println("Hangi Sütun : " +sutun);
          
      int  veri =Integer.valueOf(model.getValueAt(sayac, 0).toString());
        System.out.println("Verimiz :Ç budur : " + s);
        
        Connection connection=null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        
        
        
        try{
            DbHelper helper = new DbHelper();
           
            connection =  helper.getConnection();
            String sql=islem;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, veri);  // 1 ilk soru işareti demek !
            
          
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
                 Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField albmekle;
    private javax.swing.JTextField albumAdiTxt;
    private javax.swing.JPanel albumEkle;
    private javax.swing.JButton albumEkleBtn;
    private javax.swing.JTable albumListe;
    private javax.swing.JButton albumSil;
    private javax.swing.JPanel anaPanel;
    private javax.swing.JPanel cardLayout;
    private javax.swing.JTextField guncelleTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel kategoriler;
    private javax.swing.JTable kullaniciTablo;
    private javax.swing.JPanel kullanicilar;
    private javax.swing.JPanel kullanicilarPanel;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lebel;
    private javax.swing.JTextField sanatciTxt;
    private javax.swing.JTextField sarkiAdiTxt;
    private javax.swing.JPanel sarkiEkle;
    private javax.swing.JTable sarkiListesi;
    private javax.swing.JTextField sarkiUpdateTxt;
    private javax.swing.JButton silBtn;
    private javax.swing.JPanel solPanel;
    private javax.swing.JTextField tarihTxt;
    private javax.swing.JTextField textt;
    private javax.swing.JTextField turTxt;
    private javax.swing.JTextField txAd;
    private javax.swing.JTextField txEma;
    private javax.swing.JTextField txPre;
    private javax.swing.JTextField txSifre;
    private javax.swing.JLabel updateLabel;
    private javax.swing.JTable veriTabaniAlbumListed;
    private javax.swing.JTable veriTabaniCalmaListe;
    private javax.swing.JTable veriTabaniKategorilerListe;
    private javax.swing.JTable veriTabaniKullaniciListe;
    private javax.swing.JPanel veriTabaniPanel;
    private javax.swing.JTable veriTabaniTakipListe;
    private javax.swing.JTable veritabanıSarkiListe;
    private javax.swing.JPanel vtAlbumler;
    private javax.swing.JPanel vtSarkiPanel;
    private javax.swing.JPanel yeniCardLay;
    // End of variables declaration//GEN-END:variables
}
