package dev.denismasterherobrine.nomoregigeresquealiens.mixin;

import dev.denismasterherobrine.nomoregigeresquealiens.GigeresqueControls;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "mods.cybercat.gigeresque.common.worlddata.PandoraEffect", remap = false)
public abstract class PandoraEffectMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void nomoregigeresquealiens$disablePandoraSpawns(
            ServerLevel level,
            boolean spawnEnemies,
            boolean spawnFriendlies,
            CallbackInfoReturnable<Integer> cir
    ) {
        if (GigeresqueControls.disablePandoraEffect()) {
            cir.setReturnValue(0);
        }
    }
}
