package arc.core.managers;

import java.util.Set;
import java.util.UUID;

import javax.annotation.Nonnull;

import com.hypixel.hytale.server.core.permissions.PermissionsModule;

public class PermissionManager {

  public static void AddUserToGroup
  (
    @Nonnull UUID playerId, 
    @Nonnull String group
  ) 
  {
    if (UserHasGroup(playerId, group)) return;

    PermissionsModule.get().addUserToGroup(playerId, group);
  }

  public static void RemoveUserFromGroup
  (
    @Nonnull UUID playerId, 
    @Nonnull String group
  ) 
  {
    if (!UserHasGroup(playerId, group)) return;
    
    PermissionsModule.get().removeUserFromGroup(playerId, group);
  }

  public static boolean UserHasPermission
  (
    @Nonnull UUID playerId,
    @Nonnull String permission
  ) 
  {
    return PermissionsModule.get().hasPermission(playerId, permission);
  }

  public static boolean UserHasGroup
  (
    @Nonnull UUID playerId,
    @Nonnull String group
  ) 
  {
    return PermissionsModule.get().getGroupsForUser(playerId).contains(group);
  }

  public static void AddPermisionToGroup
  (
    @Nonnull String group,
    Set<String> permissions
  ) 
  {
    if (permissions == null) return;
    
    PermissionsModule.get().addGroupPermission(group, permissions);
  }
}
