package arc.core.managers;

import javax.annotation.Nonnull;

import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;


public class ComponentManager {

  public static <T extends Component<EntityStore>> void AttachComponentToEntity
  (
    @Nonnull Ref<EntityStore> ref,
    @Nonnull Store<EntityStore> store,
    ComponentType<EntityStore, T> componentType
  ) 
  {
    if (componentType == null) return;
    
    var component = store.getComponent(ref, componentType);
    if (component == null) {
      store.addComponent(ref, componentType);
    }
  }

  public static <T extends Component<EntityStore>> void RemoveComponentFromEntity
  (
    @Nonnull Ref<EntityStore> ref,
    @Nonnull Store<EntityStore> store,
    ComponentType<EntityStore, T> componentType
  ) 
  {
    if (componentType == null) return;
    
    var component = store.getComponent(ref, componentType);
    if (component != null) {
      store.removeComponent(ref, componentType);
    }
  }

  public static <T extends Component<EntityStore>> T GetComponentFromEntity
  (
    @Nonnull Ref<EntityStore> ref,
    @Nonnull Store<EntityStore> store,
    ComponentType<EntityStore, T> componentType
  ) 
  {
    if (componentType == null) return null;
    
    return store.getComponent(ref, componentType);
  }
}
