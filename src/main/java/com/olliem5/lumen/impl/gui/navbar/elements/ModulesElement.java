package com.olliem5.lumen.impl.gui.navbar.elements;

import com.olliem5.lumen.impl.gui.navbar.NavbarElement;
import com.olliem5.lumen.impl.gui.window.windows.ModuleWindow;
import net.minecraft.util.Identifier;

/**
 * @author olliem5
 * @since 1.0
 */

public final class ModulesElement extends NavbarElement {
    public ModulesElement() {
        super("Modules", new Identifier("lumen", "images/navbar/modules.png"), new ModuleWindow());
    }
}
