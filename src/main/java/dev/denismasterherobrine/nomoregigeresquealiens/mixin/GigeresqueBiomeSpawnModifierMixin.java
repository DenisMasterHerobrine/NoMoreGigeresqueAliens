package dev.denismasterherobrine.nomoregigeresquealiens.mixin;

import dev.denismasterherobrine.nomoregigeresquealiens.GigeresqueControls;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "mods.cybercat.gigeresque.NeoForgeMod$ModEntitySpawn", remap = false)
public abstract class GigeresqueBiomeSpawnModifierMixin {
    @Inject(method = "modify", at = @At("HEAD"), cancellable = true)
    private void nomoregigeresquealiens$disableEggBiomeModifier(
            Holder<Biome> biome,
            BiomeModifier.Phase phase,
            ModifiableBiomeInfo.BiomeInfo.Builder builder,
            CallbackInfo ci
    ) {
        if (GigeresqueControls.disableBiomeEggSpawns()) {
            ci.cancel();
        }
    }
}
