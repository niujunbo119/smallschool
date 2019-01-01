/*$(function () {
    $('#net-loading').show();
    ajaxHttpRequest('v1/index', {
        jsonpCallback: 'handler',
        success: function (data, status) {
            // 请求出现异常
            if (status != "success") {
                showError("请求出现异常！");
                $('#net-loading').hide();
                return;
            }
            $('#net-loading').hide();
        },
        error: function (errorType, error) {
            showError("ERROR--请求出现异常！");
            $('#net-loading').hide();
        }
    });
});*/

function handler(data) {
    if (!data.meta.success) {
        showError(data.meta.msg);
        $('#net-loading').hide();
        return;
    }
    var main = template('main-temp', data);
    $('.main-wrap').html(main);

    $('#slideshow').swipeSlide({
        autoSwipe: true,//自动切换默认是
        speed: 3000,//速度默认4000
        continuousScroll: true,//默认否
        transitionType: 'cubic-bezier(0.22, 0.69, 0.72, 0.88)',//过渡动画linear/ease/ease-in/ease-out/ease-in-out/cubic-bezier
        lazyLoad: true,//懒加载默认否
        firstCallback: function (i, sum, me) {
            me.find('.dot').children().first().addClass('cur');
        },
        callback: function (i, sum, me) {
            me.find('.dot').children().eq(i).addClass('cur').siblings().removeClass('cur');
        }
    });
    $('#notify-txt').swipeSlide({
        autoSwipe: true,//自动切换默认是
        speed: 5000,//速度默认4000
        continuousScroll: true,//默认否
        transitionType: 'ease-in'
    });

    $('.sub').hide();
    $('.count').hide();

    // 购物车商品总价格价格
    setProductTotalPrice();

    // 购买
    $(".add").click(function () {
        $('#buy-loading').show();
        var $add = $(this);

        if($add.attr("working") == "true") {
            showError("操作太快了，休息一下吧！");
            return;
        } else {
            $add.attr("working","true");
        }
        var productId = $add.parents('.item').attr("data-id");
        ajaxHttpRequest('v1/token', {
            jsonpCallback: 'token',
            success: function (data, status) {
                if (status != "success") {
                    showError("请求出现异常！");
                    $('#net-loading').hide();
                    return;
                }
                if (!data.meta.success) {
                    showError(data.meta.msg);
                    $('#net-loading').hide();
                    return;
                }
                if (!data.data) {
                    /*ajaxHttpRequest('product/v1/stock', {
                        jsonpCallback: 'checkStock',
                        data: {
                            productId: productId
                        },
                        success: function (data, status) {
                            if (status != "success") {
                                showError("请求出现异常");
                                $('#buy-loading').hide();
                                $add.attr("working","false");
                                return;
                            }
                            if (!data.meta.success) {
                                showError(data.meta.msg);
                                $('#buy-loading').hide();
                                $add.attr("working","false");
                                return;
                            }
                            animation($add);
                            // 数量增加
                            var price = $add.parent().siblings(".price").children("strong").text();
                            var counts = addProductCount(productId, price);
                            var localData = {
                                data : counts
                            };
                            addCount($add, localData);
                            // 金额增加
                            setProductTotalPrice();
                            $('#buy-loading').hide();
                            $add.attr("working","false");
                        },
                        error: function (errorType, error) {
                            $('#buy-loading').hide();
                            showError("ERROR--请求出现异常");
                        }
                    });*/
                    goLogin();
                } else {
                    ajaxHttpRequest('v1/add', {
                        jsonpCallback: 'add',
                        data: {
                            productId: productId
                        },
                        success: function (data, status) {
                            if (status != "success") {
                                showError("请求出现异常");
                                $('#buy-loading').hide();
                                $add.attr("working","false");
                                return;
                            }
                            if (!data.meta.success) {
                                showError(data.meta.msg);
                                $('#buy-loading').hide();
                                $add.attr("working","false");
                                return;
                            }
                            animation($add);
                            // 数量增加
                            addCount($add, data);
                            // 金额增加
                            setProductTotalPrice();
                            $('#buy-loading').hide();
                        },
                        error: function (errorType, error) {
                            $('#buy-loading').hide();
                            showError("ERROR--请求出现异常");
                        }
                    });
                }
                $add.attr("working","false");
            },
            error: function (errorType, error) {
                showError("ERROR--请求出现异常！");
                $('#net-loading').hide();
            }
        });
    });

    // 减少操作
    $(".sub").click(function () {
        $('#buy-loading').show();
        var $sub = $(this);

        if($sub.attr("working") == "true") {
            showError("操作太快了，休息一下吧！");
            return;
        } else {
            $sub.attr("working","true");
        }
        var productId = $sub.parents('.item').attr("data-id");
        ajaxHttpRequest('v1/token', {
            jsonpCallback: 'token',
            success: function (data, status) {
                if (status != "success") {
                    showError("请求出现异常！");
                    $('#net-loading').hide();
                    return;
                }
                if (!data.meta.success) {
                    showError(data.meta.msg);
                    $('#net-loading').hide();
                    return;
                }
                if (!data.data) {
                    /*ajaxHttpRequest('product/v1/stock', {
                        jsonpCallback: 'checkStock',
                        data: {
                            productId: productId
                        },
                        success: function (data, status) {
                            if (status != "success") {
                                showError("请求出现异常");
                                $('#buy-loading').hide();
                                $add.attr("working","false");
                                return;
                            }
                            if (!data.meta.success) {
                                showError(data.meta.msg);
                                $('#buy-loading').hide();
                                $add.attr("working","false");
                                return;
                            }
                            var price = $sub.parent().siblings(".price").children("strong").text();
                            var counts = subProductCount(productId, price);
                            var localData = {
                                data : counts
                            };
                            subCount($sub, localData);
                            setProductTotalPrice();
                            $('#buy-loading').hide();
                            $sub.attr("working", "false");
                        },
                        error: function (errorType, error) {
                            $('#buy-loading').hide();
                            showError("ERROR--请求出现异常");
                        }
                    });*/
                    //goLogin();
                } else {
                    ajaxHttpRequest('v1/sub', {
                        jsonpCallback: 'sub',
                        data: {
                            productId: productId
                        },
                        success: function (data, status) {
                            if (status != "success") {
                                showError("请求出现异常");
                                $('#buy-loading').hide();
                                $sub.attr("working","false");
                                return;
                            }
                            if (!data.meta.success) {
                                showError(data.meta.msg);
                                $('#buy-loading').hide();
                                $sub.attr("working","false");
                                return;
                            }
                            subCount($sub, data);
                            setProductTotalPrice();
                            $('#buy-loading').hide();
                            $sub.attr("working","false");
                        },
                        error: function (errorType, error) {
                            showError("ERROR--请求出现异常");
                            $('#buy-loading').hide();
                        }
                    });
                }
            },
            error: function (errorType, error) {
                showError("ERROR--请求出现异常！");
                $('#net-loading').hide();
            }
        });
    });

}
// 添加数量
function addCount($add, data) {
    $add.siblings('.sub').show();
    $add.prev('.count').show();
    $add.prev().text(data.data);
    $add.parent().siblings(".price").css({
        "font-size":"14px",
        "color":"white",
        "position":"absolute",
        "bottom":"82px",
        "left":"0",
        "border-radius":"6px",
        "background":"#EF4F4F"
    }).children('strong').css("font-size","14px");
}

// 减少数量
function subCount($sub, data) {
    var count = parseInt(data.data);
    if(count == 0) {
        $sub.hide();
        $sub.siblings('.count').hide();
        $sub.parent().siblings(".price").removeAttr('style').children('strong').removeAttr('style');
    }
    $sub.next().text(count);
}

// 动画
function animation($add) {
    // 动画效果
    var imgSrc = $add.parents(".item").children('.pic').children('img').attr('src');
    var imgObj = $('<img src="' + imgSrc + '">').appendTo("body").css({
        "width": "30px",
        "height": "30px",
        "border-radius": "50px",
        "position": "absolute",
        "top": toInteger($add.offset().top) + toInteger($add.css("width"))/2-15,
        "left": toInteger($add.offset().left)+ toInteger($add.css("height"))/2-15,
    });
    var bool = new Parabola({
        el: imgObj,
        callback: function () {

        },
        stepCallback: function (x, y) {
        }
    });
    // 设置配置参数
    bool.setOptions({
        targetEl: $("#cart"),
        curvature: 0.01,
        duration: 600
    });
    // 开始运动
    bool.start();
}

// 转换成Int类型
function toInteger(text){
    text = parseInt(text);
    return isFinite(text) ? text : 0;
}
