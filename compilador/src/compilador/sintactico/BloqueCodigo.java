/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class BloqueCodigo {
    
    private ArrayList <Token> a_TablaLexico;
    private ArrayList <Token> a_TablaSimbolos;
    private int a_Recorrido;
    private String a_Consola="";
    private boolean a_Error=false;

    public BloqueCodigo(ArrayList <Token> p_TablaLexico,ArrayList <Token> p_TablaSimbolos,int p_Recorrido,String p_Consola) {
        a_TablaLexico=p_TablaLexico;
        a_TablaSimbolos=p_TablaSimbolos;
        a_Recorrido=p_Recorrido;
        a_Consola=p_Consola;
        m_end();
        System.out.println("");
    }
    
    private void m_end(){
        boolean v_Bandera=true;
        do{
            if(a_TablaLexico.size()>a_Recorrido){
                Token v_Token = a_TablaLexico.get(a_Recorrido);
                if(v_Token.m_getIdToken()!=11&&v_Token.m_getIdToken()!=61){
                    Linea o_Linea=new Linea(a_TablaLexico,a_TablaSimbolos, a_Recorrido, a_Consola);
                    a_Recorrido=o_Linea.m_getRecorrido();
                    a_Consola=o_Linea.m_getConsola();
                    a_TablaSimbolos=o_Linea.m_getTabla();
                    a_TablaLexico=o_Linea.m_getLexico();
                    if(o_Linea.m_getError())
                        a_Error=true;
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
    
    public ArrayList <Token> m_getTabla(){
        return a_TablaSimbolos;
    }
    
    public ArrayList <Token> m_getLexico(){
        return a_TablaLexico;
    }
}
