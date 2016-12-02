/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.sintactico;

import compilador.Token;
import java.util.ArrayList;

public class Linea {
    private ArrayList <Token> a_TablaLexico;
    private ArrayList <Token> a_TablaSimbolos;
    private int a_Recorrido;
    private String a_Consola="";
    private boolean a_Error=false;
    
    
    public Linea (ArrayList <Token> p_TablaLexico,ArrayList <Token> p_TablaSimbolos,int p_Recorrido,String p_Consola){
        a_TablaLexico=p_TablaLexico;
        a_TablaSimbolos=p_TablaSimbolos;
        a_Recorrido=p_Recorrido;
        a_Consola=p_Consola;
        m_Linea();
    }
    
    private void m_Linea(){
        if(a_TablaLexico.size()>a_Recorrido){
            Token v_Token = a_TablaLexico.get(a_Recorrido);
            //Crear una variable
            if(v_Token.m_getIdToken()==56||v_Token.m_getIdToken()==57){
                a_Recorrido++;
                CreaVariable o_creaVariable = new CreaVariable(a_TablaLexico,a_TablaSimbolos,a_Recorrido,a_Consola);
                a_Consola=o_creaVariable.m_getConsola();
                a_Recorrido=o_creaVariable.m_getRecorrido();
                a_TablaSimbolos=o_creaVariable.m_getTabla();
                a_TablaLexico=o_creaVariable.m_getLexico();
                if(o_creaVariable.m_getError())
                    a_Error=true;
            }else{
                if(v_Token.m_getIdToken()==12){
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
                    if(v_Token.m_getIdToken()==16||v_Token.m_getIdToken()==17){
                        if(a_TablaLexico.size()>a_Recorrido+1){
                            a_Recorrido++;
                            v_Token = a_TablaLexico.get(a_Recorrido);
                            if(v_Token.m_getIdToken()==58){
                                if(a_TablaLexico.size()>a_Recorrido+1){
                                    a_Recorrido++;
                                    v_Token = a_TablaLexico.get(a_Recorrido);
                                    Condicion o_Condicion = new Condicion(a_TablaLexico,a_TablaSimbolos, a_Recorrido, a_Consola);
                                    a_Recorrido=o_Condicion.m_getRecorrido();
                                    a_Consola=o_Condicion.m_getConsola();
                                    if(o_Condicion.m_getError())
                                        a_Error=true;
                                    if(a_TablaLexico.size()>a_Recorrido){                                        
                                        v_Token = a_TablaLexico.get(a_Recorrido);
                                        if(v_Token.m_getIdToken()==59){
                                            if(a_TablaLexico.size()>a_Recorrido+1){
                                                a_Recorrido++;
                                                v_Token = a_TablaLexico.get(a_Recorrido);
                                                if(v_Token.m_getIdToken()==60){
                                                    if(a_TablaLexico.size()>a_Recorrido+1){
                                                        a_Recorrido++;
                                                        BloqueCodigo o_bloqueCodigo=new BloqueCodigo(a_TablaLexico,a_TablaSimbolos,a_Recorrido,a_Consola);
                                                        a_Consola=o_bloqueCodigo.m_getConsola();
                                                        a_Recorrido=o_bloqueCodigo.m_getRecorrido();
                                                        a_TablaSimbolos=o_bloqueCodigo.m_getTabla();
                                                        a_TablaLexico=o_bloqueCodigo.m_getLexico();
                                                        if(o_bloqueCodigo.m_getError())
                                                            a_Error=true;
                                                        if(a_TablaLexico.size()>a_Recorrido){
                                                            v_Token = a_TablaLexico.get(a_Recorrido);
                                                            if(v_Token.m_getIdToken()==61){
                                                                a_Recorrido++;
                                                            }else{
                                                                a_Consola+="Error[]: Falta declarar '}' \n";
                                                                a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                                                a_Error=true;
                                                            }
                                                        }else{
                                                            v_Token=a_TablaLexico.get(a_Recorrido-1);
                                                            a_Consola+="Error[]: Falta declarar '}' \n";
                                                            a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                                            a_Error=true;
                                                        }
                                                    }
                                                }else{
                                                    a_Consola+="Error[]: Falta declarar '{' \n";
                                                    a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                                    a_Error=true;
                                                }
                                            }else{
                                                v_Token=a_TablaLexico.get(a_Recorrido-1);
                                                a_Consola+="Error[]: Falta declarar '{' \n";
                                                a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                                a_Error=true;
                                            }
                                        }else{
                                            a_Consola+="Error[]: Falta declarar ')' \n";
                                            a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                            a_Error=true;
                                        }
                                    }else{       
                                        v_Token=a_TablaLexico.get(a_Recorrido-1);
                                        a_Consola+="Error[]: Falta declarar ')' \n";
                                        a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                        a_Error=true;
                                    }
                                }
                            }else{
                                a_Consola+="Error[]: Falta declarar '(' \n";
                                a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                a_Error=true;
                            }
                        }else{
                            v_Token=a_TablaLexico.get(a_Recorrido-1);
                            a_Consola+="Error[]: No se declaro condicion \n";
                            a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                            a_Error=true;
                        }
                    }else{
                        if(v_Token.m_getIdToken()==32){
                            if(a_TablaLexico.size()>a_Recorrido+1){
                                a_Recorrido++;
                                v_Token = a_TablaLexico.get(a_Recorrido);
                                
                                if(v_Token.m_getIdToken()==58){
                                    if(a_TablaLexico.size()>a_Recorrido+1){
                                        a_Recorrido++;
                                        v_Token = a_TablaLexico.get(a_Recorrido);
                                        Expresion o_Expresion = new Expresion(a_TablaLexico,a_TablaSimbolos, a_Recorrido, a_Consola,0);
                                        a_Recorrido=o_Expresion.m_getRecorrido();
                                        a_Consola=o_Expresion.m_getConsola();
                                        if(o_Expresion.m_getError())
                                            a_Error=true;
                                        
                                        if(a_TablaLexico.size()>a_Recorrido){
                                            v_Token = a_TablaLexico.get(a_Recorrido);
                                            if(v_Token.m_getIdToken()==59){
                                                if(a_TablaLexico.size()>a_Recorrido+1){
                                                    a_Recorrido++;
                                                    v_Token = a_TablaLexico.get(a_Recorrido);
                                                    if(v_Token.m_getIdToken()==62){
                                                        a_Recorrido++;
                                                    }else{
                                                        a_Consola+="Error[]: Falta declarar ';' \n";
                                                        a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                                        a_Error=true;
                                                    }
                                                }else{
                                                    v_Token = a_TablaLexico.get(a_Recorrido-1);
                                                    a_Consola+="Error[]: Falta declarar ';' \n";
                                                    a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                                    a_Error=true;
                                                }
                                                
                                            }else{
                                                a_Consola+="Error[]: Falta declarar ')' \n";
                                                a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                                a_Error=true;
                                            }
                                        }else{
                                            v_Token = a_TablaLexico.get(a_Recorrido-1);
                                            a_Consola+="Error[]: Falta declarar ')' \n";
                                            a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                            a_Error=true;
                                        }
                                        
                                    }
                                }else{
                                    a_Consola+="Error[]: Falta declarar '(' \n";
                                    a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                    a_Error=true;
                                }
                                    
                            }else{
                                v_Token = a_TablaLexico.get(a_Recorrido-1);
                                a_Consola+="Error[]: Falta declarar ')' \n";
                                a_Consola+="Error en la linea: "+v_Token.m_getNoLinea()+" \n";                                
                                a_Error=true;
                            }
                        }else{
                            a_Recorrido++;
                        }
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
    
    public ArrayList <Token> m_getTabla(){
        return a_TablaSimbolos;
    }
    
    public ArrayList <Token> m_getLexico(){
        return a_TablaLexico;
    }
}
