/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class Condicion {
    
    private ArrayList <Token> a_TablaLexico;
    private ArrayList <Token> a_TablaSimbolos;
    private int a_Recorrido;
    private String a_Consola="";
    private boolean a_Error=false;
    
    public Condicion(ArrayList <Token> p_TablaLexico,ArrayList <Token> p_TablaSimbolos,int p_Recorrido,String p_Consola){
        a_TablaLexico=p_TablaLexico;
        a_TablaSimbolos=p_TablaSimbolos;
        a_Recorrido=p_Recorrido;
        a_Consola=p_Consola;
        m_Condicion();
    }
    
    private void m_Condicion(){
        Expresion o_Expresion = new Expresion(a_TablaLexico,a_TablaSimbolos, a_Recorrido, a_Consola,0);
        a_Recorrido=o_Expresion.m_getRecorrido();
        a_Consola=o_Expresion.m_getConsola();
        a_Error=o_Expresion.m_getError();
        if(a_TablaLexico.size()>a_Recorrido){
            Token v_Token = a_TablaLexico.get(a_Recorrido);
            if(v_Token.m_getIdToken()==105||
                    v_Token.m_getIdToken()==107||
                    v_Token.m_getIdToken()==109||
                    v_Token.m_getIdToken()==110||
                    v_Token.m_getIdToken()==111){
                if(a_TablaLexico.size()>a_Recorrido+1){
                    a_Recorrido++;
                    v_Token = a_TablaLexico.get(a_Recorrido);
                    if(v_Token.m_getIdToken()!=59){
                        o_Expresion = new Expresion(a_TablaLexico,a_TablaSimbolos, a_Recorrido, a_Consola,0);
                        a_Recorrido=o_Expresion.m_getRecorrido();
                        a_Consola=o_Expresion.m_getConsola();
                        if(o_Expresion.m_getError())
                            a_Error=true;
                    }else{
                        a_Consola+="Error[]: No se declaro una valor \n";
                        a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
                        a_Error=true;
                    }
                }else{
                    a_Consola+="Error[]: No se declaro una valor \n";
                    a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
                    a_Error=true;
                }
            }else{
                a_Consola+="Error[]: Expresion mal declarada \n";
                a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                a_Error=true;
            }
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
