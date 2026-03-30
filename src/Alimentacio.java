import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alimentacio extends Producte {

    private LocalDate dataCaducitat;

    public Alimentacio(float preu, String nom, String codi, LocalDate data) {
        super(preu, nom, codi);
        this.dataCaducitat = data;
    }

    @Override
    public float getPreu() {
        float preu = super.getPreu();
        long dies = ChronoUnit.DAYS.between(LocalDate.now(), dataCaducitat);

        return preu - preu * (1f / (dies + 1)) + (preu * 0.1f);
    }
}