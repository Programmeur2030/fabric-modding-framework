package nl.willemdeprogrammeur.fabricmodframework.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import nl.willemdeprogrammeur.fabricmodframework.Fmoddingframework;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

import java.util.Collections;
import java.util.List;

public class basic {

    public static void Register_Basic() {
        Fmoddingframework.LOGGER.info("basis componenten van modding framework aan het laden");
    }
    //items registreren
    public static Item Item(String name, String MOD_ID, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
    }
    // item overload
    public static Item Item(String name, Item item, RegistryKey<ItemGroup> creativeTab) {
        Item registered = Registry.register(Registries.ITEM, new Identifier(Fmoddingframework.MOD_ID, name), item);

        // Voeg toe aan creative tab
        ItemGroupEvents.modifyEntriesEvent(creativeTab).register(entries -> {
            entries.add(registered);
        });
        return registered;
    }

    //een block registreren
    private static Item BlockItem(String name, String MOD_ID, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static Block block(String name, String MOD_ID, Block block) {
        BlockItem(name, MOD_ID, block);
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }

    // een item/block groep maken
    public static ItemGroup ItemGroup(String name, String MOD_ID, ItemStack icon, List<ItemStack> items) {
        Identifier id = new Identifier(MOD_ID, name);
        return Registry.register(Registries.ITEM_GROUP, id,
                FabricItemGroup.builder()
                        .icon(() -> icon)
                        .displayName(Text.translatable("itemGroup." + MOD_ID + "." + name))
                        .entries((displayContext, entries) -> {
                            entries.addAll(Collections.unmodifiableList(items));
                        })
                        .build());
    }
}
