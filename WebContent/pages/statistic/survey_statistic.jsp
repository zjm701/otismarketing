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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Survey Statistic</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css"/>
<script type="text/javascript" src="<%=path%>/thirdparty/dataTables/js/jquery.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript">
$(function () {
    $('#container0').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: 'Survey for favorit brand'
        },
        subtitle: {
            text: 'Source: Otis.org'
        },
        xAxis: {
            categories: ['Benz', 'BMW', 'Audi'],
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Unit(People)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: 'p'
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
            
            data: [107, 31, 635]
        }]
    });
    $('#container1').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: 'When did you get this brand'
        },
        subtitle: {
            text: 'Source: Otis.org'
        },
        xAxis: {
            categories: ['3 months ago', '6 months ago', '9 months ago'],
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Unit(People)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: 'p'
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
            
            data: [97, 31, 4]
        }]
    });
});
</script>
</head>
<body>
<div class="container clearfix">
	<!--sidebar-->
    <div class="main-wrap">
        <div> <center>Your favorit brand survey</center></div>
		<div id="container0" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
<div id="container1" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
    </div>
</div>
</body>
</html>