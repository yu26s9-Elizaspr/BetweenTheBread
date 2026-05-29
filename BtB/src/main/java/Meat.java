public class Meat extends Topping {

    private MeatType meatType;

    public Meat(MeatType meatType, boolean extra) {
        super(extra);
        this.meatType = meatType;
    }

    public MeatType getMeatType() {
        return meatType;
    }

    @Override
    public double calculatePrice(SandwichSize size) {

        switch (size) {
            case FOUR_INCH:
                return isExtra() ? 0.50 : 1.00;

            case EIGHT_INCH:
                return isExtra() ? 1.00 : 2.00;

            case TWELVE_INCH:
                return isExtra() ? 1.50 : 3.00;

            default:
                return 0;
        }
    }
    @Override
    public String toString() {
        if (isExtra()) {
            return "Extra " + meatType;
        }
        return meatType.toString();
    }
}
