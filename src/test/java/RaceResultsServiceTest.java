import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {

    @Test
    public void subscribedClientShouldReceiveMessage() {
        RaceResultsService raceResultsService = new RaceResultsService();
        Client client = mock(Client.class);
        Message message = mock(Message.class);

        raceResultsService.addSubscriber(client);
        raceResultsService.send(message);

        verify(client).receive(message);
    }
}