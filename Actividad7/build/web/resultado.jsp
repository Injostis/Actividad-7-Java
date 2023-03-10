<%-- 
    Document   : resultado
    Created on : 16 feb 2023, 21:53:55
    Author     : rod06
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ecuaciones.Triangulo" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            // Obtener los valores de base, altura, área y perímetro de las cookies
            Cookie[] cookies = request.getCookies();
            int base = 0;
            int altura = 0;
            int area = 0;
            int perimetro = 0;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    String value = cookie.getValue();
                    if (name.equals("base")) {
                        base = Integer.parseInt(value);
                    } else if (name.equals("altura")) {
                        altura = Integer.parseInt(value);
                    } else if (name.equals("area")) {
                        area = Integer.parseInt(value);
                    } else if (name.equals("perimetro")) {
                        perimetro = Integer.parseInt(value);
                    }
                }
            }

            // Mostrar los resultados
            out.println("Base: " + base);
            out.println("Altura: " + altura);
            out.println("Área: " + area);
            out.println("Perímetro: " + perimetro);
        %>
    </body>
</html>
