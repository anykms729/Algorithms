/*A thread can be in one of the following states.
        NEW – A thread that has not yet started is in this state.
        RUNNABLE – A thread executing in the Java virtual machine is in this state.
        BLOCKED – A thread that is blocked waiting for a monitor lock is in this state.
        WAITING – A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
        TIMED_WAITING – A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
        TERMINATED – A thread that has exited is in this state.*/

/* Thread class provides you other useful methods you can use:
        boolean isAlive() – to check if the thread is still running, returns true or false
        void setName(String name) – To name a thread
        String getName() – To get the name of a thread
        long getId() – To get the ID of a thread
        static int activeCount() – Returns an estimate of the number of active threads in the current thread's thread group and its subgroups
        ThreadGroup getThreadGroup() - Returns the thread group to which it belongs
        int getPriority() – Returns this thread's priority
        void setPriority() – Changes the priority of this thread
        Thread.State getState() – Returns the state of this thread */


public class MessagePrinterStateTest {
    public static void main(String[] args) {
        Thread t = new MessagePrinterTest.MessagePrinter("Hi", 10);
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
    }
}
