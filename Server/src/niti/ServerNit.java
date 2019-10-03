/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
import podesavanja.PodesavanjaKonekcije;

/**
 *
 * @author milaz
 */
public class ServerNit extends Thread {

    private List<KlijentNit> klijenti;
    ServerSocket ss;
    boolean kraj = false;

    public ServerNit() {
        klijenti = new ArrayList<>();
    }

    @Override
    public void run() {
        int port = Integer.parseInt(PodesavanjaKonekcije.getInstanca().getProperty("port"));
        try {
            ss = new ServerSocket(port);
            Kontroler.getInstanca().getFormaServer().postaviStatus("Server je pokrenut na portu: " + port, false);
            System.out.println("Server je pokrenut");
            Socket s;
            while (!kraj) {
                s = ss.accept();
                System.out.println("Klijent se povezao");
                KlijentNit kn = new KlijentNit(s);
                klijenti.add(kn);
                kn.start();
            }
        } catch (IOException ex) {
            Kontroler.getInstanca().getFormaServer().postaviStatus("", true);
            Kontroler.getInstanca().getFormaServer().postaviStatus("Server nije pokrenut", true);
        }
    }

    public List<KlijentNit> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(List<KlijentNit> klijenti) {
        this.klijenti = klijenti;
    }

    public void zaustaviServer() {
        try {

            for (KlijentNit kn : klijenti) {
                kn.setKraj(true);
                kn.getSocket().close();
            }
            klijenti = new ArrayList<>();
            Kontroler.getInstanca().setAktivniKorisnici(new ArrayList<>());
            kraj = true;
            ss.close();
            Kontroler.getInstanca().getFormaServer().srediTabelu();
            System.out.println("Server je zaustavljen");
            Kontroler.getInstanca().getFormaServer().postaviStatus("Server nije pokrenut", true);
        } catch (IOException ex) {
            Logger.getLogger(ServerNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
