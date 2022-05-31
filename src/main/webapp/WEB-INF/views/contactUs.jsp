	<%@include file="/WEB-INF/views/header.jsp" %>
	<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
	<!--寮曠敤鐧惧害鍦板浘API-->
<style type="text/css">
    .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
    .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
	 <div id="contact-page" class="container">
    	<!-- <div class="bg">
	    	<div class="row">    		
	    		<div class="col-sm-12">    			   			
					<h2 class="title text-center">Contact <strong>Us</strong></h2>  
					鐧惧害鍦板浘瀹瑰櫒
  
					</div>  			    				    				
					
				</div>			 		
			</div>     -->	
    		<div class="row">  	
	    		<div class="col-sm-8">
	    		<div  class="contact-map" id="dituContent"></div>
	    			<!-- <div class="contact-form">
	    				<h2 class="title text-center">Get In Touch</h2>
	    				<div class="status alert alert-success" style="display: none"></div>
				    	<form id="main-contact-form" class="contact-form row" name="contact-form" action="EmailSendingServlet" method="post">
				            <div class="form-group col-md-6">
				                <input type="text" name="name" class="form-control" required="required" placeholder="Name">
				            </div>
				            <div class="form-group col-md-6">
				                <input type="email" name="recipient" class="form-control" required="required" placeholder="Email">
				            </div>
				            <div class="form-group col-md-12">
				                <input type="text" name="subject" class="form-control" required="required" placeholder="Subject">
				            </div>
				            <div class="form-group col-md-12">
				                <textarea name="content" id="message" required="required" class="form-control" rows="8" placeholder="Your Message Here"></textarea>
				            </div>                        
				            <div class="form-group col-md-12">
				                <input type="submit" name="submit" class="btn btn-primary pull-right" value="Submit">
				            </div>
				        </form>
	    			</div>
	     -->		</div>
	    		<div class="col-sm-4">
	    			<div class="contact-info">
	    				<h2 class="title text-center">Contact Info</h2>
	    				<address>
	    					<p>ECJTU</p>
							<p> 808, Shuanggang East Street</p>
							<p>Economic and Technological Development Zone</p>
							<p>Nanchang City, Jiangxi Province</p>
							<p>Fax: 1-714-252-0026</p>
							<p>Email: info@e-shopper.com</p>
	    				</address>
	    				<div class="social-networks">
	    					<h2 class="title text-center">Social Networking</h2>
							<ul>
								<li>
									<a href="#"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-google-plus"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-youtube"></i></a>
								</li>
							</ul>
	    				</div>
	    			</div>
    			</div>    			
	    	</div>  
    	</div>	
    </div><!--/#contact-page-->
    <script type="text/javascript">
    //鍒涘缓鍜屽垵濮嬪寲鍦板浘鍑芥暟锛?
    function initMap(){
        createMap();//鍒涘缓鍦板浘
        setMapEvent();//璁剧疆鍦板浘浜嬩欢
        addMapControl();//鍚戝湴鍥炬坊鍔犳帶浠?
        addMarker();//鍚戝湴鍥句腑娣诲姞marker
    }
    
    //鍒涘缓鍦板浘鍑芥暟锛?
    function createMap(){
        var map = new BMap.Map("dituContent");//鍦ㄧ櫨搴﹀湴鍥惧鍣ㄤ腑鍒涘缓涓€涓湴鍥?
        var point = new BMap.Point(115.876018,28.749703);//瀹氫箟涓€涓腑蹇冪偣鍧愭爣
        map.centerAndZoom(point,17);//璁惧畾鍦板浘鐨勪腑蹇冪偣鍜屽潗鏍囧苟灏嗗湴鍥炬樉绀哄湪鍦板浘瀹瑰櫒涓?
        window.map = map;//灏唌ap鍙橀噺瀛樺偍鍦ㄥ叏灞€
    }
    
    //鍦板浘浜嬩欢璁剧疆鍑芥暟锛?
    function setMapEvent(){
        map.enableDragging();//鍚敤鍦板浘鎷栨嫿浜嬩欢锛岄粯璁ゅ惎鐢?鍙笉鍐?
        map.enableScrollWheelZoom();//鍚敤鍦板浘婊氳疆鏀惧ぇ缂╁皬
        map.enableDoubleClickZoom();//鍚敤榧犳爣鍙屽嚮鏀惧ぇ锛岄粯璁ゅ惎鐢?鍙笉鍐?
        map.enableKeyboard();//鍚敤閿洏涓婁笅宸﹀彸閿Щ鍔ㄥ湴鍥?
    }
    
    //鍦板浘鎺т欢娣诲姞鍑芥暟锛?
    function addMapControl(){
        //鍚戝湴鍥句腑娣诲姞缂╂斁鎺т欢
	var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
	map.addControl(ctrl_nav);
        //鍚戝湴鍥句腑娣诲姞缂╃暐鍥炬帶浠?
	var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
	map.addControl(ctrl_ove);
        //鍚戝湴鍥句腑娣诲姞姣斾緥灏烘帶浠?
	var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
	map.addControl(ctrl_sca);
    }
    
    //鏍囨敞鐐规暟缁?
    var markerArr = [{title:"鎴戠殑鏍囪",content:"鎴戠殑澶囨敞<br/>姹熻タ鐪佸崡鏄屽競缁忔祹鎶€鏈紑鍙戝尯鍙屾腐涓滃ぇ琛808鍙<br/>(0791)87046576",point:"115.873619|28.750131",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
		 ];
    //鍒涘缓marker
    function addMarker(){
        for(var i=0;i<markerArr.length;i++){
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0,p1);
			var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point,{icon:iconImg});
			var iw = createInfoWindow(i);
			var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
			marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                        borderColor:"#808080",
                        color:"#333",
                        cursor:"pointer"
            });
			
			(function(){
				var index = i;
				var _iw = createInfoWindow(i);
				var _marker = marker;
				_marker.openInfoWindow(_iw);
				_marker.addEventListener("click",function(){
				    this.openInfoWindow(_iw);
			    });
			    _iw.addEventListener("open",function(){
				    _marker.getLabel().hide();
			    })
			    _iw.addEventListener("close",function(){
				    _marker.getLabel().show();
			    })
				label.addEventListener("click",function(){
				    _marker.openInfoWindow(_iw);
			    })
				if(!!json.isOpen){
					label.hide();
					_marker.openInfoWindow(_iw);
				}
			})()
        }
    }
    //鍒涘缓InfoWindow
    function createInfoWindow(i){
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
        return iw;
    }
    //鍒涘缓涓€涓狪con
    function createIcon(json){
        var icon = new BMap.Icon("<%=basePath%>images/home/pin.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
        return icon;
    }
    
    initMap();//鍒涘缓鍜屽垵濮嬪寲鍦板浘
</script>
<%@include file="/WEB-INF/views/footer.jsp" %>