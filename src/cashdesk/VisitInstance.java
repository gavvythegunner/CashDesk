/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashdesk;

import java.util.Date;

/**
 *
 * @author gavin
 */
class VisitInstance 
{
    private Date visit;
    private int id;
    private int cashin;
    private int cashout;

    VisitInstance(Date d,int _id, int bi, int co) {
        visit = d;
        id = _id;
        cashin = bi;
        cashout = co;
    }

    public Date getVisit() {
        return visit;
    }

    public void setVisit(Date visit) {
        this.visit = visit;
    }

    public int getCashin() {
        return cashin;
    }

    public void setCashin(int cashin) {
        this.cashin = cashin;
    }

    public int getCashout() {
        return cashout;
    }

    public void setCashout(int cahout) {
        this.cashout = cahout;
    }
    
    
}
