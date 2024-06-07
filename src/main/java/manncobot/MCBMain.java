package manncobot;

import org.cstr24.hyphengl.engine.Engine;

public class MCBMain {
    public static void main(String[] args) {
        MCBApplication app = new MCBApplication();
        Engine.startApplication(app, args);
    }
}
