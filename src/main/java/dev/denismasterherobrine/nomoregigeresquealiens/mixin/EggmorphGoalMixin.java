package dev.denismasterherobrine.nomoregigeresquealiens.mixin;

import dev.denismasterherobrine.nomoregigeresquealiens.GigeresqueControls;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "mods.cybercat.gigeresque.common.entity.ai.goals.nest.EggmorphGoal", remap = false)
public abstract class EggmorphGoalMixin {
    @Inject(method = {"canUse", "canContinueToUse"}, at = @At("HEAD"), cancellable = true)
    private void nomoregigeresquealiens$disableEggmorphing(CallbackInfoReturnable<Boolean> cir) {
        if (GigeresqueControls.disableEggmorphing()) {
            cir.setReturnValue(false);
        }
    }
}
