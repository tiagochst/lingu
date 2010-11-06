/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ra082941
 */
@Entity
@Table(name = "Comentario")
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findById", query = "SELECT c FROM Comentario c WHERE c.id = :id"),
    @NamedQuery(name = "Comentario.findByTexto", query = "SELECT c FROM Comentario c WHERE c.texto = :texto"),
    @NamedQuery(name = "Comentario.findByData", query = "SELECT c FROM Comentario c WHERE c.data = :data"),
    @NamedQuery(name = "Comentario.findByIDDoc", query = "SELECT c FROM Comentario c WHERE c.iDDoc = :iDDoc"),
    @NamedQuery(name = "Comentario.findByIDComResp", query = "SELECT c FROM Comentario c WHERE c.iDComResp = :iDComResp"),
    @NamedQuery(name = "Comentario.findByIDUser", query = "SELECT c FROM Comentario c WHERE c.iDUser = :iDUser")})
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Texto")
    private String texto;
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "IDDoc")
    private int iDDoc;
    @Basic(optional = false)
    @Column(name = "IDComResp")
    private int iDComResp;
    @Basic(optional = false)
    @Column(name = "IDUser")
    private int iDUser;

    public Comentario() {
    }

    public Comentario(Integer id) {
        this.id = id;
    }

    public Comentario(Integer id, String texto, Date data, int iDDoc, int iDComResp, int iDUser) {
        this.id = id;
        this.texto = texto;
        this.data = data;
        this.iDDoc = iDDoc;
        this.iDComResp = iDComResp;
        this.iDUser = iDUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIDDoc() {
        return iDDoc;
    }

    public void setIDDoc(int iDDoc) {
        this.iDDoc = iDDoc;
    }

    public int getIDComResp() {
        return iDComResp;
    }

    public void setIDComResp(int iDComResp) {
        this.iDComResp = iDComResp;
    }

    public int getIDUser() {
        return iDUser;
    }

    public void setIDUser(int iDUser) {
        this.iDUser = iDUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Comentario[id=" + id + "]";
    }

}
