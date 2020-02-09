package servers;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class BenytGalgeLogikKlient {
    static GalgeLogikI k;
    static Scanner scanner;

    public static void main(String[] arg) throws Exception {
        //k = (GalgeLogikI) Naming.lookup("rmi://localhost:1099/galgetjeneste");
        k = (GalgeLogikI) Naming.lookup("rmi://freilarsen.ddns.net:20099/galgetjeneste");
        dialogMethod();
    }

    public static void dialogMethod() throws Exception {
        scanner = new Scanner(System.in);

        System.out.println("**********************************************");
        System.out.println("**                                          **");
        System.out.println("**          VELKOMMEN TIL GALGELEG          **");
        System.out.println("**                                          **");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();
        System.out.println("Indtast 'exit' for at afbryde\n Tryk 'Enter' for at fortsætte");

        while (true) try {
            System.out.println();
            System.out.println("1 Spil med standard indstillinger");
            System.out.println("2 Spil med ord hentet fra dr");
            System.out.print("Skriv valg: ");
            String valgString = scanner.next();
            int valg = 0;
            try {
                valg = Integer.parseInt(valgString);
            } catch (Exception e) {
                if (valgString.equalsIgnoreCase("exit")) {
                    break;
                } else {
                }
            }

            if (valg == 1) {
                k.nulstil();
                guessMethod();

            } else if (valg == 2) {
                System.out.println("Henter ord fra DR!");
                k.hentOrdFraDr();
                Thread.sleep(2);
                guessMethod();

            } else {
                System.out.println("\nUlovligt valg!");
            }

            if (k.erSpilletSlut() || k.erSpilletTabt() || k.erSpilletVundet()) {

                System.out.println("\nSpillet er slut!");
                if (k.erSpilletTabt()) {
                    System.out.println("Trist, du tabte!");
                    System.out.println("Ordet var " + k.getOrdet());
                    break;
                } else {
                    //k.erSpilletVundet()
                    System.out.println("Tillykke du vandt!");
                }
            }

        } catch (
                Throwable t) {
            t.printStackTrace();
            scanner.nextLine();
        }
        System.out.println("Afslutter programmet... ");
        System.exit(0);
    }

    static private void guessMethod() throws RemoteException {
        System.out.println("Skriv et bogstav og tryk 'enter' for at gætte");
        while (!k.erSpilletSlut() && !k.erSpilletTabt() && !k.erSpilletVundet()) {
            System.out.println("\nForkerte gæt " + k.getAntalForkerteBogstaver());
            System.out.println(k.getSynligtOrd());
            k.gætBogstav(scanner.next());
        }
    }
}


