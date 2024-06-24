package view;

import exception.MessageDialog;
import exception.TransmittedDataShowData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.*;
import services.*;

public class GuideAndCustomerHome extends javax.swing.JFrame {
    
    private Customer loggedInCustomer;
    private Guide loggedInGuide;
    private String reated = "comingTours";
    private TourService tourService;
    private DestinateService DestinateService;
    private GuideService GuideService;
    private CustomerService CustomerService;
    private CustomerTourService CustomerTourService;
    
    public GuideAndCustomerHome() {
        initComponents();
        tourService = new TourService();
        DestinateService = new DestinateService();
        GuideService = new GuideService();
        CustomerTourService = new CustomerTourService();
        initializeTableOfTours();
        setLocationRelativeTo(null);
    }
    
    public GuideAndCustomerHome(Object object){
        initComponents();
        tourService = new TourService();
        DestinateService = new DestinateService();
        GuideService = new GuideService();
        CustomerService = new CustomerService();
        CustomerTourService = new CustomerTourService();
        if(object instanceof Customer){
            this.loggedInCustomer = (Customer) object;
            String title = loggedInCustomer.getLastName() + " " + loggedInCustomer.getFirstName();
            if(title.contains("Khách hàng chưa nhập")){
                welcomeLabel.setText("Xin chào");
            }else{
                welcomeLabel.setText("Xin chào: " + title);
            }
        }else if(object instanceof Guide){
            this.loggedInGuide = (Guide) object;
            welcomeLabel.setText("Xin chào: " + loggedInGuide.getLastName() + " " + loggedInGuide.getFirstName());
        }else{
            throw new IllegalArgumentException("Không hỗ trợ loại đối tượng này.");
        }
        if(loggedInCustomer == null && loggedInGuide == null){
            MessageDialog.showErrorDialog(this, "Phải đăng nhập với tài khoản khách hàng để sử dụng tính năng này ", "Lỗi");
            return;
        }
         
        initializeTableOfTours();
        ratedTour.setVisible(false);
        evaluateBtn.setVisible(false);
        addTour.setVisible(false);
        showCustomersOfTour.setVisible(false);
        if(loggedInGuide != null){
            evaluateBtn.setVisible(true);
            addTour.setVisible(false);
            showCustomersOfTour.setVisible(true);
        }
        if(loggedInCustomer != null){
            addTour.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        updateProfile = new javax.swing.JButton();
        showTourInDay = new javax.swing.JButton();
        showUpcomingTours = new javax.swing.JButton();
        registeredTourBtn = new javax.swing.JButton();
        evaluateBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        menu1 = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JToggleButton();
        showCustomersOfTour = new javax.swing.JButton();
        ratedTour = new javax.swing.JButton();
        addTour = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        futureTourTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("XIN CHÀO");

        updateProfile.setBackground(new java.awt.Color(0, 102, 102));
        updateProfile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateProfile.setForeground(new java.awt.Color(255, 255, 255));
        updateProfile.setText("Tài khoản cá nhân");
        updateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfileActionPerformed(evt);
            }
        });

        showTourInDay.setBackground(new java.awt.Color(0, 102, 102));
        showTourInDay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showTourInDay.setForeground(new java.awt.Color(255, 255, 255));
        showTourInDay.setText("Tour cắm trại hôm nay của bạn");
        showTourInDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTourInDayActionPerformed(evt);
            }
        });

        showUpcomingTours.setBackground(new java.awt.Color(0, 102, 102));
        showUpcomingTours.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showUpcomingTours.setForeground(new java.awt.Color(255, 255, 255));
        showUpcomingTours.setText("Các tour cắm trại sắp diễn ra");
        showUpcomingTours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUpcomingToursActionPerformed(evt);
            }
        });

        registeredTourBtn.setBackground(new java.awt.Color(0, 102, 102));
        registeredTourBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        registeredTourBtn.setForeground(new java.awt.Color(255, 255, 255));
        registeredTourBtn.setText("Các tour cắm trại đã đăng kí");
        registeredTourBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registeredTourBtnActionPerformed(evt);
            }
        });

        evaluateBtn.setBackground(new java.awt.Color(0, 102, 102));
        evaluateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        evaluateBtn.setForeground(new java.awt.Color(255, 255, 255));
        evaluateBtn.setText("Đánh giá khách hàng của tour cắm trại");
        evaluateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluateBtnActionPerformed(evt);
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
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(registeredTourBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(showTourInDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(showUpcomingTours, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(evaluateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(welcomeLabel)
                .addGap(54, 54, 54)
                .addComponent(registeredTourBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(updateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(showTourInDay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(showUpcomingTours, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(evaluateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        menu1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        menu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu1.setText("CÁC TOUR CẮM TRẠI SẮP DIỄN RA");

        searchInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        searchBtn.setBackground(new java.awt.Color(0, 153, 204));
        searchBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Tìm kiếm");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        showCustomersOfTour.setBackground(new java.awt.Color(0, 102, 102));
        showCustomersOfTour.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showCustomersOfTour.setForeground(new java.awt.Color(255, 255, 255));
        showCustomersOfTour.setText("Danh sách khách hàng tham gia tour");
        showCustomersOfTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCustomersOfTourActionPerformed(evt);
            }
        });
        ratedTour.setBackground(new java.awt.Color(0, 102, 102));
        ratedTour.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ratedTour.setForeground(new java.awt.Color(255, 255, 255));
        ratedTour.setText("Các tour cắm trại đã đánh giá");

        addTour.setBackground(new java.awt.Color(0, 102, 102));
        addTour.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addTour.setForeground(new java.awt.Color(255, 255, 255));
        addTour.setText("Đăng ký tham gia tour cắm trại");
        addTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTourActionPerformed(evt);
            }
        });

        futureTourTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(futureTourTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(showCustomersOfTour)
                                .addGap(18, 18, 18)
                                .addComponent(ratedTour)
                                .addGap(18, 18, 18)
                                .addComponent(addTour))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(menu1))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showCustomersOfTour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ratedTour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        int key = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn đăng xuất khỏi hệ thống?", "Xác nhận");
        if (key == 0) {
            dispose();
            Login loginScreen = new Login();
            loginScreen.setLocationRelativeTo(null);
            loginScreen.setVisible(true);
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void registeredTourBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registeredTourBtnActionPerformed
        try {
            dispose();
            ShowData scData = null;
            if(loggedInGuide != null){
                showCustomersOfTour.setVisible(true);
                addTour.setVisible(false);
                ratedTour.setVisible(false);
                
                TransmittedDataShowData data = new TransmittedDataShowData("toursOfGuides", "GuideAndCustomerHome", loggedInGuide.getId(), false);
                scData = new ShowData(data);
            }else if(loggedInCustomer != null){
                TransmittedDataShowData data = new TransmittedDataShowData("toursOfCustomers", "GuideAndCustomerHome", loggedInCustomer.getId(), true);
                scData = new ShowData(data);
            }
            scData.setLocationRelativeTo(null);
            scData.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_registeredTourBtnActionPerformed

    private void updateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProfileActionPerformed
        try {
            dispose();
            
            if(loggedInCustomer != null){
                Customer Customer = CustomerService.getCustomerByAccountId(loggedInCustomer.getId());
                CustomerProfile CustomerProfile = new CustomerProfile(Customer);
                CustomerProfile.setLocationRelativeTo(null);
                CustomerProfile.setVisible(true);
            }else if(loggedInGuide != null){
                Guide Guide = GuideService.getGuideByAccountId(loggedInGuide.getId());
                GuideProfile GuideProfile = new GuideProfile(Guide);
                GuideProfile.setLocationRelativeTo(null);
                GuideProfile.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateProfileActionPerformed

    private void showTourInDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTourInDayActionPerformed
        try {
            menu1.setText("TOUR CẮM TRẠI HÔM NAY CỦA BẠN");
            addTour.setVisible(false);
            searchInput.setVisible(false);
            searchBtn.setVisible(false);
            tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(new String[]{"Mã tour", "Tên tour", "Mô tả",
                "Số lượng", "Ngày diễn ra", "Người đại diện", "Địa điểm", "Hướng dẫn viên"});
            futureTourTable.setModel(tableModel);
            tableModel.setRowCount(0);
            if(loggedInCustomer != null){
                List<Tour> tour_data = tourService.getToursByCustomerId(loggedInCustomer.getId());
                List<Destinate> Destinate_data = DestinateService.getAllDestinate();
                List<Guide> Guide_data = GuideService.getAllGuides();
                //Destinate
                if(tour_data != null){
                    for(Tour tour : tour_data){
                        String dateString = tour.getStartDate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        try {
                            LocalDate inputDate = LocalDate.parse(dateString,formatter);
                            LocalDate currentDate = LocalDate.now();
                            if(currentDate.compareTo(inputDate) == 0){
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
                                    tour.getStartDate(),
                                    tour.getPresentator(), 
                                    DestinateName, 
                                    GuideName
                                });
                            }
                        } catch (Exception e) {
                            MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
                            e.printStackTrace();
                        }
                    }
                }
            }else if(loggedInGuide != null){
                ratedTour.setVisible(false);
                addTour.setVisible(false);
                
                List<Tour> tour_data = tourService.getToursByGuideId(loggedInGuide.getId());
                List<Destinate> Destinate_data = DestinateService.getAllDestinate();
                List<Guide> Guide_data = GuideService.getAllGuides();
                
                if(tour_data != null){
                    for(Tour tour : tour_data){
                        String dateString = tour.getStartDate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        try {
                            LocalDate inputDate = LocalDate.parse(dateString,formatter);
                            LocalDate currentDate = LocalDate.now();
                            if(currentDate.compareTo(inputDate) == 0){
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
                                    tour.getStartDate(),
                                    tour.getPresentator(), 
                                    DestinateName, 
                                    GuideName
                                });
                            }
                        } catch (Exception e) {
                            MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
                            e.printStackTrace();
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_showTourInDayActionPerformed

    private void showUpcomingToursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUpcomingToursActionPerformed
        menu1.setText("CÁC TOUR CẮM TRẠI SẮP DIỄN RA");
        if(loggedInGuide != null){
            addTour.setVisible(false);
            searchInput.setVisible(true);
            searchBtn.setVisible(true);
            ratedTour.setVisible(false);
            showCustomersOfTour.setVisible(true);
            initializeTableOfTours();
            reated = "comingTours";
        }else if(loggedInCustomer != null){
            addTour.setVisible(true);
            initializeTableOfTours();
            reated = "comingTours";
        }
    }//GEN-LAST:event_showUpcomingToursActionPerformed

    private void addTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTourActionPerformed
        try {
            if(reated.equalsIgnoreCase("tookPlaceTours")){
                
            }else{
                int index = futureTourTable.getSelectedRow();
                if (index == -1) {
                    MessageDialog.showInfoDialog(this, "Vui chọn tour cắm trại mà bạn muốn thêm", "Thông báo");
                    return;
                }
                String code = (String) futureTourTable.getValueAt(index, 0);
                int tourId = tourService.getIdByTourCode(code);
                Tour tour = tourService.getTourById(tourId);
                
                if(loggedInCustomer != null){
                    List<CustomerTour> CustomerTours_data = CustomerTourService.getAllCustomerToursByTourId(tourId);
                    System.out.println("CustomerTours_data: " + CustomerTours_data);
                    List<Tour> tours = tourService.getToursByCustomerId(loggedInCustomer.getId());
                    System.out.println("Tours: " + tours);
                    System.out.println("CustomerId: " + loggedInCustomer.getId());
                    if(CustomerTours_data != null && tours != null){
                        for(CustomerTour CustomerTour : CustomerTours_data){
                            if(CustomerTour.getCustomerId() == loggedInCustomer.getId()){
                                MessageDialog.showInfoDialog(futureTourTable, "Bạn đã đăng ký tour cắm trại này rồi", "Thông báo");
                                return;
                            }
                        }
                        
                        for(Tour item : tours){
                            if (item.getStartDate().compareTo(tour.getStartDate()) == 0) {
                                MessageDialog.showInfoDialog(futureTourTable, "Bạn đã có một tour cắm trại vào ngày " + item.getStartDate() + " rồi.", "Thông báo");
                                return;
                            }
                            if (item.getId() == tour.getId() && item.getAvailables() == tour.getCustomerTours().size()) {
                                MessageDialog.showInfoDialog(futureTourTable, "Hiện tại số lượng người tour đã đầy, mong bạn tham gia tour cắm trại khác", "Thông báo");
                                return;
                            }
                        }
                    }
                    
                    CustomerTour CustomerTour = new CustomerTour(loggedInCustomer.getId(), tourId, 0);
                    CustomerTourService.addCustomerTour(CustomerTour);
                    MessageDialog.showInfoDialog(futureTourTable, "Đăng ký tour thành công", "Thông báo");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addTourActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        searchByKey();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void evaluateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluateBtnActionPerformed
        if(loggedInGuide != null){
            menu1.setText("DANH SÁCH CÁC TOUR CẮM TRẠI CẦN ĐƯỢC ĐÁNH GIÁ");
            addTour.setText("Các tour cắm trại chưa đánh giá");
            showCustomersOfTour.setVisible(true);
            addTour.setVisible(true);
            ratedTour.setVisible(true);
            reated = "tookPlaceTours";
            loadTableOfTookPlaceTours();
        }
    }//GEN-LAST:event_evaluateBtnActionPerformed

    private void loadTableOfTookPlaceTours(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã tour", "Tên tour", "Mô tả",
            "Số lượng", "Ngày diễn ra", "Người đại diện ", "Địa điểm", "Hướng dẫn viên"});
        futureTourTable.setModel(tableModel);
        tableModel.setRowCount(0);
        if(loggedInGuide != null){
            ratedTour.setVisible(false);
            addTour.setVisible(false);

            List<Tour> tour_data = tourService.getToursByGuideId(loggedInGuide.getId());
            List<Destinate> Destinate_data = DestinateService.getAllDestinate();
            List<Guide> Guide_data = GuideService.getAllGuides();

            if(tour_data != null){
                for(Tour tour : tour_data){
                    String dateString = tour.getStartDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    try {
                        LocalDate inputDate = LocalDate.parse(dateString,formatter);
                        LocalDate currentDate = LocalDate.now();
                        if(currentDate.compareTo(inputDate) > 0){
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
                                tour.getStartDate(),
                                tour.getPresentator(), 
                                DestinateName, 
                                GuideName
                            });
                        }
                    } catch (Exception e) {
                        MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    private void showCustomersOfTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCustomersOfTourActionPerformed
        try {
            int index = futureTourTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn tour cắm trại mà bạn muốn xem danh sách khách hàng", "Thông báo");
                return;
            }
            
            String code = (String)futureTourTable.getValueAt(index, 0);
            int tourId = tourService.getIdByTourCode(code);
            dispose();
            TransmittedDataShowData data_show = null;
            if (loggedInGuide != null) {
                data_show = new TransmittedDataShowData("CustomerTours", "GuideAndCustomerHome", tourId, loggedInGuide.getId(), false);
                if (reated.equalsIgnoreCase("tookPlaceTours")) {
                    data_show = new TransmittedDataShowData("CustomerTookPlaceTours", "GuideAndCustomerHome", tourId, loggedInGuide.getId(), false);
                }
            }
            ShowData screen = new ShowData(data_show);
            screen.setLocationRelativeTo(null);
            screen.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_showCustomersOfTourActionPerformed

    private void searchByKey(){
        try {
            String keyword = searchInput.getText().trim();
            int count = 0;
            if(keyword.trim().equalsIgnoreCase("")){
                if(reated.equalsIgnoreCase("comingTours")){
                    initializeTableOfTours();
                }else if(reated.equalsIgnoreCase("tookPlaceTours")){
                    loadTableDataOfTours();
                }else{
                    initializeTableOfTours();
                    return;
                }
            }
            
            List<Tour> tour_data = tourService.getAllTours();
            List<Destinate> Destinate_data = DestinateService.getAllDestinate();
            List<Guide> Guide_data = GuideService.getAllGuides();
            tableModel.setRowCount(0);
            if(tour_data != null){
                for(Tour tour : tour_data){
                    try {
                        String DestinateName = "";
                        String GuideName = "";
                        for(Destinate comp : Destinate_data){
                            if(comp.getId() == tour.getId()){
                                DestinateName = comp.getName();
                            }
                        }
                        for(Guide tea : Guide_data){
                            if (tea.getId() == tour.getGuideId()) {
                                GuideName = tea.getLastName() + " " + tea.getFirstName();
                            }
                        }
                        if (keyword.equalsIgnoreCase(tour.getCode()) || keyword.equalsIgnoreCase(tour.getName())) {
                            tableModel.addRow(new Object[]{tour.getCode(), tour.getName(), tour.getDescription(),
                                tour.getAvailables(),
                                tour.getPresentator(), DestinateName, GuideName, tour.getStartDate()});
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuideAndCustomerHome().setVisible(true);
            }
        });
    }
    
    private void loadTableDataOfTours(){
        try {
            if(loggedInGuide != null){
                List<Tour> tour_data = tourService.getToursByGuideId(loggedInGuide.getId());
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
                            if(currentDate.compareTo(inputDate) < 0){
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
                                    tour.getStartDate(),
                                    tour.getPresentator(), 
                                    DestinateName, 
                                    GuideName
                                });
                            }
                        } catch (Exception e) {
                            MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
                            e.printStackTrace();
                        }
                    }
                }
            }else if(loggedInCustomer != null){
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
                            if(currentDate.compareTo(inputDate) < 0){
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
                                    tour.getStartDate(),
                                    tour.getPresentator(), 
                                    DestinateName, 
                                    GuideName
                                });
                            }
                        } catch (Exception e) {
                            MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initializeTableOfTours() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã tour", "Tên tour", "Mô tả",
            "Số lượng", "Ngày  diễn ra", "Người đại diện Địa điểm", "Địa điểm", "Hướng dẫn viên"});
        futureTourTable.setModel(tableModel);
        loadTableDataOfTours();
    }
    
    
    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTour;
    private javax.swing.JButton evaluateBtn;
    private javax.swing.JTable futureTourTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel menu1;
    private javax.swing.JButton ratedTour;
    private javax.swing.JButton registeredTourBtn;
    private javax.swing.JToggleButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JButton showCustomersOfTour;
    private javax.swing.JButton showTourInDay;
    private javax.swing.JButton showUpcomingTours;
    private javax.swing.JButton updateProfile;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
