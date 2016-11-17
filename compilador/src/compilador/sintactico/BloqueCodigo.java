/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;
public class BloqueCodigo {
  
    private String a_codFuente;
    
    public BloqueCodigo(String p_codFuente){
        a_codFuente=p_codFuente;
        start(p_codFuente);
    }
    
    //#start
    private int start(String p_codFuente){
        int v_Recorrido=0;
        v_Recorrido=m_startQ0(p_codFuente,0);
        return v_Recorrido;
    }
    
    private int m_startQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=m_startQ0(p_Palabra,1);
            }
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=m_startQ0(p_Palabra,1);
            }
            if(p_Palabra.charAt(p_Index)=='#'){
                v_Recorrido=m_startQ0(p_Palabra,1);
            }
            else{
                
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='s'){
                v_Recorrido=m_startQ2(p_Palabra,2);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='t'){
                v_Recorrido=m_startQ3(p_Palabra,3);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='a'){
                v_Recorrido=m_startQ4(p_Palabra,4);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ4(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='r'){
                v_Recorrido=m_startQ5(p_Palabra,5);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ5(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='t'){
                v_Recorrido=m_startQ6(p_Palabra,6);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ6(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=6;
            }
            if(p_Palabra.charAt(p_Index)==10){
                v_Recorrido=6;
            }
        }
        else{
            v_Recorrido=6;
        }
        return v_Recorrido;
    }
    
}
