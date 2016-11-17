/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class AnalisisSintactico {
    
    private ArrayList <Token> a_TablaDeSimbolos = new ArrayList <Token>();
    private String a_codFuente;
    
    public AnalisisSintactico(ArrayList p_TablaDeSimbolos, String p_codFuente){
        a_TablaDeSimbolos=p_TablaDeSimbolos;
        a_codFuente=p_codFuente;
    }
    
}
