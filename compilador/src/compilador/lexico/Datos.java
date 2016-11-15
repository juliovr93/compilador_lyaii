    /**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.lexico;
public class Datos {

    public int getDatos(String p_Palabra){
        int v_Index=0;
        if (m_entQ0(p_Palabra,0)>0){
            v_Index=m_entQ0(p_Palabra,0);
        }else{
            if(m_cadQ0(p_Palabra,0)>0)
                v_Index=m_cadQ0(p_Palabra,0);
        }
        return v_Index;
    }
    
    private int m_entQ0(String p_Palabra,int p_Indice){
        int v_Index=p_Indice;
        if(p_Palabra.charAt(p_Indice)>=48&&p_Palabra.charAt(p_Indice)<=57){    
            v_Index=m_entQ1(p_Palabra,v_Index+1);
        }
        return v_Index;
    }
    
    private int m_entQ1(String p_Palabra,int p_Indice){
        int v_Index=p_Indice;
        if (p_Palabra.length()-1>=p_Indice){
            if(p_Palabra.charAt(p_Indice)>=48&&p_Palabra.charAt(p_Indice)<=57){    
                v_Index=m_entQ1(p_Palabra,v_Index+1);
            }
        }
        return v_Index;
    }
    
    private int m_cadQ0(String p_Palabra,int p_Indice){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Indice){
            if(p_Palabra.charAt(p_Indice)=='"'){
                v_Recorrido=m_cadQ1(p_Palabra,1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_cadQ1(String p_Palabra,int p_Indice){
        int v_Indice=p_Indice;
        if (p_Palabra.length()-1>=p_Indice){
            if(p_Palabra.charAt(p_Indice)!='"'){
                v_Indice=m_cadQ1(p_Palabra,v_Indice+1);
            }
            else{
                return v_Indice+1;
            }
        }
        else{
            return -1;
        }
        return v_Indice;
    }
}
