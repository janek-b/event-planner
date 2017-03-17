import org.junit.*;
import static org.junit.Assert.*;

public class EventTest {

  private Event testEvent;

  @Before
  public void setUp() {
    testEvent = new Event(100, "Catering", "Full Bar", "DJ");
  }

  @After
  public void tearDown() {
    testEvent = null;
    assertNull(testEvent);
  }

  @Test
  public void newEvent_instantiatedCorrectly() {
    assertEquals(true, testEvent instanceof Event);
  }

  @Test
  public void getGuestCount_returnsTheCorrectNumberOfGuests_100() {
    assertEquals(100, testEvent.getGuestCount());
  }

  @Test
  public void getFoodSelection_returnsTheOptionSelected_Catering() {
    assertEquals("Catering", testEvent.getFoodSelection());
  }

  @Test
  public void getBeverageSelection_returnsTheOptionSelected_FullBar() {
    assertEquals("Full Bar", testEvent.getBeverageSelection());
  }

  @Test
  public void getEntertainmentSelection_returnsTheOptionSelected_DJ() {
    assertEquals("DJ", testEvent.getEnterainmentSelection());
  }
}
