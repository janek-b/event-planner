public class Event {
  private int mGuestCount;
  private String mFoodSelection;
  private String mBeverageSelection;
  private String mEntertainmentSelection;

  private static String[] mFoodOptions = {"Snack Bar", "Buffet", "Dinner"};
  private static String[] mBeverageOptions = {"Full Bar", "Non-Alcoholic", "BYOB"};
  private static String[] mEntertainmentOptions = {"DJ", "Live Band", "Comedian", "Magician", "None"};

  public Event(int guestCount, int food, int beverage, int entertainment) {
    mGuestCount = guestCount;
    mFoodSelection = mFoodOptions[food];
    mBeverageSelection = mBeverageOptions[beverage];
    mEntertainmentSelection = mEntertainmentOptions[entertainment];
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

  public static String[] getBeverageOptions() {
    return mBeverageOptions;
  }

  public static String[] getEntertainmentOptions() {
    return mEntertainmentOptions;
  }

  public int getEventPrice() {
    int pricePerPerson = 0;
    int entertainmentPrice = 0;
    switch (mFoodSelection) {
      case "Snack Bar" :
        pricePerPerson += 2;
        break;
      case "Buffet" :
        pricePerPerson += 10;
        break;
      case "Dinner" :
        pricePerPerson += 20;
        break;
    }
    switch (mBeverageSelection) {
      case "Full Bar":
        pricePerPerson += 15;
        break;
      case "Non-Alcoholic":
        pricePerPerson += 5;
        break;
      case "BYOB":
        pricePerPerson += 0;
        break;
    }
    switch (mEntertainmentSelection) {
      case "DJ":
        entertainmentPrice = 300;
        break;
      case "Live Band":
        entertainmentPrice = 400;
        break;
      case "Comedian":
        entertainmentPrice = 200;
        break;
      case "Magician":
        entertainmentPrice = 100;
        break;
      case "None":
        entertainmentPrice = 0;
        break;
    }
    return pricePerPerson * mGuestCount + entertainmentPrice;
  }

  public double getDiscountPrice(String coupon) {
    double discount = 0;
    if (coupon.equals("freeDJ") && mFoodSelection.equals("Dinner") && mBeverageSelection.equals("Full Bar") && mGuestCount >= 150) {
      discount = getEventPrice() - 300;
    } else if (coupon.equals("20%off")) {
      discount = getEventPrice() * 0.8;
    } else {
      discount = getEventPrice();
    }

    return discount;
    // discount = Math.round(discount * 100);
    // return discount/100;
    // return (Math.round(discount * 100))/100;
  }

}
