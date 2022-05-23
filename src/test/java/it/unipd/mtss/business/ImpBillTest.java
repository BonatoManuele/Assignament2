////////////////////////////////////////////////////////////////////
// [Manuele] [Bonato] [1201121]
// [Pietro] [Valdagno] [2000561]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.Ordine;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.itemType;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ImpBillTest {

    @Test
    public void totale() throws BillException {
        Bill test=new ImpBill();
        List<EItem> itemsOrdered=new ArrayList<EItem>();
        for (int i=0;i<20;i++){
            itemsOrdered.add(new EItem(itemType.motherboard,"msi",1));
        }
        User user=new User();
        assertTrue(test.getOrderPrice(itemsOrdered,user)==20);
    }

    @Test
    public void scontoImporto() throws BillException {
        Bill test=new ImpBill();
        List<EItem> itemsOrdered=new ArrayList<EItem>();
        itemsOrdered.add(new EItem(itemType.processor,"i20",2000));
        User user=new User();
        Assert.assertTrue(test.getOrderPrice(itemsOrdered,user)==1800);
    }

    @Test
    public void comissione() throws BillException {
        Bill test=new ImpBill();
        List<EItem> itemsOrdered=new ArrayList<EItem>();
        itemsOrdered.add(new EItem(itemType.processor,"",2));
        User user=new User();
        Assert.assertTrue(test.getOrderPrice(itemsOrdered,user)==4);
    }

    @Test
    public void scontoProc() throws BillException {
        Bill test=new ImpBill();
        List<EItem> itemsOrdered=new ArrayList<EItem>();
        itemsOrdered.add(new EItem(itemType.processor,"intel1",100));
        itemsOrdered.add(new EItem(itemType.processor,"intel2",100));
        itemsOrdered.add(new EItem(itemType.processor,"intel8",200));
        itemsOrdered.add(new EItem(itemType.processor,"intel",300));
        itemsOrdered.add(new EItem(itemType.processor,"intel",50));
        User user=new User();
        Assert.assertTrue(test.getOrderPrice(itemsOrdered,user)==750);
        itemsOrdered.add(new EItem(itemType.processor,"intel8",200));
        Assert.assertTrue(test.getOrderPrice(itemsOrdered,user)==925);
    }

    @Test
    public void mouseGift() throws BillException {
        Bill test=new ImpBill();
        List<EItem> itemsOrdered=new ArrayList<EItem>();
        for (int i=0;i<9;i++){
            itemsOrdered.add(new EItem(itemType.mouse,"trust",2));
        }
        itemsOrdered.add(new EItem(itemType.mouse,"trust",1));
        itemsOrdered.add(new EItem(itemType.mouse,"trust",3));
        User user=new User();
        Assert.assertTrue(test.getOrderPrice(itemsOrdered,user)==21);
    }

    @Test
    public void mouseOrKeyboardGift() throws BillException {
        Bill test=new ImpBill();
        List<EItem> itemsOrdered=new ArrayList<EItem>();
        for (int i=0;i<3;i++){
            itemsOrdered.add(new EItem(itemType.mouse,"trust",2));
            itemsOrdered.add(new EItem(itemType.keyboard,"trust",3));
        }
        User user=new User();
        Assert.assertTrue(test.getOrderPrice(itemsOrdered,user)==13);
        itemsOrdered.add(new EItem(itemType.mouse,"trust",2));
        Assert.assertTrue(test.getOrderPrice(itemsOrdered,user)==17);
    }

    @Test(expected = BillException.class)
    public void limiteCarello() throws BillException {
        Bill test=new ImpBill();
        List<EItem> itemsOrdered=new ArrayList<EItem>();
        for (int i=0;i<31;i++){
            itemsOrdered.add(new EItem(itemType.motherboard,"asus",1));
        }
        User user=new User();
        test.getOrderPrice(itemsOrdered,user);
        Assert.fail();
    }


    @Test
    public void orderCanBeFree() {
        Bill test=new ImpBill();
        List<Ordine> ordini=new ArrayList<>();
        ordini.add(new Ordine(new ArrayList<EItem>(),new User(1,"", LocalDate.of(2000,1,1)), LocalTime.of(18,30,0),0));
        assertTrue(test.ordiniGratis(ordini).size()==0);
        ordini.add(new Ordine(new ArrayList<EItem>(),new User(2,"",LocalDate.now()), LocalTime.of(18,30,0),0));
        assertTrue(test.ordiniGratis(ordini).size()==1);
        ordini.add(new Ordine(new ArrayList<EItem>(),new User(1,"", LocalDate.of(2000,1,1)), LocalTime.of(19,30,0),0));
        assertTrue(test.ordiniGratis(ordini).size()==1);
    }

    @Test
    public void ordiniGratis() {
        Bill test=new ImpBill();
        List<Ordine> ordini=new ArrayList<>();
        for (int i=0;i<15;i++){
            ordini.add(new Ordine(new ArrayList<EItem>(),new User(2,"",LocalDate.now()), LocalTime.of(18,30,0),0));
        }
        assertTrue(test.ordiniGratis(ordini).size()==10);

    }

}