package view;

import exception.MessageDialog;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;
import models.*;
import services.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
public class ManageDestinate extends javax.swing.JFrame {

    public ManageDestinate() {
        initComponents();
        DestinateService = new DestinateService();
        tourService = new TourService();
        initializeTable();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        DestinateCodeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DestinateNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DestinatePhoneField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        DestinateTimeStayField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        DestinateAddressField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        DestinateDesField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        DestinateTable = new javax.swing.JTable();
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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setText("QUẢN LÍ THÔNG TIN ĐỊA ĐIỂM");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mã địa điểm: ");

        DestinateCodeField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Tên địa điểm: ");

        DestinateNameField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Place Sleep:");

        DestinatePhoneField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("TimeStay:");

        DestinateTimeStayField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        DestinateAddressField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Mô tả:");

        DestinateDesField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        DestinateTable.setModel(new javax.swing.table.DefaultTableModel(
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
        DestinateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DestinateTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DestinateTable);

        btn_add.setBackground(new java.awt.Color(0, 102, 51));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(0, 153, 153));
        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Sửa");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Xóa");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(125)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel5)
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(DestinateAddressField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel3)
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(DestinatePhoneField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel1)
        							.addGap(32)
        							.addComponent(DestinateCodeField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
        					.addGap(32)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel2)
        							.addGap(32)
        							.addComponent(DestinateNameField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel4)
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(DestinateTimeStayField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel6)
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(DestinateDesField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(21)
        					.addComponent(btn_back))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(31)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
        						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        							.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        							.addGap(68)
        							.addComponent(btn_edit, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        							.addGap(58)
        							.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        							.addGap(53)
        							.addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        							.addGap(131)))))
        			.addContainerGap(37, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(0, 480, Short.MAX_VALUE)
        			.addComponent(jLabel9)
        			.addGap(314))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(14)
        			.addComponent(btn_back, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(4)
        			.addComponent(jLabel9)
        			.addGap(35)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(DestinateCodeField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1)
        				.addComponent(DestinateNameField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addGap(32)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(DestinatePhoneField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3)
        				.addComponent(DestinateTimeStayField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4))
        			.addGap(32)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(DestinateAddressField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5)
        				.addComponent(DestinateDesField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6))
        			.addGap(42)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
        			.addGap(29)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_clear, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(btn_delete, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(btn_edit, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(btn_add, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        			.addGap(35))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Hàm clear
    private void clearAllFields() {
        DestinateCodeField.setText("");
        DestinateNameField.setText("");
        DestinatePhoneField.setText("");
        DestinateTimeStayField.setText("");
        DestinateAddressField.setText("");
        DestinateDesField.setText("");
    }
    // Hàm load dữ liệu
    private void loadedTableData(){
        try{
            List<Destinate> Destinate_data = DestinateService.getAllDestinate();
            tableModel.setRowCount(0);
            if(Destinate_data != null){
                for(Destinate Destinate : Destinate_data){
                    
                    // Thêm đối tượng Destinate vào các dòng của table
                    tableModel.addRow(new Object[]{
                        Destinate.getCode(),
                        Destinate.getName(),
                        Destinate.getAddress(),
                        Destinate.getTimeStay(),
                        Destinate.getSleepPlace(),
                        Destinate.getDescription()
                    });
                }
            }
            tableModel.fireTableDataChanged();
        }catch(Exception e){
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
        }
    }
    
    // Hàm khởi tạo bảng
    private void initializeTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã địa điểm", "Địa điểm","Địa chỉ",
            "TimeStay", "PlaceSleep", "Mô tả"});
        DestinateTable.setModel(tableModel);
        loadedTableData();
    }
    
    // Nút thêm
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            
            // Lấy giá trị từ text field
            String DestinateCode = this.DestinateCodeField.getText().trim();
            String DestinateName = this.DestinateNameField.getText().trim();
            String DestinateDescription = this.DestinateDesField.getText().trim();
            String DestinateTimeStay = this.DestinateTimeStayField.getText().trim();
            String DestinateSleepPlace = this.DestinatePhoneField.getText().trim();
            String DestinateAdress = this.DestinateAddressField.getText().trim();

            // Bắt lỗi bỏ trống
            if(DestinateName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên địa điểm trống", "Thông báo");
                return;
            }
            if(DestinateCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã địa điểm trống ", "Thông báo");
                return;
            }
          //  TimeStay
            if(DestinateTimeStay.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "TimeStay địa điểm trống", "Thông báo");
                return;
            }
            if(DestinateSleepPlace.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Điện thoại địa điểm trống", "Thông báo");
                return;
            }
            if(DestinateAdress.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Địa chỉ địa điểm trống", "Thông báo");
                return;
            }
            if(DestinateDescription.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mô tả địa điểm trống", "Thông báo");
                return;
            }
            // Bắt lỗi trùng
            if(DestinateService.isExistedComCode(DestinateCode)){
                MessageDialog.showInfoDialog(this, "Mã số địa điểm đã tồn tại", "Thông báo");
            }else if(DestinateService.isExistedComName(DestinateName)){
                MessageDialog.showInfoDialog(this, "Tên địa điểm đã tồn tại", "Thông báo");
            }else{
                // Gán biến vào đối tượng 
                Destinate Destinate = new Destinate(DestinateCode, DestinateName, DestinateDescription, DestinateTimeStay,DestinateSleepPlace, DestinateAdress);
                
                // Thực hiện thêm
                DestinateService.addDestinate(Destinate);
                loadedTableData();
                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
                clearAllFields();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_addActionPerformed

    // Nút nhập lại
    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearAllFields();
    }//GEN-LAST:event_btn_clearActionPerformed
    
    // Nút xóa
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = DestinateTable.getSelectedRow();// Hàng được chọn
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui lòng chọn địa điểm", "Thông báo");
                return;
            }
            
            // Lấy giá trị từ hàng được chọn của từng cột 
            String code = (String) DestinateTable.getValueAt(index, 0);
            String name = (String) DestinateTable.getValueAt(index, 1);
            String address = (String) DestinateTable.getValueAt(index, 2);
            String TimeStay = (String) DestinateTable.getValueAt(index, 3);
            String SleepPlace = (String) DestinateTable.getValueAt(index, 4);
            String description = (String) DestinateTable.getValueAt(index, 5);
            
            System.out.println("index " + index);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa địa điểm này không?", "Xác nhận xóa");
            
            if (confirm == 0) {
                
                // Lấy ra id tương ứng với các thuộc tính được chọn ra từ bảng
                int DestinateId = DestinateService.GetIdByDestinate(code, name, description, TimeStay, SleepPlace, address);
                System.out.println("ID: " + DestinateId);
                // Thực hiện xóa
                DestinateService.deleteDestinateById(DestinateId);
                loadedTableData();
                clearAllFields();
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void DestinateTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DestinateTableMouseClicked
        try {
            int index = DestinateTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui lòng chọn địa điểm", "Thông báo");
                return;
            }

            // Lấy giá trị từ bảng
            String code = (String) DestinateTable.getValueAt(index, 0);
            String name = (String) DestinateTable.getValueAt(index, 1);
            String address = (String) DestinateTable.getValueAt(index, 2);
            String TimeStay = (String) DestinateTable.getValueAt(index, 3);
            String SleepPlace = (String) DestinateTable.getValueAt(index, 4);
            String description = (String) DestinateTable.getValueAt(index, 5);

            // Đẩy giá trị lên các JTextField
            DestinateCodeField.setText(code);
            DestinateNameField.setText(name);
            DestinateDesField.setText(description);
            DestinateTimeStayField.setText(TimeStay);
            DestinatePhoneField.setText(SleepPlace);
            DestinateAddressField.setText(address);
            
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
        }
    }//GEN-LAST:event_DestinateTableMouseClicked

    // Nút sửa
    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = DestinateTable.getSelectedRow(); // Hàng được chọn
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui chọn chọn địa điểm muốn sửa", "Thông báo");
                return;
            }
            
            // Lấy giá trị từ bảng
            String code = (String) DestinateTable.getValueAt(index, 0);
            String name = (String) DestinateTable.getValueAt(index, 1);
            String address = (String) DestinateTable.getValueAt(index, 2);
            String TimeStay = (String) DestinateTable.getValueAt(index, 3);
            String SleepPlace = (String) DestinateTable.getValueAt(index, 4);
            String description = (String) DestinateTable.getValueAt(index, 5);

            // Lấy ra id tương ứng với giá trị của bảng
            int DestinateId = DestinateService.GetIdByDestinate(code, name, description, TimeStay, SleepPlace, address);
            
            // Lấy giá trị từ text field
            String DestinateName = this.DestinateNameField.getText().trim();
            String DestinateCode = this.DestinateCodeField.getText().trim();
            String DestinateDes = this.DestinateDesField.getText().trim();
            String DestinateTimeStay = this.DestinateTimeStayField.getText().trim();
            String DestinatePhone = this.DestinatePhoneField.getText().trim();
            String DestinateAddress = this.DestinateAddressField.getText().trim();
            
            // Bắt sự kiện bỏ trống
            if (DestinateName.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Tên địa điểm không để trống", "Thông báo");
                return;
            }
            if (DestinateCode.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Mã số địa điểm không để trống", "Thông báo");
                return;
            }
            if (DestinateTimeStay.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Mail địa điểm không để trống", "Thông báo");
                return;
            }
            if (DestinatePhone.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Số điện thoại địa điểm không để trống", "Thông báo");
                return;
            }
            if (DestinateAddress.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Địa chỉ địa điểm không để trống", "Thông báo");
                return;
            }
            if(DestinateDes.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mô tả địa điểm trống", "Thông báo");
                return;
            }
            
            // Bắt sự kiện trùng
            if (DestinateService.isExistedComCode(DestinateCode) && !DestinateCode.equals(DestinateCode)) {
                MessageDialog.showInfoDialog(this, "Mã số địa điểm đã tồn tại", "Thông báo");
                return;
            }
            if (DestinateService.isExistedComName(DestinateName) && !DestinateName.equals(DestinateName)) {
                MessageDialog.showInfoDialog(this, "Tên địa điểm đã tồn tại", "Thông báo");
                return;
            }
            
            // Gọi đối tượng thông qua id
            Destinate selectedCom = DestinateService.getDestinateById(DestinateId);
            
            // Đẩy giá trị từ text Field vào đối tượng
            selectedCom.setCode(DestinateCode);
            selectedCom.setName(DestinateName);
            selectedCom.setDescription(DestinateDes);
            selectedCom.setTimeStay(DestinateTimeStay);
            selectedCom.setSleepPlace(DestinatePhone);
            selectedCom.setAddress(DestinateAddress);
            // Thực hiện sửa đối tượng theo id
            DestinateService.updateDestinate(selectedCom , DestinateId);
            loadedTableData();
            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            clearAllFields();
            
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        AdminHome homeScreen = new AdminHome();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageDestinate().setVisible(true);
        });
    }

    private DefaultTableModel tableModel;
    private DestinateService DestinateService;
    private TourService tourService;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JTextField DestinateAddressField;
    private javax.swing.JTextField DestinateCodeField;
    private javax.swing.JTextField DestinateDesField;
    private javax.swing.JTextField DestinateTimeStayField;
    private javax.swing.JTextField DestinateNameField;
    private javax.swing.JTextField DestinatePhoneField;
    private javax.swing.JTable DestinateTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
