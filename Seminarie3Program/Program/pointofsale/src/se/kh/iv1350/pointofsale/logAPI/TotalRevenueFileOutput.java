package se.kh.iv1350.pointofsale.logAPI;

import se.kh.iv1350.pointofsale.integration.observer.Observer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is the class that writes out the total revenue to the text file
 */
public class TotalRevenueFileOutput implements Observer{

    /**
     * Writes the total revenue to the text file made
     * @param totalRevenue the current total revenue
     */

    @Override
    public void update(int totalRevenue) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("totalRevenueNew.txt"));
            writer.write("total Revenue " + totalRevenue);
            writer.write("\n Konungen Leif den Store" );
            writer.close();
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }
}
