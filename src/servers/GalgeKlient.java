package servers;

import java.rmi.Naming;
import java.util.ArrayList;

public class GalgeKlient {
	public static void main(String[] arg) throws Exception {
		GalgeLegI k = (GalgeLegI) Naming.lookup("rmi://localhost:1099/galgetjeneste");
		System.out.println(		k.getSynligtOrd());

		k.gætBogstav("e");
		System.out.println(		k.getSynligtOrd());

		k.gætBogstav("a");
		System.out.println(		k.getSynligtOrd());

		k.gætBogstav("o");
		System.out.println(		k.getSynligtOrd());

		k.gætBogstav("i");
		System.out.println(		k.getSynligtOrd());


		/*

		k.overførsel(100);
		k.overførsel(50);
		System.out.println("Saldo er: " + k.saldo());
		k.overførsel(-150);
		System.out.println("Saldo ved slut er: " + k.saldo());
		ArrayList<String> bevægelser = k.bevægelser();
		System.out.println("Bevægelser er: " + bevægelser);
		k.setNavn("Ny konto");
		System.out.println(k.getNavn());
*/


/*
		long tid = System.currentTimeMillis();
		for (int i=0; i<100; i++) {
			k.overførsel(1);
			k.overførsel(-1);
		}
		long dt = System.currentTimeMillis() - tid;
		System.out.println( "Kørselstiden for RMI var: "+ dt );
*/



	}
}

