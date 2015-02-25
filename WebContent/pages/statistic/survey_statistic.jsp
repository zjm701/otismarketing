<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.otis.marketing.entity.Statistic, com.otis.marketing.entity.StatisticItem, java.util.List"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Survey Statistic</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css"/>
<script type="text/javascript" src="<%=path%>/thirdparty/dataTables/js/jquery.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript">

$(function () {
	<%
		List<Statistic> list = (List<Statistic>)session.getAttribute("currentStatList");
		int index = 0;
		for (Statistic stat : list) {
	%>
	$('#container<%=index++ %>').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: '<%=stat.getTitle() %>'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [<%=stat.getOptionString() %>],
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: '单位(人)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: '人选择'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true
                }
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: -40,
            y: 100,
            floating: true,
            borderWidth: 1,
            backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
            shadow: true
        },
        credits: {
            enabled: false
        },
        series: [{
            
            data: [<%=stat.getTotalString() %>]
        }]
    });
	<%
		}
	%>
});
</script>
</head>
<body>
<a href="<%=path%>/statistic/export?surveyId=<%=request.getAttribute("surveyId") %>">导出统计结果</a>
<div class="container clearfix">
	<!--sidebar-->
    <div class="main-wrap">
    <%
    index = 0;
    for (Statistic stat : list) {
    %>
    	<table width="80%">
			<tr>
				<td>
					<div id="container<%=index %>" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
				</td>
				<td>
					<div class="main-wrap">
						<div class="crumb-wrap">
							<div class="crumb-list">
					    		<table class="display" cellspacing="0" width="100%">
					    			<tr>
					    				<th>选项</th>
					    				<th>选择人数</th>
					    				<th>百分比</th>
					    				<th><a href="<%=path%>/statistic/export?surveyId=<%=request.getAttribute("surveyId") %>&index=<%=index++ %>">导出当前结果</a></th>
					    			</tr>
    <%
    	for (StatisticItem item : stat.getItems()) {
	%>
									<tr>
					    				<td><%=item.getOptionDesc() %></td>
					    				<td><%=item.getTotal() %></td>
					    				<td><%=item.getPercentage()*100 %>%</td>
					    			</tr>
	<%    		
    	}
    %>
					    		</table>
					    	</div>
					    </div>
					</div>
				</td>
			</tr>
		</table>
    <%	
    }
    %>
    </div>
</div>
</body>
</html>