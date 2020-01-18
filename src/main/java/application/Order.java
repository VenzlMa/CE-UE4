package application;

public class Order {

    private final long id;
    private final String griff;
    private final String lenkertyp;
    private final String material;
    private final String schaltung;


    public Order(long id, String griff, String lenkertyp, String material, String schaltung) {
        this.id = id;
        this.griff = griff;
        this.lenkertyp = lenkertyp;
        this.material = material;
        this.schaltung = schaltung;
    }
}
