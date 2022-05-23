////////////////////////////////////////////////////////////////////
// [Manuele] [Bonato] [1201121]
// [Pietro] [Valdagno] [2000561]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;
import java.time.LocalDate;
import java.util.Date;

public class User {

    public User(){}
    public User(int id, String name, LocalDate nascita){
        this.id=id;
        this.name=name;
        this.nascita=nascita;
    }
    int id;
    String name;
    LocalDate nascita;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDate getNascita() {
        return nascita;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNascita(LocalDate nascita) {
        this.nascita = nascita;
    }
    public int getAge() {
        int anni=LocalDate.now().getYear()-nascita.getYear();
        int mesi=LocalDate.now().getMonthValue()-nascita.getMonthValue();
        int giorni=LocalDate.now().getDayOfMonth()-nascita.getDayOfMonth();
        if(mesi>0){
            return anni;
        }
        if (mesi<0){
            return anni-1;
        }
        if(mesi==0 && giorni>=0){
            return anni;
        }
        else{
            return anni-1;
        }
    }
}
