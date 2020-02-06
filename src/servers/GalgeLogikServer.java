package servers;

import java.rmi.Naming;

public class GalgeLogikServer {
    public static void main(String[] arg) throws Exception {
        // Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
		java.rmi.registry.LocateRegistry.createRegistry(1099); // start i server-JVM
		GalgeLogikI k = new GalgeLogikImpl();
		Naming.rebind("rmi://localhost:1099/galgetjeneste", k);
		System.out.println("GalgeTjeneste registreret.");

        /*java.rmi.registry.LocateRegistry.createRegistry(8080); // lyt på port 20099
        GalgeLogikI k = new GalgeLogikImpl();
        Naming.rebind("rmi://localhost:1099/galgetjeneste", k);
        System.setProperty("java.rmi.server.hostname", "freilarsen.ddns.net/");
        Naming.rebind("rmi://freilarsen.ddns.net/galgetjeneste", k);*/
    }
}
/*
Hvis klienter skulle forbinde til server "javabog.dk" på port 20099 skulle der rettes til
		java.rmi.registry.LocateRegistry.createRegistry(20099); // lyt på port 20099
		KontoI k = new GalgeLogikImpl();
		System.setProperty("java.rmi.server.hostname", "javabog.dk");
		Naming.rebind("rmi://javabog.dk:20099/kontotjeneste", k);

Overfør JAR-fil til server, f.eks.:
scp /home/j/prog1/oop-projekt/dist/oop-projekt.jar javabog.dk:

Log ind på server, f.eks.:
ssh javabog.dk

Start med f.eks.:
java -cp oop-projekt.jar kapitel_19.GalgeLogikServer

I stedet for System.setProperty("java.rmi.server.hostname", "javabog.dk");
kunne du også starte serverprogrammet med:
java -Djava.rmi.server.hostname=javabog.dk -cp oop-projekt.jar kapitel_19.GalgeLogikServer


*/
