import java.time.LocalDate;

public class Alimentacio extends Producte {
    private LocalDate dataCaducitat;

    public Alimentacio(float preu, String nom, String codi, LocalDate dataCaducitat) {
        super(preu, nom, codi);
        this.dataCaducitat = dataCaducitat;
    }


    @Override
    public float getPreu() {
        long dies = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), dataCaducitat);
        float preu = super.getPreu();

        return preu - preu * (1f / (dies + 1)) + (preu * 0.1f);
    }
}