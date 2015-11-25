package Data;

import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.Random;

/**
 * Created by bimalshah on 24/11/2015.
 */
public class Stock {
    private static double timePeriod;
    private static int steps;
    public static double sigma;
    public static double interest;
    public static double dt;
    public double time = 0;
    public double stock;
    public static double strike;
    private static Random rand = new Random();
    private static NormalDistribution norm = new NormalDistribution();
    private static double rootdt;

    public static void setTimePeriod(double timePeriod) {
        Stock.timePeriod = timePeriod;
    }

    public static void setSteps(int steps) {
        Stock.steps = steps;
    }

    public static void setDt() {
        Stock.dt = timePeriod/steps;
        Stock.rootdt = Math.sqrt(dt);
    }

    public Stock(double stock) {
        this.stock = stock;
    }

    public static int getSteps() {
        return steps;
    }

    //=previousstock*(1+IR*dt+sigma*SQRT(dt)*NORMSINV(RAND()))
    public void calculateStep(){
        double prob = norm.inverseCumulativeProbability(rand.nextDouble());
        double calc = (1+interest*dt+sigma*Math.sqrt(dt)*prob);
        //update stock value
        this.stock = stock*calc;

    }

    public double payoff(){
        return Math.max(stock-strike,0);
    }

    public double discountPayoff(){
        return payoff() * Math.exp(-interest*timePeriod);
    }
}
