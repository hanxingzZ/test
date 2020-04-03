package com.hx.test.question.hxtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.hx.test.question.util.ListNode;
import com.hx.test.question.util.TreeNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(610625296@qq.com)
 * @date 创建时间：2020年4月2日 下午3:41:50
 * @version 1.0
 */
public class Main {

	/**
	 * 
	 * Description: 翻转链表
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月2日 下午4:24:06
	 * @param
	 * @return
	 */
	public static ListNode<Integer> fun1(ListNode<Integer> head) {
		ListNode<Integer> next = null;
		ListNode<Integer> pre = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}

		return pre;
	}

	/**
	 * 
	 * Description: 判断有效括号
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月2日 下午5:51:33
	 * @param
	 * @return
	 */
	public static boolean fun2(String str) {
		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');
		char[] cs = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : cs) {
			// 右括号
			if (!map.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	/**
	 * 
	 * Description: 返回第k大值
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月2日 下午5:51:17
	 * @param
	 * @return
	 */
	public static int fun3(int[] arr, int k) {
		PriorityQueue<Integer> p = new PriorityQueue<>();
		for (int a : arr) {
			if (p.size() < k) {
				p.offer(a);
			} else {
				if (p.peek() < a) {
					p.poll();
					p.offer(a);
				}
			}
		}
		return p.poll();
	}

	/**
	 * 
	 * Description: 两个字符串是否有效异位（字母都相同 位置不同） 1.map 2.数组
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 上午9:46:12
	 * @param
	 * @return
	 */
	public static boolean fun4(String str1, String str2) {

		char[] cs1 = str1.toCharArray();
		char[] cs2 = str2.toCharArray();

		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		for (char c : cs1) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
			arr1[c - 'a']++;
		}
		for (char c : cs2) {
			map2.put(c, map2.getOrDefault(c, 0) + 1);
			arr2[c - 'a']++;
		}
		boolean flag2 = map1.equals(map2);
		System.out.print(flag2);
		boolean flag1 = true;
		for (int i = 0; i < 26; i++) {
			if (arr1[i] != arr2[i]) {
				flag1 = false;
				break;
			}
		}
		System.out.print("~~~~~");
		System.out.print(flag1);
		return flag1 && flag2;
	}

	/**
	 * 
	 * Description: 两数之和
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 上午10:18:51
	 * @param
	 * @return
	 */
	public static int[] fun5(int[] arr, int traget) {
		Map<Integer, Integer> map1 = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map1.containsKey(traget - arr[i])) {
				return new int[] { map1.get(traget - arr[i]), i };
			} else {
				map1.put(arr[i], i);
			}
		}
		return new int[2];
	}

	/**
	 * 
	 * Description: 三数之和=0
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 上午11:03:08
	 * @param
	 * @return
	 */
	public static List<List<Integer>> fun6(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < arr.length - 2; i++) {
			if (arr[i] > 0) {
				break;
			}
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int start = i + 1;
			int end = arr.length - 1;
			while (start < end) {
				int sum = arr[start] + arr[i] + arr[end];
				if (sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(arr[start]);
					list.add(arr[i]);
					list.add(arr[end]);
					result.add(list);
					start++;
					while (start < end && arr[start + 1] == arr[start]) {
						start++;
					}
					end--;
					while (start < end && arr[end - 1] == arr[end]) {
						end--;
					}
				} else if (sum < 0) {
					start++;
					while (start < end && arr[start + 1] == arr[start]) {
						start++;
					}
				} else {
					end--;
					while (start < end && arr[end - 1] == arr[end]) {
						end--;
					}
				}

			}
		}
		return result;
	}

	/**
	 * 
	 * Description: 验证二叉搜索树
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 上午11:17:23
	 * @param
	 * @return
	 */
	public static boolean fun7(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private static boolean isBST(TreeNode root, Integer max, Integer min) {
		if (root == null) {
			return true;
		}
		if (max != null && max <= root.val) {
			return false;
		}
		if (min != null && min >= root.val) {
			return false;
		}
		return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);
	}

	public static double fun8(double x, int n) {
		if (x == 0) {
			return 0;
		}
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		double sum = 1;
		while (n != 0) {
			if ((n & 1) == 1) {
				sum *= x;
			}
			x *= x;
			n >>= 1;
		}
		return sum;
	}

	/**
	 * 
	 * Description: 二叉树层序遍历
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 下午2:15:39
	 * @param
	 * @return
	 */
	public static void fun9(TreeNode root) {
		if (root == null) {
			return;
		}
		List<Integer> list1 = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			list1.add(temp.val);
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
		}
		System.out.println(list1);

	}

	/**
	 * 
	 * Description: fun9 变种 将每一层分别打印
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 下午2:24:12
	 * @param
	 * @return
	 */
	public static void fun9o1(TreeNode root) {
		if (root == null) {
			return;
		}
		List<List<Integer>> list1 = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> l = new ArrayList<>();
			for (int i = 0; i < size; i++) {

				TreeNode temp = queue.poll();
				l.add(temp.val);
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}
			list1.add(l);

		}
		System.out.println(list1);

	}

	/**
	 * 
	 * Description: 二叉树的最小深度
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 下午2:34:06
	 * @param
	 * @return
	 */
	public static int fun10(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = fun10(root.left);
		int right = fun10(root.right);
		return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;

	}

	/**
	 * 
	 * Description: 二叉树最大深度
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 下午2:37:23
	 * @param
	 * @return
	 */
	public static int fun11(TreeNode root) {
		return root == null ? 0 : Math.max(fun11(root.left), fun11(root.right)) + 1;
	}

	/**
	 * 
	 * Description: 生成n对有效括号
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 下午3:53:35
	 * @param
	 * @return
	 */
	public static List<String> fun12(int n) {
		List<String> list = new ArrayList<String>();
		fun12("", list, n, n);
		return list;
	}

	public static void fun12(String str, List<String> re, int left, int right) {
		if (left == 0 && right == 0) {
			re.add(str);
		}
		if (left > 0) {
			fun12(str + "(", re, left - 1, right);
		}
		if (right > left) {
			fun12(str + ")", re, left, right - 1);
		}
	}

	/**
	 * 
	 * Description: 算术平方根
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 下午4:08:03
	 * @param
	 * @return
	 */
	public static double fun13(int x) {

		double l = 0;
		double r = x - 1;
		double re = 0;
		while (l < r) {
			double mid = (l + r) / 2;
			if (Math.abs(mid - x / mid) < 1e-15) {
				return mid;
			} else if (mid > x / mid) {
				r = mid;
				re = mid;
			} else {
				l = mid;

			}
		}
		return re;
	}

	/**
	 * 
	 * Description: 统计1的个数
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 下午4:12:06
	 * @param
	 * @return
	 */
	public static int fun14(int n) {
		int sum = 0;
		while (n != 0) {
			n = n & (n - 1);
			sum++;
		}

		return sum;
	}

	/**
	 * 
	 * Description: fun14变种 判断是否是2的次幂
	 * 
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 下午4:12:22
	 * @param
	 * @return
	 */
	public static boolean fun14o1(int n) {

		return n > 0 && (n & (n - 1)) == 0;
	}

	/**
	 * 
	 * Description: fun14变种 范围内的count1  利用动态转移方程  f(x)=f(x/2)+x%2 => f(x) = f(x>>1) + x&1
	 * @author 韩兴（610625296@qq.com）
	 * @date 2020年4月3日 下午5:54:08
	 * @param 
	 * @return
	 */
	public static int[] fun14o2(int n) {
		int[] arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = arr[i >> 1] + i & 1;
		}
		for (int a : arr) {
			System.out.print(a + " ");
		}
		return arr;
	}

	public static void main(String[] args) {
		// // 1
		// ListNode<Integer> root = new ListNode<>(1);
		// root.next = new ListNode<>(2);
		// root.next.next = new ListNode<>(3);
		// root.next.next.next = new ListNode<>(4);
		// root.next.next.next.next = new ListNode<>(5);
		// ListNode.printListNode(root);
		// ListNode.printListNode(fun1(root));
		// // 2
		// System.out.println(fun2("{{{}}}"));
		// System.out.println(fun2("{{}}}"));
		// System.out.println(fun2("{{(}}}"));
		// // 3
		// int[] arr = { 5, 4, 23, 1, 2, 7 };
		// System.out.println(fun3(arr, 5));
		// // 4
		// System.out.println(fun4("asd", "daaa"));
		// // 5
		// for (int a : fun5(new int[] { 2, 11, 15, 7 }, 9)) {
		// System.out.println(a);
		// }
		// // 6
		// System.out.println(fun6(new int[] { -1, 0, 1, 2, -1, -4 }));
		// // 8
		// System.out.println(fun8(0, 0));

		// 7 9 9o1 10 11
		// /**
		// *h 5
		// *h 2 7
		// *h 1 3 6 8
		// *h
		// */
		// TreeNode root = new TreeNode(5);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(7);
		// root.left.left = new TreeNode(1);
		// root.left.right = new TreeNode(3);
		// // 验证二叉搜索树 root.left.right = new TreeNode(2);
		// root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(8);
		// // 验证最大深度 root.right.right.left = new TreeNode(8);
		// System.out.println(fun7(root));
		// fun9(root);
		// fun9o1(root);
		// System.out.println(fun10(root));
		// System.out.println(fun11(root));
		// System.out.println(fun12(3));
		// System.out.println(fun13(13));
		// System.out.println(Math.sqrt(13));
		// System.out.println(fun14(6));
		System.out.println(fun14o2(2));
	}

}
