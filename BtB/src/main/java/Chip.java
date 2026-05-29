public class Chip {
    private String type;

    public Chip (String type) {
        this.type = type;
    }
    // getters
    public String getType() {
        return type;
    }
    //setters
    public void setType(String type){
        this.type = type;
    }

    public double calculatePrice() {
        return 1.50;
    }
    @Override
    public String toString() {
        return type + " - $" +
                String.format("%.2f", calculatePrice());
    }
}
