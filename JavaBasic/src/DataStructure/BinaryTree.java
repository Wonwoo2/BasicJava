package DataStructure;

import java.util.Arrays;

public class BinaryTree {
	static int node[] = new int[7];

	static void insert() {
		for (int i = 0; i < node.length; i++) {
			node[i] = i + 1;
		}
		System.out.println(Arrays.toString(node));
	}

	static void preorder(int index) {
		if (index >= node.length) {
			return;
		}
		System.out.print(node[index] + " ");
		preorder(2 * index + 1);
		preorder(2 * index + 2);

	}
	
	public static void main(String[] args) {
		/*
		 * 					1
		 * 			2				3
		 * 		4		5		6		7
		 */
		insert();
		preorder(0);
		
		
	}
}