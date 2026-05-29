
import java.util.ArrayList;
import java.util.List;

public class Sandwhich {

        private SandwichSize size;
        private BreadType breadType;
        private boolean toasted;
        private List<Topping> toppings;
        private List<SauceType> sauces;
        private List<Sides> sides;

        public Sandwhich(SandwichSize size, BreadType breadType, boolean toasted) {
            this.size = size;
            this.breadType = breadType;
            this.toasted = toasted;
            this.toppings = new ArrayList<>();
            this.sauces = new ArrayList<>();
            this.sides = new ArrayList<>();
        }

        public void addTopping(Topping topping) {
            toppings.add(topping);
        }

        public void addSauce(SauceType sauce) {
            sauces.add(sauce);
        }

        public void addSide(Sides side) {
            sides.add(side);
        }

        public double calculatePrice() {
            double total = size.getBasePrice();

            for (Topping topping : toppings) {
                total += topping.calculatePrice(size);
            }

            return total;
        }

        public SandwichSize getSize() {
            return size;
        }

        public BreadType getBreadType() {
            return breadType;
        }

        public boolean isToasted() {
            return toasted;
        }

        public List<Topping> getToppings() {
            return toppings;
        }

        public List<SauceType> getSauces() {
            return sauces;
        }

        public List<Sides> getSides() {
            return sides;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append(size).append(" sandwich on ").append(breadType).append(" bread\n");

            if (toasted) {
                sb.append("Toasted: yes\n");
            } else {
                sb.append("Toasted: no\n");
            }

            if (!toppings.isEmpty()) {
                sb.append("Toppings: ");
                for (Topping topping : toppings) {
                    sb.append(topping).append(", ");
                }
                sb.setLength(sb.length() - 2);
                sb.append("\n");
            }

            if (!sauces.isEmpty()) {
                sb.append("Sauces: ");
                for (SauceType sauce : sauces) {
                    sb.append(sauce).append(", ");
                }
                sb.setLength(sb.length() - 2);
                sb.append("\n");
            }

            if (!sides.isEmpty()) {
                sb.append("Sides: ");
                for (Sides side : sides) {
                    sb.append(side).append(", ");
                }
                sb.setLength(sb.length() - 2);
                sb.append("\n");
            }

            sb.append(String.format("Price: $%.2f", calculatePrice()));

            return sb.toString();
        }
    }

