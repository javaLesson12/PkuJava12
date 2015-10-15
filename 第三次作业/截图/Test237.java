/*
	Delete Node in a Linked List
	Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
    Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
	the linked list should become 1 -> 2 -> 4 after calling your function.
*/

 class ListNode 
{
    int val;
    ListNode next;
    ListNode(int x) 
	{ val = x; }
 }

class Test237 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
	public static void deleteNode(ListNode node) 
    {
		if(node.next==null)
			return;
		ListNode i=node;
		ListNode j=node.next;
		while(j.next!=null)
		{
			i.val=j.val;
			i=i.next;
			j=j.next;
		}
		i.val=j.val;
		i.next=null;  
    }
}
