/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class CreaVariable {
    
    private ArrayList <Token> a_TablaLexico;
    private ArrayList <Token> a_TablaSimbolos;
    private int a_Recorrido;
    private String a_Consola="";
    private boolean a_Error=false;
    
    public CreaVariable (ArrayList <Token> p_TablaLexico,ArrayList <Token> p_TablaSimbolos,int p_Recorrido,String p_Consola){
        a_TablaLexico=p_TablaLexico;
        a_TablaSimbolos=p_TablaSimbolos;
        a_Recorrido=p_Recorrido;
        a_Consola=p_Consola;
        m_creaVariable();
    }
    
    private void m_creaVariable(){
    if(a_TablaLexico.size()>a_Recorrido){
            Token v_Token = a_TablaLexico.get(a_Recorrido);
            if(v_Token.m_getIdToken()==12){
                if(m_buscaToken(v_Token.m_getLexema())){
                    Token v_Temp = a_TablaLexico.get(a_Recorrido-1);
                    m_tipoToken(v_Token.m_getLexema(),v_Temp);
                    m_tipoLexema(v_Token.m_getLexema(), v_Temp);
                }else{
                    Token v_Temp = a_TablaLexico.get(a_Recorrido-1);
                    m_tipoLexema(v_Token.m_getLexema(), v_Temp);
                    a_TablaLexico.set(a_Recorrido,v_Token);
                    a_Consola+="Error[]: El identificador '"+v_Token.m_getLexema()+"' ya fue declarado \n";
                    a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                    a_Error=true;
                }
                
                if(a_TablaLexico.size()>a_Recorrido+1){
                    a_Recorrido++;
                    v_Token = a_TablaLexico.get(a_Recorrido);
                    if(v_Token.m_getIdToken()!=62){
                        if(v_Token.m_getIdToken()==112){
                            a_Recorrido++;
                            Expresion o_Expresion = new Expresion(a_TablaLexico,a_TablaSimbolos, a_Recorrido, a_Consola,0);
                            a_TablaSimbolos= o_Expresion.m_getTabla();
                            a_TablaLexico=o_Expresion.m_getLexico();
                            a_Recorrido=o_Expresion.m_getRecorrido();
                            a_Consola=o_Expresion.m_getConsola();
                            if(o_Expresion.m_getError())
                                a_Error=true;
                            if(a_TablaLexico.size()>a_Recorrido){
                                v_Token = a_TablaLexico.get(a_Recorrido);
                                if(v_Token.m_getIdToken()!=62){
                                    a_Consola+="Error[]: Falta cerrar linea ';' \n";
                                    a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                    a_Error=true;
                                }else{
                                    a_Recorrido++;
                                }
                            }else{
                                v_Token=a_TablaLexico.get(a_Recorrido-1);
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
                        a_Recorrido++;
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
        }else{
            Token v_Token = a_TablaLexico.get(a_Recorrido-1);
            a_Consola+="Error[]: No se declaro una variable \n";
            a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
            a_Error=true;
        }
    }
    
    private void m_tipoToken(String p_Palabra,Token p_Token){
        for(int v_indice=0;v_indice<a_TablaSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaSimbolos.get(v_indice);
            if(v_Temporal.m_getLexema().equals(p_Palabra)){
                v_Temporal.m_setTipo(p_Token.m_getIdToken());
                a_TablaSimbolos.set(v_indice,v_Temporal);
            }
        }
    }
    
    private void m_tipoLexema(String p_Palabra,Token p_Token){
        for(int v_indice=0;v_indice<a_TablaLexico.size();v_indice++){
            Token v_Temporal=a_TablaLexico.get(v_indice);
            if(v_Temporal.m_getLexema().equals(p_Palabra)){
                v_Temporal.m_setTipo(p_Token.m_getIdToken());
                a_TablaLexico.set(v_indice,v_Temporal);
            }
        }
    }
    
    private boolean m_buscaToken(String p_Palabra){
        boolean v_Bandera=true;
        for(int v_indice=0;v_indice<a_TablaSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaSimbolos.get(v_indice);
            if(v_Temporal.m_getLexema().equals(p_Palabra)){
                if(v_Temporal.m_getTipo()!=0)
                    v_Bandera=false;
                else
                    v_Bandera=true;
            }
        }
        return v_Bandera;
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
