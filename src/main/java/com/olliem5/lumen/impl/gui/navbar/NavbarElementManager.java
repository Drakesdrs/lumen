package com.olliem5.lumen.impl.gui.navbar;

import com.olliem5.lumen.impl.gui.navbar.elements.ConsoleElement;
import com.olliem5.lumen.impl.gui.navbar.elements.HUDElement;
import com.olliem5.lumen.impl.gui.navbar.elements.ModulesElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author olliem5
 * @since 1.0
 */

public final class NavbarElementManager {
    private static final List<NavbarElement> navbarElements = new ArrayList<>();

    public static void initialize() {
        navbarElements.addAll(Arrays.asList(
           new ModulesElement(),
           new HUDElement(),
           new ConsoleElement()
        ));
    }

    public static List<NavbarElement> getNavbarElements() {
        return navbarElements;
    }
}
