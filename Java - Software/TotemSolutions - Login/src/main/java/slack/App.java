package slack;

// @author Grupo_04-2ADSA
import java.io.IOException;
import org.json.JSONObject;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        JSONObject json = new JSONObject();

        json.put("text", "Deu certo");

        Slack.sendMessage(json);
    }
}
