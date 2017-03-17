import java.io.Console;

public class App {
  private static Console console = System.console();

  public static void main(String[] args) {

    boolean eventBooked = false;
    while (!eventBooked) {
      printHeader();
      System.out.println("\nPlease answer the following questions to get an estimated price for your event.");

      int guestCount = Integer.parseInt(console.readLine("\nHow many guests will be attending? "));
      int food = getSelection("Food", Event.getFoodOptions());
      int beverage = getSelection("Beverage", Event.getBeverageOptions());
      int entertainment = getSelection("Entertainment", Event.getEntertainmentOptions());
      String couponCode = "";
      Event newEvent = new Event(guestCount, food, beverage, entertainment);
      printEventdetails(newEvent);
      System.out.println(String.format("The Estimated price for your event: \t$%.2f", newEvent.getDiscountPrice(couponCode)));


      boolean couponEntered = false;
      while (!couponEntered) {
        couponCode = console.readLine("\nEnter a coupon code to find out if you're eligable for a discounted price.\n");
        if (couponCode.equals("")) {
          System.out.println("\nYou did not enter a valid coupon code. No discount applied.\n");
          String tryagain = console.readLine("Try Again?\t");
          if (tryagain.toLowerCase().charAt(0) == 'n') {
            couponEntered = true;
          }
        } else {
          System.out.println(String.format("\nThe price after applying your coupon code is: $%.2f", newEvent.getDiscountPrice(couponCode)));
          couponEntered = true;
        }
      }


      String booked = console.readLine("Book this event?\t");
      if (booked.toLowerCase().charAt(0) == 'y') {
        System.out.println("Thank you for planning your event with us.");
        eventBooked = true;
      } else if (booked.toLowerCase().charAt(0) == 'n') {
        String option = console.readLine("Would you like to plan a new event?\t");
        if (option.toLowerCase().charAt(0) == 'n') {
          eventBooked = true;
        }
      }
    }
  }

  public static int getSelection(String category, String[] options) {
    System.out.println(String.format("\nEnter the number corresponding with the %s option you would like", category));
    for (int i = 1; i <= options.length; i++) {
      System.out.println(String.format("\t%d) %s", i, options[i-1]));
    }
    int selection = Integer.parseInt(console.readLine()) -1;
    return selection;
  }

  public static void printEventdetails(Event event) {
    printHeader();
    System.out.println("\nHere are the details for your upcoming Event:\n");
    System.out.println(String.format("Expected number of Guests:\t\t%d", event.getGuestCount()));
    System.out.println(String.format("The Food option selected:\t\t%s", event.getFoodSelection()));
    System.out.println(String.format("The Beverage option selected:\t\t%s", event.getBeverageSelection()));
    System.out.println(String.format("The Entertainment option selected:\t%s", event.getEnterainmentSelection()));
  }

  public static void printHeader() {
    System.out.print("\033[H\033[2J");
    System.out.println("________  __     __  ________  __    __  ________  ______  ");
    System.out.println("/        |/  |   /  |/        |/  \\  /  |/        |/      \\ ");
    System.out.println("$$$$$$$$/ $$ |   $$ |$$$$$$$$/ $$  \\ $$ |$$$$$$$$//$$$$$$  |");
    System.out.println("$$ |__    $$ |   $$ |$$ |__    $$$  \\$$ |   $$ |  $$ \\__$$/ ");
    System.out.println("$$    |   $$  \\ /$$/ $$    |   $$$$  $$ |   $$ |  $$      \\ ");
    System.out.println("$$$$$/     $$  /$$/  $$$$$/    $$ $$ $$ |   $$ |   $$$$$$  |");
    System.out.println("$$ |_____   $$ $$/   $$ |_____ $$ |$$$$ |   $$ |  /  \\__$$ |");
    System.out.println("$$       |   $$$/    $$       |$$ | $$$ |   $$ |  $$    $$/ ");
    System.out.println("$$$$$$$$/     $/     $$$$$$$$/ $$/   $$/    $$/    $$$$$$/  ");
  }
}
