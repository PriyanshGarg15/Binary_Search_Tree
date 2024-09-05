public class a2_size_sum_max_min_find_in_bst {
    public static class Node {
        int data;
        Node left, right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node construct(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int mid = (lo + hi) / 2;
        int data = arr[mid];

        Node leftChild = construct(arr, lo, mid - 1);
        Node rightChild = construct(arr, mid + 1, hi);
        return new Node(data, leftChild, rightChild);
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += (node.left == null ? "." : node.left.data) + " <- " + node.data + " -> " + (node.right == null ? "." : node.right.data);
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public static int sum(Node node) {
        if (node == null) return 0;
        return node.data + sum(node.left) + sum(node.right);
    }

    public static int max(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public static int min(Node node) {
        if (node == null) return Integer.MAX_VALUE;
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public static Node find(Node node, int data) {
        while (node != null) {
            if (data < node.data) {
                node = node.left;
            } else if (data > node.data) {
                node = node.right;
            } else {
                return node; // found the node in bst
            }
        }
        return null; // not found the node in bst
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 37, 50, 62, 75, 87, 97};

        Node root = construct(arr, 0, arr.length - 1);
        display(root);

        System.out.println("Size: " + size(root)); 
        System.out.println("Sum: " + sum(root));
        System.out.println("Max: " + max(root));
        System.out.println("Min: " + min(root)); 
        System.out.println("Find 50: " + (find(root, 50) != null ? "Found" : "Not Found")); // Output: Find value 50
        System.out.println("Find 100: " + (find(root, 100) != null ? "Found" : "Not Found")); // Output: Find value 100
    }
}
