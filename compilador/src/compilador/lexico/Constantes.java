    /**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.lexico;
public class Constantes {

    private int a_ID;
    
    public int getConstante(String p_codFuente){
        int v_Recorrido=0;
        v_Recorrido=m_entQ0(p_codFuente);
        if(v_Recorrido==0){
            v_Recorrido=m_cadQ0(p_codFuente);
        }
        return v_Recorrido;
    }
    
    private int m_entQ0(String p_codFuente){
        int v_Recorrido=0;
        if(p_codFuente.charAt(0)>=48&&p_codFuente.charAt(0)<=57){    
            v_Recorrido=m_entQ1(p_codFuente,1);
        }
        return v_Recorrido;
    }
    
    private int m_entQ1(String p_codFuente,int p_Recorrido){
        int v_Recorrido=p_Recorrido;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(p_Recorrido)>=48&&p_codFuente.charAt(p_Recorrido)<=57){    
                v_Recorrido=m_entQ1(p_codFuente,v_Recorrido+1);
            }else{
                if(p_codFuente.charAt(p_Recorrido)!=';'){
                    if(p_codFuente.charAt(p_Recorrido)!=')'){
                        if(p_codFuente.charAt(p_Recorrido)!='+'){
                            if(p_codFuente.charAt(p_Recorrido)!='-'){
                                if(p_codFuente.charAt(p_Recorrido)!='*'){
                                    if(p_codFuente.charAt(p_Recorrido)!='/'){
                                        if(p_codFuente.charAt(p_Recorrido)!='='){
                                            if(p_codFuente.charAt(p_Recorrido)!='<'){
                                                if(p_codFuente.charAt(p_Recorrido)!='>'){
                                                    if(p_codFuente.charAt(p_Recorrido)!=' '){
                                                        if(p_codFuente.charAt(p_Recorrido)!=10){
                                                            if(p_codFuente.charAt(p_Recorrido)!=32)
                                                                v_Recorrido=-1;
                                                        }else{v_Recorrido=p_Recorrido;}
                                                    }else{v_Recorrido=p_Recorrido;}
                                                }else{v_Recorrido=p_Recorrido;}
                                            }else{v_Recorrido=p_Recorrido;}
                                        }else{v_Recorrido=p_Recorrido;}
                                    }else{v_Recorrido=p_Recorrido;}
                                }else{v_Recorrido=p_Recorrido;}
                            }else{v_Recorrido=p_Recorrido;}
                        }else{v_Recorrido=p_Recorrido;}
                    }else{v_Recorrido=p_Recorrido;}
                }else{v_Recorrido=p_Recorrido;}
            }
        }
        a_ID=2;
        return v_Recorrido;
    }
    
    private int m_cadQ0(String p_codFuente){
        int v_Recorrido=0;
        if(p_codFuente.charAt(0)=='"'){
            v_Recorrido=m_cadQ1(p_codFuente.substring(1),1);
        }
        return v_Recorrido;
    }
    
    private int m_cadQ1(String p_codFuente,int p_Recorrido){
        int v_Recorrido=p_Recorrido;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)!='"'){
                if(p_codFuente.charAt(0)!=10){
                    v_Recorrido=m_cadQ1(p_codFuente.substring(1),v_Recorrido+1);
                }else{
                    v_Recorrido=-2;
                } 
            }else{
                return v_Recorrido+1;
            }
        }
        a_ID=3;
        return v_Recorrido;
    }
    
    public int m_getID(){
        return a_ID;
    }
}
