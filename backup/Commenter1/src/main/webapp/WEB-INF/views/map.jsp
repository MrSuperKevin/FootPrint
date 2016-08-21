<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="format-detection" content="telephone=no" />
        <meta name="msapplication-tap-highlight" content="no" />
        <!-- WARNING: for iOS 7, remove the width=device-width and height=device-height attributes. See https://issues.apache.org/jira/browse/CB-4323 -->
        <meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height, target-densitydpi=device-dpi" />
        <title>我的足迹</title>
        <link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/map.css" />"/>
    </head>
    <body>

            <nav class="nav">
              <a class="navbar-btn" href="#"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>返回</a>
            </nav>

            <div id="allmap"></div>

            <p class="title">我的足迹<span class="time">2014.03.12-2016.08.21</span></p>

            <action class="map-wrap">
                <ul class="map">
                    <c:forEach items="${comments}" var="comment">
                    
                    <li class="map-item">
                        <div class="map-title active">
                            <span class="glyphicon glyphicon-map-marker local-icon" aria-hidden="true"></span>
                            <p class="time">${comment.time}</p>
                            <h1 class="landscape">{comment.place.name}</h1>
                            <p class="place">上海</p>
                        </div>

                        <div class="scroll-item">
                            <img class="comment-img" src="<c:url value="/static/img/dfmz1.png" />" alt="" style="width: 4.5rem;">
                            <div class="comment-body">
                                <p class="comment">${comment.text}</p>
                                <div class="user">
                                    <img class="user-photo" src="<c:url value="/static/img/user0.png" />" style="width: 1rem" alt="">
                                    <span class="like"><span>99</span><span class="glyphicon glyphicon-heart like-icon" aria-hidden="true"></span></span>


                                </div>
                            </div>
                        </div>
                    </li>
                    
                    </c:forEach>

                    <li class="map-item">
                        <div class="map-title">
                            <span class="glyphicon glyphicon-map-marker local-icon" aria-hidden="true"></span>
                            <p class="time">2016.04.10</p>
                            <h1 class="landscape">东方明珠</h1>
                            <p class="place">上海</p>
                        </div>

                        <div class="scroll-item">
                            <img class="comment-img" src="<c:url value="/static/img/dfmz1.png" />" alt="" style="width: 4.5rem;">
                            <div class="comment-body">
                                <p class="comment">上海是个好玩的地方上海海</p>
                                <div class="user">
                                    <img class="user-photo" src="<c:url value="/static/img/user0.png" />" style="width: 1rem" alt="">
                                    <span class="like"><span>99</span><span class="glyphicon glyphicon-heart like-icon" aria-hidden="true"></span></span>


                                </div>
                            </div>
                        </div>
                    </li>

                    <li class="map-item">
                        <div class="map-title">
                            <span class="glyphicon glyphicon-map-marker local-icon" aria-hidden="true"></span>
                            <p class="time">2016.04.10</p>
                            <h1 class="landscape">东方明珠</h1>
                            <p class="place">上海</p>
                        </div>

                        <div class="scroll-item">
                            <img class="comment-img" src="<c:url value="/static/img/dfmz1.png" />" alt="" style="width: 4.5rem;">
                            <div class="comment-body">
                                <p class="comment">上海是个好玩的地方上海海</p>
                                <div class="user">
                                    <img class="user-photo" src="<c:url value="/static/img/user0.png" />" style="width: 1rem" alt="">
                                    <span class="like"><span>99</span><span class="glyphicon glyphicon-heart like-icon" aria-hidden="true"></span></span>


                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </action>
    ${coordinate}






        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=qsESCvQwgewn0R8WH0OTE0GjOoCBXCmM"></script>
        <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="<c:url value="/static/js/iscroll-lite.js" />"></script>
        <script type="text/javascript" src="<c:url value="/static/js/index.js" />"></script>
        
        <script type="text/javascript">
            // 百度地图API功能
            map = new BMap.Map("allmap");
//            map.centerAndZoom(new BMap.Point(116.417854,39.921988), 13);
            var geolocation = new BMap.Geolocation();
            geolocation.getCurrentPosition(function(r){
                    if(this.getStatus() == BMAP_STATUS_SUCCESS){
                            var mk = new BMap.Marker(r.point);
                            map.addOverlay(mk);
                            map.panTo(r.point);
                            //alert('您的位置：'+r.point.lng+','+r.point.lat);
                    }
                    else {
                            //alert('failed'+this.getStatus());
                    }        
            },{enableHighAccuracy: true})
            var data_info = [${coordinate}];
            var opts = {
                        width : 250,     // 信息窗口宽度
                        height: 80,     // 信息窗口高度
                        title : "信息窗口" , // 信息窗口标题
                        enableMessage:true//设置允许信息窗发送短息
                       };
            for(var i=0;i<data_info.length;i++){
                var marker = new BMap.Marker(new BMap.Point(data_info[i][0],data_info[i][1]));  // 创建标注
                var content = data_info[i][2];
                map.addOverlay(marker);               // 将标注添加到地图中
                addClickHandler(content,marker);
            }
            function addClickHandler(content,marker){
                marker.addEventListener("click",function(e){
                    openInfo(content,e)}
                );
            }
            function openInfo(content,e){
                var p = e.target;
                var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
                var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
                map.openInfoWindow(infoWindow,point); //开启信息窗口
            }
        </script>
    </body>
</html>
