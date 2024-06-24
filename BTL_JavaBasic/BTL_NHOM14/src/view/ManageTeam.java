package view;

import exception.MessageDialog;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Team;
import services.TeamService;

public class ManageTeam extends javax.swing.JFrame {

    public ManageTeam() {
        initComponents();
        TeamService = new TeamService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    private void clearAllField(){
        TeamIdField.setText("");
        TeamNameField.setText("");
    }
    private void loadedDataTable(){
        try {
            List<Team> data = TeamService.getAllTeam();
            tableModel.setRowCount(0);
            int count = 0;
            if(data != null){
                for(Team item : data){
                    count++;
                    tableModel.addRow(new Object[]{count,item.getCode(),item.getName()});
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    private void initializeTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"STT", "Mã đoàn cắm trại", "Tên đoàn cắm trại"});
        TeamTable.setModel(tableModel);
        loadedDataTable();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TeamNameField = new javax.swing.JTextField();
        btn_back = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TeamTable = new javax.swing.JTable();
        ListStudentButton = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TeamIdField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TeamNameField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Trở lại trang chủ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(0, 153, 153));
        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Sửa");
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_edit.setPreferredSize(new java.awt.Dimension(269, 37));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(0, 102, 51));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm");
        btn_add.setPreferredSize(new java.awt.Dimension(269, 37));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(102, 153, 0));
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Nhập lại");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        TeamTable.setModel(new javax.swing.table.DefaultTableModel(
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
        TeamTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeamTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TeamTable);

        ListStudentButton.setBackground(new java.awt.Color(0, 102, 153));
        ListStudentButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ListStudentButton.setForeground(new java.awt.Color(255, 255, 255));
        ListStudentButton.setText("Danh sách khách hàng");
        ListStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListStudentButtonActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Xóa");
        btn_delete.setPreferredSize(new java.awt.Dimension(269, 37));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mã đoàn cắm trại:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("QUẢN LÍ THÔNG TIN ĐOÀN CẮM TRẠI");

        TeamIdField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Tên đoàn cắm trại:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_back))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(290, 290, 290)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ListStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TeamIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TeamNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                                    .addComponent(jLabel2))))))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TeamIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TeamNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(ListStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TeamTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeamTableMouseClicked
        try {
            int index = TeamTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui lòng chọn đoàn cắm trại", "Thông báo");
                return;
            }
            String code = (String) TeamTable.getValueAt(index, 1);
            String name = (String) TeamTable.getValueAt(index, 2);
            
            int TeamId = TeamService.getIdByTeam(code, name);
            
            TeamIdField.setText(code);
            TeamNameField.setText(name);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_TeamTableMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String code = this.TeamIdField.getText().trim();
            String name = this.TeamNameField.getText().trim();
            
            if(code.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã đoàn cắm trại trống", "Thông báo");
                return;
            }
            if(name.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên đoàn cắm trại trống", "Thông báo");
                return;
            }
            if(TeamService.isExistedTeamCode(code)){
                MessageDialog.showInfoDialog(this, "Trùng mã đoàn cắm trại", "Thông báo");
            }else if(TeamService.isExistedTeamName(name)){
                MessageDialog.showInfoDialog(this, "Trùng tên đoàn cắm trại", "Thông báo");
            }else{
                Team Team = new Team(code, name);
                
                TeamService.addTeam(Team);
                
                loadedDataTable();
                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
                clearAllField();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_addActionPerformed

    
    //Bắt lỗi khi không thể cập nhật dữ liệu đoàn cắm trại
    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = TeamTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn đoàn cắm trại", "Thông báo");
                return;
            }
            
            String code = (String) TeamTable.getValueAt(index, 1);
            String name = (String) TeamTable.getValueAt(index, 2);
            
            int TeamId = TeamService.getIdByTeam(code, name);
            System.out.println(TeamId);
            
            String TeamNewCode = this.TeamIdField.getText().trim();
            String TeamNewName = this.TeamNameField.getText().trim();
            
            if(TeamNewCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã đoàn cắm trại trống", "Thông báo");
                return;
            }
            if(TeamNewName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên đoàn cắm trại trống", "Thông báo");
                return;
            }
            
            if(TeamService.isExistedTeamCode(TeamNewCode) && !TeamNewCode.equals(TeamNewCode)){
                MessageDialog.showInfoDialog(this, "Mã đoàn cắm trại không tồn tại!", "Thông báo");
                return;
            }
            if(TeamService.isExistedTeamName(TeamNewName) && !TeamNewName.equals(TeamNewName)){
                MessageDialog.showInfoDialog(this, "Tên đoàn cắm trại không tồn tại!", "Thông báo");
                return;
            }
            
            Team selectedTeam = TeamService.getTeamById(TeamId);
            System.out.println(selectedTeam);
            
            selectedTeam.setCode(TeamNewCode);
            selectedTeam.setName(TeamNewName);
            
            TeamService.updateTeam(selectedTeam, TeamId);
            loadedDataTable();
            MessageDialog.showInfoDialog(this, "Cập nhật thành công", "Thông báo");
            clearAllField();
            
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() 
                    + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = TeamTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn đoàn cắm trại", "Thông báo");
                return;
            }
            String code = (String) TeamTable.getValueAt(index, 1);
            String name = (String) TeamTable.getValueAt(index, 2);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa đoàn cắm trại này không?", "Xác nhận xóa");
            
            if(confirm == 0){
                int TeamId = TeamService.getIdByTeam(code, name);
                
                System.out.println("ID: " + TeamId);
                
                TeamService.deleteTeam(TeamId);
                loadedDataTable();
                clearAllField();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearAllField();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        AdminHome homeScreen = new AdminHome();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    
    // Bắt lỗi khi chuyển trang
    private void ListStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListStudentButtonActionPerformed
        try {
            int index = TeamTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn đoàn cắm trại", "Thông báo");
                return;
            }
            String code = (String) TeamTable.getValueAt(index, 1);
            String name = (String) TeamTable.getValueAt(index, 2);
            
            int TeamId = TeamService.getIdByTeam(code,name);
            Team Team = TeamService.getTeamById(TeamId);
            System.out.println("Team: " + Team.getId());
            
            dispose();
            ManageListCustomerTeam manageListStudentTeam = new ManageListCustomerTeam(Team);
            manageListStudentTeam.setLocationRelativeTo(null);
            manageListStudentTeam.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ListStudentButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageTeam().setVisible(true);
            }
        });
    }

    private DefaultTableModel tableModel;
    private TeamService TeamService;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TeamIdField;
    private javax.swing.JTextField TeamNameField;
    private javax.swing.JButton ListStudentButton;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JTable TeamTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
