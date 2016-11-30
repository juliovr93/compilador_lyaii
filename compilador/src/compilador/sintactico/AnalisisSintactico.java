/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class AnalisisSintactico {
    
    ArrayList <Token> a_TablaSimbolos;
    String a_Consola="";
    boolean a_Error=false;
    
    public AnalisisSintactico(ArrayList <Token> p_TablaSimbolos){
        a_TablaSimbolos=p_TablaSimbolos;
        Principal o_Principal = new Principal(a_TablaSimbolos,0,a_Consola);
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
}
