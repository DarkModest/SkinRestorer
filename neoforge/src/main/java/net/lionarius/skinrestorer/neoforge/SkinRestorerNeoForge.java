package net.lionarius.skinrestorer.neoforge;

import net.lionarius.skinrestorer.SkinRestorer;
import net.neoforged.fml.common.Mod;

@Mod(SkinRestorer.MOD_ID)
public final class SkinRestorerNeoForge {
    
    public SkinRestorerNeoForge() {
        SkinRestorer.onInitialize();
    }
}
