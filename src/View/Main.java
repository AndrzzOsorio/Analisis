/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Tree.Tree;
import Code.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.Rectangle;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author 4NDR35
 */
public class Main extends javax.swing.JFrame {

    LinkedList<Point> points;
    Point point = new Point();
    Control c;
    LinkedList<Area> recs;
    Boolean painting = true;
    private int NWeight = 400;
    private int NHeight = 500;
    private int NPoints = 0;
    private int NColors = 0;
    

    public Main(LinkedList<Point> points, Control c, LinkedList<Area> recs, JButton btncolors, Interface interface1, JButton jButton1) throws HeadlessException {
        this.points = points;
        this.c = c;
        this.recs = recs;
        this.btncolors = btncolors;
        this.interface1 = interface1;
        this.btndivide = jButton1;
    }

    public Main() {
        initComponents();
        interface1.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        this.setResizable(false);
        this.setBounds(0, 0, NWeight, NHeight);
        this.setVisible(true);
        points = new LinkedList<>();
        Tree t;
        c = new Control();
        recs = new LinkedList<>();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        interface1 = new View.Interface();
        btncolors = new javax.swing.JButton();
        btndivide = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        interface1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                interface1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout interface1Layout = new javax.swing.GroupLayout(interface1);
        interface1.setLayout(interface1Layout);
        interface1Layout.setHorizontalGroup(
            interface1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        interface1Layout.setVerticalGroup(
            interface1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        btncolors.setBackground(new java.awt.Color(51, 0, 0));
        btncolors.setForeground(new java.awt.Color(255, 255, 255));
        btncolors.setText("Colors");
        btncolors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncolorsActionPerformed(evt);
            }
        });

        btndivide.setBackground(new java.awt.Color(51, 0, 0));
        btndivide.setForeground(new java.awt.Color(255, 255, 255));
        btndivide.setText("Divide");
        btndivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndivideActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 0, 0));
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setText("Groups");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Automatic");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(interface1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btndivide, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncolors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(interface1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncolors)
                    .addComponent(btndivide))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void interface1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_interface1MouseClicked
        point = new Point(evt.getX(), evt.getY());
        if (painting == true) {
            points.add(new Point(evt.getX(), evt.getY()));
            interface1.SetPoints(points);
            this.repaint();
        } else if (PointSelection(point)) {
            if (c.contains(point).size() > 1) {
                recs = c.contains(point);
                interface1.SetColors(recs);
                this.repaint();
            }
        }

    }//GEN-LAST:event_interface1MouseClicked

    private void btndivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndivideActionPerformed
        c.standar(points, this.getWidth(), this.getHeight());
        interface1.SetControl(c);
        this.repaint();
        painting = false;

    }//GEN-LAST:event_btndivideActionPerformed

    private void btncolorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncolorsActionPerformed
        recs = c.Colors();
        interface1.SetColors(recs);
        this.repaint();


    }//GEN-LAST:event_btncolorsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        c.group(points, NWeight, NHeight);
        this.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        NPoints = new Integer(JOptionPane.showInputDialog("Please, especify the number of points"));
        NColors = new Integer(JOptionPane.showInputDialog("Please, especify the minimun number of colors to use"));
        NWeight = new Integer(JOptionPane.showInputDialog("Please, especify the width of the new panel"));
        NHeight = new Integer(JOptionPane.showInputDialog("Please, especify the heigth of the new panel"));
        for (int i = 0; i < NPoints; i++) {
            points.add(new Point(Math.random() * NWeight, Math.random() * NHeight));
        }
        interface1.SetPoints(points);
        c.standar(points, NWeight, NHeight);
        interface1.SetControl(c);
        for (int i = 0; i < NColors; i++) {
            c.Newcolor();
        }
        recs = c.Colors2();

        interface1.SetColors(recs);
        this.repaint();
        this.setBounds(0, 0, NWeight, NHeight);
        this.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncolors;
    private javax.swing.JButton btndivide;
    private View.Interface interface1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables

    private boolean PointSelection(Point p) {
        boolean intersect = false;
        for (int i = 0; i < points.size(); i++) {
            if (p.getCoordx() >= points.get(i).getCoordx()
                    && p.getCoordx() <= points.get(i).getCoordx() + 10
                    && p.getCoordy() >= points.get(i).getCoordy()
                    && p.getCoordy() <= points.get(i).getCoordy() + 10) {
                intersect = true;
            }

        }
        return intersect;
    }

    /**
     * @return the NWeight
     */
    public int getNWeight() {
        return NWeight;
    }

    /**
     * @param NWeight the NWeight to set
     */
    public void setNWeight(int NWeight) {
        this.NWeight = NWeight;
    }

    /**
     * @return the NHeight
     */
    public int getNHeight() {
        return NHeight;
    }

    /**
     * @param NHeight the NHeight to set
     */
    public void setNHeight(int NHeight) {
        this.NHeight = NHeight;
    }

    /**
     * @return the NPoints
     */
    public int getNPoints() {
        return NPoints;
    }

    /**
     * @param NPoints the NPoints to set
     */
    public void setNPoints(int NPoints) {
        this.NPoints = NPoints;
    }

    /**
     * @return the NColors
     */
    public int getNColors() {
        return NColors;
    }

    /**
     * @param NColors the NColors to set
     */
    public void setNColors(int NColors) {
        this.NColors = NColors;
    }

}
