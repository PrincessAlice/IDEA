import java.util.*;

public class Trees {
    public static void levelOrder1(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            System.out.println(front.val);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    private static class Element {
        int level;
        TreeNode node;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (root == null) { return retList; }
        Queue<Element> queue = new LinkedList<>();
        Element e = new Element();
        e.node = root;
        e.level = 0;
        queue.add(e);

        while (!queue.isEmpty()) {
            Element front = queue.poll();

            if (front.level == retList.size()) {
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add(front.node.val);


            if (front.node.left != null) {
                Element l = new Element();
                l.node = front.node.left;
                l.level = front.level + 1;
                queue.add(l);
            }
            if (front.node.right != null) {
                Element r = new Element();
                r.node = front.node.right;
                r.level = front.level + 1;
                queue.add(r);
            }
        }

        return retList;
    }

    public static boolean isCompleteTree(TreeNode root) {
        // 层序遍历，直到遇到 null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            TreeNode front = queue.poll();
            if (front == null) {
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }

        // 判断队列中剩余元素是否都是 null
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                return false;
            }
        }

        return true;
    }

    public static void preorderNoR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.pop()
            cur = top.right;
        }
    }

    public static void postorderNoR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;       // 上一个被三次完整经过的结点

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            if (top.right == null || top.right == last) {
                stack.pop();
                System.out.println(top.val);
                last = top;
            } else {
                cur = top.right;
            }
        }
    }

    public static void inorderNoR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode();
        n1.val = 1;
        n1.left = new TreeNode();
        n1.left.val = 2;
        n1.right = new TreeNode();
        n1.right.val = 3;
        n1.left.left = new TreeNode();
        n1.left.left.val = 4;

        //preorderNoR(n1);
        //inorderNoR(n1);
        postorderNoR(n1);
    }
}
