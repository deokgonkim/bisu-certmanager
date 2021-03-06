<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=EUC-KR" errorPage="/error.jsp"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"/>
    <title>로그인 화면</title>
    <style type="text/css">
    <!--

BODY
{
  background-color:#EFEFEF;
}

H1
{
  font-family:Arial, sans-serif;
}

H2
{
  font-family:Arial, sans-serif;
}


H3
{
  font-family:Arial, sans-serif;
}


/*
** This controls the attributes of the BODY portion of the title frame.
*/ 

.clsTitleBody
{
  font-family:Arial, sans-serif;
	color:white;
	font-size:17pt;
	font-weight: bold;
	background-color:#336699;
}

/*
*  This controls the attributes for the BODY tag within the application. All JSP pages designate
*  the BODY tag as having this CSS class name.
*/
.clsContentsBody
{
  font-family:Arial, sans-serif;
	color:white;
	font-size:12pt;
	font-weight: bold;
	background-color:#6699CC;
}


/*
** This controls the TD within the View Record Form.
*/

.clsViewCurrentRecord .vrTableRow TD
{
  font-family:Arial, sans-serif;
	color:black;
	font-size:10pt;
	font-weight: bold;
	background-color:#6699CC;
  text-align:left;
	vertical-align:bottom
}


/*
** This controls the edit fields within the row edit form generated by the Edit Current Record Data Web Bean.
*/
.clsViewCurrentRecord .vrTableRow .clsFieldValue
{
  font-family:Arial, sans-serif;
	color:black;
	font-size:10pt;
	font-weight: bold;
	background-color:white;
  text-align:left;
	vertical-align:bottom
}

/*
** This controls the look of all table detail cells generated by the HTML generation framework.
*/

.vrTableRow TD
{
	font-family:Arial, sans-serif; 
	color:black; 
	font-size:10pt; 
	font-weight: bold;
	background-color:white; 
  text-align:left;
	vertical-align:bottom
}




/*
** When you enable the alternating colors feature for the HTML Table Control, this class controls the attributes of the odd row.
*/

.clsOddTableRow TD
{
	font-family:Arial, sans-serif; 
	color:black; 
	font-size:10pt; 
	font-weight: bold;
	background-color:white; 
  text-align:left;
	vertical-align:bottom
}

/*
** When you enable the alternating colors feature for the HTML Table Control, this class controls the attributes of the even row.
*/

.clsEvenTableRow TD
{
	font-family:Arial, sans-serif; 
	color:black; 
	font-size:10pt; 
	font-weight: bold;
	background-color:#EDEDED; 
  text-align:left;
	vertical-align:bottom
}

/*
** This class controls the attributes of the current row.
*/

.clsCurrentTableRow TD
{
	font-family:Arial, sans-serif; 
	font-size:10pt; 
	font-weight: bold;
  text-align:left;
	vertical-align:bottom;
}

/*
** Controls attributes of all table headers generated by the HTML generation framework.
*/

.vrTableHeader 
{
	font-family:Arial, sans-serif; 
	color:#FFFFFF; 
	font-size:10pt; 
	font-weight: bold;
	background-color:#6699CC; 
    text-align:left;
	vertical-align:bottom 
}


/*
** controls the panel that contains the rounded corder table control. Please look at the HTML Table Control for more information.
*/

.PANEL 
{
	background-color:#EFEFEF 
}

/*
** These are reserved for future use
*/

.container {
	background-color: purple }
.COLOR1 {
	background-color: #000000 }
.COLOR2 {
	background-color: #003366 }
.COLOR3 {
	background-color: #336699 }
.COLOR4 {
	background-color: #6699cc }
.COLOR5 {
	background-color: #99ccff }
.COLOR6 {
	background-color: #ffffff }
.COLORG2 {
	background-color: #333333 }
.COLORG3 {
	background-color: #666666 }
.COLORG4 {
	background-color: #999999 }
.COLORG5 {
	background-color: #cccccc }
.APPSWINDOW {
	background-color:#336699; }
.BISWINDOW {
	background-color:#FFFFFF }
.PRINTWINDOW {
	background-color:#FFFFFF }
.HOMEWINDOW {
	background-color:#FFFFFF }
.HIGHLIGHT {
	background-color:#FFFFFF }
.SHADOW {
	background-color:#666666 }
.DARKSHADOW {
	background-color:#333333 }

.SOFTPANEL {
	background-image:url(FNDBKBLU.gif);
	background-color:#EEEEEE}
.HELPTEXT {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt }
.PROMPTBLACK {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt }
.PROMPTWHITE {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#FFFFFF; 
	font-size:10pt }
.DATABLACK {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt;
	font-weight:bold }
.DATAWHITE {
	font-family:Arial, Helvetica, Geneva, sans-serif;
	color:#FFFFFF; 
	font-size:10pt;
	font-weight:bold }
.DATATOTALS {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000;
	font-size:10pt;
	font-weight:bold }
.INFOBLACK {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt }
.INFOWHITE {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#FFFFFF; 
	font-size:10pt }
.ALERTTEXT {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt }
.ALERTTITLE {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:12pt;
	font-weight:bold }
.FIELDDATA {
	font-family:Arial, Helvetica, Geneva, sans-serif;
	color:#000000; 
	font-size:10pt;
	font-weight:bold }
.LINK {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	font-size:10pt; }
.WIDEFIELDDATA {
	font-family:"Arial narrow", Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt }

.TABLEHEADERCENTER {
	font-family:Arial, sans-serif; 
	color:#FFFFFF; 
	font-size:10pt;
	font-weight: bold; 
	background-color:#6699CC; 
	text-align:center; 
	vertical-align:bottom }
.TABLEHEADERLEFT {
	font-family:Arial, sans-serif; 
	color:#FFFFFF; 
	font-size:10pt; 
	font-weight: bold; 
	background-color:#6699CC; 
	text-align:left; 
	vertical-align:bottom }
.TABLEHEADERRIGHT {
	font-family:Arial, sans-serif; 
	color:#FFFFFF;
	font-size:10pt; 
	font-weight: bold; 
	background-color:#6699CC; 
	text-align:right; 
	vertical-align:bottom }
.SORTHEADER {
	font-family:Arial, sans-serif; 
	color:#FFFFFF; 
	font-size:10pt; 
	font-weight: bold; 
	text-decoration:none }	
.TABLECELL {
	font-family:Arial, Helvetica, Geneva, sans-serif;
	color:#000000; 
	font-size:10pt; 
	background-color:#FFFFFF }
.TABLEROWHEADER {
	font-family:Arial, Helvetica, Geneva, sans-serif;
	color:#FFFFFF; 
	font-size:10pt; 
	font-weight: bold;
	background-color:#6699CC }
.TABLECELLSHADED {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt;
	background-color:#99CCFF }
.TABLECELLGRAYSHADED {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt;
	background-color:#CCCCCC }
.INPUTCELL {
	font-family:"Arial narrow", Arial, Helvetica, Geneva, sans-serif;
	color:#000000; 
	font-size:10pt; 
	background-color:#FFFFFF }
.INPUTCELLSHADED {
	font-family:"Arial narrow", Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt; 
	background-color:#99CCFF }
.TABLESURROUND {
	background-color:#6699CC }
.PRINTHEADER {
	font-family:Arial, sans-serif; 
	color:#FFFFFF; 
	font-size:10pt;
	font-weight: bold; 
	background-color:#6699CC; 
	text-align:center; 
	vertical-align:bottom }
.PRINTCELL {
	font-family:Arial, Helvetica, Geneva, sans-serif;
	color:#000000; 
	font-size:10pt; 
	background-color:#FFFFFF }
.PRINTROWHEADER {
	font-family:Arial, Helvetica, Geneva, sans-serif;
	color:#FFFFFF; 
	font-size:10pt; 
	font-weight: bold; 
	background-color:#6699CC }
.PRINTCELLSHADED {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt;
	background-color:#99CCFF }
.PRINTSURROUND {
	background-color:#6699CC }
.BISHEADER {
	font-family:Arial, sans-serif; 
	color:#FFFFFF; 
	font-size:10pt; 
	font-weight: bold; 
	background-color:#6699CC; 
	text-align:center; 
	vertical-align:bottom }
.BISCELL {
	font-family:Arial, Helvetica, Geneva, sans-serif;
	color:#000000; 
	font-size:10pt; 
	background-color:#FFFFFF }
.BISROWHEADER {
	font-family:Arial, Helvetica, Geneva, sans-serif;
	color:#FFFFFF; 
	font-size:10pt; 
	font-weight: bold; 
	background-color:#6699CC }
.BISCELLSHADED {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000; 
	font-size:10pt;
	background-color:#99CCFF }
.BISSURROUND {
	background-color:#6699CC }
.BUTTON {
	background-color:#CCCCCC }
.BUTTONTEXT {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000;	
	font-size:10pt;
	text-decoration:none }
.DISABLEDBUTTONTEXT {
	font-family:Arial, Helvetica, Geneva, sans-serif;
	color:#999999;	
	font-size:10pt;
	text-decoration:none }
.TOOLBAR {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#336699;
	font-size:13PT;
	font-style:italic;	
	font-weight:bold;
	background-color:#CCCCCC }
.PANELTITLE {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#CCCCCC;
	font-size:12PT;
	font-weight:bold;
	background-color:#003366 }
.TABTITLE {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#CCCCCC;
	font-size:12PT;
	font-weight:bold }
.CURRENTTAB {
	background-color:#CCCCCC }
.CURRENTTABTEXT {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#000000;
	font-size:10PT;
	text-decoration:none }
.OTHERTAB {
	background-color:#6699CC}
.OTHERTABTEXT {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#FFFFFF;
	font-size:10PT;
	text-decoration:none }
.WEEKDAYCELL {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color:#FFFFFF;
	font-size:10PT;
	font-weight: bold;
	background-color: #6699CC }
.MONTHDAYCELL {
	background-color: #FFFFFF }
.DAYLINK {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color: #000000;
	font-size:10PT;
	font-weight: bold;
	text-decoration:none }
.DISABLEDDAYLINK {
	font-family:Arial, Helvetica, Geneva, sans-serif; 
	color: #999999;
	font-size:10PT;
	font-weight: bold;
	text-decoration:none }
.GROUPBOX {
	background-color:#333333 }
.GROUPBOXLAYER {
	position:absolute;
	font-family:Arial, Geneva, arial, sans-serif; 
	font-size:14pt;
	color:#000000;
	font-weight:bold;
	visibility:hidden }
.GROUPBOXTEXT {
	font-family:Arial, Geneva, arial, sans-serif; 
	font-size:12pt;
	color:#000000;
	font-weight:bold }

-->
    </style>
  </head>
  <body onload="return document.forms[0].j_username.focus();">
    <div style="width: 780px">
      <h1 align="center" style="padding: 5px; border: blue 1px solid;" class="clsTitleBody">로그인</h1>
      <form mane="form1" action="j_security_check" method="POST">
        <table>
          <thead>
            <tr class="vrTableHeader" height="24px" style="vertical-align: middle;">
              <th align="center" width="160px">구분</th>
              <th align="center" width="620px">내용</th>
            </tr>
          </thead>
          <tbody>
            <tr class="clsOddTableRow">
              <td style="text-align: right;" width="160px">로그인명 : </td>
              <td><input type="text" name="j_username" /></td>
            </tr>
            <tr class="clsEvenTableRow">
              <td style="text-align: right;" width="160px">패스워드 : </td>
              <td><input type="password" name="j_password" /></td>
            </tr>
            <tr class="clsOddTableRow">
              <td style="text-align: center;" colspan="2"><input type="submit" class="button" value="로그인" /></td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  </body>
</html>