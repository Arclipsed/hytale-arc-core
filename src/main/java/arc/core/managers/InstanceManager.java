package arc.core.managers;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.hypixel.hytale.builtin.instances.InstancesPlugin;
import com.hypixel.hytale.builtin.instances.config.InstanceWorldConfig;
import com.hypixel.hytale.builtin.instances.removal.RemovalCondition;
import com.hypixel.hytale.math.vector.Transform;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.WorldConfig;

import arc.core.loggers.Logger;

public class InstanceManager {
  

  public static CompletableFuture<World> CreateInstance
  (
    @Nonnull String templateName,
    @Nonnull String worldName, 
    @Nonnull World forWorld
  ) 
  {
    var spawnProvider =  forWorld.getWorldConfig().getSpawnProvider();
    if (spawnProvider == null) return null;
    var transform = spawnProvider.getSpawnPoint(forWorld, UUID.randomUUID());
    if (transform == null) return null;

    var instanceNameExists = InstancesPlugin.get().getInstanceAssets().contains(templateName);
    if (instanceNameExists == false) {
      Logger.Error("InstanceManager - CreateInstance - templateName doesnt exist");
      return null;
    }
    
    return InstancesPlugin.get().spawnInstance(templateName, worldName, forWorld, transform);
  }

  public static void RemoveInstance(
    @Nonnull World world, 
    @Nonnull RemovalCondition... conditions
  ) 
  {
    WorldConfig worldConfig = world.getWorldConfig();
    worldConfig.setDeleteOnRemove(true);

    InstanceWorldConfig instanceConfig = InstanceWorldConfig.ensureAndGet(worldConfig);

    instanceConfig.setRemovalConditions(conditions);

    InstancesPlugin.safeRemoveInstance(world);
  }

  public static void TeleportPlayerToLoadingInstance
  (
    @Nonnull PlayerRef playerRef, 
    @Nonnull CompletableFuture<World> loadingWorld,
    @Nullable Transform returnTransform
  ) 
  {
    var playerEntity = playerRef.getReference();
    if (playerEntity == null) return;

    var playerStore = playerEntity.getStore();
    
    InstancesPlugin.teleportPlayerToLoadingInstance(playerEntity, playerStore, loadingWorld, returnTransform);
  }

  public static void TeleportPlayerToInstance
  (
    @Nonnull PlayerRef playerRef, 
    @Nonnull World world,
    @Nullable Transform returnTransform
  ) 
  {
    var playerEntity = playerRef.getReference(); 
    if (playerEntity == null) return;
    var playerStore = playerEntity.getStore();

    InstancesPlugin.teleportPlayerToInstance(playerEntity, playerStore, world, returnTransform);
  }

  public static void RemovePlayerFromInstance(@Nonnull PlayerRef playerRef) {
    var playerEntity = playerRef.getReference();
    if (playerEntity == null) return;

    var playerStore = playerEntity.getStore();
    
    InstancesPlugin.exitInstance(playerEntity, playerStore);
  }
}
