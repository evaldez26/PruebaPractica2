/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebapractica2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author guali
 */
public class PruebaPractica2 {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner (System.in);
    static Random rand = new Random();
    public static ArrayList<libro> lista = new ArrayList();
     public static ArrayList<libro> prestados = new ArrayList();
      public static ArrayList<libro> disponibles = new ArrayList();
    public static libro book;
    public static void main(String[] args) {
        char resp = 's';
        while (resp == 's') {
            System.out.println("____________________Biblioteca____________________");
            System.out.print("1. Agregar libro\n2. Solicitar libro\n3. Regresar libro\n4. Buscar libro por nombre\n5. Listar libros disponibles\n6. Lista libros prestados\n7.Salir\nQue desea hacer: ");
            int opcion = leer.nextInt();
            System.out.println();
            switch(opcion){
                case 1:
                    agregar(lista);
                    System.out.println();
                    break;
                case 2:
                    solicitar(lista);
                    System.out.println();
                    break;
                case 3:
                    regresar(lista);
                    System.out.println();
                    break;
                case 4:
                    Buscar(lista);
                    break;
                case 5:
                    imprimir(disponibles);
                    break;
                case 6:
                    imprimir(prestados);
                    break;
                case 7:
                    System.out.println("Salio del programa");
                    resp = 'n';
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
                            
            }


        }

    }//fin del main
    public static ArrayList<libro> agregar(ArrayList<libro> a){
        System.out.print("Ingrese nombre del libro: ");
        leer.nextLine();
        String nombre = leer.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = leer.nextLine();
        String id = "";
        for(int i = 0; i<5;i++){
           int num = rand.nextInt(10);
           id += num;
        }
        book = new libro(nombre,autor,id,"disponible");
        a.add(book);
        disponibles.add(book);
        return a;       
    }
    
    public static ArrayList<libro> solicitar (ArrayList<libro> a){
        imprimir(lista);
       System.out.print("Ingrese la posicion del libro: ");
        int posicion = leer.nextInt();
        if(a.get(posicion).estado.equalsIgnoreCase("Disponible")){
            book = a.get(posicion);
               book.prestar(a.get(posicion));
               prestados.add(book);
               disponibles.remove(book);
            System.out.println("Disfrute su libro"); 
            }else{
                System.out.println("Libro no disponible");
            }
           
        return a;       
    }
    
    public static ArrayList<libro> regresar (ArrayList<libro> a){
        imprimir(lista);
        System.out.print("Ingrese la posicion del libro: ");
        int posicion = leer.nextInt();
        if(a.get(posicion).estado.equalsIgnoreCase("prestado")){
            book = a.get(posicion);
               book.regresar(a.get(posicion));
               prestados.remove(book);
               disponibles.add(book);
            System.out.println("EL libro fue regresado"); 
            }else{
                System.out.println("Este libro no ha sido prestado");
            }
           
        return a;       
    }
    
    public static void Buscar (ArrayList<libro> a){
        System.out.print("Ingrese nombre del libro: ");
        leer.nextLine();
        String nombre = leer.nextLine();
        for(int i = 0; i<a.size();i++){
         if(a.get(i).Nombre.equalsIgnoreCase(nombre)){
             book=a.get(i);
         }   
        }
        
        System.out.println(book);
    }
    
    public static void imprimir ( ArrayList<libro> array){
        for(int i = 0; i<array.size();i++){
            System.out.println("("+i+")"+array.get(i));
        }
    }
            

}
