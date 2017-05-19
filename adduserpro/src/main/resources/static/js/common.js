/**
 * Created by yunhao on 2017/5/19.
 */
$(document).ready(function () {
    var offsetWidth = document.body.offsetWidth;
    $('#father-box').css({
        'height': (offsetWidth/5)+"px",
        'width': offsetWidth+"px"
    });
    $('#line').animate({
        'margin-left': "100%"
    }, 1000);
    $('#lineBox').delay(1000).animate({
        'height': 0
    }, 0);

    $('#father-box').delay(500).animate({
        'opacity': 1
    }, 1000);

    var topDownWidth = offsetWidth / 10;
    var topDownHeight = offsetWidth / 300;
    var topDownLeft = (offsetWidth - topDownWidth) / 2;
    $('#top-down').css({
        'left': topDownLeft+"px",
        'width':topDownWidth+"px",
        'height': 0
    });
    $('#top-down').delay(1500).animate({
        'height':topDownHeight+"px"
    });
    var imgWidth = topDownWidth / 1.5;
    var imgLeft = (offsetWidth - imgWidth) / 2;
    var imgBottom = 2 * topDownHeight;
    $('#rabbit-head-box').css({
        'left': imgLeft+"px",
        'bottom': imgBottom+"px"
    });
    $('#rabbit-head-img').css({
        'width': imgWidth+"px"
    });
    $('#rabbit-head').css({
        'margin-bottom': "-"+($('#rabbit-head-img').height()+imgBottom)+"px"
    });
    $('#rabbit-head').delay(2000).animate({
        'margin-bottom': "-"+($('#rabbit-head-img').height()/5)+"px"
    });

    $('#down-top').css({
        'width': topDownWidth+"px",
        'height':0 ,
        'left': topDownLeft+"px",
        'background-color': 'black'
    });
    $('#down-top').delay(1500).animate({
        'height': topDownHeight+"px"
    }, 500);

    var hatWidth =topDownHeight * 1.5;
    var hatDownWidth = topDownWidth * 2 / 3;
    var hatHeight = hatDownWidth * 3 / 4;
    $('#hatLeft').css({
        'height': 0,
        'width': hatWidth+"px",
        'top': hatWidth+"px",
        'left': (offsetWidth - hatDownWidth - hatWidth) / 2 - hatWidth + "px"
    });
    $('#hatRight').css({
        'height': 0,
        'width': hatWidth+"px",
        'top': hatWidth+hatHeight+"px",
        'left': (offsetWidth + hatDownWidth) / 2 + hatWidth/2+ "px"
    });
    $('#hatDown').css({
        'height': hatWidth+"px",
        'width': 0,
        'top': hatHeight+"px",
        'left': (offsetWidth - hatDownWidth) / 2 -hatWidth + "px"
    });
    $('#hatLeft').delay(1500).animate({
        'height': hatHeight+"px"
    }, 500);
    $('#hatDown').delay(2000).animate({
        'width': hatDownWidth+hatWidth*2+"px",
    }, 500);
    $('#hatRight').delay(2500).animate({
        'height': hatHeight+"px",
        'top': hatWidth+"px"
    }, 500);

    $('#teamname').css({
        'left': topDownLeft+"px",
        'top': hatWidth*4 + hatHeight+"px",
        'width': topDownWidth+"px"
    });
    $('#teamname').delay(2700).animate({
        'opacity': '1'
    }, 500);
});