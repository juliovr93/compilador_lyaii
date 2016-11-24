/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class Linea {
    private ArrayList <Token> a_TablaSimbolos;
    private int a_Recorrido;
    private String a_Consola="";
    private boolean a_Error=false;
    
    
    public Linea (ArrayList <Token> p_TablaSimbolos,int p_Recorrido,String p_Consola){
        a_TablaSimbolos=p_TablaSimbolos;
        a_Recorrido=p_Recorrido;
        a_Consola=p_Consola;
        m_Linea();
    }
    
    private void m_Linea(){
        if(a_TablaSimbolos.size()>a_Recorrido){
            Token v_Token = a_TablaSimbolos.get(a_Recorrido);
            if(v_Token.m_getIdToken()==56||v_Token.m_getIdToken()==57){
                a_Recorrido++;
                CreaVariable o_creaVariable = new CreaVariable(a_TablaSimbolos, a_Recorrido, a_Consola);
                a_Consola=o_creaVariable.m_getConsola();
                a_Recorrido=o_creaVariable.m_getRecorrido();
                a_Error=o_creaVariable.m_getError();
            }
        }
    }
    
    public String m_getConsola(){
        return a_Consola;
    }
    
    public int m_getRecorrido(){
        return a_Recorrido;
    }
    
    public boolean m_getError(){
        return a_Error;
    }
}
