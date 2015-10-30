class MinStack {
      private Stack<Integer> stack;
        Stack<Integer> minVals;

        public MinStack() {
            stack = new Stack<>();
            minVals = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(minVals.isEmpty()||minVals.peek() >= x)
            {
                minVals.push(x);
            }
        }

        public void pop() {
            int val = stack.peek();
            stack.pop();
            if(val == minVals.peek()){
                minVals.pop();
            }

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minVals.peek();
        }
}
