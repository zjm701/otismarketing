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
<div class="container clearfix">
	<!--sidebar-->
    <div class="main-wrap">
    <%
    index = 0;
    for (Statistic stat : list) {
    %>
    	<div id="container<%=index++ %>" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
    <%	
    }
    %>
    </div>
</div>
</body>
</html>