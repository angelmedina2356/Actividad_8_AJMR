<%-- 
    Document   : resultados
    Created on : 23/04/2021, 09:27:55 PM
    Author     : Angel
--%>

<%@page import="modelo.Triangulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RESULTADOS</title>
    </head>
    <body>
        <h1>AQUI SE MUESTRAN TUS RESULTADOS!</h1>
        
        <%
                Triangulo t=new Triangulo();
                t=(Triangulo) request.getAttribute("OnjetoJava");
                if(t!=null){
                    out.print("El perimetro es: ");
                    out.print(t.getPerimetro()+"<br>");
                    out.print("El area es: ");
                    out.print(t.getArea());
                }
                        
            %>
        
    </body>
</html>
