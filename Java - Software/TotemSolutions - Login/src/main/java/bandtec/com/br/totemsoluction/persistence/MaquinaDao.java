package bandtec.com.br.totemsoluction.persistence;

import bandtec.com.br.totemsoluction.entity.Maquina;
import com.github.britooo.looca.api.core.Looca;
import java.net.InetAddress;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitor
 */
public class MaquinaDao extends Dao {

    /*Método boolean para saber se a máquina que está rodando o programa já 
    está cadastrada*/
    public Boolean bucarMaquina(Looca looca) throws Exception {
        InetAddress infoMaquina = InetAddress.getLocalHost();

        open();
        /*Abertura da conexão com banco de dados*/
        System.out.println("Iniciando verificação no banco...");
        String hostname = "";
        stmt = con.prepareStatement("select hostname from Maquina where hostname= ?;");
        stmt.setString(1, infoMaquina.getHostName());
        rs = stmt.executeQuery();
        /*Execução da instrução no banco - parte importante*/
        while (rs.next()) {
            hostname = rs.getString(1);
        }
        close();
        /*Fechamento da conexão com banco de dados*/

        System.out.println("Finalizando verificação no banco... \nResultado: ");

        /*Verificação*/
        System.out.println("Totem registrado? " + hostname.equals(
                String.valueOf(infoMaquina.getHostName())));
        if (hostname.equals(String.valueOf(infoMaquina.getHostName()))) {
            return true;
        } else {
            return false;
        }
    }

    /*Insert na tabela Máquina */
    public void insertInfoMaquina(Looca looca, Integer fkEmpresa) throws Exception {
        InetAddress infoMaquina = InetAddress.getLocalHost();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        open();
        try {
            System.out.println("Realizando registro de totem no banco...");
            stmt = con.prepareStatement("insert into Maquina (fkEmpresa, hostname, sistemaOperacionalSO, arquiteturaSO, fabricanteCPU, nomeCPU,\n"
                    + "    identificadorCPU, microArquiteturaCPU, frequenciaCPU, pacotesFisicosCPU, cpuFisicosCPU, cpuLogicosCPU, ip, reiniciar, "
                    + "limpezaDeCache, dataDeRegistro) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            stmt.setInt(1, fkEmpresa);
            stmt.setString(2, infoMaquina.getHostName());
            stmt.setString(3, looca.getSistema().getSistemaOperacional());
            stmt.setInt(4, looca.getSistema().getArquitetura());
            stmt.setString(5, looca.getSistema().getFabricante());
            stmt.setString(6, looca.getProcessador().getNome());
            stmt.setString(7, looca.getProcessador().getIdentificador());
            stmt.setString(8, looca.getProcessador().getMicroarquitetura());
            stmt.setString(9, String.valueOf(looca.getProcessador().getFrequencia()));
            stmt.setInt(10, looca.getProcessador().getNumeroPacotesFisicos());
            stmt.setInt(11, looca.getProcessador().getNumeroCpusFisicas());
            stmt.setInt(12, looca.getProcessador().getNumeroCpusLogicas());
            stmt.setString(13, infoMaquina.getHostAddress());
            stmt.setLong(14, 0);
            stmt.setLong(15, 0);
            stmt.setString(16, dtf.format(LocalDateTime.now()));
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Registro realizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um problema no registro - Máquina");
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    public Integer buscaDados() throws Exception {
        InetAddress infoMaquina = InetAddress.getLocalHost();
        open();
        /*Abertura da conexão com banco de dados*/
        stmt = con.prepareStatement("select idMaquina from Maquina "
                + "where hostname = ?;");
        stmt.setString(1, infoMaquina.getHostName());
        rs = stmt.executeQuery();
        /*Execução da instrução no banco - parte importante*/
        Integer idMaquina = null;
        while (rs.next()) {
            idMaquina = rs.getInt(1);
        }
        close();
        /*Fechamento da conexão com banco de dados*/
        return idMaquina;
    }

    public List<Maquina> ativaInovacao(Integer fkMaquina) throws Exception {
        open();
        /*Abertura da conexão com banco de dados*/
        stmt = con.prepareStatement("select reiniciar, limpezaDeCache "
                + "from Maquina where idMaquina = ?;");
        stmt.setInt(1, fkMaquina);
        rs = stmt.executeQuery();
        /*Execução da instrução no banco - parte importante*/
        List<Maquina> maquina = new ArrayList<>();
        while (rs.next()) {
            Maquina m = new Maquina();
            m.setReiniciar(rs.getLong(1));
            m.setLimpezaDeCache(rs.getLong(2));
            maquina.add(m);
        }
        close();
        /*Fechamento da conexão com banco de dados*/
        return maquina;
    }

    public void updateReiniciar(Integer fkMaquina) throws Exception {
        try {
            open();
            stmt = con.prepareStatement(
                    "update Maquina set reiniciar=? where idMaquina=?");
            stmt.setLong(1, 0);
            stmt.setInt(2, fkMaquina);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    public void updateLimpezaCache(Integer fkMaquina) throws Exception {
        try {
            open();
            stmt = con.prepareStatement(
                    "update Maquina set limpezaDeCache=? where idMaquina=?");
            stmt.setLong(1, 0);
            stmt.setInt(2, fkMaquina);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }
}
