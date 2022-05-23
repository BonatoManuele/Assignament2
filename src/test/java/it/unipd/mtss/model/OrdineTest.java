////////////////////////////////////////////////////////////////////
// [Manuele] [Bonato] [1201121]
// [Pietro] [Valdagno] [2000561]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrdineTest {

    List<EItem> list=new ArrayList<EItem>();
    User user=new User(1,"", LocalDate.now());

    private Ordine generateOrdine(){
        if (list.isEmpty())
            list.add(new EItem());
        return new Ordine(list,user, LocalTime.MIN,100);
    }


    @Test
    public void getTot() {
        assertFalse(generateOrdine().getTot()==10);
        assertTrue(generateOrdine().getTot()==100);
    }

    @Test
    public void getOrarioOrdine() {
        assertFalse(generateOrdine().getOrarioOrdine()==LocalTime.MAX);
        assertTrue(generateOrdine().getOrarioOrdine()==LocalTime.MIN);
    }

    @Test
    public void getUser() {
        assertTrue(generateOrdine().getUser()==user);
        assertFalse(generateOrdine().getUser()== new User());
    }

    @Test
    public void getListaElementi() {
        assertTrue(generateOrdine().getListaElementi()==list);
        assertFalse(generateOrdine().getListaElementi()== new ArrayList<EItem>());

    }

    @Test
    public void setTot() {
        Ordine ordine=generateOrdine();
        ordine.setTot(20);
        assertFalse(ordine.getTot()==10);
        assertTrue(ordine.getTot()==20);
    }

    @Test
    public void setOrarioOrdine() {
        Ordine ordine=generateOrdine();
        ordine.setOrarioOrdine(LocalTime.MAX);
        assertTrue(ordine.getOrarioOrdine()==LocalTime.MAX);
        assertFalse(ordine.getOrarioOrdine()==LocalTime.MIN);
    }

    @Test
    public void setListaElementi() {
        Ordine ordine=generateOrdine();
        List<EItem> list1=new ArrayList<>();
        ordine.setListaElementi(list1);
        assertTrue(ordine.getListaElementi()==list1);
        assertFalse(ordine.getListaElementi()== list);
    }

    @Test
    public void setUtente() {
        Ordine ordine=generateOrdine();
        User user1=new User();
        ordine.setUtente(user1);
        assertTrue(ordine.getUser()==user1);
        assertFalse(ordine.getUser()==user);
    }
}