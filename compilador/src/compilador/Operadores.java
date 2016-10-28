/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador;

public class Operadores {
    
    int getOperadores(String p_Palabra){
        int v_Return=0;
        if(Mas(p_Palabra) >0){
            v_Return=Mas(p_Palabra);
        }
        else{
            if(Menos(p_Palabra) >0){
                v_Return=Menos(p_Palabra);
            }
            else{
                if(Por(p_Palabra) >0){
                    v_Return=Por(p_Palabra);
                }
                else{
                    if(Entre(p_Palabra) >0){
                        v_Return=Entre(p_Palabra);
                    }
                    else{
                        if(MenorIgual(p_Palabra) >0){
                            v_Return=MenorQue(p_Palabra);
                        }
                        else{
                            if(MayorIgual(p_Palabra) >0){
                                v_Return=MayorQue(p_Palabra);
                            }
                            else{
                                if(MenorQue(p_Palabra) >0){
                                    v_Return=MenorIgual(p_Palabra);
                                }
                                else{
                                    if(MayorQue(p_Palabra) >0){
                                        v_Return=MayorIgual(p_Palabra);
                                    }
                                    else{
                                        if(Igual(p_Palabra) >0){
                                            v_Return=Igual(p_Palabra);
                                        }
                                        else{
                                            v_Return=0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return v_Return;
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
    
    private int MenorQue(String p_Palabra){
        if(p_Palabra.charAt(0)=='<')
            return 1;
        else
            return 0;
    }
    
    private int MayorQue(String p_Palabra){
        if(p_Palabra.charAt(0)=='>')
            return 1;
        else
            return 0;
    }
    
    private int MenorIgual(String p_Palabra){
        if(p_Palabra.charAt(0)=='<'){
            if(p_Palabra.length()>1){
                if(p_Palabra.charAt(1)=='=')
                return 2;
            }
            return 1;
        }
        else
            return 0;
    }
    
    private int MayorIgual(String p_Palabra){
        if(p_Palabra.charAt(0)=='>'){
            if(p_Palabra.length()>1){
                if(p_Palabra.charAt(1)=='=')
                return 2;
            }
            return 1;
        }
        else
            return 0;
    }
    
    private int Igual(String p_Palabra){
        if(p_Palabra.charAt(0)=='='){
            if(p_Palabra.length()>1){
                if(p_Palabra.charAt(1)=='=')
                return 2;
            }
            return 1;
        }
        else
            return 0;
    }
}
