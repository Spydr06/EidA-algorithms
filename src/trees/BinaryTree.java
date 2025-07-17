package trees;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;

    public BinaryTreeNode<T> iterativeSearch(T key) {
        BinaryTreeNode<T> x = root;
        while(x != null && x.getKey() != key) {
            if(key.compareTo(x.getKey()) < 0)
                x = x.getLeft();
            else
                x = x.getRight();
        }

        return x;
    }

    public void inorderWalk(BinaryTreeNode.Visitor<T> visitor) {
        if(root != null)
            root.inorderWalk(visitor);
    }

    public void preorderWalk(BinaryTreeNode.Visitor<T> visitor) {
        if(root != null)
            root.preorderWalk(visitor);
    }

    public void postorderWalk(BinaryTreeNode.Visitor<T> visitor) {
        if(root != null)
            root.postorderWalk(visitor);
    }

    public BinaryTreeNode<T> search(T key) {
        return root == null ? null : root.search(key);
    }

    public BinaryTreeNode<T> minimum() {
        return root == null ? null : root.minimum();
    }

    public BinaryTreeNode<T> maximum() {
        return root == null ? null : root.maximum();
    }

    public void insert(BinaryTreeNode<T> z) {
        BinaryTreeNode<T> x = root, y = null;
        while(x != null) {
            y = x;
            if(z.getKey().compareTo(x.getKey()) < 0)
                x = x.getLeft();
            else
                x = x.getRight();
        }

        if(y == null)
            this.root = z;
        else if(z.getKey().compareTo(y.getKey()) < 0)
            y.setLeft(z);
        else
            y.setRight(z);
    }

    private void transplant(BinaryTreeNode<T> u, BinaryTreeNode<T> v) {
        if(u.getParent() == null)
            root = u;
        else if(u.equals(u.getParent().getLeft()))
            u.getParent().setLeft(v);
        else
            u.getParent().setRight(v);
    }

    public void delete(BinaryTreeNode<T> z) {
        if(z.getLeft() == null)
            transplant(z, z.getRight());
        else if(z.getRight() == null)
            transplant(z, z.getLeft());
        else {
            BinaryTreeNode<T> y = z.getRight().minimum();
            if(!y.equals(z.getRight())) {
                transplant(y, y.getRight());
                y.setRight(z.getRight());
            }

            transplant(z, y);
            y.setLeft(z.getLeft());
        }
    }
}
