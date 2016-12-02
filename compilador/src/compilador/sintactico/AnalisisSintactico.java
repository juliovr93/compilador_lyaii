/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class AnalisisSintactico {
    
    private ArrayList <Token> a_TablaSimbolos;
    private ArrayList <Token> a_TablaLexico;
    private String a_Consola="";
    private boolean a_Error=false;
    
    public AnalisisSintactico(ArrayList <Token> p_TablaLexico,ArrayList <Token> p_TablaSimbolos){
        a_TablaLexico=p_TablaLexico;
        a_TablaSimbolos=p_TablaSimbolos;
        Principal o_Principal = new Principal(a_TablaLexico,a_TablaSimbolos,0,a_Consola);
        a_TablaSimbolos=o_Principal.m_getTabla();
        a_TablaLexico=o_Principal.m_getLexico();
        a_Consola=o_Principal.m_getConsola();
        if(o_Principal.m_getError())
            a_Error=true;
    }
    
    public boolean m_getError(){
        return a_Error;
    }
    
    public String m_getConsola(){
        return a_Consola;
    }
    
    public ArrayList <Token> m_getTabla(){
        return a_TablaSimbolos;
    }
    
    public ArrayList <Token> m_getLexico(){
        return a_TablaLexico;
    }
}
