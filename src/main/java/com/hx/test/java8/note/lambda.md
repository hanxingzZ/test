lambda 的定义
lambda 是一段可以传递的代码，因此它可以被执行一次或多次。

lambda名称的由来
许多年前，在计算机出来之前，有位名叫 Alonzo Church 的逻辑学家，他想证明
什么样的数学函数是可以有效计算的（奇怪的是，当时已经存在了许多已知的函数，
但是没有人知道怎样去计算他们的值。）它使用希腊字母lambda （λ）来标记参数。
至于为什么非要用λ 是因为《数学原理》中使用‘^’来表示自由变量，所以Church就用
大写的 lambda Λ 来表示参数，但是最终还是换回了小写。
于是从那时起，带参数变量的表达式都被叫做lambda表达式。

lambda 表达式的格式： 参数、箭头 ->，以及一个表达式。
如果负责计算的代码无法用一个表达式表示，
那么可以用编写方法的方式来编写：即用{}包裹代码并明确使用return语句

一个lambda表达式包含3个部分：
1. 一段代码。
2. 参数
3. 自由变量的值。这里的自由指的是那些不是参数并且没有在代码中定义的变量