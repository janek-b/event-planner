import java.io.Console;
import java.util.Arrays;
import java.util.Random;

public class App {
  private static Console console = System.console();

  public static void main(String[] args) {
    Random rng = new Random();

    boolean eventBooked = false;
    while (!eventBooked) {
      printHeader();
      int navChoice = navigation();
      if (navChoice == 1) {
        printHeader();
        System.out.println("\nPlease answer the following questions to get an estimated price for your event.");

        int guestCount = Integer.parseInt(console.readLine("\nHow many guests will be attending? "));
        int food = getSelection("Food", Event.getFoodOptions());
        int beverage = getSelection("Beverage", Event.getBeverageOptions());
        int entertainment = getSelection("Entertainment", Event.getEntertainmentOptions());

        Event newEvent = new Event(guestCount, food, beverage, entertainment);

        printEventdetails(newEvent);
        System.out.println(String.format("The Estimated price for your event: \t$%.2f", newEvent.getEventPrice()));

        applyDiscount(newEvent);

      } else if (navChoice == 2) {
        int randomGuestCount = rng.nextInt(500);
        int randomFood = rng.nextInt(Event.getFoodOptions().length);
        int randomBeverage = rng.nextInt(Event.getBeverageOptions().length);
        int randomEntertainment = rng.nextInt(Event.getEntertainmentOptions().length);

        Event randomEvent = new Event(randomGuestCount, randomFood, randomBeverage, randomEntertainment);

        printEventdetails(randomEvent);
        System.out.println(String.format("The Estimated price for your event: \t$%.2f", randomEvent.getEventPrice()));

      }

      String booked = console.readLine("\nBook this event?\t");
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

  public static void applyDiscount(Event event) {
    if (event.isEligibleForDiscount()) {
      String couponCode = console.readLine("\nYou are eligible for a discount. Enter a coupon code to redeem your discount.\n");
      boolean couponEntered = false;
      while (!couponEntered) {
        if (!Arrays.asList(Event.getCouponCodes()).contains(couponCode)) {
          System.out.println("You did not enter a valid coupon code. No discount applied.\n");
          couponCode = console.readLine("Try a different code or type 'Exit' to skip\t");
          if (couponCode.toLowerCase().equals("exit")) {
            couponEntered = true;
          }
        } else if (!event.isEligibleForDiscount(couponCode)) {
          System.out.println("You are not eligible for this discount.\n");
          couponCode = console.readLine("Try a different code or type 'Exit' to skip\t");
          if (couponCode.toLowerCase().equals("exit")) {
            couponEntered = true;
          }
        } else if (event.isEligibleForDiscount(couponCode)) {
          System.out.println(String.format("\nThe price after applying your discount is: $%.2f", event.getDiscountPrice(couponCode)));
          couponEntered = true;
        }
      }
    }
  }

  public static int navigation() {
    System.out.println("\nPlease a number corresponding with one of the below options");
    System.out.println("\t1) Get Custom Event Package Price.");
    System.out.println("\t2) Random Event Package");
    int choice = Integer.parseInt(console.readLine());
    return choice;
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
