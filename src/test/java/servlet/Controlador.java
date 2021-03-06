package servlet;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseDeDatos.CompraDAO;
import baseDeDatos.Fecha;
import baseDeDatos.ProductoDAO;
import entidades.Carrito;
import entidades.Cliente;
import entidades.Compra;
import entidades.Pago;
import entidades.Producto;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
   // ArrayList<Producto>productos=new ArrayList<>();
   	
    ArrayList<Carrito>listaCarrito = new ArrayList<>();
   	int item;
   	double totalPagar=0.0;
   	int cantidad=1;
   	int idp;
   	Carrito car;
   	
       @SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
       	
       	
    	HttpSession objsesion = request.getSession(true);
    	ArrayList<Carrito> articulos= objsesion.getAttribute("carrito") == null? null : (ArrayList) objsesion.getAttribute("carrito");
		String usuario = (String)objsesion.getAttribute("usuario");		
		String accion = request.getParameter("accion");
       	//productos=(ArrayList<Producto>) pdao.listar();
       	
       	if(usuario != null) { 
	   		switch(accion) {			
	   			case "GenerarCompra":	
	   					Cliente cliente= new Cliente();
	   					cliente.setId(12);
	   					double totalPagar2 = Double.parseDouble(request.getParameter("totalPagar"));
	   					System.out.println(totalPagar2);
	   					//Pago pago = new Pago();
	   					CompraDAO dao = new CompraDAO();
	   					Compra compra = new Compra(cliente, 19, Fecha.FechaBD(), totalPagar, "Cancelado",articulos);
	   					int res = dao.GenerarCompra(compra);
	   					if(res!=0 && totalPagar>0) {
	   						request.getRequestDispatcher("mensaje.jsp").forward(request, response);
	   					}else {
	   						request.getRequestDispatcher("error.jsp").forward(request, response);
	   					}
	   					break;			
	   			default:
	   				//request.setAttribute("productos", productos);
	   				request.getRequestDispatcher("index.jsp").forward(request, response);
	
	   		}
       	
       	}else {
       		objsesion.invalidate();
       		//request.setAttribute("productos", productos);
       		request.getRequestDispatcher("index.jsp").forward(request, response);
       	}
       }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
