package BusquedaHash;

import java.util.Arrays;

public class TablaHash {
    //Declaracion de las varables y arreglo para  la tabla
    String [] arreglo;
    int tamaño,contador;

    //Constructor que recibe la tabla como parametro
    public TablaHash(int tam) {
        //Inicializamos los atributos
        tamaño= tam;
        //Construimos el arreglo vacio
        arreglo=new String [tam];
        //Llenamos el arreglo con un valor inicial
        Arrays.fill(arreglo, "-1");
    }
    
    //Funcion que recibe el conjunto de claves y les asigna un valor.
    public void funcionHash(String []cadenaArreglo){
        int i;
        //Iniciamos el ciclo para asignar a cada clave los valores
        for (i = 0;i<cadenaArreglo.length; i++) {
            //La clave se guarda en la variable elemento
            String elemento = cadenaArreglo[i];
            //Funcion que da el valor a la clave
            int indiceArreglo=Integer.parseInt(elemento)%(tamaño-1);
            System.out.println("El indice es "+indiceArreglo+" Para el elemento "+elemento);
            
            //Tratamiento de colisiones
            while (Integer.parseInt(arreglo[indiceArreglo])!=-1){
                //Incrementamos para buscar un espacio vacio en el arreglo
                indiceArreglo++;
                //Informamos del calbio
                System.out.println("Colision en el indice "+ (indiceArreglo -1)+ " Cambio al indice " +indiceArreglo);
                //Ajuste del valor para que sea concistente 0 (regresamos al principio del arreglo)
                indiceArreglo %= tamaño; 
            }
            //Guardamos la clave 
            arreglo[indiceArreglo]=elemento;
        }
    }
    
    
    //Metodo para buscar la clave en el arregl
    public String buscarClave(String elemento){
        //Obrenemos el indice del arreglo y lo guardamos
        int indiceArreglo=Integer.parseInt(elemento)%(tamaño-1);
        //Contamos las veces que pasamos por el arreglo
        contador = 0;
        
        //Mientras este ocupada la celda -1 preguntamos
        while(Integer.parseInt(arreglo[indiceArreglo])!=-1){
            //¿Esa posicion del elemento es igual a la clave?
            if(arreglo[indiceArreglo].equals(elemento)){
                //Si es asi imprimimo el indice correspondiente
                System.out.println("El elemento "+ elemento+" Fue encontrado en el indice "+indiceArreglo);
                return arreglo[indiceArreglo];
            }
            //Si el elemento no se encontro continuamos avanzando buscando
            indiceArreglo++;
            indiceArreglo %=tamaño;
            contador++;
            //Si el contador es menor al tamaño menos uno, no se encontro el dato
            if(contador > (tamaño-1)){
                break;
            }
        }
        return "La clave del elemento "+elemento+" NO fue encontrada";
    }
    
    //Imprimimos la tabla con las claves y elementos guadados 
    public void mostrar(){
        int incremento=0, i, j;
        for (i = 0; i < 1; i++) {
            incremento+=50;//Debe de ser deacuerdo al numero de elementos
            for (j = 0;j<250; j++) {
                System.out.print("-");
            } 
            System.out.println();
            for(j=incremento-50; j<incremento; j++){
                System.out.format("|%3s"+" ",j);
            }
            System.out.println("|");
            for(int n=0; n<250; n++){
                System.out.print("-");
            }
            System.out.println();
            for(j=incremento-50; j<incremento; j++){
                if(arreglo[j].equals("-1")){
                    System.out.print("|");
                }else{
                    System.out.print(String.format("|%3s"+" ", arreglo[j]));
                }
            }
            System.out.println("|");
            for(j=0; j<250; j++){
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
