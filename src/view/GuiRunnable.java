package view;

public class GuiRunnable implements Runnable {

    private GUI gui;

    private final int DELAY = 5000; //refresh time for auto-refreshing
    public GuiRunnable(GUI gui)
    {
        this.gui = gui;
    }

    @Override
    public void run()
    {
        while (true) {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
