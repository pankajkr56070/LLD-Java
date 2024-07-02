public abstract class Button {

    private boolean status;

    public void pressDown() {
        System.out.println("Button is pressed");
    }

    public abstract boolean isPressed();

}
