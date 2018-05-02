package Almacen;
/**
 * 
 * @author (Sady) 
 * @version (02/05/2018)
 */
 
public class Producto
{
   
    private int codigo;    // Código del producto, se utiliza para buscar
    private String nombre; // Nombre un texto
    private int stock;    // existencia actuales
    private int stock_min; // Número mínimo de existencias recomendadas
    private float precio;  // Precio

    /**
     * Constructor for objects of class Producto
     */
    
    public Producto ( int codigo, String nombre,int Stock,int MinStock,float precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = Stock;
        stock_min=MinStock;
        this.precio=precio;
    }
    
    public int getCodigo (){
        return codigo;
    }
    
    @Override
    public String toString(){
       return codigo +":"+ nombre +":"+ stock+":"+precio;
    }
    
    public int getStock(){
        return stock;
    }
    
    public boolean setStock( int valor ){
        stock = (stock<valor)?stock:stock+valor;
        return true;
    }
    
    public int getStock_min(){
        return stock_min;
    }
    
    public void setStock_min( int valor ){
        stock_min = valor;
    }
    
    
    public float getPrecio(){
        return precio;
    }
    
    public void setPrecio( float valor ){
        precio = valor;
    }
    
    public String getNombre() {
    	return nombre;
    }
    	
}
