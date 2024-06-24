package view;

import exception.MessageDialog;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Account;
import services.AccountService;

public class ManageAccount extends javax.swing.JFrame {

    public ManageAccount(){
        initComponents();
        accountService = new AccountService();
        initializeTable();
        initializeRoleCombobox();
        setLocationRelativeTo(null);
    }
    
    private void loadTableData(){
        try {
            List<Account> data = accountService.getAllAccounts();
            tableModel.setRowCount(0);
            if(data != null){
                for(Account account : data){
                    tableModel.addRow(new Object[]{account.getUsername(),account.getPassword(),account.getRole()});
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
        }
    }
    
    private void initializeTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Tên tài khoản", "Mật khẩu", "Quyền trong hệ thống"});
        accountTable.setModel(tableModel);
        loadTableData();
    }
    
    private void clearAllFields(){
        usernameField.setText("");
        passwordField.setText("");
        roleInput.setSelectedIndex(1);
    }
    
    private void initializeRoleCombobox(){
        roleInput.removeAllItems();
        roleInput.addItem("Quản lí thông thường");
        roleInput.addItem("Tài khoản khách hàng");        
        roleInput.addItem("Tài khoản hướng dẫn viên");

        roleInput.setSelectedIndex(1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        roleInput = new javax.swing.JComboBox<>();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Trở lại trang chủ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("QUẢN LÍ TÀI KHOẢN HỆ THỐNG");

        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accountTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Tên tài khoản:");

        usernameField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Quyền tài khoản:");

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        roleInput.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        btn_add.setBackground(new java.awt.Color(0, 102, 51));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm");
        btn_add.setPreferredSize(new java.awt.Dimension(269, 37));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(0, 153, 153));
        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Sửa");
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_edit.setPreferredSize(new java.awt.Dimension(269, 37));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Xóa");
        btn_delete.setPreferredSize(new java.awt.Dimension(269, 37));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(102, 153, 0));
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Nhập lại");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 993, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameField)
                    .addComponent(passwordField)
                    .addComponent(roleInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 115, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(roleInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel9)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String username = this.usernameField.getText().trim();
            String password = this.passwordField.getText().trim();
            String role = (String) roleInput.getSelectedItem();
            if(username.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên người dùng không được bỏ trống", "Thông báo");
                return;
            }
            if(password.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mật khẩu không được bỏ trống", "Thông báo");
                return;
            }
            if(accountService.isExistedUsername(username)){
                MessageDialog.showInfoDialog(this, "Trùng tên đăng nhập", "Thông báo");
            }else{
                int accountId = accountService.getLastIdFromAccount() + 1;
                Account account = new Account(accountId,username, password, role);
                accountService.addAccount(account);
                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
                loadTableData();
                clearAllFields();
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void accountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTableMouseClicked
        try {
            int index = accountTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn tài khoản", "Thông báo");
            }
            
            String username = (String) accountTable.getValueAt(index, 0);
            String password = (String) accountTable.getValueAt(index, 1);
            String role = (String) accountTable.getValueAt(index, 2);
            
            usernameField.setText(username);
            passwordField.setText(password);
            roleInput.setSelectedItem(role);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_accountTableMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = accountTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn tài khoản", "Thông báo");
            }
            String username = (String) accountTable.getValueAt(index, 0);
            String password = (String) accountTable.getValueAt(index, 1);
            String role = (String) accountTable.getValueAt(index, 2);
            
            int accountId = accountService.getIdByAccount(username, password, role);
            System.out.println("ID: "+accountId);
            
            String usernameText = this.usernameField.getText().trim();
            String passwordText = this.passwordField.getText().trim();
            String roleText = (String) roleInput.getSelectedItem();
            
            if(usernameText.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên người dùng không được bỏ trống", "Thông báo");
                return;
            }
            if(passwordText.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mật khẩu không được bỏ trống", "Thông báo");
                return;
            }
            if(accountService.isExistedUsername(usernameText) && !usernameText.equals(usernameText)){
                MessageDialog.showInfoDialog(this, "Tên tài khoản không tồn tại", "Thông báo");
            }else{
                Account account = accountService.getAccountById(accountId);
                
                account.setUsername(usernameText);
                account.setPassword(passwordText);
                account.setRole(roleText);
                
                accountService.updateAccount(account, accountId);
                MessageDialog.showInfoDialog(this, "Cập nhật thành công", "Thông báo");
                loadTableData();
                clearAllFields();
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = accountTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn tài khoản", "Thông báo");
            }
            String username = (String) accountTable.getValueAt(index, 0);
            String password = (String) accountTable.getValueAt(index, 1);
            String role = (String) accountTable.getValueAt(index, 2);
            
            int accountId = accountService.getIdByAccount(username, password, role);
            System.out.println("ID: "+accountId);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa lớp này không?", "Xác nhận xóa");

            if(confirm == 0){
                accountService.deleteAccountById(accountId);
                loadTableData();
                clearAllFields();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearAllFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        AdminHome homeScreen = new AdminHome();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageAccount().setVisible(true);
        });
    }

    private DefaultTableModel tableModel;
    private AccountService accountService;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accountTable;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField passwordField;
    private javax.swing.JComboBox<String> roleInput;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
