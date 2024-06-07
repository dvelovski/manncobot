package manncobot;

import org.cstr24.hyphengl.assets.HyResHandle;
import org.cstr24.hyphengl.entities.Entity;
import org.cstr24.hyphengl.entities.components.ModelComponent;
import org.cstr24.hyphengl.geometry.HyModel;

public class Mercenary extends Entity<Mercenary> {
    public String name = "";
    //equipped items?
    //animation instances...?

    public Mercenary(){
        super();
        addComponent(new ModelComponent());
    }

    @Override
    public Mercenary cloneEntity() {
        return null;
    }

    @Override
    public void update() {

    }
}
