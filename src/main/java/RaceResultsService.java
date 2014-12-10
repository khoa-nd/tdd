/**
 * Created by NguyenDangKhoa on 12/6/14.
 */
public class RaceResultsService {

    private Client client;

    public void addSubscriber(Client client) {
        this.client = client;
    }

    public void send(Message message) {
        this.client.receive(message);
    }
}
