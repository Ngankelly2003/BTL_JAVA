package view;

import exception.MessageDialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import models.Guide;
import models.Tour;
import services.GuideService;
import services.TourService;

public class ManageToursOfDestinate extends javax.swing.JFrame {

    
    private int DestinateId;
    private List<Tour> tours = new ArrayList<>();
    
    public void setTours(List<Tour> tours) {
        this.tours = tours;
        loadedDataTable();
    }
    
    public void setDestinateId(int comId) {
        this.DestinateId = comId; 
    }
    
    public int getDestinateId() {
        return DestinateId;
    }
    
    public ManageToursOfDestinate() {
        initComponents();
        setLocationRelativeTo(null);
        tourService = new TourService();
        GuideService = new GuideService();
        initializeTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        JLabel = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        toursOfDestinateTable = new javax.swing.JTable();
        DestinateCodeLabel = new javax.swing.JLabel();
        DestinatePhoneLabel = new javax.swing.JLabel();
        DestinateAddressLabel = new javax.swing.JLabel();
        DestinateNameLabel = new javax.swing.JLabel();
        DestinateTimeStayLabel = new javax.swing.JLabel();
        DestinateDescriptionLabel = new javax.swing.JLabel();

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

        JLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLabel.setText("CÁC TOUR CẮM TRẠI ĐƯỢC TỔ CHỨC");

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setText("Mã địa điểm:   ");

        label2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label2.setText("Hình thức tổ chức : ");

        label3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label3.setText("Địa chỉ:   ");

        label4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label4.setText("Tên địa điểm :   ");

        label5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label5.setText("TimeStay:   ");

        label6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label6.setText("Ghi chú:   ");

        toursOfDestinateTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(toursOfDestinateTable);

        DestinateCodeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DestinateCodeLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DestinatePhoneLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DestinatePhoneLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DestinateAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DestinateAddressLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DestinateNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DestinateNameLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DestinateTimeStayLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DestinateTimeStayLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DestinateDescriptionLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DestinateDescriptionLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DestinateAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label2)
                                    .addComponent(label1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DestinateCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DestinatePhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DestinateDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DestinateTimeStayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label4)
                                .addGap(3, 3, 3)
                                .addComponent(DestinateNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JLabel)
                .addGap(311, 311, 311))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(JLabel)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DestinateNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DestinateCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DestinatePhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DestinateTimeStayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DestinateAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DestinateDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Nút trở lại trang ManageDestinate
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        ManageDestinate Destinate = new ManageDestinate();
        Destinate.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageToursOfDestinate().setVisible(true);
        });
    }
    
    // Hàm load dữ liệu cho bảng
    private void loadedDataTable(){
        try {
            if (tours != null) {
                for (Tour tour : tours) {
                String GuideName = tourService.getGuideNameById(tour.getGuideId());
                tableModel.addRow(new Object[]{
                        tour.getCode(), 
                        tour.getName(),
                        tour.getStartDate(), 
                        tour.getDescription(),
                        tour.getAvailables(),
                        tour.getPresentator(), 
                        GuideName
                });    
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    public void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến",
            "Ngày khởi hành", "Mô tả", "Số ghế","Người thuyết trình","Giáo viên"});
        toursOfDestinateTable.setModel(tableModel);
        loadedDataTable();
    }

    private DefaultTableModel tableModel;
    private TourService tourService;
    private GuideService GuideService;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel;
    private javax.swing.JButton btn_back;
    private javax.swing.JLabel DestinateAddressLabel;
    private javax.swing.JLabel DestinateCodeLabel;
    private javax.swing.JLabel DestinateDescriptionLabel;
    private javax.swing.JLabel DestinateTimeStayLabel;
    private javax.swing.JLabel DestinateNameLabel;
    private javax.swing.JLabel DestinatePhoneLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JTable toursOfDestinateTable;
    // End of variables declaration//GEN-END:variables

    public JLabel getDestinateAddressLabel() {
        return DestinateAddressLabel;
    }

    public void setDestinateAddressLabel(JLabel DestinateAddressLabel) {
        this.DestinateAddressLabel = DestinateAddressLabel;
    }

    public JLabel getDestinateCodeLabel() {
        return DestinateCodeLabel;
    }

    public void setDestinateCodeLabel(JLabel DestinateCodeLabel) {
        this.DestinateCodeLabel = DestinateCodeLabel;
    }

    public JLabel getDestinateDescriptionLabel() {
        return DestinateDescriptionLabel;
    }

    public void setDestinateDescriptionLabel(JLabel DestinateDescriptionLabel) {
        this.DestinateDescriptionLabel = DestinateDescriptionLabel;
    }
    
    public JLabel getDestinateTimeStayLabel() {
        return DestinateTimeStayLabel;
    }

    public void setDestinateTimeStayLabel(JLabel DestinateTimeStayLabel) {
        this.DestinateTimeStayLabel = DestinateTimeStayLabel;
    }

    public JLabel getDestinateNameLabel() {
        return DestinateNameLabel;
    }

    public void setDestinateNameLabel(JLabel DestinateNameLabel) {
        this.label4 = DestinateNameLabel;
    }

    public JLabel getDestinatePhoneLabel() {
        return DestinatePhoneLabel;
    }
    

    public void setDestinatePhoneLabel(JLabel DestinatePhoneLabel) {
        this.DestinatePhoneLabel = DestinatePhoneLabel;
    }

}
