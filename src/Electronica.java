public class Electronica extends Producte {

    private int diesGarantia;

    public Electronica(float preu, String nom, String codi, int dies) {
        super(preu, nom, codi);
        this.diesGarantia = dies;
    }

    @Override
    public float getPreu() {
        float preu = super.getPreu();
        return preu + preu * (diesGarantia / 365f) * 0.1f;
    }
}