package Data;

/**
 * Created by bimalshah on 24/11/2015.
 */
public class Model {

    public static void calculateAllSteps(Stock stock){
        for (int i = 0; i < Stock.getSteps(); i++) {
            stock.calculateStep();
        }
    }

public static void multipleStocks(int num){
    double average = 0;

    for (int i =0; i<num;i++) {
        Stock stock = new Stock(100);

        Model.calculateAllSteps(stock);
        //System.out.println("final stock value:" +stock.stock);
        //System.out.println("Payoff:"+ stock.discountPayoff());
        average += stock.discountPayoff();
    }

    System.out.println("option price = " + average/num);
}





}
