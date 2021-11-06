package bandtec.com.br.totemsoluction.slack;

// @author Grupo_04-2ADSA
import java.io.IOException;
import org.json.JSONObject;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        JSONObject msgTeste = new JSONObject();

        msgTeste.put("text", "Estado crítico!");

        Slack.sendMessage(msgTeste);
    }
}
