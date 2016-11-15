/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */
package compilador.lexico;

public class PalabrasReservadas {
    
    public int getPalabrasReservadas(String p_Palabra){
        int v_Indice=0;
        if(start(p_Palabra)>0){
            v_Indice=start(p_Palabra);
        }
        else{
            if(end(p_Palabra)>0)
                v_Indice=end(p_Palabra);
            else{
                if(si(p_Palabra)>0)
                    v_Indice=si(p_Palabra);
                else{
                    if(cad(p_Palabra)>0)
                        v_Indice=cad(p_Palabra);
                    else{
                        if(ent(p_Palabra)>0)
                            v_Indice=ent(p_Palabra);
                        else{
                            if(mientras(p_Palabra)>0)
                                v_Indice=mientras(p_Palabra);
                            else{
                                if(imprime(p_Palabra)>0)
                                    v_Indice=imprime(p_Palabra);
                            }
                        }
                    }
                }
            }
        }
        return v_Indice;
    }
    
    //#start
    private int start(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_startQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    private int m_startQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='#'){
                v_Recorrido=m_startQ1(p_Palabra,1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='s'){
                v_Recorrido=m_startQ2(p_Palabra,2);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='t'){
                v_Recorrido=m_startQ3(p_Palabra,3);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='a'){
                v_Recorrido=m_startQ4(p_Palabra,4);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ4(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='r'){
                v_Recorrido=m_startQ5(p_Palabra,5);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ5(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='t'){
                v_Recorrido=m_startQ6(p_Palabra,6);
            }
        }
        return v_Recorrido;
    }
    
    private int m_startQ6(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=6;
            }
            if(p_Palabra.charAt(p_Index)==10){
                v_Recorrido=6;
            }
        }
        else{
            v_Recorrido=6;
        }
        return v_Recorrido;
    }
    
    //#end
    private int end(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_endQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    
    private int m_endQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='#'){
                v_Recorrido=m_endQ1(p_Palabra,1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_endQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='e'){
                v_Recorrido=m_endQ2(p_Palabra,2);
            }
        }
        return v_Recorrido;
    }
    
    private int m_endQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='n'){
                v_Recorrido=m_endQ3(p_Palabra,3);
            }
        }
        return v_Recorrido;
    }
    
    private int m_endQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='d'){
                v_Recorrido=m_endQ4(p_Palabra,4);
            }
        }
        return v_Recorrido;
    }
    
    private int m_endQ4(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=4;
            }
            if(p_Palabra.charAt(p_Index)==10){
                v_Recorrido=4;
            }
        }else{
            v_Recorrido=4;
        }
        return v_Recorrido;
    }
    
    //si - sino
    private int si(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_siQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    private int m_siQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='s'){
                v_Recorrido=m_siQ1(p_Palabra,1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_siQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='i'){
                v_Recorrido=m_siQ2(p_Palabra,2);
            }
        }
        return v_Recorrido;
    }
    
    private int m_siQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='('){
                v_Recorrido=2;
            }
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=2;
            }
            if(p_Palabra.charAt(p_Index)==10){
                v_Recorrido=2;
            }
            if(p_Palabra.charAt(p_Index)=='n'){
                v_Recorrido=m_siQ3(p_Palabra,3);
            }
        }else{
            v_Recorrido=2;
        }
        return v_Recorrido;
    }
    
    private int m_siQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='o'){
                v_Recorrido=m_siQ4(p_Palabra,4);
            }
        }
        return v_Recorrido;
    }
    
    private int m_siQ4(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='{'){
                v_Recorrido=4;
            }
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=4;
            }
            if(p_Palabra.charAt(p_Index)==10){
                v_Recorrido=4;
            }
        }else{
            v_Recorrido=4;
        }
        return v_Recorrido;
    }
    
    //ent
    private int ent(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_entQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    private int m_entQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='e'){
                v_Recorrido=m_entQ1(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_entQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='n'){
                v_Recorrido=m_entQ2(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_entQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='t'){
                v_Recorrido=m_entQ3(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_entQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=3;
            }
            if(p_Palabra.charAt(p_Index)==10){
                v_Recorrido=3;
            }
        }else{
            v_Recorrido=3;
        }
        return v_Recorrido;
    }
    
    //cad
    private int cad(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_cadQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    private int m_cadQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='c'){
                v_Recorrido=m_cadQ1(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_cadQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='a'){
                v_Recorrido=m_cadQ2(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_cadQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='d'){
                v_Recorrido=m_cadQ3(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
   
    private int m_cadQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=3;
            }
            if(p_Palabra.charAt(p_Index)==10){
                v_Recorrido=3;
            }
        }else{
            v_Recorrido=3;
        }
        return v_Recorrido;
    }
    
    //mientras
    private int mientras(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_mientrasQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    private int m_mientrasQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='m'){
                v_Recorrido=m_mientrasQ1(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='i'){
                v_Recorrido=m_mientrasQ2(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='e'){
                v_Recorrido=m_mientrasQ3(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
   
    private int m_mientrasQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='n'){
                v_Recorrido=m_mientrasQ4(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ4(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='t'){
                v_Recorrido=m_mientrasQ5(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ5(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='r'){
                v_Recorrido=m_mientrasQ6(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ6(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='a'){
                v_Recorrido=m_mientrasQ7(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ7(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='s'){
                v_Recorrido=m_mientrasQ8(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_mientrasQ8(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=8;
            }
            if(p_Palabra.charAt(p_Index)==10){
                v_Recorrido=8;
            }
            if(p_Palabra.charAt(p_Index)=='('){
                v_Recorrido=8;
            }
        }else{
            v_Recorrido=8;
        }
        return v_Recorrido;
    }
    
    //imprime
    private int imprime(String p_Palabra){
        int v_Recorrido=0;
        v_Recorrido=m_imprimeQ0(p_Palabra,0);
        return v_Recorrido;
    }
    
    private int m_imprimeQ0(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='i'){
                v_Recorrido=m_imprimeQ1(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ1(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='m'){
                v_Recorrido=m_imprimeQ2(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ2(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='p'){
                v_Recorrido=m_imprimeQ3(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ3(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='r'){
                v_Recorrido=m_imprimeQ4(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ4(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='i'){
                v_Recorrido=m_imprimeQ5(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ5(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='m'){
                v_Recorrido=m_imprimeQ6(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ6(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)=='e'){
                v_Recorrido=m_imprimeQ7(p_Palabra,p_Index+1);
            }
        }
        return v_Recorrido;
    }
    
    private int m_imprimeQ7(String p_Palabra,int p_Index){
        int v_Recorrido=0;
        if(p_Palabra.length()-1>=p_Index){
            if(p_Palabra.charAt(p_Index)==' '){
                v_Recorrido=7;
            }
            if(p_Palabra.charAt(p_Index)==10){
                v_Recorrido=7;
            }
            if(p_Palabra.charAt(p_Index)=='('){
                v_Recorrido=7;
            }
        }else{
            v_Recorrido=p_Index;
        }
        return v_Recorrido;
    }
}
