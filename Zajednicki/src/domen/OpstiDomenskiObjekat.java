 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author milaz
 */
public interface OpstiDomenskiObjekat extends Serializable{

    String vratiVrednostiAtributa();

    String postaviVrednostiAtributa();

    String vratiImeKlase();

    String vratiUslovZaJednog();

    default String vratiUslovZaVise() { return ""; };

    OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception;
    
    String vratiNazivKolone(int kolona);
    
    ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception;
    
    default String vratiSpajanje() { return ""; }
    
    default String vratiSortiranje() { return ""; }
    
    default String selektuj() { return "*"; }
   
}
