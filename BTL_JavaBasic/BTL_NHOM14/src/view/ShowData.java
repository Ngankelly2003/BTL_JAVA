package view;

import exception.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.*;

public class ShowData extends javax.swing.JFrame {
    
    TransmittedDataShowData dataOfShowData;
    private GuideService GuideService;
    private CustomerService CustomerService;
    private CustomerTourService CustomerTourService;
    private TeamService TeamService;
    private TourService tourService;
    private DestinateService DestinateService;

    public ShowData(TransmittedDataShowData data){
        
        GuideService = new GuideService();
        CustomerService = new CustomerService();
        CustomerTourService = new CustomerTourService();
        TeamService = new TeamService();
        DestinateService = new DestinateService();
        tourService = new TourService();
        try {
            this.dataOfShowData = data;
            initComponents();
            setLocationRelativeTo(null);
            checkAndInitializeTable();
            if (dataOfShowData.getTypeData().equalsIgnoreCase("toursOfGuides") || dataOfShowData.getTypeData().equalsIgnoreCase("toursOfCustomers")) {
                clearDataButton.setText("Hủy chuyến tham quan");
            }
            if (dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTookPlaceTours")) {
                clearDataButton.setText("Đánh giá");
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra! Chi tiết: " + ex.getMessage(), "lỗi");
            ex.printStackTrace();
        }
    }
    
    private void checkAndInitializeTable() {
        try {
            if (dataOfShowData.getTypeData() != null && dataOfShowData.getBackToPage() != null) {
                tableModel = new DefaultTableModel();
                if (dataOfShowData.getTypeData().equalsIgnoreCase("Guides")) {
                    titleMainLabel.setText("Danh sách hướng dẫn viên");
                    tableModel.setColumnIdentifiers(new String[]{"Mã giáo viên", "Họ tên",
                        "Địa chỉ", "Điện thoại", "", "Ngày sinh"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("Customers")) {
                    titleMainLabel.setText("Danh sách sinh viên được quản lý");
                    tableModel.setColumnIdentifiers(new String[]{"Mã khách hàng", "Họ", "Tên", "Địa chỉ", "SĐT", "", "Ngày sinh", "Lớp"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("Destinates")) {
                    titleMainLabel.setText("Danh sách doanh nghiệp liên kết với nhà trường");
                    tableModel.setColumnIdentifiers(new String[]{"Mã doanh nghiệp", "Doanh nghiệp", "Địa chỉ",
                        "", "Điện thoại", "Mô tả"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("tours")) {
                    titleMainLabel.setText("Danh sách các chuyến tham quan được tổ chức");
                    tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Thời gian", "Mô tả",
                        "Số lượng", "Người đại diện", "Công ty", "Giáo viên"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTours")) {
                    titleMainLabel.setText("Danh sách sinh viên của chuyến tham quan");
                    tableModel.setColumnIdentifiers(new String[]{"Mã khách hàng", "Họ", "Tên", "Địa chỉ", "SĐT", "", "Ngày sinh","Lớp"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("toursOfGuides")) {
                    Guide Guide = GuideService.getGuideById(dataOfShowData.getGuideId());
                    titleMainLabel.setText("DANH SÁCH CÁC CHUYẾN THAM QUAN CỦA HƯỚNG DẪN VIÊN " + Guide.getLastName().toUpperCase() + " " + Guide.getFirstName().toUpperCase());
                    tableModel.setColumnIdentifiers(new String[]{"Mã chuyến tham quan", "Tên chuyến tham quan", "Ngày tham quan", "Doanh nghiệp chủ quản", "Số lượng sinh viên tham gia"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("toursOfCustomers")) {
                    Customer stu = CustomerService.getCustomerById(dataOfShowData.getCustomerId());
                    titleMainLabel.setText("DANH SÁCH CÁC CHUYẾN THAM QUAN CỦA SINH VIÊN " + stu.getLastName().toUpperCase() + " " + stu.getFirstName().toUpperCase());
                    tableModel.setColumnIdentifiers(new String[]{"Mã chuyến tham quan", "Tên chuyến tham quan", "Mô tả", "Ngày bắt đầu", "Số ghế ", "Tên doanh nghiệp", "Tên giáo viên", "Người đại diện"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTookPlaceTours")) {
                    titleMainLabel.setText("Danh sách sinh viên của chuyến tham quan");
                    tableModel.setColumnIdentifiers(new String[]{"Mã khách hàng", "Họ", "Tên", "Địa chỉ", "SĐT", "", "Ngày sinh", "Điểm đánh giá"});
                }
                dataTable.setModel(tableModel);
                loadTableData();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(search, "Có lỗi, chi tiết: " + ex.getMessage(), "Lỗi");
        }
    }
    private void loadTableData() {
        try {
            if(dataOfShowData.getTypeData() != null && dataOfShowData.getBackToPage() != null){
                tableModel.setRowCount(0);
            }
            if(dataOfShowData.getTypeData().equalsIgnoreCase("Customers")){
                loadCustomersData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTours")){
                loadCustomerToursData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("tours")){
                loadToursData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("Destinates")){
                loadDestinatesData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("Guides")){
                loadGuidesData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfGuides")){
                loadTableToursOfGuideData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfCustomers")){
                loadTableToursOfCustomerData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTookPlaceTours")){
                loadCustomersAwaitingFeedback("=");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ShowData() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleMainLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        searchInput = new javax.swing.JTextField();
        search = new javax.swing.JLabel();
        searchButton = new javax.swing.JToggleButton();
        clearDataButton = new javax.swing.JToggleButton();
        exportPDFFileButton = new javax.swing.JToggleButton();
        exportExcelFileButton = new javax.swing.JToggleButton();
        backButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleMainLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleMainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleMainLabel.setText("Danh sách thông tin");
        titleMainLabel.setToolTipText("");

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(dataTable);

        searchInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        search.setText("Tìm kiếm theo tên:");

        searchButton.setBackground(new java.awt.Color(0, 102, 153));
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Tìm kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        clearDataButton.setBackground(new java.awt.Color(102, 153, 0));
        clearDataButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clearDataButton.setForeground(new java.awt.Color(255, 255, 255));
        clearDataButton.setText("Nhập lại");
        clearDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDataButtonActionPerformed(evt);
            }
        });

        exportPDFFileButton.setBackground(new java.awt.Color(0, 102, 102));
        exportPDFFileButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exportPDFFileButton.setForeground(new java.awt.Color(255, 255, 255));
        exportPDFFileButton.setText("Xuất danh sách PDF");
        exportPDFFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPDFFileButtonActionPerformed(evt);
            }
        });

        exportExcelFileButton.setBackground(new java.awt.Color(0, 102, 102));
        exportExcelFileButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exportExcelFileButton.setForeground(new java.awt.Color(255, 255, 255));
        exportExcelFileButton.setText("Xuất danh sách Excel");
        exportExcelFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelFileButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(153, 0, 0));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Trở lại trang trước");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchInput, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exportExcelFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(exportPDFFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleMainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titleMainLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search)
                        .addGap(18, 18, 18)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportPDFFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(exportExcelFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDataButtonActionPerformed
        try {
            if (dataOfShowData.getTypeData().equalsIgnoreCase("toursOfCustomers")){
                int index = dataTable.getSelectedRow();
                if (index == -1) {
                    MessageDialog.showInfoDialog(this, "Vui lòng chọn chuyến tham quan mà bạn muốn xóa", "Thông báo");
                    return;
                }
                String tourCode = (String) dataTable.getValueAt(index, 0);
                System.out.println("TourCode: " + tourCode);
                int tourId = tourService.getIdByTourCode(tourCode);
                System.out.println("TourId: " + tourId);
                System.out.println("CustomerId: " + dataOfShowData.getCustomerId());
                int CustomerId = dataOfShowData.getCustomerId();
                CustomerTourService.deleteCustomerTour(CustomerId, tourId);
                MessageDialog.showInfoDialog(this, "Xóa chuyến tham quan thành công", "Thông báo");
                loadTableToursOfCustomerData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfGuides")){
                int index = dataTable.getSelectedRow();
                if(index == -1){
                    MessageDialog.showInfoDialog(this, "Vui lòng chọn chuyến tham quan mà bạn muốn xóa", "Thông báo");
                    return;
                }
                String tourCode = (String) dataTable.getValueAt(index, 0);
                int tourId = tourService.getIdByTourCode(tourCode);
                int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa chuyến tham quan này không", "Thông báo");
                if(confirm == 0){
                    tourService.updateGuideIdByTourId(tourId);
                    loadTableToursOfGuideData();
                }
            }
            else if (dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTookPlaceTours")) {
                try {
                    int index = dataTable.getSelectedRow();
                    if (index == -1) {
                        MessageDialog.showInfoDialog(this, "Vui lòng chọn sinh viên bạn muốn đánh giá", "Thông báo");
                        return;
                    }
                    String CustomerCode = (String) dataTable.getValueAt(index, 0);
                    int CustomerId = CustomerService.getIdByCustomer(CustomerCode);
                    Customer selectCustomer = CustomerService.getCustomerById(CustomerId);
                    System.out.println("Customer: " + selectCustomer);
                    dispose();

                    Tour selectTour = tourService.getTourById(dataOfShowData.getTourId());
                    System.out.println("Tour: " + selectTour);
                    RateCustomerResult screen = new RateCustomerResult(selectTour, selectCustomer,true);
                    screen.setLocationRelativeTo(null);
                    screen.setVisible(true);
                } catch (Exception ex) {
                    MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage(), "Lỗi");
                    ex.printStackTrace();
                }
            }else{
                searchInput.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_clearDataButtonActionPerformed

    private void exportPDFFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPDFFileButtonActionPerformed
        try {
            String title = "";
            if (dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTours")) {
                title = "DANH SÁCH SINH VIÊN CỦA CHUYẾN THAM QUAN";
            }
            dataTable.setModel(tableModel);
            loadTableData();
            PDFExporter.exportTableToPDF(dataTable, title);
        } catch (Exception e) {
            MessageDialog.showErrorDialog(search, "Có lỗi, chi tiết: " + e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_exportPDFFileButtonActionPerformed

    private void exportExcelFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelFileButtonActionPerformed
        try {
            if (dataOfShowData.getTypeData().equalsIgnoreCase("toursOfGuides")) {
                Tour tour = tourService.getTourByGuideId(dataOfShowData.getGuideId());
                Guide Guide = GuideService.getGuideById(dataOfShowData.getGuideId());
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
                        String tourTitle = tour.getName() + " (Mã: " + Guide.getCode() + ", Tên giáo viên: " + Guide.getLastName() +" "+Guide.getFirstName() + ") ";
                        Sheet sheet = workbook.createSheet("Danh sách các chuyến tham quan mà giáo viên tham gia " + tourTitle);

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

                        String[] headers = {"Mã chuyến tham quan", "Tên chuyến tham quan", "Ngày tham quan", "Doanh nghiệp chủ quản", "Số lượng sinh viên tham gia"};

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
                        List<Tour> tours = tourService.getToursByGuideId(dataOfShowData.getGuideId());
                        if (tours != null) {
                            int rowNum = 1;
                            for (Tour GuideTour : tours) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfTourGuide(GuideTour, i));
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
            } else if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfCustomers")){
                Tour tour = tourService.getTourByCustomerId(dataOfShowData.getCustomerId());
                Customer Customer = CustomerService.getCustomerById(dataOfShowData.getCustomerId());
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
                        String tourTitle = tour.getName() + " (Mã: " + Customer.getCode() + ", Tên sinh viên: " + Customer.getLastName() +" "+Customer.getFirstName() + ") ";
                        Sheet sheet = workbook.createSheet("Danh sách các chuyến tham quan mà sinh viên tham gia " + tourTitle);

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

                        String[] headers = {"Mã chuyến tham quan", 
                            "Tên chuyến tham quan", 
                            "Mô tả", 
                            "Ngày bắt đầu", 
                            "Số ghế ", 
                            "Tên doanh nghiệp", 
                            "Tên giáo viên", 
                            "Người đại diện"};

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
                        List<Tour> tours = tourService.getToursByCustomerId(dataOfShowData.getCustomerId());
                        if (tours != null) {
                            int rowNum = 1;
                            for (Tour CustomerTour : tours) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfTourCustomer(CustomerTour, i));
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
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("Customers")){
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
                        Sheet sheet = workbook.createSheet("Danh sách sinh viên được quản lý ");

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

                        String[] headers = {"Mã khách hàng", 
                            "Họ", 
                            "Tên", 
                            "Địa chỉ", 
                            "SĐT", 
                            "", 
                            "Ngày sinh", 
                            "Lớp"};

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
                        List<Customer> Customers = CustomerService.getAllCustomers();
                        if (Customers != null) {
                            int rowNum = 1;
                            for (Customer CustomerSelect : Customers) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfCustomers(CustomerSelect, i));
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
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("Destinates")){
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
                        Sheet sheet = workbook.createSheet("Danh sách doanh nghiệp liên kết với nhà trường ");

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

                        String[] headers = {
                            "Mã doanh nghiệp", 
                            "Tên doanh nghiệp", 
                            "Địa chỉ", 
                            "", 
                            "SĐT", 
                            "Mô tả"
                        };

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
                        List<Destinate> Destinates = DestinateService.getAllDestinate();
                        if (Destinates != null) {
                            int rowNum = 1;
                            for (Destinate DestinateSelect : Destinates) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfDestinates(DestinateSelect, i));
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
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("Guides")){
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
                        Sheet sheet = workbook.createSheet("Danh sách giáo viên đại diện nhà trường ");

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

                        String[] headers = {
                            "Mã giáo viên", 
                            "Họ tên", 
                            "Địa chỉ", 
                            "SĐT", 
                            "", 
                            "Ngày sinh"
                        };

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
                        List<Guide> Guides = GuideService.getAllGuides();
                        if (Guides != null) {
                            int rowNum = 1;
                            for (Guide GuideSelect : Guides) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfGuides(GuideSelect, i));
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
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("tours")){
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
                        Sheet sheet = workbook.createSheet("Danh sách các chuyến tham quan được tổ chức");

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

                        String[] headers = {
                            "Mã chuyến", 
                            "Tên chuyến", 
                            "Thời gian", 
                            "Mô tả",
                            "Số lượng", 
                            "Người đại diện", 
                            "Công ty", 
                            "Giáo viên"
                        };

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
                        List<Tour> tours = tourService.getAllTours();
                        if (tours != null) {
                            int rowNum = 1;
                            for (Tour tourSelect : tours) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfTours(tourSelect, i));
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
            }
            
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTours")){
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
                        Sheet sheet = workbook.createSheet("Danh sách sinh viên tham gia chuyến đi");

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

                        String[] headers = {
                            "Mã khách hàng", 
                            "Họ", 
                            "Tên", 
                            "Địa chỉ",
                            "SĐT", 
                            "", 
                            "Ngày sinh", 
                            "Lớp"
                        };
                        
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
                        List<Customer> Customers_data = CustomerService.getCustomersByTourId(dataOfShowData.getTourId());
                        if (Customers_data != null) {
                            int rowNum = 1;
                            for (Customer CustomerSelect : Customers_data) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfCustomerTours(CustomerSelect, i));
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
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTookPlaceTours")){
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
                        Sheet sheet = workbook.createSheet("Danh sách sinh viên của chuyến tham quan");

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

                        String[] headers = {
                            "Mã khách hàng", 
                            "Họ", 
                            "Tên", 
                            "Địa chỉ",
                            "SĐT", 
                            "", 
                            "Ngày sinh", 
                            "Điểm đánh giá"
                        };
                        
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
                        
                        List<Customer> Customers = CustomerService.getCustomersByTourId(dataOfShowData.getTourId());
                        if (Customers != null) {
                            int rowNum = 1;
                            for (Customer CustomerSelect : Customers) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfCustomerTookPlaceTours(CustomerSelect, i));
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_exportExcelFileButtonActionPerformed

    private String getCellValueOfTourGuide(Tour tour, int columnIndex)throws Exception{
        switch (columnIndex) {
            case 0:
                return tour.getCode();
            case 1:
                return tour.getName();
            case 2:
                return tour.getStartDate();
            case 3:
                return tourService.getDestinateNameById(tour.getDestinateId());
            case 4:
                return String.valueOf(CustomerTourService.getNumberOfCustomers(tour.getId()));
            default:
                return "";
        }
    }
    
    private String getCellValueOfTourCustomer(Tour tour , int columnIndex) throws Exception{
        switch (columnIndex) {
            case 0:
                return tour.getCode();
            case 1:
                return tour.getName();
            case 2:
                return tour.getDescription();
            case 3: 
                return tour.getStartDate();
            case 4:
                return String.valueOf(tour.getAvailables());
            case 5:
                return tourService.getDestinateNameById(tour.getDestinateId());
            case 6:
                return tourService.getGuideNameById(tour.getGuideId());
            case 7:
                return tour.getPresentator();
            default:
                return "";
        }
    }
    
    private String getCellValueOfCustomers(Customer Customer , int columnIndex) throws Exception{
        switch(columnIndex){
            case 0:
                return Customer.getCode();
            case 1:
                return Customer.getLastName();
            case 2:
                return Customer.getFirstName();
            case 3:
                return Customer.getAddress();
            case 4:
                return Customer.getPhoneNumber();
            case 5:
                return Customer.getEmail();
            case 6:
                return Customer.getBirthDate();
            case 7:
                return CustomerService.getCustomerTeamNameById(Customer.getTeamId());
            default:
                return "";
        }
    }
    
    private String getCellValueOfDestinates(Destinate Destinate , int columnIndex) throws Exception{
        switch(columnIndex){
            case 0:
                return Destinate.getCode();
            case 1:
                return Destinate.getName();
            case 2:
                return Destinate.getAddress();
            case 3:
                return Destinate.getTimeStay();
            case 4:
                return Destinate.getSleepPlace();
            case 5:
                return Destinate.getDescription();
            default:
                return "";
        }
    }
    
    private String getCellValueOfGuides(Guide Guide , int columnIndex) throws Exception{
        switch(columnIndex){
            case 0: 
                return Guide.getCode();
            case 1:
                return Guide.getLastName() + " " + Guide.getFirstName();
            case 2:
                return Guide.getAddress();
            case 3:
                return Guide.getPhoneNumber();
            case 4:
                return Guide.getEmail();
            case 5:
                return Guide.getBirthDate();
            default:
                return "";
        }
        
    }
    
    private String getCellValueOfTours(Tour tour , int columnIndex) throws Exception{
        switch (columnIndex) {
        case 0:
            return tour.getCode();
        case 1:
            return tour.getName();
        case 2:
            return tour.getStartDate();
        case 3: 
            return tour.getDescription();
        case 4:
            return String.valueOf(tour.getAvailables());
        case 5:
            return tour.getPresentator();
        case 6:
            return tourService.getDestinateNameById(tour.getDestinateId());
        case 7:
            return tourService.getGuideNameById(tour.getGuideId());
        default:
            return "";
        }
    }
    
    private String getCellValueOfCustomerTours(Customer Customer , int columnIndex) throws Exception{
        
        switch(columnIndex){
            case 0:
                return Customer.getCode();
            case 1:
                return Customer.getLastName();
            case 2:
                return Customer.getFirstName();
            case 3:
                return Customer.getAddress();
            case 4:
                return Customer.getPhoneNumber();
            case 5:
                return Customer.getEmail();
            case 6:
                return Customer.getBirthDate();
            case 7:
                return CustomerService.getCustomerTeamNameById(Customer.getTeamId());
            default:
                return "";
        }
    }
    
    private String getCellValueOfCustomerTookPlaceTours(Customer Customer , int columnIndex) throws Exception{
        switch(columnIndex){
        case 0:
            return Customer.getCode();
        case 1:
            return Customer.getLastName();
        case 2:
            return Customer.getFirstName();
        case 3:
            return Customer.getAddress();
        case 4:
            return Customer.getPhoneNumber();
        case 5:
            return Customer.getEmail();
        case 6:
            return Customer.getBirthDate();
        case 7:
            return String.valueOf(CustomerTourService.geCustomerTourByCustomerId(Customer.getId()).getRate());
        default:
            return "";
        }
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dispose();
        if(dataOfShowData.getBackToPage().equalsIgnoreCase("managetoursofGuide")){
            try {
                List<Tour> tours = tourService.getToursByGuideId(dataOfShowData.getGuideId());
                Guide Guide = GuideService.getGuideById(dataOfShowData.getGuideId());
                ManageToursOfGuide manageToursOfGuide = new ManageToursOfGuide();
                manageToursOfGuide.setTours(tours);
                manageToursOfGuide.setGuideID(dataOfShowData.getGuideId());
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
        }else if (dataOfShowData.getBackToPage().equalsIgnoreCase("home")) {
            AdminHome home = new AdminHome();
            home.setLocationRelativeTo(null);
            home.setVisible(true);
        }else if(dataOfShowData.getBackToPage().equalsIgnoreCase("GuideAndCustomerHome")){
            try {
                dispose();
                GuideAndCustomerHome GuideAndCustomerHome = null;
                if(dataOfShowData.isIsCustomer()){
                    Customer Customer = CustomerService.getCustomerById(dataOfShowData.getCustomerId());
                    GuideAndCustomerHome = new GuideAndCustomerHome(Customer);
                }else {
                    Guide Guide = GuideService.getGuideById(dataOfShowData.getGuideId());
                    GuideAndCustomerHome = new GuideAndCustomerHome(Guide);
                }
                GuideAndCustomerHome.setLocationRelativeTo(null);
                GuideAndCustomerHome.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            String keyword = searchInput.getText().trim();
            int count = 0;
            if (keyword.trim().equals("")) {
                checkAndInitializeTable();
                return;
            }
            
            if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfGuides")){
                    List<Tour> tour_data = tourService.getToursByGuideId(dataOfShowData.getGuideId());
                    List<Destinate> Destinate_data = DestinateService.getAllDestinate();
                    List<Guide> Guide_data = GuideService.getAllGuides();
                    tableModel.setRowCount(0);
                    if (tour_data != null) {
                        for (Tour tour : tour_data) {
                            String DestinateName = "";
                            String GuideName = "";
                            int numberOfCustomers = CustomerTourService.getNumberOfCustomers(tour.getId());
                            for (Destinate comp : Destinate_data) {
                                if (comp.getId() == tour.getDestinateId()) {
                                    DestinateName = comp.getName();
                                }
                            }
                            for (Guide tea : Guide_data) {
                                if (tea.getId() == tour.getGuideId()) {
                                    GuideName = tea.getLastName() + " " + tea.getFirstName();
                                }
                            }
                            if (keyword.equalsIgnoreCase(DestinateName) || keyword.equalsIgnoreCase(tour.getName()) || keyword.equalsIgnoreCase(tour.getCode())) {
                                tableModel.addRow(new Object[]{
                                tour.getCode(), 
                                tour.getName(), 
                                tour.getStartDate(),
                                DestinateName,
                                numberOfCustomers
                                });
                            } else {
                                count++;
                            }
                        }
                        if (count == tour_data.size()) {
                            MessageDialog.showInfoDialog(dataTable, "Không tìm thấy chuyến tham quan doanh nghiệp bạn cần tìm", "Thông báo");
                            checkAndInitializeTable();
                        }
                    }
                }
                
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfCustomers")){
                List<Tour> tour_data = tourService.getToursByCustomerId(dataOfShowData.getCustomerId());
                    List<Destinate> Destinate_data = DestinateService.getAllDestinate();
                    List<Guide> Guide_data = GuideService.getAllGuides();
                    tableModel.setRowCount(0);
                    if (tour_data != null) {
                        for (Tour tour : tour_data) {
                            String DestinateName = "";
                            String GuideName = "";
                            for (Destinate comp : Destinate_data) {
                                if (comp.getId() == tour.getDestinateId()) {
                                    DestinateName = comp.getName();
                                }
                            }
                            for (Guide tea : Guide_data) {
                                if (tea.getId() == tour.getGuideId()) {
                                    GuideName = tea.getLastName() + " " + tea.getFirstName();
                                }
                            }
                            if (keyword.equalsIgnoreCase(DestinateName) || keyword.equalsIgnoreCase(tour.getName()) || keyword.equalsIgnoreCase(tour.getCode())) {
                                tableModel.addRow(new Object[]{
                                tour.getCode(), 
                                tour.getName(), 
                                tour.getDescription(),
                                tour.getStartDate(),
                                tour.getAvailables(),
                                DestinateName,
                                GuideName,
                                tour.getPresentator()
                                });
                            } else {
                                count++;
                            }
                        }
                        if (count == tour_data.size()) {
                            MessageDialog.showInfoDialog(dataTable, "Không tìm thấy chuyến tham quan doanh nghiệp bạn cần tìm", "Thông báo");
                            checkAndInitializeTable();
                        }
                    }
            }
            else if (dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTours")) {
                Tour tour = tourService.getTourById(dataOfShowData.getTourId());
                if (tour != null) {
                    List<CustomerTour> data_Customers_tour = CustomerTourService.getAllCustomerToursByTourId(tour.getId());
                    List<Customer> data = CustomerService.getCustomersByTourId(tour.getId());
                            
                    tableModel.setRowCount(0);
                    if (data != null && data_Customers_tour != null) {
                        for (Customer stu : data) {
                            String TeamName = CustomerService.getCustomerTeamNameById(stu.getTeamId());
                            for (CustomerTour item : data_Customers_tour) {
                                if (stu.getId() == item.getCustomerId()) {
                                    if (stu.getFirstName().equalsIgnoreCase(keyword) || stu.getLastName().equalsIgnoreCase(keyword) || keyword.equalsIgnoreCase(stu.getLastName() + stu.getFirstName()) || keyword.equalsIgnoreCase(stu.getCode())) {
                                        tableModel.addRow(new Object[]{
                                            stu.getCode(), 
                                            stu.getLastName(), 
                                            stu.getFirstName(), 
                                            stu.getAddress(), 
                                            stu.getPhoneNumber(), 
                                            stu.getEmail(), 
                                            stu.getBirthDate(),
                                            TeamName
                                        });
                                    } else {
                                        count++;
                                    }
                                }
                            }
                        }
                        if (count == data_Customers_tour.size()) {
                            MessageDialog.showInfoDialog(dataTable, "Không tìm thấy sinh viên bạn cần tìm", "Thông báo");
                            checkAndInitializeTable();
                        }
                    }
                }
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("tours")){
                List<Tour> tour_data = tourService.getAllTours();
                List<Destinate> Destinate_data = DestinateService.getAllDestinate();
                List<Guide> Guide_data = GuideService.getAllGuides();
                tableModel.setRowCount(0);
                if (tour_data != null) {
                    for (Tour tour : tour_data) {
                        String DestinateName = "";
                        String GuideName = "";
                        for (Destinate comp : Destinate_data) {
                            if (comp.getId() == tour.getDestinateId()) {
                                DestinateName = comp.getName();
                            }
                        }
                        for (Guide tea : Guide_data) {
                            if (tea.getId() == tour.getGuideId()) {
                                GuideName = tea.getLastName() + " " + tea.getFirstName();
                            }
                        }
                        if (keyword.equalsIgnoreCase(GuideName) || keyword.equalsIgnoreCase(DestinateName) || keyword.equalsIgnoreCase(tour.getName()) || keyword.equalsIgnoreCase(tour.getCode())) {
                            tableModel.addRow(new Object[]{
                            tour.getCode(), 
                            tour.getName(), 
                            tour.getStartDate(),
                            tour.getDescription(),
                            tour.getAvailables(),
                            tour.getPresentator(), 
                            DestinateName, 
                            GuideName 
                            });
                        } else {
                            count++;
                        }
                    }
                    if (count == tour_data.size()) {
                        MessageDialog.showInfoDialog(dataTable, "Không tìm thấy chuyến tham quan doanh nghiệp bạn cần tìm", "Thông báo");
                        checkAndInitializeTable();
                    }
                }
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("Customers")){
                List<Customer> data = CustomerService.getAllCustomers();
                tableModel.setRowCount(0);
                if (data != null) {
                    for (Customer stu : data) {
                        if (stu.getFirstName().equalsIgnoreCase(keyword) || stu.getLastName().equalsIgnoreCase(keyword) || keyword.equalsIgnoreCase(stu.getLastName() + stu.getFirstName()) || keyword.equalsIgnoreCase(stu.getCode())) {
                            tableModel.addRow(new Object[]{
                                stu.getCode(), 
                                stu.getLastName(), 
                                stu.getFirstName(), 
                                stu.getAddress(), 
                                stu.getPhoneNumber(), 
                                stu.getEmail(), 
                                stu.getBirthDate(),
                                TeamService.getTeamNameById(stu.getTeamId())
                            });
                        } else {
                            count++;
                        }
                    }
                    if (count == data.size()) {
                        MessageDialog.showInfoDialog(dataTable, "Không tìm thấy sinh viên bạn cần tìm", "Thông báo");
                        checkAndInitializeTable();
                    }
                }
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("Destinates")){
                List<Destinate> data = DestinateService.getAllDestinate();
                tableModel.setRowCount(0);
                if(data != null){
                    for(Destinate com : data){
                        if (com.getName().equalsIgnoreCase(keyword) || keyword.equalsIgnoreCase(com.getCode())) {
                            tableModel.addRow(new Object[]{
                                com.getCode(), 
                                com.getName(), 
                                com.getAddress(),
                                com.getTimeStay(), 
                                com.getSleepPlace(),
                                com.getDescription()});
                        } else {
                            count++;
                        }
                    }
                    if (count == data.size()) {
                        MessageDialog.showInfoDialog(dataTable, "Không tìm thấy doanh nghiệp bạn cần tìm", "Thông báo");
                        checkAndInitializeTable();
                    }
                }
            }
            else if (dataOfShowData.getTypeData().equalsIgnoreCase("Guides")){
                List<Guide> data = GuideService.getAllGuides();
                tableModel.setRowCount(0);
                if(data != null){
                    for(Guide tea : data){
                        if(tea.getFirstName().equalsIgnoreCase(keyword) || tea.getLastName().equalsIgnoreCase(keyword) || keyword.equalsIgnoreCase(tea.getLastName() + tea.getFirstName()) || keyword.equalsIgnoreCase(tea.getCode())){
                            tableModel.addRow(new Object[]{
                                tea.getCode(),
                                tea.getLastName() + " " +tea.getFirstName(),
                                tea.getAddress(),
                                tea.getPhoneNumber(),
                                tea.getEmail(),
                                tea.getBirthDate()
                            });
                        }else{
                            count++;
                        }
                    }
                    if(count == data.size()){
                        MessageDialog.showInfoDialog(dataTable, "Không tìm thấy giáo viên bạn cần tìm", "Thông báo");
                        checkAndInitializeTable();
                    }
                }
            }
            else if (dataOfShowData.getTypeData().equalsIgnoreCase("CustomerTookPlaceTours")) {
                Tour tour = tourService.getTourById(dataOfShowData.getTourId());
                if (tour != null) {
                    List<CustomerTour> data_Customers_tour = CustomerTourService.getAllCustomerToursByTourId(tour.getId());
                    List<Customer> data = CustomerService.getAllCustomers();
                    tableModel.setRowCount(0);
                    if (data != null && data_Customers_tour != null) {
                        for (Customer stu : data) {
                            for (CustomerTour item : data_Customers_tour) {
                                if (stu.getId() == item.getCustomerId()) {
                                    if (stu.getFirstName().equalsIgnoreCase(keyword) || stu.getLastName().equalsIgnoreCase(keyword) || keyword.equalsIgnoreCase(stu.getLastName() + stu.getFirstName()) || keyword.equalsIgnoreCase(stu.getCode())) {
                                        tableModel.addRow(new Object[]{
                                            stu.getCode(), 
                                            stu.getLastName(), 
                                            stu.getFirstName(), 
                                            stu.getAddress(), 
                                            stu.getPhoneNumber(), 
                                            stu.getEmail(), 
                                            stu.getBirthDate()
                                        });
                                    } else {
                                        count++;
                                    }
                                }
                            }
                        }
                        if (count == data_Customers_tour.size()) {
                            MessageDialog.showInfoDialog(dataTable, "Không tìm thấy sinh viên bạn cần tìm", "Thông báo");
                            checkAndInitializeTable();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchButtonActionPerformed
    private DefaultTableModel tableModel;

    private void loadTableToursOfCustomerData() throws Exception{
        try {
            List<Tour> data = tourService.getToursByCustomerId(dataOfShowData.getCustomerId());
            tableModel.setRowCount(0);
            if(data != null){
                for(Tour tour : data){
                    int DestinateId = tourService.getDestinateIdByTourId(tour.getId());
                    Destinate Destinate = DestinateService.getDestinateById(DestinateId);
                    String GuideName = tourService.getGuideNameById(tour.getGuideId());
                    tableModel.addRow(new Object[]{
                        tour.getCode(),
                        tour.getName(),
                        tour.getDescription(),
                        tour.getStartDate(),
                        tour.getAvailables(),
                        Destinate.getName(),
                        GuideName,
                        tour.getPresentator()
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadTableToursOfGuideData() throws Exception{
        try {
            List<Tour> data = tourService.getToursByGuideId(dataOfShowData.getGuideId());
            tableModel.setRowCount(0);
            if(data != null){
                for(Tour tour : data){
                    int DestinateId = tourService.getDestinateIdByTourId(tour.getId());
                    Destinate Destinate = DestinateService.getDestinateById(DestinateId);
                    int numberOfCustomers = CustomerTourService.getNumberOfCustomers(tour.getId());
                    tableModel.addRow(new Object[]{
                        tour.getCode(),tour.getName(),tour.getStartDate(),
                        Destinate.getName(),
                        numberOfCustomers
                    });
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadCustomersData() throws Exception {
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
    private void loadCustomerToursData() throws Exception{
        List<Customer> Customers_data = CustomerService.getCustomersByTourId(dataOfShowData.getTourId());
        if(Customers_data != null){
            for(Customer stu : Customers_data){
                Team Team = TeamService.getTeamNameById(stu.getTeamId());
                String TeamName = Team.getName();
                tableModel.addRow(new Object[]{stu.getCode(), 
                    stu.getLastName(), 
                    stu.getFirstName(), 
                    stu.getAddress(), 
                    stu.getPhoneNumber(), 
                    stu.getEmail(), 
                    stu.getBirthDate(), 
                    TeamName});
            }
        }
    }
    
    private void loadToursData() throws Exception{
        try {
            List<Tour> tour_data = tourService.getAllTours();
            tableModel.setRowCount(0);
            if(tour_data != null){
                for (Tour tour : tour_data) {
                String DestinateName = tourService.getDestinateNameById(tour.getDestinateId());
                
                String GuideName = "";
                if (tour.getGuideId() > 0) {
                    GuideName = tourService.getGuideNameById(tour.getGuideId());
                }
                tableModel.addRow(new Object[]{
                        tour.getCode(), 
                        tour.getName(),
                        tour.getStartDate(), 
                        tour.getDescription(),
                        tour.getAvailables(),
                        tour.getPresentator(), 
                        DestinateName, 
                        GuideName
                });
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    private void loadDestinatesData() throws Exception{
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
            e.printStackTrace();
        }
    } 
    
    private void loadGuidesData() throws Exception{
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
                    });
                }
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
            e.printStackTrace();
        }
    }
    
    private void loadCustomersAwaitingFeedback(String type) throws Exception {
        Tour tour = tourService.getTourById(dataOfShowData.getTourId());
        List<CustomerTour> data = CustomerTourService.getAllCustomerToursByTourId(tour.getId());
        List<Customer> Customers = CustomerService.getCustomersByTourId(dataOfShowData.getTourId());

        if (data != null && Customers != null && !data.isEmpty()) {
            for (Customer stu : Customers) {
                CustomerTour CustomerTour = CustomerTourService.geCustomerTourByCustomerId(stu.getId());
                    tableModel.addRow(new Object[]{
                        stu.getCode(), 
                        stu.getLastName(), 
                        stu.getFirstName(), 
                        stu.getAddress(), 
                        stu.getPhoneNumber(), 
                        stu.getEmail(), 
                        stu.getBirthDate(), 
                        CustomerTour.getRate()
                    });
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton backButton;
    private javax.swing.JToggleButton clearDataButton;
    private javax.swing.JTable dataTable;
    private javax.swing.JToggleButton exportExcelFileButton;
    private javax.swing.JToggleButton exportPDFFileButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel search;
    private javax.swing.JToggleButton searchButton;
    private javax.swing.JTextField searchInput;
    private javax.swing.JLabel titleMainLabel;
    // End of variables declaration//GEN-END:variables

}
