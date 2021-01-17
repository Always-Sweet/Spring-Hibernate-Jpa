/**
 * 初始化
 */
function init() {
    createBreadcrumb(navigation, "1");
}

/**
 * 添加图书
 */
function save() {
    const bookForm = document.getElementById("bookForm");
    var url = bookForm.action;
    ajax({
        url: url,
        type: "post",
        data: formData(bookForm),
        dataType: "json",
        contentType: "application/json",
        timeout: "10000",
        success: function (data) {
            if (data.code === '100') {
                disabledForm(bookForm);
                alert("添加成功");
                bookForm.querySelector("button[type='submit']").disabled = true;
            } else {
                alert(data.error);
            }
        },
        error: function (err) {
            console.log(err);
        }
    })
    return false;
}