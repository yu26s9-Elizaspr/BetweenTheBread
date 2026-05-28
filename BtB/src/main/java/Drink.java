public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    //getters
    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    //setters
    public void setSize(String size) {
        this.size = size;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}


