public class Drink {
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    //getters
    public DrinkSize getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double calculatePrice() {
        return size.getPrice();
    }

    public String getDescription() {
        return size + " " + flavor + " - $" + calculatePrice();
    }
    @Override
    public String toString() {
        return size + " " + flavor + " - $" +
                String.format("%.2f", calculatePrice());
    }
}


