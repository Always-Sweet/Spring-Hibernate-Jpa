var navigation = {
    index: "-1",
    title: "home",
    url: "",
    children: [{
        index: "1",
        title: "addBook",
        url: "addBook.html"
    }]
}

/**
 * 面包屑DOM构造器
 * index不允许重复，只寻找一个匹配index的节点
 *
 * @param navigation 导航目录 默认结构：节点拥有：index、title, url和children属性
 * @param index
 */
function createBreadcrumb(navigation, index) {
    const element = document.getElementById("navigation");
    const separator = " > ";
    let href = document.createElement("a");
    var url = window.location.href;
    var pathName = window.location.pathname;
    var rootUrl = url.substring(0, url.indexOf(pathName)) + pathName.substring(0, pathName.indexOf("/", 1));

    if (!navigation) return null;
    if (navigation["index"] === index) {
        href.setAttribute("href", !!navigation["url"] ?  navigation["url"] : rootUrl);
        href.innerText = navigation["title"];
        let text = document.createTextNode(separator);
        element.appendChild(text);
        element.appendChild(href);
        return true;
    } else if(!!navigation["children"] && navigation["children"].length > 0) {
        for (let i in navigation["children"]) {
            let result = createBreadcrumb(navigation["children"][i], index);
            if (result === true) {
                let href = document.createElement("a");
                href.setAttribute("href", !!navigation["url"] ? navigation["url"] : rootUrl);
                href.innerText = navigation["title"];
                let text = document.createTextNode(separator);
                element.insertBefore(href, element.childNodes[0]);
                element.insertBefore(text, element.childNodes[0]);
                return true;
            }
        }
        return false;
    }
}

/**
 * 获取表单数据
 *
 * @param formDom
 */
function formData(formDom) {
    var data = {};
    var formData = formDom.getElementsByTagName("input");
    for (let i in formData) {
        data[formData[i]["name"]] = formData[i].value;
    }
    return data;
}

/**
 * 锁定表单禁止操作
 */
function disabledForm(formDom) {
    var formData = formDom.getElementsByTagName("input");
    for (let i in formData) {
        formData[i].disabled = true;
    }
}