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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ra082941
 */
@Entity
@Table(name = "Usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo"),
    @NamedQuery(name = "Usuario.findByPais", query = "SELECT u FROM Usuario u WHERE u.pais = :pais"),
    @NamedQuery(name = "Usuario.findByLingua", query = "SELECT u FROM Usuario u WHERE u.lingua = :lingua"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByIDRede", query = "SELECT u FROM Usuario u WHERE u.iDRede = :iDRede")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Tipo")
    private int tipo;
    @Basic(optional = false)
    @Column(name = "Pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "Lingua")
    private String lingua;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "IDRede")
    private int iDRede;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<PgmMultilinguistico> pgmMultilinguisticoCollection;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nome, int tipo, String pais, String lingua, String email, String senha, int iDRede) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.pais = pais;
        this.lingua = lingua;
        this.email = email;
        this.senha = senha;
        this.iDRede = iDRede;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIDRede() {
        return iDRede;
    }

    public void setIDRede(int iDRede) {
        this.iDRede = iDRede;
    }

    public Collection<PgmMultilinguistico> getPgmMultilinguisticoCollection() {
        return pgmMultilinguisticoCollection;
    }

    public void setPgmMultilinguisticoCollection(Collection<PgmMultilinguistico> pgmMultilinguisticoCollection) {
        this.pgmMultilinguisticoCollection = pgmMultilinguisticoCollection;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usuario[id=" + id + "]";
    }

}
