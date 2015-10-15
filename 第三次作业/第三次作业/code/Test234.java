/*
	顺读和倒读都一样的单链表
	Given a singly linked list, determine if it is a palindrome.
	Follow up:
	Could you do it in O(n) time and O(1) space?

	先遍历一下单链表，看下一共多少个元素--n
	找到一半后面的单链表的指针
	把前半个单链表进行反转，
	两个子链表就可以行进元素的对比


*/
 class ListNode 
{ 
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
class Test234 
{
	public static void main(String[] args) 
	{
		ListNode p1=new ListNode(1);
		ListNode p2=new ListNode(2);
		p1.next=p2;
		p2.next=null;

		System.out.println(isPalindrome(p1));
	}
	public static boolean isPalindrome(ListNode head) 
	{
		int n=getNum(head);
		int m;
		if(n%2!=0)
			 m=n/2+2;
		else 
			 m=n/2+1;
		ListNode mid=getPointer(head,m);
		ListNode pre=reverse(head,n/2);


		while(mid!=null&&pre!=null)
		{
			if(mid.val!=pre.val)
				return false;
			mid=mid.next;
			pre=pre.next;
		}
		return true;
    }

	public static int getNum(ListNode head)
	{
		ListNode p=head;
		int n=0;
		while(p!=null)
		{
			n++;
			p=p.next;
		}
		System.out.println(n);
		return n;
	}
	public static ListNode getPointer(ListNode head,int num)
	{
		int i=1;
		ListNode p=head;
		while(i<num)
		{
			p=p.next;
			i++;
		}
		System.out.println(p.val);
		return p;
	}

	public static ListNode reverse(ListNode head,int num)
	{
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		ListNode pre=head;//前面的节点
		head=head.next;   //后面的链表的头结点
		int i=1;
		pre.next=null;  
		
		ListNode p=null;//当前准备摘下来的节点

		while(i<num&&head!=null)
		{
			p=head;
			head=head.next;
			p.next=pre;
			pre=p;
			i++;
		}
		
		return pre;//刚开始我设置的return p,一直显示空指针异常，原来忽视了一种情况，就是num=i=1；则直接返回p=null
	}



}
