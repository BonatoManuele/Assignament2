////////////////////////////////////////////////////////////////////
// [Manuele] [Bonato] [1201121]
// [Pietro] [Valdagno] [2000561]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    LocalDate date=LocalDate.of(2005,11,16);
    private User generateUser(){
        return new User(1,"pino",date);
    }

    @Test
    public void getId() {
        assertTrue(generateUser().getId()==1);
        assertFalse(generateUser().getId()==2);
    }

    @Test
    public void getName() {
        assertTrue(generateUser().getName()=="pino");
        assertFalse(generateUser().getName()=="pina");
    }

    @Test
    public void getNascita() {
        assertTrue(generateUser().getNascita()==date);
        assertFalse(generateUser().getNascita()==LocalDate.of(1,1,1));
    }

    @Test
    public void setId() {
        User user= generateUser();
        user.setName("amd");
        assertFalse(user.getName()=="intel");
        assertTrue(user.getName()=="amd");

    }

    @Test
    public void setName() {
        User user= generateUser();
        user.setName("pina");
        assertFalse(user.getName()=="pino");
        assertTrue(user.getName()=="pina");

    }

    @Test
    public void setNascita() {
        User user=generateUser();
        LocalDate date1=LocalDate.of(1,1,1);
        user.setNascita(date1);
        assertTrue(user.getNascita()==date1);
        assertFalse(user.getNascita()== date);
    }

}