### 学习笔记

#### LRUCache

查询：O(1)

修改、更新：O(1)

实现方式：HashTable + Double LinkedList， 在Java里可使用LinkedHashMap。



#### 位运算

1. 将x最右边的n位清零： x & (~0 << n)
2. 获取x的低n位值： (x >> n) & 1
3. 获取x的第n位的幂值： x & (1 << n)
4. 仅将第n位置为1： x | (1 << n)
5. 仅将第n位置为0： x & (~ (1 << n))

   判断奇偶： x & 1 == 1、 x & 1 == 0

   清零最低位的1： x & (x - 1)

   得到最低位的1：x & -x

   结果为0： x & ~x