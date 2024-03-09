/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebapractica2;
import java.util.Scanner;
/**
 *
 * @author guali
 */
public class libro {
    static Scanner leer = new Scanner(System.in);
    String Nombre;
    String Autor;
    String ID;
    String estado;
    String dueño;

    public libro(String Nombre, String Autor, String ID, String estado) {
        this.Nombre = Nombre;
        this.Autor = Autor;
        this.ID = ID;
        this.estado = estado;
        this.dueño = " ";
       
    }
    
    public void prestar(libro a){
        a.estado = "prestado";
        System.out.print("Ingrese nombre del dueño: ");
        a.dueño = leer.next();
    }
    
    public void regresar(libro a){
        a.estado = "disponible";
        a.dueño = " ";
    }

    @Override
    public String toString() {
        return "Nombre=" + Nombre + ", Autor=" + Autor + ", ID=" + ID + ", Estado=" + estado + ", Due\u00f1o=" + dueño;
    }
    
    
    
    
    
}
