
package ejemplos.tema3;
import librerias.excepciones.*;

public class TestModuloAutorizacion {

    public static void main(String[] args) throws Exception {
        ModuloAutorizacion mA = new ModuloAutorizacion(10);
        // COMPLETAR
        mA.registrarUsuario("Lisa Saliasi", "x1999");
        mA.registrarUsuario("Francisco Jes�s P�rez Chavarr�a","x1986");
        mA.registrarUsuario("Sara Saliasi", "x1992");
        
        Thread.sleep(8000);
        
        
        System.out.println(mA.estaAutorizado("Lisa Saliasi","x1999"));
        System.out.println(mA.estaAutorizado("Francisco P�rez","x1986"));
        System.out.println(mA.estaAutorizado("Sara Saliasi", "x1993"));
        
        // COMPLETAR
        System.out.println(mA.fechaAcceso("Lisa Saliasi","x1999"));
        System.out.println(mA.fechaAcceso( "Francisco Jes�s P�rez Chavarr�a", "x1986"));
    }
}