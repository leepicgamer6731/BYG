package corgiaoc.byg.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import corgiaoc.byg.BYG;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGWorldConfig {
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.IntValue biomeSize;
    public static ForgeConfigSpec.IntValue biomeSizeNETHER;
    public static ForgeConfigSpec.IntValue biomeSizeEND;

    public static ForgeConfigSpec.IntValue seaLevel;
    public static ForgeConfigSpec.ConfigValue<String> externalEndBiomes;
    public static ForgeConfigSpec.ConfigValue<String> netherBiomes;
    public static ForgeConfigSpec.ConfigValue<String> externalICYBiomes;
    public static ForgeConfigSpec.ConfigValue<String> externalWARMBiomes;
    public static ForgeConfigSpec.ConfigValue<String> externalHOTBiomes;
    public static ForgeConfigSpec.ConfigValue<String> externalCOOLBiomes;
    public static ForgeConfigSpec.BooleanValue controlNether;
    public static ForgeConfigSpec.BooleanValue controlEnd;

    static {
        COMMON_BUILDER.comment("Dimension Settings").push("Dimension_Settings").push("The_End");
        controlEnd = COMMON_BUILDER.comment("Does BYG control The End?").define("ControlEnd", true);
        externalEndBiomes = COMMON_BUILDER.comment("Add external End biomes by their registry ID's in a commented list.\n Adding a biome several times gives it more weight in generation.\nPutting \"all\" will use all available end biomes in the registry.\nDefault: \"all\"").define("ExternalEndBiomes", "all");
        biomeSizeEND = COMMON_BUILDER.comment("End Biome Size\nResults vary.\nDefault: 1").defineInRange("EndBiomeSize", 1, 0, 10);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.push("The_Nether");
        controlNether = COMMON_BUILDER.comment("Does BYG control The Nether?").define("ControlNether", true);
        netherBiomes = COMMON_BUILDER.comment("Add external End biomes by their registry ID's in a commented list.\n Adding a biome several times gives it more weight in generation.\nPutting \"all\" will use all available end biomes in the registry.\nDefault: \"all\".").define("NetherBiomes", "all");
        biomeSizeNETHER = COMMON_BUILDER.comment("Nether Biome Size\nDefault: 3").defineInRange("NetherBiomeSize", 3, 0, 10);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec config, Path path) {
        BYG.LOGGER.info("Loading config: " + path);
        CommentedFileConfig file = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }
}