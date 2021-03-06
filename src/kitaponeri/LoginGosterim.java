package kitaponeri;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class LoginGosterim extends javax.swing.JFrame {
    
    static String username;
    String[] enYeniIyiPopuler = new String[20];
    static String[] books = new String[30];
    static ImageIcon icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8,icon9,icon10;
    static boolean ck1,ck2,ck3,ck4,ck5,ck6,ck7,ck8,ck9,ck10;
    static int puan = 0;
    static int oy=0;
    
    
    public void tamKayit(String oylananISBN) throws ClassNotFoundException, SQLException{
        Baglanti bg = new Baglanti();
        int UserID = bg.selectUserID(username);
            bg.update("INSERT INTO bx_book_ratings (User_ID, ISBN, Book_Rating)\n" +
            "VALUES (" + UserID+ ", '" + oylananISBN + "'," + oy + ");");
        
    }
    
    public static void resimAtama(String sayfa) throws ClassNotFoundException, SQLException, MalformedURLException, IOException{
        Baglanti bg = new Baglanti();
        books = bg.selectPhoto("select * from bx_books", Integer.parseInt(sayfa));
        
        icon1 = (new ImageIcon(ImageIO.read(new URL(books[0]))));
        icon2 = (new ImageIcon(ImageIO.read(new URL(books[1]))));
        icon3 = (new ImageIcon(ImageIO.read(new URL(books[2]))));
        icon4 = (new ImageIcon(ImageIO.read(new URL(books[3]))));
        icon5 = (new ImageIcon(ImageIO.read(new URL(books[4]))));
        icon6 = (new ImageIcon(ImageIO.read(new URL(books[5]))));
        icon7 = (new ImageIcon(ImageIO.read(new URL(books[6]))));
        icon8 = (new ImageIcon(ImageIO.read(new URL(books[7]))));
        icon9 = (new ImageIcon(ImageIO.read(new URL(books[8]))));
        icon10 = (new ImageIcon(ImageIO.read(new URL(books[9]))));
        
    }
    
    
    public LoginGosterim(String username) {
        
        initComponents();
        btnYonetim.setVisible(false);
        try {
            this.username = username;
            resimAtama("1");
            ph1.setIcon(icon1); ph2.setIcon(icon2); ph3.setIcon(icon3); ph4.setIcon(icon4);
            ph5.setIcon(icon5); ph6.setIcon(icon6); ph7.setIcon(icon7); ph8.setIcon(icon8);
            ph9.setIcon(icon9); ph10.setIcon(icon10);
            ph1.setText(books[10]); ph2.setText(books[11]); ph3.setText(books[12]);
            ph4.setText(books[13]); ph5.setText(books[14]); ph6.setText(books[15]);
            ph7.setText(books[16]); ph8.setText(books[17]); ph9.setText(books[18]);
            ph10.setText(books[19]);
            ck1=false;ck2=false;ck3=false;ck4=false;ck5=false;ck6=false;ck7=false;ck8=false;ck9=false;ck10=false;
            
            } 
            catch (ClassNotFoundException ex) {Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);}
            catch (SQLException ex) {Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);}
            catch (IOException ex) {Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ph1 = new javax.swing.JLabel();
        ph2 = new javax.swing.JLabel();
        ph4 = new javax.swing.JLabel();
        ph3 = new javax.swing.JLabel();
        ph7 = new javax.swing.JLabel();
        ph9 = new javax.swing.JLabel();
        ph8 = new javax.swing.JLabel();
        ph6 = new javax.swing.JLabel();
        ph5 = new javax.swing.JLabel();
        ph10 = new javax.swing.JLabel();
        spinner = new javax.swing.JSpinner();
        btnSayfaGit = new javax.swing.JButton();
        etSayfa = new javax.swing.JTextField();
        btnPuanla = new javax.swing.JButton();
        btnOku = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnYonetim = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        btnEnIyi = new javax.swing.JMenuItem();
        btnEnPopuler = new javax.swing.JMenuItem();
        btnEnYeni = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ph1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph1.setIcon(icon1);
        ph1.setText(books[10]);
        ph1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ph1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ph1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ph1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ph1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ph1MouseClicked(evt);
            }
        });

        ph2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph2.setIcon(icon2);
        ph2.setText(books[11]);
        ph2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ph2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ph2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ph2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ph2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ph2MouseClicked(evt);
            }
        });

        ph4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph4.setIcon(icon4);
        ph4.setText(books[13]);
        ph4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ph4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ph4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ph4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ph4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ph4MouseClicked(evt);
            }
        });

        ph3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph3.setIcon(icon3);
        ph3.setText(books[12]);
        ph3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ph3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ph3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ph3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ph3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ph3MouseClicked(evt);
            }
        });

        ph7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph7.setIcon(icon7);
        ph7.setText(books[16]);
        ph7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ph7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ph7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ph7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ph7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ph7MouseClicked(evt);
            }
        });

        ph9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph9.setIcon(icon9);
        ph9.setText(books[18]);
        ph9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ph9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ph9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ph9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ph9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ph9MouseClicked(evt);
            }
        });

        ph8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph8.setIcon(icon8);
        ph8.setText(books[17]);
        ph8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ph8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ph8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ph8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ph8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ph8MouseClicked(evt);
            }
        });

        ph6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph6.setIcon(icon6);
        ph6.setText(books[15]);
        ph6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ph6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ph6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ph6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ph6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ph6MouseClicked(evt);
            }
        });

        ph5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph5.setIcon(icon5);
        ph5.setText(books[14]);
        ph5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ph5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ph5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ph5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ph5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ph5MouseClicked(evt);
            }
        });

        ph10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ph10.setIcon(icon10);
        ph10.setText(books[19]);
        ph10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ph10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ph10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ph10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ph10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ph10MouseClicked(evt);
            }
        });

        spinner.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        spinner.setBorder(null);
        spinner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSayfaGit.setText("Sayfaya Git");
        btnSayfaGit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSayfaGitActionPerformed(evt);
            }
        });

        etSayfa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        etSayfa.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnPuanla.setText("Puanla");
        btnPuanla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuanlaActionPerformed(evt);
            }
        });

        btnOku.setText("OKU");
        btnOku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkuActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnYonetim.setText("Yonetim Paneli");
        btnYonetim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnYonetim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYonetimActionPerformed(evt);
            }
        });
        jMenu1.add(btnYonetim);

        jMenuItem4.setText("Onerilen Kitaplar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        btnEnIyi.setText("En Iyi Kitaplar");
        btnEnIyi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnIyi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnIyiActionPerformed(evt);
            }
        });
        jMenu1.add(btnEnIyi);

        btnEnPopuler.setText("En Populer Kitaplar");
        btnEnPopuler.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnPopuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnPopulerActionPerformed(evt);
            }
        });
        jMenu1.add(btnEnPopuler);

        btnEnYeni.setText("En Yeni Kitaplar");
        btnEnYeni.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnYeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnYeniActionPerformed(evt);
            }
        });
        jMenu1.add(btnEnYeni);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPuanla, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(btnOku, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etSayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSayfaGit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ph1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ph2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ph3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ph4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(ph6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ph7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ph8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ph9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ph10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ph5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ph4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ph3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ph2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ph1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ph7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ph8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ph6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ph9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ph5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ph10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPuanla, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOku, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etSayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSayfaGit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ph9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph9MouseClicked
        if(ck9 == false){
            ck9 = true; ph9.resize(120, 210);
            ck2=ck3=ck4=ck5=ck6=ck7=ck8=ck1=ck10=false;
            ph2.resize(130,220); ph3.resize(130,220); ph4.resize(130,220); ph5.resize(130,220); ph6.resize(130,220);
            ph7.resize(130,220); ph8.resize(130,220); ph1.resize(130,220); ph10.resize(130,220);
        }else{
            ck9 = false;
            ph9.resize(130, 220);
        }
    }//GEN-LAST:event_ph9MouseClicked

    private void btnSayfaGitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSayfaGitActionPerformed
        try {   
            resimAtama(etSayfa.getText());
            ph1.setIcon(icon1); ph2.setIcon(icon2); ph3.setIcon(icon3); ph4.setIcon(icon4);
            ph5.setIcon(icon5); ph6.setIcon(icon6); ph7.setIcon(icon7); ph8.setIcon(icon8);
            ph9.setIcon(icon9); ph10.setIcon(icon10);
            ph1.setText(books[10]); ph2.setText(books[11]); ph3.setText(books[12]);
            ph4.setText(books[13]); ph5.setText(books[14]); ph6.setText(books[15]);
            ph7.setText(books[16]); ph8.setText(books[17]); ph9.setText(books[18]);
            ph10.setText(books[19]);
            ck2=ck3=ck4=ck5=ck6=ck7=ck8=ck9=ck10=false;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSayfaGitActionPerformed

    private void ph1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph1MouseClicked
        if(ck1 == false){
            ck1 = true; ph1.resize(120, 210);
            ck2=ck3=ck4=ck5=ck6=ck7=ck8=ck9=ck10=false;
            ph2.resize(130,220); ph3.resize(130,220); ph4.resize(130,220); ph5.resize(130,220); ph6.resize(130,220);
            ph7.resize(130,220); ph8.resize(130,220); ph9.resize(130,220); ph10.resize(130,220);
        }else{
            ck1 = false;
            ph1.resize(130, 220);
        }
    }//GEN-LAST:event_ph1MouseClicked

    private void ph2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph2MouseClicked
        if(ck2 == false){
            ck2 = true; ph2.resize(120, 210);
            ck1=ck3=ck4=ck5=ck6=ck7=ck8=ck9=ck10=false;
            ph1.resize(130,220); ph3.resize(130,220); ph4.resize(130,220); ph5.resize(130,220); ph6.resize(130,220);
            ph7.resize(130,220); ph8.resize(130,220); ph9.resize(130,220); ph10.resize(130,220);
        }else{
            ck2 = false;
            ph2.resize(130, 220);
        }
    }//GEN-LAST:event_ph2MouseClicked

    private void ph3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph3MouseClicked
        if(ck3 == false){
            ck3 = true; ph3.resize(120, 210);
            ck2=ck1=ck4=ck5=ck6=ck7=ck8=ck9=ck10=false;
            ph2.resize(130,220); ph1.resize(130,220); ph4.resize(130,220); ph5.resize(130,220); ph6.resize(130,220);
            ph7.resize(130,220); ph8.resize(130,220); ph9.resize(130,220); ph10.resize(130,220);
        }else{
            ck3 = false;
            ph3.resize(130, 220);
        }
    }//GEN-LAST:event_ph3MouseClicked

    private void ph4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph4MouseClicked
        if(ck4 == false){
            ck4 = true; ph4.resize(120, 210);
            ck2=ck3=ck1=ck5=ck6=ck7=ck8=ck9=ck10=false;
            ph2.resize(130,220); ph3.resize(130,220); ph1.resize(130,220); ph5.resize(130,220); ph6.resize(130,220);
            ph7.resize(130,220); ph8.resize(130,220); ph9.resize(130,220); ph10.resize(130,220);
        }else{
            ck4 = false;
            ph4.resize(130, 220);
        }
    }//GEN-LAST:event_ph4MouseClicked

    private void ph5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph5MouseClicked
        if(ck5 == false){
            ck5 = true; ph5.resize(120, 210);
            ck2=ck3=ck4=ck1=ck6=ck7=ck8=ck9=ck10=false;
            ph2.resize(130,220); ph3.resize(130,220); ph4.resize(130,220); ph1.resize(130,220); ph6.resize(130,220);
            ph7.resize(130,220); ph8.resize(130,220); ph9.resize(130,220); ph10.resize(130,220);
        }else{
            ck5 = false;
            ph5.resize(130, 220);
        }
    }//GEN-LAST:event_ph5MouseClicked

    private void ph6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph6MouseClicked
        if(ck6 == false){
            ck6 = true; ph6.resize(120, 210);
            ck2=ck3=ck4=ck5=ck1=ck7=ck8=ck9=ck10=false;
            ph2.resize(130,220); ph3.resize(130,220); ph4.resize(130,220); ph5.resize(130,220); ph1.resize(130,220);
            ph7.resize(130,220); ph8.resize(130,220); ph9.resize(130,220); ph10.resize(130,220);
        }else{
            ck6 = false;
            ph6.resize(130, 220);
        }
    }//GEN-LAST:event_ph6MouseClicked

    private void ph7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph7MouseClicked
        if(ck7 == false){
            ck7 = true; ph7.resize(120, 210);
            ck2=ck3=ck4=ck5=ck6=ck1=ck8=ck9=ck10=false;
            ph2.resize(130,220); ph3.resize(130,220); ph4.resize(130,220); ph5.resize(130,220); ph6.resize(130,220);
            ph1.resize(130,220); ph8.resize(130,220); ph9.resize(130,220); ph10.resize(130,220);
        }else{
            ck7 = false;
            ph7.resize(130, 220);
        }
    }//GEN-LAST:event_ph7MouseClicked

    private void ph8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph8MouseClicked
        if(ck8 == false){
            ck8 = true; ph8.resize(120, 210);
            ck2=ck3=ck4=ck5=ck6=ck7=ck1=ck9=ck10=false;
            ph2.resize(130,220); ph3.resize(130,220); ph4.resize(130,220); ph5.resize(130,220); ph6.resize(130,220);
            ph7.resize(130,220); ph1.resize(130,220); ph9.resize(130,220); ph10.resize(130,220);
        }else{
            ck8 = false;
            ph8.resize(130, 220);
        }
    }//GEN-LAST:event_ph8MouseClicked

    private void ph10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph10MouseClicked
        if(ck10 == false){
            ck10 = true; ph10.resize(120, 210);
            ck2=ck3=ck4=ck5=ck6=ck7=ck8=ck9=ck1=false;
            ph2.resize(130,220); ph3.resize(130,220); ph4.resize(130,220); ph5.resize(130,220); ph6.resize(130,220);
            ph7.resize(130,220); ph8.resize(130,220); ph9.resize(130,220); ph1.resize(130,220);
        }else{
            ck10 = false;
            ph10.resize(130, 220);
        }
    }//GEN-LAST:event_ph10MouseClicked

    private void btnPuanlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuanlaActionPerformed
        oy = (Integer) spinner.getValue();
        
        if(ck1){
            try {tamKayit(books[20]);} 
                catch (ClassNotFoundException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);} 
                catch (SQLException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);}
        }else if(ck2){
            try {tamKayit(books[21]);} 
                catch (ClassNotFoundException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);} 
                catch (SQLException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);}
        }else if(ck3){
            try {tamKayit(books[22]);} 
                catch (ClassNotFoundException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);} 
                catch (SQLException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);}
        }else if(ck4){
            try {tamKayit(books[23]);} 
                catch (ClassNotFoundException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);} 
                catch (SQLException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);}
        }else if(ck5){
            try {tamKayit(books[24]);} 
                catch (ClassNotFoundException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);} 
                catch (SQLException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);}
        }else if(ck6){
            try {tamKayit(books[25]);} 
                catch (ClassNotFoundException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);} 
                catch (SQLException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);}
        }else if(ck7){
            try {tamKayit(books[26]);} 
                catch (ClassNotFoundException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);} 
                catch (SQLException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);}
        }else if(ck8){
            try {tamKayit(books[27]);} 
                catch (ClassNotFoundException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);} 
                catch (SQLException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);}
        }else if(ck9){
            try {tamKayit(books[28]);} 
                catch (ClassNotFoundException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);} 
                catch (SQLException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);}
        }else if(ck10){
            try {tamKayit(books[29]);} 
                catch (ClassNotFoundException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);} 
                catch (SQLException ex) {Logger.getLogger(SignUpGosterim.class.getName()).log(Level.SEVERE, null, ex);}
        }else{
            System.out.println("Bir Kitap seciniz");
            
        }
    }//GEN-LAST:event_btnPuanlaActionPerformed

    private void btnOkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkuActionPerformed
        boolean hepsi = ck1 || ck2 || ck3 || ck4 || ck5 || ck6 || ck7 || ck8 || ck9 || ck10;
        if (hepsi) {
            String filePath = "E:\\Kitaplar\\dorduncu_sanayi_devrimi.pdf";

            // build a controller
            SwingController controller = new SwingController();

            // Build a SwingViewFactory configured with the controller
            SwingViewBuilder factory = new SwingViewBuilder(controller);

            // Use the factory to build a JPanel that is pre-configured
            //with a complete, active Viewer UI.
            JPanel viewerComponentPanel = factory.buildViewerPanel();

            // add copy keyboard command
            ComponentKeyBinding.install(controller, viewerComponentPanel);

            // add interactive mouse link annotation support via callback
            controller.getDocumentViewController().setAnnotationCallback(
                    new org.icepdf.ri.common.MyAnnotationCallback(
                            controller.getDocumentViewController()));

            // Create a JFrame to display the panel in
            JFrame window = new JFrame("Using the Viewer Component");
            window.getContentPane().add(viewerComponentPanel);
            window.pack();
            window.setVisible(true);

            // Open a PDF document to view
            controller.openDocument(filePath);
        }else{
            System.out.println("Kitap Seciniz!");
        }
    }//GEN-LAST:event_btnOkuActionPerformed

    private void btnYonetimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYonetimActionPerformed
        new AdminSecim().setVisible(true);
    }//GEN-LAST:event_btnYonetimActionPerformed

    private void btnEnIyiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnIyiActionPerformed
        Baglanti bg = new Baglanti();
        try {
            bg.selectEnIyi(enYeniIyiPopuler);
            new IyiPopulerYeni(enYeniIyiPopuler).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnIyiActionPerformed

    private void btnEnYeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnYeniActionPerformed
        Baglanti bg = new Baglanti();
        try {
            bg.selectEnYeni(enYeniIyiPopuler);
            new IyiPopulerYeni(enYeniIyiPopuler ,5).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnYeniActionPerformed

    private void btnEnPopulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnPopulerActionPerformed
        try {
            new Baglanti().selectEnPopuler(enYeniIyiPopuler);
            new IyiPopulerYeni(enYeniIyiPopuler).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnEnPopulerActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            int id = new Baglanti().selectUserID(username);
            new Baglanti().onerilen(id,enYeniIyiPopuler);
            new IyiPopulerYeni(enYeniIyiPopuler).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginGosterim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
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
            java.util.logging.Logger.getLogger(LoginGosterim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGosterim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGosterim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGosterim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGosterim(username).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnEnIyi;
    private javax.swing.JMenuItem btnEnPopuler;
    private javax.swing.JMenuItem btnEnYeni;
    private javax.swing.JButton btnOku;
    private javax.swing.JButton btnPuanla;
    private javax.swing.JButton btnSayfaGit;
    public javax.swing.JMenuItem btnYonetim;
    private static javax.swing.JTextField etSayfa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private static javax.swing.JLabel ph1;
    private static javax.swing.JLabel ph10;
    private static javax.swing.JLabel ph2;
    private static javax.swing.JLabel ph3;
    private static javax.swing.JLabel ph4;
    private static javax.swing.JLabel ph5;
    private static javax.swing.JLabel ph6;
    private static javax.swing.JLabel ph7;
    private static javax.swing.JLabel ph8;
    private static javax.swing.JLabel ph9;
    private static javax.swing.JSpinner spinner;
    // End of variables declaration//GEN-END:variables
}
