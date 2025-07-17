package trees;

public class BinaryTreeNode<T extends Comparable<T>> {
    public interface Visitor<T extends Comparable<T>> {
        void visit(BinaryTreeNode<T> node);
    }

    private T key;
    private BinaryTreeNode<T> parent, left, right;

    public T getKey() {
        return key;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;

        if(left != null)
            left.parent = this;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;

        if(right != null)
            right.parent = this;
    }

    public void inorderWalk(Visitor<T> visitor) {
        if(left != null)
            left.inorderWalk(visitor);
        visitor.visit(this);
        if(right != null)
            right.inorderWalk(visitor);
    }

    public void preorderWalk(Visitor<T> visitor) {
        visitor.visit(this);
        if(left != null)
            left.preorderWalk(visitor);
        if(right != null)
            right.preorderWalk(visitor);
    }

    public void postorderWalk(Visitor<T> visitor) {
        if(left != null)
            left.postorderWalk(visitor);
        if(right != null)
            right.postorderWalk(visitor);
        visitor.visit(this);
    }

    public BinaryTreeNode<T> search(T key) {
        if(this.key == key)
            return this;

        if(key.compareTo(this.key) < 0 && left != null)
            return left.search(key);
        if(key.compareTo(this.key) > 0 && right != null)
            return right.search(key);
        return null;
    }

    public BinaryTreeNode<T> minimum() {
        BinaryTreeNode<T> x = this;
        while(x.getLeft() != null)
            x = x.getLeft();
        return x;
    }

    public BinaryTreeNode<T> maximum() {
        BinaryTreeNode<T> x = this;
        while(x.getRight() != null)
            x = x.getRight();
        return x;
    }

    public BinaryTreeNode<T> successor() {
        if(right != null)
            return right.minimum();

        BinaryTreeNode<T> x = this, y = parent;
        while(y != null && x == y.right) {
            x = y;
            y = y.parent;
        }

        return y;
    }
}

