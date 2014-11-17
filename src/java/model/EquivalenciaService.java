
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import pojos.Contrato;
import pojos.Equivalencia;
import pojos.Exceptions.ContratoNotFoundException;
import pojos.Exceptions.FechaIncorrectaException;
import pojos.Exceptions.MovilidadNotFoundException;
import pojos.GrupoAsignaturaA;
import pojos.GrupoAsignaturaB;
import pojos.Movilidad;
import pojos.utillidades.EquivalenciaRevisada;

@Local
public interface EquivalenciaService {
    public void crearEquivalencia(Equivalencia e);
    public void eliminarEquivalencia(Equivalencia e);
    public void actualizarEquivalencia(Equivalencia e);
    public List<Equivalencia> listarEquivalencias();
    
    
    public void crearGrupoAsignaturasA(GrupoAsignaturaA grupo);
     public void crearGrupoAsignaturasB(GrupoAsignaturaB grupo);
    //public void crearMiembroGrupoAsignatura(MiembroGrupoAsignatura m);
       
    
    public void creaContrato(Contrato c);
    public void modificaContrato(Contrato c);
    public List<Contrato> listaContratos(Movilidad m);
    public void eliminaContrato(Contrato c);
    public Contrato findContrato(Integer id) throws ContratoNotFoundException;
   public List<Equivalencia> equivalenciasPublicas(String universidad);
   public List<Object[]> listaObject();
   public int[] totalCreditos(ArrayList<Equivalencia> lista);
   public void confirmarContrato(ArrayList<Equivalencia> lista,Contrato c);
   public ArrayList<Equivalencia> editarContrato(ArrayList<Equivalencia>listaAuxEquivalencias,Contrato c);
   public void crearContratoDesdeAceptado(ArrayList<Equivalencia>listaAuxEquivalencias,Contrato c, Contrato cNuevo);
   public void compruebaFechaCrearContrato(Contrato c,Date aux)throws FechaIncorrectaException;
   public ArrayList<EquivalenciaRevisada> compararEquivalencias(ArrayList<Equivalencia> listaAuxEquivalencias,ArrayList<Equivalencia> listaAuxEquivalenciasComparado);
    public Contrato verContratoPorEquivalencia(Equivalencia e)throws ContratoNotFoundException;
    public Movilidad buscarMovilidadPorContrato(Contrato c)throws ContratoNotFoundException,MovilidadNotFoundException;
    
}
