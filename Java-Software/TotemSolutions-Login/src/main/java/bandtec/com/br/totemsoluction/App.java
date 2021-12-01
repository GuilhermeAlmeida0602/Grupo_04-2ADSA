package bandtec.com.br.totemsoluction;

// @author Grupo_04-2ADSA
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import java.time.Instant;
import java.util.List;
import java.util.TimerTask;
import javax.management.timer.Timer;

public class App {

    public static void main(String[] args) {

        // teste para pegar dados dos componentes
        // Area do log
//        // Instanciando um objeto da classe Looca
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
//        System.out.println("Listando as informações do Sistema da Máquina\n");
//
        System.out.println(sistema);

        System.out.println(
                "\n______________________________________\n");
        // Processos • Processos • Processos • Processos • Processos • Processos • 

//        System.out.println("Listando as informações dos Processos da Máquina\n");
//        Conversor conv = new Conversor();
//
//        ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
//
//        List<Processo> processos = grupoDeProcessos.getProcessos();
//
//        }

        /*
            System.out.println("CPU  " + proc.getUsoCpu());
            System.out.println("MEMORIA RAM: " + proc.getUsoMemoria());
            System.out.println(proc.getUsoCpu().intValue());
            if (proc.getPid() == 8100) {
                Double uso = proc.getUsoMemoria();
                Long total = looca.getMemoria().getEmUso();
                Double fim = (uso * total) / 100;
                System.out.println(proc.getPid() + "memoria: " + proc.getUsoMemoria().intValue());
                System.out.println("PID: " + proc.getPid() + "\tmemoria: " + proc.getUsoMemoria().longValue());
                System.out.println("PID: " + proc.getPid() + "\tmemoria: " + proc.getUsoMemoria() * 100);
                System.out.println("TOTAL: " + total);
                System.out.println("PID: " + proc.getPid() + "\tmemoria: " + (uso * 10));
                System.out.println("PID: " + proc.getPid() + "\tmemoria: " + uso + "\t% de uso: " + fim.intValue());
                System.out.println("PID: " + proc.getPid() + "\tmemoria: " + conv.formatarBytes(proc.getMemoriaVirtualUtilizada()));
                System.out.println("PID: " + proc.getPid() + "\tmemoria: " + proc.getMemoriaVirtualUtilizada().doubleValue());
                System.out.println("PID: " + proc.getPid() + "\tmemoria: " + proc.getMemoriaVirtualUtilizada().intValue());
            }
        }
        for (int i = 0; i < 10; i++) {
            Long teste = processos.get(i).getMemoriaVirtualUtilizada();
            Double teste1 = processos.get(i).getUsoMemoria();
            System.out.println("CPU  " + conv.formatarBytes(processos.get(i).getUsoCpu()));
            System.out.println("MEMORIA RAM: " + conv.formatarBytes(teste1));
        }
         */
        System.out.println(
                "\n______________________________________\n");

        /* 
        Processador • Processador • Processador • Processador • Processador • 
        
        
        Processador procUm = new Processador();

        System.out.println(looca.getProcessador());

        Memoria mem = new Memoria();
         */
//        System.out.println("Printando com o objeto looca "+looca.getMemoria());
//        System.out.println("Printando com objeto memoria " + conv.formatarBytes(mem.getEmUso()));
        System.out.println(
                "\n______________________________________\n");

        // Discos • Discos • Discos • Discos • Discos • Discos • Discos • Discos • Discos • 
//        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
//
//        List<Disco> discos = grupoDeDiscos.getDiscos();
//
//        for (Disco disco : discos) {;
//            System.out.println(disco);
//
//        }
        System.out.println(
                "\n______________________________________\n");

//        DiscosGroup grupoDeVolumes = looca.getGrupoDeDiscos();;
//
//        List<Volume> volumes = grupoDeVolumes.getVolumes();
//
//        for (Volume vol : volumes) {
//            System.out.println(vol);
//
//            Long disp = vol.getDisponivel();
//            Long total = vol.getTotal();
//
//            // Long uso = ((disp * 100) / total) - disp;
//            System.out.println(((disp * 100) / total) - disp);
//
//        }
//        String total = conv.formatarBytes(volumes.get(0).getTotal());
//        String disp = conv.formatarBytes(volumes.get(0).getDisponivel());
//
//        System.out.println("Valores convertidos:");
//        System.out.println(total);
//        System.out.println(disp);
//        String teste = conv.formatarBytes(volumes.get(0).getTotal());
        //System.out.println(piki);
//        System.out.println(piki);
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
