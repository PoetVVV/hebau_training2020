// 获取页面元素
var div = document.querySelector('.banner-box');
var img = document.getElementById('img');
var lis = document.querySelectorAll('.btn>li');
var prev = document.querySelector('.prev');
var next = document.querySelector('.next');
//定义变量表示图片的下标
var index = 0;

// 定义函数 功能是切换图片 li的背景颜色和边框颜色
function change(){
    //更换图片路径
    img.src = 'images/' + index + '.jpg';

    //那li的默认背景颜色和边框颜色取消
    for(var i = 0; i < lis.length; i++){
        lis[i].style.cssText=' border: 2px solid rgba(255,255,255,.3);background-color: rgba(0,0,0,.4);';
    }

    //更改li的背景颜色和边框颜色
    lis[index].style.cssText='border-color: rgba(0,0,0,.4);background-color: rgba(255,255,255,.3);';
}

// 定义函数 功能是自动切换图片 li的背景颜色和边框颜色
function autoChange(){
    index++;
    //判断index的范围(第五张执行完回到第一张)
    if(index > 4){
        index = 0;
    }

    //调用change函数，根据index的值自动切换图片 和 li的背景颜色、边框颜色
    change();
}
// 启动定时器 实现图片自动轮播效果
var timer = setInterval(autoChange,2000);

// 设置鼠标移入div的效果
div.onmouseover = function(){
    //停止定时器
    clearInterval(timer);
};

// 设置鼠标移出div的效果
div.onmouseout = function(){
    //重新启动定时器
    timer = setInterval(autoChange,2000);
};

//设置左边按钮被点击的效果
prev.onclick = function(){
    index--;
    // 判断index的值
    if(index == -1){
        index = 4;
    }
    //调用change函数
    change();
};

//设置右边按钮被点击的效果
next.onclick = function(){
    index++;
    //判断index的范围
    if(index > 4){
        index = 0;
    }
    //调用change函数
    change();
};

//设置点击li的效果
for(var i = 0; i < lis.length; i++){
    lis[i].id = i;
    lis[i].onclick = function(){
      //console.log(this.id);
      index  = this.id;
      //调用change函数
      change();
    }
}


/* ************************************************************ */
// tab切换
var lists = document.querySelectorAll('.tab-list>li');
var divs = document.querySelectorAll('.elec-box>.items-right');
for(var i = 0; i < lists.length; i++){
    lists[i].index = i;
    lists[i].onmouseover = function(){
        //设置li样式之前 li默认的样式去掉
        for(var i = 0; i < lists.length; i++){
            lists[i].style.cssText = 'border-bottom:none;color:#424242;'
        }
        //设置li的样式
        lists[this.index].style.cssText = 'color: #ff6700;border-bottom: 2px solid #ff6700;';

        //设置div显示之前 所有的元素隐藏
        for(var j = 0; j < divs.length; j++){
            divs[j].style.display = 'none';
        }

        //设置对应的div显示
        divs[this.index].style.display = 'block';
    }
}


