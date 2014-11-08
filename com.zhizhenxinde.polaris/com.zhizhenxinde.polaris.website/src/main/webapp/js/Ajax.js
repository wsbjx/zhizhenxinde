/**
 * 前端与后端交互的对象
 */
var Ajax = function() {

	this.prototype.GET = function(uri) {
		return sendRequest(uri, {}, "GET");
	};

	this.prototype.POST = function(uri, data) {
		return sendRequest(uri, data, "POST");
	};

	this.prototype.DELETE = function(uri) {
		return sendRequest(uri, {}, "DELETE");
	};

	this.prototype.PUT = function(uri) {
		return sendRequest(uri, {}, "PUT");
	};

	function sendRequest(uri, data, method) {
		var json = JSON.stringify(data);
		$.ajax({
			type : method,
			async : false,
			url : "api/" + uri,
			data : json,
			contentType : "application/json; charset=UTF-8",
			dataType : "json",
			cache : false,
			error : function(obj) {
				console.log("sendRequest failed! URI:" + uri + ", JSON:" + json);
			}
		});
	}
};

var ajax = new Ajax();
