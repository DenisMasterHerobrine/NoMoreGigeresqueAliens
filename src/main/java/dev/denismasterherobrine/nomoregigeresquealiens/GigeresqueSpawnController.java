package dev.denismasterherobrine.nomoregigeresquealiens;

import mods.cybercat.gigeresque.common.worlddata.PandoraData;
import net.minecraft.world.entity.MobSpawnType;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

public final class GigeresqueSpawnController {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onSpawnPlacementCheck(MobSpawnEvent.SpawnPlacementCheck event) {
        if (GigeresqueControls.shouldBlock(event.getEntityType())) {
            event.setResult(MobSpawnEvent.SpawnPlacementCheck.Result.FAIL);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPositionCheck(MobSpawnEvent.PositionCheck event) {
        if (GigeresqueControls.shouldBlock(event.getEntity())) {
            event.setResult(MobSpawnEvent.PositionCheck.Result.FAIL);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onFinalizeSpawn(FinalizeSpawnEvent event) {
        if (GigeresqueControls.shouldBlock(event.getEntity()) && event.getSpawnType() != MobSpawnType.COMMAND) {
            event.setSpawnCancelled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onEntityJoinLevel(EntityJoinLevelEvent event) {
        if (!NoMoreGigeresqueAliensConfig.CANCEL_BLOCKED_ENTITY_JOIN.get()) {
            return;
        }
        if (event.loadedFromDisk() && NoMoreGigeresqueAliensConfig.KEEP_LOADED_EXISTING_ENTITIES.get()) {
            return;
        }
        if (GigeresqueControls.shouldBlock(event.getEntity())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onLevelTick(LevelTickEvent.Pre event) {
        if (GigeresqueControls.resetPandoraTrigger()) {
            PandoraData.setIsTriggered(false);
        }
    }
}
