/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador;

public class PalabrasReservadas {
    
    int getPalabrasReservadas(String p_Palabra){
        int v_Indice=0;
        if(start(p_Palabra)>0){
            v_Indice=start(p_Palabra);
        }
        else{
            if(end(p_Palabra)>0)
                v_Indice=end(p_Palabra);
            else{
                if(si(p_Palabra)>0)
                    v_Indice=si(p_Palabra);
                else{
                    
                }
            }
        }
        return v_Indice;
    }
    
    //#start
    private int start(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_startQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    int m_startQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='#'){
                v_Recorrido=m_startQ1(p_Palabra,1);
            }
        }
        return v_Recorrido;
    }
    
    int m_startQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='s'){
                v_Recorrido=m_startQ2(p_Palabra,2);
            }
        }
        return v_Recorrido;
    }
    
    int m_startQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='t'){
                v_Recorrido=m_startQ3(p_Palabra,3);
            }
        }
        return v_Recorrido;
    }
    
    int m_startQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='a'){
                v_Recorrido=m_startQ4(p_Palabra,4);
            }
        }
        return v_Recorrido;
    }
    
    int m_startQ4(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='r'){
                v_Recorrido=m_startQ5(p_Palabra,5);
            }
        }
        return v_Recorrido;
    }
    
    int m_startQ5(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='t'){
                v_Recorrido=m_startQ6(p_Palabra,6);
            }
        }
        return v_Recorrido;
    }
    
    int m_startQ6(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            v_Recorrido=0;
        }
        else{
            v_Recorrido=6;
        }
        return v_Recorrido;
    }
    
    //#end
    private int end(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_endQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    
    int m_endQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='#'){
                v_Recorrido=m_endQ1(p_Palabra,1);
            }
        }
        return v_Recorrido;
    }
    
    int m_endQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='e'){
                v_Recorrido=m_endQ2(p_Palabra,2);
            }
        }
        return v_Recorrido;
    }
    
    int m_endQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='n'){
                v_Recorrido=m_endQ3(p_Palabra,3);
            }
        }
        return v_Recorrido;
    }
    
    int m_endQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='d'){
                v_Recorrido=m_endQ4(p_Palabra,4);
            }
        }
        return v_Recorrido;
    }
    
    int m_endQ4(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            v_Recorrido=0;
        }else{
            v_Recorrido=4;
        }
        return v_Recorrido;
    }
    
    //si - sino
    private int si(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_siQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    int m_siQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='s'){
                v_Recorrido=m_siQ1(p_Palabra,1);
            }
        }
        return v_Recorrido;
    }
    
    int m_siQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='i'){
                v_Recorrido=m_siQ2(p_Palabra,2);
            }
        }
        return v_Recorrido;
    }
    
    int m_siQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='('){
                v_Recorrido=2;
            }
            if(p_Palabra.charAt(p_Index)=='n'){
                v_Recorrido=m_siQ3(p_Palabra,3);
            }
        }else{
            v_Recorrido=2;
        }
        return v_Recorrido;
    }
    
    int m_siQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='o'){
                v_Recorrido=m_siQ4(p_Palabra,4);
            }
        }
        return v_Recorrido;
    }
    
    int m_siQ4(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='{'){
                v_Recorrido=4;
            }
        }else{
            v_Recorrido=4;
        }
        return v_Recorrido;
    }
    
    //cad
    private int cad(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_cadQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    int m_cadQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='c'){
                v_Recorrido=m_cadQ1(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    int m_cadQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='a'){
                v_Recorrido=m_cadQ2(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    int m_cadQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='d'){
                v_Recorrido=m_cadQ3(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
   
    int m_cadQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            v_Recorrido=0;
        }else{
            v_Recorrido=p_Index;
        }
        return v_Recorrido;
    }
    
    
}
