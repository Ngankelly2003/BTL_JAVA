package view;

import exception.MessageDialog;
import static exception.Validator.*;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.Team;
import models.Customer;
import models.Guide;
import models.Tour;
import services.AccountService;
import services.TeamService;
import services.CustomerService;
import services.TourService;

public class ManageCustomer extends javax.swing.JFrame {
    
    public ManageCustomer() {
        initComponents();
        CustomerService = new CustomerService();
        TeamService = new TeamService();
        accountService = new AccountService();
        tourService = new TourService();
        loadComboBox();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã khách hàng", "Họ", "Tên", "Địa chỉ", "SĐT", "Email", "Ngày sinh", "Đoàn"});
        CustomerTable.setModel(tableModel); 
        loadDataTable();
    }
    
    private void loadDataTable(){
        try {
            List<Customer> Customers_data = CustomerService.getAllCustomers();
            List<Team> Team_data = TeamService.getAllTeam();
            tableModel.setRowCount(0);
            if(Customers_data != null){
                for(Customer Customer : Customers_data){
                    String TeamName = CustomerService.getCustomerTeamNameById(Customer.getTeamId());
                    tableModel.addRow(new Object[]{
                        Customer.getCode(),
                        Customer.getLastName(),
                        Customer.getFirstName(),
                        Customer.getAddress(),
                        Customer.getPhoneNumber(),
                        Customer.getEmail(),
                        Customer.getBirthDate(),
                        TeamName
                    });
                }
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
            e.printStackTrace();
        }
    }
    
    private void loadComboBox() {
        try {
            List<Team> Team_data = TeamService.getAllTeam();
            // Xóa các mục cũ trước khi thêm mới
            TeamInput.removeAllItems();

            for (Team Team : Team_data) {
                TeamInput.addItem(Team.getName());
            }
            
            Object selectedTeam = TeamInput.getSelectedItem();
            System.out.println("Giá trị được chọn: " + selectedTeam);                

        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho combobox có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
}
    
    private void clearAllFields(){
        txt_code.setText("");
        txt_last_name.setText("");
        txt_first_name.setText("");
        txt_address.setText("");
        txt_email.setText("");
        txt_phone.setText("");
        txt_datebirth.setText("");
        TeamInput.setSelectedIndex(0);
        txt_code.requestFocus();
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

        btn_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_code = new javax.swing.JTextField();
        txt_last_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_first_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_CustomerTours = new javax.swing.JButton();
        txt_datebirth = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        imageBrowse = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        TeamInput = new javax.swing.JComboBox<>();

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

        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
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
        CustomerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CustomerTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Mã khách hàng:");

        txt_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_last_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Họ:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tên:");

        txt_first_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        txt_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Ngày sinh:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Lớp:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("QUẢN LÍ THÔNG TIN KHÁCH HÀNG");

        btn_add.setBackground(new java.awt.Color(0, 102, 51));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(0, 102, 102));
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

        btn_CustomerTours.setBackground(new java.awt.Color(0, 102, 153));
        btn_CustomerTours.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_CustomerTours.setForeground(new java.awt.Color(255, 255, 255));
        btn_CustomerTours.setText("Chuyến cắm trại khách hàng tham gia");
        btn_CustomerTours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CustomerToursActionPerformed(evt);
            }
        });

        txt_datebirth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        imageBrowse.setBackground(new java.awt.Color(0, 153, 153));
        imageBrowse.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imageBrowse.setForeground(new java.awt.Color(255, 255, 255));
        imageBrowse.setText("Tải ảnh lên");
        imageBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBrowseActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Email:");

        imageLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imageLabel.setText("Ảnh");

        TeamInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_CustomerTours, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_back)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_datebirth)
                                    .addComponent(TeamInput, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_phone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                    .addComponent(txt_address, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_first_name, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(txt_last_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_code, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(imageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(imageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_datebirth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TeamInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_CustomerTours, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

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

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String CustomerCode = this.txt_code.getText().trim();
            String CustomerLastName = this.txt_last_name.getText().trim();
            String CustomerFirstName = this.txt_first_name.getText().trim();
            String CustomerAddress = this.txt_address.getText().trim();
            String CustomerPhone = this.txt_phone.getText().trim();
            String CustomerEmail = this.txt_email.getText().trim();
            String CustomerBirthDate = this.txt_datebirth.getText().trim();
//            Team Team = (Team) TeamInput.getSelectedItem();
            
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
            
            if(CustomerCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã khách hàng không được bỏ trống", "Thông báo");
                return;
            }
            
            if(CustomerLastName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên khách hàng không được bỏ trống", "Thông báo");
                return;
            }
            
            if(CustomerFirstName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên khách hàng không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(CustomerAddress.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Địa chỉ khách hàng không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(CustomerPhone.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "SĐT khách hàng không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(CustomerEmail.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Email khách hàng không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(CustomerBirthDate.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Ngày sinh của khách hàng không được bỏ trống", "Thông báo");
                return; 
            }
            
            if (!isNumeric(CustomerPhone)) {
                MessageDialog.showInfoDialog(this, "dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (!isValidEmail(CustomerEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }
            if (!isDate(CustomerBirthDate)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            
            if(CustomerService.isExistedCustomerCode(CustomerCode)){
                MessageDialog.showInfoDialog(this, "Mã khách hàng đã tồn tại", "Thông báo");
                return;
            }
            
            if (TeamInput.getSelectedItem() instanceof String) {
                String selectedTeamName = (String) TeamInput.getSelectedItem();
                System.out.println("SelectedTeamName: " + selectedTeamName);
                // Tìm đối tượng Team tương ứng với tên lớp học được chọn
                List<Team> Team_data = TeamService.getAllTeam();
                for (Team c : Team_data) {
                    if (c.getName().equals(selectedTeamName)) {
                        Team Team = c;
                        int TeamId = TeamService.getTeamIdByTeamName(Team);
                        
                        int accountId = accountService.getLastIdFromAccount() + 1;
           
                        Customer Customer = new Customer(
                                accountId, 
                                imagePath, 
                                CustomerCode,
                                CustomerFirstName,
                                CustomerLastName, 
                                CustomerAddress, 
                                CustomerPhone, 
                                CustomerEmail, 
                                CustomerBirthDate, 
                                accountId,
                                TeamId
                        );

                        System.out.println("Customer: " + Customer.getCode());
                        System.out.println("TeamId : " + TeamId);
                        accountService.addCustomerAccount(Customer.getCode(), Customer.getCode(), "Tài khoản khách hàng");
                        CustomerService.addCustomer(Customer);
                        loadDataTable();
                        MessageDialog.showInfoDialog(this, "Thêm khách hàng thành công", "Thông báo");
                        clearAllFields();
                        break;
                    }
                }
            } else {
                System.out.println("Kiểu dữ liệu không phải là String");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void CustomerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTableMouseClicked
        try {
            int index = CustomerTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn khách hàng", "Thông báo");
                return;
            }
            String code = (String) CustomerTable.getValueAt(index, 0);
            String lastName = (String) CustomerTable.getValueAt(index, 1);
            String firstName = (String) CustomerTable.getValueAt(index, 2);
            String address = (String) CustomerTable.getValueAt(index, 3);
            String phone = (String) CustomerTable.getValueAt(index, 4);
            String email = (String) CustomerTable.getValueAt(index, 5);
            String birthdate = (String) CustomerTable.getValueAt(index, 6);
            
            // Lấy ra CustomerId theo CustomerCode
            int CustomerId = CustomerService.getIdByCustomer(code);
            
            // Lấy ra đối tượng Customer theo CustomerId
            Customer getCustomerImage = CustomerService.getCustomerById(CustomerId);
            
            // Lấy ra TeamId theo CustomerId
            int TeamId = CustomerService.getTeamIdByCustomerId(CustomerId);
            // Lấy ra đối tượng Team theo TeamId
            Team Team = TeamService.getTeamNameById(TeamId);
            
            TeamInput.setSelectedItem(Team.getName());
            txt_code.setText(code);
            txt_last_name.setText(lastName);
            txt_first_name.setText(firstName);
            txt_address.setText(address);
            txt_email.setText(email);
            txt_phone.setText(phone);
            txt_datebirth.setText(birthdate);
            
            ImageIcon imageIcon = new ImageIcon(getCustomerImage.getImagePath());

            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CustomerTableMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = CustomerTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn khách hàng", "Thông báo");
                return;
            }
            
            String code = (String) CustomerTable.getValueAt(index, 0);
            String lastName = (String) CustomerTable.getValueAt(index, 1);
            String firstName = (String) CustomerTable.getValueAt(index, 2);
            String address = (String) CustomerTable.getValueAt(index, 3);
            String phone = (String) CustomerTable.getValueAt(index, 4);
            String email = (String) CustomerTable.getValueAt(index, 5);
            String birthdate = (String) CustomerTable.getValueAt(index, 6);
            
            int CustomerId = CustomerService.getIdByCustomer(code);
            System.out.println(CustomerId);
            Customer Customer = CustomerService.getCustomerById(CustomerId);
            System.out.println(Customer);
            
            String imagePath = Customer.getImagePath();
            if (!selectedImagePath.equals(imagePath)) {
                if (!selectedImagePath.trim().equals("")) {
                    Customer.setImagePath(selectedImagePath);
                }
            }
            
            String CustomerCode = this.txt_code.getText().trim();
            String CustomerLastName = this.txt_last_name.getText().trim();
            String CustomerFirstName = this.txt_first_name.getText().trim();
            String CustomerAddress = this.txt_address.getText().trim();
            String CustomerPhone = this.txt_phone.getText().trim();
            String CustomerEmail = this.txt_email.getText().trim();
            String CustomerBirthDate = this.txt_datebirth.getText().trim();
            
            if(CustomerCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã khách hàng không được bỏ trống", "Thông báo");
                return;
            }
            
            if(CustomerLastName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên khách hàng không được bỏ trống", "Thông báo");
                return;
            }
            
            if(CustomerFirstName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên khách hàng không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(CustomerAddress.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Địa chỉ khách hàng không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(CustomerPhone.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "SĐT khách hàng không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(CustomerEmail.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Email khách hàng không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(CustomerBirthDate.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Ngày sinh của khách hàng không được bỏ trống", "Thông báo");
                return; 
            }
            
            if (!isNumeric(CustomerPhone)) {
                MessageDialog.showInfoDialog(this, "dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (!isValidEmail(CustomerEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }
            if (!isDate(CustomerBirthDate)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            
            if(CustomerService.isExistedCustomerCode(CustomerCode) && !CustomerCode.equals(code)){
                MessageDialog.showInfoDialog(this, "Mã khách hàng không tồn tại", "Thông báo");
                return;
            }
            
            String selectedTeamName = (String) TeamInput.getSelectedItem();
            System.out.println("SelectedTeamName: " + selectedTeamName);
        
            // Tìm đối tượng Team tương ứng với tên lớp học được chọn
            List<Team> Team_data = TeamService.getAllTeam();
            for (Team c : Team_data) {
                if (c.getName().equals(selectedTeamName)) {
                    Team Team = c;
                    int TeamId = TeamService.getTeamIdByTeamName(Team);

                    System.out.println("TeamId: " + TeamId);
                    Customer.setCode(CustomerCode);
                    Customer.setFirstName(CustomerFirstName);
                    Customer.setLastName(CustomerLastName);
                    Customer.setPhoneNumber(CustomerPhone);
                    Customer.setBirthDate(CustomerBirthDate);
                    Customer.setEmail(CustomerEmail);
                    Customer.setAddress(CustomerAddress);
                    Customer.setTeamId(TeamId);

                    CustomerService.updateCustomer(Customer, CustomerId);
                    loadDataTable();
                    MessageDialog.showInfoDialog(this, "Cập nhật khách hàng thành công", "Thông báo");
                    clearAllFields();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = CustomerTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn khách hàng", "Thông báo");
                return;
            }
            
            String code = (String) CustomerTable.getValueAt(index, 0);
            
            int CustomerId = CustomerService.getIdByCustomer(code);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này không?", "Xác nhận xóa");
            
            if(confirm == 0){
                CustomerService.deleteCustomerById(CustomerId);
                loadDataTable();
                MessageDialog.showInfoDialog(this, "Xóa khách hàng thành công", "Thông báo");
                clearAllFields();
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    private void btn_CustomerToursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CustomerToursActionPerformed
        try {
            int index = CustomerTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn khách hàng để thực hiện chức năng", "Thông báo");
                return;
            }
            String code = (String) CustomerTable.getValueAt(index, 0);
            
            Customer Customer = CustomerService.getCustomerByCustomerCode(code);
            dispose();
            
            int CustomerId = Customer.getId();
            System.out.println("CustomerId: " + CustomerId);
            List<Tour> tours = tourService.getToursByCustomerId(CustomerId);
            System.out.println("Tours: " + tours);
            
            ManageCustomerTour manageCustomerTourScreen = new ManageCustomerTour();
            manageCustomerTourScreen.setTours(tours);
            manageCustomerTourScreen.setImagePath(Customer.getImagePath());
            manageCustomerTourScreen.getCustomerCodeLabel().setText(Customer.getCode());
            manageCustomerTourScreen.getFullNameLabel().setText(Customer.getLastName() + " " + Customer.getFirstName());
            manageCustomerTourScreen.getAddressLabel().setText(Customer.getAddress());
            manageCustomerTourScreen.getPhoneNumberLabel().setText(Customer.getPhoneNumber());
            manageCustomerTourScreen.getEmailLabel().setText(Customer.getEmail());
            manageCustomerTourScreen.getBirthDateLabel().setText(Customer.getBirthDate());
            manageCustomerTourScreen.getTeamIdLabel().setText(TeamService.getTeamNameById(Customer.getTeamId()).getName());
            
            manageCustomerTourScreen.setLocationRelativeTo(null);
            manageCustomerTourScreen.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_CustomerToursActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCustomer().setVisible(true);
            }
        });
    }
    
    private DefaultTableModel tableModel;
    private String selectedImagePath = "";
    private CustomerService CustomerService;
    private TeamService TeamService;
    private AccountService accountService;
    private TourService tourService;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CustomerTours;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JComboBox<Object> TeamInput;
    private javax.swing.JButton imageBrowse;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextField txt_datebirth;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
