package com.anfal.diagnosapenyakitumum;

import android.util.Log;

import com.scalified.tree.TreeNode;
import com.scalified.tree.multinode.ArrayMultiTreeNode;

public class Tree {
    private TreeNode<String> root;

    private TreeNode<String> makeTreeNode(String node, @org.jetbrains.annotations.NotNull String[] values) {
        TreeNode<String> nodes = new ArrayMultiTreeNode<>(node);
        for(String value : values){
            TreeNode<String> child = new ArrayMultiTreeNode<>(value);
            nodes.add(child);
            for (TreeNode<String> n : nodes.subtrees()) {
                nodes = n;
            }
        }
        return nodes.root();
    }
    public static TreeNode<String> getSibling(TreeNode<String> parent, int index){
        int i = 0;
        for(TreeNode<String> node : parent.subtrees()){
            if(index == i){
                return node;
            }
            i++;
        }
        return null;
    }

    public static TreeNode<String> getSubTree(TreeNode<String> parent){
        for(TreeNode<String> node : parent.subtrees()){
                return node;
        }
        return null;
    }

    public Tree() {
        //TREE ROOT
        this.root = new ArrayMultiTreeNode<>("root");

        //SubTree G3
        TreeNode<String> G3 = new ArrayMultiTreeNode<>("G3");
        //Penyakit Tifus (P1)
        G3.add(makeTreeNode("G1",new String[]{"G2","G4","G5","G6","G7","G47","P1"}));
        //Penyakit ISPA (P4)
        G3.add(makeTreeNode("G11",new String[]{"G29","G30","G31","G32","P4"}));

        //SubTree G4
        TreeNode<String> G4 = new ArrayMultiTreeNode<>("G4");
        //Penyakit Tifus (P1)
        G4.add(makeTreeNode("G1",new String[]{"G2","G3","G5","G6","G7","G47","P1"}));
        //Penyakit Diare (P3)
        G4.add(makeTreeNode("G6",new String[]{"G9","G18","G19","G20","G22","P3"}));

        //SubTree G6
        TreeNode<String> G6 = new ArrayMultiTreeNode<>("G6");
        //Penyakit Tifus (P1)
        G6.add(makeTreeNode("G1",new String[]{"G2","G3","G4","G5","G7","G47","P1"}));
        //Penyakit Maag (P5)
        G6.add(makeTreeNode("G34",new String[]{"G35","G36","G37","G38","G39","P5"}));

        //SubTree G30
        TreeNode<String> G30 = new ArrayMultiTreeNode<>("G30");
        //Penyakit Radang Tenggorokan (P2)
        G30.add(makeTreeNode("G7",new String[]{"G9","G11","G12","G13","P2"}));
        //Penyakit Vertigo (P6)
        G30.add(makeTreeNode("G40",new String[]{"G42","G44","G45","G47","P6"}));


        // Add all SubTree
        this.root.add(G3);
        this.root.add(G4);
        this.root.add(G6);
        this.root.add(G30);
    }

    public TreeNode<String> getRoot() {
        return this.root;
    }


}
