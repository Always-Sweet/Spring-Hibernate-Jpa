function ajax(options) {
    options = options || {}; // 当没有传入option时，默认定义一个空对象
    options.type = (options.type || "GET").toUpperCase(); // 请求类型，默认GET请求，并大写
    options.dataType = options.dataType || "json"; // 响应数据类型，默认json

    var xhr;

    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (!xhr) {
        console.log("当前浏览器不兼容ajax请求")
        return;
    }

    if (options.type === "GET") {
        xhr.open("GET", options.url, true);
        xhr.send(null);
    } else {
        xhr.open(options.type, options.url, true);
        xhr.setRequestHeader("Content-type", options.contentType);
        xhr.send(JSON.stringify(options.data))
    }

    setTimeout(function () {
        if (xhr.readyState !== 4) {
            xhr.abort()
        }
    }, options.timeout);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            var status = xhr.status;
            if (status >= 200 && status < 300 || status === 304) {
                options.success && options.success(JSON.parse(xhr.responseText));
            } else {
                options.error && options.error(status);
            }
        }
    }
}