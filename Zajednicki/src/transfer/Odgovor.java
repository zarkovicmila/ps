/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import konstante.StatusOdgovora;
import java.io.Serializable;

/**
 *
 * @author milaz
 */
public class Odgovor implements Serializable {
    private StatusOdgovora status;
    private Object podaci;
    private Object greska;

    public Odgovor() {
    }

    public Odgovor(StatusOdgovora status, Object podaci, Object greska) {
        this.status = status;
        this.podaci = podaci;
        this.greska = greska;
    }

    public Object getGreska() {
        return greska;
    }

    public void setGreska(Object greska) {
        this.greska = greska;
    }

    public StatusOdgovora getStatus() {
        return status;
    }

    public void setStatus(StatusOdgovora status) {
        this.status = status;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }
    
    
}
