package Almacen;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

// Crear la clase Producto y completar los métodos

public class MiAlmacen
{
    static private ModeloAbs almacen;
    static Scanner sc;
    
    public static void main(String[] args){
        almacen=new ModeloArrayList ();
        almacen=new ModeloHashMap();
        sc = new Scanner(System.in);
        int opcion=0;
        do{
		mostrarMenu();
                opcion=leerOpcion(1,9);
                switch(opcion){
                    case 1: crear();break;
                    case 2: consultar();break;
                    case 3: borrar();break;
                    case 4: modificarPrecio();break;
                    case 5: comprar();break;
                    case 6: vender();break;
                    case 7: listar();break;
                    case 8: listarPocoStock();break;
                }
                System.out.println("\n---------------------------- ");
                System.out.print("Pulse enter para continuar");
                sc.nextLine();
        }while(opcion!=9);
        sc.close();
        
    }
    
    
    private static void mostrarMenu(){
        System.out.println("\n\n    MENU");
        System.out.println("1. Nuevo producto ");
        System.out.println("2. Consulta producto ");
        System.out.println("3. Borrar producto ");
        System.out.println("4. Modificar precio ");
        System.out.println("5. Compra de productos ");
        System.out.println("6. Venta de productos ");
        System.out.println("7. Listado completo de productos ");
        System.out.println("8. Listado de productos con stock inferior al mínimo");
        System.out.println("9. Terminar ");
        System.out.print("Elige una opción (1-9)");        
    }
    
    // Lee un entero del System.in que este comprendido entre primero y ultimo
    private static int leerOpcion(int primero, int ultimo){
        int valor = leerEntero();
        while ( valor <primero || valor > ultimo){
            valor = leerEntero();
        }
        return valor;
    }
      
    
    // Metodos Auxiliares leerFloat y LeerEntero, 
    // Lee de la System.in con el scanner sc y controlan la excepcion de NumberFormatException
    static private float leerFloat(){
        
        boolean error = false;
        float valor =0;
        String cadena;
        do {
        error = false;  
          try {
             // Intento leer directamente un entero  
             cadena = sc.nextLine();
             valor = Float.parseFloat(cadena);
             
            } catch(NumberFormatException n){
              System.out.println("Error en formato.");
              error = true;
            }
        }
       while (error);
       return valor;
    }
    
    static private int leerEntero(){
    	
    	boolean error = false;
    	int valor=0;
    	String str;
    	do {
    		error=false;
    			try {
    				str=sc.nextLine();
    				valor=Integer.parseInt(str);
    			}
    			catch(NumberFormatException n){
    				System.out.println("Error en formato.");
    				System.out.println("Intentalo otra vez");
    				error=true;
    			}
    	}
    	while(error);
    	return valor; 
    }
    
    // Muestra los datos de un producto a partir de su codigo
    
    private static void consultar(){        
    	System.out.print("Introduzca codigo:");
    	int codigo = leerEntero();
    	Producto p = almacen.buscarProducto(codigo);
    	if ( p == null){
    		System.out.println("El producto no se encuentra en almacen");
    	}
    	else {
    		System.out.println("PRODUCTO "+p);
    	}
    	
    }
    
    
    // Cambia el precio de un producto a partir de su codigo
    private static void modificarPrecio (){
    	System.out.println("Introduzca el codigo");
    	int codigo=leerEntero();
    	float precio=leerFloat();
    	almacen.buscarProducto(codigo).setPrecio(precio);
    }
    		
    // Incrementa el stock
    private static void comprar(){     
    	System.out.println("Introduzca codigo");
    	int codigo=leerEntero();
    	System.out.println("Introduzca la cantidad de productos a comprar");
    	int cantidadP=leerEntero();
    	try{
    		almacen.buscarProducto(codigo).setStock(cantidadP);
    	}
    	catch(NullPointerException n) {
    		System.out.println("El codigo no coincide con ningun producto de la lista");
    	}
    }
    
    // Decrementa el stock
    private static void vender(){
    	System.out.println("Introduzca codigo");
    	int codigo=leerEntero();
    	System.out.println("Introduzca la cantidad de productos a vender");
    	int cantidadP=leerEntero();
    	try{
    		almacen.buscarProducto(codigo).setStock(cantidadP);
    	}
    	catch(NullPointerException n) {
    		System.out.println("El codigo no coincide con ningun producto de la lista");
    	}
    		
    	
    }
    
    
    
    // Listado de todos los productos
    private static void listar(){        
    	almacen.listarProductos();
    }
    
    // Listado de todos los productos con stock inferior a stock minimo
    private static void listarPocoStock(){
    	almacen.listarPocoStock();
    }
    
    // Solicita datos al usuario para dar de alta un nuevo producto 
    // El codigo no se puede repetir
    private static void crear(){
    	System.out.println("<NUEVO PRODUCTO>");
    	int codigo=0;
    	String nombre="";
    	int Stock=0;
    	int minStock=0;
    	float precio=0;
    	System.out.println("Introduzca el nombre del producto");
    	nombre=sc.nextLine();
    	System.out.println("Introduzca el codigo para el producto");
    	codigo=leerEntero();
    	System.out.println("Introduzca el stock minimo");
    	minStock=leerEntero();
    	do{
    		System.out.println("Nota:el Stock no puede ser menor al Stock minimo");
    		System.out.println("Introduzca el stock");
    		Stock=leerEntero();
    	}
    	while(minStock>Stock);
    	System.out.println("Introzca el precio");
    	precio=leerFloat();
    	almacen.insertarProducto(new Producto(codigo,nombre,Stock,minStock,precio));
    }
    
    
    // Borrar un producto a partir de su codigo
    
    private static void borrar(){  
    	System.out.println("Introduzca el codigo del producto a borrar");
    	if(almacen.borrarProducto(leerEntero())){
    		System.out.println("Se ha borrado con exito");
    	}
    	else {
    		System.out.println("El producto no se ha podido borrar");
    	}
    }
}













  
    
    
    









    
    	
    		
    	
    	
