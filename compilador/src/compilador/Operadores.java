/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador;

public class Operadores {
    
    int getOperadores(String p_Palabra){
        int v_Indice=0;
        if(Mas(p_Palabra) >0){
            v_Indice=Mas(p_Palabra);
        }
        else{
            if(Menos(p_Palabra) >0){
                v_Indice=Menos(p_Palabra);
            }
            else{
                if(Por(p_Palabra) >0){
                    v_Indice=Por(p_Palabra);
                }
                else{
                    if(Entre(p_Palabra) >0){
                        v_Indice=Entre(p_Palabra);
                    }
                    else{
                        if(MenorQue(p_Palabra,v_Indice) >0){
                            v_Indice=MenorQue(p_Palabra,v_Indice);
                        }
                        else{
                            if(MayorQue(p_Palabra,v_Indice) >0){
                                v_Indice=MayorQue(p_Palabra,v_Indice);
                            }
                            else{
                                if(Igual(p_Palabra,v_Indice) >0){
                                    v_Indice=Igual(p_Palabra,v_Indice);
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
    
    private int Mas(String p_Palabra){
        if(p_Palabra.charAt(0)=='+')
            return 1;
        else
            return 0;
    }
    
    private int Menos(String p_Palabra){
        if(p_Palabra.charAt(0)=='-')
            return 1;
        else
            return 0;
    }
    
    private int Por(String p_Palabra){
        if(p_Palabra.charAt(0)=='*')
            return 1;
        else
            return 0;
    }
    
    private int Entre(String p_Palabra){
        if(p_Palabra.charAt(0)=='/')
            return 1;
        else
            return 0;
    }
    
    private int MenorQue(String p_Palabra,int p_Indice){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>p_Indice){
            if(p_Palabra.charAt(0)=='<'){
                v_Recorrido=IgualQ(p_Palabra,1);
            }
        }
        return v_Recorrido;
    }
    
    private int MayorQue(String p_Palabra,int p_Indice){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>p_Indice){
            if(p_Palabra.charAt(0)=='>'){
                v_Recorrido=IgualQ(p_Palabra,1);
            }
        }
        return v_Recorrido;
    }
    
    private int Igual(String p_Palabra,int p_Indice){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>p_Indice){
            if(p_Palabra.charAt(0)=='='){
                v_Recorrido=IgualQ(p_Palabra,1);
            }
        }
        return v_Recorrido;
    }
    
    private int IgualQ(String p_Palabra,int p_Indice){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Indice){
            if(p_Palabra.charAt(p_Indice)=='='){
                v_Recorrido=2;
            }else{
                v_Recorrido=1;
            }
        }else{
            v_Recorrido=1;
        }
        return v_Recorrido;
    }
}
