/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class BloqueCodigo {
    ArrayList <Token> a_TablaDeSimbolos;
    private String a_codFuente;
    private int a_Linea=1;
    private String a_consola="";
    
    public BloqueCodigo(ArrayList p_TablaDeSimbolos, String p_codFuente){
        a_codFuente=p_codFuente;
        a_TablaDeSimbolos=p_TablaDeSimbolos;
        m_start(a_codFuente);
    }
    
    //#start
    private void m_start(String p_codFuente){
        m_startQ0(p_codFuente);
    }
    
    private void m_startQ0(String p_codFuente){
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
            if(v_codFuente.charAt(0)=='#'){
                m_startQ1(v_codFuente.substring(1,v_codFuente.length()));
            }
            else{
                a_consola+="Error [190]: Error al declarar '#start'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
                m_startError(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#start'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_startQ1(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='s'){
                m_startQ2(v_codFuente.substring(1,v_codFuente.length()));
            }else{
                a_consola+="Error [190]: Error al declarar '#start'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
                m_startError(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#start'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_startQ2(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='t'){
                m_startQ3(v_codFuente.substring(1,v_codFuente.length()));
            }else{
                a_consola+="Error [190]: Error al declarar '#start'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
                m_startError(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#start'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_startQ3(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='a'){
                m_startQ4(v_codFuente.substring(1,v_codFuente.length()));
            }else{
                a_consola+="Error [190]: Error al declarar '#start'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
                m_startError(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#start'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_startQ4(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='r'){
                m_startQ5(v_codFuente.substring(1,v_codFuente.length()));
            }else{
                a_consola+="Error [190]: Error al declarar '#start'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
                m_startError(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#start'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_startQ5(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='t'){
                m_startQ7(v_codFuente.substring(1,v_codFuente.length()));
            }else{
                a_consola+="Error [190]: Error al declarar '#start'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
                m_startError(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#start'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_startQ7(String p_codFuente){
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
            if(v_codFuente.charAt(0)=='#'){
                m_end(v_codFuente);
            }else{
                // ********************** Linea ***************************** //
                Linea o_Linea= new Linea(a_TablaDeSimbolos,v_codFuente,a_Linea);
                v_codFuente=o_Linea.m_getCodigoFuente();
                a_consola+=o_Linea.m_getConsola();
                a_TablaDeSimbolos=o_Linea.m_getTabla();
                a_codFuente=o_Linea.m_getCodigoFuente();
                // ********************** Linea ***************************** //
                m_end(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#end'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_startError(String p_codFuente){
        String v_codFuente=p_codFuente;
        boolean v_bandera=true;
        while(!"".equals(v_codFuente)&&v_bandera){                                    
            v_bandera=true;
            if(v_codFuente.charAt(0)!=32){    
                if(v_codFuente.charAt(0)!=10){
                    if(v_codFuente.charAt(0)!=' '){
                        v_codFuente=v_codFuente.substring(1,v_codFuente.length());
                    }
                    else{
                        v_bandera=false;
                    }
                }else{
                    v_bandera=false;
                }
            }else{
                v_bandera=false;
            }
        }
        
        if(!"".equals(v_codFuente)){
            m_startQ7(v_codFuente);
        }else{
            a_consola+="Error [190]: Error al declarar '#end'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    //#end
    private void m_end(String p_codFuente){
        m_endQ0(p_codFuente);
    }
    
    private void m_endQ0(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='#'){
                m_endQ1(v_codFuente.substring(1,v_codFuente.length()));
            }else{
                a_consola+="Error [190]: Error al declarar '#end'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
                m_endError(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#end'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_endQ1(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='e'){
                m_endQ2(v_codFuente.substring(1,v_codFuente.length()));
            }else{
                a_consola+="Error [190]: Error al declarar '#end'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
                m_endError(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#end'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_endQ2(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='n'){
                m_endQ3(v_codFuente.substring(1,v_codFuente.length()));
            }else{
                a_consola+="Error [190]: Error al declarar '#end'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
                m_endError(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#end'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_endQ3(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)=='d'){
                m_endQ4(v_codFuente.substring(1,v_codFuente.length()));
            }else{
                a_consola+="Error [190]: Error al declarar '#end'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
                m_endError(v_codFuente);
            }
        }else{
            a_consola+="Error [190]: Error al declarar '#end'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_endQ4(String p_codFuente){
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
                        a_consola+="Error [200]: Error al declarar instrucciones fuera del método principal \n";
                        a_consola+="Error en la linea: "+a_Linea+"\n";
                        m_endError(v_codFuente);
                    }
                }
            }
        }
    }
    
    private void m_endError(String p_codFuente){
        String v_codFuente=p_codFuente;
        boolean v_bandera=true;
        while(!"".equals(v_codFuente)&&v_bandera){                                    
            v_bandera=true;
            if(v_codFuente.charAt(0)!=32){    
                if(v_codFuente.charAt(0)!=10){
                    if(v_codFuente.charAt(0)!=' '){
                        v_codFuente=v_codFuente.substring(1,v_codFuente.length());
                    }
                    else{
                        v_bandera=false;
                    }
                }else{
                    v_bandera=false;
                }
            }else{
                v_bandera=false;
            }
        }
        
        if(!"".equals(v_codFuente)){
            m_endQ4(v_codFuente);
        }else{
            a_consola+="Error [190]: Error al declarar '#end'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    public String m_getConsola(){
        return a_consola;
    }
    
    public String m_getCodigoFuente(){
        return a_codFuente;
    }
    
    public  ArrayList <Token> m_getTabla(){
        return a_TablaDeSimbolos;
    }
}
