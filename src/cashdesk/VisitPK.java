/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashdesk;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gavin
 */
@Embeddable
public class VisitPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idVisit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date idVisit;
    @Basic(optional = false)
    @Column(name = "visitor_id")
    private int visitorId;

    public VisitPK() {
    }

    public VisitPK(Date idVisit, int visitorId) {
        this.idVisit = idVisit;
        this.visitorId = visitorId;
    }

    public Date getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(Date idVisit) {
        this.idVisit = idVisit;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisit != null ? idVisit.hashCode() : 0);
        hash += (int) visitorId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitPK)) {
            return false;
        }
        VisitPK other = (VisitPK) object;
        if ((this.idVisit == null && other.idVisit != null) || (this.idVisit != null && !this.idVisit.equals(other.idVisit))) {
            return false;
        }
        if (this.visitorId != other.visitorId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cashdesk.VisitPK[ idVisit=" + idVisit + ", visitorId=" + visitorId + " ]";
    }
    
}
