package se.kh.iv1350.pointofsale.view;

import se.kh.iv1350.pointofsale.exceptions.ServerConnectionFailException;
import se.kh.iv1350.pointofsale.exceptions.ItemNotFoundException;
import se.kh.iv1350.pointofsale.controller.Controller;
import se.kh.iv1350.pointofsale.logAPI.TotalRevenueFileOutput;

/**
 * Placeholder for view, contains hardcoded execution with calls to controller for testing.
 */
public class View {

    private Controller contr;

    public View(Controller contr) {
        this.contr = contr;
        contr.attach(new TotalRevenueView(), new TotalRevenueFileOutput());
    }

}
