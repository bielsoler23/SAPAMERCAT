public class Electronica extends Producte {
    private int diesGarantia;

    public Electronica(float preu, String nom, String codi, int diesGarantia) {
        super(preu, nom, codi);
        this.diesGarantia = diesGarantia;
    }

    @Override
    public float getPreu() {
        float preu = super.getPreu();
        return preu + preu * (diesGarantia / 365f) * 0.1f;
    }
}