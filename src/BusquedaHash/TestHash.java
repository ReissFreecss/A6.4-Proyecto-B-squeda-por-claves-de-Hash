
package BusquedaHash;

import javax.swing.JOptionPane;


public class TestHash {
    public static void main(String[] args) {
        
        TablaHash hash = new TablaHash(50);
        
        
        String[]elementos= new String[50];
        generaValore(elementos);
        
        hash.funcionHash(elementos);
        hash.mostrar();
        String clave;
        
        do{
            clave=JOptionPane.showInputDialog("¿Clave a buscar?");
            String salida = hash.buscarClave(clave);
            System.out.println(salida);
        }while (clave.charAt(0)!='0');
        
    }
    
    public static void generaValore(String [] elementos){
        for (int i = 0; i < elementos.length; i++) {
            elementos[i]=""+ (int)(Math.random()*1000);
        }
        System.out.println("Elemento: ");
        for(String e: elementos){
            System.out.println(" "+e);
        }
        System.out.println();
    }

    
}
