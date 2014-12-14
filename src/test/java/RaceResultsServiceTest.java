import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class RaceResultsServiceTest {

    private RaceResultsService raceResultsService = new RaceResultsService();
    private Client clientA = mock(Client.class);
    private Client clientB = mock(Client.class);
    private Message message = mock(Message.class);

    // zero subscribers
    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResultsService.send(message);

        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    // one subscriber
    @Test
    public void subscribedClientShouldReceiveMessage() {
        raceResultsService.addSubscriber(clientA);
        raceResultsService.send(message);

        verify(clientA).receive(message);
    }

    // two subscribers
    @Test
    public void messageShouldBeSentToAllSubscribedClients() {
        raceResultsService.addSubscriber(clientA);
        raceResultsService.addSubscriber(clientB);
        raceResultsService.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }
}