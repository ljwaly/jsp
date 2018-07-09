

<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="../common/taglibs.jsp"%>

<c:set var="testABC" value="15902188397" scope="request" />
<%
	String testABC = (String) request.getAttribute("testABC");
	String testABCD = testABC.substring(0, testABC.length() - 3);
	request.setAttribute("testABCD", testABCD);
%>
${testABCD}
