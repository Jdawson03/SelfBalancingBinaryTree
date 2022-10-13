# SelfBalancingBinaryTree
An AVL implementation of a self balancing binary tree.

In a worst case scenario for a BST, the search time effiency is the same as a linked list O(n), in a self-balancing BST the worst case is O(log n) by preventing the linked list situation from happening. This specific implementation is an AVL tree. See https://en.wikipedia.org/wiki/AVL_tree for more information but I chose this specific style as it is slightly more efficient than other implemntations in exchange for being slightly more complex to implement.
 
The tree works by checking the height differences between the left and right branches of a node and ensuring there isn't ever a difference of more than 1, if this difference was to arise, it will rotate nodes around to ensure balance. 

```
e.g.        becomes:
      a               b
       \            /   \
        b          a     c
         \
          c
 ```
In testing this effiency improvement with 21,000 nodes over an average of 100 tests, took the time to search for an item from roughly 80,000 nanoseconds to 140. The testing wasn't in sterile condidtions but gives a rough real world demonstartion of the improvement an AVL tree has in worst case scenarios compared to standards BST's.


This task overall came when some coursework at Swansea University asked me to implement a Binary Tree and I tested it with an adversarial data set.
