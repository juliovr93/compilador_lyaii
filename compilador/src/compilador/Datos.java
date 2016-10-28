/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador;
public class Datos {

    int getDatos(String p_Palabra){
        int v_Index=0;
        v_Index=m_DatosQ0(p_Palabra,0);
        return v_Index;
    }
    
    int m_DatosQ0(String p_Palabra,int p_Indice){
        int v_Index=p_Indice;
        if(p_Palabra.charAt(p_Indice)>=48&&p_Palabra.charAt(p_Indice)<=57){    
            v_Index=m_DatosQ1(p_Palabra,v_Index+1);
        }
        return v_Index;
    }
    
    int m_DatosQ1(String p_Palabra,int p_Indice){
        int v_Index=p_Indice;
        if (p_Palabra.length()-1>=p_Indice){
            if(p_Palabra.charAt(p_Indice)>=48&&p_Palabra.charAt(p_Indice)<=57){    
                v_Index=m_DatosQ1(p_Palabra,v_Index+1);
            }
        }
        return v_Index;
    }
}
