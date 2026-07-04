package dev.denismasterherobrine.nomoregigeresquealiens.mixin;

import dev.denismasterherobrine.nomoregigeresquealiens.GigeresqueControls;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "mods.cybercat.gigeresque.common.block.entity.SporeBlockEntity", remap = false)
public abstract class SporeBlockEntityMixin {
    @Inject(method = "particleCloud", at = @At("HEAD"), cancellable = true)
    private void nomoregigeresquealiens$disableSporeInfection(LivingEntity entity, CallbackInfo ci) {
        if (GigeresqueControls.disableSporeInfection()) {
            ci.cancel();
        }
    }
}
