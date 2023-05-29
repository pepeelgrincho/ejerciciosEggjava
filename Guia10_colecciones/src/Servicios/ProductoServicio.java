/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Producto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class ProductoServicio {
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private HashMap<String,Producto> listaProductos = new HashMap<String,Producto>();
  
    

    /*public ProductoServicio() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.listaProductos = new HashMap<String,Producto>();
    }    */
    
    public void menu() {
        int opcion = 10;
        String codigo;
        Double precio;
        
        while (opcion != 0) {
            System.out.println("Introduce el numero de la opción que quieras:");
            System.out.println("1.- Introducir producto");
            System.out.println("2.- Modificar precio");
            System.out.println("3.- Eliminar producto");
            System.out.println("4.- Mostrar los productos");
            System.out.println("0.- Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el códido del producto:");
                    codigo = sc.next();
                    System.out.println("Introduce el precio del producto:");
                    precio = sc.nextDouble();
                    guardarProducto(codigo, precio);
                    break;
                case 2:
                    System.out.println("Introduce el códido del producto del que quieres cambiar el precio:");
                    codigo = sc.next();
                    modificaPrecio(codigo);
                    break;
                case 3:
                    System.out.println("Introduce el códido del producto que quieres eliminar:");
                    codigo = sc.next();
                    eliminaProducto(codigo);
                    break;
                case 4:
                    mostrarProductos();
                    break;
                case 0:
                    System.out.println("saliendo...");
                    break;
                default:
                    System.out.println("Tienes que introducir una opción valida");
            }

        }
    }
    
    private void guardarProducto(String codigo, Double precio) {
        if (listaProductos.containsKey(codigo)) {
            System.out.println("No se puede introducir el producto. El código esta repetido.");
        } else {
            listaProductos.put(codigo, new Producto(codigo, precio));
        }
    }
    
    private void modificaPrecio(String codigo) {
        if (listaProductos.containsKey(codigo)) {
            System.out.println("Introduce el precio del producto:");
            Producto p = new Producto(codigo,sc.nextDouble());
            
            listaProductos.put(codigo, p);
        } else {
            System.out.println("No hay ningun producto con ese código.");
        }
    }
             
                        
                        
    private void eliminaProducto(String codigo){
        if (listaProductos.containsKey(codigo)) {
            listaProductos.remove(codigo);
            System.out.println("el producto a sido eliminado correctamente");
        } else {
            System.out.println("No hay ningun producto con ese código.");
        }
    }
                        
    private void mostrarProductos(){
        
        if (listaProductos.size()!=0){
        listaProductos.forEach((codigo,Producto) -> System.out.println("codigo :" + codigo + "  precio : " + Producto.getValor()));}
        else System.out.println("no hay productos ingresados ");
    }

}

