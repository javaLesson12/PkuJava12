class MyStack {
    // Push element x onto stack.
          //push to back, peek/pop from front, size, and is empty
        private static LinkedList<Integer> queue_as;
        public MyStack(){
             queue_as = new LinkedList<>();
        }
        // Push element x onto stack.
        public void push(int x) {
            queue_as.addLast(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            LinkedList<Integer> queue_ds = new LinkedList<>();
            while (queue_as.size() > 1) {
                queue_ds.addLast(queue_as.getFirst());
                queue_as.removeFirst();
            }
            queue_as = queue_ds;

        }

        // Get the top element.
        public int top() {
            LinkedList<Integer> queue_ds = new LinkedList<>();
            while (queue_as.size() > 1) {
                queue_ds.addLast(queue_as.getFirst());
                queue_as.removeFirst();
            }
            int ans = queue_as.getFirst();
            queue_ds.addLast(queue_as.getFirst());
            queue_as = queue_ds;
            return ans;
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue_as.isEmpty();
        }
}