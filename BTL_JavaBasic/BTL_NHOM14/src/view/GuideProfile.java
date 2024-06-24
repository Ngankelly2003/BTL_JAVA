package view;

import exception.MessageDialog;
import static exception.Validator.isDate;
import static exception.Validator.isNumeric;
import static exception.Validator.isValidEmail;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.*;
import view.*;
import services.*;

public class GuideProfile extends javax.swing.JFrame {

    private Guide loggedInGuide;
    private String selectedImagePath = "";
    private static final String imageFolderPath = "src/images/";
    private AccountService accountService;
    private GuideService GuideService;
    
    public GuideProfile(Guide Guide) throws Exception{
        try {
            this.loggedInGuide = Guide;
            initComponents();
            accountService = new AccountService();
            GuideService = new GuideService();
            loadInformationGuide();
        } catch (Exception ex) {
            Logger.getLogger(GuideProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public GuideProfile() {
        initComponents();
        accountService = new AccountService();
        GuideService = new GuideService();
        setLocationRelativeTo(null);
    }
    
    private void loadInformationGuide() throws Exception{
        if(loggedInGuide != null){
            GuideNameTitle.setText(loggedInGuide.getLastName().toUpperCase() + " " + loggedInGuide.getFirstName().toUpperCase());
            GuideIDField.setText(loggedInGuide.getCode());
            nameGuideField.setText(loggedInGuide.getLastName() + " " + loggedInGuide.getFirstName());
            birthdayGuideField.setText(loggedInGuide.getBirthDate());
            emailGuideField.setText(loggedInGuide.getEmail());
            addressGuideField.setText(loggedInGuide.getAddress());
            phoneNumberGuideField.setText(loggedInGuide.getPhoneNumber());
            ImageIcon imageIcon = new ImageIcon(loggedInGuide.getImagePath());
            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
            imageLabel.setIcon(imageIcon);
            
            List<Account> data_accounts = accountService.getAllAccounts();
            Account selectAccount = null;
            for (Account item : data_accounts) {
                if (item.getId() == loggedInGuide.getAccountId()) {
                    selectAccount = item;
                    break;
                }
            }
            GuideUsernameInput.setText(selectAccount.getUsername());
            GuidePasswordInput.setText(selectAccount.getPassword());
            disableInput();
        }
    }
    
    private void disableInput() {
        GuideAvataButton.setEnabled(false);
        GuideIDField.setEnabled(false);
        nameGuideField.setEnabled(false);
        birthdayGuideField.setEnabled(false);
        phoneNumberGuideField.setEnabled(false);
        addressGuideField.setEnabled(false);
        emailGuideField.setEnabled(false);
        GuideUsernameInput.setEnabled(false);
        GuidePasswordInput.setEnabled(false);
        
        GuideIDField.setDisabledTextColor(Color.BLACK);
        nameGuideField.setDisabledTextColor(Color.BLACK);
        birthdayGuideField.setDisabledTextColor(Color.BLACK);
        phoneNumberGuideField.setDisabledTextColor(Color.BLACK);
        addressGuideField.setDisabledTextColor(Color.BLACK);
        emailGuideField.setDisabledTextColor(Color.BLACK);
        GuideUsernameInput.setDisabledTextColor(Color.BLACK);
        GuidePasswordInput.setDisabledTextColor(Color.BLACK);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        GuideNameTitle = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        backpage = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        GuideIDField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        birthdayGuideField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        addressGuideField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        phoneNumberGuideField = new javax.swing.JTextField();
        emailGuideField = new javax.swing.JTextField();
        nameGuideField = new javax.swing.JTextField();
        GuideAvataButton = new javax.swing.JButton();
        changeInformationButton = new javax.swing.JButton();
        saveChangeInfomation = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        changeAccoutButton = new javax.swing.JButton();
        saveChangeAccount = new javax.swing.JButton();
        GuideUsernameInput = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        GuidePasswordInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        GuideNameTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GuideNameTitle.setForeground(new java.awt.Color(255, 255, 255));
        GuideNameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GuideNameTitle.setText("Nguyễn Thị Kim Ngân");
        GuideNameTitle.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hướng dẫn viên");

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        backpage.setBackground(new java.awt.Color(204, 51, 0));
        backpage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backpage.setForeground(new java.awt.Color(255, 255, 255));
        backpage.setText("Quay lại trang trước");
        backpage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backpageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(GuideNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(backpage)
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GuideNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backpage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mã Hướng dẫn viên:");

        GuideIDField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ngày sinh:");

        birthdayGuideField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Địa chỉ:");

        addressGuideField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tên Hướng dẫn viên:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Email:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Số điện thoại:");

        phoneNumberGuideField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        emailGuideField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        nameGuideField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        GuideAvataButton.setBackground(new java.awt.Color(0, 153, 153));
        GuideAvataButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        GuideAvataButton.setForeground(new java.awt.Color(255, 255, 255));
        GuideAvataButton.setText("Tải ảnh lên");
        GuideAvataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuideAvataButtonActionPerformed(evt);
            }
        });

        changeInformationButton.setBackground(new java.awt.Color(0, 204, 255));
        changeInformationButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        changeInformationButton.setForeground(new java.awt.Color(255, 255, 255));
        changeInformationButton.setText("Thay đổi thông tin");
        changeInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInformationButtonActionPerformed(evt);
            }
        });

        saveChangeInfomation.setBackground(new java.awt.Color(0, 153, 51));
        saveChangeInfomation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveChangeInfomation.setForeground(new java.awt.Color(255, 255, 255));
        saveChangeInfomation.setText("Lưu thay đổi");
        saveChangeInfomation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangeInfomationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(GuideIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(birthdayGuideField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressGuideField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(GuideAvataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailGuideField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(nameGuideField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addComponent(phoneNumberGuideField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(changeInformationButton)
                        .addGap(46, 46, 46)
                        .addComponent(saveChangeInfomation, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuideIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameGuideField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdayGuideField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailGuideField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressGuideField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberGuideField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeInformationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GuideAvataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveChangeInfomation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        changeAccoutButton.setBackground(new java.awt.Color(0, 204, 255));
        changeAccoutButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        changeAccoutButton.setForeground(new java.awt.Color(255, 255, 255));
        changeAccoutButton.setText("Thay đổi thông tin");
        changeAccoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeAccoutButtonActionPerformed(evt);
            }
        });

        saveChangeAccount.setBackground(new java.awt.Color(0, 153, 51));
        saveChangeAccount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveChangeAccount.setForeground(new java.awt.Color(255, 255, 255));
        saveChangeAccount.setText("Lưu thay đổi");
        saveChangeAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangeAccountActionPerformed(evt);
            }
        });

        GuideUsernameInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Tên tài khoản:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Mật khẩu:");

        GuidePasswordInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GuidePasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GuideUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(changeAccoutButton)
                .addGap(75, 75, 75)
                .addComponent(saveChangeAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GuideUsernameInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuidePasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeAccoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveChangeAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TÀI KHOẢN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("THÔNG TIN HƯỚNG DẪN VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backpageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backpageActionPerformed
        dispose();
        GuideAndCustomerHome screen = new GuideAndCustomerHome(loggedInGuide);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
    }//GEN-LAST:event_backpageActionPerformed

    private void GuideAvataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuideAvataButtonActionPerformed
        JFileChooser browseImageFile = new JFileChooser();

        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpeg", "jpg", "jfif", "svg");
        browseImageFile.addChoosableFileFilter(fnef);

        int showOpenDialogue = browseImageFile.showOpenDialog(null);

        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();

            // Tạo đường dẫn mới cho tập tin hình ảnh đến thư mục đích
            Path currentDirectory = Paths.get("").toAbsolutePath();
            Path destinationDirectory = currentDirectory.resolve(Paths.get("src", "images"));
            Path destinationPath = destinationDirectory.resolve(selectedImageFile.getName());

            try {
                // Sao chép tập tin vào thư mục đích
                Files.copy(selectedImageFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "Tải tệp thành công");

                // Lấy đường dẫn tương đối của tập tin đã lưu
                Path relativePath = currentDirectory.relativize(destinationPath);
                selectedImagePath = relativePath.toString();

                // Hiển thị ảnh
                ImageIcon imageIcon = new ImageIcon(selectedImageFile.toURI().toURL()); // Chuyển đổi File thành URL
                Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi trong quá trình lưu tệp");
            }
        }
    }//GEN-LAST:event_GuideAvataButtonActionPerformed

    private void changeInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeInformationButtonActionPerformed
        nameGuideField.setEnabled(true);
        birthdayGuideField.setEnabled(true);
        phoneNumberGuideField.setEnabled(true);
        addressGuideField.setEnabled(true);
        emailGuideField.setEnabled(true);
        GuideAvataButton.setEnabled(true);
    }//GEN-LAST:event_changeInformationButtonActionPerformed

    private void saveChangeInfomationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangeInfomationActionPerformed
        try {
            String GuideName = this.nameGuideField.getText().trim();
            String GuideAddress = this.addressGuideField.getText().trim();
            String GuidePhoneNumber = this.phoneNumberGuideField.getText().trim();
            String GuideBirthday = this.birthdayGuideField.getText().trim();
            String GuideEmail = this.emailGuideField.getText().trim();
            
            String imagePath = loggedInGuide.getImagePath();

            if (!selectedImagePath.equals(imagePath)) {
                if (!selectedImagePath.trim().equals("")) {
                    loggedInGuide.setImagePath(selectedImagePath);
                }
            }
            
            if (GuideName.equals("")) {
                MessageDialog.showInfoDialog(jPanel1, "Bạn chưa nhập họ tên Hướng dẫn viên", "Thông báo");
                return;
            }

            if (GuideAddress.equals("")) {
                MessageDialog.showInfoDialog(jPanel1, "Bạn chưa nhập địa chỉ", "Thông báo");
                return;
            }
            if (GuidePhoneNumber.equals("")) {
                MessageDialog.showInfoDialog(jPanel1, "Bạn chưa nhập số điện thoại", "Thông báo");
                return;
            }
            if (!isNumeric(GuidePhoneNumber)) {
                MessageDialog.showInfoDialog(jPanel1, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (GuideBirthday.equals("")) {
                MessageDialog.showInfoDialog(jPanel1, "Bạn chưa nhập ngày sinh", "Thông báo");
                return;
            }

            if (!isDate(GuideBirthday)) {
                MessageDialog.showInfoDialog(jPanel1, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            if (GuideEmail.equals("")) {
                MessageDialog.showInfoDialog(jPanel1, "Bạn chưa nhập email", "Thông báo");
                return;
            }
            if (!isValidEmail(GuideEmail)) {
                MessageDialog.showInfoDialog(jPanel1, "Email không đúng định dạng", "Thông báo");
                return;
            }
            
            loggedInGuide.setFirstName(GuideService.FirstName(GuideName));
            loggedInGuide.setLastName(GuideService.LastName(GuideName));
            loggedInGuide.setPhoneNumber(GuidePhoneNumber);
            loggedInGuide.setBirthDate(GuideBirthday);
            loggedInGuide.setEmail(GuideEmail);
            loggedInGuide.setAddress(GuideAddress);
          
            GuideService.updateGuide(loggedInGuide, loggedInGuide.getId());
            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            loadInformationGuide();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveChangeInfomationActionPerformed

    private void changeAccoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeAccoutButtonActionPerformed
        GuidePasswordInput.setEnabled(true);
    }//GEN-LAST:event_changeAccoutButtonActionPerformed

    private void saveChangeAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangeAccountActionPerformed
        try {
            String password = GuidePasswordInput.getText().trim();
            if(password.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mật khẩu", "Thông báo");
                return;
            }
            Account account = accountService.getAccountById(loggedInGuide.getId());
            account.setPassword(password);
            accountService.updateAccount(account, loggedInGuide.getId());
            MessageDialog.showInfoDialog(this, "Cập nhật thành công", "Thông báo");
            loadInformationGuide();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_saveChangeAccountActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuideProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressGuideField;
    private javax.swing.JButton backpage;
    private javax.swing.JTextField birthdayGuideField;
    private javax.swing.JButton changeAccoutButton;
    private javax.swing.JButton changeInformationButton;
    private javax.swing.JTextField emailGuideField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nameGuideField;
    private javax.swing.JTextField phoneNumberGuideField;
    private javax.swing.JButton saveChangeAccount;
    private javax.swing.JButton saveChangeInfomation;
    private javax.swing.JButton GuideAvataButton;
    private javax.swing.JTextField GuideIDField;
    private javax.swing.JLabel GuideNameTitle;
    private javax.swing.JTextField GuidePasswordInput;
    private javax.swing.JTextField GuideUsernameInput;
    // End of variables declaration//GEN-END:variables
}
