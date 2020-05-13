package ejemplos.tema3;

import librerias.estructurasDeDatos.modelos.*;

import java.util.Locale;
import java.util.Scanner;

import librerias.estructurasDeDatos.deDispersion.*; 

public class AnalizadorDeTexto {
	  public static void main(String[] args) {	
	    	Locale localEDA = new Locale("es", "US");
	        Scanner teclado = new Scanner(System.in).useLocale(localEDA);
	        System.out.println("Escriba palabras separadas por blancos:");
	        String texto = teclado.nextLine();
	        
	        AnalizadorDeTexto t = new AnalizadorDeTexto(texto);
	        
	        System.out.println(t.frecuenciaMayorQue(5));
	        
	      
	    }

  

	protected Map<String, Integer> m;
    
    /** construye un Analizador del Texto t, considerando que   
     *  el separador de sus palabras es el espacio en blanco
     */
    public AnalizadorDeTexto(String t) {
        String[] palabras = t.split(" +");
        m = new TablaHash<String, Integer>(palabras.length);
        for (int i = 0; i < palabras.length; i++) { 
            String pal = palabras[i].toLowerCase();
            Integer frec = m.recuperar(pal); 
            if (frec != null) {
               frec++;
               m.insertar(pal, frec); 
            }
            else { m.insertar(pal, 1); }
        }
    }
    
   

    
    /** devuelve el nº de palabras con frecuencia de aparición mayor   
     *  que n que aparecen en el texto tratado por un Analizador.   
     *  Así, por ejemplo, si n=0 devuelve el número de palabras distintas  
     *  que aparecen en el texto; si n=1 devuelve el número de palabras  
     *  repetidas que tiene el texto, etc.
     */
    public int frecuenciaMayorQue(int n) {
        ListaConPI<String> deClaves = m.claves();
        int cont=0;
      
        for(deClaves.inicio(); !deClaves.esFin(); deClaves.siguiente()) {
        	  int res = m.recuperar(deClaves.recuperar());
        	  if(n<res) {
        		  cont++;
        	  }
        }
		return cont;
    }  

  
    
}