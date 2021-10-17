package bandtec.com.br.totemsoluction;

import com.github.britooo.looca.api.core.Looca;

// @author Grupo_04-2ADSA
public class HardwareSo extends javax.swing.JFrame {
    
    Looca looca = new Looca();

    public HardwareSo() {
        initComponents();
        ExibirInformacoes();
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
        conteudo = new javax.swing.JPanel();
        txConteudo = new javax.swing.JLabel();
        txConteudo1 = new javax.swing.JLabel();
        txConteudo2 = new javax.swing.JLabel();
        txConteudo3 = new javax.swing.JLabel();
        txConteudo4 = new javax.swing.JLabel();
        txConteudo5 = new javax.swing.JLabel();

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
                .addGap(11, 11, 11))
        );

        conteudo.setBackground(new java.awt.Color(247, 247, 247));
        conteudo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(35, 135, 195)));

        txConteudo.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txConteudo.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo.setToolTipText("");
        txConteudo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txConteudo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txConteudo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txConteudo1.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo1.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo1.setToolTipText("");
        txConteudo1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txConteudo1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txConteudo1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txConteudo2.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo2.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo2.setToolTipText("");
        txConteudo2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txConteudo2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txConteudo2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txConteudo3.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo3.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo3.setToolTipText("");
        txConteudo3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txConteudo3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txConteudo3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txConteudo4.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo4.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo4.setToolTipText("");
        txConteudo4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txConteudo4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txConteudo4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txConteudo5.setBackground(new java.awt.Color(35, 135, 195));
        txConteudo5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txConteudo5.setForeground(new java.awt.Color(35, 135, 195));
        txConteudo5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txConteudo5.setToolTipText("");
        txConteudo5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txConteudo5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txConteudo5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout conteudoLayout = new javax.swing.GroupLayout(conteudo);
        conteudo.setLayout(conteudoLayout);
        conteudoLayout.setHorizontalGroup(
            conteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(conteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 1228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txConteudo1, javax.swing.GroupLayout.PREFERRED_SIZE, 1228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txConteudo2, javax.swing.GroupLayout.PREFERRED_SIZE, 1228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txConteudo3, javax.swing.GroupLayout.PREFERRED_SIZE, 1228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txConteudo4, javax.swing.GroupLayout.PREFERRED_SIZE, 1228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txConteudo5, javax.swing.GroupLayout.PREFERRED_SIZE, 1228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        conteudoLayout.setVerticalGroup(
            conteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txConteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txConteudo1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txConteudo2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txConteudo3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txConteudo4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txConteudo5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(conteudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(conteudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
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

    private void btnSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSOActionPerformed
        // ação do btn SISTEMA OPERACIONAL

        txConteudo.setText(String.format("Sistema operacional: %s", looca.getSistema().getSistemaOperacional()));
        txConteudo1.setText(String.format("Fabricante: %s", looca.getSistema().getFabricante()));
        txConteudo2.setText(String.format("Arquitetura: %d bits", looca.getSistema().getArquitetura()));
        txConteudo3.setText(String.format("Inicializado: %s", looca.getSistema().getInicializado()));
        txConteudo4.setText(String.format("Tempo de atividade: %s", looca.getSistema().getTempoDeAtividade()));
        txConteudo5.setText("Executando como " + (looca.getSistema().getPermissao() ? "root" : "usuário padrão"));
    }//GEN-LAST:event_btnSOActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // ação do btn VOLTAR
        new ProcessosTelaInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // ação do btn SAIR 
        new LoginPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnProcessadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessadorActionPerformed
        // ação do btn PROCESSADOR
        new HardwareProcesso().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProcessadorActionPerformed

    private void btnHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDActionPerformed
        // ação do btn DISCO RÍGIDO
        new HardwareHD().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHDActionPerformed

    private void btnMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemoriaActionPerformed
        new HardwareMemoria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMemoriaActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HardwareSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HardwareSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HardwareSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HardwareSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HardwareSo().setVisible(true);
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
    private javax.swing.JPanel conteudo;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txConteudo;
    private javax.swing.JLabel txConteudo1;
    private javax.swing.JLabel txConteudo2;
    private javax.swing.JLabel txConteudo3;
    private javax.swing.JLabel txConteudo4;
    private javax.swing.JLabel txConteudo5;
    // End of variables declaration//GEN-END:variables

    public void ExibirInformacoes () {
        txConteudo.setText(String.format("Sistema operacional: %s", looca.getSistema().getSistemaOperacional()));
        txConteudo1.setText(String.format("Fabricante: %s", looca.getSistema().getFabricante()));
        txConteudo2.setText(String.format("Arquitetura: %d bits", looca.getSistema().getArquitetura()));
        txConteudo3.setText(String.format("Inicializado: %s", looca.getSistema().getInicializado()));
        txConteudo4.setText(String.format("Tempo de atividade: %s", looca.getSistema().getTempoDeAtividade()));
        txConteudo5.setText("Executando como " + (looca.getSistema().getPermissao() ? "root" : "usuário padrão"));
    }
}
