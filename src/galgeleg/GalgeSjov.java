package galgeleg;

import java.util.Scanner;

public class GalgeSjov {

    Scanner scanner = new Scanner(System.in); // opret scanner-objekt

    public void method() {
        System.out.println("**********************************************");
        System.out.println("**                                          **");
        System.out.println("**  SERVER for brugerautorisationsmodulet   **");
        System.out.println("**                                          **");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println("Du er ved at starte serveren for brugerautorisationsmodulet");
        System.out.println();
        System.out.println("Er det det du ønsker? (tryk 'n' for at afbryde)");
        if (scanner.nextLine().toLowerCase().startsWith("n")) {
            System.out.println("OK - afslutter programmet");
            System.exit(0);
        }

    }


}
