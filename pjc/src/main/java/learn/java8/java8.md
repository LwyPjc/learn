
# lambda

函数式编程 
java : 函数作为参数

(x,y) 多参要有括号


# 流

>以声明式的方式处理集合数据
将继承操作链接起来
从支持数据处理操作的源生成的元素序列

流只能变量一次。

源 中间操作 终端操作

中间操作：
1. 无状态操作 
2. 有状态操作 建立在所有数据的基础上 distinct

终端操作:
1. 短路 找到匹配的就不找了
2. 非短路

## 流的构建

1. 由值创建流
2. 由数组创建流
3. 由文件生成流
4. 由函数生成流--无限流

## 收集器

collect 流的方法

Collector 接口

Collectors 工具类 里面有一些实现了Collector的

Collectors里有哪些预定义的收集器功能呢?
1. 将流元素归约和汇总为一个值
2. 将流元素分组
3. 将流元素分区

## 规约 汇总

reduce 将stream流中元素转换成一个值

Collector 接口

可以查看Collects有哪些实现了Collect的方法
``` java

Collector<T,A,R>{
// 建立新的结果容器
Supplier<A> supplier,
// 将元素添加到结果容器
BiConsumer<A, T> accumulator,
// 对结果容器应用最终转换
Function<A, R> finisher,
// 合并两个结果容器
BinaryOperator<A> combiner,
// 定义收集器行为，如 是否可以并行，可以使用哪些优化
Characteristics... characteristics
}

// Collectors 的实现
public static <T>
Collector<T, ?, List<T>> toList() {
    return new CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
                               (left, right) -> { left.addAll(right); return left; },
      
```

## streamLambdaDemo

查找，去重，扁平化，分组，排序

# 资源

## 关闭流

Gc 垃圾回收
1. GC 只负责回收堆内存资源，不会回收任何物理资源
2. GC 时间不一定
3. GC 回收之前，总会调用它的finalize 方法

物理资源需要手动释放：
1. 文件/流资源
2. 套接字资源
3. 数据库连接资源

try with resource 需实现 AutoCloseable 接口



# Guava

## 不可变集合

>把一个集合变为不可变集合，在之后的处理不能改变这个集合
创建不可变集合 3 种方式

# 线程池


