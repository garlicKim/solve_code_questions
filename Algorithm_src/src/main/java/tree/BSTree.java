package tree;

public class BSTree {
    private Node node = new Node();

    public Node insertKey(Node node, int x) {

        Node p = node;

        Node newNode = new Node(x);

        if (p == null) {

            return newNode;

        } else if (p.data > newNode.data) {

            p.left = insertKey(p.left, x);

            return p;

        } else if (p.data < newNode.data) {

            p.right = insertKey(p.right, x);

            return p;

        } else {

            return p;

        }

    }

    public Node search(int x) {

        Node p = node;

        while (p != null) {

            if (x < p.data)
                p = p.left;

            else if (x > p.data)
                p = p.right;

            else
                return p;

        }

        return p;

    }

    public void inorder(Node root) {

        if (root != null) {

            inorder(root.left);

            System.out.print(root.data + " ");

            inorder(root.right);

        }

    }

    public void print() {

        inorder(node);

        System.out.println();

    }

    public void insert(int x) {

        node = insertKey(node, x);

    }
}
