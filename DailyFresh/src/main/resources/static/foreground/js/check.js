function setCookie(name, value) {
    var exp = new Date();
    exp.setTime(exp.getTime() +  30 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}

function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

function checkCookie() {
    if (getCookie("userName") == null) {
        alert("未登录!");
        window.location.href = "login.html";
    }
}

function clearCookie() {
    delCookie("userName");
    window.location.href = "login.html";
}
