import Package.*;
class addElement extends Thread
{
	Queue queue;Stack stack;Circular_queue cir_que;
	int element,task;
	public addElement(Queue queue,Stack stack,Circular_queue cir_que,int element,int task)
	{
		if(task==1)
			this.stack=stack;
		else if(task==2)
			this.queue=queue;
		else if(task==3)
			this.cir_que=cir_que;
		this.element=element;
		this.task=task;
	}
	public void run()
	{
		if(task==1)
			stack.add(element);
		else if(task==2)
			queue.add(element);
		else if(task==3)
			cir_que.add(element);
	}
}