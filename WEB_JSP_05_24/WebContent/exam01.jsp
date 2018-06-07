<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title> hello jsp </title>
    </head>

    <body>
        <%!
         static int b;
        %>
    
        <% 
           
           System.out.println("Hello JSP");
        //같은 영역 
        for(int i =0;i<5;i++){
        %>
        <button>test</button>
        <% 
        }
         // 같은 영역
         int c =10;
        %>
        
        <!-- 표현식 -->
        <%= "abc" %>
        out.write(abc);
        
        <script>
        if( <%=c%> >10){
        	//servlet에서 쓰인 변수가 스크립트에서는 쓰일수가 없다  그래서  < % out. write () % >
        }
        </script>
        Hello Client
    </body>

    </html>
