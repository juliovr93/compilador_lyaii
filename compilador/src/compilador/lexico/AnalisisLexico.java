/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.lexico;

import compilador.Token;
import java.util.ArrayList;

public class AnalisisLexico {
    
    private String a_codFuente;
    private String a_consola="";
    private int a_Linea=1;
    private ArrayList<Token> a_TablaDeSimbolos = new ArrayList<Token>();
    private boolean a_bdLexico=true;
    
    public AnalisisLexico(String p_codFuente){
        a_codFuente=p_codFuente;
        m_anaLexico();
    }
    
    private void m_anaLexico(){
        a_bdLexico=true;                                                    
        a_Linea=1;
        if(!"".equals(a_codFuente)){
            while(!"".equals(a_codFuente)){                                          
                a_codFuente=m_buscaLexema(a_codFuente);
            }
        }
        else{
            a_consola+="Error [150]: No hay codigo fuente\n";
            a_consola+="Error en la linea: "+a_Linea+"\n";
            a_bdLexico=false;
        }
    }
    
    private String m_SaltoLinea_Espacio(String p_codFuente){
        String v_codFuente=p_codFuente;
        boolean v_bandera=true;
        while(!"".equals(v_codFuente)&&v_bandera){                                    
            if(v_codFuente.charAt(0)==32){
                v_bandera=true;
                a_Linea++;
                v_codFuente=v_codFuente.substring(1,v_codFuente.length());
            }else{
                if(v_codFuente.charAt(0)==10){
                    v_bandera=true;
                    a_Linea++;
                    v_codFuente=v_codFuente.substring(1,v_codFuente.length());
                }else{
                    if(v_codFuente.charAt(0)==' '){
                        v_bandera=true;
                        v_codFuente=v_codFuente.substring(1,v_codFuente.length());
                    }else{
                        v_bandera=false;
                    }
                }
            }
        }
        return v_codFuente;
    }
    
    private String m_buscaLexema(String p_codFuente){
        int v_Recorrido=0,v_Indice=0;                                           // Variables de control para el recorrido del codigo fuente
        boolean v_Inserta=false;                                                // Bandera para control de insercion de token
        boolean v_errLexema=false;                                              // Bandera para control de error de lexemas
        
        /***************  Saltos de Linea y Espacios **************************/
        if(!"".equals(p_codFuente)){
            p_codFuente=m_SaltoLinea_Espacio(p_codFuente);
        }
        
        /*********************  Palabras Reservadas ***************************/
        if(!"".equals(p_codFuente)){
            PalabrasReservadas v_PalabrasReserv=new PalabrasReservadas();           // Llama a la clase PalabrasReservadas para detectar palabras reservadas en el código fuente
            v_Recorrido = v_PalabrasReserv.getPalabrasReservadas(p_codFuente);        // Manda llamar el metodo getPalabrasReservadas para regresar el numero de caracteres que componen a la palabra reservada
            if(0!=v_Recorrido){                                                     // Compara si recorrido del codigo fuente es diferente de 0
                m_addToken(p_codFuente.substring(0,v_Recorrido),3);                   // Si el recorrido es diferente de 0 encontro una palabra reservada y añade el token a la tabla de simbolos
                v_Inserta=true;                                                     // Cambia la bandera de control de insercion a cierto
                v_Indice=v_Recorrido;                                               // Sustrae el recorrigo del codigo fuente y lo guarda en v_Indice
            }
        }
        /********************  Operadores  ************************************/
        if(!"".equals(p_codFuente)){
            Operadores v_Operadores=new Operadores();                               // Llama a la clase Operadores para detectar operadores en el código fuente
            v_Recorrido = v_Operadores.getOperadores(p_codFuente);                    // Manda llamar el método getOperadores para regresar el número de caráceres que componen al operador
            if(0!=v_Recorrido){                                                     // Compara si recorrido del codigo fuente es diferente de 0
                m_addToken(p_codFuente.substring(0,v_Recorrido),2);                   // Si el recorrido es diferente de 0 encontro un operador y añade el token a la tabla de simbolos
                v_Inserta=true;                                                     // Cambia la bandera de control de insercion a cierto
                v_Indice=v_Recorrido;                                               // Sustrae el recorrigo del codigo fuente y lo guarda en v_Indice
            }
        }
        /*********************  Delimitadores  ********************************/
        if(!"".equals(p_codFuente)){
            Delimitadores v_Delimitadores=new Delimitadores();                      // Llama a la clase Delimitadores para detectar delimitadores en el código fuente
            v_Recorrido = v_Delimitadores.getDelimitadores(p_codFuente);              // Manda llamar el método getDelimitadores para regresar el número de carácteres que componen al delimitador
            if(0!=v_Recorrido){                                                     // Compara si recorrido del codigo fuente es diferente de 0
                m_addToken(p_codFuente.substring(0,v_Recorrido),1);                   // Si el recorrido es diferente de 0 encontro un delimitador y añade el token a la tabla de simbolos
                v_Inserta=true;                                                     // Cambia la bandera de control de insercion a cierto
                v_Indice=v_Recorrido;                                               // Sustrae el recorrigo del codigo fuente y lo guarda en v_Indice
            }        
        }
        /********************  Datos  *****************************************/
        if(!"".equals(p_codFuente)){
            Datos v_Datos=new Datos();                                              // Llama a la clase Datos para detectar los tipos de datos en el código fuente
            v_Recorrido = v_Datos.getDatos(p_codFuente);                              // Manda llamar el método getDatos para regresar el número de carácteres que componen al tipo de dato
            if(0!=v_Recorrido){                                                     // Compara si recorrido del código fuente es diferente de 0
                if(v_Recorrido>0){                                                  // Compara si el recorrido del código fue mayor a 0
                    m_addToken(p_codFuente.substring(0,v_Recorrido),5);               // Si el recorrido es mayor de 0 encontro un tipo de datos y añade el token a la tabla de simbolos
                    v_Inserta=true;                                                 // Cambia la bandera de control de insercion a cierto
                    v_Indice=v_Recorrido;                                           // Sustrae el recorrigo del codigo fuente y lo guarda en v_Indice
                    v_Recorrido=0;                                                  // Reinicia el valor del reco rrido a 0
                }
                else{
                    p_codFuente=p_codFuente.substring(0,v_Recorrido);                   // Si el recorrido es menor de 0 indica un error en los tipos de datos cadena
                    v_errLexema=true;                                               // Cambia la bandera v_errLexema a cierto
                }
            }              
        }
        /********************  Identificadores  *******************************/
        if(!"".equals(p_codFuente)){        
            Identificadores v_Ident=new Identificadores();                          // Llama a la clase Identificadores para detectar los tipos de datos en el código fuente
            v_Recorrido = v_Ident.getIndentificador(p_codFuente);                     // Manda llamar el método getIdentificadores para regresar el número de carácteres que componen al tipo de dato
            if(0!=v_Recorrido){                                                     // Compara si el recorrido del código fuente es diferente de 0
                m_addToken(p_codFuente.substring(0,v_Recorrido),4);                   // Si el recorrido es mayor de 0 encontro un identificador y añade el token a la tabla de simbolos
                v_Inserta=true;                                                     // Cambia la bandera de control de insercion a cierto
                v_Indice=v_Recorrido;                                               // Sustrae el recorrigo del codigo fuente y lo guarda en v_Indice
            }
        }
        /********************  Verificacion de Inserción   ********************/        
        if(v_Inserta){                                                          // Verifica que el léxema se haya insertado
            if(p_codFuente.length()!=0){
                if(v_Indice!=p_codFuente.length())                                    // Verifica que la palabra a analizar se haya termiando
                    p_codFuente=p_codFuente.substring(v_Indice,p_codFuente.length());     // Si no, recorta el codigo fuente a analizar
            }else{
                p_codFuente="";                                                   // Si el codigo fuente termina, lo inicializa a vacio
            }            
        }
        else{                                                                   // Si el léxema no se   inserto
            if(!"".equals(p_codFuente)){
                if(v_Indice!=p_codFuente.length()-1){                                 // Analiza que el indice tenga un valor diferente a 0
                    a_bdLexico=false;
                    if(v_errLexema){                                                    
                        a_consola+="Error [182]: Cadena no completada: '"+p_codFuente.charAt(0)+"'\n";
                        a_consola+="Error en la linea: "+a_Linea+"\n";
                    }else{
                        a_consola+="Error [180]: No se encuentra simbolo: ' "+p_codFuente.charAt(0)+" ' para cerrar cadena\n";
                        a_consola+="Error en la linea: "+a_Linea+"\n";
                        p_codFuente=p_codFuente.substring(1,p_codFuente.length());
                    }
                }
            }
            else{
                if(a_TablaDeSimbolos.size()==0){
                    a_consola+="Error [151]: No se encontro ningún lexéma\n";
                    a_consola+="Error en la linea: "+a_Linea+"\n";
                    a_bdLexico=false;
                }
            }
        }
        return p_codFuente;
    }
    
    private boolean m_buscaToken(String p_Palabra){
        boolean v_Bandera=false;
        for(int v_indice=0;v_indice<a_TablaDeSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaDeSimbolos.get(v_indice);
            if(v_Temporal.m_getLexema().equals(p_Palabra))
                v_Bandera=true;
        }
        return v_Bandera;
    }
    
    private void m_addToken(String p_Palabra,int p_Tipo){
        if(!m_buscaToken(p_Palabra)){
            int v_ID = a_TablaDeSimbolos.size()+1;
            Token v_newSimbolo = new Token(v_ID,p_Palabra,p_Tipo);
            a_TablaDeSimbolos.add(v_newSimbolo);
        }        
    }
    
    public ArrayList<Token> m_getTablaDeSimbolos(){
        return a_TablaDeSimbolos;
    }
    
    public String m_getConsola(){
        return a_consola;
    }
    
    public boolean m_getLexico(){
        return a_bdLexico;
    }
}
