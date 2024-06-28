package net.lionarius.skinrestorer.neoforge;

import net.lionarius.skinrestorer.SkinRestorer;
import net.lionarius.skinrestorer.command.SkinCommand;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@Mod(SkinRestorer.MOD_ID)
@EventBusSubscriber(modid = SkinRestorer.MOD_ID)
public final class SkinRestorerNeoForge {
    
    public SkinRestorerNeoForge() {
        NeoForge.EVENT_BUS.register(SkinRestorerNeoForge.class);
        SkinRestorer.onInitialize(FMLPaths.CONFIGDIR.get());
    }
    
    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        SkinCommand.register(event.getDispatcher());
    }
}
