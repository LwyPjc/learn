
# js

## DOM 查找

document object model

>DOM 是 W3C（万维网联盟）的标准， 是中立于平台和语言的接口，它允许程序和脚本动态地访问和更新文档的内容、结构和样式。对网页进行增删改查的操作。

查找节点
读取节点信息
修改节点信息
创建新节点
删除节点

常用DOM方法
getElementById()
getElementsByTagName()
getElementsByClassName()
appendChild()
removeChild()
replaceChild()
insertBefore()
createAttribute()
createElement()
createTextNode()
getAttribute()
setAttribute()

1. 按id属性，精确查找一个元素对象
getElementById只能用在document上

``` javascript

var ul = document.getElementById('myList');
console.log(ul );

```

2. 按标签名找

```javascript

var elems=parent.getElementsByTagName("tag");
查找指定parent节点下的所有标签为tag的子代节点

```

1. 可用在任意父元素上
2. 不仅查直接子节点，而且查所有子代节点
3. 返回一个动态集合
即使只找到一个元素，也返回集合
必须用[0],取出唯一元素


3. 通过name属性查找


``` javascript

document.getElementsByName(‘name属性值’)

```

4. 通过class查找

查找父元素下指定class属性的元素

``` javascript
<div id="news">
    <p class="mainTitle">新闻标题1</p>
    <p class="subTitle">新闻标题2</p>
    <p class=" mainTitle ">新闻标题3</p>
</div>

var div = document.getElementById('news');
var list = div.getElementsByClassName('mainTitle');
console.log(list );

```

5. 通过CSS选择器查找

元素选择器
类选择器
Id选择器
后代选择器
子代选择器
群组选择器


5.1. 只找一个元素:  如果选择器匹配的有多个，只返回第一个
var elem=parent.querySelector("selector")

5.2. 找多个: 
var elems=parent.querySelectorAll("selector") 



## DOM 修改

1. 读取属性值： 2种: 

```javascript

1. 先获得属性节点对象，再获得节点对象的值:
var attrNode=elem.attributes[下标/属性名];
var attrNode=elem.getAttributeNode(属性名)
attrNode.value——属性值

2. 直接获得属性值
var value=elem.getAttribute("属性名");


```

2、修改属性
```javascript

elem.setAttribute("属性名", value);
var h1 = document.getElementById(“a1");
h1.setAttributeNode(“name”，zhangji);

```

3. 判断是否包含指定属性：
```javascript

var bool=elem.hasAttribute("属性名")
document.getElementById('bt1').hasAttribute('onclick');
```

4. 移除属性：

```javascript

elem.removeAttribute("属性名")

<a id=“alink" class="slink" href="javascript:void(0)" onclick="jump()">百度搜索</a>

var a = document.getElementById('alink');
a.removeAttribute('class');
```

5 修改样式

```javascript
内联样式： elem.style.属性名
强调： 属性名: 去横线，变驼峰

css: background-color => backgroundColor
list-style-type => listStyleType

```

## DOM 添加

1. 创建空元素: 
2. 设置关键属性
3. 将元素添加到DOM树

```javascript
1. 创建空元素
var elem=document.createElement("元素名")

var table = document.createElement('table');
var tr= document.createElement('tr');
var td= document.createElement('td');
var td= document.createElement('td');
console.log( table );

2.1. 设置关键属性
a.innerHTML="go to tmooc"
a.herf="http://tmooc.cn";
<a href="http://tmooc.cn">go to tmooc</a>
2.2. 设置关键样式
a.style.opacity = "1";
a.style.cssText = "width: 100px;height: 100px";

3. 将元素添加到DOM树
parentNode.appendChild(childNode)
可用于将为一个父元素追加最后一个子节点

var div = document.createElement( 'div' );
var txt = document.createTextNode('版权声明');
div.appendChild(txt);
document.body.appendChild(div);

parentNode.insertBefore(newChild, existingChild)
用于在父元素中的指定子节点之前添加一个新的子节点

<ul id="menu">
    <li>首页</li>
    <li>联系我们</li>
</ul>

var ul = document.getElementById('menu');
var newLi = document.createElement('li');

ul.insertBefore(newLi, ul.lastChild);


```

添加元素优化

尽量少的操作DOM树
为什么: 每次修改DOM树，都导致重新layout

1.如果同时创建父元素和子元素时，建议在内存中先将子元素添加到父元素，再将父元素一次性挂到页面

2. 如果只添加多个平级子元素时, 就要将所有子元素，临时添加到文档片段中。再将文档片段整体添加到页面

文档片段: 内存中，临时保存多个平级子元素的 虚拟父元素用法和普通父元素完全一样

1.创建片段
var frag=document.createDocumentFragment();

2.将子元素临时追加到frag中
frag.appendChild(child);

3.将frag追加到页面
parent.appendChild(frag);
强调: append之后，frag自动释放，不会占用元素


## BOM
\
浏览器对象模型

window:代表整个窗口
history: 封装当前窗口打开后，成功访问过的历史url记录
n avigator:封装浏览器配置信息
document:封装当前正在加载的网页内容
location:封装了当前窗口正在J开的url地址
screen :封装了屏幕的信息
event:定义了网页中的事件机制


完整窗口大小: window.outerWidth/outerHeight
文档显示区大小: window.innerWidth/innerHeight

### 定时器
The timer

让程序按指定时间间隔自动执行任务
网页动态效果、计时功能等

1. 周期性定时器
让程序按指定时间间隔反复自动执行一项任务
```javascript

setInterval(exp,time)：周期性触发代码exp
exp：执行语句
time：时间周期，单位为毫秒


setInterval(function(){
console.log("Hello World");
},1000);

停止定时器
1、给定时器取名


var timer = setInterval(function(){
console.log("Hello World");
},1000);

clearInterval(timer);


```

2. 一次性定时器
让程序延迟一段时间执行

```javascript

setTimeout(exp,time)：一次性触发代码exp
    exp：执行语句
    time：间隔时间，单位为毫秒

setTimeout(function(){
    alert("恭喜过关");
},3000);

```

>只要反复执行，就用周期性
 只要只执行一次，就用一次性



# 图

https://www.jianshu.com/p/b004148366ce

