package bandtec.com.br.totemsoluction;

// grupo04 -> todo mundo fez.
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.time.Instant;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Instanciando um objeto da classe Looca
        Looca looca = new Looca();

        // Instanciando um objeto da classe Sistema
        Sistema sistema = looca.getSistema();

        // Retornando o Sistema Operacional
        String SO = looca.getSistema().getSistemaOperacional();

        // Retornando o Fabricante do Processador
        String fabte = looca.getSistema().getFabricante();

        // Retornando a Arquitetura do Sistema
        Integer arq = looca.getSistema().getArquitetura();

        // Retornando quando ele foi iniciado
        Instant inic = looca.getSistema().getInicializado();

        // Retornando o tempo de atividade do computador
        Long tempAtiv = looca.getSistema().getTempoDeAtividade();

        //Retornando a permissão do usuário
        Boolean perm = looca.getSistema().getPermissao();

        System.out.println("Listando as informações do Sistema da Máquina\n");

        System.out.println(sistema);

        System.out.println("\n______________________________________\n");

        System.out.println("Listando as informações dos Processos da Máquina\n");

        ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();

        List<Processo> processos = grupoDeProcessos.getProcessos();

        for (Processo proc : processos) {
            System.out.println(proc);
        }

        System.out.println("\n______________________________________\n");

        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();

        List<Disco> discos = grupoDeDiscos.getDiscos();

        for (Disco disco : discos) {
            System.out.println(disco);
        }
        
        System.out.println("\n______________________________________\n");

        Processador procUm = new Processador();
        
        System.out.println(looca.getProcessador());
        
    }
}
