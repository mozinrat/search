<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page session="true"%>
<html>
<head>
<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/static/css/home.css"/>" rel="stylesheet">
</head>
<body>
	<div class="container-fluid"><img src="<c:url value="/static/img/ercLogo.gif"/>" alt="erecycling" ></div>
	<div class="navbar">
	  <div class="navbar-inner bg-black">
	    <div class="container-fluid ">
	     <ul class="nav">
	     <li class="dropdown">
	      <a href="#" class="dropdown-toggle text-color" >Device Prioritization Administration</a>
	      </li></ul>
		  <ul class="nav pull-right text-color">
		   	<c:if test="${pageContext.request.userPrincipal.name != null}">
				<strong>Welcome : ${pageContext.request.userPrincipal.name}</strong> 
				<br><a href="javascript:formSubmit()"> Logout</a>
			</c:if>
          </ul>
        </div>
      </div>
      </div>
      <c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
	</form>
      <div class="container-fluid">
      <div class="row-fluid">
    <div class="span6" id="textSubHeader"><h3>Upload Device Prioritization List</h3></div><br></div>
	
	
	<div class="row-fluid">
			<spring:hasBindErrors htmlEscape="true" name="fileUpload">
				<c:if test="${errors.errorCount gt 0}">
					<div class="span7 alert alert-error">  
				  		<c:forEach items="${errors.allErrors}"	var="error">
							<strong><spring:message code="${error.code}" arguments="${error.arguments}"	text="${error.defaultMessage}" /></strong>
							<br>
						</c:forEach>
					</div>
				</c:if>	
			</spring:hasBindErrors>
				<c:if test="${fn:length(fileErrors) gt 0}">
					<div class="span7 alert alert-error">
						<c:forEach items="${fileErrors}" var="file">
							<strong>${file}</strong><br>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${not empty fileSuccess}">
					<div class="span6 alert alert-success">
						<strong>${fileSuccess}</strong>
					</div>
				</c:if>
				<c:if test="${not empty fileNotFound}">
					<div class="span7 alert alert-error">
						<strong>${fileNotFound}</strong>
					</div>
				</c:if>
				<c:if test="${not empty fileUploadFail}">
					<div class="span7 alert alert-error">
						<strong>${fileUploadFail}</strong>
					</div>
				</c:if>
		</div>
<div class="row-fluid">
	<div class="well span7">
	<table cellpadding="10">
	<c:if test="${not empty programList}">
		<tr>
			<td><label for="program" class="label-bold">Programs</label></td><td></td>
			<td>
			<select name="program" id="programSelect">
					<option value="">---Select	Program---</option>
					<c:forEach items="${programList}" var="program">
					<c:if test="${program.programName ne 'ALL'}">
						<option value="${program.id}"	${program.id==programValue ? 'selected' : ''}>${program.programName}</option>
					</c:if>
					</c:forEach>
			</select>
			</td>
		</tr>
	</c:if>
</table>	
	<div id="attributes-div">
			<%@include file="attribute.jsp"%>
	</div>
</div>
</div>
</div>
	<script src="<c:url value="/static/js/jquery.min.js"/>"></script>
	<script type="text/javascript">
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
		
		$(function() {
			var cc = 0;
			$("#programSelect").click(function() {
				cc++;
				if (cc === 200) {
					$(this).change();
					cc = 0;
				}
			}).change(function() {
				var program = $(this).val();
				$.get("getAttributes?program="+program, function(data) {
					 $('#attributes-div').empty();
	 				 $('#attributes-div').html(data);
				});
			});
		});
	</script>
</body>
</html>