/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.semantico;

import compilador.Token;
import java.util.ArrayList;

public class Principal {

    private ArrayList <Token> a_TablaLexico;
    private ArrayList <Token> a_TablaSimbolos;
    private int a_Recorrido;
    private String a_Consola="";
    private boolean a_Error=false;
    
    public Principal(ArrayList <Token> p_TablaLexico,ArrayList <Token> p_TablaSimbolos,int p_Recorrido,String p_Consola){
        a_TablaLexico=p_TablaLexico;
        a_TablaSimbolos=p_TablaSimbolos;
        a_Recorrido=p_Recorrido;
        a_Consola=p_Consola;
        m_start();
    }
    
    private void m_start(){
        Token v_Token = a_TablaLexico.get(a_Recorrido);
        if(v_Token.m_getIdToken()!=10){
            
        }else{
            a_Recorrido++;
        }
        BloqueCodigo o_bloqueCodigo=new BloqueCodigo(a_TablaLexico,a_TablaSimbolos,a_Recorrido,a_Consola);
        a_Consola=o_bloqueCodigo.m_getConsola();
        a_Recorrido=o_bloqueCodigo.m_getRecorrido();
        a_TablaSimbolos=o_bloqueCodigo.m_getTabla();
        a_TablaLexico=o_bloqueCodigo.m_getLexico();
        if(o_bloqueCodigo.m_getError())
            a_Error=true;
        m_end();
    }
    
    private void m_end(){
        if(a_TablaLexico.size()>a_Recorrido){
            Token v_Token = a_TablaLexico.get(a_Recorrido);
            if(v_Token.m_getIdToken()!=11){
                
            }
        }else{
            Token v_Token=a_TablaLexico.get(a_Recorrido-1);
            
        }
    }
    
    public String m_getConsola(){
        return a_Consola;
    }
        
    public boolean m_getError(){
        return a_Error;
    }
    
}
