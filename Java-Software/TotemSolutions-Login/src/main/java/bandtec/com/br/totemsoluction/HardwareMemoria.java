package bandtec.com.br.totemsoluction;

import bandtec.com.br.totemsoluction.slack.MensagensSlack;
import bandtec.com.br.totemsoluction.slack.Slack;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.util.Conversor;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import log.Log;
import org.json.JSONObject;

// @author Grupo_04-2ADSA
public class HardwareMemoria extends javax.swing.JFrame {

    // Instanciando objeto da classe Conversor e Memoria
    Conversor conv = new Conversor();
    Memoria memoria = new Memoria();
    MensagensSlack slack = new MensagensSlack();

    public HardwareMemoria() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HardwareMemoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(HardwareMemoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(HardwareMemoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HardwareMemoria.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        ExibeMemoria();
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
        jPanel3 = new javax.swing.JPanel();
        txConteudo1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pbDisponivel = new javax.swing.JProgressBar();
        pbEmUso2 = new javax.swing.JProgressBar();
        labelTotal = new javax.swing.JLabel();

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
        btnSO.setBorder(null);
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
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(btnSO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnProcessador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnMemoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnHD)
                .addContainerGap(33, Short.MAX_VALUE))
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
                .addGap(11, 11, 11))
        );

        jPanel3.setBackground(new java.awt.Color(247, 247, 247));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 135, 195)));

        txConteudo1.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txConteudo1.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txConteudo1.setText("Informações de memória");
        txConteudo1.setToolTipText("");

        jPanel4.setBackground(new java.awt.Color(247, 247, 247));

        jLabel3.setBackground(new java.awt.Color(35, 135, 195));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 135, 195));
        jLabel3.setText("Disponível:");

        jLabel4.setBackground(new java.awt.Color(35, 135, 195));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(35, 135, 195));
        jLabel4.setText("Total:");

        jLabel5.setBackground(new java.awt.Color(35, 135, 195));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 135, 195));
        jLabel5.setText("Em uso:");

        pbDisponivel.setBackground(new java.awt.Color(196, 196, 196));
        pbDisponivel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pbDisponivel.setForeground(new java.awt.Color(35, 135, 195));
        pbDisponivel.setValue(20);
        pbDisponivel.setBorder(null);
        pbDisponivel.setFocusable(false);
        pbDisponivel.setStringPainted(true);

        pbEmUso2.setBackground(new java.awt.Color(196, 196, 196));
        pbEmUso2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pbEmUso2.setForeground(new java.awt.Color(35, 135, 195));
        pbEmUso2.setValue(20);
        pbEmUso2.setBorder(null);
        pbEmUso2.setFocusable(false);
        pbEmUso2.setStringPainted(true);

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(35, 135, 195));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pbDisponivel, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addComponent(pbEmUso2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(pbEmUso2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        pbDisponivel.setValue(50);
        pbDisponivel.setValue(50);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txConteudo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(txConteudo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        ExibeMemoria();
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
        new HardwareProcesso().setVisible(true);
        this.dispose();
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
                new HardwareMemoria().setVisible(true);
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
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JProgressBar pbDisponivel;
    private javax.swing.JProgressBar pbEmUso2;
    private javax.swing.JLabel txConteudo1;
    // End of variables declaration//GEN-END:variables

    // Método para exibir as informações da MEMÓRIA
    public void ExibeMemoria() {

        Integer emUso = (int) ((memoria.getEmUso() * 100) / memoria.getTotal()) + 1;
        Integer dispon = (int) ((memoria.getDisponivel() * 100) / memoria.getTotal());
        String total = conv.formatarBytes(memoria.getTotal());

        pbEmUso2.setValue(emUso);
        pbDisponivel.setValue(dispon);
        labelTotal.setText(total);

        if (dispon < 10) {
            Log log = new Log();
            try {
                log.criarLog();
                slack.alerta("memória ram");
            } catch (IOException ex) {
                Logger.getLogger(HardwareHD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(HardwareMemoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IS.png")));
    }
}
