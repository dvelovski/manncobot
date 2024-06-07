package manncobot;

import manncobot.ui.HyTestWindow;
import manncobot.ui.MCBManagerWindow;
import manncobot.ui.UITestWindow;
import org.cstr24.hyphengl.assets.AssetLoader;
import org.cstr24.hyphengl.engine.Application;
import org.cstr24.hyphengl.engine.OSWindowCreationInfo;
import org.cstr24.hyphengl.engine.WindowMode;
import org.cstr24.hyphengl.entities.components.ModelComponent;
import org.cstr24.hyphengl.filesystem.HyFile;
import org.cstr24.hyphengl.graphics.Colours;
import org.cstr24.hyphengl.interop.source.SourceAssetTypes;
import org.cstr24.hyphengl.interop.source.SourceInterop;
import org.cstr24.hyphengl.interop.source.materials.SourceShaders;
import org.cstr24.hyphengl.interop.source.tf.TFItemLibrary;
import org.cstr24.hyphengl.scene.World;
import org.cstr24.hyphengl.ui.windowing.UIWindowManager;

public class MCBApplication extends Application {
    public static final String[] MERC_NAMES = {"Scout", "Soldier", "Pyro", "Demoman", "Heavy", "Engineer", "Medic", "Sniper", "Spy"};

    public TFItemLibrary itemLibrary;
    public MCBManagerWindow managerWindow;
    public HyTestWindow hTestWindow;

    public MCBApplication(){
        this.startupSettings.windowSpecifications = new OSWindowCreationInfo(1440, 900, "MannCoBot", 0, WindowMode.Windowed);
        this.startupSettings.windowSpecifications.setBackgroundColour(Colours.AliceBlue);
        this.startupSettings.windowSpecifications.setWindowIconHandle(HyFile.get("res/icon.bmp"));
        this.startupSettings.captureCursor = false;
        this.startupSettings.requiresSourceInterop = true;

        managerWindow = new MCBManagerWindow();
        hTestWindow = new HyTestWindow();

        currentScene = new World();
    }

    @Override
    public void initialise() {
        SourceInterop.initialize();
        SourceShaders.init();
        SourceInterop.mountTeamFortress2();
        SourceInterop.mountHalfLife2();

        itemLibrary = new TFItemLibrary();
        itemLibrary.load("res/tf/items_game.txt");

        UIWindowManager.get().openWindow(managerWindow);
        UIWindowManager.get().openWindow(hTestWindow);

        UIWindowManager.get().openWindow(new UITestWindow(hTestWindow));

        //create mercenaries
        Mercenary mercScout = new Mercenary();
        ((ModelComponent) mercScout.getComponent(ModelComponent.TYPE)).setModelHandle(AssetLoader.get().loadResource(SourceAssetTypes.MDL, "models/player/scout.mdl"));

        Mercenary mercSoldier = new Mercenary();
        ((ModelComponent) mercSoldier.getComponent(ModelComponent.TYPE)).setModelHandle(AssetLoader.get().loadResource(SourceAssetTypes.MDL, "models/player/soldier.mdl"));

        Mercenary mercPyro = new Mercenary();
        ((ModelComponent) mercPyro.getComponent(ModelComponent.TYPE)).setModelHandle(AssetLoader.get().loadResource(SourceAssetTypes.MDL, "models/player/pyro.mdl"));

        Mercenary mercDemoman = new Mercenary();
        ((ModelComponent) mercDemoman.getComponent(ModelComponent.TYPE)).setModelHandle(AssetLoader.get().loadResource(SourceAssetTypes.MDL, "models/player/demo.mdl"));

        Mercenary mercHeavy = new Mercenary();
        ((ModelComponent) mercHeavy.getComponent(ModelComponent.TYPE)).setModelHandle(AssetLoader.get().loadResource(SourceAssetTypes.MDL, "models/player/heavy.mdl"));

        Mercenary mercEngineer = new Mercenary();
        ((ModelComponent) mercEngineer.getComponent(ModelComponent.TYPE)).setModelHandle(AssetLoader.get().loadResource(SourceAssetTypes.MDL, "models/player/engineer.mdl"));

        Mercenary mercMedic = new Mercenary();
        ((ModelComponent) mercMedic.getComponent(ModelComponent.TYPE)).setModelHandle(AssetLoader.get().loadResource(SourceAssetTypes.MDL, "models/player/medic.mdl"));

        Mercenary mercSniper = new Mercenary();
        ((ModelComponent) mercSniper.getComponent(ModelComponent.TYPE)).setModelHandle(AssetLoader.get().loadResource(SourceAssetTypes.MDL, "models/player/sniper.mdl"));

        Mercenary mercSpy = new Mercenary();
        ((ModelComponent) mercSpy.getComponent(ModelComponent.TYPE)).setModelHandle(AssetLoader.get().loadResource(SourceAssetTypes.MDL, "models/player/spy.mdl"));
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    @Override
    public void shutdown() {

    }
}
