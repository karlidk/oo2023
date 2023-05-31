// Ülemklass
class Loom {
    void häälitse() {
        System.out.println("Loom häälitseb");
    }
}

// Alamklassid
class Kass extends Loom {
    void häälitse() {
        System.out.println("Kass ütleb: Mjäu");
    }
}

class Koer extends Loom {
    void häälitse() {
        System.out.println("Koer ütleb: Au-au");
    }
}

class Linnud extends Loom {
    void häälitse() {
        System.out.println("Linnud laulavad");
    }
}

// Näitprogramm
public class AlamklassideNäide {
    public static void main(String[] args) {
        Loom loom1 = new Kass();
        Loom loom2 = new Koer();
        Loom loom3 = new Linnud();

        loom1.häälitse(); // Väljund: Kass ütleb: Mjäu
        loom2.häälitse(); // Väljund: Koer ütleb: Au-au
        loom3.häälitse(); // Väljund: Linnud laulavad
    }
}
