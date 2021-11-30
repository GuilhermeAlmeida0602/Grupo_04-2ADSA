package bandtec.com.br.totemsoluction;

import bandtec.com.br.totemsoluction.slack.MensagensSlack;
import bandtec.com.br.totemsoluction.slack.Slack;
import com.github.britooo.looca.api.core.Looca;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import log.Log;
import org.json.JSONObject;

// @author Grupo_04-2ADSA
public final class HardwareProcesso extends javax.swing.JFrame {
    
    Looca looca = new Looca();
    MensagensSlack slack = new MensagensSlack();
    
    public HardwareProcesso() {
        
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            
            initComponents();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HardwareProcesso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(HardwareProcesso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(HardwareProcesso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HardwareProcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ExibeProcesso();
        setIcon();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnMemoria = new javax.swing.JButton();
        btnSO = new javax.swing.JButton();
        btnHD = new javax.swing.JButton();
        btnProcessador = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        divLeft = new javax.swing.JPanel();
        txConteudo = new javax.swing.JLabel();
        txConteudo3 = new javax.swing.JLabel();
        txConteudo4 = new javax.swing.JLabel();
        txConteudo5 = new javax.swing.JLabel();
        txConteudo6 = new javax.swing.JLabel();
        txConteudo7 = new javax.swing.JLabel();
        divRight = new javax.swing.JPanel();
        txConteudo99 = new javax.swing.JLabel();
        txConteudo8 = new javax.swing.JLabel();
        txConteudo9 = new javax.swing.JLabel();
        txConteudo10 = new javax.swing.JLabel();
        divPorce = new javax.swing.JPanel();
        pbEmUso = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setMinimumSize(new java.awt.Dimension(1080, 650));

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        header.setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TotemSoluctions.png"))); // NOI18N

        btnSair.setBackground(new java.awt.Color(35, 135, 195));
        btnSair.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("SAIR");
        btnSair.setBorder(null);
        btnSair.setFocusPainted(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(35, 135, 195));
        btnVoltar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorder(null);
        btnVoltar.setDefaultCapable(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));

        btnMemoria.setForeground(new java.awt.Color(255, 102, 102));
        btnMemoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardMemoria.png"))); // NOI18N
        btnMemoria.setBorder(null);
        btnMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemoriaActionPerformed(evt);
            }
        });

        btnSO.setForeground(new java.awt.Color(255, 102, 102));
        btnSO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardSO.png"))); // NOI18N
        btnSO.setToolTipText("");
        btnSO.setBorder(null);
        btnSO.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSO.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSOActionPerformed(evt);
            }
        });

        btnHD.setForeground(new java.awt.Color(255, 102, 102));
        btnHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardHD.png"))); // NOI18N
        btnHD.setBorder(null);
        btnHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDActionPerformed(evt);
            }
        });

        btnProcessador.setForeground(new java.awt.Color(255, 102, 102));
        btnProcessador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hardProcessador.png"))); // NOI18N
        btnProcessador.setBorder(null);
        btnProcessador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProcessador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMemoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProcessador)
                    .addComponent(btnHD)
                    .addComponent(btnSO)
                    .addComponent(btnMemoria))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        content.setBackground(new java.awt.Color(247, 247, 247));

        divLeft.setBackground(new java.awt.Color(247, 247, 247));
        divLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 135, 195)));

        txConteudo.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        txConteudo.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txConteudo.setText("Informações físicas");
        txConteudo.setToolTipText("");

        txConteudo3.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo3.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo3.setToolTipText("");
        txConteudo3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txConteudo4.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo4.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo4.setToolTipText("");
        txConteudo4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txConteudo5.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo5.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo5.setToolTipText("");
        txConteudo5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txConteudo6.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo6.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo6.setToolTipText("");
        txConteudo6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txConteudo7.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo7.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo7.setToolTipText("");
        txConteudo7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout divLeftLayout = new javax.swing.GroupLayout(divLeft);
        divLeft.setLayout(divLeftLayout);
        divLeftLayout.setHorizontalGroup(
            divLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(divLeftLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(divLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txConteudo3, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(txConteudo7, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(txConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txConteudo4, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(txConteudo5, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(txConteudo6, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        divLeftLayout.setVerticalGroup(
            divLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(divLeftLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txConteudo)
                .addGap(25, 25, 25)
                .addComponent(txConteudo3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txConteudo4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txConteudo5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txConteudo6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txConteudo7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        divRight.setBackground(new java.awt.Color(247, 247, 247));
        divRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 135, 195)));

        txConteudo99.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo99.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        txConteudo99.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txConteudo99.setText("Informações de Processamento");
        txConteudo99.setToolTipText("");

        txConteudo8.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo8.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo8.setToolTipText("");
        txConteudo8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txConteudo9.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo9.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo9.setToolTipText("");
        txConteudo9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txConteudo10.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo10.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo10.setToolTipText("");
        txConteudo10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout divRightLayout = new javax.swing.GroupLayout(divRight);
        divRight.setLayout(divRightLayout);
        divRightLayout.setHorizontalGroup(
            divRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(divRightLayout.createSequentialGroup()
                .addGroup(divRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, divRightLayout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(txConteudo8, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(divRightLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txConteudo99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
            .addGroup(divRightLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(divRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txConteudo10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txConteudo9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        divRightLayout.setVerticalGroup(
            divRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(divRightLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txConteudo99)
                .addGap(18, 18, 18)
                .addComponent(txConteudo8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txConteudo9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txConteudo10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        divPorce.setBackground(new java.awt.Color(247, 247, 247));
        divPorce.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 135, 195)));

        pbEmUso.setBackground(new java.awt.Color(196, 196, 196));
        pbEmUso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pbEmUso.setForeground(new java.awt.Color(35, 135, 195));
        pbEmUso.setBorder(null);
        pbEmUso.setFocusable(false);
        pbEmUso.setStringPainted(true);

        jLabel3.setBackground(new java.awt.Color(35, 135, 195));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 135, 195));
        jLabel3.setText("Em uso (%)");

        javax.swing.GroupLayout divPorceLayout = new javax.swing.GroupLayout(divPorce);
        divPorce.setLayout(divPorceLayout);
        divPorceLayout.setHorizontalGroup(
            divPorceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(divPorceLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(divPorceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(pbEmUso, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        divPorceLayout.setVerticalGroup(
            divPorceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(divPorceLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbEmUso, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pbEmUso.setValue(50);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(divLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(divRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(divPorce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(divLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(divRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(divPorce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new ProcessosTelaInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemoriaActionPerformed
        new HardwareMemoria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMemoriaActionPerformed

    private void btnSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSOActionPerformed
        new HardwareSo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSOActionPerformed

    private void btnHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDActionPerformed
        new HardwareHD().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHDActionPerformed

    private void btnProcessadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessadorActionPerformed
        ExibeProcesso();
    }//GEN-LAST:event_btnProcessadorActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        try {

            // Avisando para o usuario que a máquina está sendo monitorada
            slack.stopService();
            new ProcessosTelaInicial().setVisible(true);
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSairActionPerformed
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HardwareProcesso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHD;
    private javax.swing.JButton btnMemoria;
    private javax.swing.JButton btnProcessador;
    private javax.swing.JButton btnSO;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel content;
    private javax.swing.JPanel divLeft;
    private javax.swing.JPanel divPorce;
    private javax.swing.JPanel divRight;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar pbEmUso;
    private javax.swing.JLabel txConteudo;
    private javax.swing.JLabel txConteudo10;
    private javax.swing.JLabel txConteudo3;
    private javax.swing.JLabel txConteudo4;
    private javax.swing.JLabel txConteudo5;
    private javax.swing.JLabel txConteudo6;
    private javax.swing.JLabel txConteudo7;
    private javax.swing.JLabel txConteudo8;
    private javax.swing.JLabel txConteudo9;
    private javax.swing.JLabel txConteudo99;
    // End of variables declaration//GEN-END:variables

    // Método para exibir as informações do PROCESSADOR
    public void ExibeProcesso() {
        txConteudo3.setText(String.format("Fabricante: %s", looca.getProcessador().getFabricante()));
        txConteudo4.setText(String.format("Nome: %s", looca.getProcessador().getNome()));
        txConteudo5.setText(String.format("Identificador: %s", looca.getProcessador().getIdentificador()));
        txConteudo6.setText(String.format("Micro Arquitetura: %s", looca.getProcessador().getMicroarquitetura()));
        txConteudo7.setText(String.format("Frequência: " + looca.getProcessador().getFrequencia()));
        txConteudo8.setText(String.format("Nº de Pacotes Físicos: %s", looca.getProcessador().getNumeroPacotesFisicos()));
        txConteudo9.setText(String.format("Nº de CPU Físicos: %s", looca.getProcessador().getNumeroCpusFisicas()));
        txConteudo10.setText(String.format("Nº de CPU Lógicos: " + looca.getProcessador().getNumeroCpusLogicas()));
        
        Double uso = looca.getProcessador().getUso();
        Integer usoProc = uso.intValue();
        
        pbEmUso.setValue(usoProc);
        
        if (usoProc > 90) {
            Log log = new Log();
            try {
                log.criarLog();
                slack.alerta("processador");
            } catch (IOException ex) {
                Logger.getLogger(HardwareHD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(HardwareProcesso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IS.png")));
    }
}
