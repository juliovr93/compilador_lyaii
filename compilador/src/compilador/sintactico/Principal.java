/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class Principal {

    private ArrayList <Token> a_TablaSimbolos;
    private int a_Recorrido;
    private String a_Consola="";
    private boolean a_Error=false;
    
    public Principal(ArrayList <Token> p_TablaSimbolos,int p_Recorrido,String p_Consola){
        a_TablaSimbolos=p_TablaSimbolos;
        a_Recorrido=p_Recorrido;
        a_Consola=p_Consola;
        m_start();
    }
    
    private void m_start(){
        Token v_Token = a_TablaSimbolos.get(a_Recorrido);
        if(v_Token.m_getIdToken()!=10){
            a_Consola+="Error[]: No se declaro la sentencia 'start' \n";
            a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
            a_Error=true;
        }else{
            a_Recorrido++;
        }
        BloqueCodigo o_bloqueCodigo=new BloqueCodigo(a_TablaSimbolos,a_Recorrido,a_Consola);
        a_Consola=o_bloqueCodigo.m_getConsola();
        a_Recorrido=o_bloqueCodigo.m_getRecorrido();
        a_Error=o_bloqueCodigo.m_getError();
        m_end();
    }
    
    private void m_end(){
        if(a_TablaSimbolos.size()>a_Recorrido){
            Token v_Token = a_TablaSimbolos.get(a_Recorrido);
            if(v_Token.m_getIdToken()!=11){
                a_Consola+="Error[]: No se declaro la sentencia 'end' \n";
                a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
                a_Error=true;
            }
        }else{
            a_Consola+="Error[]: No se declaro la sentencia 'end' \n";
            a_Error=true;
        }
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
