<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=EUC-KR" errorPage="/error.jsp"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    <title>업로드 화면</title>
    <link href="css/oracle.css" rel="stylesheet" media="screen"/>
    <link href="css/upload_form.css" rel="stylesheet" media="screen"/>
  </head>
  <body>
    <div style="width: 780px">
      <h1 align="center" style="padding: 5px; border: blue 1px solid;" class="clsTitleBody">인증서 업로드</h1>
      <div align="right"><a href="listcertificate" style="font-size: 10pt;">목록</a> | <a href="logout" style="font-size: 10pt;">로그아웃</a></div>
      <form name="frm_cert_upload" action="uploadaction" method="POST" enctype="multipart/form-data">
        <table>
          <thead>
            <tr class="vrTableHeader" height="24px" style="vertical-align: middle;">
              <th align="center" width="160px">구분</th>
              <th align="center" width="620px">내용</th>
            </tr>
          </thead>
          <tbody>
            <tr class="clsOddTableRow">
              <td style="text-align: right;" width="160px">고객사 : </td>
              <td><input type="text" name="customer" /></td>
            </tr>
            <tr class="clsEvenTableRow">
              <td style="text-align: right;" width="160px">담당자 : </td>
              <td><input type="text" name="customerpersonnel" /></td>
            </tr>
            <tr class="clsOddTableRow">
              <td style="text-align: right;" width="160px">담당자메일 : </td>
              <td><input type="text" name="customerpersonnelmail" /></td>
            </tr>
            <tr class="clsEvenTableRow">
              <td style="text-align: right;" width="160px">발급자 : </td>
              <td><input type="text" name="manager" /></td>
            </tr>
            <tr class="clsOddTableRow">
              <td style="text-align: right;" width="160px">발급자메일 : </td>
              <td><input type="text" name="managermail" />여러 개를 등록할 경우 ,로 구분하여 주십시오.</td>
            </tr>
            <tr class="clsEvenTableRow">
              <td style="text-align: right;" width="160px">비고 : </td>
              <td><input type="text" name="comment" /></td>
            </tr>
            <tr class="clsOddTableRow">
              <td style="text-align: right;" width="160px">인증서 : </td>
              <td><input type="file" name="cert" /></td>
            </tr>
            <tr class="clsEvenTableRow">
              <td style="text-align: right;" width="160px">개인키 : </td>
              <td><input type="file" name="key" /></td>
            </tr>
          </tbody>
        </table>
        <div style="font-size: 10pt; line-height: 20px;">※ 만료 30일, 7일, 1일 전에 발급자 메일로 만료 안내 메시지가 발신됩니다.</div>
        <input type="submit" class="button" value="파일 업로드" />
      </form>
    </div>
  </body>
</html>