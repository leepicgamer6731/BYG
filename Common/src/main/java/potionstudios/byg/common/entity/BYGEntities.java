package potionstudios.byg.common.entity;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.boat.BYGBoatEntity;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

@SuppressWarnings("deprecation")
public class BYGEntities {
    private static final RegistrationProvider<EntityType<?>> PROVIDER = RegistrationProvider.get(Registry.ENTITY_TYPE_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<EntityType<BYGBoatEntity>> BOAT = createEntity("boat", EntityType.Builder.<BYGBoatEntity>of(BYGBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F));

    //TODO: Geckolib Mojmap 1.18
//    public static final EntityType<ManOWar> MAN_O_WAR = createEntity("man_o_war", EntityType.Builder.of(ManOWar::new, MobCategory.AMBIENT).sized(0.6F, 1.75F).build(BYG.MOD_ID + ":man_o_war"));

    public static <E extends Entity> RegistryObject<EntityType<E>> createEntity(String id, EntityType.Builder<E> entityType) {
        return PROVIDER.register(id, () -> entityType.build(BYG.MOD_ID + ":" + id));
    }

    public static void loadClass() {}
}
