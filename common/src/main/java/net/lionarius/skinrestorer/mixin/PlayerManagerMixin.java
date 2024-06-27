package net.lionarius.skinrestorer.mixin;

import net.lionarius.skinrestorer.SkinRestorer;
import net.lionarius.skinrestorer.SkinResult;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collections;
import java.util.List;

@Mixin(PlayerManager.class)
public abstract class PlayerManagerMixin {
    
    @Shadow
    public abstract List<ServerPlayerEntity> getPlayerList();
    
    @Shadow @Final
    private MinecraftServer server;
    
    @Inject(method = "remove", at = @At("TAIL"))
    private void remove(ServerPlayerEntity player, CallbackInfo ci) {
        SkinRestorer.getSkinStorage().removeSkin(player.getUuid());
    }
    
    @Inject(method = "disconnectAllPlayers", at = @At("HEAD"))
    private void disconnectAllPlayers(CallbackInfo ci) {
        for (ServerPlayerEntity player : getPlayerList()) {
            SkinRestorer.getSkinStorage().removeSkin(player.getUuid());
        }
    }
    
    @Inject(method = "onPlayerConnect", at = @At("HEAD"))
    private void onPlayerConnected(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo ci) {
        SkinRestorer.setSkinAsync(server, Collections.singleton(player.getGameProfile()), () -> SkinResult.ofNullable(SkinRestorer.getSkinStorage().getSkin(player.getUuid())));
    }
}