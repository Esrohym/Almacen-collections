package Almacen;
/**
 * Implementa la parte de Modelo de Datow
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class ModeloArrayList extends ModeloAbs
{
    private ArrayList <Producto> lista;
    
    public ModeloArrayList()
    {
       lista=new ArrayList <Producto>();
    }

    // Implementar los metodos abstractos de ModeloAbs
    public boolean insertarProducto ( Producto p){
    	lista.add(p);
    	return true;    
    }
    	
 
    public boolean borrarProducto (int codigo){
    	Producto aux=(buscarProducto(codigo));
    	lista.remove(aux);
    	return (aux==null);
    	
    }
    	
      
    public Producto buscarProducto ( int codigo) {
    	   	
    	for(Producto productos:lista){
    		if(productos.getCodigo()==codigo) {
    			return productos;
    		}
    	}
    	return null;	
    }
    	
    public void listarProductos (){
		System.out.printf("%s\t%s\n","Codigo","Nombre");
    	for(Producto productos:lista) {
    		System.out.printf("%s\t%s\n",productos.getCodigo(),productos.getNombre());
    	}
    }

    public boolean modificarProducto (Producto nuevo){
    	return false;
    }
    
    public void listarPocoStock() {
    	System.out.printf("%s\t%s\n","Codigo","Nombre");
    	for(Producto productos:lista) {
    		if(productos.getStock()<productos.getStock_min()){
    			System.out.printf("%s\t%s\n",productos.getCodigo(),productos.getNombre());
    		}
    	}
    }
    		
    	
    
    	
	   
	   
    
    			
    		
    		
    	
    	
    	
    	
    
    
    
    
}    
