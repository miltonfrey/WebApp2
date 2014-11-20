/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author abc
 */
@Embeddable
public class AsignaturaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codAsignatura")
    private int codAsignatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreUniversidad")
    private String nombreUniversidad;

    public AsignaturaPK() {
    }

    public AsignaturaPK(int codAsignatura, String nombreUniversidad) {
        this.codAsignatura = codAsignatura;
        this.nombreUniversidad = nombreUniversidad;
    }

    public int getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AsignaturaPK) ) return false;
		 AsignaturaPK castOther = ( AsignaturaPK ) other; 
         
		 return (this.getCodAsignatura()==castOther.getCodAsignatura())
 && ( (this.getNombreUniversidad()==castOther.getNombreUniversidad()) || ( this.getNombreUniversidad()!=null && castOther.getNombreUniversidad()!=null && this.getNombreUniversidad().equals(castOther.getNombreUniversidad()) ) );
   }
   
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCodAsignatura();
         result = 37 * result + ( getNombreUniversidad() == null ? 0 : this.getNombreUniversidad().hashCode() );
         return result;
   }   


    @Override
    public String toString() {
        return "pojos.AsignaturaPK[ codAsignatura=" + codAsignatura + ", nombreUniversidad=" + nombreUniversidad + " ]";
    }
    
}
