/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashdesk;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gavin
 */
@Entity
@Table(name = "visit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v")
    , @NamedQuery(name = "Visit.findByIdVisit", query = "SELECT v FROM Visit v WHERE v.visitPK.idVisit = :idVisit")
    , @NamedQuery(name = "Visit.findByVisitorIdLatest", query = "SELECT v FROM Visit v WHERE v.visitPK.visitorId = :visitorId order by v.visitPK.idVisit desc")
    , @NamedQuery(name = "Visit.findByVisitorId", query = "SELECT v FROM Visit v WHERE v.visitPK.visitorId = :visitorId")
    , @NamedQuery(name = "Visit.findByVisitBuyin", query = "SELECT v FROM Visit v WHERE v.visitBuyin = :visitBuyin")
    , @NamedQuery(name = "Visit.findByVisitCashout", query = "SELECT v FROM Visit v WHERE v.visitCashout = :visitCashout")
    , @NamedQuery(name = "Visit.findByVisitComment", query = "SELECT v FROM Visit v WHERE v.visitComment = :visitComment")
    , @NamedQuery(name = "Visit.findByVisitLogout", query = "SELECT v FROM Visit v WHERE v.visitLogout = :visitLogout")
    , @NamedQuery(name = "Visit.findByVisitCreditcard", query = "SELECT v FROM Visit v WHERE v.visitCreditcard = :visitCreditcard")})
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VisitPK visitPK;
    @Column(name = "visit_buyin")
    private Integer visitBuyin;
    @Column(name = "visit_cashout")
    private Integer visitCashout;
    @Column(name = "visit_comment")
    private String visitComment;
    @Column(name = "visit_logout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitLogout;
    @Column(name = "visit_creditcard")
    private Integer visitCreditcard;

    public Visit() {
    }

    public Visit(VisitPK visitPK) {
        this.visitPK = visitPK;
    }

    public Visit(Date idVisit, int visitorId) {
        this.visitPK = new VisitPK(idVisit, visitorId);
    }

    public VisitPK getVisitPK() {
        return visitPK;
    }

    public void setVisitPK(VisitPK visitPK) {
        this.visitPK = visitPK;
    }

    public Integer getVisitBuyin() {
        return visitBuyin;
    }

    public void setVisitBuyin(Integer visitBuyin) {
        this.visitBuyin = visitBuyin;
    }

    public Integer getVisitCashout() {
        return visitCashout;
    }

    public void setVisitCashout(Integer visitCashout) {
        this.visitCashout = visitCashout;
    }

    public String getVisitComment() {
        return visitComment;
    }

    public void setVisitComment(String visitComment) {
        this.visitComment = visitComment;
    }

    public Date getVisitLogout() {
        return visitLogout;
    }

    public void setVisitLogout(Date visitLogout) {
        this.visitLogout = visitLogout;
    }

    public Integer getVisitCreditcard() {
        return visitCreditcard;
    }

    public void setVisitCreditcard(Integer visitCreditcard) {
        this.visitCreditcard = visitCreditcard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitPK != null ? visitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visit)) {
            return false;
        }
        Visit other = (Visit) object;
        if ((this.visitPK == null && other.visitPK != null) || (this.visitPK != null && !this.visitPK.equals(other.visitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cashdesk.Visit[ visitPK=" + visitPK + " ]";
    }
    
}
