/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class Variable {
    private ArrayList <Token> a_TablaDeSimbolos;
    private String a_consola="";
    private String a_codFuente;
    private int a_Linea;
    private int a_Tipo;
    
    public Variable (ArrayList p_TablaDeSimbolos, String p_codFuente,int p_Linea,int p_Tipo){
        a_Tipo=p_Tipo;
        a_Linea=p_Linea;
        a_codFuente=p_codFuente;
        a_TablaDeSimbolos=p_TablaDeSimbolos;
        m_Variable(a_codFuente);
    }
    
    private void m_Variable(String p_codFuente){
        String v_codFuente=p_codFuente;
        m_variableQ0(v_codFuente,0);
    }
    
    private void m_variableQ0(String p_codFuente,int p_index){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)>=65&&v_codFuente.charAt(0)<=90||v_codFuente.charAt(0)>=97&&v_codFuente.charAt(0)<=122){
                p_index++;
                m_variableQ1(v_codFuente.substring(1,v_codFuente.length()),p_index);
            }else{
                a_consola+="Error [210]: Error no se declaro ninguna variable\n";
                a_consola+="Error en la linea: "+a_Linea+"\n";
            }
        }
    }
    
    private void m_variableQ1(String p_codFuente,int p_index){
        String v_codFuente=p_codFuente;
        if(!"".equals(v_codFuente)){
            if(v_codFuente.charAt(0)>=48&&v_codFuente.charAt(0)<=57||v_codFuente.charAt(0)>=65&&v_codFuente.charAt(0)<=90||v_codFuente.charAt(0)>=97&&v_codFuente.charAt(0)<=122){
                p_index++;
                m_variableQ1(v_codFuente.substring(1,v_codFuente.length()),p_index);
            }else{
                if(v_codFuente.charAt(0)==' '){
                    m_variableQ2(v_codFuente.substring(1,v_codFuente.length()),p_index);
                }else{
                    if(v_codFuente.charAt(0)==10){
                        a_Linea++;
                        m_variableQ2(v_codFuente.substring(1,v_codFuente.length()),p_index);
                    }else{
                        if(v_codFuente.charAt(0)==32){
                            m_variableQ2(v_codFuente.substring(1,v_codFuente.length()),p_index);
                        }else{
                            if(v_codFuente.charAt(0)=='='){
                                m_variableQ3(v_codFuente.substring(1,v_codFuente.length()),p_index);
                            }else{
                                if(v_codFuente.charAt(0)==';'){
                                    m_variableQ4(v_codFuente.substring(1,v_codFuente.length()),p_index);
                                }else{
                                    a_consola+="Error [210]: Error no se declaro ninguna variable\n";
                                    a_consola+="Error en la linea: "+a_Linea+"\n";
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void m_variableQ2(String p_codFuente,int p_index){
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
            if(v_codFuente.charAt(0)=='='){
                m_variableQ3(v_codFuente.substring(1,v_codFuente.length()),p_index);
            }else{
                if(v_codFuente.charAt(0)==';'){
                    m_variableQ4(v_codFuente.substring(1,v_codFuente.length()),p_index);
                }else{
                    
                }
            }
        }else{
            a_consola+="Error [210]: Error no se declaro ninguna variable\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
        }
    }
    
    private void m_variableQ3(String p_codFuente,int p_index){
        System.out.println("Valor");
    }
    
    private void m_variableQ4(String p_codFuente,int p_index){
        m_buscaToken(a_codFuente.substring(0,p_index));
    }
    
    private void m_buscaToken(String p_Palabra){
        for(int v_indice=0;v_indice<a_TablaDeSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaDeSimbolos.get(v_indice);
            if(v_Temporal.m_getLexema().equals(p_Palabra)){
                v_Temporal.m_setTipo(a_Tipo);
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
