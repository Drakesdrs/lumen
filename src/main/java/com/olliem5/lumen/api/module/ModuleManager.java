package com.olliem5.lumen.api.module;

import com.olliem5.lumen.impl.events.KeyPressEvent;
import com.olliem5.lumen.impl.events.UpdateEvent;
import com.olliem5.lumen.impl.events.WorldRenderEvent;
import com.olliem5.lumen.impl.modules.GUI;
import com.olliem5.lumen.impl.modules.TestModule;
import com.olliem5.pace.annotation.PaceHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author olliem5
 * @since 1.0
 */

public final class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();
    private static final Map<Class<? extends Module>, Module> moduleInstances = new HashMap<>();

    public static void initialize() {
        addModule(new TestModule());
        addModule(new GUI());

        modules.sort(ModuleManager::alphabetize);
    }

    private static int alphabetize(Module module1, Module module2) {
        return module1.getName().compareTo(module2.getName());
    }

    private static void addModule(Module module) {
        modules.add(module);
        moduleInstances.put(module.getClass(), module);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Module> T getModule(Class<T> klass) {
        return (T) moduleInstances.get(klass);
    }

    public static Module getModule(String name) {
        for (Module module : modules) {
            if (module.getName().equalsIgnoreCase(name)) return module;
        }
        return null;
    }

    public static List<Module> getModules() {
        return modules;
    }

    public static boolean isActive(Class<? extends Module> klass) {
        Module module = getModule(klass);
        return module != null && module.isEnabled();
    }

    @PaceHandler
    public void onUpdate(UpdateEvent event) {
        modules.forEach(Module::onUpdate);
    }

    @PaceHandler
    public void onWorldRender(WorldRenderEvent event) {
        modules.forEach(Module::onRender);
    }

    @PaceHandler
    public void onKeyPress(KeyPressEvent event) {
        for (Module module : modules) {
            if (module.getKey() == event.getKey()) {
                module.toggle();
            }
        }
    }
}
