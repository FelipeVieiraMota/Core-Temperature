package org.core.temperature.vo.screen.v1;

import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class TemperatureDisplay extends javax.swing.JFrame {

    protected javax.swing.JTextArea areaTemperature;
    protected javax.swing.JMenuItem jMenuItem1;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JMenuBar menuBar;
    protected javax.swing.JMenuItem menuItemAuthor;
    protected javax.swing.JMenu menuItemVersion;

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null,"Version 1.0.0");
    }

    private void menuItemAuthorActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null,"Felipe Vieira Mota - felipevieiramota@gmail.com");
    }

    public TemperatureDisplay() {
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaTemperature = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        menuItemVersion = new javax.swing.JMenu();
        menuItemAuthor = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Core Temperature");
        setBackground(new java.awt.Color(137, 148, 159));
        setResizable(false);

        areaTemperature.setEditable(false);
        areaTemperature.setBackground(new java.awt.Color(1, 1, 1));
        areaTemperature.setColumns(5);
        areaTemperature.setFont(new java.awt.Font("Ubuntu", 1, 56));
        areaTemperature.setForeground(new java.awt.Color(25, 201, 69));
        areaTemperature.setRows(2);
        jScrollPane1.setViewportView(areaTemperature);

        menuItemVersion.setText("About");

        menuItemAuthor.setText("Author");
        menuItemAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAuthorActionPerformed(evt);
            }
        });
        menuItemVersion.add(menuItemAuthor);

        jMenuItem1.setText("Version");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuItemVersion.add(jMenuItem1);

        menuBar.add(menuItemVersion);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
}
