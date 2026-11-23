import java.util.*;

class ProductOfNumbers {
    Stack<Integer> stack = new Stack<>();

    public ProductOfNumbers() {
        stack.push(1);
    }

    public void add(int num) {
        if (num == 0) {
            stack.clear();
            stack.push(1);
        } else {
            stack.push(stack.peek() * num);
        }
    }

    public int getProduct(int k) {
        if (k >= stack.size()) {
            return 0;
        }

        return stack.get(stack.size() - 1) /
               stack.get(stack.size() - 1 - k);
    }
}