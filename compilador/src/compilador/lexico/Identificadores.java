/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.lexico;

public class Identificadores {
    
    public int getIndentificador(String p_Palabra){
        int v_Indice=0;
        v_Indice=m_IdentQ0(p_Palabra,0);
        return v_Indice;
    }
    
    private int m_IdentQ0(String p_Palabra,int p_Indice){
        int v_Indice=0;
        if(p_Palabra.charAt(p_Indice)>=65&&p_Palabra.charAt(v_Indice)<=90||
                p_Palabra.charAt(p_Indice)>=97&&p_Palabra.charAt(v_Indice)<=122)
            v_Indice=m_IdentQ1(p_Palabra,v_Indice+1);
        return v_Indice;
    }
    
    private int m_IdentQ1(String p_Palabra,int p_Indice){
        int v_Indice=p_Indice;
        if (p_Palabra.length()-1>=p_Indice){
            if(p_Palabra.charAt(p_Indice)>=48&&p_Palabra.charAt(v_Indice)<=57||
                p_Palabra.charAt(p_Indice)>=65&&p_Palabra.charAt(v_Indice)<=90||
                p_Palabra.charAt(p_Indice)>=97&&p_Palabra.charAt(v_Indice)<=122)
                v_Indice=m_IdentQ1(p_Palabra,v_Indice+1);
        }
        return v_Indice;
    }
}
