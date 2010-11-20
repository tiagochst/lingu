/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "Documento")
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findById", query = "SELECT d FROM Documento d WHERE d.id = :id"),
    @NamedQuery(name = "Documento.findByTitulo", query = "SELECT d FROM Documento d WHERE d.titulo = :titulo"),
    @NamedQuery(name = "Documento.findByTipo", query = "SELECT d FROM Documento d WHERE d.tipo = :tipo"),
    @NamedQuery(name = "Documento.findByAssunto", query = "SELECT d FROM Documento d WHERE d.assunto = :assunto"),
    @NamedQuery(name = "Documento.findByLinguaDescricao", query = "SELECT d FROM Documento d WHERE d.linguaDescricao = :linguaDescricao"),
    @NamedQuery(name = "Documento.findByPais", query = "SELECT d FROM Documento d WHERE d.pais = :pais"),
    @NamedQuery(name = "Documento.findByNumAcessos", query = "SELECT d FROM Documento d WHERE d.numAcessos = :numAcessos"),
    @NamedQuery(name = "Documento.findByLinguaOficial", query = "SELECT d FROM Documento d WHERE d.linguaOficial = :linguaOficial"),
    @NamedQuery(name = "Documento.findByLinguaUtilizador", query = "SELECT d FROM Documento d WHERE d.linguaUtilizador = :linguaUtilizador"),
    @NamedQuery(name = "Documento.findByPalavrasChaves", query = "SELECT d FROM Documento d WHERE d.palavrasChaves = :palavrasChaves"),
    @NamedQuery(name = "Documento.findByLinguaPalavrasChaves", query = "SELECT d FROM Documento d WHERE d.linguaPalavrasChaves = :linguaPalavrasChaves"),
    @NamedQuery(name = "Documento.findBySo", query = "SELECT d FROM Documento d WHERE d.so = :so"),
    @NamedQuery(name = "Documento.findByIp", query = "SELECT d FROM Documento d WHERE d.ip = :ip"),
    @NamedQuery(name = "Documento.findByNavegador", query = "SELECT d FROM Documento d WHERE d.navegador = :navegador"),
    @NamedQuery(name = "Documento.findByDataInsercao", query = "SELECT d FROM Documento d WHERE d.dataInsercao = :dataInsercao"),
    @NamedQuery(name = "Documento.findByLocal", query = "SELECT d FROM Documento d WHERE d.local = :local"),
    @NamedQuery(name = "Documento.findByExtensao", query = "SELECT d FROM Documento d WHERE d.extensao = :extensao")})
public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "Tipo")
    private int tipo;
    @Column(name = "Assunto")
    private String assunto;
    @Lob
    @Column(name = "Descricao")
    private String descricao;
    @Column(name = "LinguaDescricao")
    private String linguaDescricao;
    @Column(name = "Pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "NumAcessos")
    private int numAcessos;
    @Column(name = "LinguaOficial")
    private String linguaOficial;
    @Column(name = "LinguaUtilizador")
    private String linguaUtilizador;
    @Column(name = "PalavrasChaves")
    private String palavrasChaves;
    @Column(name = "LinguaPalavrasChaves")
    private String linguaPalavrasChaves;
    @Basic(optional = false)
    @Column(name = "SO")
    private String so;
    @Basic(optional = false)
    @Column(name = "IP")
    private String ip;
    @Basic(optional = false)
    @Column(name = "Navegador")
    private String navegador;
    @Basic(optional = false)
    @Column(name = "DataInsercao")
    @Temporal(TemporalType.DATE)
    private Date dataInsercao;
    @Column(name = "Local")
    private String local;
    @Basic(optional = false)
    @Column(name = "Extensao")
    private String extensao;
    @JoinTable(name = "DocResposta", joinColumns = {
        @JoinColumn(name = "IDDoc2", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "IDDoc1", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Documento> documentoCollection;
    @ManyToMany(mappedBy = "documentoCollection")
    private Collection<Documento> documentoCollection1;

    public Documento() {
    }

    public Documento(Integer id) {
        this.id = id;
    }

    public Documento(Integer id, String titulo, int tipo, int numAcessos, String so, String ip, String navegador, Date dataInsercao, String extensao) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.numAcessos = numAcessos;
        this.so = so;
        this.ip = ip;
        this.navegador = navegador;
        this.dataInsercao = dataInsercao;
        this.extensao = extensao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinguaDescricao() {
        return linguaDescricao;
    }

    public void setLinguaDescricao(String linguaDescricao) {
        this.linguaDescricao = linguaDescricao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNumAcessos() {
        return numAcessos;
    }

    public void setNumAcessos(int numAcessos) {
        this.numAcessos = numAcessos;
    }

    public String getLinguaOficial() {
        return linguaOficial;
    }

    public void setLinguaOficial(String linguaOficial) {
        this.linguaOficial = linguaOficial;
    }

    public String getLinguaUtilizador() {
        return linguaUtilizador;
    }

    public void setLinguaUtilizador(String linguaUtilizador) {
        this.linguaUtilizador = linguaUtilizador;
    }

    public String getPalavrasChaves() {
        return palavrasChaves;
    }

    public void setPalavrasChaves(String palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    public String getLinguaPalavrasChaves() {
        return linguaPalavrasChaves;
    }

    public void setLinguaPalavrasChaves(String linguaPalavrasChaves) {
        this.linguaPalavrasChaves = linguaPalavrasChaves;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    public Collection<Documento> getDocumentoCollection1() {
        return documentoCollection1;
    }

    public void setDocumentoCollection1(Collection<Documento> documentoCollection1) {
        this.documentoCollection1 = documentoCollection1;
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
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.Documento[id=" + id + "]";
    }

}
