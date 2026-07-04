package dev.denismasterherobrine.nomoregigeresquealiens;

import java.util.List;
import net.neoforged.neoforge.common.ModConfigSpec;

public final class NoMoreGigeresqueAliensConfig {
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue DISABLE_GIGERESQUE_BIOME_EGG_SPAWNS;
    public static final ModConfigSpec.BooleanValue DISABLE_PANDORA_EFFECT;
    public static final ModConfigSpec.BooleanValue RESET_PANDORA_TRIGGER;
    public static final ModConfigSpec.BooleanValue DISABLE_EGGMORPHING;
    public static final ModConfigSpec.BooleanValue DISABLE_SPORE_INFECTION;
    public static final ModConfigSpec.BooleanValue CANCEL_BLOCKED_ENTITY_JOIN;
    public static final ModConfigSpec.BooleanValue KEEP_LOADED_EXISTING_ENTITIES;
    public static final ModConfigSpec.ConfigValue<List<? extends String>> BLOCKED_ENTITY_IDS;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("gigeresque_control");

        DISABLE_GIGERESQUE_BIOME_EGG_SPAWNS = builder
                .comment("Stops Gigeresque's biome modifier from adding alien egg spawns to overworld biomes.")
                .define("disableGigeresqueBiomeEggSpawns", true);

        DISABLE_PANDORA_EFFECT = builder
                .comment("Stops PandoraEffect from spawning eggs around players after Pandora is triggered.")
                .define("disablePandoraEffect", true);

        RESET_PANDORA_TRIGGER = builder
                .comment("Forces Gigeresque PandoraData.isTriggered() back to false every server tick.")
                .define("resetPandoraTrigger", false);

        DISABLE_EGGMORPHING = builder
                .comment("Stops xenomorph eggmorph AI from converting victims into new alien eggs.")
                .define("disableEggmorphing", true);

        DISABLE_SPORE_INFECTION = builder
                .comment("Stops neomorph spore blocks from applying the spore effect and creating new aliens.")
                .define("disableSporeInfection", true);

        CANCEL_BLOCKED_ENTITY_JOIN = builder
                .comment("Cancels new blocked Gigeresque entities when they try to enter the world.")
                .define("cancelBlockedEntityJoin", true);

        KEEP_LOADED_EXISTING_ENTITIES = builder
                .comment("Keeps already saved entities when chunks load from disk. Disable to purge blocked entities too.")
                .define("keepLoadedExistingEntities", true);

        BLOCKED_ENTITY_IDS = builder
                .comment(
                        "Gigeresque entity ids to block. Empty by default so existing and newly spawned entities are not removed unless you opt in.",
                        "Known ids: gigeresque:egg, gigeresque:aqua_egg, gigeresque:alien, gigeresque:aquatic_alien, gigeresque:chestburster, gigeresque:aquatic_chestburster, gigeresque:facehugger, gigeresque:runner_alien, gigeresque:runnerburster, gigeresque:popper, gigeresque:hammerpede, gigeresque:stalker, gigeresque:neoburster, gigeresque:neomorph_adolescent, gigeresque:neomorph, gigeresque:spitter, gigeresque:draconictemplebeast, gigeresque:ravenoustemplebeast, gigeresque:moonlighthorrortemplebeast, gigeresque:hellmorph_runner, gigeresque:baphomorph, gigeresque:hell_burster"
                )
                .defineListAllowEmpty(
                        List.of("blockedEntityIds"),
                        List::of,
                        () -> "",
                        value -> value instanceof String id && id.contains(":"));

        builder.pop();
        SPEC = builder.build();
    }

    private NoMoreGigeresqueAliensConfig() {
    }
}
