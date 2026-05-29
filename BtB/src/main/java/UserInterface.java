import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private Order currentOrder;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayHomeScreen() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== BETWEEN THE BREAD ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    currentOrder = new Order();
                    displayOrderScreen();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void displayOrderScreen() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n=== Order Screen ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChip();
                    break;
                case "4":
                    checkout();
                    ordering = false;
                    break;
                case "0":
                    currentOrder = null;
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void addDrink() {
        System.out.println("\nChoose drink size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.print("Choice: ");

        DrinkSize size;

        switch (scanner.nextLine()) {
            case "1":
                size = DrinkSize.SMALL;
                break;
            case "2":
                size = DrinkSize.MEDIUM;
                break;
            case "3":
                size = DrinkSize.LARGE;
                break;
            default:
                System.out.println("Invalid size.");
                return;
        }

        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);

        System.out.println("Drink added.");
    }

    public void addChip() {
        System.out.print("\nWhat type of chips would you like? ");
        String chipType = scanner.nextLine();

        Chip chip = new Chip(chipType);
        currentOrder.addChip(chip);

        System.out.println("Chips added.");
    }

    public void addSandwich() {

        SandwichSize size = chooseSandwichSize();
        if (size == null) return;

        BreadType breadType = chooseBreadType();
        if (breadType == null) return;

        System.out.print("Would you like it toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwhich sandwhich = new Sandwhich(size, breadType, toasted);

        addMeats(sandwhich);
        addCheeses(sandwhich);
        addRegularToppings(sandwhich);
        addSauces(sandwhich);
        addSides(sandwhich);

        currentOrder.addSandwich(sandwhich);

        System.out.println("Sandwich added!");
    }

    private SandwichSize chooseSandwichSize() {
        System.out.println("\nChoose sandwich size:");
        System.out.println("1) 4 inch");
        System.out.println("2) 8 inch");
        System.out.println("3) 12 inch");
        System.out.print("Choice: ");

        switch (scanner.nextLine()) {
            case "1":
                return SandwichSize.FOUR_INCH;
            case "2":
                return SandwichSize.EIGHT_INCH;
            case "3":
                return SandwichSize.TWELVE_INCH;
            default:
                System.out.println("Invalid size.");
                return null;
        }
    }

    private BreadType chooseBreadType() {
        System.out.println("\nChoose bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.print("Choice: ");

        switch (scanner.nextLine()) {
            case "1":
                return BreadType.WHITE;
            case "2":
                return BreadType.WHEAT;
            case "3":
                return BreadType.RYE;
            case "4":
                return BreadType.WRAP;
            default:
                System.out.println("Invalid bread.");
                return null;
        }
    }

    private void addMeats(Sandwhich sandwich) {
        System.out.println("\nChoose meat:");
        System.out.println("1) Steak");
        System.out.println("2) Ham");
        System.out.println("3) Salami");
        System.out.println("4) Roast Beef");
        System.out.println("5) Chicken");
        System.out.println("6) Bacon");
        System.out.println("0) No meat");
        System.out.print("Choice: ");

        MeatType meatType;

        switch (scanner.nextLine()) {
            case "1":
                meatType = MeatType.STEAK;
                break;
            case "2":
                meatType = MeatType.HAM;
                break;
            case "3":
                meatType = MeatType.SALAMI;
                break;
            case "4":
                meatType = MeatType.ROAST_BEEF;
                break;
            case "5":
                meatType = MeatType.CHICKEN;
                break;
            case "6":
                meatType = MeatType.BACON;
                break;
            case "0":
                return;
            default:
                System.out.println("Invalid meat.");
                return;
        }

        sandwich.addTopping(new Meat(meatType, false));

        System.out.print("Extra meat? yes/no: ");
        boolean extra = scanner.nextLine().equalsIgnoreCase("yes");

        if (extra) {
            sandwich.addTopping(new Meat(meatType, true));
        }
    }

    private void addCheeses(Sandwhich sandwich) {
        System.out.println("\nChoose cheese:");
        System.out.println("1) American");
        System.out.println("2) Provolone");
        System.out.println("3) Cheddar");
        System.out.println("4) Swiss");
        System.out.println("0) No cheese");
        System.out.print("Choice: ");

        CheeseType cheeseType;

        switch (scanner.nextLine()) {
            case "1":
                cheeseType = CheeseType.AMERICAN;
                break;
            case "2":
                cheeseType = CheeseType.PROVOLONE;
                break;
            case "3":
                cheeseType = CheeseType.CHEDDAR;
                break;
            case "4":
                cheeseType = CheeseType.SWISS;
                break;
            case "0":
                return;
            default:
                System.out.println("Invalid cheese.");
                return;
        }

        sandwich.addTopping(new Cheese(cheeseType, false));

        System.out.print("Extra cheese? yes/no: ");
        boolean extra = scanner.nextLine().equalsIgnoreCase("yes");

        if (extra) {
            sandwich.addTopping(new Cheese(cheeseType, true));
        }
    }

    private void addRegularToppings(Sandwhich sandwich) {
        while (true) {
            System.out.println("\nChoose regular topping:");
            System.out.println("1) Lettuce");
            System.out.println("2) Peppers");
            System.out.println("3) Onions");
            System.out.println("4) Tomatoes");
            System.out.println("5) Jalapenos");
            System.out.println("6) Cucumbers");
            System.out.println("7) Pickles");
            System.out.println("8) Guacamole");
            System.out.println("9) Mushrooms");
            System.out.println("0) Done");
            System.out.print("Choice: ");

            ToppingType toppingType;

            switch (scanner.nextLine()) {
                case "1":
                    toppingType = ToppingType.LETTUCE;
                    break;
                case "2":
                    toppingType = ToppingType.PEPPERS;
                    break;
                case "3":
                    toppingType = ToppingType.ONIONS;
                    break;
                case "4":
                    toppingType = ToppingType.TOMATOES;
                    break;
                case "5":
                    toppingType = ToppingType.JALAPENOS;
                    break;
                case "6":
                    toppingType = ToppingType.CUCUMBERS;
                    break;
                case "7":
                    toppingType = ToppingType.PICKLES;
                    break;
                case "8":
                    toppingType = ToppingType.GUACAMOLE;
                    break;
                case "9":
                    toppingType = ToppingType.MUSHROOMS;
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid topping.");
                    continue;
            }

            sandwich.addTopping(new RegularTopping(toppingType));
        }
    }

    private void addSauces(Sandwhich sandwich) {
        while (true) {
            System.out.println("\nChoose sauce:");
            System.out.println("1) Mayo");
            System.out.println("2) Mustard");
            System.out.println("3) Ketchup");
            System.out.println("4) Ranch");
            System.out.println("5) Thousand Islands");
            System.out.println("6) Vinaigrette");
            System.out.println("0) Done");
            System.out.print("Choice: ");

            switch (scanner.nextLine()) {
                case "1":
                    sandwich.addSauce(SauceType.MAYO);
                    break;
                case "2":
                    sandwich.addSauce(SauceType.MUSTARD);
                    break;
                case "3":
                    sandwich.addSauce(SauceType.KETCHUP);
                    break;
                case "4":
                    sandwich.addSauce(SauceType.RANCH);
                    break;
                case "5":
                    sandwich.addSauce(SauceType.THOUSAND_ISLANDS);
                    break;
                case "6":
                    sandwich.addSauce(SauceType.VINAIGRETTE);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid sauce.");
            }
        }
    }

    private void addSides(Sandwhich sandwich) {
        while (true) {
            System.out.println("\nChoose side:");
            System.out.println("1) Au Jus");
            System.out.println("2) Sauce");
            System.out.println("0) Done");
            System.out.print("Choice: ");

            switch (scanner.nextLine()) {
                case "1":
                    sandwich.addSide(Sides.AU_JUS);
                    break;
                case "2":
                    sandwich.addSide(Sides.SAUCE);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid side.");
            }
        }
    }

    public void checkout() {
        if (!currentOrder.isValidOrder()) {
            System.out.println("Order is empty.");
            return;
        }

        System.out.println("\n=== Checkout ===");
        System.out.println(currentOrder);

        System.out.print("Confirm order? yes/no: ");
        String confirm = scanner.nextLine().trim();

        while (!confirm.equalsIgnoreCase("yes") &&
                !confirm.equalsIgnoreCase("no")) {

            System.out.print("Please enter yes or no: ");
            confirm = scanner.nextLine().trim();
        }

        if (confirm.equalsIgnoreCase("yes")) {
            ReceiptWriter writer = new ReceiptWriter();
            writer.saveReceipt(currentOrder);
            System.out.println("Order confirmed.");
        } else {
            System.out.println("Order canceled.");
        }

        currentOrder = null;
    }
}