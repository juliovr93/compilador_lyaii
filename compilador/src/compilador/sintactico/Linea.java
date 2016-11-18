/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class Linea {
    private ArrayList <Token> a_TablaDeSimbolos;
    private String a_consola="";
    private String a_codFuente="";
    private int a_Linea;
    
    public Linea(ArrayList p_TablaDeSimbolos, String p_codFuente,int p_Linea){
        a_Linea=p_Linea;
        a_TablaDeSimbolos=p_TablaDeSimbolos;
        a_codFuente=p_codFuente;
        m_tipoLinea(a_codFuente);
    }
    
    private void m_tipoLinea(String p_codFuente){
        String v_codFuente=p_codFuente;                
        if(!"".equals(v_codFuente)){
            CreaVariable o_creaVariable=new CreaVariable(a_TablaDeSimbolos,v_codFuente,a_Linea);
            a_consola+=o_creaVariable.m_getConsola();
            a_TablaDeSimbolos=o_creaVariable.m_getTabla();
            a_codFuente=o_creaVariable.m_getCodigoFuente();
            if(o_creaVariable.m_getCodigoFuente()!=v_codFuente){
                a_codFuente=o_creaVariable.m_getCodigoFuente();
            }
        }
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
