<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.Collection,org.springframework.security.core.GrantedAuthority,
	com.otis.marketing.security.OtisContext,org.springframework.security.core.authority.SimpleGrantedAuthority"%>
<%
String path = request.getContextPath();
%>
<div class="sidebar-wrap">
	<div class="sidebar-title">
		<h1>功能菜单</h1>
	</div>
	<div class="sidebar-content">
		<ul class="sidebar-list">
			<li>
				<ul class="sub-menu">
					<li><a href="<%=path%>/newsManagement/getAllNews"><i class="icon-font">&#xe005;</i>新闻管理</a></li>
					<li><a href="<%=path%>/survey/findAllSurvey"><i class="icon-font">&#xe004;</i>问卷管理</a></li>
					<li><a href="<%=path%>/statistic/findAllSurvey"><i class="icon-font">&#xe031;</i>问卷统计</a></li>
					<%
						Collection<GrantedAuthority> permissions = (Collection<GrantedAuthority>) OtisContext.getContextAuthorities();
						if (permissions.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
					%>
							<li><a href="<%=path%>/userManagement/goUserManagement"><i class="icon-font">&#xe003;</i>用户管理</a></li>
					<%
						}
					%>
					<li><a href="<%=path%>/appVersion/getVersionsInfoList"><i class="icon-font">&#xe009;</i>App版本管理</a></li>
				</ul>
			</li>
		</ul>
	</div>
</div>
