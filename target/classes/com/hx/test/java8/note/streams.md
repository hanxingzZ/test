大家可以把Stream当成一个高级版本的Iterator。原始版本的Iterator，用户只能一个一个的遍历元素
并对其执行某些操作；高级版本的Stream，用户只要给出需要对其包含的元素执行什么操作，
比如“过滤掉长度大于10的字符串”、“获取每个字符串的首字母”等，具体这些操作如何应用到每个元素上，
就给Stream就好了！

Stream 是java8中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作
但是将执行操作的时间交给具体实现来决定。
例如，如果你希望计算某个方法的平均值，你可以在每个元素上制定调用的方法，从而获得所有值的平均值。
你也可以使用 Stream API 来并行执行操作，使用多线程来计算每一段的总和与数量，再将结果汇总起来。

内容介绍：
    1. 迭代器意味着特定的遍历策略，禁止了高效的并发执行。
    2. 你可以从集合、数组、生成器、或者迭代器中创建stream
    3. 使用过滤器filter 来选择元素，使用map来改变元素
    4. 其他改变stream 的操作包括limit、distinct、和sorted。
    5. 要从stream中获得结果，请使用reduction 操作符，例如 count、max、min、findFirst或findAny
       其中一些方法会返回一个 Optional值。
    6. Optional类型的目的是为了安全的替代使用null值。（java8给出的一个处理nullpoint异常的类）
       要想安全的使用它，需要借助于 ifPresent 和 orElse 方法。
    7. 你可以收集集合、数组、字符串或者map中的stream结果。
    8. Collectors类的 groupingBy 和partitioningBy方法允许你对stream中的内容分组，并获取每个组的结果。
    9. java8对原始类型 int、long和double提供了专门的stream
    10. 当你使用并行stream时，请确保不带有副作用，并且考虑放弃排序约束。
    11. 为了使用streamAPI 你需要了解一些函数式接口。
    
当使用 Stream 的时候会有以下几个步骤：
1. 创建一个Stream
2. 在一个或多个步骤中，指定将初始Stream转换为另一个Stream的中间操作
3. 使用一个终止操作来产生一个结果。该操作会强制它之前的延迟操作立刻执行。在这之后，该Stream就不会再被调用了