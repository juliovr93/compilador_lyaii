/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class mainSintactico {
    
    private ArrayList <Token> a_TablaDeSimbolos = new ArrayList <Token>();
    
    public mainSintactico(ArrayList p_TablaDeSimbolos){
        a_TablaDeSimbolos=p_TablaDeSimbolos;
        m_BuscaToken();
    }
    
    private boolean m_BuscaToken(){
        boolean v_bdStart=false;
        boolean v_bdEnd=false;
        
        for(int v_indice=0;v_indice<a_TablaDeSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaDeSimbolos.get(v_indice);
            if(v_Temporal.m_getLexema().equals("#start"))
                v_bdStart=true;
            if(v_Temporal.m_getLexema().equals("#end"))
                v_bdEnd=true;
        }
        return v_bdStart && v_bdEnd;
    }
    
    public String mainSintaxis(){
        String v_Mensaje="";
        if(m_BuscaToken()){
            
        }else{
            v_Mensaje="Error []: La sentencia <main> no esta completa";
        }
        return v_Mensaje;
    }
}
