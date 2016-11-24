/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.lexico;

public class Delimitadores {
    
    private int a_ID;
    
    public int  getDelimitadores(String p_codFuente){
        int v_Indice=0;
        if(m_PuntoComa(p_codFuente)!=0){
            v_Indice=1;
            a_ID=62;
        }else{
            if(m_ParentesisAbierto(p_codFuente)!=0){
                v_Indice=1;
                a_ID=58;
            }else{
                if(m_ParentesisCerrado(p_codFuente)!=0){
                    v_Indice=1;
                    a_ID=59;
                }else{
                    if(m_LlavesAbierto(p_codFuente)!=0){
                        v_Indice=1;
                        a_ID=60;
                    }else{
                        if(m_LlavesCerrado(p_codFuente)!=0){
                            a_ID=61;
                            v_Indice=1;
                        }
                    }
                }
            }
        }
        return v_Indice;
    }
    
    //Punto y coma
    private int m_PuntoComa(String p_codFuente){
        if(p_codFuente.charAt(0)==';')
            return 1;
        else
            return 0;
    }
    
    //ParentesisAbierto
    private int m_ParentesisAbierto(String p_codFuente){
        if(p_codFuente.charAt(0)=='(')
            return 1;
        else
            return 0;
    }
    
    //ParentesisCerrado
    private int m_ParentesisCerrado(String p_codFuente){
        if(p_codFuente.charAt(0)==')')
            return 1;
        else
            return 0;
    }
    
    //ParentesisCerrado
    private int m_LlavesAbierto(String p_codFuente){
        if(p_codFuente.charAt(0)=='{')
            return 1;
        else
            return 0;
    }
    
    //ParentesisCerrado
    private int m_LlavesCerrado(String p_codFuente){
        if(p_codFuente.charAt(0)=='}')
            return 1;
        else
            return 0;
    }
    
    public int m_getID(){
        return a_ID;
    }
}
