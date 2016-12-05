/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.semantico;

import compilador.Token;
import java.util.ArrayList;

public class AnalisisSemantico {
    private ArrayList <Token> a_TablaSimbolos;
    private ArrayList <Token> a_TablaLexico;
    private String a_Consola="";
    private boolean a_Error=false;
    
    public AnalisisSemantico(ArrayList <Token> p_TablaLexico,ArrayList <Token> p_TablaSimbolos){
        a_TablaSimbolos=p_TablaSimbolos;
        a_TablaLexico=p_TablaLexico;
        m_chequeoTipos();
        m_checaExpresiones();
    }
    
    
    private void m_chequeoTipos(){
        boolean v_Bandera=false;
        for(int v_indice=0;v_indice<a_TablaSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaSimbolos.get(v_indice);
            if(v_Temporal.m_getIdToken()==12){
                if(v_Temporal.m_getValor()!=0){
                    if(v_Temporal.m_getTipo()==56){
                        Token v_Valor= a_TablaSimbolos.get(v_Temporal.m_getValor()-1);
                        if(v_Valor.m_getIdToken()!=2){
                            a_Consola+="Error [310] Sem: Asignación de un valor de diferente tipo al de la variable al que se le asigna. \n";
                            a_Consola+="Error en la linea: "+v_Temporal.m_getNoLinea()+"\n";
                            a_Error=true;
                        }
                    }else{
                        if(v_Temporal.m_getTipo()==57){
                            Token v_Valor= a_TablaSimbolos.get(v_Temporal.m_getValor()-1);
                            if(v_Valor.m_getIdToken()!=3){
                                a_Consola+="Error [310]: Sem: Asignación de un valor de diferente tipo al de la variable al que se le asigna. \n";
                                a_Consola+="Error en la linea: "+v_Temporal.m_getNoLinea()+"\n";
                                a_Error=true;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void m_checaExpresiones(){
        Principal o_Principal = new Principal(a_TablaLexico,a_TablaSimbolos,0,a_Consola);
        a_Consola=o_Principal.m_getConsola();
        if(o_Principal.m_getError())
            a_Error=true;
    }
    
    public String m_getConsola(){
        return a_Consola;
    }
    
    public boolean m_getError(){
        return a_Error;
    }
}
