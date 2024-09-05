import java.util.*;

public class test {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close(); // Close the scanner

        if (n == 0) {
            System.out.println("Tree is empty");
            return;
        }

        Node root = create_tree(arr);
        System.out.println(root.data);
        displayTree(root);
        right_side_view(root);
    }

    public static Node create_tree(int[] arr) {
        if (arr.length == 0) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < arr.length) {
            Node current = queue.poll();
            if (arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void right_side_view(Node root) {
        if (root == null) return;

        List<Integer> rightSideView = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (i == size - 1) {
                    rightSideView.add(current.data);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        for (int val : rightSideView) {
            System.out.print(val + " ");
        }
    }

    public static void displayTree(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }
}
