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
alert('�α��� �����Դϴ�.\nJAAS�� �����Ǿ� ��Ȯ�� ���� �޽����� �� �� �����ϴ�.\n�����ڿ��� ����� Ȥ�ó� ������ �� ���� �ֽ��ϴ�.');
document.location = '<%=request.getContextPath() %>/login_form.jsp';
</script>
  </body>
</html>