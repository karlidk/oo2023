import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Novell novell = new Novell("Minu elu", 10.0);

        // loeme raamatud sisse
        try {
            File raamatud = new File("raamat.txt");
            Scanner scanner = new Scanner(raamatud);
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                String[] raamat = rida.split(",");
                if (raamat.length == 3) {
                    String nimetus = raamat[0];
                    double hind = Double.parseDouble(raamat[1]);
                    int id = Integer.parseInt(raamat[2]);
                    novell.lisaRaamat(new Raamat(nimetus, hind, id));
                } else {
                    System.out.println("Viga: tekstireal pole kolme elementi!");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Viga: faili ei leitud!");
        } catch (NumberFormatException e) {
            System.out.println("Viga: numbriline formaat on valesti määratud!");
        }


        // loeme novelli sisse
        try {
            File novellifail = new File("novell.txt");
            Scanner scanner = new Scanner(novellifail);
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                String[] novell2 = rida.split(";");
                String nimetus = novell2[0];
                double maksumus = Double.parseDouble(novell2[1]);
                novell = new Novell(nimetus, maksumus);
                while (scanner.hasNextLine()) {
                    rida = scanner.nextLine();
                    if (rida.equals("")) {
                        break;
                    }
                    String[] raamat = rida.split(";");
                    String raamatuNimetus = raamat[0];
                    double raamatuHind = Double.parseDouble(raamat[1]);
                    int raamatuId = Integer.parseInt(raamat[2]);
                    novell.lisaRaamat(new Raamat(raamatuNimetus, raamatuHind, raamatuId));
                }
                System.out.println("Novell \"" + novell.getNimetus() + "\" maksab " + novell.getMaksumus() + " eurot ja sisaldab järgmisi raamatuid:");
                for (Raamat raamat : novell.getRaamatud()) {
                    System.out.println("- " + raamat.getNimetus() + " (" + raamat.getMaksumus() + " eurot, id " + raamat.getNimetus() + ")");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Faili ei leitud!");
            e.printStackTrace();
        }
    }
}
