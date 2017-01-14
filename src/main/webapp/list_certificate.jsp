<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%--
  - certlist : java.util.List - contains
  -                             com.idatabank.bisu.certmanager.CertEntity
  --%>
<%@ page contentType="text/html;charset=EUC-KR" errorPage="/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    <title>������ ���</title>
    <link href="css/oracle.css" rel="stylesheet" media="screen"/>
    <link href="css/list_certificate.css" rel="stylesheet" media="screen"/>
  </head>
  <body>
    <div style="width: 780px">
    <h1 align="center" style="padding: 5px; border: blue 1px solid;" class="clsTitleBody">���������� ���</h1>
    <div align="right"><a href="uploadform" style="font-size: 10pt;">���ε�</a> | <a href="logout" style="font-size: 10pt;">�α׾ƿ�</a></div>
    <table>
      <thead>
        <tr class="vrTableHeader" height="24px" style="vertical-align: middle;">
          <th align="center" width="160px">����</th>
          <th align="center" width="200px">DN</th>
          <th align="center" width="80px">�߱���</th>
          <th align="center" width="260px">��ȿ�Ⱓ</th>
          <th align="center" width="80px">���</th>
        </tr>
      </thead>
      <tbody><c:set var="k" value="false" />
        <c:forEach items="${certlist}" var="certentity"><c:choose><c:when test="${k}"><c:set var="rowclass" value="clsEvenTableRow"/></c:when><c:otherwise><c:set var="rowclass" value="clsOddTableRow"/></c:otherwise></c:choose><tr class="${rowclass}">
          <td class="${rowclass}" width="160px" style="text-align: center;border-top: gray 1px dotted;">${certentity.name}</td>
          <td class="${rowclass}" width="200px" height="16px" style="border-top: gray 1px dotted;"><div id="k" style="height: 16px; overflow-x: hidden;overflow-y: hidden;" title="${certentity.subjectDn}">${certentity.subjectDn}</div></td>
          <td class="${rowclass}" width="80px" style="text-align: center;border-top: gray 1px dotted;">${certentity.manager}</td>
          <td class="${rowclass}" width="260px" style="text-align: center;border-top: gray 1px dotted;">${certentity.notBefore} - ${certentity.notAfter}</td>
          <td class="${rowclass}" width="80px" style="text-align: center;border-top: gray 1px dotted;">${certentity.comment}</td>
        </tr><tr class="${rowclass}">
          <td colspan="5" style="text-align: right; height: 20px;">
            <form action="controler" method="POST">
              <input type="hidden" name="action" />
              <a href="getcertificate?ID=${certentity.id}" target="_blank">������ �ޱ�</a> ::
              <a href="getprivatekey?ID=${certentity.id}" target="_blank">����Ű �ޱ�</a> ::
              <a href="viewcertinfo?ID=${certentity.id}">������ ��������</a>
            </form>
          </td>
        </tr><c:set var="k" value="${!k}" /></c:forEach>
      </tbody>
    </table>
    </div>
  </body>
</html>