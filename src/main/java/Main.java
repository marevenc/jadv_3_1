public class Main {
    public static void main(String[] args) {
        Switch mySwitch = new Switch();

        User user = new User(mySwitch);
        Toy toy = new Toy(mySwitch, user);

        Thread toyThread = new Thread(toy, "игрушка");
        Thread userThread = new Thread(user, "пользователь");

        toyThread.start();
        userThread.start();


        try {
            userThread.join();
            toyThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
