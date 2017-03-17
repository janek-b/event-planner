import org.junit.*;
import static org.junit.Assert.*;
// import java.util.List;
// import java.util.ArrayList;

public class EventTest {

  private Event testEvent;

  @Before
  public void setUp() {
    testEvent = new Event(100, 0, 0, 0);
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
    assertEquals("Snack Bar", testEvent.getFoodSelection());
  }

  @Test
  public void getBeverageSelection_returnsTheOptionSelected_FullBar() {
    assertEquals("Full Bar", testEvent.getBeverageSelection());
  }

  @Test
  public void getEntertainmentSelection_returnsTheOptionSelected_DJ() {
    assertEquals("DJ", testEvent.getEnterainmentSelection());
  }

  @Test
  public void getFoodOptions_staticMethodReturnsArrayOfOptions() {
    String[] testFoodOptions = {"Snack Bar", "Buffet", "Dinner"};
    assertEquals(testFoodOptions, Event.getFoodOptions());
  }

  @Test
  public void getBeverageOptions_staticMethodReturnsArrayOfOptions() {
    String[] testBeverageOptions = {"Full Bar", "Non-Alcoholic", "BYOB"};
    assertEquals(testBeverageOptions, Event.getBeverageOptions());
  }

  @Test
  public void getEntertainmentOptions_staticMethodReturnsArrayOfOptions() {
    String[] testEntertainmentOptions = {"DJ", "Live Band", "Comedian", "Magician", "None"};
    assertEquals(testEntertainmentOptions, Event.getEntertainmentOptions());
  }

  @Test
  public void getEventPrice_returnsAccurateEstimateBasedOnOptions_2000() {
    assertEquals(2000, testEvent.getEventPrice());
    Event testEvent2 = new Event(50, 2, 0, 1);
    assertEquals(2150, testEvent2.getEventPrice());
  }

  @Test
  public void getDiscountPrice_freeDJIfMoreThan150PeoplewithFoodAndDrink() {
    Event testDJDiscount1 = new Event(150, 2, 0, 0);
    Event testDJDiscount2 = new Event(150, 1, 0, 0);
    assertEquals(5250, testDJDiscount1.getDiscountPrice("freeDJ"), 0.0);
    assertEquals(4050, testDJDiscount2.getDiscountPrice("freeDJ"), 0.0);
    assertEquals(2000, testEvent.getDiscountPrice("freeDJ"), 0.0);
  }

  @Test
  public void getDiscountPrice_20PercentOffWhenDinnerAndBar() {
    Event testPercentDiscount1 = new Event(50, 2, 0, 1);
    Event testPercentDiscount2 = new Event(53, 0, 0, 0);
    assertEquals(1720, testPercentDiscount1.getDiscountPrice("20%off"), 0.0);
    assertEquals(960.8, testPercentDiscount2.getDiscountPrice("20%off"), 0.0);
  }
}
