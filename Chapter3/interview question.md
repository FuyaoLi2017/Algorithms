1. Question 1
Merging with smaller auxiliary array. Suppose that the subarray a[0] to a[n−1] is sorted and the subarray a[n] to a[2∗n−1] is sorted. How can you merge the two subarrays so that a[0] to a[2∗n−1] is sorted using an auxiliary array of length nn (instead of 2n)?

my answer: Put the first half(a[0]~a[n]) of the array into the auxiliary array and then compare the auxiliary array and the second half of the original array to form the result array.

Note: these interview questions are ungraded and purely for your own enrichment. To get a hint, submit a solution.


2. Question 2
Counting inversions. An inversion in an array a[] is a pair of entries a[i] and a[j] such that i < j but a[i] > a[j]. Given an array, design a linearithmic algorithm to count the number of inversions.

如果没有性能限制，用插入排序算法可以实现。题目性能被限制在nlogn，又是归并排序的练习题，很显然要实现个归并排序，并在里面计数。通过一个例子来看下计数方法，例如{6, 5, 2, 3, 4, 1}这个序列，归并过程中会分为分为如下几步：

1. 归并{6, 5}，存在一次右侧元素5移至左侧的操作，变成{5, 6}，归并前逆序对<6,5>

2. 归并{5, 6, 2}，存在一次右侧元素2移至左侧的操作, 变成{2, 5, 6}，归并前存在两对逆序对<5, 2>和<6, 2>

3. 归并{3, 4}，不存在右侧元素左移操作

4. 归并{3, 4, 1}，存在一次右侧元素1移至左侧的操作，变成{1, 3, 4}，归并前存在两对逆序对<3, 1>和<4, 1>

5. 归并{2, 5, 6, 1, 3, 4}，存在三次1、3、4右侧元素移至左侧的操作，归并前存在七对逆序对<2,1><5,1><6,1><5,3><6,3><5,4><6,4>

由上述分析可见，当右侧元素a[j]与左侧元素a[i]进行比较后需要移至左侧时，a[j]与区间 [ a[i] , a[mid] ]中的所有元素都可以组成逆序对，这个区间的元素个数为mid+1-i个。

参考：https://www.cnblogs.com/evasean/p/7230996.html


3. Question 3
Shuffling a linked list. Given a singly-linked list containing n items, rearrange the items uniformly at random. Your algorithm should consume a logarithmic (or constant) amount of extra memory and run in time proportional to nlogn in the worst case.

transform the mergesort to the random sort
https://www.cnblogs.com/evasean/p/7232572.html
