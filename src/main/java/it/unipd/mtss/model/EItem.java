////////////////////////////////////////////////////////////////////
// [Manuele] [Bonato] [1201121]
// [Pietro] [Valdagno] [2000561]
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

public class EItem {
    public
    itemType tipo;
    String name;
    double price;

    public EItem(itemType tipo,String name, double price){
        this.tipo=tipo;
        this.name=name;
        this.price=price;
    }
    public EItem(){}

    public void setTipo(itemType tipo) {
        this.tipo = tipo;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public itemType getTipo() {
        return tipo;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

}
