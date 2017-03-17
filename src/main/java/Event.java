public class Event {
  private int mGuestCount;
  private String mFoodSelection;

  public Event(int guestCount, String foodSelection) {
    mGuestCount = guestCount;
    mFoodSelection = foodSelection;
  }

  public int getGuestCount() {
    return mGuestCount;
  }

  public String getFoodSelection() {
    return mFoodSelection;
  }
}
