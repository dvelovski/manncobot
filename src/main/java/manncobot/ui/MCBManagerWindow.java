package manncobot.ui;

import imgui.ImGui;
import imgui.type.ImBoolean;
import imgui.type.ImInt;
import manncobot.MCBApplication;
import org.cstr24.hyphengl.engine.Engine;
import org.cstr24.hyphengl.ui.windowing.ImmediateUIWindow;

public class MCBManagerWindow extends ImmediateUIWindow {
    ImInt mercSelection = new ImInt(0);
    int itemSelection = 0;

    public MCBManagerWindow(){
        this.caption = "MannCoBot Manager";
    }

    @Override
    public void immediateModeRender() {

        if (ImGui.combo("##Mercenary", mercSelection, MCBApplication.MERC_NAMES)){
            //what's a not shit way to manipulate the program state
        }

        if (ImGui.beginListBox("##Items")){
            for (int i = 0; i < 3; i++){
                if (ImGui.selectable("Test " + i, new ImBoolean(i == itemSelection))){
                    itemSelection = i;
                }
            }
            ImGui.endListBox();
        }
        if (ImGui.button("Quit")){
            Engine.getRunningApplication().exit();
        }
    }
}
