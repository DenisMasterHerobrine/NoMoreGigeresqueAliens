package dev.denismasterherobrine.nomoregigeresquealiens;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(NoMoreGigeresqueAliens.MODID)
public class NoMoreGigeresqueAliens {
    public static final String MODID = "nomoregigeresquealiens";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NoMoreGigeresqueAliens(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.SERVER, NoMoreGigeresqueAliensConfig.SPEC);
        NeoForge.EVENT_BUS.register(new GigeresqueSpawnController());
        LOGGER.info("NoMoreGigeresqueAliens loaded");
    }
}
