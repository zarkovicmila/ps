/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Odgovor;
import transfer.Zahtev;

/**
 *
 * @author milaz
 */
public class KomSaKlijentom {

    public static KomSaKlijentom instanca;

    private KomSaKlijentom() {
    }

    public static KomSaKlijentom getInstanca() {
        if (instanca == null) {
            instanca = new KomSaKlijentom();
        }
        return instanca;
    }
    public void posaljiOdgovor(Odgovor o, Socket s){
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(o);
        } catch (IOException ex) {
            Logger.getLogger(KomSaKlijentom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Zahtev primiZahtev(Socket s){
        Zahtev z = new Zahtev();
        try {
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            z = (Zahtev) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(KomSaKlijentom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KomSaKlijentom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return z;
    }
}
