package bandtec.com.br.totemsoluction;

// @author Grupo_04-2ADSA
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import java.time.Instant;
import java.util.List;

public class App {

    public static void main(String[] args) {

//        // Instanciando um objeto da classe Looca
        Looca looca = new Looca();
//
//        // Instanciando um objeto da classe Sistema
//        Sistema sistema = looca.getSistema();
//
//        // Retornando o Sistema Operacional
//        String SO = looca.getSistema().getSistemaOperacional();
//
//        // Retornando o Fabricante do Processador
//        String fabte = looca.getSistema().getFabricante();
//
//        // Retornando a Arquitetura do Sistema
//        Integer arq = looca.getSistema().getArquitetura();
//
//        // Retornando quando ele foi iniciado
//        Instant inic = looca.getSistema().getInicializado();
//
//        // Retornando o tempo de atividade do computador
//        Long tempAtiv = looca.getSistema().getTempoDeAtividade();
//
//        //Retornando a permissão do usuário
//        Boolean perm = looca.getSistema().getPermissao();
//        System.out.println("Listando as informações do Sistema da Máquina\n");
//
//        System.out.println(sistema);
        System.out.println("\n______________________________________\n");

        /*
        
        Processos • Processos • Processos • Processos • Processos • Processos • 
        
        
        System.out.println("Listando as informações dos Processos da Máquina\n");

        ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();

        List<Processo> processos = grupoDeProcessos.getProcessos();

        for (Processo proc : processos) {
            System.out.println(proc);
        }
        
         */
        System.out.println("\n______________________________________\n");

        /* 
        
        Processador • Processador • Processador • Processador • Processador • 
        
        
        Processador procUm = new Processador();

        System.out.println(looca.getProcessador());

        Memoria mem = new Memoria();

        System.out.println(looca.getMemoria());
        
         */
        System.out.println("\n______________________________________\n");

        // Discos • Discos • Discos • Discos • Discos • Discos • Discos • Discos • Discos • 
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();

        List<Disco> discos = grupoDeDiscos.getDiscos();

        for (Disco disco : discos) {;
            System.out.println(disco);

        }

        System.out.println("\n______________________________________\n");

        DiscosGroup grupoDeVolumes = looca.getGrupoDeDiscos();

        List<Volume> volumes = grupoDeVolumes.getVolumes();

//        for (Volume vol : volumes) {;
//            System.out.println(vol);
//        }
        for (Volume vol : volumes) {
            System.out.println(volumes.get(0));
        }

        Conversor conv = new Conversor();

//        String total = conv.formatarBytes(volumes.get(0).getTotal());
//        String disp = conv.formatarBytes(volumes.get(0).getDisponivel());
//
//        System.out.println("Valores convertidos:");
//        System.out.println(total);
//        System.out.println(disp);
        String teste = conv.formatarBytes(volumes.get(0).getTotal());

        //System.out.println(piki);

//        Integer discoTotal = Integer.valueOf(conv.formatarBytes(volumes.get(0).getTotal()));
//        Integer discoDisp = Integer.valueOf(conv.formatarBytes(volumes.get(0).getDisponivel()));
//
//        Integer result = (discoDisp * 100) / discoTotal;
//
//        System.out.println(discoTotal);
//
//        System.out.println(discoDisp);
//
//        System.out.println(result);
    }
}
