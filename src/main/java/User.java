public class User implements Runnable{

    Switch mySwitch;
    int waitingTime = 5000;
    int numberOfIterations = 5;

    public User(Switch mySwitch){
        this.mySwitch = mySwitch;
    }

    public  void run(){
        for(int i = 0; i < numberOfIterations; i++){
            this.setOn();
            try {
                Thread.sleep(waitingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void setOn(){
        synchronized (mySwitch){
            mySwitch.setState(true);
            System.out.println("Тумблер включен");
            mySwitch.notify();
        }
    }
}
