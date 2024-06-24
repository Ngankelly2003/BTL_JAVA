package view;

import exception.MessageDialog;
import exception.TransmittedDataShowData;
import models.*;
import services.*;

public class RateCustomerResult extends javax.swing.JFrame {
    private Tour selectedTour;
    private Customer selectedCustomer;
    private boolean isShowData = false;
    
    private CustomerTourService CustomerTourService;
    private TourService tourService;
    
    public RateCustomerResult() {
        initComponents();
        CustomerTourService = new CustomerTourService();
        tourService = new TourService();
        setLocationRelativeTo(null);
    }
    
    public RateCustomerResult(Tour tour , Customer Customer){
        this.selectedTour = tour;
        this.selectedCustomer = Customer;
        CustomerTourService = new CustomerTourService();
        tourService = new TourService();
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        String CustomerScreenTitle = Customer.getLastName() + " " + Customer.getFirstName() + " (Mã: " + Customer.getCode() + ") trong chuyến tham quan";
        CustomerTitle.setText(CustomerScreenTitle);
        String tourTitle = tour.getName() + " (Mã: " + tour.getCode() + ", công ty: " + tour.getName() + ") - Ngày: " + tour.getStartDate();
        tourNameTitle.setText(tourTitle);
    }
    
    public RateCustomerResult(Tour tour , Customer Customer, boolean isShowData){
        this.selectedTour = tour;
        this.selectedCustomer = Customer;
        this.isShowData = isShowData;
        CustomerTourService = new CustomerTourService();
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        String CustomerScreenTitle = Customer.getLastName() + " " + Customer.getFirstName() + " (Mã: " + Customer.getCode() + ") trong chuyến tham quan";
        CustomerTitle.setText(CustomerScreenTitle);
        String tourTitle = tour.getName() + " (Mã: " + tour.getCode() + ", công ty: " + tour.getName() + ") - Ngày: " + tour.getStartDate();
        tourNameTitle.setText(tourTitle);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        screenTitle = new javax.swing.JLabel();
        CustomerTitle = new javax.swing.JLabel();
        tourNameTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        inputRate1 = new javax.swing.JTextField();
        inputRate2 = new javax.swing.JTextField();
        inputRate4 = new javax.swing.JTextField();
        inputRate3 = new javax.swing.JTextField();
        inputRate5 = new javax.swing.JTextField();
        inputRate6 = new javax.swing.JTextField();
        inputRate7 = new javax.swing.JTextField();
        inputRate11 = new javax.swing.JTextField();
        inputRate9 = new javax.swing.JTextField();
        inputRate10 = new javax.swing.JTextField();
        inputRate8 = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        rateCustomerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Quay lại");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        screenTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        screenTitle.setText("Đánh giá sinh viên tham gia chuyến tham quan");

        CustomerTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CustomerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CustomerTitle.setText("Tên + Mã SV trong chuyến tham quan");

        tourNameTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tourNameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tourNameTitle.setText("Tên công ty - Ngày diễn ra");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("1. Đánh giá sự hiểu biết của sinh viên về doanh nghiệp");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Hiểu biết cơ bản về doanh nghiệp tham quan (0 - 10 đ)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tìm hiểu các yêu cầu và vị trí việc làm tại doanh nghiệp (0 - 5 đ)");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("2. Đánh giá sự hiểu biết của dinh viên về ngành nghề của mình");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Hiểu biết cơ bản về ngành nghề mình đang hướng đến (0 - 10 đ)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Khả năng áp dụng kiến thức trong bối cảnh thực tế (0 - 5 đ)");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("3. Kỹ năng quan sát và phân tích của sinh viên trong môi trường công việc");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Nhận diện và phân tích các quy trình và hoạt động của doanh nghiệp (0 - 10 đ)");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Đánh giá và phân tích môi trường làm việc (0 - 10 đ)");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("4. Đánh khá khả năng giao tiếp, tương tác, đóng góp của sinh viên");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Tương tác với nhân viên và đại diện doanh nghiệp (0 - 10 đ)");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Giao tiếp linh hoạt, chân thực (0 - 10 đ)");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("5. Đánh giá sự hứng thú và đam mê của sinh viên (0 - 10 đ)");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("6. Đánh giá ý thức chấp hành các quy định trong chuyến tham quan");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Chấp hành đầy đủ quy định của nhà trường (0 - 10 đ)");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Chấp hành quy định khi tham quan doanh nghiệp (0 - 10 đ)");

        inputRate1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inputRate2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inputRate4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inputRate3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inputRate5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inputRate6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inputRate7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inputRate11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inputRate9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inputRate10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        inputRate8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        resetButton.setBackground(new java.awt.Color(102, 153, 0));
        resetButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("Nhập lại");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        rateCustomerButton.setBackground(new java.awt.Color(0, 102, 51));
        rateCustomerButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rateCustomerButton.setForeground(new java.awt.Color(255, 255, 255));
        rateCustomerButton.setText("Đánh giá");
        rateCustomerButton.setPreferredSize(new java.awt.Dimension(269, 37));
        rateCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateCustomerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputRate8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRate9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRate6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRate7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRate5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRate4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRate3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRate2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRate1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRate10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputRate11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(rateCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(CustomerTitle))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(tourNameTitle))
                            .addComponent(screenTitle, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(screenTitle)
                .addGap(12, 12, 12)
                .addComponent(CustomerTitle)
                .addGap(12, 12, 12)
                .addComponent(tourNameTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(inputRate1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3))
                            .addComponent(inputRate2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(inputRate3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(inputRate4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(inputRate11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(inputRate10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(inputRate5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(inputRate7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(inputRate6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(inputRate8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputRate9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rateCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        try{
            int rate = getTotalRate();
            if(rate < 0 || rate > 100)
            {
                 MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
                 return;
            }
            CustomerTourService.updateRateCustomer(this.selectedCustomer.getId(), this.selectedTour.getId(), rate);
            this.selectedTour = tourService.getTourById(this.selectedTour.getId());
            if(isShowData){
                dispose();
                TransmittedDataShowData showSata = new TransmittedDataShowData("CustomerTookPlaceTours", "GuideAndCustomerHome", selectedTour.getId(), selectedTour.getGuideId(), false);
                ShowData screen = new ShowData(showSata);
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }else{
                dispose();
                ManageTourCustomer screen = new ManageTourCustomer(this.selectedTour);
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_backActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        inputRate1.setText("");
        inputRate2.setText("");
        inputRate3.setText("");
        inputRate4.setText("");
        inputRate5.setText("");
        inputRate6.setText("");
        inputRate7.setText("");
        inputRate8.setText("");
        inputRate9.setText("");
        inputRate10.setText("");
        inputRate11.setText("");
    }//GEN-LAST:event_resetButtonActionPerformed
    
    private int getTotalRate() throws Exception {
        int rate = 0;
        try {
            int rate1 = Integer.parseInt(this.inputRate1.getText().trim());
            int rate2 = Integer.parseInt(this.inputRate2.getText().trim());
            int rate3 = Integer.parseInt(this.inputRate3.getText().trim());
            int rate4 = Integer.parseInt(this.inputRate4.getText().trim());
            int rate5 = Integer.parseInt(this.inputRate5.getText().trim());
            int rate6 = Integer.parseInt(this.inputRate6.getText().trim());
            int rate7 = Integer.parseInt(this.inputRate7.getText().trim());
            int rate8 = Integer.parseInt(this.inputRate8.getText().trim());
            int rate9 = Integer.parseInt(this.inputRate9.getText().trim());
            int rate10 = Integer.parseInt(this.inputRate10.getText().trim());
            int rate11 = Integer.parseInt(this.inputRate11.getText().trim());
            if (rate1 < 0 || rate1 > 10) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            if (rate2 < 0 || rate2 > 5) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            if (rate3 < 0 || rate3 > 10) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            if (rate4 < 0 || rate4 > 5) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            if (rate5 < 0 || rate5 > 10) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            if (rate6 < 0 || rate6 > 10) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            if (rate7 < 0 || rate7 > 10) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            if (rate8 < 0 || rate8 > 10) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            if (rate9 < 0 || rate9 > 10) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            if (rate10 < 0 || rate10 > 10) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            if (rate11 < 0 || rate11 > 10) {
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
            }
            rate = rate1 + rate2 + rate3 + rate4 + rate5 + rate6 + rate7 + rate8 + rate9 + rate10 + rate11;
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
        return rate;
    }
    
    private void rateCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateCustomerButtonActionPerformed
        try {
            int rate = getTotalRate();
            if(rate < 0 || rate > 100){
                MessageDialog.showInfoDialog(this, "Điểm không hợp kệ", "Thông báo");
                return;
            }
            CustomerTourService.updateRateCustomer(this.selectedCustomer.getId(), this.selectedTour.getId(), rate);
            if(isShowData){
                dispose();
                TransmittedDataShowData showSata = new TransmittedDataShowData("CustomerTookPlaceTours", "GuideAndCustomerHome", selectedTour.getId(), selectedTour.getGuideId(), false);
                ShowData screen = new ShowData(showSata);
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }else{
                dispose();
                ManageTourCustomer screen = new ManageTourCustomer(this.selectedTour);
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_rateCustomerButtonActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RateCustomerResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JTextField inputRate1;
    private javax.swing.JTextField inputRate10;
    private javax.swing.JTextField inputRate11;
    private javax.swing.JTextField inputRate2;
    private javax.swing.JTextField inputRate3;
    private javax.swing.JTextField inputRate4;
    private javax.swing.JTextField inputRate5;
    private javax.swing.JTextField inputRate6;
    private javax.swing.JTextField inputRate7;
    private javax.swing.JTextField inputRate8;
    private javax.swing.JTextField inputRate9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton rateCustomerButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel screenTitle;
    private javax.swing.JLabel CustomerTitle;
    private javax.swing.JLabel tourNameTitle;
    // End of variables declaration//GEN-END:variables
}
