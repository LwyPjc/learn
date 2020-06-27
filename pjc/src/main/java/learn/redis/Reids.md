# 内存模型

c语言写成

单线程 不要执行长命令 keys flushall

# 配置

daemonize yes 
port 6382
dir "/opt/soft/redis/data"
Logfile 6382. log


# API

## 通用命令

``` jshelllanguage

keys 命令，O(n)

127.0.0.1:6379> mset hello good hehe nice
OK
127.0.0.1:6379> keys he*
1) "hehe"
2) "hello"
127.0.0.1:6379> keys he[h-l]
(empty list or set)
127.0.0.1:6379> keys he[h-i]
(empty list or set)
127.0.0.1:6379> keys h?
(empty list or set)
127.0.0.1:6379> keys h*
1) "hehe"
2) "hello"
127.0.0.1:6379> keys he[h-l]*
1) "hehe"
2) "hello"
127.0.0.1:6379>

==================
dbsize 计算key的总数  O(1),

127.0.0.1:6379> keys *
1) "hehe"
2) "hello"
3) "one"
127.0.0.1:6379> dbsize
(integer) 3
127.0.0.1:6379>

===============

exists

del
============
expire 
ttl 查看剩余时间，已过期返回-2，被删除了。返回-1表示没有过期时间
persist  消除过期时间

127.0.0.1:6379> set aa world
OK
127.0.0.1:6379> expire aa 20
(integer) 1
127.0.0.1:6379> ttl aa
(integer) 14
127.0.0.1:6379> ttl aa
(integer) 11
127.0.0.1:6379> ttl aa
(integer) -2
127.0.0.1:6379> get aa
(nil)
127.0.0.1:6379> set two 'eve'
OK
127.0.0.1:6379> expire two 100
(integer) 1
127.0.0.1:6379> ttl two
(integer) 97
127.0.0.1:6379> persist two
(integer) 1
127.0.0.1:6379> ttl two
(integer) -1
127.0.0.1:6379> get two
"eve"
127.0.0.1:6379>

===========================

type key 对应的值类型
string hash list set zset none


127.0.0.1:6379> set a b
OK
127.0.0.1:6379> type a
string
127.0.0.1:6379> sadd myset 1 2 3
(integer) 3
127.0.0.1:6379> type myset
set
127.0.0.1:6379> type ww
none
127.0.0.1:6379>


```

## 字符串

数字，bits 等都为字符串

对象toJSON啊 
不大于512MB

>计数器，缓存，分布式锁

get set del

>计数器
```
incr key
#key自增1,如果key不存在，自增后get(key)=1

decr key
#key自减1,如果key不存在，自减后get(key)=-1

incrby key k
#key自增k,如果key不存在，自增后get(key)=k

decrby key k
#key自减k,如果key不存在，自减后get(key)=-k


127.0.0.1:6379> get counter
(nil)
127.0.0.1:6379> incr counter
(integer) 1
127.0.0.1:6379> get counter
"1"
127.0.0.1:6379> incr counter
(integer) 2
127.0.0.1:6379> get counter
"2"
127.0.0.1:6379> incrby counter 8
(integer) 10
127.0.0.1:6379> get counter
"10"
127.0.0.1:6379> decr counter
(integer) 9
127.0.0.1:6379> decr counter 8
(error) ERR wrong number of arguments for 'decr' command
127.0.0.1:6379> get counter
"9"
127.0.0.1:6379> decr counter 3
(error) ERR wrong number of arguments for 'decr' command
127.0.0.1:6379> decrby counter 5
(integer) 4
127.0.0.1:6379> 

```

>缓存

>分布式id生成器

>更新
``` 
set key value
#不管key是否存在，都设置

setnx key value
#key不存在，才设置

set key value XX 更新
#key存在，才设置


127.0.0.1:6379> exists java
(integer) 0
127.0.0.1:6379> set java good
OK
127.0.0.1:6379> setnx java bad
(integer) 0
127.0.0.1:6379> get java
"good"
127.0.0.1:6379>
127.0.0.1:6379> set java nice xx
OK
127.0.0.1:6379> get java
"nice"
127.0.0.1:6379>
127.0.0.1:6379> setnx php dd
(integer) 1
127.0.0.1:6379> get php
"dd"
127.0.0.1:6379>   

```

mget mset

多次 get 或set 节省网络时间


>其它命令
``` 
getset key newvalue
#set key newvalue并返回旧的value

append key value
#将value追加到旧的value

strlen key
#返回字符串的长度(注意中文)

127.0.0.1:6379> mget php java
1) "dd"
2) "nice"
127.0.0.1:6379>
127.0.0.1:6379> getset java newbb
"nice"
127.0.0.1:6379> mget php java
1) "dd"
2) "newbb"
127.0.0.1:6379> append php cc
(integer) 4
127.0.0.1:6379> append php java
(integer) 8
127.0.0.1:6379> mget java php
1) "newbb"
2) "ddccjava"
127.0.0.1:6379>
127.0.0.1:6379> strlen php
(integer) 8
127.0.0.1:6379> append java ￎￊￎￊ
(integer) 9
127.0.0.1:6379> get java
"newbb\xce\xca\xce\xca"
127.0.0.1:6379> 

incrbyfloat key 3.5
#增加key对应的值3.5
getrange key start end
#获取字符串指定下标所有的值
setrange key index value
#设置指定下标所有对应的值
 

```

## 哈希

hget hset hdel hgetall

``` 
hget key field
#获取hash key对应的field的value

hset key field value
#设置hash key对应field的value

hdel key field
#删除hash key对应field的value

127.0.0.1:6379> hset use1 age 22
(integer) 1
127.0.0.1:6379> hset use1 name wang
(integer) 1
127.0.0.1:6379> hget use1
(error) ERR wrong number of arguments for 'hget' command
127.0.0.1:6379> get use1
(error) WRONGTYPE Operation against a key holding the wrong kind of value
127.0.0.1:6379> hget use1 age
"22"
127.0.0.1:6379> hdel use1
(error) ERR wrong number of arguments for 'hdel' command
127.0.0.1:6379> hdel use1 age
(integer) 1
127.0.0.1:6379> hget use1 age
(nil)
127.0.0.1:6379> hgetall use1
1) "name"
2) "wang"
3) "age"
4) "22"
127.0.0.1:6379>

```
 
hexists hlen

``` 
127.0.0.1:6379> hexists use1 age
(integer) 1
127.0.0.1:6379> hexists use1 nn
(integer) 0
127.0.0.1:6379> hlen use1
(integer) 2
127.0.0.1:6379>
```

hmget hmset

``` 
127.0.0.1:6379> hmget use1 name age
1) "wang"
2) "22"
127.0.0.1:6379> hmset use1 addredd china mobile 1234
OK
127.0.0.1:6379>
```

>hincrby

hgetall hvals hkeys

``` 
127.0.0.1:6379> hkeys use1
1) "name"
2) "age"
3) "addredd"
4) "mobile"
127.0.0.1:6379> hvals use1
1) "wang"
2) "22"
3) "china"
4) "1234"
127.0.0.1:6379>
```

``` 
hgetall key
#返回hash key对应所有的field和value
hvals key
#返回hash key对应所有field的value
hkeys key
#返回hash key对应所有field


```

## 列表

有序 重复

左右两边插入弹出

lpush rpush 
linsert 
lpop rpop

``` 
rpush key value1 value2..valueN
#从列表右端插入值(1-N个)

lpush key value1 value2 ..valueN
#从列表左端插入值(1-N个)

127.0.0.1:6379> lpush listOne a b c d
(integer) 4
127.0.0.1:6379> lrange listOne 0 -1
1) "d"
2) "c"
3) "b"
4) "a"
127.0.0.1:6379> rpush listTwo a b c d
(integer) 4
127.0.0.1:6379> lrange listTwo 0 -1
1) "a"
2) "b"
3) "c"
4) "d"
127.0.0.1:6379> 

```

``` 
linsert key before|after value newValue
#在list指定的值前|后插入newValue

127.0.0.1:6379> linsert listOne after b ww
(integer) 5
127.0.0.1:6379> lrange listOne 0 -1
1) "d"
2) "c"
3) "b"
4) "ww"
5) "a"
127.0.0.1:6379>

```

``` 
127.0.0.1:6379> lpop listOne
"d"
127.0.0.1:6379> lrange listOne 0 -1
1) "c"
2) "b"
3) "ww"
4) "a"
127.0.0.1:6379> rpop listOne
"a"
127.0.0.1:6379> lrange listOne 0 -1
1) "c"
2) "b"
3) "ww"
127.0.0.1:6379>
```

lrem

``` 
lrem key count value
#根据count值，从列表中删除所有value相等的项
(1) count>0，从左到右,删除最多count个value相等的项
(2) count<0，从右到左，删除最多Math.abs(count)个value相等的项
(3) count=0 ,删除所有value相等的项

```

ltrim 保留指定下标索引范围

``` 
ltrim key start end
#按照索引范围修剪列表

```

lrange

``` 
Irange key start end (包含end)
#获取列表指定索弓|范围所有item

```

lindex 按下标获取

``` 
lindex key index
#获取列表指定索弓|的item

```

llen 列表长度

lset 更新

不常用命令
``` 
blpop brpop
blpop key timeout
#lpop阻塞版本，timeout是阻塞超时时
间,timeout= 0为永远不阻塞

```

>应用
栈 队列
``` 
LRUSH + LPOP = Stack
LPUSH + RPOP = Queue 
LPUSH + LTRIM = Capped Collection 固定限制的列表
LPUSH + BRPOP = Message Queue

```

## set

集合间的操作
sinter sdiff sunion

sadd 添加
``` 
sadd key element1 ...
#向集合key添加element(如果element已经存在，
添加失败)

```

srem 删除某元素

``` 
srem key element
#将集合key中的element移除掉

```

scard 计算集合元素个数

sismember 判断元素是否在集合中

srandmember key count 随机取出count个元素

spop 随机弹出一个元素，将元素从原集合中删除

smembers 获取集合所有元素 

>srandmember与spop 的区别

``` 
127.0.0.1:6379> sadd user1 it new his sports
(integer) 4
127.0.0.1:6379> smembers user1
1) "his"
2) "sports"
3) "new"
4) "it"
127.0.0.1:6379> spop user1
"new"
127.0.0.1:6379> smembers user1
1) "his"
2) "sports"
3) "it"
127.0.0.1:6379> scard user1
(integer) 3
127.0.0.1:6379> sismember user1 entertainment
(integer) 0
127.0.0.1:6379> 
```

集合间操作:共同关注社交关系 sadd sinter

``` 
sdiff user:1:follow user:2:follow = music his #差集
sinter user:1:follow user:2:follow = it sports #交集
sunion user:1:follow user:2:follow = it music his sports news ent #并集
sdiff|sinter|suion + store destkey .. #将差集、交集、并集结果保存在destkey中


```

>抽奖系统
spop/srandmember

>赞 踩 喜欢

>标签
sadd


## 有序集合 命令 以z开头

key score value

zadd score 可以重复 element不可以重复

``` 
zadd key score element(可以是多对)
#添加score和element

```

zrem
``` 
zrem key element(可以是多个)
#删除元素

```

zscore
``` 
zscore key element
#返回元素的分数

```

zincrby
``` 
zincrby key increScore element
#增加或减少元素的分数

```

zcard


zrank 排名 从0开始 

zrange 排名 zrangebyscore 按分数排名
``` 
zrange key start end [WITHSCORES]
#返回指定索弓|范围内的升序元素[分值]

zrangebyscore key minScore maxScore [WITHSCORES]
#返回指定分数范围内的升序元素[分值]

```

zcount
``` 
zcount key minScore maxScore
#返回有序集合内在指定分数范围内的个数

```

zremrangebyrank zremrangebyscore
``` 
zremrangebyrank key start end
#删除指定排名内的升序元素

zremrangebyscore key minScore maxScore
#删除指定分数内的升序元素

```

``` 
127.0.0.1:6379> zadd player 1000 ronaldo 900 messi 800 corload 600 kaka
(integer) 4
127.0.0.1:6379> zrange player 0 -1
1) "kaka"
2) "corload"
3) "messi"
4) "ronaldo"
127.0.0.1:6379> zcount player 700 1000
(integer) 3
127.0.0.1:6379> zrangebyscore player 700 1000
1) "corload"
2) "messi"
3) "ronaldo"
127.0.0.1:6379> zremrangebyrank player 0 1
(integer) 2
127.0.0.1:6379> zrange player 0 -1
1) "messi"
2) "ronaldo"
127.0.0.1:6379> zrange player 0 -1 withscores
1) "messi"
2) "900"
3) "ronaldo"
4) "1000"
127.0.0.1:6379>
```

>排行榜
score

不常用命令
``` 
zrevrank 从高到低
zrevrange 
zrevrangebyscore

集合计算 存储
```

# 应用

缓存系统

计数器

消息队列
>简单消息队列

排行榜

实时系统
布隆过滤器











# 问题

## redis 存满了怎么办


# 图
https://www.jianshu.com/p/970747650de5

