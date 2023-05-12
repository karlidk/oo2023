import java.util.ArrayList;

public class Novell {
    private String nimetus;
    private double maksumus;
    private ArrayList<Raamat> raamatud;

    public Novell(String nimetus, double maksumus) {
        this.nimetus = nimetus;
        this.maksumus = maksumus;
        this.raamatud = new ArrayList<Raamat>();
    }

    public String getNimetus() {
        return nimetus;
    }

    public double getMaksumus() {
        return maksumus;
    }

    public void lisaRaamat(Raamat raamat) {
        raamatud.add(raamat);
    }

    public ArrayList<Raamat> getRaamatud() {
        return raamatud;
    }

    public void kontrolliPikkust() {
        if (nimetus.length() < 10) {
            System.out.println("Veateade: Novelli nimi on lühem kui 10 tähemärki!");
        }
    }
}
