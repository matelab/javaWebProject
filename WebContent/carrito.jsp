 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="baseDeDatos.ProductoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Producto"%>
<%@page import="entidades.Carrito"%>
<%@page import="interfaces.I_ProductosRepo" %>
<%@page import="servlet.Controlador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.Date" %>
  <%
 	HttpSession sesion = request.getSession(true);
 	ArrayList<Carrito> articulos= sesion.getAttribute("carrito") == null? null : (ArrayList) sesion.getAttribute("carrito");
	
	%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body>
 <jsp:include page="header.jsp" /> 
<jsp:include page="login.jsp" /> 
<div class="container">
 <%if(articulos != null){ %>
	<h1>Carrito</h1>
	<a href="Controlador?accion=home">Seguir comprando</a>
	
	  <div>
       	<h2>Generar compra</h2>
       	Subtotal <input id="text-subtotal" type="text" value="$.${totalPagar}0" readonly="" class="form-control"/>
       	Descuento <input type="text" value="$.00" readonly="" class="form-control"/>
       	Total a pagar<input id="text-total" type="text" value="$.${totalPagar}0" readonly="" class="form-control"/>
       	
       	<a href="#">Realizar pago</a>
       	<a href="Controlador?accion=GenerarCompra">Generar compra</a>
       </div>
       <hr>
      
	<table id="shop-table" class="table table-hover" border="1">
                 <thead>
                     <tr class="text-center">
                         <th>ITEM</th>
                         <th>NOMBRES</th>
                         <th>DESCRIPCION</th>
                         <th>PRECIO</th>
                         <th>CANT</th>
                         <th>SUBTOTAL</th>
                         <th>ACCION</th>
                     </tr>
                 </thead>
                 <tbody>
                  <%  for(Carrito c: articulos){%>
    					<tr class="text-center">
                         <td ><%= c.getItem()%></td>
                         <td><%= c.getNombre()%>
                         <img src="ControladorIMG?id=<%= c.getIdProducto()%>" height="100" width="100">
                         </td>
                         <td><%= c.getDescripcion()%></td>
                         <td><%= c.getPrecioCompra()%></td>
                         <td>
                         	<input type="hidden" name="idpro" class="idpro" value="<%= c.getIdProducto()%>" />
                         	<input style="padding:15px" type="number" name="cantidad" class="Cantidad" value="<%= c.getCantidad()%>" min="1"/>
                         </td>
                         <td>
                         	<input type="hidden" name="subtotal" class="subtotal" value="<%= c.getSubtotal()%>" />
                         	<%= c.getSubtotal()%>
                         </td>  
                         <td>
                    	    <input type="hidden" name="idp" class="idp" value="<%= c.getIdProducto()%>" />                          	
                         	<button class="btnDelete">Eliminar</button>
                         </td>                                  
                     </tr>
         		<% } %> 

	    
                 </tbody>
             </table>  
  	<% }else{ %>
  		<h2>No hay articulos en el carro</h2>
  	<%} %>            
</div>
	 
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>           
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>         
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="js/funciones.js" type="text/javascript"></script>
</body>
</html>