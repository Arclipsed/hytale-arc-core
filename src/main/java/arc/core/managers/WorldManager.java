package arc.core.managers;

import java.nio.file.Path;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.WorldConfig;

public class WorldManager {

  public static CompletableFuture<World> CreateWorld
  (
    @Nonnull String worldName,
    @Nonnull UUID uuid,
    @Nonnull WorldConfig config
  ) 
  {
    UUID worldId = uuid;
    String path = "./universe/worlds/" + worldName;
    Path filePath = Path.of(path);
    if (filePath == null) return null;
    
    config.setUuid(worldId);
    
    return Universe.get().makeWorld(worldName, filePath, config);
  }

  public static World GetWorldById(@Nonnull UUID worldId) {
    return Universe.get().getWorld(worldId);
  }

  public static World GetWorldByName(@Nonnull String worldName) {
    return Universe.get().getWorld(worldName);
  }
}
