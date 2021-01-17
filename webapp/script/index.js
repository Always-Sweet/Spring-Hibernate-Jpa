// 表头
var head = [{
    index: "no",
    title: "序号",
    className: "table_center",
    width: "50"
}, {
    index: "name",
    title: "书名",
    className: "table_left",
    width: "25%"
}, {
    index: "author",
    title: "作者",
    className: "table_center",
    width: "20%"
}, {
    index: "price",
    title: "价格",
    className: "table_right",
    width: "20%"
}, {
    index: "storageDate",
    title: "入库时间",
    className: "table_center"
}];

// 选中的书籍
var checkRow = [];
// 单页大小
var pageSize = 5;
// 页码
var currentPage = 1;

// 初始化页面
function init() {
    createBreadcrumb(navigation, "-1");
    loadBookList(1);
}

/**
 * 加载表头
 */
function loadTableTh() {
    const bookTable = document.getElementById("bookList");
    let tr = document.createElement("tr");
    let fixedWidth = head.filter(width => !!width.width && width.width.indexOf("%") === -1)
        .reduce((total, width) => {
            return width.width;
        }, 0);
    let th = document.createElement("th");
    th.style.width = "25px";
    tr.appendChild(th);
    for (let j = 0; j < head.length; j++) {
        let th = document.createElement("th");
        th.innerText = head[j].title;
        th.setAttribute("class", "table_center");
        if (!head[j].width || head[j].width.indexOf("%") === -1) {
            th.style.width = fixedWidth + "px";
        } else {
            th.style.width = "calc(" + head[j].width + ")";
        }
        tr.appendChild(th);
    }
    bookTable.appendChild(tr);
}

/**
 * 加载书籍列表
 */
function loadBookList(page) {
    var bookTable = document.getElementById("bookList");
    // 清空子元素
    while(bookTable.hasChildNodes()) {
        bookTable.removeChild(bookTable.firstElementChild);
    }
    loadTableTh();
    ajax({
        url: "books/all?pageNum=" + page + "&pageSize=" + pageSize,
        type: "GET",
        data: {},
        dataType: "json",
        contentType: "application/json",
        timeout: "10000",
        success: function (data) {
            if (!data) return;
            if (data.code === '100') {
                for (let i = 0; i < data.result.data.length; i++) {
                    var tr = document.createElement("tr");
                    var book = data.result.data[i];

                    let checktd = document.createElement("td");
                    let checkBok = document.createElement("input");
                    checkBok.setAttribute("type", "checkbox")
                    checktd.setAttribute("class", "table_center");
                    checkBok.onclick = function (e) {
                        selectRow(e, data.result.data[i]);
                    }
                    checktd.appendChild(checkBok);
                    tr.appendChild(checktd);

                    var no = document.createElement("td");
                    no.innerText = i + 1;
                    no.setAttribute("class", "table_center");
                    tr.appendChild(no);

                    var keys = Object.keys(book);
                    if (!keys) continue
                    for (let m in head) {
                        for (var j = 0; j < keys.length; j++) {
                            if (head[m].index === keys[j]) {
                                var td = document.createElement("td");
                                td.innerText = book[keys[j]];
                                td.setAttribute("class", head[m].className);
                                tr.appendChild(td);
                            }
                        }
                    }
                    bookTable.appendChild(tr);
                }
            } else {
                alert(data.error);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}

/**
 * 选择行
 * @param e
 * @param row
 */
function selectRow(e, row) {
    if (e.target.checked === true) {
        checkRow.push(row);
    } else {
        checkRow = checkRow.filter(obj => obj.id !== row.id);
    }
}

// 书籍删除
function remove() {
    if (checkRow.length === 0) {
        alert("请选择书籍");
    }

    ajax({
        url: "books",
        type: "DELETE",
        data: checkRow.map(book => book.id),
        dataType: "json",
        contentType: "application/json",
        timeout: "10000",
        success: function (data) {
            if (data.code === '100') {
                alert("书籍删除成功");
                loadBookList();
            } else {
                alert("书籍删除异常：" + data.error);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}