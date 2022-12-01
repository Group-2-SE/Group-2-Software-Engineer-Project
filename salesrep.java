package auto;
import java.util.*;
import java.io.*;

public class salesrep extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public salesrep() {
        initComponents();
    }        
    private void initComponents() {

        carinvent = new javax.swing.JButton();
        trkcustprog = new javax.swing.JButton();
        custinfo = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        carinvent.setText("View Car Inventory");
        carinvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carinventMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                carinventMousePressed(evt);
            }
        });
        carinvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carinventActionPerformed(evt);
            }
        });

        trkcustprog.setText("Track Customer Progress ");
        trkcustprog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trkcustprogActionPerformed(evt);
            }
        });

        custinfo.setText(" Customer Information ");
        custinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custinfoActionPerformed(evt);
            }
        });

        logout.setText("Logout ");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(trkcustprog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carinvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(custinfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(carinvent)
                .addGap(92, 92, 92)
                .addComponent(trkcustprog)
                .addGap(64, 64, 64)
                .addComponent(custinfo)
                .addGap(86, 86, 86)
                .addComponent(logout)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void trkcustprogActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // 
    }                                           

    private void custinfoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // T
    }                                        

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // 
    }                                      

    private void carinventActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // 
    }                                         

    private void carinventMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // 
        
    
    }                                      

    private void carinventMousePressed(java.awt.event.MouseEvent evt) {                                       
        // 
    }                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(salesrep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(salesrep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(salesrep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(salesrep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Creates and displays the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new salesrep().setVisible(true);
            }
        });
    }

    // Variables declaration                   
    private javax.swing.JButton carinvent;
    private javax.swing.JButton custinfo;
    private javax.swing.JButton logout;
    private javax.swing.JButton trkcustprog;
    // End of variables declaration                   
}