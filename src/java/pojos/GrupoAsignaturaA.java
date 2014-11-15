/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abc
 */
@Entity
@Table(name = "grupo_asignatura_a")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoAsignaturaA.findAll", query = "SELECT g FROM GrupoAsignaturaA g"),
    @NamedQuery(name = "GrupoAsignaturaA.findByIdequivalencia", query = "SELECT g FROM GrupoAsignaturaA g WHERE g.idequivalencia = :idequivalencia")})
public class GrupoAsignaturaA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idequivalencia")
    private Integer idequivalencia;
    @JoinColumn(name = "idequivalencia", referencedColumnName = "idequivalencia", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Equivalencia equivalencia;
    @OneToMany(mappedBy = "idGrupoAsignaturaA", fetch = FetchType.LAZY)
    private Set<MiembroGrupoAsignaturaA> miembroGrupoAsignaturaASet;

    public GrupoAsignaturaA() {
    }

    public GrupoAsignaturaA(Integer idequivalencia) {
        this.idequivalencia = idequivalencia;
    }

    public Integer getIdequivalencia() {
        return idequivalencia;
    }

    public void setIdequivalencia(Integer idequivalencia) {
        this.idequivalencia = idequivalencia;
    }

    public Equivalencia getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(Equivalencia equivalencia) {
        this.equivalencia = equivalencia;
    }

    @XmlTransient
    public Set<MiembroGrupoAsignaturaA> getMiembroGrupoAsignaturaASet() {
        return miembroGrupoAsignaturaASet;
    }

    public void setMiembroGrupoAsignaturaASet(Set<MiembroGrupoAsignaturaA> miembroGrupoAsignaturaASet) {
        this.miembroGrupoAsignaturaASet = miembroGrupoAsignaturaASet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequivalencia != null ? idequivalencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoAsignaturaA)) {
            return false;
        }
        GrupoAsignaturaA other = (GrupoAsignaturaA) object;
        if ((this.idequivalencia == null && other.idequivalencia != null) || (this.idequivalencia != null && !this.idequivalencia.equals(other.idequivalencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.GrupoAsignaturaA[ idequivalencia=" + idequivalencia + " ]";
    }
    
}
