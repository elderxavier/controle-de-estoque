<%-- 
    Document   : testaconexao
    Created on : 02/09/2015, 00:27:10
    Author     : x-e
--%>

<%@page import="model.Estoque"%>
<%@page import="dao.EstoqueDAO"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.FileHandler"%>
<%@page import="db.ConexaoDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste Banco de dados</title>
    </head>
    <body>
        <p><%out.println(ConexaoDB.statusConection());%> </p>
        <% ConexaoDB.getConexaoMySQL();%>
        <p><%out.println(ConexaoDB.statusConection()); %> </p>
        <% //ConexaoDB.FecharConexao();%>
        <p><%//out.println(ConexaoDB.statusConection()); %> </p>
        
        <% 
        
        EstoqueDAO dao = new EstoqueDAO();
        Estoque estoque = new Estoque();
        
        estoque.setDescricao("descricao");
        
        estoque.setFabricante("fabricante");
        //dao.Inserir(estoque);


        
        %>
    </body>
</html>