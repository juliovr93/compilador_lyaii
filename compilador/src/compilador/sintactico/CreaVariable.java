/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class CreaVariable {
    private ArrayList <Token> a_TablaDeSimbolos;
    private String a_consola="";
    private String a_codFuente;
    private int a_Linea;
    
    public CreaVariable(ArrayList p_TablaDeSimbolos, String p_codFuente,int p_Linea){
        a_Linea=p_Linea;
        a_codFuente=p_codFuente;
        a_TablaDeSimbolos=p_TablaDeSimbolos;
        m_tipoVariable(a_codFuente);
    }
    
    private void m_tipoVariable(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            cad(v_codFuente);
        }
    }
    
    //cad
    private void cad(String p_codFuente){
        m_cadQ0(p_codFuente);
    }
    
    private void m_cadQ0(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='c'){
                m_cadQ1(v_codFuente.substring(1,v_codFuente.length()));
            }
        }
    }
    
    private void m_cadQ1(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='a'){
                m_cadQ2(v_codFuente.substring(1,v_codFuente.length()));
            }
        }
    }
    
    private void m_cadQ2(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='d'){
                m_cadQ3(v_codFuente.substring(1,v_codFuente.length()));
            }
        }
    }
    
    private void m_cadQ3(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)==' '){
                m_cadQ4(v_codFuente.substring(1,v_codFuente.length()));
            }else{
                if(v_codFuente.charAt(0)==10){
                    a_Linea++;
                    m_cadQ4(v_codFuente.substring(1,v_codFuente.length()));
                }else{
                    if(v_codFuente.charAt(0)==32){
                        m_cadQ4(v_codFuente.substring(1,v_codFuente.length()));
                    }
                }
            }
        }
    }
    
    private void m_cadQ4(String p_codFuente){
        String v_codFuente=p_codFuente;
        boolean v_bandera=true;
        while(!"".equals(v_codFuente)&&v_bandera){                                    
            if(v_codFuente.charAt(0)==32){
                v_bandera=true;
                v_codFuente=v_codFuente.substring(1,v_codFuente.length());
            }else{
                if(v_codFuente.charAt(0)==10){
                    v_bandera=true;
                    a_Linea++;
                    v_codFuente=v_codFuente.substring(1,v_codFuente.length());
                }else{
                    if(v_codFuente.charAt(0)==' '){
                        v_bandera=true;
                        v_codFuente=v_codFuente.substring(1,v_codFuente.length());
                    }else{
                        v_bandera=false;
                    }
                }
            }
        }
        if(!"".equals(v_codFuente)){
            Variable o_variable = new Variable(a_TablaDeSimbolos,v_codFuente,a_Linea,m_buscaToken("cad"));
            a_TablaDeSimbolos=o_variable.m_getTabla();
            a_consola+=o_variable.m_getConsola();
            a_codFuente=o_variable.m_getCodigoFuente();
        }else{
            a_consola+="Error [210]: Error no se declaro ninguna variable\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private int m_buscaToken(String p_Palabra){
        int v_tipo=-1;
        for(int v_indice=0;v_indice<a_TablaDeSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaDeSimbolos.get(v_indice);
            if(v_Temporal.m_getLexema().equals(p_Palabra)){
                v_Temporal.m_getID();
            }    
        }
        return v_tipo;
    }
    
    public String m_getCodigoFuente(){
        return a_codFuente;
    }
    
    public String m_getConsola(){
        return a_consola;
    }
    
    public  ArrayList <Token> m_getTabla(){
        return a_TablaDeSimbolos;
    }
}
