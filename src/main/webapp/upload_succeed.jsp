<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%--
  - request.attribute[FILENAME] : 파일명
  --%>
<%@ page contentType="text/html;charset=EUC-KR" errorPage="/error.jsp"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    <title>upload_succeed</title>
    <link href="css/oracle.css" rel="stylesheet" media="screen"/>
    <link href="css/upload_form.css" rel="stylesheet" media="screen"/>
  </head>
  <body>
    <div style="width: 780px">
      <h1 align="center" style="padding: 5px; border: blue 1px solid;" class="clsTitleBody">인증서 업로드</h1>
      <h2 align="center" style="padding: 5px; border: blue 1px solid;"> 업로드 되었습니다. </h2>
      <hr />
      <div align="right"><a href="uploadform">추가</a> | <a href="listcertificate">목록</a></div>
    </div>
  </body>
</html>