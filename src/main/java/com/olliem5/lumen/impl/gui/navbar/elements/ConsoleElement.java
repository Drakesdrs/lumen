package com.olliem5.lumen.impl.gui.navbar.elements;

import com.olliem5.lumen.impl.gui.navbar.NavbarElement;
import com.olliem5.lumen.impl.gui.window.windows.ConsoleWindow;
import net.minecraft.util.Identifier;

/**
 * @author olliem5
 * @since 1.0
 */

public final class ConsoleElement extends NavbarElement {
    public ConsoleElement() {
        super("Console", new Identifier("lumen", "images/navbar/console.png"), new ConsoleWindow());
    }
}
