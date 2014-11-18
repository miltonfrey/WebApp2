
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import model.EquivalenciaService;
import model.UniversidadService;
import pojos.Contrato;
import pojos.Equivalencia;
import pojos.Exceptions.ContratoNotFoundException;
import pojos.Exceptions.MovilidadNotFoundException;
import pojos.Exceptions.UniversidadException;
import pojos.Movilidad;
import pojos.Pais;
import pojos.Universidad;
import pojos.utillidades.BeanUtilidades;


@Named(value = "equivalenciasPublicasController")
@ViewScoped
public class EquivalenciasPublicasController implements Serializable{

    @Inject
    private BeanUtilidades beanUtilidades;
    @EJB
    private EquivalenciaService equivalenciaService;
    @EJB
    private UniversidadService universidadService;
    
    
    public EquivalenciasPublicasController() {
    }
    
    
    private ArrayList<Pais> listaPaises;
    private String paisStr;
    private ArrayList<Universidad> listaUniversidad;
    private String universidadStr;
    private Universidad universidad;
    
    private boolean checkPais;
   private boolean checkUni;
    
    private ArrayList<Equivalencia> listaEquivalencias;
    
    private Equivalencia selectedEquivalencia; 
    
    private boolean mostrarInfo;
    
    
    
    @PostConstruct
    public void init(){
       
    }

    

    public void setListaEquivalencias(ArrayList<Equivalencia> listaEquivalencias) {
        this.listaEquivalencias = listaEquivalencias;
    }

    public ArrayList<Pais> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(ArrayList<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public String getPaisStr() {
        return paisStr;
    }

    public void setPaisStr(String paisStr) {
        this.paisStr = paisStr;
    }

    public ArrayList<Universidad> getListaUniversidad() {
        return listaUniversidad;
    }

    public void setListaUniversidad(ArrayList<Universidad> listaUniversidad) {
        this.listaUniversidad = listaUniversidad;
    }

    public String getUniversidadStr() {
        return universidadStr;
    }

    public void setUniversidadStr(String universidadStr) {
        this.universidadStr = universidadStr;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    
    

    public boolean isCheckPais() {
        return checkPais;
    }

    public void setCheckPais(boolean checkPais) {
        this.checkPais = checkPais;
    }

    public boolean isCheckUni() {
        return checkUni;
    }

    public void setCheckUni(boolean checkUni) {
        this.checkUni = checkUni;
    }

    public Equivalencia getSelectedEquivalencia() {
        return selectedEquivalencia;
    }

    public void setSelectedEquivalencia(Equivalencia selectedEquivalencia) {
        this.selectedEquivalencia = selectedEquivalencia;
    }

    public boolean isMostrarInfo() {
        return mostrarInfo;
    }

    public void setMostrarInfo(boolean mostrarInfo) {
        this.mostrarInfo = mostrarInfo;
    }

   
    
    
    
    
    public void onChangePais(){
        
        checkPais=true;
        listaUniversidad=(ArrayList<Universidad>)universidadService.listarPorPais(paisStr);
        checkUni=false;
        mostrarInfo=false;
    }
    
    public void onChangeUni(){
        
        checkUni=true;
        mostrarInfo=false;
    }
   
    
    public String buscar(){
        
        
        
        try{
        universidad=universidadService.findUniversidad(universidadStr);
        }catch(UniversidadException ex){
            beanUtilidades.creaMensaje("no existe esa universidad", FacesMessage.SEVERITY_ERROR);
            universidadStr="";
            return null;
        }
        listaEquivalencias=(ArrayList < Equivalencia >)equivalenciaService.equivalenciasPublicas(universidadStr);
        mostrarInfo=true;
        return null;
    }
    
    public String verContrato(){
         Movilidad m;
        Contrato c;
        try{
        c=equivalenciaService.verContratoPorEquivalencia(selectedEquivalencia);
         m=equivalenciaService.buscarMovilidadPorContrato(c);
        }catch(ContratoNotFoundException|MovilidadNotFoundException|RuntimeException ex){
           beanUtilidades.creaMensaje("se ha producido un error", FacesMessage.SEVERITY_ERROR);
            return "equivalenciasPublicasAdmin.xhtml";
        }
      
        
       
        
        
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contrato", c);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("movilidad", m);
       // return "equivalenciasPublicasAdmin.xhtml?faces-redirect=true";
        return "gestionarContrato.xhtml?faces-redirect=true";
    }
    
    
   
}

    

