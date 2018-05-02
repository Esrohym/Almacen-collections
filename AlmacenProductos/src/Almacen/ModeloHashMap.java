package Almacen;
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.Map;

public class ModeloHashMap extends ModeloAbs
{
    private HashMap <Integer,Producto> lista;
    
    public ModeloHashMap(){
       lista=new HashMap  <Integer,Producto>();
    }

    public boolean insertarProducto ( Producto p) {
    	lista.put(p.getCodigo(), p);
    	return false;
    }
    	
    
    	
    
    public boolean borrarProducto ( int codigo ) {
    	if(!lista.isEmpty()) {
    		if(buscarProducto(codigo)!=null) {
    			lista.remove(codigo);
    			return true;
    		}
    	}
    	return false;
    }
    				
    public Producto buscarProducto ( int codigo) {
    	return lista.get(codigo);
    }
    			
    public void listarProductos (){
    	System.out.printf("%s\t%s\n","Codigo","Nombre");
    	for(Map.Entry<Integer,Producto> lista:lista.entrySet()) {
    		System.out.printf("%s\t%s\n",lista.getValue().getCodigo(),lista.getValue().getNombre());
    	}
    }
    		
    		
    public boolean modificarProducto (Producto nuevo){
    	return false;
    }
    
    public void listarPocoStock() {
    	System.out.printf("%s\t%s\n","Codigo","Nombre");
    	for(Map.Entry<Integer,Producto> lista:lista.entrySet()) {
    		if(lista.getValue().getStock()<lista.getValue().getStock_min()) {
    			System.out.printf("%s\t%s\n",lista.getValue().getCodigo(),lista.getValue().getNombre());
    		}
    	}
    }
}
    	
    	

    		
    		
    	
    
    	
    	
    
  
    
    	
    	