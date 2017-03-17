import java.io.Console;

public class App {
  private static Console console = System.console();

  public static void main(String[] args) {
    printHeader();
    System.out.println("\nPlease answer the following questions to get an estimated price for your event.");

    int guestCount = Integer.parseInt(console.readLine("\nHow many guests will be attending? "));

    int food = getSelection("food", Event.getFoodOptions());
    int beverage = getSelection("beverage", Event.getBeverageOptions());
    int entertainment = getSelection("entertainment", Event.getEntertainmentOptions());

    Event newEvent = new Event(guestCount, food, beverage, entertainment);
    System.out.println(String.format("The Estimated price for your event is: %d", newEvent.getEventPrice()));
  }

  public static int getSelection(String category, String[] options) {
    System.out.println(String.format("\nEnter the number corresponding with the %s option you would like", category));
    for (int i = 1; i <= options.length; i++) {
      System.out.println(String.format("\t%d) %s", i, options[i-1]));
    }
    int selection = Integer.parseInt(console.readLine()) -1;
    return selection;
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
