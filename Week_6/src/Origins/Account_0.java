/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Origins;

/**
 *
 * @author m7942
 */
public abstract class Account_0 {

    protected int money;
    protected String accountName;
    protected int credit;
    protected String accountType;

    public Account_0() {
        money = 0;
        credit = 0;
        accountName = "";
    }
}

class Credit extends Account_0 {
    //int credit = 0;
    public Credit(String tili, int raha, int luotto) {
        accountType = "credit";
        accountName = tili;
        money = raha;
        //credit = luotto;
        System.out.println("Tili luotu.");
    }
}

class Normal extends Account_0 {

    public Normal(String tili, int raha) {
        accountType = "normal";
        accountName = tili;
        money = raha;
        System.out.println("Tili luotu.");
    }
}
