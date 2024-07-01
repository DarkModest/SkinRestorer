package net.lionarius.skinrestorer.mixin;

import net.lionarius.skinrestorer.SkinRestorer;
import net.minecraft.network.Connection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collections;
import java.util.List;

@Mixin(PlayerList.class)
public abstract class PlayerListMixin {
    
    @Shadow
    public abstract List<ServerPlayer> getPlayers();
    
    @Shadow @Final
    private MinecraftServer server;
    
    @Inject(method = "remove", at = @At("TAIL"))
    private void remove(ServerPlayer player, CallbackInfo ci) {
        SkinRestorer.getSkinStorage().removeSkin(player.getUUID());
    }
    
    @Inject(method = "removeAll", at = @At("HEAD"))
    private void removeAll(CallbackInfo ci) {
        for (ServerPlayer player : getPlayers()) {
            SkinRestorer.getSkinStorage().removeSkin(player.getUUID());
        }
    }
    
    @Inject(method = "placeNewPlayer", at = @At("HEAD"))
    private void placeNewPlayer(Connection connection, ServerPlayer player, CommonListenerCookie cookie, CallbackInfo ci) {
        SkinRestorer.applySkin(server, Collections.singleton(player.getGameProfile()), SkinRestorer.getSkinStorage().getSkin(player.getUUID()));
    }
}
