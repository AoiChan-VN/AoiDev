package aoichan.crystal.gameplay.gem;

import aoichan.crystal.bootstrap.CrystalPlugin;
import aoichan.crystal.core.loader.GemLoader;
import aoichan.crystal.core.module.CrystalModule;
import aoichan.crystal.core.registry.GemRegistry;

public class GemModule implements CrystalModule {

    // [!] Code: Gem Registry
    private final GemRegistry registry = new GemRegistry();

    // [!] Code: Gem Loader
    private GemLoader loader;

    @Override
    public void enable() {

        loader = new GemLoader(CrystalPlugin.get(), registry);
        loader.load();
    }

    @Override
    public void disable() {

        registry.clear();
    }

    @Override
    public String name() {
        return "GemModule";
    }

    public GemRegistry getRegistry() {
        return registry;
    }
}
