/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.lexico;

public class PalabrasReservadas {
    
    public int getPalabrasReservadas(String p_codFuente){                       // Metodo para buscar una palabra reservada
        String v_codFuente=p_codFuente;                                         // Pasa el codigo fuente en una variable 
        int v_Indice=0;                                                         // El indice se inicia con 0
        v_Indice=m_start(v_codFuente);                                          // Busca la palabra reservada #start
        if(v_Indice==0){                                                        // 
            v_Indice=m_end(v_codFuente);
            if(v_Indice==0){
                v_Indice=m_si(v_codFuente);
                if(v_Indice==0){
                    v_Indice=m_cad(v_codFuente);
                    if(v_Indice==0){
                        v_Indice=m_ent(v_codFuente);
                        if(v_Indice==0){
                            v_Indice=m_mientras(v_codFuente);
                            if(v_Indice==0){
                                v_Indice=m_imprime(v_codFuente);
                            }
                        }
                    }
                }
            }
        }        
        return v_Indice;
    }
    
    //#start
    private int m_start(String p_codFuente){
        int v_Recorrido=0;
        v_Recorrido=m_startQ0(p_codFuente);
        return v_Recorrido;
    }
    
    private int m_startQ0(String p_codFuente){
        int v_Recorrido=0;
        if(p_codFuente.charAt(0)=='s'){
            v_Recorrido=m_startQ1(p_codFuente.substring(1));
        }
        return v_Recorrido;
    }
    
    private int m_startQ1(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='t'){
                v_Recorrido=m_startQ2(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ2(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='a'){
                v_Recorrido=m_startQ3(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ3(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='r'){
                v_Recorrido=m_startQ4(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ4(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='t'){
                v_Recorrido=m_startQ5(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ5(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)==' '){
                v_Recorrido=5;
            }
            if(p_codFuente.charAt(0)==10){
                v_Recorrido=5;
            }
            if(p_codFuente.charAt(0)<48||p_codFuente.charAt(0)>57&&
               p_codFuente.charAt(0)<65||p_codFuente.charAt(0)>90&&
               p_codFuente.charAt(0)<97||p_codFuente.charAt(0)>122)
                v_Recorrido=5;
        }else{
            v_Recorrido=5;
        }
        return v_Recorrido;
    }      
   
    //#end
    private int m_end(String p_codFuente){
        int v_Recorrido=0;
        v_Recorrido=m_endQ0(p_codFuente);
        return v_Recorrido;
    }
    
    
    private int m_endQ0(String p_codFuente){
        int v_Recorrido=0;
        if(p_codFuente.charAt(0)=='e'){
            v_Recorrido=m_endQ1(p_codFuente.substring(1));
        }
        return v_Recorrido;
    }
    
    private int m_endQ1(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='n'){
                v_Recorrido=m_endQ2(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    
    private int m_endQ2(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='d'){
                v_Recorrido=m_endQ3(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_endQ3(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)==' '){
                v_Recorrido=3;
            }
            if(p_codFuente.charAt(0)==10){
                v_Recorrido=3;
            }
            if(p_codFuente.charAt(0)<48||p_codFuente.charAt(0)>57&&
               p_codFuente.charAt(0)<65||p_codFuente.charAt(0)>90&&
               p_codFuente.charAt(0)<97||p_codFuente.charAt(0)>122)
                v_Recorrido=3;
        }else{
            v_Recorrido=3;
        }
        return v_Recorrido;
    }      
    
    //si - sino
    private int m_si(String p_codFuente){
        int v_Recorrido=0;
        v_Recorrido=m_siQ0(p_codFuente);
        return v_Recorrido;
    }
    
    private int m_siQ0(String p_codFuente){
        int v_Recorrido=0;
        if(p_codFuente.charAt(0)=='s'){
            v_Recorrido=m_siQ1(p_codFuente.substring(1));
        }
        return v_Recorrido;
    }
    
    private int m_siQ1(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='i'){
                v_Recorrido=m_siQ2(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_siQ2(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)==' '){
                v_Recorrido=2;
            }
            if(p_codFuente.charAt(0)==10){
                v_Recorrido=2;
            }
            if(p_codFuente.charAt(0)=='n'){
                v_Recorrido=m_siQ3(p_codFuente.substring(1));
            }else{
                if(p_codFuente.charAt(0)<48||p_codFuente.charAt(0)>57&&
                   p_codFuente.charAt(0)<65||p_codFuente.charAt(0)>90&&
                   p_codFuente.charAt(0)<97||p_codFuente.charAt(0)>122)
                    v_Recorrido=2;
            }
        }else{
            v_Recorrido=2;
        }
        return v_Recorrido;
    }
    
    private int m_siQ3(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='o'){
                v_Recorrido=m_siQ4(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_siQ4(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)==' '){
                v_Recorrido=4;
            }
            if(p_codFuente.charAt(0)==10){
                v_Recorrido=4;
            }else{
                if(p_codFuente.charAt(0)<48||p_codFuente.charAt(0)>57&&
                   p_codFuente.charAt(0)<65||p_codFuente.charAt(0)>90&&
                   p_codFuente.charAt(0)<97||p_codFuente.charAt(0)>122)
                    v_Recorrido=4;
            }
        }else{
            v_Recorrido=4;
        }
        return v_Recorrido;
    }
    
    //ent
    private int m_ent(String p_codFuente){
        int v_Recorrido=0;
        v_Recorrido=m_entQ0(p_codFuente);
        return v_Recorrido;
    }
    
    
    private int m_entQ0(String p_codFuente){
        int v_Recorrido=0;
        if(p_codFuente.charAt(0)=='e'){
            v_Recorrido=m_entQ1(p_codFuente.substring(1));
        }
        return v_Recorrido;
    }
    
    private int m_entQ1(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='n'){
                v_Recorrido=m_entQ2(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    
    private int m_entQ2(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='t'){
                v_Recorrido=m_entQ3(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_entQ3(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)==' '){
                v_Recorrido=3;
            }
            if(p_codFuente.charAt(0)==10){
                v_Recorrido=3;
            }
            if(p_codFuente.charAt(0)<48||p_codFuente.charAt(0)>57&&
               p_codFuente.charAt(0)<65||p_codFuente.charAt(0)>90&&
               p_codFuente.charAt(0)<97||p_codFuente.charAt(0)>122)
                v_Recorrido=3;
        }else{
            v_Recorrido=3;
        }
        return v_Recorrido;
    }
    
    //cad
    private int m_cad(String p_codFuente){
        int v_Recorrido=0;
        v_Recorrido=m_cadQ0(p_codFuente);
        return v_Recorrido;
    }
    
    
    private int m_cadQ0(String p_codFuente){
        int v_Recorrido=0;
        if(p_codFuente.charAt(0)=='c'){
            v_Recorrido=m_cadQ1(p_codFuente.substring(1));
        }
        return v_Recorrido;
    }
    
    private int m_cadQ1(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='a'){
                v_Recorrido=m_cadQ2(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    
    private int m_cadQ2(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='d'){
                v_Recorrido=m_cadQ3(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_cadQ3(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)==' '){
                v_Recorrido=3;
            }
            if(p_codFuente.charAt(0)==10){
                v_Recorrido=3;
            }
            if(p_codFuente.charAt(0)<48||p_codFuente.charAt(0)>57&&
               p_codFuente.charAt(0)<65||p_codFuente.charAt(0)>90&&
               p_codFuente.charAt(0)<97||p_codFuente.charAt(0)>122)
                v_Recorrido=3;
        }else{
            v_Recorrido=3;
        }
        return v_Recorrido;
    }
    
    //mientras
    private int m_mientras(String p_codFuente){
        int v_Recorrido=0;
        v_Recorrido=m_mientrasQ0(p_codFuente);
        return v_Recorrido;
    }
    
    private int m_mientrasQ0(String p_codFuente){
        int v_Recorrido=0;
        if(p_codFuente.charAt(0)=='m'){
            v_Recorrido=m_mientrasQ1(p_codFuente.substring(1));
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ1(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='i'){
                v_Recorrido=m_mientrasQ2(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ2(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='e'){
                v_Recorrido=m_mientrasQ3(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
   
    private int m_mientrasQ3(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='n'){
                v_Recorrido=m_mientrasQ4(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ4(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='t'){
                v_Recorrido=m_mientrasQ5(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ5(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='r'){
                v_Recorrido=m_mientrasQ6(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ6(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='a'){
                v_Recorrido=m_mientrasQ7(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ7(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='s'){
                v_Recorrido=m_mientrasQ8(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ8(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)==' '){
                v_Recorrido=8;
            }
            if(p_codFuente.charAt(0)==10){
                v_Recorrido=8;
            }
            if(p_codFuente.charAt(0)<48||p_codFuente.charAt(0)>57&&
               p_codFuente.charAt(0)<65||p_codFuente.charAt(0)>90&&
               p_codFuente.charAt(0)<97||p_codFuente.charAt(0)>122)
                v_Recorrido=8;
        }else{
            v_Recorrido=8;
        }
        return v_Recorrido;
    }
    
    //imprime
    private int m_imprime(String p_codFuente){
        int v_Recorrido=0;
        v_Recorrido=m_imprimeQ0(p_codFuente);
        return v_Recorrido;
    }
    
    private int m_imprimeQ0(String p_codFuente){
        int v_Recorrido=0;
        if(p_codFuente.charAt(0)=='i'){
            v_Recorrido=m_imprimeQ1(p_codFuente.substring(1));
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ1(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='m'){
                v_Recorrido=m_imprimeQ2(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ2(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='p'){
                v_Recorrido=m_imprimeQ3(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ3(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='r'){
                v_Recorrido=m_imprimeQ4(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ4(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='i'){
                v_Recorrido=m_imprimeQ5(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ5(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='m'){
                v_Recorrido=m_imprimeQ6(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ6(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)=='e'){
                v_Recorrido=m_imprimeQ7(p_codFuente.substring(1));
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ7(String p_codFuente){
        int v_Recorrido=0;
        if(!"".equals(p_codFuente)){
            if(p_codFuente.charAt(0)==' '){
                v_Recorrido=7;
            }
            if(p_codFuente.charAt(0)==10){
                v_Recorrido=7;
            }
            if(p_codFuente.charAt(0)<48||p_codFuente.charAt(0)>57&&
               p_codFuente.charAt(0)<65||p_codFuente.charAt(0)>90&&
               p_codFuente.charAt(0)<97||p_codFuente.charAt(0)>122)
                v_Recorrido=7;
        }else{
            v_Recorrido=7;
        }
        return v_Recorrido;
    }
}