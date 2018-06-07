<%@page import="bean.MemberInfos"%>
<%@page import="java.util.List"%>
<%@page import="bean.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="tochange.jsp" method="post" id="modify">
	<%
		String getids =(String)session.getAttribute("loginId");
		DAO date = new DAO();
	    List<MemberInfos> list = date.myinfo(getids);
	%>
  <table border="1">
    <tr>
    <td>index</td>
    <td>원본</td>
    <td>변경할내용</td>
    </tr>
    <tr>
      <td>ID:</td>
      <td><%=list.get(0).getId() %></td>
      <td>아이디는 변경불가</td>
    </tr>
    <tr>
      <td>PW:</td>
      <td><%=list.get(0).getPw()%></td>
      <td><input type="text" id="cpw" name="pw"></td>
    </tr>
    <tr>
      <td>NAME:</td>
      <td><%=list.get(0).getName()%></td>
      <td><input type="text" id="cname" name="name"></td>
    </tr>
    <tr>
      <td>PHONE:</td>
      <td><%=list.get(0).getPhone1()+"-"+list.get(0).getPhone2()+"-"+list.get(0).getPhone3() %></td>
      <td><input type="text" id="phone1" name="phone1">-<input type="text" id="phone2" name="phone2">
      -<input type="text" id="phone3" name="phone3"></td>
    </tr>
    <tr>
      <td>EMAIL:</td>
      <td><%=list.get(0).getEmail()%></td>
      <td><input type="text" id="cemail" name="email"></td>
    </tr>
    <tr>
      <td>ADDRESS:</td>
      <td><%=list.get(0).getZipcode()+""+list.get(0).getAddress1()+list.get(0).getAddress2()%></td>
      <td><input type="text" id="sample6_postcode" readonly name="zipcode"> <button onclick="sample6_execDaumPostcode()" type="button">찾기</button>
      - <input type="text" id="sample6_address" readonly name="address1"> -   <input type="text"id="sample6_address2" name="address2">
    </td>
    </tr>
  </table>
  <button id="change" type="button">변경하기</button>
  <button id="return" type="button">돌아가기</button>
</form>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  <script>
    document.getElementById("return").onclick = function(){
       location.href="login.jsp";
    }
    document.getElementById("change").onclick = function(){
       document.getElementById("modify").submit();
    }

    function sample6_execDaumPostcode() {
    new daum.Postcode({
       oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 각 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullAddr = ''; // 최종 주소 변수
           var extraAddr = ''; // 조합형 주소 변수

           // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
           if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
               fullAddr = data.roadAddress;

           } else { // 사용자가 지번 주소를 선택했을 경우(J)
               fullAddr = data.jibunAddress;
           }

           // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
           if(data.userSelectedType === 'R'){
               //법정동명이 있을 경우 추가한다.
               if(data.bname !== ''){
                   extraAddr += data.bname;
               }
               // 건물명이 있을 경우 추가한다.
               if(data.buildingName !== ''){
                   extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
               }
               // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
               fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('sample6_address').value = fullAddr;
           // 커서를 상세주소 필드로 이동한다.
           document.getElementById('sample6_address2').focus();
       }
    }).open();


    }

  </script>
</body>
</html>
