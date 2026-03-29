public class Electronica extends Producte {
    private int diesGarantia;

    public Electronica(float preu, String nom, String codi, int diesGarantia) {
        super(preu, nom, codi);
        this.diesGarantia = diesGarantia;
    }
}