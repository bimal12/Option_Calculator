package Data;

/**
 * Created by bimalshah on 24/11/2015.
 */
public class Calculate {

    public static void main(String[] args) {

        long startTime = System.nanoTime();


        Stock.interest = 0.05;
        Stock.strike = 100;
        Stock.setTimePeriod(1);
        Stock.setSteps(252);
        Stock.sigma = 0.2;
        Stock.setDt();

        Model.multipleStocks(5000);
        Model.multipleStocks(5000);
        Model.multipleStocks(5000);
        Model.multipleStocks(5000);


        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Duration of code is: " + duration/1000000. + "ms");

    }


}
