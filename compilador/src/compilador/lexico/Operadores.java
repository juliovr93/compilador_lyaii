/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.lexico;

public class Operadores {
    
    private int a_ID;
    
    public int getOperadores(String p_codFuente){
        int v_Indice=0;
        if(m_Mas(p_codFuente) >0){
            v_Indice=m_Mas(p_codFuente);
            a_ID=5;
        }
        else{
            if(m_Menos(p_codFuente) >0){
                v_Indice=m_Menos(p_codFuente);
                a_ID=6;
            }
            else{
                if(m_Por(p_codFuente) >0){
                    v_Indice=m_Por(p_codFuente);
                    a_ID=7;
                }
                else{
                    if(m_Entre(p_codFuente) >0){
                        v_Indice=m_Entre(p_codFuente);
                        a_ID=8;
                    }
                    else{
                        if(m_MenorQue(p_codFuente,v_Indice) >0){
                            v_Indice=m_MenorQue(p_codFuente,v_Indice);
                        }
                        else{
                            if(m_MayorQue(p_codFuente,v_Indice) >0){
                                v_Indice=m_MayorQue(p_codFuente,v_Indice);
                            }
                            else{
                                if(m_Igual(p_codFuente,v_Indice) >0){
                                    v_Indice=m_Igual(p_codFuente,v_Indice);
                                }
                                else{
                                    v_Indice=0;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return v_Indice;
    }
    
    private int m_Mas(String p_codFuente){
        if(p_codFuente.charAt(0)=='+')
            return 1;
        else
            return 0;
    }
    
    private int m_Menos(String p_codFuente){
        if(p_codFuente.charAt(0)=='-')
            return 1;
        else
            return 0;
    }
    
    private int m_Por(String p_codFuente){
        if(p_codFuente.charAt(0)=='*')
            return 1;
        else
            return 0;
    }
    
    private int m_Entre(String p_codFuente){
        if(p_codFuente.charAt(0)=='/')
            return 1;
        else
            return 0;
    }
    
    private int m_MenorQue(String p_codFuente,int p_Recorrido){
        int v_Recorrido=0;
        if(p_codFuente.length()-1>p_Recorrido){
            if(p_codFuente.charAt(0)=='<'){
                v_Recorrido=IgualQ(p_codFuente,1);
                if(v_Recorrido==1){
                    a_ID=105;
                }
                if(v_Recorrido==2){
                    a_ID=109;
                }
            }
        }
        return v_Recorrido;
    }
    
    private int m_MayorQue(String p_codFuente,int p_Recorrido){
        int v_Recorrido=0;
        if(p_codFuente.length()-1>p_Recorrido){
            if(p_codFuente.charAt(0)=='>'){
                v_Recorrido=IgualQ(p_codFuente,1);
            }
            if(v_Recorrido==1){
                a_ID=107;
            }
            if(v_Recorrido==2){
                a_ID=110;
            }
        }
        return v_Recorrido;
    }
    
    private int m_Igual(String p_codFuente,int p_Recorrido){
        int v_Recorrido=0;
        if(p_codFuente.length()-1>p_Recorrido){
            if(p_codFuente.charAt(0)=='='){
                v_Recorrido=IgualQ(p_codFuente,1);
            }
            if(v_Recorrido==1){
                a_ID=112;
            }
            if(v_Recorrido==2){
                a_ID=111;
            }
        }
        return v_Recorrido;
    }
    
    private int IgualQ(String p_codFuente,int p_Recorrido){
        int v_Recorrido=0;
        if(p_codFuente.length()-1>=p_Recorrido){
            if(p_codFuente.charAt(p_Recorrido)=='='){
                v_Recorrido=2;
            }else{
                v_Recorrido=1;
            }
        }else{
            v_Recorrido=1;
        }
        return v_Recorrido;
    }
    
    public int m_getID(){
        return a_ID;
    }
}
