package arc.core.managers;

import java.util.List;

import javax.annotation.Nonnull;

import com.hypixel.hytale.common.plugin.PluginIdentifier;
import com.hypixel.hytale.common.semver.SemverRange;
import com.hypixel.hytale.server.core.plugin.PluginBase;
import com.hypixel.hytale.server.core.plugin.PluginManager;

public class PluginsManager {

  public static boolean HasPlugin
  (
    @Nonnull String group, 
    @Nonnull String name,
    @Nonnull String version
  ) 
  {
    return PluginManager.get().hasPlugin(new PluginIdentifier(group, name), SemverRange.fromString(version));
  }

  public static PluginBase GetPlugin
  (
    @Nonnull String group, 
    @Nonnull String name,
    @Nonnull String version
  ) 
  {
    return PluginManager.get().getPlugin(new PluginIdentifier(group, name));
  }

  public static List<PluginBase> GetPlugins()
  {
    return PluginManager.get().getPlugins();
  }
}
