/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ra082941
 */
@Entity
@Table(name = "RedeDeTrabalho")
@NamedQueries({
    @NamedQuery(name = "RedeDeTrabalho.findAll", query = "SELECT r FROM RedeDeTrabalho r"),
    @NamedQuery(name = "RedeDeTrabalho.findById", query = "SELECT r FROM RedeDeTrabalho r WHERE r.id = :id"),
    @NamedQuery(name = "RedeDeTrabalho.findByNome", query = "SELECT r FROM RedeDeTrabalho r WHERE r.nome = :nome"),
    @NamedQuery(name = "RedeDeTrabalho.findByEmail", query = "SELECT r FROM RedeDeTrabalho r WHERE r.email = :email"),
    @NamedQuery(name = "RedeDeTrabalho.findByUrl", query = "SELECT r FROM RedeDeTrabalho r WHERE r.url = :url")})
public class RedeDeTrabalho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Email")
    private String email;
    @Column(name = "URL")
    private String url;

    public RedeDeTrabalho() {
    }

    public RedeDeTrabalho(Integer id) {
        this.id = id;
    }

    public RedeDeTrabalho(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof RedeDeTrabalho)) {
            return false;
        }
        RedeDeTrabalho other = (RedeDeTrabalho) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RedeDeTrabalho[id=" + id + "]";
    }

}
