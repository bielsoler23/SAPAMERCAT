public abstract class Producte {

    private float preu;
    private String nom;
    private String codiBarres;

    public Producte(float preu, String nom, String codiBarres) {
        this.preu = preu;
        this.nom = nom;
        this.codiBarres = codiBarres;
    }

    public float getPreu() {
        return preu;
    }

    public String getNom() {
        return nom;
    }

    public String getCodiBarres() {
        return codiBarres;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodiBarres(String codiBarres) {
        this.codiBarres = codiBarres;
    }

    // IMPORTANT per Map
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Producte)) return false;
        Producte p = (Producte) o;
        return codiBarres.equals(p.getCodiBarres()) && getPreu() == p.getPreu();
    }

    @Override
    public int hashCode() {
        return codiBarres.hashCode();
    }
}