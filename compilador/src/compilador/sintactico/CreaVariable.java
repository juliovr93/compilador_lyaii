/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class CreaVariable {
    
    private ArrayList <Token> a_TablaSimbolos;
    private int a_Recorrido;
    private String a_Consola="";
    private boolean a_Error=false;
    
    public CreaVariable (ArrayList <Token> p_TablaSimbolos,int p_Recorrido,String p_Consola){
        a_TablaSimbolos=p_TablaSimbolos;
        a_Recorrido=p_Recorrido;
        a_Consola=p_Consola;
        m_creaVariable();
    }
    
    private void m_creaVariable(){
        if(a_TablaSimbolos.size()>a_Recorrido){
            Token v_Token = a_TablaSimbolos.get(a_Recorrido);
            if(v_Token.m_getIdToken()==12){
                a_Recorrido++;
                if(a_TablaSimbolos.size()>a_Recorrido){
                    v_Token = a_TablaSimbolos.get(a_Recorrido);
                    if(v_Token.m_getIdToken()!=62){
                        a_Recorrido++;
                        if(a_TablaSimbolos.size()>a_Recorrido){
                            v_Token = a_TablaSimbolos.get(a_Recorrido);
                            if(v_Token.m_getIdToken()!=112){
                                
                            }else{
                                a_Consola+="Error[]: No se asigno un valor\n";
                                a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                a_Error=true;
                            }
                        }
                        else{
                            a_Consola+="Error[]: No se asigno un valor\n";
                            a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
                            a_Error=true;
                        }
                    }else{
                        a_Consola+="Error[]: Falta cerrar linea ';' \n";
                        a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
                        a_Error=true;
                    }
                }else{
                    a_Consola+="Error[]: Falta cerrar linea ';' \n";
                    a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
                    a_Error=true;
                }
            }else{
                a_Consola+="Error[]: No se declaro una variable \n";
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
