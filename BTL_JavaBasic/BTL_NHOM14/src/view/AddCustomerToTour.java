package view;

import exception.MessageDialog;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.*;
import services.*;

public class AddCustomerToTour extends javax.swing.JFrame {
    
    private CustomerService CustomerService;
    private TeamService TeamService;
    private CustomerTourService CustomerTourService;
    private TourService tourService;
    
    public AddCustomerToTour() {
        initComponents();
        CustomerService = new CustomerService();
        TeamService = new TeamService();
        CustomerTourService = new CustomerTourService();
        tourService = new TourService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    private Tour selectedTour;

    public AddCustomerToTour(Tour tour) {
        CustomerService = new CustomerService();
        TeamService = new TeamService();
        CustomerTourService = new CustomerTourService();
        tourService = new TourService();
        try {
            this.selectedTour = tour;
            initComponents();
            setLocationRelativeTo(null);
            initializeTable();
            screenTitle.setText("" + tour.getName() + " (Mã: " + tour.getCode() + ", công ty: " + tour.getName() + ") - Ngày: " + tour.getStartDate());
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }
    
    private void handleSearchByKeyword(){
        try {
            String keyword = searchInput.getText().trim();
            if(keyword.trim().equals("")){
                MessageDialog.showInfoDialog(this, "Chưa có từ khóa tìm kiếm", "Thông báo");
                return;
            }
            List<Customer> data = CustomerService.getAllCustomers();
            List<Customer> displayData = new ArrayList<>();
            List<CustomerTour> selectedData = new ArrayList<>();
            
            if(CustomerTourService.getAllCustomerToursByTourId(selectedTour.getId()) == null){
                CustomerTourService.addListCustomerTours(new ArrayList<>());
            }
            
            for (Customer Customer : data) {
                boolean isExisted = false;
                for (CustomerTour selectedRel : selectedData) {
                    if (selectedRel.getCustomerId() == CustomerService.getIdByCustomer(Customer.getCode())) {
                        isExisted = true;
                        break;
                    }
                }
                if (!isExisted) {
                    displayData.add(Customer);
                }
            }
            
            tableModel.setRowCount(0);
            if (displayData != null) {
                for (Customer cus : displayData) {
                    if (cus.getAddress().contains(keyword) || cus.getCode().contains(keyword) || cus.getFirstName().contains(keyword) || cus.getLastName().contains(keyword) || cus.getPhoneNumber().contains(keyword)) {
                    tableModel.addRow(
                            new Object[]{
                                cus.getCode(),
                                cus.getLastName(),
                                cus.getFirstName(),
                                TeamService.getTeamNameById(cus.getTeamId()).getName(),
                                cus.getBirthDate(),
                                cus.getPhoneNumber(),
                                cus.getEmail(),
                                cus.getAddress()
                            });
                    }
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabel = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        screenTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        addToListButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLabel.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        JLabel.setText("Thêm sinh viên tham gia chuyến cắm trại");

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Quay lại");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        screenTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        screenTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        screenTitle.setText("Tên công ty - Ngày diễn ra");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Tìm kiếm sinh viên:");

        searchInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        searchInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchInputKeyPressed(evt);
            }
        });

        findButton.setBackground(new java.awt.Color(0, 102, 153));
        findButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        findButton.setForeground(new java.awt.Color(255, 255, 255));
        findButton.setText("Tìm kiếm");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        resetButton.setBackground(new java.awt.Color(102, 153, 0));
        resetButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("Nhập lại");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        addToListButton.setBackground(new java.awt.Color(0, 102, 51));
        addToListButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addToListButton.setForeground(new java.awt.Color(255, 255, 255));
        addToListButton.setText("Thêm sinh viên vào chuyến đi");
        addToListButton.setPreferredSize(new java.awt.Dimension(269, 37));
        addToListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToListButtonActionPerformed(evt);
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
        jScrollPane1.setViewportView(CustomerTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(screenTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(findButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addToListButton, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(searchInput))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btn_back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(JLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btn_back)
                .addGap(18, 18, 18)
                .addComponent(JLabel)
                .addGap(18, 18, 18)
                .addComponent(screenTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(addToListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        ManageTourCustomer screen = new ManageTourCustomer(selectedTour);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void addToListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToListButtonActionPerformed
        try {
            int chosenIndex[] = CustomerTable.getSelectedRows();
            if (chosenIndex.length == 0) {
                MessageDialog.showInfoDialog(this, "Chưa có sinh viên nào được chọn để thực hiện chức năng này", "Thông báo");
                return;
            }
            
            List<Customer> chosenCustomers = new ArrayList<>();
            for (int index : chosenIndex) {
                String code = (String) CustomerTable.getValueAt(index, 0);
                Customer Customer = CustomerService.getCustomerByCustomerCode(code);
                if (Customer != null) {
                    chosenCustomers.add(Customer);
                }
            }
            System.out.println("ChosenCustomers: " + chosenCustomers);
            
//            List<CustomerTour> CustomerTourData = CustomerTourService.getAllCustomerTours();
//            if(CustomerTourService.getAllCustomerToursByTourId(selectedTour.getId()) == null){
//                CustomerTourService.addListCustomerTours(new ArrayList<>());
//            }

            List<CustomerTour> CustomerTourData = new ArrayList<>();

            for (Customer Customer : chosenCustomers) {
                CustomerTour relationship = new CustomerTour();
                relationship.setCustomerId(Customer.getId());
                relationship.setRate(0);
                relationship.setTourId(selectedTour.getId());
                CustomerTourData.add(relationship); 
                CustomerTourService.getAllCustomerToursByTourId(selectedTour.getId()).add(relationship);
                if (CustomerTourService.getAllCustomerToursByCustomerId(Customer.getId()) == null) {
                    CustomerService.addListCustomers(new ArrayList<>());
                }
                CustomerTourService.getAllCustomerToursByCustomerId(Customer.getId()).add(relationship);
            }
            CustomerTourService.addListCustomerTours(CustomerTourData);
            
            List<Customer> CustomerData = CustomerService.getAllCustomers();
            for (int i = 0; i < CustomerData.size(); i++) {
                for (Customer tempCustomer : chosenCustomers) {
                    if (CustomerData.get(i).getId() == tempCustomer.getId()) {
                        CustomerData.set(i, tempCustomer);
                    }
                }
            }
            
            List<Tour> tourData = tourService.getAllTours();
            for (int i = 0; i < tourData.size(); i++) {
                if (tourData.get(i).getId() == selectedTour.getId()) {
                    tourData.set(i, selectedTour);
                    break;
                }
            }
            
            clearAllFields();
            MessageDialog.showInfoDialog(this, "Đã thêm thành công " + chosenIndex.length + " sinh viên vào chuyến tham quan!", "Thông báo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addToListButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        clearAllFields();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        handleSearchByKeyword();
    }//GEN-LAST:event_findButtonActionPerformed

    private void searchInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            // Handle Enter key press
            handleSearchByKeyword();
        }
    }//GEN-LAST:event_searchInputKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCustomerToTour().setVisible(true);
            }
        });
    }
    
    private void clearAllFields() {
        searchInput.setText("");
        loadTableData();
    }
    
    private void loadTableData() {
        try {
            List<Customer> data = CustomerService.getAllCustomers();
            List<Customer> displayData = new ArrayList<>();
            List<CustomerTour> selectedData = new ArrayList<>();
            if (CustomerTourService.getAllCustomerToursByTourId(selectedTour.getId()) != null) {
                selectedData = CustomerTourService.getAllCustomerToursByTourId(selectedTour.getId());
            }// selectedData: [3,2,9]

            for (Customer Customer : data) {
                boolean isExisted = false;
                for (CustomerTour selectedRel : selectedData) {
                    if (selectedRel.getCustomerId() == CustomerService.getIdByCustomer(Customer.getCode())) {
                        isExisted = true;
                        break;
                    }
                }
                if (!isExisted) {
                    displayData.add(Customer);
                }
            }
            tableModel.setRowCount(0);
            if (displayData != null) {
                for (Customer cus : displayData) {
                    tableModel.addRow(
                            new Object[]{
                                cus.getCode(),
                                cus.getLastName(),
                                cus.getFirstName(),
                                TeamService.getTeamNameById(cus.getTeamId()).getName(),
                                cus.getBirthDate(),
                                cus.getPhoneNumber(),
                                cus.getEmail(),
                                cus.getAddress()
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
        tableModel.setColumnIdentifiers(new String[]{"Mã khách hàng", "Họ", "Tên", "Ngày sinh", "Team", "SĐT", "Email", "Địa chỉ",});
        CustomerTable.setModel(tableModel);
        loadTableData();
    }

    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel;
    private javax.swing.JButton addToListButton;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton findButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel screenTitle;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTable CustomerTable;
    // End of variables declaration//GEN-END:variables
}
