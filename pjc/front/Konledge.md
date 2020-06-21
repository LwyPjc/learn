>对后端人员的前端知识
html css JavaScript

html：决定网页结构
css：美化网页
JavaScript：用户交互 

# 浏览器

> ie6 与 ie7 差距巨大

## 显示内容
html内容请求一次，遇到js再请求，遇到图片等url再请求
所以一个页面可能跟服务器交互好多次。

# SEO

搜索引擎 使用 <meta>标签

语义化 <em> <strong>

自定义 列表
dl   列表项dt 列表描述 dd

# html
DOM 树 Document Object Model
就是 html <body> 这样的嵌套的东西 
一般是 来操作 DOM树

## 标签

>一个页面建议只有一个`<h1>`
1~7 最好用css 控制大小
```html

<br/> 段内换行 也就是\n，

&nbsp;这是一个空格，这个叫特殊字符。要显示多个空格时使用

<pre> 预留格式，预定义格式化的文本，文本中的换行和空格 会被保留

<span> 行内组合，通过css样式来格式化


```



## 超链接

``` html
<a> 

<a href="www.bb.cc"> 文字或图片</a>

```

1. 到当前站点的其它网页上 记得带上协议
2. 到其它站点
3. 虚拟超链接

> `多个<a>标签 默认实在一行上，用<p> 或<br/> 来换行`

## img 图像

``` html

<img src="" alt="替换文本，当图片不显示时" />

src 路径加文件名

相对路径：对站点来说

jpg gif png



```

## div 区域标签

页面的一个组成部分，一个栏目板块

align 属性 如 center 这样的属性 都被 css 给替代了


## 列表项

``` html
无序列表
ul
li

有序列表
ol
li

```


## 表格 table tr td

``` html

表头 td--->th

```




## 表单

``` html

<form action=""> 
<input type="text|password">

```



### 单选 复选

``` html

<input type="radio|checkbox" value="" name="name" checked="checked">

```




### 下拉列表


``` html

<select>
    <option selected="selected">

```



### 文本域

``` html

<textarea row="行数" cols="列数"> 默认 </textarea>

```





# css

要使用外联样式的话，得先定义，然后用<link>引入
<link rel="要链接什么样的文件" href="css文件地址"> 

内嵌样式

``` css

<style>
    p{
        ...
    }

</style>

```



## 选择器

> 标签选择器 p body 等
  类选择器 如 <p class="one">这样子
     使用就是 .one{}这样
  ID选择器 <p id="two"> 一般id选择器是唯一
     使用就是 #two{}
  
     

选择器: 

标签选择器，body,h1,p,hr....

``` css

<style type = "text/css">
	p{
		...
	}
	h1{
		...
	}
	.one{
		...
	}
</style>

```



类别选择器：

``` css

.one{...;...;}
.two{...;..;}
<body>
	<p class = "one" >类别11</p>
	<p class = "one" >类别12</p>
	<p class = "one" >类别13</p>
	<p class = "two" >类别21</p>
	<p class = "two" >类别22</p>
	<p class = "two" >类别23</p>
	<p>普通</p>
<body>

```


id选择器



``` css
#one{..;..;}

<p id="one"> 唯一性</p>

```



--------------------------------

嵌套声明样式 空格隔开

``` css
<style type="text/css">
	p span{
	color:red;
}
</style>

<body>
	<p>问问<span>span里面</span>酷酷酷</p>
</body>

```



------------------------------

集体声明 逗号隔开

``` css
<style type="text/css">
	p,span{
	color:red;
}
</style>
```



--------------

全局声明 `*` 号

``` css
<style type="text/css">
	
*{
	text-align: center;
}

</style>

```


------------

混合使用

``` css
<div class "one two max">ddddd 嗡嗡嗡</div>
```



## code

``` css
<p style = "color:red;font-size:12px;">xxxxxxxskfl
</p>

background-color:#ccc;
text-align:center;
color:red;
font-size:12px;
font:"黑体";
width:200px;
text-align: right; /* 对其方式 */   

```



## 问题

### 样式会覆盖吗？？？

外面的样式
html的内联样式
标签的属性

>答：就近原则 行内样式优先级大于内联样式大于外联样式 


## 文字样式

属性值单位
``` css
px  像素
em  字符
%   百分比 相对上层标签而言
```


### 颜色

颜色名
``` css
rgb
rgba a 为透明读0~1
#xxxxxx 十六位
```


### 文本 对p标签

首行缩进  text-indent 2em
color
letter-spacing
line-height
text-align
text-decoration
text-indent

### 字体


| font        | 在一个声明中设置所有的字体属性 | font: bold 18px '幼圆'                                       |
| ----------- | ------------------------------ | ------------------------------------------------------------ |
| font-family | 字体系列                       | 网页安全字体 font-family: "Hiragino Sans GB", "Microsoft YaHei", sans-serif; |
| font-size   | 字号                           | 14px 120%                                                    |
| font-style  | 斜体                           | italic                                                       |
| font-weight | 粗体                           | bold                                                         |


font 顺序 简化
font: 斜体 粗体 字号/行高 字体
font: italic bold 16px/1.5em '宋体'；


### 背景与超链接

背景：
background
background-color
background-image
background-repeat

超链接：

a:link − 普通的、未被访问的链接
a:visited − 用户已访问的链接
a:hover − 鼠标指针位于链接的上方悬停
a:active − 链接被点击的时刻

a:hover 必须位于 a:link 和 a:visited 之后
a:active 必须位于 a:hover 之后

`：伪类选择器`:冒号分隔

```css

a:link {
text-decoration: none;
color: #09f;/*未访问*/
}
a:visited {
text-decoration: none;
color: #930;/*已访问*/
}
a:hover {
text-decoration: underline;
color: #03c;/*鼠标悬停*/
}
a:active {
text-decoration: none;
color: #03c;/*按下鼠标*/
}

鼠标悬停 放大效果
a{
font-size: 22px;
}
a:hover{
font-size: 120%;
}

```

## 列表 表格

### 列表样式

>list-style 所有用于列表的属性 设置于一个声明中
list-style-image 为列表项标志设置图像
list-style-position 标志的位置
list-style-type 标志的类型

list-style-type ：标志类型
>none 无标记。
disc 默认。标记是实心圆。
circle 标记是空心圆。
square 标记是实心方块。
decimal 标记是数字。
lower-roman 小写罗马数字(i, ii, iii, iv, v, 等。)
upper-roman 大写罗马数字(I, II, III, IV, V, 等。)
lower-alpha 小写英文字母The marker is lower-alpha (a, b, c, d, e, 等。)
upper-alpha 大写英文字母The marker is upper-alpha (A, B, C, D, E, 等。)
lower-Greek 小写希腊字母(alpha, beta, gamma, 等。)
lower-latin 小写拉丁字母(a, b, c, d, e, 等。)
upper-latin 大写拉丁字母(A, B, C, D, E, 等。)

list-style-position 标志的位置

list-style-image 为列表项标志设置图像
>url

### 表格样式

border
width 宽
height 高
border-collapse

表格大小
``` css
table{
width: 500px;
height: 200px;
}
```

表格边框
``` css
table, td, th { /* td th */
border: 1px solid #eee;/* solid实线 */
}

table {
border-collapse:collapse; # 叠加，坍缩 表格边框和单元格边框重叠为一个
}
```

表格 奇偶选择器，如隔行的颜色一样
``` css
:nth-child(odd|even) odd 奇数，even偶数

tr:nth-child(odd){
background-color:#EAF2D3;
}

```



# css 布局与定位
目的：网页布局

1. 盒子模型container 有哪些块

2. 定位机制 元素放在哪里


## 盒子模型

事事皆可为盒子

盒子组成:
内容 content
高度 height
宽度 width
边框 border
内边距 padding 外盒子与内盒子
外边距 margin 外盒子与外盒子



``` css

margin: 1px 2px 1px 2px; 上右下左 顺时针

水平居中
margin 0 auto; 水平方向上浏览器自动计算

两个盒子，垂直距离不是相加关系，而是取最大值。

图片盒子
<div id="newsimglist">
    <img src = "images/crisis.jpg" />
    <img src = "images/crisis.jpg" />
    <img src = "images/crisis.jpg" />
</div>

#newsimglist{
    text-align:center;
    font-size:0; /*否则图间有空隙 浏览器会自动生成一点空隙 */
}


```

### 盒子模型 图
https://www.jianshu.com/p/0e605c5c6976

## 定位机制

>排列盒子

三种定位：文档流 flow 浮动定位 float 层定位 layer

文档流
>两个div --》上下关系，然后从左到右，按不同标签元素分

```css
元素分类:


block 
独占一行 
元素的height、width、margin、padding都可设置 
<div>、<p>、<h1>...<h6>、<ol>、<ul>、<table>、<form>

inline 
width、height不可设置 
width就是它包含的文字或图片的宽度，不可改变
<span>、<a>

inline-block 
就是同时具备inline元素、block元素的特点 
不单独占用一行 
元素的height、width、margin、padding都可设置 <img>

元素转换 display:

display: none 元素不会被显示
display:block 显示为block元素
display:inline 显示为inline元素
display：inline-block 显示为inline-block元素


a{
    display:block;
}

```

浮动定位
>左右关系
float 浮动

比如 div标签是上下结构

应用：图文混排，菜单与内容

1. 宽度不够用
2. 清除浮动 clear

层定位
>position

希望网页元素可以层层叠加
position{ // 相对于哪一层来说
    static 默认值，正常流 ；没有定位，left等皆无效
    fixed 固定定位 相对于浏览器窗口进行定位
    relative 相对定位 相对于其直接父元素进行定位，无论什么元素
    absolute 绝对定位 相对于static定位以外的第一个父元素 进行定位 相对于relative/absolute/body定位l.包括 fixed吗
}

left
right
top
bottom
z-index 大的在上面


fixed:  如广告，无论怎么拖动滚条

``` css


#fix-box{
    width:200px;
    height:200px;
    border:1px solid red;
    // 下面是距离浏览器上面 左面的距离
    position:fixed;
    left:100px;
    top:50px;
}

```

相对定位position:relative
定位为relative的元素脱离正常的文档流中，**但其在文档流中的原位置依然存在**,它只是移动了，原来的位置已经规划了，之后的盒子不会占据以规划的位置。
```css

#box1{
    width:170px;
    height:190px;
    position:relative;
    top:20px;
    left:20px;
}


```
position:absolute
脱离文档流，原来的位置会丢失，也就是未被规划了。之后的盒子会占据。
与relative的区别:其在正常流中的原位置不再存在

使用： 一般外层元素会设为相对定位，而里面的元素设为绝对定位，这样当外层元素移动时，里面的元素也会移动，就是移动一块了。

如文字显示在图片里：
``` css

div{
    border:1px solid red;
    color: #fff;
}
#box1{
    width:170px;
    height:190px;
    position:relative;
}
#box2{
    width:99%;
    position:absolute;
    bottom:0;
}
<div id="box1">
    <img src=“coffee.jpg">
    <div id="box2">一起享受咖啡带来的温暖吧
    </div>
</div>

```
# css3 

不同浏览器会有不同成都的支持

## 圆角 阴影

圆角边框：两个值 水平值 垂直值
border-top-left-radius 左上角的形状
border-top-right-radius 右上角的形状
border-bottom-left-radius 左下角的形状
border-bottom-right-radius 右下角的形状

阴影/投影 box-shadow
inset 水平偏移 垂直偏移 模糊距离 颜色
inset 可选，内部阴影
outset 默认值，外部阴影

## 文本 文字

text-shadow属性 水平偏移 垂直偏移 阴影大小 颜色

word-wrap属性 单词折叠

@font-face规则 使用网络字体
字体放在服务器上，去服务器下载到本地，浏览器就可以显示了。不同浏览器可能对应不同字体

定义字体名字，再使用
font-family
src:ur....

## 2D 转换

对元素进行旋转、缩放、移动、拉伸

transform 属性
rotate()
scale()

缩放transform:scale(x,y)
x:水平方向缩放的倍数
y:垂直方向缩放的倍数，若省略，同x
0~1,缩小；>1放大


## 过渡与动画
过渡 将元素某个属性从 一个值 在指定时间内过渡到 另一个值
一个状态到另外一个状态
transition 属性名 持续时间 过渡方法

transition-property 多个属性逗号隔开，所有属性all 
transition-duration s ms
transition-timing-function 函数
transition-delay 

动画
多个状态的变化
@keyframes 定义规则

animation属性

animation 简写
animation-name 引用 @keyframes 动画的名称
animation-duration 动画完成时间
animation-timing-function 规定动画的速度曲线。默认是 "ease"。
animation-play-state running | paused



## 3D 变换
表明是3D变换
transform-style： preserve-3d

旋转  坐标系下
transform属性 角度deg
rotateX( )
rotateY( )
rotateZ( )

近大远小 眼睛到舞台的距离
透视 perspective属性

// todo 案例

# 笔记 图片

## css

https://www.jianshu.com/p/0e605c5c6976

## css 3
https://www.jianshu.com/p/5c1201b09f13


# 参考

## idea 配置 前端开发

https://qjzd.net/topic/5a4ee74ff918faeb40031461

https://www.w3school.com.cn/tcpip/tcpip_intro.asp