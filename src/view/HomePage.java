package view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;
import service.*;

public class HomePage extends javax.swing.JFrame {

    private UserService userService = null;
    User user = null;
    DefaultTableModel defaultTableModel = null;
    ProductService productService = null;

    public HomePage(User user) throws SQLException {

        userService = new UserService();
        this.user = user;
        productService = new ProductService();

        initComponents();

        //thêm cột cho table
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) { //Cái này là để k cho sửa trực tiếp trên bảng
                return false;
            }
        };
        productTB.setModel(defaultTableModel);
        defaultTableModel.addColumn("id");
        defaultTableModel.addColumn("Tên sản phẩm");
        defaultTableModel.addColumn("Đơn giá");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Trạng thái");
        //thêm dữ liệu vào trong table
        showTableData(productService.getAllProduct());
        
        //tắt 2 nút sửa xóa
        viewProductBT.setVisible(false);
        deleteProductBT.setVisible(false);
    }

    public void showTableData(List<Product> products) {
        for (Product product : products) {
            String trangThai = product.getStatus() == 1 ? "Mở" : "Đóng";
            defaultTableModel.addRow(new Object[]{product.getId(), product.getName(), product.getPrice(),
                 product.getAmount(), trangThai
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productTB = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        viewProductBT = new javax.swing.JButton();
        deleteProductBT = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        editPasswordMI = new javax.swing.JMenuItem();
        logOutMI = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        addProductMI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí sản phẩm");

        productTB.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        productTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        productTB.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        productTB.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        productTB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            }
        });
        productTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTB);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÍ SẢN PHẨM");

        viewProductBT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        viewProductBT.setText("Xem chi tiết");
        viewProductBT.setToolTipText("");

        deleteProductBT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        deleteProductBT.setText("Xóa");

        jMenu1.setText("Tài Khoản");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        editPasswordMI.setText("Đổi mật khẩu");
        editPasswordMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPasswordMIActionPerformed(evt);
            }
        });
        jMenu1.add(editPasswordMI);

        logOutMI.setText("Đăng xuất");
        logOutMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutMIActionPerformed(evt);
            }
        });
        jMenu1.add(logOutMI);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sản phẩm");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        addProductMI.setText("Thêm mới sản phẩm");
        jMenu2.add(addProductMI);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                        .addComponent(viewProductBT)
                        .addGap(167, 167, 167)
                        .addComponent(deleteProductBT)
                        .addGap(275, 275, 275)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewProductBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteProductBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editPasswordMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPasswordMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editPasswordMIActionPerformed

    private void logOutMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutMIActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logOutMIActionPerformed

    private void productTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTBMouseClicked
        // TODO add your handling code here:
        viewProductBT.setVisible(true);
        deleteProductBT.setVisible(true);
    }//GEN-LAST:event_productTBMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addProductMI;
    private javax.swing.JButton deleteProductBT;
    private javax.swing.JMenuItem editPasswordMI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem logOutMI;
    private javax.swing.JTable productTB;
    private javax.swing.JButton viewProductBT;
    // End of variables declaration//GEN-END:variables
}
