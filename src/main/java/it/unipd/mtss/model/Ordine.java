////////////////////////////////////////////////////////////////////
// [Manuele] [Bonato] [1201121]
// [Pietro] [Valdagno] [2000561]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.util.List;
import java.time.LocalTime;

public class Ordine {
    List<EItem> listaElementi;
    User utente;
    LocalTime orarioOrdine;
    double tot;

    public Ordine(){}
    public Ordine(List<EItem> listaElementi, User utente, LocalTime orarioOrdine, double price) {
        this.listaElementi = listaElementi;
        this.utente = utente;
        this.orarioOrdine = orarioOrdine;
        this.tot = price;
    }
    public double getTot() {
        return tot;
    }
    public LocalTime getOrarioOrdine() {
        return orarioOrdine;
    }
    public User getUser() {
        return utente;
    }
    public List<EItem> getListaElementi(){
        return listaElementi;
    }
    public void setTot(double tot) {
        this.tot = tot;
    }
    public void setOrarioOrdine(LocalTime orarioOrdine) {
        this.orarioOrdine = orarioOrdine;
    }
    public void setListaElementi(List<EItem> listaElementi) {
        this.listaElementi = listaElementi;
    }
    public void setUtente(User utente) {
        this.utente = utente;
    }
}

