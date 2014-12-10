import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RaceResultsServiceTest {

    private RaceResultsService raceResultsService = new RaceResultsService();
    private Client clientA = mock(Client.class);
    private Client clientB = mock(Client.class);
    private Message message = mock(Message.class);

    @Test
    public void subscribedClientShouldReceiveMessage() {
        raceResultsService.addSubscriber(clientA);
        raceResultsService.send(message);

        verify(clientA).receive(message);
    }

    @Test
    public void messageShouldBeSentToAllSubscribedClients() {
        raceResultsService.addSubscriber(clientA);
        raceResultsService.addSubscriber(clientB);
        raceResultsService.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }
}