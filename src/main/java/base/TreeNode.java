package base;

import cn.hutool.core.collection.CollectionUtil;

import java.util.List;

public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int data){
        this.val = data;
    }
    public TreeNode(TreeNode l,int d,TreeNode r){
        this.left = l;
        this.val = d;
        this.right = r;
    }
    public TreeNode(int l,int d,int r){
        this.left = new TreeNode(l);
        this.val = d;
        this.right = new TreeNode(r);
    }

    public static TreeNode createBinaryTreeForRecursion(List<Integer> list){
        TreeNode node = null;
        if(CollectionUtil.isEmpty(list)){
            return null;
        }
        Integer data = removeLast(list);
        if(data!=null){
            node = new TreeNode(data);
            node.left = createBinaryTreeForRecursion(list);
            node.right = createBinaryTreeForRecursion(list);
        }
        return node;
    }

    public static Integer removeLast(List<Integer> list){
        return list.remove(list.size() - 1);
    }
}
