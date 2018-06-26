// 자바스크립트 함수를 모아 놓은 라이브러리
var bitcamp = new Object();

bitcamp.ajax = (url, settings) => {
	if(settings == undefined || settings == null){
		settings = {};
	}
	
	if (settings.method == undefined){
		settings.method = "GET";
	}
	
	if (settings.dataType == undefined){
		settings.dataType = "text";
	}
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4){
            if(xhr.status == 200){
            	if(settings.success == undefined)
            		return;
            	
            	if(settings.dataType == "text"){
            		settings.success(xhr.responseText);
            	} else if(settings.dataType == "json"){
            		settings.success(JSON.parse(xhr.responseText));
            	}
            } else {
            	if(settings.error){
            		settings.error();
            	}
            }
        }
    };
    xhr.open(settings.method, url, true);
    if(settings.method == "POST"){
    	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    	var qs = "";
    	if(settings.data) {
    		for(var key in settings.data) {
    			if (qs.length > 0) { qs += "&"; }
    			qs += key + "=" + encodeURIComponent(settings.data[key]);
    		}
    	}
    	xhr.send(qs);
    } else {
    	xhr.send();
    }
};

bitcamp.getJSON = (url, p1, p2) => {
    if (p1 == undefined || typeof p1 != "function"){
        bitcamp.ajax(url, {
        	"data": p1,
        	"dataType": "json",
        	"success": p2
        });
    } else if (typeof p1 == "function"){
    	bitcamp.ajax(url, {
    		"dataType": "json",
    		"success": p1
    	});
    }
};

var $ = bitcamp;