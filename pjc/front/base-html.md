
# 前端概览

>
1. HTML是网页内容的载体。内容就是网页制作者放在页面上想要让用户浏览的信息，可以包含文字、图片、视频等。
2. CSS样式是表现。就像网页的外衣。比如，标题字体、颜色变化，或为标题加入背景图片、边框等。所有这些用来改变内容外观的东西称之为表现。
3. JavaScript是用来实现网页上的特效效果。如：鼠标滑过弹出下拉菜单。或鼠标滑过表格的背景颜色改变。还有焦点新闻（新闻图片）的轮换。可以这么理解，有动画的，有交互的一般都是用JavaScript来实现的。

>在网页上要展示出来的页面内容一定要放在body标签中。

``` html

没有语义，单独为了设置样式而用
<span></span>

<style>
span{
   color:blue; 
}
</style>
=======

斜体
<em></em>


粗体
<strong></strong>

=======

<hx>一共有六个

--------
空格：
&nbsp;

---

<q>引用</q>
会给你加双引号

大段引用：缩进
<blockquote></blokdquote>

-----------
<hr>
水平横线

------------

网站地址：默认显示为斜体

<address>
本文的作者：<a href="mailto:lilian@imooc.com">lilian</a>
</address>
    
=======================
超链接：
    
    <a  href="目标网址"  title="鼠标滑过显示的文本">链接显示的文本</a>
    
    <a>标签在默认情况下，链接的网页是在当前浏览器窗口中打开，有时我们需要在新的浏览器窗口中打开。
    <a href="目标网址" target="_blank">click here!</a>
        
        
=====================
图片：
        
<img src="图片地址" alt="下载失败时的替换文本" title = "提示文本">

======
        
HTML表单(form)
        <form   method="传送方式"   action="服务器文件">
        action: 浏览者输入的数据被传送到的地方,比如一个PHP页面(save.php)
        method ： 数据传送的方式（get/post）
            <form    method="post"   action="save.php">
        	<label for="username">用户名:</label>
        	<input type="text" name="username" />
        	<label for="pass">密码:</label>
        	<input type="password" name="pass" />
		   </form>
        
    文本输入框：
            <form>
   			<input type="text/password" name="名称" value="文本" />
		   </form>
     1、type：
            当type="text"时，输入框为文本输入框; 当type="password"时, 输入框为密码输入框。

	2、name：为文本框命名，以备后台程序ASP 、PHP使用。

	3、value：为文本输入框设置默认值。(一般起到提示作用)   
    -----------------
     大量文字，文本域：
            <textarea  rows="行数" cols="列数">文本</textarea>
            
         <form  method="post" action="save.php">
          	<label>联系我们</label>
        	<textarea cols="50" rows="10" >在这里输入内容...</textarea>
		</form>
      -------------------
      html中有两种选择框，即单选框和复选框，两者的区别是单选框中的选项用户只能选择一项，而复选框中用户可以任意选择多项，甚至全选。
       <input   type="radio/checkbox"   value="值"    name="名称"   checked="checked"/>
       当 type="radio" 时，控件为单选框   
       当 type="checkbox" 时，控件为复选框     
       checked：当设置 checked="checked" 时，该选项被默认选中     
       
       注意:同一组的单选按钮，name 取值一定要一致，比如上面例子为同一个名称“radioLove”，这样同一组的单选按钮才可以起到单选的作用。
       
       
  ----------------------
  多选框：<option value="旅游" selected="selected">旅游</option>
  selected="selected" 表示默认选中此项
  
  <select>
      <option value="看书">看书</option>
      <option value="旅游">旅游</option>
      <option value="运动">运动</option>
      <option value="购物">购物</option>
    </select>
    
    进行多选时按下Ctrl键同时进行单击
    <select multiple="multiple"> <!-- 实现多选 -->
      <option value="看书">看书</option>
      <option value="旅游">旅游</option>
      <option value="运动">运动</option>
      <option value="购物">购物</option>
    </select>
    
    
	----------------------
	提交按钮：
	<input   type="submit"   value="提交">
	type：只有当type值设置为submit时，按钮才有提交作用
	value：按钮上显示的文字
	重置按钮:
	<input type="reset" value="重置">
	type：只有当type值设置为reset时，按钮才有重置作用
	value：按钮上显示的文字
	
	-----------------
	label 标签：
	label标签不会向用户呈现任何特殊效果，它的作用是为鼠标用户改进了可用性。如果你在 label 标签内点击文本，就会触发此控件。就是说，当用户单击选中该label标签时，浏览器就会自动将焦点转到和标签相关的表单控件上（就自动选中和该label标签相关连的表单控件上）。
	<label for="控件id名称">
	
  
```





>设置style
``` html

style放head标签里



```