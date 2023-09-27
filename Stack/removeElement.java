package Stack;

import Stack.Package.*;
public class removeElement extends Thread
{
	Queue queue;Stack stack;Circular_queue cir_que;
	int task; 
	public removeElement(Queue queue,Stack stack,Circular_queue cir_que,int task)
	{
		if(task==1)
			this.stack=stack;
		else if(task==2)
			this.queue=queue;
		else if(task==3)
			this.cir_que=cir_que;
		this.task=task;
	}
	public void run()
	{
		if(task==1)
			stack.remove();
		else if(task==2)
			queue.remove();
		else if(task==3)
			cir_que.remove();
	}
}