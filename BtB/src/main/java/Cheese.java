public class Cheese extends Topping {

    private CheeseType cheeseType;

    public Cheese(CheeseType cheeseType, boolean extra) {
        super(extra);
        this.cheeseType = cheeseType;
    }

    public CheeseType getCheeseType() {
        return cheeseType;
    }

    @Override
    public double calculatePrice(SandwichSize size) {
        switch (size) {
            case FOUR_INCH:
                return isExtra() ? 0.30 : 0.75;
            case EIGHT_INCH:
                return isExtra() ? 0.60 : 1.50;
            case TWELVE_INCH:
                return isExtra() ? 0.90 : 2.25;
            default:
                return 0.0;
        }
    }
    @Override
    public String toString() {
        if (isExtra()) {
            return "Extra " + cheeseType;
        }
        return cheeseType.toString();
    }
}
