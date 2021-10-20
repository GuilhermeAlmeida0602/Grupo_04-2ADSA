/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandtec.com.br.totemsoluction.persistence;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vitor
 */
public class MaquinaDao extends Dao {

    public Boolean bucarMaquina(Looca looca) throws Exception {
        DiscosGroup grupoDeVolumes = looca.getGrupoDeDiscos();
        List<Volume> volumes = grupoDeVolumes.getVolumes();

        open();
        /*Abertura da conexão com banco de dados*/
        System.out.println("Iniciando verificação no banco...");
        String uuid = "";
        stmt = con.prepareStatement("select uuid from maquina where uuid= ?;");
        stmt.setString(1, String.valueOf(volumes.get(0).getUUID()));
        rs = stmt.executeQuery();
        /*Execução da instrução no banco - parte importante*/
        while (rs.next()) {
            uuid = rs.getString(1);
        }
        close();
        /*Fechamento da conexão com banco de dados*/
        System.out.println("Finalizando verificação no banco... \nResultado: ");

        /*Verificação*/
        System.out.println("Totem registrado? " + uuid.equals(
                String.valueOf(volumes.get(0).getUUID())));
        if (uuid.equals(String.valueOf(volumes.get(0).getUUID()))) {
            return true;
        } else {
            return false;
        }
    }

    /*Insert na tabela Máquina */
    public void insertInfoMaquina(Looca looca) throws Exception {

        DiscosGroup grupoDeVolumes = looca.getGrupoDeDiscos();
        List<Volume> volumes = grupoDeVolumes.getVolumes();

        open();
        try {
            System.out.println("Realizando registro de totem no banco...");
            stmt = con.prepareStatement("insert into Maquina "
                    + "values (null, ?,?,?,?,?,?,?,?,?,?,?,?);");
            stmt.setInt(1, 1);
            stmt.setString(2, looca.getSistema().getSistemaOperacional());
            stmt.setInt(3, looca.getSistema().getArquitetura());
            stmt.setString(4, looca.getSistema().getFabricante());
            stmt.setString(5, looca.getProcessador().getNome());
            stmt.setString(6, looca.getProcessador().getIdentificador());
            stmt.setString(7, looca.getProcessador().getMicroarquitetura());
            stmt.setLong(8, looca.getProcessador().getFrequencia());
            stmt.setInt(9, looca.getProcessador().getNumeroPacotesFisicos());
            stmt.setInt(10, looca.getProcessador().getNumeroCpusFisicas());
            stmt.setInt(11, looca.getProcessador().getNumeroCpusLogicas());
            stmt.setString(12, String.valueOf(volumes.get(0).getUUID()));
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Registro realizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um problema no registro");
            ex.printStackTrace();
        } finally {
            close();
        }
    }
}
