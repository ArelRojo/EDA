package ejemplos.tema3;

import java.util.Locale;
import java.util.Scanner;

import librerias.estructurasDeDatos.deDispersion.TablaHash;
import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.modelos.Map;

public class Test3Map {

	public static void main(String[] args) {
		// Por simplicidad, la frase no se lee de un fichero,  
        // sino que se lee de teclado como un String de Palabras 
        // separadas por blancos. Una frase (String) ejemplo seria: 
        // "vale, aunque es un poco rollo lo hago para que se vea como funciona el Map!! Se me ha olvidado escribir palabras repetidas vaya!!"

        // Lectura de la frase (String) a partir de la que se construye el Map
        Locale localEDA = new Locale("es", "US");
        Scanner teclado = new Scanner(System.in).useLocale(localEDA);
        System.out.println("Escriba palabras separadas por blancos:");
        String texto = teclado.nextLine();
        
        // Creacion del Map vacio ... 
        // ?Que Clave y Valor tiene cada Entrada de este Map? 
		// ?De que tipos son? 
        Map<String, Integer> m = new TablaHash<String, Integer>(texto.length());
        
        // Construcción del Map, via insercion/actualizacion de sus Entradas, 
        // a partir de la frase leida: 
        // uso del método split de String con separador " " (uno o mas)
        String[] palabrasDelTexto = texto.split(" +");
        for (int i = 0; i < palabrasDelTexto.length; i++) {
            // OJO: LO MÁS BARATO SERIA 
		    // d.insertar(palabrasDelTexto[i].toLowerCase(), 
		    // palabrasDelTexto[i].toLowerCase());
        	int cont = 0;
        	for(int j = 0; j<palabrasDelTexto.length;j++) {
        		if(palabrasDelTexto[i].equals(palabrasDelTexto[j])){cont++;}
        	}
            m.insertar(palabrasDelTexto[i].toLowerCase(), cont); 
	}
        ListaConPI<String> deCLaves = m.claves();
        int res = 0;
        for(deCLaves.inicio(); !deCLaves.esFin(); deCLaves.siguiente()) {
        	res = m.recuperar(deCLaves.recuperar());
        	if(res > 1) {
        	System.out.println("Palabra " + deCLaves.recuperar() + " se repite " + res + " veces " );
        	}
        }
        

	}

}
