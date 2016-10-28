/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador;

public class Delimitadores {
    
    int  getDelimitadores(String p_Palabra){
        int v_Indice=0;
        if(m_PuntoComa(p_Palabra)!=0){
            v_Indice=1;
        }else{
            if(m_ParentesisAbierto(p_Palabra)!=0){
                v_Indice=1;
            }else{
                if(m_ParentesisCerrado(p_Palabra)!=0){
                    v_Indice=1;
                }else{
                    if(m_LlavesAbierto(p_Palabra)!=0){
                        v_Indice=1;
                    }else{
                        if(m_LlavesCerrado(p_Palabra)!=0){
                            v_Indice=1;
                        }
                    }
                }
            }
        }
        return v_Indice;
    }
    
    //Punto y coma
    int m_PuntoComa(String p_Palabra){
        if(p_Palabra.charAt(0)==';')
            return 1;
        else
            return 0;
    }
    
    //ParentesisAbierto
    int m_ParentesisAbierto(String p_Palabra){
        if(p_Palabra.charAt(0)=='(')
            return 1;
        else
            return 0;
    }
    
    //ParentesisCerrado
    int m_ParentesisCerrado(String p_Palabra){
        if(p_Palabra.charAt(0)==')')
            return 1;
        else
            return 0;
    }
    
    //ParentesisCerrado
    int m_LlavesAbierto(String p_Palabra){
        if(p_Palabra.charAt(0)=='{')
            return 1;
        else
            return 0;
    }
    
    //ParentesisCerrado
    int m_LlavesCerrado(String p_Palabra){
        if(p_Palabra.charAt(0)=='}')
            return 1;
        else
            return 0;
    }
}
