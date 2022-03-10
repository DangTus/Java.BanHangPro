package view;

import view.*;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;
import service.UserService;
import view.admin.QLUser;
import view.user.UserDrawMoney;
import view.user.UserEditPassword;
import view.user.UserInformation;

public class HomePage extends javax.swing.JFrame {

    private UserService userService = null;
    User user = null;

    public HomePage(User user) throws SQLException {

        userService = new UserService();
        this.user = user;

        initComponents();
        //hiển thị tên
        if (user.getRole() == 2) {
            roleLabel.setText("Xin chào người dùng".toUpperCase());
            qlUserBT.setVisible(false);
        } else if (user.getRole() == 1) {
            roleLabel.setText("Xin chào quản trị".toUpperCase());
            rutTienButton.setVisible(false);
            soDuTF.setVisible(false);
            soDuL.setVisible(false);
        }
        nameLabel.setText(user.getName().toUpperCase());
        //hiển thị số dư
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        String soDu = vn.format(user.getSoDu());
        soDuTF.setText(soDu + " VNĐ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new javax.swing.JButton();
        roleLabel = new javax.swing.JLabel();
        soDuL = new javax.swing.JLabel();
        editPasswordButton = new javax.swing.JButton();
        rutTienButton = new javax.swing.JButton();
        soDuTF = new javax.swing.JTextField();
        editPasswordButton1 = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        qlUserBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        logoutButton.setText("Đăng xuất");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        roleLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        roleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roleLabel.setText("XIN CHÀO QUẢN TRỊ");

        soDuL.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        soDuL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        soDuL.setText("Số dư hiện tại");

        editPasswordButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        editPasswordButton.setText("Đổi mật khẩu");
        editPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPasswordButtonActionPerformed(evt);
            }
        });

        rutTienButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rutTienButton.setText("Rút tiền");
        rutTienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutTienButtonActionPerformed(evt);
            }
        });

        soDuTF.setEditable(false);
        soDuTF.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        soDuTF.setMargin(new java.awt.Insets(2, 5, 2, 5));

        editPasswordButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        editPasswordButton1.setText("Xem thông tin");
        editPasswordButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPasswordButton1ActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 51, 51));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("TUS");

        qlUserBT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        qlUserBT.setText("Quản lí người dùng");
        qlUserBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qlUserBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(soDuL, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(soDuTF))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(qlUserBT)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editPasswordButton1)
                                .addGap(31, 31, 31)
                                .addComponent(editPasswordButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(rutTienButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(soDuTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDuL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(qlUserBT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rutTienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPasswordButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muôn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void editPasswordButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPasswordButton1ActionPerformed
        // TODO add your handling code here:
        new UserInformation(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editPasswordButton1ActionPerformed

    private void editPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPasswordButtonActionPerformed
        // TODO add your handling code here:
        new UserEditPassword(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editPasswordButtonActionPerformed

    private void rutTienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutTienButtonActionPerformed
        // TODO add your handling code here:
        new UserDrawMoney(user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rutTienButtonActionPerformed

    private void qlUserBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qlUserBTActionPerformed
        // TODO add your handling code here:
        try {
            new QLUser(user).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_qlUserBTActionPerformed

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
            java.util.logging.Logger.getLogger(QLUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton editPasswordButton;
    private javax.swing.JButton editPasswordButton1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton qlUserBT;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton rutTienButton;
    private javax.swing.JLabel soDuL;
    private javax.swing.JTextField soDuTF;
    // End of variables declaration//GEN-END:variables
}
