public enum SandwichSize {
    FOUR_INCH(5.50),
    EIGHT_INCH(7.00),
    TWELVE_INCH(8.50);

    private double basePrice;

    SandwichSize(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
