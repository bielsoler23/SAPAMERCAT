import java.time.LocalDate;

public class Alimentacio extends Producte {
    private LocalDate dataCaducitat;

    public Alimentacio(float preu, String nom, String codi, LocalDate dataCaducitat) {
        super(preu, nom, codi);
        this.dataCaducitat = dataCaducitat;
    }
}