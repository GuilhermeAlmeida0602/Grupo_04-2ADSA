package log;

// @author guilherme.bispo
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Log {

    public void criarLog() throws IOException {

        // Usado para pegar os processos que estão na máquina
        Looca looca = new Looca();
        ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
        List<Processo> processos = grupoDeProcessos.getProcessos();
        String caminhoDisco = System.getProperty("user.home");

        // Data e hora formatada para o nome do diretorio
        String dateTimeDiretorio = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

        // Data e hora formatada para ir dentro do arquivo
        String dateTimeArquivo = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        Integer count = 0;
        try ( FileWriter log = new FileWriter(caminhoDisco + File.separator + "Downloads" + "Log-INFOSYSTEMS  (" + String.valueOf(dateTimeDiretorio) + ").txt")) {
            PrintWriter gravarLog = new PrintWriter(log);

            gravarLog.print("  >> GERAÇÃO DA LOG \n\n");
            gravarLog.printf("  %s\n", dateTimeArquivo);
            gravarLog.print("_____________________________________________________________________________________________________________________________________________");

            gravarLog.print("\n\n  >> INFORMAÇÕES DA MÁQUINA \n\n");

            // Útil para printar as informações da Máquina e do SO
            Sistema sistema = looca.getSistema();
            String SO = looca.getSistema().getSistemaOperacional();
            String fabte = looca.getSistema().getFabricante();
            Integer arq = looca.getSistema().getArquitetura();
            Instant inic = looca.getSistema().getInicializado();
            Long tempAtiv = looca.getSistema().getTempoDeAtividade();
            Boolean perm = looca.getSistema().getPermissao();

            gravarLog.printf("%s", looca.getSistema());

            gravarLog.print("\n\n_____________________________________________________________________________________________________________________________________________");

            gravarLog.print("\n\n  >> PROCESSOS DA MÁQUINA\n\n");

            // Print dos processo na log
            for (Processo proc : processos) {
                if (count <= 30) {
                    gravarLog.printf("Nome do Processo: %s\tPID: %d\tUso de CPU: %.2f\tUso de Memória: %.2f\n", proc.getNome(), proc.getPid(), proc.getUsoCpu(), proc.getUsoMemoria());
                    count++;
                } else {
                }
            }
            log.close();
            System.out.println("Arquivo gravado com sucesso!");
        }
    }

//    public static void criarLog(String diretorioDoArquivo, String dadosLog) {;
//
//        try (
//                FileWriter criadorDeArquivos = new FileWriter(diretorioDoArquivo, true); BufferedWriter buffer = new BufferedWriter(criadorDeArquivos); PrintWriter escritorDeArquivos = new PrintWriter(buffer);) {
//            escritorDeArquivos.append(dadosLog);
//            System.out.println("\n\nOK\n\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
