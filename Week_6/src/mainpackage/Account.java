/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author m7942
 */
public abstract class Account {

    protected int money;
    protected String accountName;
    protected int credit;
    protected String accountType;

    public Account() {
        money = 0;
        credit = 0;
        accountName = "";
    }
}

class Credit extends Account {

    public Credit(String tili, int raha, int luotto) {
        accountType = "credit";
        accountName = tili;
        money = raha;
        credit = luotto;
        System.out.println("Tili luotu.");
    }
}

class Normal extends Account {

    public Normal(String tili, int raha) {
        accountType = "normal";
        accountName = tili;
        money = raha;
        System.out.println("Tili luotu.");
    }
}
