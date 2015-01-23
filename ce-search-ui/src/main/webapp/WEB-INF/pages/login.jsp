<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>CE-SEARCH :: Login</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/static/css/bootstrap-responsive.min.css"/>" rel="stylesheet">
</head>

<body>
<div class="container-fluid">
  <div class="row-fluid">
    <img src="<c:url value="/static/img/ercLogo.gif"/>" alt="" title="">
    <img class="pull-right" src="" alt="" title="">
  </div>
  <div class="row-fluid">
    <div class="span12">
      <h1>Welcome to CE-SEARCH</h1>
    </div>
  </div>
  <div class="row-fluid">
    <div class="span6">
		<%if (request.getParameter("error") != null) {%>
			<div  class="alert alert-error" style="line-height: 25px">Invalid Username/Password</div>
		<%}%>
		<%if (request.getParameter("disabled") != null) {%>
			<div  class="alert alert-error" style="line-height: 25px">Account locked</div>
		<%}%>
       <form method="post" action="<c:url value="/login"/>" class="form-inline well">
        <legend>Login</legend>
        <fieldset>
          <div id="usernameControl" class="control-group  ">
            <div class="controls input-prepend">
              <span class="add-on"><i class="icon-user"></i></span>
			  <input id="user_name" name="username" type="text" value="" placeholder="Username"/>
              <span class="help-inline"></span>
            </div>
          </div>
          <div id="passwordControl" class="control-group ">
            <div class="controls input-append">
               <span class="add-on"><i class="icon-lock"></i></span>
			   <input id="password" name="password" type="password"	placeholder="Password"/>
              <span class="help-inline"></span>
            </div>
          </div>
          <div><br/>
            <input class="btn btn-primary" name ="submit" type="submit" value="Login"/>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>
</body>
</html>