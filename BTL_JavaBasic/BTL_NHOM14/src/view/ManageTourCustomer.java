
package view;

import exception.MessageDialog;
import exception.PDFExporter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.*;

public class ManageTourCustomer extends javax.swing.JFrame {

    private DestinateService DestinateService;
    private CustomerService CustomerService;
    private TeamService TeamService;
    private CustomerTourService CustomerTourService;
    private TourService tourService;
    
    public ManageTourCustomer() {
        initComponents();
        DestinateService = new DestinateService();
        CustomerService = new CustomerService();
        TeamService = new TeamService();
        CustomerTourService = new CustomerTourService();
        tourService = new TourService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    private Tour selectedTour;
    
    public ManageTourCustomer(Tour tour){
        DestinateService = new DestinateService();
        CustomerService = new CustomerService();
        TeamService = new TeamService();
        CustomerTourService = new CustomerTourService();
        tourService = new TourService();
        try {
            this.selectedTour = tour;
            initComponents();
            setLocationRelativeTo(null);
            initializeTable();
            String tourTitle = tour.getName() + " (Mã: " + tour.getCode() + ", địa điểm: " + tour.getName() + ") - Ngày: " + tour.getStartDate();
            tourNameTitle.setText(tourTitle);
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra! Chi tiết: " + ex.getMessage(), "lỗi");
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        screenTitle = new javax.swing.JLabel();
        tourNameTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        pdfBtn = new javax.swing.JButton();
        excelBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Quay lại");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        screenTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        screenTitle.setText("Danh sách khách hàng tham gia tour cắm trại ");

        tourNameTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tourNameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tourNameTitle.setText("Tên địa điểm  - Ngày diễn ra");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Tìm kiếm khách hàng :");

        searchInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchInputKeyPressed(evt);
            }
        });

        resetButton.setBackground(new java.awt.Color(0, 102, 153));
        resetButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("Nhập lại");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(0, 102, 51));
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Tìm kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(0, 102, 51));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Thêm khách hàng vào chuyến đi");
        addButton.setPreferredSize(new java.awt.Dimension(269, 37));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(153, 0, 0));
        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Xóa khách hàng trong danh sách");
        deleteButton.setPreferredSize(new java.awt.Dimension(269, 37));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        pdfBtn.setBackground(new java.awt.Color(0, 102, 102));
        pdfBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pdfBtn.setForeground(new java.awt.Color(255, 255, 255));
        pdfBtn.setText("Xuất danh sách PDF");
        pdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfBtnActionPerformed(evt);
            }
        });

        excelBtn.setBackground(new java.awt.Color(0, 102, 102));
        excelBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        excelBtn.setForeground(new java.awt.Color(255, 255, 255));
        excelBtn.setText("Xuất danh sách Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                            .addComponent(tourNameTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(excelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(resetButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(screenTitle)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(screenTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tourNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(excelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        ManageTour manageTour = new ManageTour();
        manageTour.setLocationRelativeTo(null);
        manageTour.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void CustomerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTableMouseClicked
        try {
            int index = CustomerTable.getSelectedRow();
            if(index == -1){
                return;
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_CustomerTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        AddCustomerToTour screen = new AddCustomerToTour(selectedTour);
        screen.setLocationRelativeTo(null);
        dispose();
        screen.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        clearAllFields();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        handleSearchByKeyword();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Handle Enter key press
            handleSearchByKeyword();
        }
    }//GEN-LAST:event_searchInputKeyPressed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            int index = CustomerTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn khách hàng để thực hiện chức năng", "Thông báo");
                return;
            }
            String code = (String) CustomerTable.getValueAt(index, 0);
            
            Customer Customer = CustomerService.getCustomerByCustomerCode(code);
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này khỏi chuyến đi", "Xác nhận xóa");
            if(confirm == 0){
                System.out.println("checking Customer and tour id: " + Customer.getId() + ", " + selectedTour.getId());
                CustomerTourService.deleteCustomerTour(Customer.getId(), selectedTour.getId());
                this.selectedTour = tourService.getTourById(selectedTour.getId());
                System.out.println("SelectedTour: " + this.selectedTour);
                reinitialize();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        try {
            int DestinateId = tourService.getDestinateIdByTourId(selectedTour.getId());
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn vị trí để xuất file Excel");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                // Ensure the file has a .xlsx extension
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                File file = new File(filePath);

                // Check if the file already exists
                if (file.exists()) {
                    MessageDialog.showErrorDialog(this, "Tên file đã tồn tại! Vui lòng chọn tên khác.", "Lỗi");
                } else {
                    Workbook workbook = new XSSFWorkbook();
                    Tour tour = this.selectedTour;
                    String tourTitle = tour.getName() + " (Mã: " + tour.getCode() + ", công ty: " + DestinateService.getDestinateById(DestinateId).getName() + ") - Ngày: " + tour.getStartDate();
                    Sheet sheet = workbook.createSheet("Danh sách khách hàng tham gia chuyến tham quan " + tourTitle);

                    // Create header row
                    Row headerRow = sheet.createRow(0);

                    CellStyle headerStyle = workbook.createCellStyle();
                    headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    headerStyle.setAlignment(HorizontalAlignment.CENTER);

                    Font headerFont = workbook.createFont();
                    headerFont.setColor(IndexedColors.WHITE.getIndex());
                    headerFont.setBold(true);
                    headerStyle.setFont(headerFont);

                    String[] headers = {"Mã khách hàng", "Họ", "Tên", "Ngày sinh", "Team", "SĐT", "Email", "Địa chỉ", "Điểm đánh giá", "Xếp loại"};

                    for (int i = 0; i < headers.length; i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(headers[i]);
                        cell.setCellStyle(headerStyle);
                    }

                    // Set cell style with borders
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setBorderBottom(BorderStyle.THIN);
                    cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderTop(BorderStyle.THIN);
                    cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderLeft(BorderStyle.THIN);
                    cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderRight(BorderStyle.THIN);
                    cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

                    // Write data to the Excel sheet
                    List<CustomerTour> data = CustomerTourService.getAllCustomerToursByTourId(selectedTour.getId());
                    if (data != null) {
                        int rowNum = 1;
                        for (CustomerTour stuTour : data) {
                            Customer stu = CustomerService.getCustomerById(stuTour.getCustomerId());
                            Row row = sheet.createRow(rowNum++);
                            for (int i = 0; i < headers.length; i++) {
                                Cell cell = row.createCell(i);
                                cell.setCellValue(getCellValue(stu, stuTour, i));
                                cell.setCellStyle(cellStyle);
                            }
                        }
                    }

                    try ( FileOutputStream fileOut = new FileOutputStream(filePath)) {
                        workbook.write(fileOut);
                    } catch (Exception exs) {
                        throw exs;
                    }

                    workbook.close();

                    MessageDialog.showInfoDialog(this, "Xuất danh sách thành công! " + "\nNơi lưu: " + filePath, "Thông báo");
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra khi xuất Excel. Chi tiết: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_excelBtnActionPerformed

    private String getCellValue(Customer stu, CustomerTour stuTour, int columnIndex) throws Exception{
        switch (columnIndex) {
            case 0:
                return stu.getCode();
            case 1:
                return stu.getLastName();
            case 2:
                return stu.getFirstName();
            case 3:
                return stu.getBirthDate();
            case 4:
                return TeamService.getTeamNameById(stu.getTeamId()).getName();
            case 5:
                return stu.getPhoneNumber();
            case 6:
                return stu.getEmail();
            case 7:
                return stu.getAddress();
            case 8:
                return String.valueOf(stuTour.getRate());
            case 9:
                return stuTour.getResult();
            default:
                return "";
        }
    }
    
    private void pdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfBtnActionPerformed
        try {
            int DestinateId = tourService.getDestinateIdByTourId(selectedTour.getId());
            PDFExporter.exportTableToPDF(CustomerTable, "DANH SÁCH CỦA TOUR CẮM TRẠI CÓ " 
                    + "(MÃ: " + selectedTour.getCode().toUpperCase() + ", "
                    + "ĐỊA ĐIỂM: " + DestinateService.getDestinateById(DestinateId).getName().toUpperCase() 
                    + ") - NGÀY: " + selectedTour.getStartDate()
            );
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(jLabel2, "Có lỗi, chi tiết: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pdfBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageTourCustomer().setVisible(true);
            }
        });
    }
    
    private void reinitialize() {
        searchInput.setText("");
        loadTableData();
    }
    
    private void handleSearchByKeyword(){
        try {
            String keyword = searchInput.getText().trim();
            if (keyword.trim().equals("")) {
                MessageDialog.showInfoDialog(this, "Chưa có từ khóa tìm kiếm", "Thông báo");
                return;
            }
            List<CustomerTour> data = CustomerTourService.getAllCustomerToursByTourId(selectedTour.getId());
            tableModel.setRowCount(0);
            if (data != null) {
                for (CustomerTour stuTour : data) {
                    Customer stu = CustomerService.getCustomerById(stuTour.getCustomerId());
                    if (stu.getAddress().contains(keyword) || stu.getCode().contains(keyword) || stu.getFirstName().contains(keyword) || stu.getLastName().contains(keyword) || stu.getPhoneNumber().contains(keyword)) {
                        tableModel.addRow(
                                new Object[]{
                                    stu.getCode(),
                                    stu.getFirstName(),
                                    stu.getLastName(),
                                    TeamService.getTeamNameById(stu.getTeamId()).getName(),
                                    stu.getBirthDate(),
                                    stu.getPhoneNumber(),
                                    stu.getEmail(),
                                    stu.getAddress()
                                });
                    }
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
        }
    }
    
    private void clearAllFields(){
        searchInput.setText("");
    }
    
    private void loadTableData(){
        try {
            List<CustomerTour> data = CustomerTourService.getAllCustomerToursByTourId(selectedTour.getId());
            tableModel.setRowCount(0);
            if(data != null){
                for(CustomerTour stuTour : data){
                    Customer Customer = CustomerService.getCustomerById(stuTour.getCustomerId());
                    tableModel.addRow(new Object[]{
                        Customer.getCode(),
                        Customer.getLastName(),
                        Customer.getFirstName(),
                        Customer.getBirthDate(),
                        TeamService.getTeamNameById(Customer.getTeamId()).getName(),
                        Customer.getPhoneNumber(),
                        Customer.getEmail(),
                        Customer.getAddress(),
                        stuTour.getRate(),
                        stuTour.getResult()
                    });
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã khách hàng", "Họ", "Tên", "Ngày sinh", "Team", "SĐT", "Email", "Địa chỉ", "Điểm đánh giá", "Xếp loại"});
        CustomerTable.setModel(tableModel);
        loadTableData();
    }

    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton excelBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pdfBtn;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel screenTitle;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JLabel tourNameTitle;
    // End of variables declaration//GEN-END:variables
}
