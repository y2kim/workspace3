<%@page import="java.util.List"%>
<%@page import="bean.MemberInfos"%>
<%@page import="bean.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
}

div {
	border: 1px solid black;
}

#wrapper {
	width: 275px;
	height: 100px;
  margin: auto;
}

#col1 {
	width: 100%;
	height: 25%
}

#col2 {
	width: 100%;
	height: 25%
}

#col3 {
	width: 100%;
	height: 25%
}

#col4 {
	width: 100%;
	height: 25%
}

#indexid {
	height: 100%;
	width: 35%;
	float: left;
	text-align: center;

}

#inid {
	height: 100%;
	width: 65%;
	float: left;
}

#indexpwd {
	height: 100%;
	width: 35%;
	float: left;
	text-align: center;

}

#inpwd {
	height: 100%;
	width: 65%;
	float: left;
}

#textid {
	width: 100%;
	height: 100%;
}

#textpwd {
	width: 100%;
	height: 100%;
}
#joinmember{
  width: 100%;
  height: 35%;
  text-align: center;

}
#funclist{
  width: 100%;
  height: 65%;
}
#funclist button{
  width: 25%;
  border: 0px;
}
div button {
	border-top: 5px;
}
</style>
</head>
<body>

  	<%
  	  String var1 = (String)session.getAttribute("loginId");
      if( var1.equals("admin")){

     DAO data = new DAO();
     MemberInfos mif = new MemberInfos();
     List<MemberInfos> list = data.listAll();
     int listsize = list.size();
    %>
  	<table border=1>
  	<tr><th>회원관리</th></tr>
  	<tr>
  	<td>아이디</td>
  	<td>이름</td>
  	<td>번호</td>
  	<td>이메일</td>
  	<td>차단여부</td>
  	</tr>
  	<% for(int i=0;i<listsize;i++) {%>
  	<tr>
  	<td><%=list.get(i).getId()%></td>
  	<td><%=list.get(i).getName()%></td>
  	<td><%=list.get(i).getPhone1()%>-<%=list.get(i).getPhone2()%>-<%=list.get(i).getPhone3()%></td>
  	<td><%=list.get(i).getEmail()%></td>
  	<% if(list.get(i).getIsblocked().equals("n")) {%>
  	 <td align="center"> <button id="block<%=i+1%>" type="button">차단</button></td>
  	<%} else {%>
  	 <td align="center"> <button id="block<%=i+1%>" type="button">해제</button></td>
  	<%}%>
     <script>
       
  	    document.getElementById("block"+'<%=i+1%>').onclick = function(){
        	 var text =  document.getElementById("block"+'<%=i+1%>').innerHTML;
  	    	if(text == '차단'){
  	    		 document.getElementById("block"+'<%=i+1%>').innerHTML = "해제";
  	            <%int result = data.doblock(list.get(i).getId());
  	          System.out.print(list.get(i).getId());
  	               if(result>0){
  	            	   %> alert("차단성공");<%
  	               }
  	            %>
  	           
  	    	}else{
  	    		 document.getElementById("block"+'<%=i+1%>').innerHTML = "차단";
   	            <% int result2 = data.unblock(list.get(i).getId());
   	             System.out.print(list.get(i).getId());
   	            if(result2>0){
            	   %> alert("차단해제");<%
               }
   	            %>
   	            
  	    	}
           
        }
     </script>
     </tr>

  	<% }%>
  	</table>

  	<%}else{
  		response.sendRedirect("never.jsp");
  	%>
    <form method="post" action="loginchk.jsp" id="logininfo">
      <div id="wrapper">
        <div id="col1" style="text-align: center">
           권환이 없습니다
        </div>
        <div id="col2">
        response.sendRedirect("error.jsp");
        </div>
        <div id="col3">

        </div>
        <div id="col4" style="text-align: center">

        </div>
      </div>
    </form>


 <%}%>

</body>
</html>
