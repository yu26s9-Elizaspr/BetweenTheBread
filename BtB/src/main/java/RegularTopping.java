public class RegularTopping extends Topping {

    private ToppingType toppingType;

    public RegularTopping(ToppingType toppingType) {
        super(false);
        this.toppingType = toppingType;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }

    @Override
    public double calculatePrice(SandwichSize size) {
        return 0.0;
    }

    @Override
    public String toString() {
        return toppingType.toString();
    }
}
