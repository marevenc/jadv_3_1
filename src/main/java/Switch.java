public class Switch {
    volatile private static boolean state;

    public void setState (boolean state){
        Switch.state = state;
    }

    public static boolean getState() {
        return state;
    }
}
