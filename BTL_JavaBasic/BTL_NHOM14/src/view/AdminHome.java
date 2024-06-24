package view;

import exception.MessageDialog;
import exception.PDFExporter;
import exception.TransmittedDataShowData;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import services.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class AdminHome extends javax.swing.JFrame {
    
    private TourService tourService;
    private GuideService GuideService;
    private CustomerService CustomerService;
    private DestinateService DestinateService;
    private AccountService accountService;

    public AdminHome() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
       
        tourService = new TourService();
        GuideService = new GuideService();
        CustomerService = new CustomerService();
        DestinateService = new DestinateService();
        accountService = new AccountService();
        
        Account currentLoginUser = accountService.currentLoginUser;
        if(!currentLoginUser.getRole().equalsIgnoreCase("Toàn quyền hệ thống")){
            manageSystemBtn.setVisible(false);
        }
        initializeTableOfTours();
        loadTextButton();
        
    }
    
    private void loadTableDataOfTours(){
        try {
            
            List<Tour> tour_data = tourService.getAllTours();
            List<Destinate> Destinate_data = DestinateService.getAllDestinate();
            List<Guide> Guide_data = GuideService.getAllGuides();
            tableModel.setRowCount(0);
            if(tour_data != null){
                for(Tour tour : tour_data){
                    String dateString = tour.getStartDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    try {
                        LocalDate inputDate = LocalDate.parse(dateString,formatter);
                        LocalDate currentDate = LocalDate.now();
                        if(currentDate.equals(inputDate)){
                            String DestinateName = "";
                            String GuideName = "";
                            for(Destinate comp : Destinate_data){
                                if(comp.getId() == tour.getDestinateId()){
                                    DestinateName = comp.getName();
                                }
                            }
                            for(Guide tea : Guide_data){
                                if(tea.getId() == tour.getGuideId()){
                                    GuideName = tea.getLastName() + " " + tea.getFirstName();
                                }
                            }
                            tableModel.addRow(new Object[]{
                                tour.getCode(),
                                tour.getName(),
                                tour.getDescription(),
                                tour.getAvailables(),
                                tour.getPresentator(), 
                                DestinateName, 
                                GuideName,
                                tour.getStartDate()
                            });
                        }
                    } catch (Exception e) {
                        MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menu = new javax.swing.JLabel();
        manageCustomerBtn = new javax.swing.JButton();
        manageGuideBtn = new javax.swing.JButton();
        manageDestinateBtn = new javax.swing.JButton();
        manageTourBtn = new javax.swing.JButton();
        manageSystemBtn = new javax.swing.JButton();
        manageClassroomBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        menu1 = new javax.swing.JLabel();
        CustomerDataButton = new javax.swing.JButton();
        DestinateDataButton = new javax.swing.JButton();
        GuideDataButton = new javax.swing.JButton();
        tourDataButton = new javax.swing.JButton();
        menu2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pdfBtn = new javax.swing.JButton();
        excelBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        todayTourTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        menu.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setText("MENU");

        manageCustomerBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageCustomerBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageCustomerBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageCustomerBtn.setText("Quản lí thông tin khách hàng");
        manageCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCustomerBtnActionPerformed(evt);
            }
        });

        manageGuideBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageGuideBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageGuideBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageGuideBtn.setText("Quản lí thông tin hướng dẫn viên");
        manageGuideBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageGuideBtnActionPerformed(evt);
            }
        });

        manageDestinateBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageDestinateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageDestinateBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageDestinateBtn.setText("Quản lí thông tin địa điểm");
        manageDestinateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDestinateBtnActionPerformed(evt);
            }
        });

        manageTourBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageTourBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageTourBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageTourBtn.setText("Quản lí các tour cắm trại");
        manageTourBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageTourBtnActionPerformed(evt);
            }
        });

        manageSystemBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageSystemBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageSystemBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageSystemBtn.setText("Quản lí hệ thống");
        manageSystemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSystemBtnActionPerformed(evt);
            }
        });

        manageClassroomBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageClassroomBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageClassroomBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageClassroomBtn.setText("Quản lí thông tin team cắm trại");
        manageClassroomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageClassroomBtnActionPerformed(evt);
            }
        });

        logOutBtn.setBackground(new java.awt.Color(204, 0, 0));
        logOutBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logOutBtn.setText("Đăng xuất");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(160, Short.MAX_VALUE)
        			.addComponent(menu)
        			.addGap(152))
        		.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        			.addGap(24)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(manageTourBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(manageCustomerBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(manageGuideBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(manageDestinateBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(manageClassroomBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(manageSystemBtn, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(31, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        			.addGap(39)
        			.addComponent(logOutBtn, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(15)
        			.addComponent(menu)
        			.addGap(33)
        			.addComponent(manageTourBtn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addGap(27)
        			.addComponent(manageCustomerBtn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addGap(28)
        			.addComponent(manageGuideBtn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addGap(29)
        			.addComponent(manageDestinateBtn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addGap(29)
        			.addComponent(manageClassroomBtn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addGap(29)
        			.addComponent(manageSystemBtn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addGap(51)
        			.addComponent(logOutBtn, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        menu1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        menu1.setText("DỮ LIỆU HIỆN CÓ TRONG HỆ THỐNG");

        CustomerDataButton.setBackground(new java.awt.Color(0, 102, 0));
        CustomerDataButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CustomerDataButton.setForeground(new java.awt.Color(255, 255, 255));
        CustomerDataButton.setText("Khách hàng được quản lí");
        CustomerDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerDataButtonActionPerformed(evt);
            }
        });

        DestinateDataButton.setBackground(new java.awt.Color(0, 102, 0));
        DestinateDataButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DestinateDataButton.setForeground(new java.awt.Color(255, 255, 255));
        DestinateDataButton.setText("Địa điểm hợp tác với công ty");
        DestinateDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinateDataButtonActionPerformed(evt);
            }
        });

        GuideDataButton.setBackground(new java.awt.Color(0, 102, 0));
        GuideDataButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        GuideDataButton.setForeground(new java.awt.Color(255, 255, 255));
        GuideDataButton.setText("Hướng dẫn viên đại diện công ty");
        GuideDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuideDataButtonActionPerformed(evt);
            }
        });

        tourDataButton.setBackground(new java.awt.Color(0, 102, 0));
        tourDataButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tourDataButton.setForeground(new java.awt.Color(255, 255, 255));
        tourDataButton.setText("Chuyến thăm quan được tổ chức");
        tourDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tourDataButtonActionPerformed(evt);
            }
        });

        menu2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        menu2.setText("CÁC TOUR CẮM TRẠI ĐƯỢC TỔ CHỨC TRONG NGÀY");

        pdfBtn.setBackground(new java.awt.Color(0, 102, 102));
        pdfBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pdfBtn.setForeground(new java.awt.Color(255, 255, 255));
        pdfBtn.setText("Xuất danh sách PDF");
        pdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfBtnActionPerformed(evt);
            }
        });

        excelBtn.setBackground(new java.awt.Color(0, 102, 102));
        excelBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        excelBtn.setForeground(new java.awt.Color(255, 255, 255));
        excelBtn.setText("Xuất danh sách Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });

        todayTourTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(todayTourTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menu2)
                        .addGap(88, 88, 88))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tourDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustomerDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DestinateDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(GuideDataButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89)
                                        .addComponent(excelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menu1)
                        .addGap(104, 104, 104))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(menu1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tourDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DestinateDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuideDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(menu2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageTourBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageTourBtnActionPerformed
        dispose();
        ManageTour manageTour = new ManageTour();
        manageTour.setLocationRelativeTo(null);
        manageTour.setVisible(true);
    }//GEN-LAST:event_manageTourBtnActionPerformed

    private void manageCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCustomerBtnActionPerformed
        dispose();
        ManageCustomer manageCustomer = new ManageCustomer();
        manageCustomer.setLocationRelativeTo(null);
        manageCustomer.setVisible(true);
    }//GEN-LAST:event_manageCustomerBtnActionPerformed

    private void manageGuideBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageGuideBtnActionPerformed
        dispose();
        ManageGuide manageGuide = new ManageGuide();
        manageGuide.setLocationRelativeTo(null);
        manageGuide.setVisible(true);
    }//GEN-LAST:event_manageGuideBtnActionPerformed

    private void manageDestinateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDestinateBtnActionPerformed
        dispose();
        ManageDestinate manageDestinate = new ManageDestinate();
        manageDestinate.setLocationRelativeTo(null);
        manageDestinate.setVisible(true);
    }//GEN-LAST:event_manageDestinateBtnActionPerformed

    private void manageClassroomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageClassroomBtnActionPerformed
        dispose();
        ManageTeam manageClassroom = new ManageTeam();
        manageClassroom.setLocationRelativeTo(null);
        manageClassroom.setVisible(true);
    }//GEN-LAST:event_manageClassroomBtnActionPerformed

    private void manageSystemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSystemBtnActionPerformed
        dispose();
        ManageAccount manageAccount = new ManageAccount();
        manageAccount.setLocationRelativeTo(null);
        manageAccount.setVisible(true);
    }//GEN-LAST:event_manageSystemBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        int key = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn đăng xuất khỏi hệ thống?", "Xác nhận");
        if (key == 0) {
            dispose();
            Login loginScreen = new Login();
            loginScreen.setLocationRelativeTo(null);
            loginScreen.setVisible(true);
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void tourDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tourDataButtonActionPerformed
        try {
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("tours", "home");
            ShowData screen = new ShowData(data);
            if (screen != null) {
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_tourDataButtonActionPerformed

    private void DestinateDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinateDataButtonActionPerformed
        try {
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("Destinate", "home");
            ShowData screen = new ShowData(data);
            if (screen != null) {
                screen.setLocationRelativeTo(null);
                screen.setVisible(true); 
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
            e.printStackTrace();
        }
    }//GEN-LAST:event_DestinateDataButtonActionPerformed

    private void CustomerDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerDataButtonActionPerformed
        try {
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("Customers", "home");
            ShowData screen = new ShowData(data);
            if (screen != null) {
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_CustomerDataButtonActionPerformed

    private void GuideDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuideDataButtonActionPerformed
        try {
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("Guides", "home");
            ShowData screen = new ShowData(data);
            if (screen != null) {
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_GuideDataButtonActionPerformed

    private void pdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfBtnActionPerformed
        try {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = currentDate.format(formatter);
            String title = "BẢNG DANH SÁCH CHUYẾN CẮM TRẠI TRONG NGÀY " + formattedDate;
            PDFExporter.exportTableToPDF(todayTourTable, title);
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(jPanel1, "Có lỗi ở phần xuất PDF, chi tiết: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pdfBtnActionPerformed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        try {
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

                    LocalDate currentDate = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formattedDate = currentDate.format(formatter);
                    String tourTitle = "DANH SÁCH CHUYẾN CẮM TRẠI TRONG NGÀY " + formattedDate;

                    Sheet sheet = workbook.createSheet(tourTitle);

                    // Create header row
                    Row headerRow = sheet.createRow(0);

                    CellStyle headerStyle = workbook.createCellStyle();
                    headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    headerStyle.setAlignment(HorizontalAlignment.CENTER);

                    org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
                    headerFont.setColor(IndexedColors.WHITE.getIndex());
                    headerFont.setBold(true);
                    headerStyle.setFont(headerFont);

                    String[] headers = {"Mã chuyến", "Tên chuyến", "Mô tả",
                        "Số lượng", "Người đại diện", "Địa điểm", "Hướng dẫn viên","Ngày diễn ra"};

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
                    List<Tour> data = tourService.getAllTours();
                    if (data != null) {
                        int rowNum = 1;
                        for (Tour tour : data) {
                            if (!tour.getStartDate().equals(formattedDate)) {
                                continue;
                            }
                            Row row = sheet.createRow(rowNum++);
                            for (int i = 0; i < headers.length; i++) {
                                Cell cell = row.createCell(i);
                                cell.setCellValue(getCellValue(tour, i));
                                cell.setCellStyle(cellStyle);
                            }
                        }
                    }

                    try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
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

    private String getCellValue(Tour tour, int columnIndex) throws Exception {
        switch (columnIndex) {
            case 0:
                return tour.getCode();
            case 1:
                return tour.getName();
            case 2:
                return tour.getDescription();
            case 3:
                return String.valueOf(tour.getAvailables());
            case 4:
                return tour.getPresentator();
            case 5:
                return DestinateService.getDestinateById(tour.getDestinateId()).getName();
            case 6:
                Guide Guide = GuideService.getGuideById(tour.getGuideId());
                if (Guide == null) {
                    return "";
                }
                String fullName = Guide.getLastName() + " " + Guide.getFirstName();
                return fullName;
            case 7:
                return tour.getStartDate();
            default:
                return "";
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }
    
    private void initializeTableOfTours() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã tour", "Tên tour", "Mô tả",
            "Số lượng", "Người đại diện", "Địa điểm", "Hướng dẫn viên","Ngày diễn ra"});
        todayTourTable.setModel(tableModel);
        loadTableDataOfTours();
    }
    private void loadTextButton(){
        try {
            List<Customer> Customers = CustomerService.getAllCustomers();
            List<Tour> tours = tourService.getAllTours();
            List<Guide> Guides = GuideService.getAllGuides();
            List<Destinate> Destinates = DestinateService.getAllDestinate();
            
            if(Customers == null){
                CustomerDataButton.setText("0 khách hàng được quản lý");
            }else{
                CustomerDataButton.setText(Customers.size()+" khách hàng được quản lý");
            }
            
            if(tours == null){
                tourDataButton.setText("0 chuyến cắm trại được tổ chức");
            }else{
                tourDataButton.setText(tours.size() + " chuyến cắm trại được tổ chức");
            }
            
            if(Guides == null){
                GuideDataButton.setText("0 hướng dẫn viên phụ trách địa điểm cắm trại");
            }else{
                GuideDataButton.setText(Guides.size()+" hướng dẫn viên phụ trách địa điểm cắm trại");
            }
            //hướng dẫn viên phụ trách địa điểm cắm trại
            if (Destinates == null) {
                DestinateDataButton.setText("0 địa điểm được hợp tác với công ty");
            } else {
                DestinateDataButton.setText(Destinates.size() + " địa điểm được hợp tác với công ty");
            }
        } catch (Exception e) {
        }
    }

    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CustomerDataButton;
    private javax.swing.JButton DestinateDataButton;
    private javax.swing.JButton excelBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton manageClassroomBtn;
    private javax.swing.JButton manageDestinateBtn;
    private javax.swing.JButton manageCustomerBtn;
    private javax.swing.JButton manageSystemBtn;
    private javax.swing.JButton manageGuideBtn;
    private javax.swing.JButton manageTourBtn;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel menu1;
    private javax.swing.JLabel menu2;
    private javax.swing.JButton pdfBtn;
    private javax.swing.JButton GuideDataButton;
    private javax.swing.JTable todayTourTable;
    private javax.swing.JButton tourDataButton;
    // End of variables declaration//GEN-END:variables
}
