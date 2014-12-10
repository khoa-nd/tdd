import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by NguyenDangKhoa on 12/6/14.
 */
public class RaceResultsService {

    private Collection<Client> clients = new ArrayList<Client>();

    public void addSubscriber(Client client) {
        clients.add(client);
    }

    public void send(Message message) {
        for (Client client : clients) {
            client.receive(message);
        }
    }
}
