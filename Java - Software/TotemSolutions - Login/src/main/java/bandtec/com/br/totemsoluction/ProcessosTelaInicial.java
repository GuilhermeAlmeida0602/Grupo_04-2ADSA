package bandtec.com.br.totemsoluction;

import bandtec.com.br.totemsoluction.entity.Maquina;
import bandtec.com.br.totemsoluction.entity.Usuario;
import bandtec.com.br.totemsoluction.persistence.DadosDiscoDao;
import bandtec.com.br.totemsoluction.persistence.DadosMaquinaDao;
import bandtec.com.br.totemsoluction.persistence.DiscoDao;
import bandtec.com.br.totemsoluction.persistence.MaquinaDao;
import bandtec.com.br.totemsoluction.persistence.ProcessosMaquinaDao;
import bandtec.com.br.totemsoluction.slack.MensagensSlack;
import com.github.britooo.looca.api.core.Looca;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

// @author Grupo_04-2ADSA
public class ProcessosTelaInicial extends javax.swing.JFrame {

    Looca looca = new Looca();
    MensagensSlack slack = new MensagensSlack();
    Integer fkMaquina = null;
    Integer fkDisco = null;

    public ProcessosTelaInicial() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HardwareHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(HardwareHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(HardwareHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HardwareHD.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    //Sobrecarga do método ProcessosTelaInicial
    public ProcessosTelaInicial(Usuario usuario) {

        // Isso aqui tira varios bugs do swing
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HardwareHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(HardwareHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(HardwareHD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HardwareHD.class.getName()).log(Level.SEVERE, null, ex);
        }

        MaquinaDao maqDao = new MaquinaDao();
        DiscoDao discDao = new DiscoDao();
        Integer fkEmpresa = usuario.getFkEmpresa();
        try {

            Boolean verificacaoMaquina = maqDao.bucarMaquina(looca);
            if (verificacaoMaquina == false) {
                System.out.println("Realizar registro do totem no banco");
                maqDao.insertInfoMaquina(looca, fkEmpresa); // Insert - dados estáticos na tabela Máquina

                fkMaquina = maqDao.buscaDados(); // Select - buscando o "idMaquina" para realizar outras buscas

                discDao.insertInfoDisco(looca, fkMaquina); // Insert - dados estáticos na tabela Disco

                fkDisco = discDao.buscaId(looca, fkMaquina); // Select - buscando o "idDisco" para realizar os inserts na tabela "DadosDisco"

            } else {
                System.out.println("Totem já registrado no banco");
                fkMaquina = maqDao.buscaDados();
                fkDisco = discDao.buscaId(looca, fkMaquina);
            }

            setIcon();
            timerInsert(fkMaquina, fkDisco);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Deu ruim no banco");
        }

        initComponents();
    }

    public void timerInsert(Integer fkMaquina, Integer fkDisco) {

        int delay = 10000;   // delay de 1 seg.
        int interval = 20000;  // intervalo de 10 seg.
        java.util.Timer timer = new java.util.Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                try {
                    for (int i = 0; i < 10; i++) {

                        System.out.println(i + "  -  Segundo(s)");

                        try {
                            DadosDiscoDao dddDao = new DadosDiscoDao();
                            dddDao.insertDadosDisco(looca, fkDisco);

                            DadosMaquinaDao dadosMaqDao = new DadosMaquinaDao();
                            dadosMaqDao.insertDadosMaquina(looca, fkMaquina);

                            /*Insert - Essa parte faz os inserts da tabela "processosMaquina", 
                            deixe comentando até ajustar o timer para não encher o banco */
//                            ProcessosMaquinaDao proMaqDao = new ProcessosMaquinaDao();
//                            proMaqDao.insertProcessosMaquina(looca, fkMaquina);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        MaquinaDao maqDao = new MaquinaDao();
                        // Verificando no banco se precisa reiniciar ou limpar o cache
                        List<Maquina> maquina = maqDao.ativaInovacao(fkMaquina);

                        //  Inovação - Reiniciar máquina
                        if (maquina.get(0).getReiniciar() == 1) {
                            try {
                                JOptionPane.showMessageDialog(null, "Totem sendo reiniciado!");
                                maqDao.updateReiniciar(fkMaquina); // Update - atualiza campo "reiniciar" para 0
                                Runtime.getRuntime().exec("shutdown /r"); // Coamando para reiniciar a máquina
                            } catch (IOException ex) {
                                Logger.getLogger(ProcessosTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        //  Inovação - Limpeza de cache
                        if (maquina.get(0).getLimpezaDeCache() == 1) {
                            try {
                                maqDao.updateReiniciar(fkMaquina); // Update - atualiza campo "limpezaDeCache" para 0
                                JOptionPane.showMessageDialog(null, "Limpeza de cache completa");
                                Runtime.getRuntime().exec("ipconfig /flushdns"); // Comando que irá limpar o cache
                            } catch (IOException ex) {
                                Logger.getLogger(ProcessosTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                } catch (Exception ex) {    // try
                    ex.printStackTrace();   // try
                }                                       // try

            }
        }, delay, interval);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        Content = new javax.swing.JPanel();
        btnHardware = new javax.swing.JButton();
        btnSO = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setMinimumSize(new java.awt.Dimension(1080, 650));

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        Header.setBackground(new java.awt.Color(247, 247, 247));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TotemSoluctions.png"))); // NOI18N

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

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Content.setBackground(new java.awt.Color(247, 247, 247));

        btnHardware.setBackground(new java.awt.Color(247, 247, 247));
        btnHardware.setForeground(new java.awt.Color(255, 102, 102));
        btnHardware.setIcon(new javax.swing.ImageIcon(getClass().getResource("/processHardware.png"))); // NOI18N
        btnHardware.setToolTipText("");
        btnHardware.setBorder(null);
        btnHardware.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnHardware.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnHardware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHardwareActionPerformed(evt);
            }
        });

        btnSO.setBackground(new java.awt.Color(247, 247, 247));
        btnSO.setForeground(new java.awt.Color(255, 102, 102));
        btnSO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/processApp.png"))); // NOI18N
        btnSO.setToolTipText("");
        btnSO.setBorder(null);
        btnSO.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSO.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSO)
                    .addComponent(btnHardware))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnHardware)
                .addGap(26, 26, 26)
                .addComponent(btnSO)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        try {
            // Avisando para o usuario que a máquina está sendo monitorada
            slack.stopService();
//            new ProcessosTelaInicial().setVisible(true);
            new LoginPage().setVisible(true);
            this.dispose();

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnHardwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHardwareActionPerformed
        new HardwareTelaInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHardwareActionPerformed

    private void btnSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSOActionPerformed
        new ProcessosApp().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSOActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcessosTelaInicial().setVisible(true);
            }
        });
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IS.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Header;
    private javax.swing.JButton btnHardware;
    private javax.swing.JButton btnSO;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
