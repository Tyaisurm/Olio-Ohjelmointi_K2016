/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parsing;

import java.util.Date;

/**
 *
 * @author m7942
 */
public class ShowData {
    public ShowData(){
    }
    
    protected int id;
    protected Date showStart;
    protected Date showEnd;
    protected String titleFin;
    protected String titleORG;
    protected String theAndAud;
    protected int prodYear;
    protected String genres;
    
    public Date getShowStart() {
        return showStart;
    }

    public Date getShowEnd() {
        return showEnd;
    }

    public String getTitleFin() {
        return titleFin;
    }

    public String getTitleORG() {
        return titleORG;
    }

    public String getTheAndAud() {
        return theAndAud;
    }

    public int getProdYear() {
        return prodYear;
    }

    public String getGenres() {
        return genres;
    }
}
