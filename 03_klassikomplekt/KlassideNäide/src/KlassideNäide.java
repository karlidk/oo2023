// Klass "Eksemplar"
class Eksemplar {
    private String nimi;

    public Eksemplar(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
}

// Klass "Hoidla"
class Hoidla {
    private Eksemplar[] eksemplarid;

    public Hoidla(int suurus) {
        eksemplarid = new Eksemplar[suurus];
    }

    public void lisaEksemplar(int indeks, Eksemplar eksemplar) {
        eksemplarid[indeks] = eksemplar;
    }

    public Eksemplar getEksemplar(int indeks) {
        return eksemplarid[indeks];
    }
}

// Näitprogramm
public class KlassideNäide {
    public static void main(String[] args) {
        Hoidla hoidla = new Hoidla(3);

        Eksemplar eksemplar1 = new Eksemplar("Eksemplar 1");
        Eksemplar eksemplar2 = new Eksemplar("Eksemplar 2");
        Eksemplar eksemplar3 = new Eksemplar("Eksemplar 3");

        hoidla.lisaEksemplar(0, eksemplar1);
        hoidla.lisaEksemplar(1, eksemplar2);
        hoidla.lisaEksemplar(2, eksemplar3);

        for (int i = 0; i < 3; i++) {
            Eksemplar eksemplar = hoidla.getEksemplar(i);
            System.out.println("Eksemplari nimi: " + eksemplar.getNimi());
        }
    }
}
