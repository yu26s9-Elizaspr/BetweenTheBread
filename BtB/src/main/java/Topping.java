public abstract class Topping {

    private boolean extra;

    public Topping(boolean extra) {
        this.extra = extra;
    }

    public boolean isExtra() {
        return extra;
    }

    public abstract double calculatePrice(SandwichSize size);
}