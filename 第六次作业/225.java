class MyStack {
    // Push element x onto stack.
    Queue<Integer> q1 ;  
    Queue<Integer> q2 ;  
    public void push(int x) {
        q1.offer(x);      
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q1.size()>1) 
        q2.offer(q1.poll());  
        q1.poll();  
        Queue<Integer> q = q1;  
        q1 = q2;  
        q2 = q;     
    }

    // Get the top element.
    public int top() {
    
        while(q1.size()>0)
        {
            q2.offer(q1.peek());
            q1.poll();
        }
        while(q2.size()>1)
        {
            q1.offer(q2.peek());
            q2.poll();
        }
        int ans=q2.peek();
        q1.offer(ans);
        q2.poll();
        return ans; 
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();     
    }
}


//用两个队列模拟一个堆栈