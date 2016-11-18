/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class Valor {
    
    private ArrayList <Token> a_TablaDeSimbolos;
    private String a_consola="";
    private String a_codFuente;
    private int a_Linea;
    private int a_Tipo;
    
    public Valor(ArrayList p_TablaDeSimbolos, String p_codFuente,int p_Linea,int p_Tipo){
        a_Tipo=p_Tipo;
        a_Linea=p_Linea;
        a_codFuente=p_codFuente;
        a_TablaDeSimbolos=p_TablaDeSimbolos;
        m_tipoValor(a_codFuente);
    }
    
    private void m_tipoValor(String p_codFuente){
        String v_codFuente=p_codFuente;
        if(m_entQ0(v_codFuente,0)){
            
        }
    }
    
    private boolean m_entQ0(String p_codFuente,int p_index){
        String v_codFuente=p_codFuente;
        boolean v_bandera=false;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)==32){    
                v_bandera=m_entQ0(v_codFuente.substring(1,v_codFuente.length()),p_index);
            }else{
                if(v_codFuente.charAt(0)>=48&&v_codFuente.charAt(0)<=57){    
                    p_index++;
                    v_bandera=m_entQ1(v_codFuente.substring(1,v_codFuente.length()),p_index);
                }else{
                    int x=v_codFuente.charAt(0);
                    System.out.println(x);
                }
            }
        }else{
            a_consola+="Error [215]: Error no se declaro ningun valor\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
        return v_bandera;
    }
    
    private boolean m_entQ1(String p_codFuente,int p_index){
        String v_codFuente=p_codFuente;
        boolean v_bandera=false;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)>=48&&v_codFuente.charAt(0)<=57){    
                p_index++;
                v_bandera=m_entQ1(v_codFuente.substring(1,v_codFuente.length()),p_index);
            }else{
                if(v_codFuente.charAt(0)==' '){
                    v_bandera=m_entQ2(v_codFuente.substring(1,v_codFuente.length()),p_index);
                }else{
                    if(v_codFuente.charAt(0)==10){
                        a_Linea++;
                        v_bandera=m_entQ2(v_codFuente.substring(1,v_codFuente.length()),p_index);
                    }else{
                        if(v_codFuente.charAt(0)==32){
                           v_bandera= m_entQ2(v_codFuente.substring(1,v_codFuente.length()),p_index);
                        }else{
                            if(v_codFuente.charAt(0)==';'){
                                v_bandera=m_entQ3(v_codFuente.substring(1,v_codFuente.length()),p_index);
                            }else{
                                
                            }
                        }
                    }
                }
            }
        }else{
            a_consola+="Error [215]: Error no se declaro ningun valor\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
        return v_bandera;
    }
    
    private boolean m_entQ2(String p_codFuente,int p_index){
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
            if(v_codFuente.charAt(0)==';'){
                m_entQ3(v_codFuente.substring(1,v_codFuente.length()),p_index);
            }else{
                m_entQ3(v_codFuente.substring(1,v_codFuente.length()),p_index);
                a_consola+="Error [210]: Error falta ';'\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
            }
        }else{
            a_consola+="Error [210]: Error falta ';'\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
        return true;
    }
    
    private boolean m_entQ3(String p_codFuente,int p_index){
        m_buscaValor(a_codFuente.substring(1,p_index+1));
        return true;
    }
    
    private void m_buscaValor(String p_Palabra){
        String v_Palabra=p_Palabra;
        int v_tipo=-1;
        for(int v_indice=0;v_indice<a_TablaDeSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaDeSimbolos.get(v_indice);
            if(v_Temporal.m_getLexema().equals(p_Palabra)){
                v_tipo=v_Temporal.m_getID();
                m_buscaVariable(v_tipo);
            }    
        }
    }
    
    private void m_buscaVariable(int p_valor){        
        for(int v_indice=0;v_indice<a_TablaDeSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaDeSimbolos.get(v_indice);
            if(v_Temporal.m_getID()==a_Tipo){
                v_Temporal.m_setValor(p_valor);
            }    
        }
    }
    
    public  ArrayList <Token> m_getTabla(){
        return a_TablaDeSimbolos;
    }
    
    public String m_getCodigoFuente(){
        return a_codFuente;
    }
    
    public String m_getConsola(){
        return a_consola;
    }
}
