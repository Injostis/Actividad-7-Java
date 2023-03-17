<%-- 
    Document   : AreaPerimetroTriangulo
    Created on : 16 feb 2023, 20:40:33
    Author     : rod06
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controladores.PerimetroAreaTriangulo" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            // Verificar si hay atributos de sesión con el nombre de "nombreUsuario"
            String nombreUsuario = (String)session.getAttribute("nombreUsuario");

            if (nombreUsuario == null) {
                // Si no hay, pedir al usuario que ingrese su nombre y guardarlo en un atributo de sesión
                out.println("Por favor, ingrese su nombre:");
                %>
                <form action="<%=request.getContextPath()%>/index.jsp" method="post">
                    <input type="text" name="nombre" />
                    <input type="submit" value="Enviar" />
                </form>
                <%
                String nombre = request.getParameter("nombre");
                session.setAttribute("nombreUsuario", nombre);
                nombreUsuario = nombre;
            } else {
                // Si hay, obtener el nombre del usuario de los atributos de sesión
                out.println("Bienvenido de nuevo, " + nombreUsuario + "!");
            }
        %>
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    String value = cookie.getValue();
                    if (name.equals("base")) {
                        out.println("Última base ingresada: " + value);
                    } else if (name.equals("altura")) {
                        out.println("Última altura ingresada: " + value);
                    } else if (name.equals("area")) {
                        out.println("Última área calculada: " + value);
                    } else if (name.equals("perimetro")) {
                        out.println("Último perímetro calculado: " + value);
                    }
                }
            }
        %>
        <h1>Área y perímetro de triángulo equilatero<h1/>
            <form action="TriangleServlet" method="post">
                Base del triangulo:<br>
                <input type="text" name="baseTriangulo" value=""><br>
                Altura del triangulo:<br>
                <input type="text" name="alturaTriangulo" value=""><br>
                <input type="submit" value="Calcular área y perímetro">
            <form/>
    </body>
</html>
