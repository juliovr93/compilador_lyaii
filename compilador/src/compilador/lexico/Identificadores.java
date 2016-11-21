/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.lexico;

public class Identificadores {
    
    public int getIndentificador(String p_codFuente){
        int v_Indice=0;
        v_Indice=m_IdentQ0(p_codFuente);
        return v_Indice;
    }
    
    private int m_IdentQ0(String p_codFuente){
        String v_codFuente=p_codFuente;
        int v_Recorrido=0;
        if(v_codFuente.charAt(0)>=65&&v_codFuente.charAt(0)<=90||
           v_codFuente.charAt(0)>=97&&v_codFuente.charAt(0)<=122)
            v_Recorrido=m_IdentQ1(v_codFuente.substring(1),v_Recorrido+1);
        return v_Recorrido;
    }
    
    private int m_IdentQ1(String p_codFuente,int p_Recorrido){
        int v_Recorrido=p_Recorrido;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)>=48&&p_codFuente.charAt(0)<=57||
               p_codFuente.charAt(0)>=65&&p_codFuente.charAt(0)<=90||
               p_codFuente.charAt(0)>=97&&p_codFuente.charAt(0)<=122)
                v_Recorrido=m_IdentQ1(p_codFuente,v_Recorrido+1);
            else{
                if(p_codFuente.charAt(0)!=';'){
                    if(p_codFuente.charAt(0)!='('){
                        if(p_codFuente.charAt(0)!=')'){
                            if(p_codFuente.charAt(0)!=')'){
                                if(p_codFuente.charAt(0)!='+'){
                                    if(p_codFuente.charAt(0)!='-'){
                                        if(p_codFuente.charAt(0)!='*'){
                                            if(p_codFuente.charAt(0)!='/'){
                                                if(p_codFuente.charAt(0)!='<'){
                                                    if(p_codFuente.charAt(0)!='>'){
                                                        if(p_codFuente.charAt(0)!='='){
                                                            if(p_codFuente.charAt(0)!=' '){
                                                                if(p_codFuente.charAt(0)!=10){
                                                                    
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return v_Recorrido;
    }
}
