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

    public Account() {
        money = 0;
        accountName = "";
    }
}

class Credit extends Account {
    int credit = 0;
    public Credit(String tili, int raha, int luotto) {
        accountName = tili;
        money = raha;
        credit = luotto;
        System.out.println("Tili luotu.");
    }
}

class Normal extends Account {

    public Normal(String tili, int raha) {
        accountName = tili;
        money = raha;
        System.out.println("Tili luotu.");
    }
}
