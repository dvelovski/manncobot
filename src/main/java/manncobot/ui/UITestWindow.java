package manncobot.ui;

import imgui.ImGui;
import org.cstr24.hyphengl.ui.css.PseudoClass;
import org.cstr24.hyphengl.ui.windowing.HyWindow;
import org.cstr24.hyphengl.ui.windowing.ImmediateUIWindow;

public class UITestWindow extends ImmediateUIWindow {
    HyWindow manipulationSubject;

    public UITestWindow(HyWindow window){
        this.manipulationSubject = window;
    }
    @Override
    public void immediateModeRender() {
        if (ImGui.button("Add focus to titlebar")){
            manipulationSubject.getTitleBar().addPseudoClass(PseudoClass.Focus);
        }
        if (ImGui.button("Remove focus from titlebar")){
            manipulationSubject.getTitleBar().removePseudoClass(PseudoClass.Focus);
        }
    }
}
