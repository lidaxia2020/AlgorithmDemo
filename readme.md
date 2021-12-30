# 树结构

- 二分搜索树（Binary Search Tree）
    - 二分搜索树是二叉树
    - 二分搜索树得每个节点的值：
        - 大于其左子树得所有的值
        - 小于右子树的所有节点的值
    - cile floor操作 rank select 操作
- 平衡二叉树：AVL;红黑树
- 堆；并查集
- 线段树；Trie(字典树，前缀树)

# 堆

- 基本结构
    - 二叉堆
        - 二叉堆是一棵完全二叉树
        - 堆中某个节点的值总是不大于其父节点的值（最大堆）
        - d叉堆 d-ary heap
        - 索引堆

# 线段树(区间树) Segment tree

- 线段树是平衡二叉树（平衡二叉树：最大深度和最小深度不超过1）
- 需要开辟4*n的空间存储n个元素

# 树状数组（Binary Index Tree） -->区间操作
# 区间相关---》Range Minimum Query RMQ

# Trie 字典树 前缀树