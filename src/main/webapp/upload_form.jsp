<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=EUC-KR" errorPage="/error.jsp"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    <title>���ε� ȭ��</title>
    <link href="css/oracle.css" rel="stylesheet" media="screen"/>
    <link href="css/upload_form.css" rel="stylesheet" media="screen"/>
  </head>
  <body>
    <div style="width: 780px">
      <h1 align="center" style="padding: 5px; border: blue 1px solid;" class="clsTitleBody">������ ���ε�</h1>
      <div align="right"><a href="listcertificate" style="font-size: 10pt;">���</a> | <a href="logout" style="font-size: 10pt;">�α׾ƿ�</a></div>
      <form name="frm_cert_upload" action="uploadaction" method="POST" enctype="multipart/form-data">
        <table>
          <thead>
            <tr class="vrTableHeader" height="24px" style="vertical-align: middle;">
              <th align="center" width="160px">����</th>
              <th align="center" width="620px">����</th>
            </tr>
          </thead>
          <tbody>
            <tr class="clsOddTableRow">
              <td style="text-align: right;" width="160px">���� : </td>
              <td><input type="text" name="customer" /></td>
            </tr>
            <tr class="clsEvenTableRow">
              <td style="text-align: right;" width="160px">����� : </td>
              <td><input type="text" name="customerpersonnel" /></td>
            </tr>
            <tr class="clsOddTableRow">
              <td style="text-align: right;" width="160px">����ڸ��� : </td>
              <td><input type="text" name="customerpersonnelmail" /></td>
            </tr>
            <tr class="clsEvenTableRow">
              <td style="text-align: right;" width="160px">�߱��� : </td>
              <td><input type="text" name="manager" /></td>
            </tr>
            <tr class="clsOddTableRow">
              <td style="text-align: right;" width="160px">�߱��ڸ��� : </td>
              <td><input type="text" name="managermail" />���� ���� ����� ��� ,�� �����Ͽ� �ֽʽÿ�.</td>
            </tr>
            <tr class="clsEvenTableRow">
              <td style="text-align: right;" width="160px">��� : </td>
              <td><input type="text" name="comment" /></td>
            </tr>
            <tr class="clsOddTableRow">
              <td style="text-align: right;" width="160px">������ : </td>
              <td><input type="file" name="cert" /></td>
            </tr>
            <tr class="clsEvenTableRow">
              <td style="text-align: right;" width="160px">����Ű : </td>
              <td><input type="file" name="key" /></td>
            </tr>
          </tbody>
        </table>
        <div style="font-size: 10pt; line-height: 20px;">�� ���� 30��, 7��, 1�� ���� �߱��� ���Ϸ� ���� �ȳ� �޽����� �߽ŵ˴ϴ�.</div>
        <input type="submit" class="button" value="���� ���ε�" />
      </form>
    </div>
  </body>
</html>