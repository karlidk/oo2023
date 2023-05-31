// Liides
interface Heli {
    void mängi();
}

// Klass, mis implementeerib liidese
class Mp3Mängija implements Heli {
    public void mängi() {
        System.out.println("Mängib MP3 helifaili");
    }
}

// Teine klass, mis implementeerib liidese
class CDMängija implements Heli {
    public void mängi() {
        System.out.println("Mängib CD helifaili");
    }
}

// Testklient
public class Liides {
    public static void main(String[] args) {
        Heli heliseade1 = new Mp3Mängija();
        Heli heliseade2 = new CDMängija();

        heliseade1.mängi(); // Väljund: Mängib MP3 helifaili
        heliseade2.mängi(); // Väljund: Mängib CD helifaili
    }
}
