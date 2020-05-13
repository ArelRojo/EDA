package ejemplos.tema3;

import java.util.Locale;
import java.util.Scanner;

import librerias.estructurasDeDatos.deDispersion.TablaHash;
import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.modelos.Map;

public class Test2Map {

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
        Map<String, String> m = new TablaHash<String, String>(texto.length());

        // Construcción del Map, via insercion/actualizacion de sus Entradas, 
        // a partir de la frase leida: 
        // uso del método split de String con separador " " (uno o mas)
        String[] palabrasDelTexto = texto.split(" +");
        for (int i = 0; i < palabrasDelTexto.length; i++) 
            // OJO: LO MÁS BARATO SERIA 
		    // d.insertar(palabrasDelTexto[i].toLowerCase(), 
		    // palabrasDelTexto[i].toLowerCase());
            m.insertar(palabrasDelTexto[i].toLowerCase(), ""); 
        
        // OJO: nos piden mostrar las palabras distintas que aparecen, 
        // que NO son las Entradas del Map sino SOLO sus claves
        ListaConPI<String> deClaves = m.claves();
        int cont = 0;
        for(deClaves.inicio(); !deClaves.esFin(); deClaves.siguiente()) {
        	cont++;
        }
        System.out.println("Palabras distintas que aparecen en el texto, "
			+ "i.e. Claves del Map:\n" + cont);
    } 
	}


