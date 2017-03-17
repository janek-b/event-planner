import org.junit.*;
import static org.junit.Assert.*;

public class EventTest {


  @Test
  public void newEvent_instantiatedCorrectly() {
    Event testEvent = new Event(100);
    assertEquals(true, testEvent instanceof Event);
  }

  @Test
  public void getGuestCount_returnsTheCorrectNumberOfGuests_100() {
    Event testEvent = new Event(100);
    assertEquals(100, testEvent.getGuestCount());
  }
}
