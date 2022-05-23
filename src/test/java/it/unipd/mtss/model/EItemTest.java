////////////////////////////////////////////////////////////////////
// [Manuele] [Bonato] [1201121]
// [Pietro] [Valdagno] [2000561]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EItemTest {


    private EItem generateEItem(){
        return new EItem(itemType.processor,"intel",10);
    }

    @Test
    public void getTipo() {
        assertTrue(generateEItem().getTipo()==itemType.processor);
        assertFalse(generateEItem().getTipo()==itemType.motherboard);
    }

    @Test
    public void getName() {
        assertTrue(generateEItem().getName()=="intel");
        assertFalse(generateEItem().getName()=="amd");
    }

    @Test
    public void getPrice() {
        assertTrue(generateEItem().getPrice()==10);
        assertFalse(generateEItem().getPrice()==20);
    }

    @Test
    public void setTipo() {
        EItem item=generateEItem();
        item.setTipo(itemType.motherboard);
        assertFalse(item.getTipo()==itemType.processor);
        assertTrue(item.getTipo()==itemType.motherboard);
    }

    @Test
    public void setName() {
        EItem item=generateEItem();
        item.setName("amd");
        assertFalse(item.getName()=="intel");
        assertTrue(item.getName()=="amd");
    }

    @Test
    public void setPrice() {
        EItem item=generateEItem();
        item.setPrice(20);
        assertFalse(item.getPrice()==10);
        assertTrue(item.getPrice()==20);
    }


}