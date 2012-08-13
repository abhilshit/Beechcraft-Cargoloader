package cargoplanner;

/**
 * A unit load device (ULD) or a cargo container that has weight,
 * it has many other properties that are out of scope of this application
 * @author Abhilshit Soni
 */
public class ULD {
    private double weight ;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ULD(double weight) {
        this.weight=weight;
    }
    
}
