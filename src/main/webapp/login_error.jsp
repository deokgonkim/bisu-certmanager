<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=EUC-KR" errorPage="/error.jsp"%>
<%@ page import="java.util.*" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    <title>login_error</title>
  </head>
  <body>
<script language="javascript" type="text/javascript">
alert('로그인 오류입니다.\nJAAS로 구현되어 정확한 에러 메시지를 알 수 없습니다.\n관리자에게 물어보면 혹시나 점검해 줄 수도 있습니다.');
document.location = '<%=request.getContextPath() %>/login_form.jsp';
</script>
  </body>
</html>