/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class BloqueCodigo {
    
    private ArrayList <Token> a_TablaSimbolos;
    private int a_Recorrido;
    private String a_Consola="";
    private boolean a_Error=false;

    public BloqueCodigo(ArrayList <Token> p_TablaSimbolos,int p_Recorrido,String p_Consola) {
        a_TablaSimbolos=p_TablaSimbolos;
        a_Recorrido=p_Recorrido;
        a_Consola=p_Consola;
        m_end();
    }
    
    private void m_end(){
        boolean v_Bandera=true;
        do{
            if(a_TablaSimbolos.size()>a_Recorrido){
                Token v_Token = a_TablaSimbolos.get(a_Recorrido);
                if(v_Token.m_getIdToken()!=11&&v_Token.m_getIdToken()!=61){
                    Linea o_Linea=new Linea(a_TablaSimbolos, a_Recorrido, a_Consola);
                    a_Recorrido=o_Linea.m_getRecorrido();
                    a_Consola=o_Linea.m_getConsola();
                    a_Error=o_Linea.m_getError();
                }else{
                    v_Bandera=false;
                }
            }else{
                v_Bandera=false;
            }
        }while(v_Bandera);
    }
    
    public String m_getConsola(){
        return a_Consola;
    }
    
    public int m_getRecorrido(){
        return a_Recorrido;
    }
    
    public boolean m_getError(){
        return a_Error;
    }
}
