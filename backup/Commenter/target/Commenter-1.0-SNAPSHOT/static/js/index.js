$(function () {
    var size=$(window).width()/18;
    console.log(size);
    $('html').css('font-size',size);
    var scroll_wrapper = new IScroll('#scroll_wrapper');

    function attachEvent(src, cb) {
        $(src).unbind();
        $(src).bind("touchstart", function (event) {
            $(this).data("touchon",true);
            $(this).addClass("pressed");
        });
        $(src).bind("touchend", function (event) {
            $(this).removeClass("pressed");
            if ($(this).data("touchon")) {
                cd.bind(this)();
            }
            $(this).data("touchon",false);
        });
        $(src).bind("touchmove", function (event) {
            $(this).data("touchon",false);
            $(this).removeClass("pressed");
            if ($(this).data("touchon")) {
                cd.bind(this)();
            }
        });
    }
});