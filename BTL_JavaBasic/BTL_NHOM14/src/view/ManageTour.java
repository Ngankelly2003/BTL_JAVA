package view;

import dao.TourDao;
import exception.MessageDialog;
import static exception.Validator.isDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.table.DefaultTableModel;
//import jdk.nashorn.internal.ir.BreakNode;
import models.*;
import services.DestinateService;
import services.GuideService;
import services.TourService;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManageTour extends javax.swing.JFrame {

    private int GuideId = -1;
    
    public ManageTour() {
        initComponents();
        setLocationRelativeTo(null);
        tourServices = new TourService();
        GuideService = new GuideService();
        DestinateService = new DestinateService();
        loadComboBox();
        initializeTable();
    }
    
    public ManageTour(int index) {
        initComponents();
        this.GuideId = index;
        tourServices = new TourService();
        GuideService = new GuideService();
        DestinateService = new DestinateService();
        setLocationRelativeTo(null);
        loadComboBox();
        initializeTable();
    }
    
    private void clearAllFields(){
        codeInput.setText("");
        nameInput.setText("");
        descriptionInput.setText("");
        startDateInput.setText("");
        presentatorInput.setText("");
        availablesInput.setText("");
    }
    private void loadComboBox(){
        try {
            List<Destinate> Destinate_data = DestinateService.getAllDestinate();
            DestinateInput.removeAllItems();
            for(Destinate comp : Destinate_data){
                DestinateInput.addItem(comp.getName());
            }
            Object selectedDestinate = DestinateInput.getSelectedItem();
            
            
            List<Guide> Guide_data = GuideService.getAllGuides();
            GuideInput.removeAllItems();
            for(Guide Guide : Guide_data){
                GuideInput.addItem(Guide.getLastName() + " " + Guide.getFirstName());
            }
            Object selectedGuide = GuideInput.getSelectedItem();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho combobox có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    private void loadTableData(){
        try {
            List<Tour> tour_data = tourServices.getAllTours();
            tableModel.setRowCount(0);
            if(tour_data != null){
                for (Tour tour : tour_data) {
                String DestinateName = tourServices.getDestinateNameById(tour.getDestinateId());
                
                String GuideName = "";
                if (tour.getGuideId() > 0) {
                    GuideName = tourServices.getGuideNameById(tour.getGuideId());
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
    
    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Thời gian", "Mô tả",
            "Số lượng", "Người đại diện", "Công ty", "Giáo viên"});
        tourTable.setModel(tableModel);
        if (GuideId >= 0) {
            btn_delete.setEnabled(false);
            btn_back.setText("Quay lại trang trước");
        }
        loadTableData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tourTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        codeInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descriptionInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        startDateInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        presentatorInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        availablesInput = new javax.swing.JTextField();
        DestinateInput = new javax.swing.JComboBox<>();
        GuideInput = new javax.swing.JComboBox<>();
        btn_back = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        viewCustomerListButton = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tourTable.setModel(new javax.swing.table.DefaultTableModel(
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
        tourTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tourTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tourTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Mã tour cắm trại:");

        codeInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Tên tour cắm trại:");

        nameInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Mô tả hoạt động chuyến đi:");

        descriptionInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Ngày diễn ra: ");

        startDateInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Địa điểm cắm trại:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Người đại diện địa điểm:");

        presentatorInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Hướng dẫn viên dẫn dắt tour:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Số lượng khách hàng có thể đi:");

        availablesInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        DestinateInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        GuideInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

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
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
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

        btn_clear.setBackground(new java.awt.Color(102, 153, 0));
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Nhập lại");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        viewCustomerListButton.setBackground(new java.awt.Color(0, 102, 153));
        viewCustomerListButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewCustomerListButton.setForeground(new java.awt.Color(255, 255, 255));
        viewCustomerListButton.setText("Danh sách khách hàng tham gia");
        viewCustomerListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCustomerListButtonActionPerformed(evt);
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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("QUẢN LÍ THÔNG TIN TOUR CẮM TRẠI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(45)
        					.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        					.addGap(45)
        					.addComponent(btn_edit, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        					.addGap(60)
        					.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        					.addGap(61)
        					.addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        					.addGap(50)
        					.addComponent(viewCustomerListButton, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(35)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 677, GroupLayout.PREFERRED_SIZE)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addGap(39)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(jLabel1)
        										.addComponent(jLabel3)
        										.addComponent(jLabel2)
        										.addComponent(jLabel5)
        										.addComponent(jLabel4)))
        								.addGroup(layout.createSequentialGroup()
        									.addGap(41)
        									.addComponent(jLabel6)))
        							.addGap(57))
        						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(jLabel7)
        							.addGap(36))
        						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(jLabel8)
        							.addGap(25)))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(GuideInput, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(DestinateInput, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(startDateInput)
        							.addComponent(nameInput)
        							.addComponent(codeInput, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
        						.addComponent(descriptionInput, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
        						.addComponent(presentatorInput, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
        						.addComponent(availablesInput, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(18, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btn_back)
        			.addPreferredGap(ComponentPlacement.RELATED, 581, Short.MAX_VALUE)
        			.addComponent(jLabel9)
        			.addGap(97))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(btn_back, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addGap(67))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addGap(29)))
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
        					.addGap(43))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(codeInput, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel1))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(nameInput, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(descriptionInput, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel3))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(startDateInput, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel4))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(DestinateInput, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel5))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(18)
        							.addComponent(presentatorInput, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(20)
        							.addComponent(jLabel6)))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(GuideInput, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(availablesInput, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel7)
        							.addGap(24)
        							.addComponent(jLabel8)))
        					.addGap(62)))
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_edit, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(btn_clear, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(viewCustomerListButton, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(btn_delete, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        				.addComponent(btn_add, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        			.addGap(27))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        if(GuideId < 0){
            dispose();
            AdminHome homeScreen = new AdminHome();
            homeScreen.setLocationRelativeTo(null);
            homeScreen.setVisible(true);
        }else{
            Guide Guide;
            try {
                dispose();
                Guide = GuideService.getGuideById(GuideId);
                List<Tour> tours = tourServices.getToursByGuideId(GuideId);
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
            }
        }
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String tourName = this.nameInput.getText().trim();
            String tourCode = this.codeInput.getText().trim();
            String tourDes = this.descriptionInput.getText().trim();
            String tourDate = this.startDateInput.getText().trim();
            String presentator = this.presentatorInput.getText().trim();
            
            if(tourDate.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Ngày bắt đầu không được trống", "Thông báo");
                return;
            }
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(tourDate, formatter);
            LocalDate currentDate = LocalDate.now();
            
            String availablesText = this.availablesInput.getText().trim();
            if (availablesText.isEmpty()) {
                MessageDialog.showInfoDialog(this, "Số lượng không được trống", "Thông báo");
                return;
            }

            int availables = Integer.parseInt(availablesText);
            
            if(tourCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã tour cắm trại không được trống", "Thông báo");
                return;
            }
            if(tourName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên tour cắm trại không được trống", "Thông báo");
                return;
            }
            if(tourDes.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mô tả tour cắm trại không được trống", "Thông báo");
                return;
            }
            
            if (currentDate.compareTo(inputDate) >= 0) {
                MessageDialog.showInfoDialog(this, "Ngày khởi hành của chuyến đi phải lớn hơn ngày hiện tại", "Thông báo");
                return;
            }
            if(presentator.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Người đại diện không được trống", "Thông báo");
                return;
            }
            if(availables < 10){
                MessageDialog.showInfoDialog(this, "Số lượng không được dưới 10 người", "Thông báo");
                return;
            }
            if(!isDate(tourDate)){
                MessageDialog.showInfoDialog(this, "Nhập ngày không đúng định dạng", "Thông báo");
                return;
            }
            if(tourServices.isExistedTourCode(tourCode)){
                MessageDialog.showInfoDialog(this, "Mã tour cắm trại đã tồn tại", "Thông báo");
                return;
            }
            if(DestinateInput.getSelectedItem() instanceof String && GuideInput.getSelectedItem() instanceof String){
                String selectedDestinateName = (String) DestinateInput.getSelectedItem();
                String selectedGuideName = (String) GuideInput.getSelectedItem();
                
                
                List<Destinate> Destinate_data = DestinateService.getAllDestinate();
                
                Destinate selectedDestinate = null;
                for(Destinate Destinate : Destinate_data){
                    if(Destinate.getName().equalsIgnoreCase(selectedDestinateName)){
                        selectedDestinate = Destinate;
                        break;
                    }
                }
                
                int DestinateId = DestinateService.getIdByDestinateName(selectedDestinate.getName());
                System.out.println("DestinateId : " + DestinateId);


                int GuideId = GuideService.getIdByGuideName(selectedGuideName);
                System.out.println("GuideId: " + GuideId);
                
                Guide Guide = GuideService.getGuideById(GuideId);
                System.out.println("Guide Code: " + Guide.getCode());

                Tour tour = new Tour(
                        tourCode, 
                        tourName, 
                        tourDes, 
                        tourDate, 
                        availables, 
                        DestinateId, 
                        GuideId, 
                        presentator);

                tourServices.addTour(tour);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
                clearAllFields();
                
                /*
                ManageToursOfGuide manageToursOfGuide = new ManageToursOfGuide(Guide);
            if (manageToursOfGuide != null) {
                manageToursOfGuide.setLocationRelativeTo(null);
                manageToursOfGuide.setVisible(true);
                manageToursOfGuide.setImagePath(Guide.getImagePath());
                manageToursOfGuide.getGuideIdLabel().setText("Mã địa điểm: " + Guide.getCode());
                manageToursOfGuide.getGuideNameLabel().setText("Tên giáo viên: " + Guide.getLastName() + " " + Guide.getFirstName());
                manageToursOfGuide.getGuidePhoneNumberLabel().setText("Số điện thoại: " + Guide.getPhoneNumber());
                manageToursOfGuide.getGuideEmailLable().setText("Email: " + Guide.getEmail());
                manageToursOfGuide.getGuideAdressLable().setText("Địa chỉ: " + Guide.getAddress());
                manageToursOfGuide.setGuideID(Guide.getId());
                manageToursOfGuide.initializeTable();
                dispose();
            }
                
                */
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void tourTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tourTableMouseClicked
        try {
            int index = tourTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn tour cắm trại", "Thông báo");
                return;
            }
            
            String code = (String) tourTable.getValueAt(index, 0);
            String name = (String) tourTable.getValueAt(index, 1);
            String date = (String) tourTable.getValueAt(index, 2);
            String description = (String) tourTable.getValueAt(index, 3);
            String presentors = (String) tourTable.getValueAt(index, 5);
            
            
            Object availablesObject = tourTable.getValueAt(index, 4);
            int availables = 0;
            if (availablesObject instanceof Integer) {
                Integer availablesValue = (Integer) availablesObject;
                String availablesText = String.valueOf(availablesValue);

                // Tiếp tục xử lý
                availables = Integer.parseInt(availablesText);
            } else if (availablesObject instanceof String) {
                String availablesText = (String) availablesObject;

                // Tiếp tục xử lý
                availables = Integer.parseInt(availablesText);
            } else {
                // Xử lý theo trường hợp không xác định, tùy thuộc vào logic ứng dụng của bạn
                System.out.println("Giá trị không phải kiểu Integer hoặc String");
            }
            int tourId = tourServices.getIdByTourCode(code);
            
            int DestinateId = tourServices.getDestinateIdByTourId(tourId);
            
            int GuideId = tourServices.getGuideIdByTourId(tourId);
            
            Guide Guide = GuideService.getGuideById(GuideId);
            Destinate Destinate = DestinateService.getDestinateById(DestinateId);
            
            GuideInput.setSelectedItem(Guide.getLastName() + " " + Guide.getFirstName());
            DestinateInput.setSelectedItem(Destinate.getName());
            codeInput.setText(code);
            nameInput.setText(name);
            descriptionInput.setText(description);
            startDateInput.setText(date);
            presentatorInput.setText(presentors);
            availablesInput.setText(String.valueOf(availables));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tourTableMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearAllFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = tourTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn tour cắm trại", "Thông báo");
                return;
            }
            
            String code = (String) tourTable.getValueAt(index, 0);
            
            int tourId = tourServices.getIdByTourCode(code);
            
            Tour tour = tourServices.getTourById(tourId);
            
            String tourName = this.nameInput.getText().trim();
            String tourCode = this.codeInput.getText().trim();
            String tourDes = this.descriptionInput.getText().trim();
            String tourDate = this.startDateInput.getText().trim();
            String presentator = this.presentatorInput.getText().trim();
            
            if(tourDate.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Ngày bắt đầu không được trống", "Thông báo");
                return;
            }
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(tourDate, formatter);
            LocalDate currentDate = LocalDate.now();
            
            String availablesText = this.availablesInput.getText().trim();
            if (availablesText.isEmpty()) {
                MessageDialog.showInfoDialog(this, "Số lượng bắt đầu không được trống", "Thông báo");
                return;
            }

            int availables = Integer.parseInt(availablesText);
            
            if(tourCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã tour cắm trại không được trống", "Thông báo");
                return;
            }
            if(tourName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên tour cắm trại không được trống", "Thông báo");
                return;
            }
            if(tourDes.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mô tả tour cắm trại không được trống", "Thông báo");
                return;
            }
            
            if (currentDate.compareTo(inputDate) >= 0) {
                MessageDialog.showInfoDialog(this, "Ngày khởi hành của chuyến đi phải lớn hơn ngày hiện tại", "Thông báo");
                return;
            }
            if(presentator.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Người đại diện không được trống", "Thông báo");
                return;
            }
            if(availables < 10){
                MessageDialog.showInfoDialog(this, "Số lượng không được dưới 10 người", "Thông báo");
                return;
            }
            if(tourServices.isExistedTourCode(tourCode) && !tourCode.equals(code)){
                MessageDialog.showInfoDialog(this, "Mã tour cắm trại không đã tồn tại", "Thông báo");
                return;
            }
            
            String selectedDestinateName = (String) DestinateInput.getSelectedItem();
            String selectedGuideName = (String) GuideInput.getSelectedItem();

            List<Destinate> Destinate_data = DestinateService.getAllDestinate();

            Destinate selectedDestinate = null;
            for(Destinate Destinate : Destinate_data){
                if(Destinate.getName().equalsIgnoreCase(selectedDestinateName)){
                    selectedDestinate = Destinate;
                    break;
                }
            }

            int DestinateId = DestinateService.getIdByDestinateName(selectedDestinate.getName());
            System.out.println("DestinateId : " + DestinateId);

            int GuideId = GuideService.getIdByGuideName(selectedGuideName);
            System.out.println("GuideId: " + GuideId);
            
            tour.setCode(tourCode);
            tour.setName(tourName);
            tour.setDescription(tourDes);
            tour.setPresentator(presentator);
            tour.setStartDate(tourDate);
            tour.setAvailables(availables);
            tour.setDestinateId(DestinateId);
            tour.setGuideId(GuideId);
            
            tourServices.updateTour(tour, tourId);
            loadTableData();
            MessageDialog.showInfoDialog(this, "Cập nhật khách hàng thành công", "Thông báo");
            clearAllFields();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = tourTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn tour cắm trại", "Thông báo");
                return;
            }
            
            String code = (String) tourTable.getValueAt(index, 0);
            
            int tourId = tourServices.getIdByTourCode(code);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tour cắm trại này không?", "Xác nhận xóa");
            if(confirm == 0){
                tourServices.deleteTourById(tourId);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Xóa sinh tour cắm trại thành công", "Thông báo");
                clearAllFields();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void viewCustomerListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCustomerListButtonActionPerformed
        try {
            int index = tourTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui chọn tour cắm trại địa điểm trước để xem danh sách khách hàng tham gia", "Thông báo");
                return;
            }
            String code = (String)tourTable.getValueAt(index, 0);
            
            int tourId = tourServices.getIdByTourCode(code);
            
            Tour selectedTour = tourServices.getTourById(tourId);
            
            ManageTourCustomer manageTourCustomer = new ManageTourCustomer(selectedTour);
            manageTourCustomer.setVisible(true);
            manageTourCustomer.setLocationRelativeTo(null);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_viewCustomerListButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageTour().setVisible(true);
        });
    }
    
    private TourService tourServices;
    private GuideService GuideService;
    private DestinateService DestinateService;
    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField availablesInput;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JTextField codeInput;
    private javax.swing.JComboBox<Object> DestinateInput;
    private javax.swing.JTextField descriptionInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField presentatorInput;
    private javax.swing.JTextField startDateInput;
    private javax.swing.JComboBox<Object> GuideInput;
    private javax.swing.JTable tourTable;
    private javax.swing.JButton viewCustomerListButton;
    // End of variables declaration//GEN-END:variables
}
