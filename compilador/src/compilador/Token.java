/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador;

public class Token {
    private int a_idToken;
    private String a_Lexema;
    private int a_Tipo;
    private Object a_Valor;
    
    Token(int p_idToken,String p_Lexema,int p_Tipo){
        a_idToken=p_idToken;
        a_Lexema=p_Lexema;
        a_Tipo=p_Tipo;
    }
    
    public String m_getLexema(){
        return a_Lexema;
    }
    
    public int m_getID(){
        return a_idToken;
    }
    
    public int m_getTipo(){
        return a_Tipo;
    }
}
