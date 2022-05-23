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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ImpBill implements Bill{

    private static boolean isType(EItem item, itemType type){
        return item.getTipo()==type;
    }
    private static int countType(List<EItem> articoli, itemType type){
        int count=0;
        for(int i=0;i<articoli.size();i++) {
            if (articoli.get(i).getTipo() == type) {
                count++;
            }
        }
        return count;
    }
    public static double comissione(double costo){
        if (costo<10){
            return 2;
        }
        return 0;
    }
    private static boolean carrelloTroppoPieno(List<EItem> articoli) throws BillException {
        if (articoli.size()>30){
            //da sistemare
            throw new BillException("ordine annullato carrello troppo pieno (max 30 articoli)");
        }
        return false;
    }
    private static double scontImporto(double costo){
        if (costo>1000){
            return costo/10;
        }
        return 0;
    }
    private static double mouseOrKeybordGift(List<EItem> articoli){
        if (countType(articoli, itemType.mouse)== countType(articoli, itemType.keyboard) && countType(articoli, itemType.mouse)!=0){
            double min=-1;
            for(int i=0;i<articoli.size();i++){
                if((isType(articoli.get(i),itemType.mouse)|| isType(articoli.get(i),itemType.keyboard)) && (min==-1 || articoli.get(i).getPrice()<min)){
                    min=articoli.get(i).getPrice();
                }
            }
            return min;
        }
        return 0;
    }
    private static double mouseGift(List<EItem> articoli){
        if (countType(articoli, itemType.mouse)>10){
            double min=-1;
            for(int i=0;i<articoli.size();i++){
                if(isType(articoli.get(i),itemType.mouse) && (min==-1 || articoli.get(i).getPrice()<min)){
                    min=articoli.get(i).getPrice();
                }
            }
            return min;
        }
        return 0;
    }
    private static double scontoProc(List<EItem> articoli){
        if (countType(articoli, itemType.processor)>5){
            double min=-1;
            for(int i=0;i<articoli.size();i++){
                if(isType(articoli.get(i),itemType.processor) && (min==-1 || articoli.get(i).getPrice()<min)){
                    min=articoli.get(i).getPrice();
                }
            }
            return min/2;
        }
        return 0;
    }
    private static double calcolaTotale(List<EItem> articoli){
        double tot=0;
        for(int i=0;i<articoli.size();i++){
            tot=tot+articoli.get(i).getPrice();
        }
        return tot;
    }

    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user) throws BillException {
        if (!carrelloTroppoPieno(itemsOrdered)) {
            double costo = calcolaTotale(itemsOrdered) - scontoProc(itemsOrdered) - mouseGift(itemsOrdered) - mouseOrKeybordGift(itemsOrdered);
            costo = costo - scontImporto(costo);
            costo = costo + comissione(costo);
            return costo;
        }
        return 0;
    }

    private boolean orderCanBeFree(Ordine ordine){
        if (ordine.getUser().getAge() < 18 && ordine.getOrarioOrdine().getHour() == 18) {
            return true;
        }
        return false;
    }
    public List<Ordine> ordiniGratis(List<Ordine> ordini){
        List<Ordine> ordinigratis= new ArrayList<Ordine>();
        for (int i = 0; i < ordini.size(); i++) {
            if (orderCanBeFree(ordini.get(i))){
                ordinigratis.add(ordini.get(i));
            }
        }
        while(ordinigratis.size()>10){
            ordinigratis.remove(new Random().nextInt(ordinigratis.size()));
        }
        return ordinigratis;
    }
}
