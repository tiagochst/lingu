/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ra082941
 */
@Entity
@Table(name = "PgmMultilinguistico")
@NamedQueries({
    @NamedQuery(name = "PgmMultilinguistico.findAll", query = "SELECT p FROM PgmMultilinguistico p"),
    @NamedQuery(name = "PgmMultilinguistico.findById", query = "SELECT p FROM PgmMultilinguistico p WHERE p.id = :id"),
    @NamedQuery(name = "PgmMultilinguistico.findByDescricao", query = "SELECT p FROM PgmMultilinguistico p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "PgmMultilinguistico.findByLingua", query = "SELECT p FROM PgmMultilinguistico p WHERE p.lingua = :lingua")})
public class PgmMultilinguistico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "Lingua")
    private String lingua;
    @JoinTable(name = "SuportaPgmMult", joinColumns = {
        @JoinColumn(name = "IDPgmMult", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "IDUser", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;

    public PgmMultilinguistico() {
    }

    public PgmMultilinguistico(Integer id) {
        this.id = id;
    }

    public PgmMultilinguistico(Integer id, String descricao, String lingua) {
        this.id = id;
        this.descricao = descricao;
        this.lingua = lingua;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
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
        if (!(object instanceof PgmMultilinguistico)) {
            return false;
        }
        PgmMultilinguistico other = (PgmMultilinguistico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PgmMultilinguistico[id=" + id + "]";
    }

}
