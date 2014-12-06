import org.junit.Test;
import org.mockito.Mockito;

public class RaceResultsServiceTest {

    @Test
    public void subscribedClientShouldReceiveMessage() {
        RaceResultsService raceResultsService = new RaceResultsService();
        Client client = Mockito.mock(Client.class);
        Message message = Mockito.mock(Message.class);
    }
}