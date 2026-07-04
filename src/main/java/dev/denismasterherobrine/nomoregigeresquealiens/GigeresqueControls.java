package dev.denismasterherobrine.nomoregigeresquealiens;

import java.util.Locale;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.levelgen.structure.Structure;

public final class GigeresqueControls {
    public static final String GIGERESQUE_NAMESPACE = "gigeresque";

    public static boolean disableBiomeEggSpawns() {
        return NoMoreGigeresqueAliensConfig.DISABLE_GIGERESQUE_BIOME_EGG_SPAWNS.get();
    }

    public static boolean disablePandoraEffect() {
        return NoMoreGigeresqueAliensConfig.DISABLE_PANDORA_EFFECT.get();
    }

    public static boolean resetPandoraTrigger() {
        return NoMoreGigeresqueAliensConfig.RESET_PANDORA_TRIGGER.get();
    }

    public static boolean generateDungeons() {
        return NoMoreGigeresqueAliensConfig.GENERATE_GIGERESQUE_DUNGEONS.get();
    }

    public static boolean disableEggmorphing() {
        return NoMoreGigeresqueAliensConfig.DISABLE_EGGMORPHING.get();
    }

    public static boolean disableSporeInfection() {
        return NoMoreGigeresqueAliensConfig.DISABLE_SPORE_INFECTION.get();
    }

    public static boolean shouldBlock(Entity entity) {
        return entity != null && shouldBlock(entity.getType());
    }

    public static boolean shouldBlock(EntityType<?> entityType) {
        ResourceLocation id = BuiltInRegistries.ENTITY_TYPE.getKey(entityType);
        if (!GIGERESQUE_NAMESPACE.equals(id.getNamespace())) {
            return false;
        }
        return NoMoreGigeresqueAliensConfig.BLOCKED_ENTITY_IDS.get().stream()
                .map(value -> value.toLowerCase(Locale.ROOT))
                .anyMatch(value -> value.equals(id.toString()));
    }

    public static boolean isGigeresqueStructure(Holder<Structure> structure) {
        return structure.unwrapKey()
                .map(ResourceKey::location)
                .map(ResourceLocation::getNamespace)
                .filter(GIGERESQUE_NAMESPACE::equals)
                .isPresent();
    }

    private GigeresqueControls() {
    }
}
