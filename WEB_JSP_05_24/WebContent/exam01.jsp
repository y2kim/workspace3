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
        //���� ���� 
        for(int i =0;i<5;i++){
        %>
        <button>test</button>
        <% 
        }
         // ���� ����
         int c =10;
        %>
        
        <!-- ǥ���� -->
        <%= "abc" %>
        out.write(abc);
        
        <script>
        if( <%=c%> >10){
        	//servlet���� ���� ������ ��ũ��Ʈ������ ���ϼ��� ����  �׷���  < % out. write () % >
        }
        </script>
        Hello Client
    </body>

    </html>
