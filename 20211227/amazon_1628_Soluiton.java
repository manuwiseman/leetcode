/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

abstract class Operator extends Node {
    Node left;
    Node right;
}

class Operant extends Node {
    int value;
    
    public Operant(int value) {
        this.value = value;
    }
    
    @Override
    public int evaluate() {
        return value;
    }
}

class Add extends Operator {
    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

class Minus extends Operator {
    @Override
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }
}

class Multiply extends Operator {
    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}

class Divide extends Operator {
    @Override
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<Node>();
        for (String s : postfix) {
            if (!Character.isDigit(s.charAt(0))) {
                Operator operator = null;
                if (s.equals("+")) operator = new Add();
                if (s.equals("-")) operator = new Minus();
                if (s.equals("*")) operator = new Multiply();
                if (s.equals("/")) operator = new Divide();
                operator.right = stack.pop();
                operator.left = stack.pop();
                stack.push(operator);
            } else {
                stack.push(new Operant(Integer.parseInt(s)));
            }
        }
        return stack.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */