import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDateTime orderTime;
    private PaymentType paymentType;


    private List<Sandwhich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;

    public Order() {
        this.orderTime = LocalDateTime.now();

        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public void addSandwich(Sandwhich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double calculateOrderTotal() {

        double total = 0.0;

        for (Sandwhich sandwich : sandwiches) {
            total += sandwich.calculatePrice();
        }

        for (Drink drink : drinks) {
            total += drink.calculatePrice();
        }

        for (Chip chip : chips) {
            total += chip.calculatePrice();
        }

        return total;
    }

    public boolean isValidOrder() {
        return !sandwiches.isEmpty()
                || !drinks.isEmpty()
                || !chips.isEmpty();
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public List<Sandwhich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chip> getChips() {
        return chips;
    }

    @Override
    public String toString() {

        String receipt = "";

        receipt += "====================================\n";
        receipt += "         BETWEEN THE BREAD\n";
        receipt += "====================================\n";

        receipt += "Date: " + orderTime + "\n\n";
        receipt += "Payment Method: " + paymentType + "\n\n";

        for (Sandwhich sandwich : sandwiches) {
            receipt += sandwich + "\n\n";
        }

        for (Drink drink : drinks) {
            receipt += drink + "\n";
        }

        for (Chip chip : chips) {
            receipt += chip + "\n";
        }

        receipt += "\n------------------------------------\n";
        receipt += String.format("TOTAL: $%.2f%n", calculateOrderTotal());
        receipt += "====================================";

        return receipt;
    }
}