/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador;

public class Token {
    private int a_noToken;
    private String a_Lexema;
    private int a_tipoLexema;
    private int a_Tipo;
    private int a_Valor;
    private int a_noLinea;
    private int a_idToken;
    
    public Token(int p_noToken,String p_Lexema,int p_tipoLexema,int p_noLinea,int p_idToken){
        a_noToken=p_noToken;
        a_Lexema=p_Lexema;
        a_tipoLexema=p_tipoLexema;
        a_noLinea=p_noLinea;
        a_idToken=p_idToken;
    }
    
    public int m_getNoToken(){
        return a_noToken;
    }
    
    public String m_getLexema(){
        return a_Lexema;
    }
    
    public int m_getTipoLexema(){
        return a_tipoLexema;
    }
    
    public int m_getTipo(){
        return a_Tipo;
    }
    
    public Object m_getValor(){
        return a_Valor;
    }
    
    public int m_getNoLinea(){
        return a_noLinea;
    }
    
    public int m_getIdToken(){
        return a_idToken;
    }
    
    public void m_setTipo(int p_Tipo){
        a_Tipo=p_Tipo;
    }
    
    public void m_setValor(int p_Tipo){
        a_Valor=p_Tipo;
    }
}
