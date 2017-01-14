<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=EUC-KR" errorPage="/error.jsp"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    <title>인증서 정보보기</title>
    <link href="css/oracle.css" rel="stylesheet" media="screen"/>
    <link href="css/view_cert_info.css" rel="stylesheet" media="screen"/>
  </head>
  <body>
    <div style="width: 780px">
      <h1 align="center" style="padding: 5px; border: blue 1px solid;" class="clsTitleBody">서버인증서 정보</h1>
      <div align="right"><a href="listcertificate" style="font-size: 10pt;">목록</a> | <a href="logout" style="font-size: 10pt;">로그아웃</a></div>
      <table>
      <thead>
        <tr class="vrTableHeader" height="24px" style="vertical-align: middle;">
          <th align="center" width="160px">구분</th>
          <th align="center" width="620px">내용</th>
        </tr>
      </thead>
      <tbody>
        <tr class="clsOddTableRow">
          <td style="text-align: right;" width="160px">고객사 및 담당자 : </td>
          <td>${certentity.name} ${certentity.customerPersonnel}</td>
        </tr>
        <tr class="clsEvenTableRow">
          <td style="text-align: right;" width="160px">ISSUER DN : </td>
          <td>${certentity.issuerDn}</td>
        </tr>
        <tr class="clsOddTableRow">
          <td style="text-align: right;" width="160px">SUBJECT DN : </td>
          <td>${certentity.subjectDn}</td>
        </tr>
        <tr class="clsEvenTableRow">
          <td style="text-align: right;" width="160px">SERIAL : </td>
          <td>${certentity.serial}</td>
        </tr>
        <tr class="clsOddTableRow">
          <td style="text-align: right;" width="160px">전자서명 Alg : </td>
          <td>${certentity.signAlg}</td>
        </tr>
        <tr class="clsEvenTableRow">
          <td style="text-align: right;" width="160px">발급자 : </td>
          <td>${certentity.manager}</td>
        </tr>
        <tr class="clsOddTableRow">
          <td style="text-align: right;" width="160px">유효기간 : </td>
          <td>${certentity.notBefore} - ${certentity.notAfter}</td>
        </tr>
        <tr class="clsEvenTableRow">
          <td style="text-align: right;" width="160px">비고 : </td>
          <td>${certentity.comment}</td>
        </tr>
        <tr class="clsOddTableRow">
          <td style="text-align: right; vertical-align: middle;" width="160px">인증서(PEM) : </td>
          <td><pre>${certpem}</pre></td>
        </tr>
        <tr class="clsEvenTableRow">
          <td style="text-align: right; vertical-align: middle;" width="160px">개인키(PEM) : </td>
          <td><pre>${keypem}</pre></td>
        </tr>
      </tbody>
      </table>
    </div>
  </body>
</html>