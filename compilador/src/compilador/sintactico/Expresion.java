/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class Expresion {
    
    private ArrayList <Token> a_TablaLexico;
    private ArrayList <Token> a_TablaSimbolos;
    private int a_Recorrido;
    private int a_Valor;
    private String a_Consola="";
    private boolean a_Error=false;
    
    public Expresion(ArrayList <Token> p_TablaLexico,ArrayList <Token> p_TablaSimbolos,int p_Recorrido,String p_Consola,int p_Valor){
        a_TablaLexico=p_TablaLexico;
        a_TablaSimbolos=p_TablaSimbolos;
        a_Recorrido=p_Recorrido;
        a_Consola=p_Consola;
        a_Valor=p_Valor;
        m_Expresion();
        System.out.println("");
    }
    
    private void m_Expresion(){
        if(a_TablaLexico.size()>a_Recorrido){
            Token v_Token=a_TablaLexico.get(a_Recorrido);
            if(v_Token.m_getIdToken()==2||v_Token.m_getIdToken()==3||v_Token.m_getIdToken()==12){
                if(a_TablaLexico.size()>a_Recorrido+1){
                    a_Recorrido++;
                    v_Token=a_TablaLexico.get(a_Recorrido);
                    if(v_Token.m_getIdToken()==5){
                        if(a_TablaLexico.size()>a_Recorrido+1){
                            a_Recorrido++;
                            Expresion o_Expresion = new Expresion(a_TablaLexico,a_TablaSimbolos,a_Recorrido, a_Consola,a_Valor++);
                            a_Recorrido=o_Expresion.m_getRecorrido();
                            a_Consola=o_Expresion.m_getConsola();
                            a_Valor=o_Expresion.m_getValor();
                            if(o_Expresion.m_getError())
                                a_Error=true;
                        }
                    }else{
                        if(v_Token.m_getIdToken()==6){
                            if(a_TablaLexico.size()>a_Recorrido+1){
                                a_Recorrido++;
                                Expresion o_Expresion = new Expresion(a_TablaLexico,a_TablaSimbolos,a_Recorrido, a_Consola,a_Valor++);
                                a_Recorrido=o_Expresion.m_getRecorrido();
                                a_Consola=o_Expresion.m_getConsola();
                                a_Valor=o_Expresion.m_getValor();
                                if(o_Expresion.m_getError())
                                    a_Error=true;
                            }
                        }else{
                            if(v_Token.m_getIdToken()==7){
                                if(a_TablaLexico.size()>a_Recorrido+1){
                                    a_Recorrido++;
                                    Expresion o_Expresion = new Expresion(a_TablaLexico,a_TablaSimbolos,a_Recorrido, a_Consola,a_Valor++);
                                    a_Recorrido=o_Expresion.m_getRecorrido();
                                    a_Consola=o_Expresion.m_getConsola();
                                    a_Valor=o_Expresion.m_getValor();
                                    if(o_Expresion.m_getError())
                                        a_Error=true;
                                }
                            }else{
                                if(v_Token.m_getIdToken()==8){
                                    if(a_TablaLexico.size()>a_Recorrido+1){
                                        a_Recorrido++;
                                        Expresion o_Expresion = new Expresion(a_TablaLexico,a_TablaSimbolos,a_Recorrido, a_Consola,a_Valor++);
                                        a_Recorrido=o_Expresion.m_getRecorrido();
                                        a_Consola=o_Expresion.m_getConsola();
                                        a_Valor=o_Expresion.m_getValor();
                                        if(o_Expresion.m_getError())
                                            a_Error=true;
                                    }
                                }else{
                                    if(a_Valor==0){
                                        Token v_Temp = a_TablaLexico.get(a_Recorrido-3);
                                        if(v_Temp.m_getIdToken()==12){
                                            Token v_Valor= a_TablaLexico.get(a_Recorrido-1);
                                            v_Temp.m_setValor(v_Valor.m_getNoToken());
                                            a_TablaLexico.set(a_Recorrido-3, v_Temp);
                                            
                                            m_valorToken(v_Temp.m_getLexema(),v_Valor.m_getLexema());
                                        }
                                        System.out.println("");
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                if(v_Token.m_getIdToken()==58){
                    if(a_TablaLexico.size()>a_Recorrido+1){
                        a_Recorrido++;
                        v_Token=a_TablaLexico.get(a_Recorrido);
                        Expresion o_Expresion = new Expresion(a_TablaLexico,a_TablaSimbolos,a_Recorrido, a_Consola,a_Valor++);
                        a_Valor=o_Expresion.m_getValor();
                        a_Recorrido=o_Expresion.m_getRecorrido();
                        a_Consola=o_Expresion.m_getConsola();
                        if(o_Expresion.m_getError())
                                a_Error=true;
                        if(a_TablaLexico.size()>a_Recorrido){
                            v_Token=a_TablaLexico.get(a_Recorrido);
                            if(v_Token.m_getIdToken()==59){
                                a_Recorrido++;
                            }else{
                                a_Consola+="Error[]: Falta cerrar expresion ')' \n";
                                a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
                                a_Error=true;
                            }
                        }else{
                            v_Token=a_TablaLexico.get(a_Recorrido-1);
                            a_Consola+="Error[]: Falta cerrar expresion ')' \n";
                            a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
                            a_Error=true;
                        }
                    }
                }else{
                    a_Consola+="Error[]: No se declaro un valor \n";
                    a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
                    a_Error=true;
                }
            }
        }else{
            Token v_Token=a_TablaLexico.get(a_Recorrido-1);
            a_Consola+="Error[]: No se declaro un valor \n";
            a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";
            a_Error=true;
        }
    }
    
    private void m_valorToken(String p_Identificador,String p_Valor){
        for(int v_indice1=0;v_indice1<a_TablaSimbolos.size();v_indice1++){
            Token v_Temporal1=a_TablaSimbolos.get(v_indice1);
            if(v_Temporal1.m_getLexema().equals(p_Identificador)){
                
                for(int v_indice2=0;v_indice2<a_TablaSimbolos.size();v_indice2++){
                    Token v_Temporal2=a_TablaSimbolos.get(v_indice2);
                    if(v_Temporal2.m_getLexema().equals(p_Valor)){
                        
                        v_Temporal1.m_setValor(v_Temporal2.m_getNoToken());
                        a_TablaSimbolos.set(v_indice1,v_Temporal1);
                        
                    }
                }
                
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
    
    public int m_getValor(){
        return a_Valor;
    }
    
    public ArrayList <Token> m_getTabla(){
        return a_TablaSimbolos;
    }
    
    public ArrayList <Token> m_getLexico(){
        return a_TablaLexico;
    }
}