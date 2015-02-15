<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Otis后台管理</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/admin_login.css" />
</head>
<body>
<div class="admin_login_wrap">
    <h1>Otis后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="login.do" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="username" id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="password" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <%if(request.getAttribute("loginFailureMsg") == null){%>
				    	<%=""%>
				    </br>
				    <%}else{ %>
				    <li>
				    	 <%= request.getAttribute("loginFailureMsg")%>
				    </li>
				    <%}%>
                    <li>
                        <input type="submit" tabindex="3" value="确定" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
</body>
</html>