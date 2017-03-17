public class Event {
  private int mGuestCount;
  private String mFoodSelection;
  private String mBeverageSelection;
  private String mEntertainmentSelection;

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
}
