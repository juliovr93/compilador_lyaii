/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class AnalisisSintactico {
    
    private ArrayList a_TablaDeSimbolos;
    private String a_codFuente;
    private String a_consola="";
    
    public AnalisisSintactico(ArrayList p_TablaDeSimbolos, String p_codFuente){
        a_TablaDeSimbolos=p_TablaDeSimbolos;
        a_codFuente=p_codFuente;
        a_anaSintactico();
    }
    
    private void a_anaSintactico(){
        BloqueCodigo o_bloqueCodigo=new BloqueCodigo(a_TablaDeSimbolos,a_codFuente);
        a_consola=o_bloqueCodigo.m_getConsola();
    }
    
    public String m_getConsola(){
        return a_consola;
    }
}
