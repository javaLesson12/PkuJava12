class MyQueue {
         //        only push to top, peek/pop from top, size, and is empty operations are valid.
        // Push element x to the back of queue.
        private static Stack<Integer> stack;

        public MyQueue() {
            stack = new Stack<>();
        }

        public void push(int x) {

            stack.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            Stack<Integer> tmp = new Stack<>();
            while (stack.size() > 1) {
                tmp.push(stack.pop());
            }
            stack = new Stack<>();
            while (!tmp.isEmpty()) {
                stack.push(tmp.peek());
                tmp.pop();
            }
        }

        // Get the front element.
        public int peek() {
            Stack<Integer> tmp = new Stack<>();
            while (stack.size() > 0) {
                tmp.push(stack.peek());
                stack.pop();
            }
            int ans = tmp.peek();
            stack = new Stack<>();
            while (!tmp.isEmpty()) {
                stack.push(tmp.peek());
                tmp.pop();
            }
            return ans;
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return stack.isEmpty();
        }
}