package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public interface GalgeLegI extends java.rmi.Remote {

    ArrayList<String> getBrugteBogstaver() throws java.rmi.RemoteException;

    String getSynligtOrd() throws java.rmi.RemoteException;

    String getOrdet() throws java.rmi.RemoteException;

    int getAntalForkerteBogstaver() throws java.rmi.RemoteException;

    boolean erSidsteBogstavKorrekt() throws java.rmi.RemoteException;

    boolean erSpilletVundet() throws java.rmi.RemoteException;

    boolean erSpilletTabt() throws java.rmi.RemoteException;

    boolean erSpilletSlut() throws java.rmi.RemoteException;

    void nulstil() throws java.rmi.RemoteException;

    void gætBogstav(String bogstav) throws java.rmi.RemoteException;

    void logStatus() throws java.rmi.RemoteException;

    String hentUrl(String url) throws java.rmi.RemoteException, IOException;

    void hentOrdFraDr() throws java.rmi.RemoteException, IOException;

    void hentOrdFraRegneark(String sværhedsgrader) throws java.rmi.RemoteException, IOException;
}