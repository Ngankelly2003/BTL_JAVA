package view;

import exception.MessageDialog;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.*;
import services.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ChangePassword extends javax.swing.JFrame {
    
    private Customer loggedInStudent;
    private AccountService accountService;
    
    public ChangePassword(Customer student) {
        initComponents();
        setLocationRelativeTo(null);
        this.loggedInStudent = student;
        accountService = new AccountService();
    }
    
    public ChangePassword() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        oldPasswordField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        newPasswordField = new javax.swing.JPasswordField();
        reEnterPasswordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imagesLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mật khẩu cũ");

        oldPasswordField.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mật khẩu");

        newPasswordField.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        reEnterPasswordField.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nhập lại mật khẩu");

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        imagesLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(imagesLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(imagesLogin)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CancelButton.setBackground(new java.awt.Color(153, 0, 0));
        CancelButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CancelButton.setForeground(new java.awt.Color(255, 255, 255));
        CancelButton.setText("Hủy");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(0, 153, 0));
        saveButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Lưu thay đổi");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(41)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jLabel4)
        						.addComponent(jLabel2)
        						.addComponent(jLabel3)
        						.addComponent(newPasswordField, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        						.addComponent(oldPasswordField)
        						.addComponent(reEnterPasswordField))
        					.addContainerGap(45, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(saveButton, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        					.addGap(47)
        					.addComponent(CancelButton, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
        					.addGap(43))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(32)
        			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(30)
        			.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(reEnterPasswordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        				.addComponent(CancelButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addGap(39))
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy cập nhật", "Thông báo", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            dispose();
            try {
                CustomerProfile personalAccountInformationScreen = new CustomerProfile(loggedInStudent);
                personalAccountInformationScreen.setLocationRelativeTo(null);
                personalAccountInformationScreen.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(UpdateCustomerProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            Account account = accountService.getAccountById(loggedInStudent.getAccountId());
            String oldPassword = accountService.getAccountById(loggedInStudent.getAccountId()).getPassword();
            String oldPasswordField = this.oldPasswordField.getText().trim();
            String newPasswordField = this.newPasswordField.getText().trim();
            String reNewPasswordField = this.reEnterPasswordField.getText().trim();
            
            if(oldPasswordField.isEmpty() || newPasswordField.isEmpty() || reNewPasswordField.isEmpty()){
                MessageDialog.showErrorDialog(this, "Vui lòng nhập đủ dữ liệu", "Thông báo");
                return;
            }
            
            if(!oldPassword.equalsIgnoreCase(oldPassword)){
                MessageDialog.showErrorDialog(this, "Mật khẩu không đúng", "Thông báo");
                return;
            }
            
            if(!newPasswordField.equalsIgnoreCase(reNewPasswordField)){
                MessageDialog.showErrorDialog(this, "Nhập lại mật khẩu không đúng", "Thông báo");
                return;
            }
            
            account.setPassword(newPasswordField);
            accountService.updateAccount(account, loggedInStudent.getId());
            MessageDialog.showInfoDialog(this, "Đổi mật khẩu thành công", "Thông báo");
            dispose();
            CustomerProfile studentProfile = new CustomerProfile(loggedInStudent);
            studentProfile.setLocationRelativeTo(null);
            studentProfile.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel imagesLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JTextField oldPasswordField;
    private javax.swing.JPasswordField reEnterPasswordField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
