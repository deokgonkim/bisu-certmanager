<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=EUC-KR" errorPage="/error.jsp"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    <title>������ ��������</title>
    <link href="css/oracle.css" rel="stylesheet" media="screen"/>
    <link href="css/view_cert_info.css" rel="stylesheet" media="screen"/>
  </head>
  <body>
    <div style="width: 780px">
      <h1 align="center" style="padding: 5px; border: blue 1px solid;" class="clsTitleBody">���������� ����</h1>
      <div align="right"><a href="listcertificate" style="font-size: 10pt;">���</a> | <a href="logout" style="font-size: 10pt;">�α׾ƿ�</a></div>
      <table>
      <thead>
        <tr class="vrTableHeader" height="24px" style="vertical-align: middle;">
          <th align="center" width="160px">����</th>
          <th align="center" width="620px">����</th>
        </tr>
      </thead>
      <tbody>
        <tr class="clsOddTableRow">
          <td style="text-align: right;" width="160px">���� �� ����� : </td>
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
          <td style="text-align: right;" width="160px">���ڼ��� Alg : </td>
          <td>${certentity.signAlg}</td>
        </tr>
        <tr class="clsEvenTableRow">
          <td style="text-align: right;" width="160px">�߱��� : </td>
          <td>${certentity.manager}</td>
        </tr>
        <tr class="clsOddTableRow">
          <td style="text-align: right;" width="160px">��ȿ�Ⱓ : </td>
          <td>${certentity.notBefore} - ${certentity.notAfter}</td>
        </tr>
        <tr class="clsEvenTableRow">
          <td style="text-align: right;" width="160px">��� : </td>
          <td>${certentity.comment}</td>
        </tr>
        <tr class="clsOddTableRow">
          <td style="text-align: right; vertical-align: middle;" width="160px">������(PEM) : </td>
          <td><pre>${certpem}</pre></td>
        </tr>
        <tr class="clsEvenTableRow">
          <td style="text-align: right; vertical-align: middle;" width="160px">����Ű(PEM) : </td>
          <td><pre>${keypem}</pre></td>
        </tr>
      </tbody>
      </table>
    </div>
  </body>
</html>