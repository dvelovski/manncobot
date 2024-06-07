package manncobot.ui;

import org.cstr24.hyphengl.ui.css.PseudoClass;
import org.cstr24.hyphengl.ui.windowing.HyWindow;
import org.cstr24.hyphengl.ui.windowing.Panel;

public class HyTestWindow extends HyWindow {
    public HyTestWindow(){
        setSize(160, 160);
        setCaption("Hy Test Window");

        Panel tB = getTitleBar();
        tB.addPseudoClass(PseudoClass.Focus);
    }
}
