import java.util.Comparator;

public class Textil extends Producte implements Comparable<Textil> {

    private String composicio;

    public Textil(float preu, String nom, String codi, String comp) {
        super(preu, nom, codi);
        this.composicio = comp;
    }

    public String getComposicio() {
        return composicio;
    }

    public void setComposicio(String composicio) {
        this.composicio = composicio;
    }

    // Comparable (ordre natural)
    @Override
    public int compareTo(Textil o) {
        return composicio.compareTo(o.getComposicio());
    }

    // Comparator (extra)
    public static Comparator<Textil> compararPerComposicio() {
        return new Comparator<Textil>() {
            @Override
            public int compare(Textil o1, Textil o2) {
                return o1.getComposicio().compareTo(o2.getComposicio());
            }
        };
    }
}