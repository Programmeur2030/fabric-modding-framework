package nl.willemdeprogrammeur.fabricmodframework.register;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import nl.willemdeprogrammeur.fabricmodframework.Fmoddingframework;

public class basic {
    //items registreren

    public static void Register_Basic() {
        Fmoddingframework.LOGGER.info("basis componenten van modding framework aan het laden");
    }
    public static Item Item(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Fmoddingframework.MOD_ID, name), item)
    }
}
