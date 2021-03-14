<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <html>
 <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Spring Boot Application with JSP</title>
 </head>
 <body>
     <input type="text" id ="t_name" placeholder="Train Name"><br>
     <button id="searchBtn">Search</button>
     <h4 id="name"> </h4>
     <h5 id="description"> </h5>

     <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
     <script>
        $('#searchBtn').click(function(){
            $.ajax({
                url: "http://localhost:8080/api/trains",
                type: "get",
                data: { name: $("#t_name").val() },
                statusCode: {
                    200:function(data){
                        $("#name").text(data[0].name);
                        $("#description").text(data[0].description);
                   },
                   204:function(){
                       $("#name").text('No Search');
                       $("#description").text(' ');
                   },
                   405:function(){
                        $("#name").text('Error');
                        $("#description").text(' ');
                   }
                }
            })
        })
     </script>
 </body>
 </html>
