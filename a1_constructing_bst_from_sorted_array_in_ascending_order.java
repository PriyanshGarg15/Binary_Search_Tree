public class a1_constructing_bst_from_sorted_array_in_ascending_order {
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

    public static void main(String[] args) {
        int[] arr = {10, 25, 37, 50, 62, 75, 87, 97};

        Node root = construct(arr, 0, arr.length - 1);
        display(root);
    }
}
