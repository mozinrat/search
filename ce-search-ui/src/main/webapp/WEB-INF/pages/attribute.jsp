<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page session="true"%>

<html>
<body>
<table cellpadding="10">
	<c:forEach items="${attributeList}" var="attribute">
		
			<tr>
				<form:form action="?" enctype="multipart/form-data" name="${attribute.id}"	id="${attribute.id}" method="post" modelAttribute="fileUpload"	commandName="fileUpload">
					<td><div class="control-group"><label for="${attribute.name}" class="label-bold">${attribute.description} List Upload</label>
				<div class="controls">	<input type="file" name="file" id="${attribute.name}" form="${attribute.id}"></div>
						<input type="hidden" name="attribute" id="attributeName" value="${attribute.id}" form="${attribute.id}"> 
						<input type="hidden" name="program" id="program" value="${programValue}" form="${attribute.id}"></div></td>
					<td>
						<button type="submit" formaction="uploadFile" form="${attribute.id}">Upload</button>
					</td>
					<td><input type="submit" formaction="download" name="download" id="download" title="Download" value="Download" form="${attribute.id}" /></td>
				</form:form>
			</tr>
	

	</c:forEach>
		</table>
	<script src="<c:url value="/static/js/jquery.min.js"/>"></script>
</body>
</html>