import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Compra {

    private Scanner sc = new Scanner(System.in);
    private Map<Producte, Integer> carro = new HashMap<>();

    public void iniciar() {
        int op;

        System.out.println("BENVINNGUT AL SAPAMERCAT");

        do {
            System.out.println("\nINICI");
            System.out.println("1) Introduit producte");
            System.out.println("2) Passar per caixa");
            System.out.println("3) Mostar carret de compra");
            System.out.println("0) Acabar");

            op = Integer.parseInt(sc.nextLine());

            switch(op) {
                case 1: menuProducte(); break;
                case 2: passarCaixa(); break;
                case 3: mostrarCarro(); break;
            }

        } while(op != 0);
    }

    private void menuProducte() {
        int op;

        do {
            System.out.println("\nPRODUCTE");
            System.out.println("1) Alimentació");
            System.out.println("2) Tèxtil");
            System.out.println("3) Electrònica");
            System.out.println("0) Tornar");

            op = Integer.parseInt(sc.nextLine());

            switch(op) {
                case 1: afegirAliment(); break;
                case 2: afegirTextil(); break;
                case 3: afegirElectronica(); break;
            }

        } while(op != 0);
    }

    private void afegirAliment() {
        System.out.println("Afegir aliment");

        System.out.print("Nom producte: ");
        String nom = sc.nextLine();

        System.out.print("Preu: ");
        float preu = Float.parseFloat(sc.nextLine());

        System.out.print("Codi de barres: ");
        String codi = sc.nextLine();

        System.out.print("Data caducitat (yyyy-mm-dd): ");
        LocalDate data = LocalDate.parse(sc.nextLine());

        afegirAlCarro(new Alimentacio(preu, nom, codi, data));
    }

    private void afegirTextil() {
        System.out.println("Afegir tèxtil");

        System.out.print("Nom producte: ");
        String nom = sc.nextLine();

        System.out.print("Preu: ");
        float preu = Float.parseFloat(sc.nextLine());

        System.out.print("Composició: ");
        String comp = sc.nextLine();

        System.out.print("Codi de barres: ");
        String codi = sc.nextLine();

        // evitar duplicats
        boolean existeix = carro.keySet().stream()
                .anyMatch(p -> p.getCodiBarres().equals(codi));

        if(existeix) {
            System.out.println("Ja existeix un tèxtil amb aquest codi!");
            return;
        }

        afegirAlCarro(new Textil(preu, nom, codi, comp));
    }

    private void afegirElectronica() {
        System.out.println("Afegir electrònica");

        System.out.print("Nom producte: ");
        String nom = sc.nextLine();

        System.out.print("Preu: ");
        float preu = Float.parseFloat(sc.nextLine());

        System.out.print("Garantia (dies): ");
        int dies = Integer.parseInt(sc.nextLine());

        System.out.print("Codi de barres: ");
        String codi = sc.nextLine();

        afegirAlCarro(new Electronica(preu, nom, codi, dies));
    }

    private void afegirAlCarro(Producte p) {
        if(carro.containsKey(p))
            carro.put(p, carro.get(p) + 1);
        else
            carro.put(p, 1);
    }

    public void passarCaixa() {
        if(carro.isEmpty()) {
            System.out.println("El carro està buit!");
            return;
        }

        System.out.println("\nSAPAMERCAT");
        System.out.println("Data: " + LocalDate.now());

        double total = 0;

        for(Map.Entry<Producte,Integer> entry : carro.entrySet()) {
            Producte p = entry.getKey();
            int q = entry.getValue();

            double subtotal = p.getPreu() * q;

            System.out.println(p.getNom() + " " + q + " " + p.getPreu());
            total += subtotal;
        }

        System.out.println("\nTotal: " + total);

        carro.clear();
    }

    public void mostrarCarro() {
        if(carro.isEmpty()) {
            System.out.println("El carro està buit!");
            return;
        }

        System.out.println("\nCarret:");

        List<Textil> textils = carro.keySet().stream()
                .filter(p -> p instanceof Textil)
                .map(p -> (Textil)p)
                .sorted(Textil.compararPerComposicio())
                .collect(Collectors.toList());

        for(Textil t : textils)
            System.out.println(t.getNom() + " -> " + carro.get(t));

        carro.keySet().stream()
                .filter(p -> !(p instanceof Textil))
                .forEach(p -> System.out.println(p.getNom() + " -> " + carro.get(p)));
    }
}