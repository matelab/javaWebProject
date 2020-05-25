package entidades;

public class Carrito {
	int currentCar;
	int item;
	int idProducto;
	String nombre;
	String descripcion;
	double precioCompra;
	int cantidad;
	double subtotal;
	
	
	public Carrito() {
		// TODO Auto-generated constructor stub
	}


	 


	public Carrito(int currentCar,int item, int idProducto, String nombre, String descripcion, double precioCompra, int cantidad,
			double subtotal) {
		this.currentCar = currentCar;
		this.item = item;
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}





	public int getCurrentCar() {
		return currentCar;
	}





	public void setCurrentCar(int currentCar) {
		this.currentCar = currentCar;
	}





	public int getItem() {
		return item;
	}


	public void setItem(int item) {
		this.item = item;
	}


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}





	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
}


