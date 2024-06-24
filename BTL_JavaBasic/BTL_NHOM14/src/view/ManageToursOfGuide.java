package view;

import exception.MessageDialog;
import exception.PDFExporter;
import exception.TransmittedDataShowData;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
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
import services.DestinateService;
import services.CustomerTourService;
import services.GuideService;
import services.TourService;

public class ManageToursOfGuide extends javax.swing.JFrame {

    
    private String imagePath = "";
    private Guide selectGuide;
    private List<Tour> tours = new ArrayList<>();
    private DestinateService DestinateService;
    private GuideService GuideService;
    private TourService tourService;
    private CustomerTourService CustomerTourService;
    private int GuideId;
    
    public void setTours(List<Tour> tours) {
        this.tours = tours;
        loadTableData();
    }
    

    public void setGuideID(int teaID) {
        this.GuideId = teaID;
    }
    
    public ManageToursOfGuide(Guide Guide) {
        initComponents();
        this.selectGuide = Guide;
        tourService = new TourService();
        GuideService = new GuideService();
        DestinateService = new DestinateService();
        CustomerTourService = new CustomerTourService();
        loadTableData();
    }
    
    public ManageToursOfGuide() {
        initComponents();
        tourService = new TourService();
        GuideService = new GuideService();
        DestinateService = new DestinateService();
        CustomerTourService = new CustomerTourService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    public void showImage() {
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
        titleMain = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        toursTable = new javax.swing.JTable();
        exportFilePDF = new javax.swing.JButton();
        exportFileExcel = new javax.swing.JButton();
        deleteTourForGuide = new javax.swing.JButton();
        showListCustomers = new javax.swing.JButton();
        GuideIdLabel = new javax.swing.JLabel();
        GuideNameLabel = new javax.swing.JLabel();
        GuideAdressLable = new javax.swing.JLabel();
        GuidePhoneNumberLabel = new javax.swing.JLabel();
        GuideEmailLable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Quay lại");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        titleMain.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleMain.setText("CÁC TOUR CẮM TRẠI DO HƯỚNG DẪN VIÊN DẪN DẮT ");

        label5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label5.setText("Email:");

        label4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label4.setText("Số điện thoại:");

        label3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label3.setText("Địa chỉ:");

        label2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label2.setText("Họ tên:");

        label1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label1.setText("Mã hướng dẫn viên :");

        imageLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imageLabel.setText("Ảnh");

        toursTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(toursTable);

        exportFilePDF.setBackground(new java.awt.Color(0, 102, 102));
        exportFilePDF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exportFilePDF.setForeground(new java.awt.Color(255, 255, 255));
        exportFilePDF.setText("Xuất danh sách PDF");
        exportFilePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFilePDFActionPerformed(evt);
            }
        });

        exportFileExcel.setBackground(new java.awt.Color(0, 102, 102));
        exportFileExcel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exportFileExcel.setForeground(new java.awt.Color(255, 255, 255));
        exportFileExcel.setText("Xuất danh sách Excel");
        exportFileExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileExcelActionPerformed(evt);
            }
        });

        deleteTourForGuide.setBackground(new java.awt.Color(153, 0, 0));
        deleteTourForGuide.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteTourForGuide.setForeground(new java.awt.Color(255, 255, 255));
        deleteTourForGuide.setText("Xóa tour cắm trại ");
        deleteTourForGuide.setPreferredSize(new java.awt.Dimension(269, 37));
        deleteTourForGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTourForGuideActionPerformed(evt);
            }
        });

        showListCustomers.setBackground(new java.awt.Color(0, 153, 153));
        showListCustomers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showListCustomers.setForeground(new java.awt.Color(255, 255, 255));
        showListCustomers.setText("Danh sách khách hàng của tour ");
        showListCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        showListCustomers.setPreferredSize(new java.awt.Dimension(269, 37));
        showListCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showListCustomersActionPerformed(evt);
            }
        });

        GuideIdLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GuideIdLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        GuideNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GuideNameLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        GuideAdressLable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GuideAdressLable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        GuidePhoneNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GuidePhoneNumberLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        GuideEmailLable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GuideEmailLable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(GuideNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(GuideAdressLable, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label1)
                                        .addGap(45, 45, 45)
                                        .addComponent(GuideIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addGap(114, 114, 114)
                                        .addComponent(GuideEmailLable, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addGap(43, 43, 43)
                                        .addComponent(GuidePhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(titleMain)))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(deleteTourForGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exportFilePDF, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(exportFileExcel)
                .addGap(63, 63, 63)
                .addComponent(showListCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(titleMain, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GuideIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GuideNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GuidePhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GuideEmailLable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GuideAdressLable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteTourForGuide, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportFilePDF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportFileExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showListCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        ManageGuide manageGuideScreen = new ManageGuide();
        manageGuideScreen.setLocationRelativeTo(null);
        manageGuideScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void deleteTourForGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTourForGuideActionPerformed
        try {
            int index = toursTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn tour cắm trại để thực hiện chức năng", "Thông báo");
                return;
            }
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tour cắm trại này không", "Thông báo");
            
            String tourCode = (String) toursTable.getValueAt(index, 0);
            int tourId = tourService.getIdByTourCode(tourCode);
            System.out.println("TourId: " + tourId);
            Tour tour = tourService.getTourById(tourId);

            if(confirm == 0){
                tourService.updateGuideIdByTourId(tourId);
            }
            loadTableData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteTourForGuideActionPerformed

    private void exportFilePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFilePDFActionPerformed
        Guide Guide = GuideService.getGuideById(GuideId);
        PDFExporter.exportTableToPDF(toursTable, "DANH SÁCH CÁC TOUR CẮM TRẠI CỦA HƯỚNG DẪN VIÊN " + Guide.getLastName().toUpperCase() + " "+Guide.getFirstName().toUpperCase());
    }//GEN-LAST:event_exportFilePDFActionPerformed
    private void exportFileExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileExcelActionPerformed
       try {
            Tour tour = tourService.getTourByGuideId(GuideId);
            Guide Guide = GuideService.getGuideById(GuideId);
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
                    String tourTitle = tour.getName() + " (Mã: " + Guide.getCode() + ", Tên hướng dẫn viên: " + Guide.getLastName() +" "+Guide.getFirstName() + ") ";
                    Sheet sheet = workbook.createSheet("Danh sách các tour cắm trại mà hướng dẫn viên tham gia " + tourTitle);

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

                    String[] headers = {"Mã tour cắm trại", "Tên tour cắm trại", "Ngày tham quan", "Địa điểm", "Số lượng khách hàng tham gia"};

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
                    List<Tour> tours = tourService.getToursByGuideId(GuideId);
                    if (tours != null) {
                        int rowNum = 1;
                        for (Tour GuideTour : tours) {
                            Row row = sheet.createRow(rowNum++);
                            for (int i = 0; i < headers.length; i++) {
                                Cell cell = row.createCell(i);
                                cell.setCellValue(getCellValue(GuideTour, i));
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
    }//GEN-LAST:event_exportFileExcelActionPerformed

    private void showListCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showListCustomersActionPerformed
        try {
            int index = toursTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui chọn chọn chọn tour cắm trại để xem danh sách khách hàng tham quan", "Thông báo");
                return;
            }
            String tourCode = (String) toursTable.getValueAt(index, 0);
            int tourId = tourService.getIdByTourCode(tourCode);
            System.out.println("TourId: " + tourId);
            Tour tour = tourService.getTourById(tourId);
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("CustomerTours", "managetoursofGuide", tour.getId(), GuideId, false);
            System.out.println("Data: " + data);
            ShowData showData = new ShowData(data);
            if (showData != null) {
                showData.setLocationRelativeTo(null);
                showData.setVisible(true);
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_showListCustomersActionPerformed

    private String getCellValue(Tour tour,int columnIndex) throws Exception{
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
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageToursOfGuide().setVisible(true);
            }
        });
    }
    
    public void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã tour cắm trại", "Tên tour cắm trại", "Ngày tham quan", "Địa điểm", "Số lượng khách hàng tham gia"});
        toursTable.setModel(tableModel);
        loadTableData();
    }
    
    private void loadTableData() {
        try {
            tableModel.setRowCount(0);  // Clear the existing data in the table
            boolean hideHeader = true;  // Assume initially that the header should be hidden

            if (tours != null && !tours.isEmpty()) {
                for (Tour tour : tours) {
                    String DestinateName = tourService.getDestinateNameById(tour.getDestinateId());
                    int numberOfCustomers = CustomerTourService.getNumberOfCustomers(tour.getId());

                    // Check if GuideId is less than 0
                    if (tour.getGuideId() >= 0) {
                        hideHeader = false;  // Set to false if GuideId is not less than 0
                        tableModel.addRow(new Object[]{
                                tour.getCode(),
                                tour.getName(),
                                tour.getStartDate(),
                                DestinateName,
                                numberOfCustomers
                        });
                    }
                }
            }

            toursTable.getTableHeader().setVisible(!hideHeader);  // Show/hide the header based on the condition
    } catch (Exception e) {
        MessageDialog.showErrorDialog(this, "Có lỗi khi tải dữ liệu", "Thông báo");
        e.printStackTrace();
    }
    }

    
    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton deleteTourForGuide;
    private javax.swing.JButton exportFileExcel;
    private javax.swing.JButton exportFilePDF;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JButton showListCustomers;
    private javax.swing.JLabel GuideAdressLable;
    private javax.swing.JLabel GuideEmailLable;
    private javax.swing.JLabel GuideIdLabel;
    private javax.swing.JLabel GuideNameLabel;
    private javax.swing.JLabel GuidePhoneNumberLabel;
    private javax.swing.JLabel titleMain;
    private javax.swing.JTable toursTable;
    // End of variables declaration//GEN-END:variables

    public JLabel getGuideIdLabel() {
        return GuideIdLabel;
    }

    public JLabel getGuideNameLabel() {
        return GuideNameLabel;
    }

    public JLabel getGuidePhoneNumberLabel() {
        return GuidePhoneNumberLabel;
    }

    public JLabel getGuideEmailLable() {
        return GuideEmailLable;
    }

    public JLabel getGuideAdressLable() {
        return GuideAdressLable;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        showImage();
    }

    public String getImagePath() {
        return imagePath;
    }
    
}
