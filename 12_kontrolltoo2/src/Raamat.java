import java.util.List;
import java.util.ArrayList;
public class Raamat {
    private String nimetus;
    private double maksumus;
    private int lehekülgedeArv;
    private List<Novell> novellid = new ArrayList<>();

    public Raamat(String nimetus, double maksumus, int lehekülgedeArv) {
        this.nimetus = nimetus;
        this.maksumus = maksumus;
        this.lehekülgedeArv = lehekülgedeArv;
    }

    public void lisaNovell(Novell novell) {
        novellid.add(novell);
    }

    public double getMaksumus() {
        return maksumus;
    }

    public int getLehekülgedeArv() {
        return lehekülgedeArv;
    }

    public String getNimetus() {
        return nimetus;
    }

    public List<Novell> getNovellid() {
        return novellid;
    }

    public double raamatuMaksumus() {
        double summa = 0;
        for (Novell novell : novellid) {
            summa += novell.getMaksumus();
        }
        return summa + maksumus;
    }
}
