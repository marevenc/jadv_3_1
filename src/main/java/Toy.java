public class Toy implements Runnable {

    Switch mySwitch;
    User user;

    public Toy(Switch mySwitch, User user) {
        this.mySwitch = mySwitch;
        this.user = user;
    }

    public void run() {
        while (true){
            if(Thread.currentThread().isInterrupted()) break;
            this.setOff();
        }

    }

    public void setOff() {
        synchronized (mySwitch) {
            try {
                while (!user.mySwitch.getState()) {
                    mySwitch.wait();
                }
                mySwitch.setState(false);
                System.out.println("Тумблер выключен");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
