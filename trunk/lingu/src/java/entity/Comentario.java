/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ra083632
 */
@Entity
@Table(name = "Comentario")
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findById", query = "SELECT c FROM Comentario c WHERE c.id = :id"),
    @NamedQuery(name = "Comentario.findByTexto", query = "SELECT c FROM Comentario c WHERE c.texto = :texto"),
    @NamedQuery(name = "Comentario.findByData", query = "SELECT c FROM Comentario c WHERE c.data = :data"),
    @NamedQuery(name = "Comentario.findByAutorCom", query = "SELECT c FROM Comentario c WHERE c.autorCom = :autorCom")})
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
    @Column(name = "AutorCom")
    private String autorCom;
    @JoinColumn(name = "IDUser", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Integer IdUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comentario")
    private Collection<Comentario> comentarioCollection;
    @JoinColumn(name = "IDComResp", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Integer IdComResp;
    @JoinColumn(name = "IDDoc", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Integer IdDocumento;

    public Comentario() {
    }

    public Comentario(Integer id) {
        this.id = id;
    }

    public Comentario(Integer id, String texto, Date data, String autorCom) {
        this.id = id;
        this.texto = texto;
        this.data = data;
        this.autorCom = autorCom;
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

    public String getAutorCom() {
        return autorCom;
    }

    public void setAutorCom(String autorCom) {
        this.autorCom = autorCom;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer id) {
        this.IdUsuario = id;
    }

    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

    public Integer getIdComResp() {
        return IdComResp;
    }

    public void setIdComResp(Integer id) {
        this.IdComResp = id;
    }

    public Integer getIdDocumento() {
        return IdDocumento;
    }

    public void setIdDocumento(Integer id) {
        this.IdDocumento = id;
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
