package view;

import exception.MessageDialog;
import static exception.Validator.isDate;
import static exception.Validator.isNumeric;
import static exception.Validator.isValidEmail;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.table.DefaultTableModel;
import services.GuideService;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.*;
import services.AccountService;
import services.TourService;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManageGuide extends javax.swing.JFrame {

    public ManageGuide() {
        initComponents();
        GuideService = new GuideService();
        accountService = new AccountService();
        tourService = new TourService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    private void loadedTableData(){
        try {
            List<Guide> Guides_data = GuideService.getAllGuides();
            tableModel.setRowCount(0);
            if(Guides_data != null){
                for(Guide Guide : Guides_data){
                    String fullName = Guide.getLastName() + " " + Guide.getFirstName();
                    
                    tableModel.addRow(new Object[]{
                        Guide.getCode(),
                        fullName,
                        Guide.getAddress(),
                        Guide.getPhoneNumber(),
                        Guide.getEmail(),
                        Guide.getBirthDate(),
                        (Guide.getTours() != null) ? Guide.getTours().size() : 0
                    });
                }
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
            e.printStackTrace();
        }
    }
    
    private void initializeTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã hướng dẫn viên", "Họ tên",
            "Địa chỉ", "Điện thoại", "Email", "Ngày sinh", "Số lượng chuyến cắm trại"});
        GuideTable.setModel(tableModel);
        loadedTableData();
    }
    
    public void clearField() {
        GuideIDField.setText("");
        nameGuideField.setText("");
        addressGuideField.setText("");
        phoneNumberGuideField.setText("");
        emailGuideField.setText("");
        birthdayGuideField.setText("");
        String imagePath = "";
        // Hiển thị ảnh
        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Chỉnh kích thước ảnh vừa với khung 
        Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_clear = new javax.swing.JButton();
        emailGuideField = new javax.swing.JTextField();
        detailTour = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        addressGuideField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        phoneNumberGuideField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        GuideTable = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_edit = new javax.swing.JButton();
        birthdayGuideField = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        GuideIDField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nameGuideField = new javax.swing.JTextField();
        imageLabel = new javax.swing.JLabel();
        imageBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_clear.setBackground(new java.awt.Color(102, 153, 0));
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Nhập lại");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        emailGuideField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        detailTour.setBackground(new java.awt.Color(0, 102, 153));
        detailTour.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        detailTour.setForeground(new java.awt.Color(255, 255, 255));
        detailTour.setText("Xem danh sách chuyến cắm trại của hướng dẫn viên");
        detailTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailTourActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        addressGuideField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Số điện thoại:");

        phoneNumberGuideField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        GuideTable.setModel(new javax.swing.table.DefaultTableModel(
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
        GuideTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuideTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(GuideTable);

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Trở lại trang chủ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(0, 102, 51));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setText("QUẢN LÍ THÔNG TIN HƯỚNG DẪN VIÊN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Ngày sinh:");

        btn_edit.setBackground(new java.awt.Color(0, 153, 153));
        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Sửa");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        birthdayGuideField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Xóa");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mã hướng dẫn viên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Email:");

        GuideIDField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Tên hướng dẫn viên:");

        nameGuideField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        imageLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imageBrowse.setBackground(new java.awt.Color(0, 153, 153));
        imageBrowse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        imageBrowse.setForeground(new java.awt.Color(255, 255, 255));
        imageBrowse.setText("Tải ảnh lên");
        imageBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1346, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addGroup(layout.createSequentialGroup()
        						.addGap(36)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(imageLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(imageBrowse, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        						.addGap(138)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(jLabel5)
        								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(addressGuideField, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(jLabel3)
        								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(birthdayGuideField, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(jLabel1)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(GuideIDField, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)))
        						.addGap(31)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(jLabel6, Alignment.LEADING)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel4)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(jLabel2)
        									.addGap(18)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        										.addComponent(emailGuideField, Alignment.TRAILING)
        										.addComponent(nameGuideField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        										.addComponent(phoneNumberGuideField, Alignment.TRAILING))))))
        					.addGroup(layout.createSequentialGroup()
        						.addGap(17)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(layout.createSequentialGroup()
        								.addGroup(layout.createParallelGroup(Alignment.LEADING)
        									.addGroup(layout.createSequentialGroup()
        										.addGap(14)
        										.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
        									.addGroup(layout.createSequentialGroup()
        										.addGap(202)
        										.addComponent(btn_edit, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        										.addGap(42)
        										.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        										.addGap(42)
        										.addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
        								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(detailTour, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
        								.addGap(183))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(btn_back, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
        								.addGap(339)
        								.addComponent(jLabel9))))))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(19)
        					.addComponent(btn_back, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
        					.addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(imageBrowse, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addGap(18))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(43)
        					.addComponent(jLabel9)
        					.addGap(57)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(GuideIDField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel1)
        						.addComponent(nameGuideField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2))
        					.addGap(30)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(birthdayGuideField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel3)
        						.addComponent(emailGuideField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel4))
        					.addGap(32)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(addressGuideField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel5)
        						.addComponent(phoneNumberGuideField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel6))
        					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
        			.addGap(33)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_edit, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(btn_clear, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(detailTour, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(btn_delete, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(btn_add, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        			.addGap(42))
        );
        getContentPane().setLayout(layout);

        btn_clear.getAccessibleContext().setAccessibleName("");
        detailTour.getAccessibleContext().setAccessibleName("");
        btn_edit.getAccessibleContext().setAccessibleName("");
        btn_delete.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imageBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageBrowseActionPerformed
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
    }//GEN-LAST:event_imageBrowseActionPerformed

    private void GuideTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuideTableMouseClicked
        try {
            int index = GuideTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn hướng dẫn viên", "Thông báo");
                return;
            }
            
            String GuideCode = (String) GuideTable.getValueAt(index, 0);
            String GuideName = (String) GuideTable.getValueAt(index, 1);
            String GuideAddress = (String) GuideTable.getValueAt(index, 2);
            String GuidePhone = (String) GuideTable.getValueAt(index, 3);
            String GuideEmail = (String) GuideTable.getValueAt(index, 4);
            String GuideBirthday = (String) GuideTable.getValueAt(index, 5);
            
            GuideIDField.setText(GuideCode);
            nameGuideField.setText(GuideName);
            phoneNumberGuideField.setText(GuidePhone);
            birthdayGuideField.setText(GuideBirthday);
            emailGuideField.setText(GuideEmail);
            addressGuideField.setText(GuideAddress);
            
            int GuideId = GuideService.getIdByGuide(GuideCode);
            
            Guide getGuideImage = GuideService.getGuideById(GuideId);
            ImageIcon imageIcon = new ImageIcon(getGuideImage.getImagePath());

            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_GuideTableMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String GuideID = this.GuideIDField.getText().trim();
            String GuideName = this.nameGuideField.getText().trim();
            String GuideAddress = this.addressGuideField.getText().trim();
            String GuidePhoneNumber = this.phoneNumberGuideField.getText().trim();
            String GuideBirthday = this.birthdayGuideField.getText().trim();
            String GuideEmail = this.emailGuideField.getText().trim();
            String imagePath = "src\\\\images\\\\user.png";
            if (selectedImagePath.trim() != "") {
                imagePath = selectedImagePath;
            }
            
            // Hiển thị ảnh
            ImageIcon imageIcon = new ImageIcon(selectedImagePath);

            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
            
            if (GuideID.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã hướng dẫn viên", "Thông báo");
                return;
            }

            if (GuideName.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập họ tên hướng dẫn viên", "Thông báo");
                return;
            }

            if (GuideAddress.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập địa chỉ", "Thông báo");
                return;
            }
            if (GuidePhoneNumber.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập số điện thoại", "Thông báo");
                return;
            }
            if (!isNumeric(GuidePhoneNumber)) {
                MessageDialog.showInfoDialog(this, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (GuideBirthday.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập ngày sinh", "Thông báo");
                return;
            }

            if (!isDate(GuideBirthday)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            if (GuideEmail.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập email", "Thông báo");
                return;
            }
            if (!isValidEmail(GuideEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }

            int accountId = accountService.getLastIdFromAccount() + 1;
            
            if(GuideService.isCheckCodeGuide(GuideID)){
                MessageDialog.showInfoDialog(this, "Trùng mã hướng dẫn viên", "Thông báo");
            }else{
                Guide Guide = new Guide(
                        accountId,
                        imagePath,
                        GuideID,
                        GuideService.FirstName(GuideName),
                        GuideService.LastName(GuideName),
                        GuideAddress,
                        GuidePhoneNumber,
                        GuideEmail,
                        GuideBirthday,
                        accountId
                );
                accountService.addGuideAccount(Guide.getCode(), Guide.getCode(), "Tài khoản hướng dẫn viên");
                GuideService.addGuide(Guide);
                loadedTableData();
                MessageDialog.showInfoDialog(this, "Đã thêm thành công", "Thông  báo");
                clearField();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = GuideTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn hướng dẫn viên", "Thông báo");
                return;
            }
            
            String GuideCode = (String) GuideTable.getValueAt(index, 0);
            String GuideName = (String) GuideTable.getValueAt(index, 1);
            String GuideAddress = (String) GuideTable.getValueAt(index, 2);
            String GuidePhone = (String) GuideTable.getValueAt(index, 3);
            String GuideEmail = (String) GuideTable.getValueAt(index, 4);
            String GuideBirthday = (String) GuideTable.getValueAt(index, 5);
            
            int GuideId = GuideService.getIdByGuide(GuideCode);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa đoàn này không?", "Xác nhận xóa");
            
            if(confirm == 0){
                GuideService.deleteGuideById(GuideId);
                loadedTableData();
                clearField();
            }
            
            System.out.println("GuideId: " + GuideId);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = GuideTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn hướng dẫn viên", "Thông báo");
                return;
            }
            
            String code = (String) GuideTable.getValueAt(index, 0);
            String name = (String) GuideTable.getValueAt(index, 1);
            String address = (String) GuideTable.getValueAt(index, 2);
            String phone = (String) GuideTable.getValueAt(index, 3);
            String email = (String) GuideTable.getValueAt(index, 4);
            String birthday = (String) GuideTable.getValueAt(index, 5);
            
            int GuideId = GuideService.getIdByGuide(code);
            System.out.println("GuideId : " + GuideId);
            
            Guide Guide = GuideService.getGuideById(GuideId);
            System.out.println("Guide: " + Guide.getCode());
            
            String imagePath = Guide.getImagePath();
            if (!selectedImagePath.equals(imagePath)) {
                if (!selectedImagePath.trim().equals("")) {
                    Guide.setImagePath(selectedImagePath);
                }
            }
                    
            String GuideCode = this.GuideIDField.getText().trim();
            String GuideName = this.nameGuideField.getText().trim();
            String GuideAddress = this.addressGuideField.getText().trim();
            String GuidePhoneNumber = this.phoneNumberGuideField.getText().trim();
            String GuideBirthday = this.birthdayGuideField.getText().trim();
            String GuideEmail = this.emailGuideField.getText().trim();
            
            if (GuideCode.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã hướng dẫn viên", "Thông báo");
                return;
            }

            if (GuideName.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập họ tên hướng dẫn viên", "Thông báo");
                return;
            }

            if (GuideAddress.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập địa chỉ", "Thông báo");
                return;
            }
            if (GuidePhoneNumber.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập số điện thoại", "Thông báo");
                return;
            }
            if (!isNumeric(GuidePhoneNumber)) {
                MessageDialog.showInfoDialog(this, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (GuideBirthday.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập ngày sinh", "Thông báo");
                return;
            }

            if (!isDate(GuideBirthday)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            if (GuideEmail.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập email", "Thông báo");
                return;
            }
            if (!isValidEmail(GuideEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }

            if(GuideService.isCheckCodeGuide(GuideCode) && !GuideCode.equals(GuideCode)){
                MessageDialog.showInfoDialog(this, "Mã hướng dẫn viên không tồn tại", "Thông báo");
            }else{
                Guide.setCode(GuideCode);
                Guide.setFirstName(GuideService.FirstName(GuideName));
                Guide.setLastName(GuideService.LastName(GuideName));
                Guide.setPhoneNumber(GuidePhoneNumber);
                Guide.setBirthDate(GuideBirthday);
                Guide.setEmail(GuideEmail);
                Guide.setAddress(GuideAddress);
                
                GuideService.updateGuide(Guide, GuideId);
                MessageDialog.showInfoDialog(this, "Cập nhật thành công", "Thông báo");
                loadedTableData();
                clearField();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearField();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        AdminHome homeScreen = new AdminHome();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void detailTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailTourActionPerformed
        try {
            int index = GuideTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn hướng dẫn viên để thực hiện chức năng", "Thông báo");
                return;
            }
            
            String code = (String) GuideTable.getValueAt(index, 0);
            
            int GuideId = GuideService.getIdByGuide(code);
            Guide Guide = GuideService.getGuideById(GuideId);
            
            dispose();
            List<Tour> tours = tourService.getToursByGuideId(GuideId);
            
            ManageToursOfGuide manageToursOfGuide = new ManageToursOfGuide();
            manageToursOfGuide.setTours(tours);
            manageToursOfGuide.setGuideID(GuideId);
            manageToursOfGuide.setImagePath(Guide.getImagePath());
            manageToursOfGuide.getGuideIdLabel().setText(Guide.getCode());
            manageToursOfGuide.getGuideNameLabel().setText(Guide.getLastName()+" "+Guide.getFirstName());
            manageToursOfGuide.getGuidePhoneNumberLabel().setText(Guide.getPhoneNumber());
            manageToursOfGuide.getGuideEmailLable().setText(Guide.getEmail());
            manageToursOfGuide.getGuideAdressLable().setText(Guide.getAddress());
            
            manageToursOfGuide.setLocationRelativeTo(null);
            manageToursOfGuide.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_detailTourActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageGuide().setVisible(true);
        });
    }
    
    
    private DefaultTableModel tableModel;
    private GuideService GuideService;
    private String selectedImagePath = "";
    private static final String imageFolderPath = "src/images";
    private AccountService accountService;
    private TourService tourService;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressGuideField;
    private javax.swing.JTextField birthdayGuideField;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton detailTour;
    private javax.swing.JTextField emailGuideField;
    private javax.swing.JButton imageBrowse;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameGuideField;
    private javax.swing.JTextField phoneNumberGuideField;
    private javax.swing.JTextField GuideIDField;
    private javax.swing.JTable GuideTable;
    // End of variables declaration//GEN-END:variables
}
