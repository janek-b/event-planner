public class Event {
  private int mGuestCount;
  private String mFoodSelection;
  private String mBeverageSelection;
  private String mEntertainmentSelection;

  private static String[] mFoodOptions = {"Snack Bar", "Buffet", "Catering", "Dinner"};

  public Event(int guestCount, String food, String beverage, String entertainment) {
    mGuestCount = guestCount;
    mFoodSelection = food;
    mBeverageSelection = beverage;
    mEntertainmentSelection = entertainment;
  }

  public int getGuestCount() {
    return mGuestCount;
  }

  public String getFoodSelection() {
    return mFoodSelection;
  }

  public String getBeverageSelection() {
    return mBeverageSelection;
  }

  public String getEnterainmentSelection() {
    return mEntertainmentSelection;
  }

  public static String[] getFoodOptions() {
    return mFoodOptions;
  }
}
