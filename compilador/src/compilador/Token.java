/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador;

public class Token {
    private int a_idToken;
    private String a_Lexema;
    private int a_TipoLexema;
    private int a_Tipo;
    private Object a_Valor;
    
    public Token(int p_idToken,String p_Lexema,int p_tipoLexema){
        a_idToken=p_idToken;
        a_Lexema=p_Lexema;
        a_TipoLexema=p_tipoLexema;
    }
    
    public String m_getLexema(){
        return a_Lexema;
    }
    
    public int m_getID(){
        return a_idToken;
    }
    
    public int m_getTipoLexema(){
        return a_TipoLexema;
    }
    
    public int m_getTipo(){
        return a_Tipo;
    }
    
    public Object m_getValor(){
        return a_Valor;
    }
    
    public void m_setTipo(int p_Tipo){
        a_Tipo=p_Tipo;
    }
}
