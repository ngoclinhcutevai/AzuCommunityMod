package com.ngoclinh.acm.sound;

import com.ngoclinh.acm.AzusCommunityMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent DISC_BLUE = registerSoundEvent("disc_blue");
    public static final SoundEvent DISC_HORIZON = registerSoundEvent("disc_horizon");
    public static final SoundEvent DISC_CLOUDS = registerSoundEvent("disc_clouds");

    public static final RegistryKey<JukeboxSong> DISC_BLUE_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(AzusCommunityMod.MOD_ID, "disc_blue"));
    public static final RegistryKey<JukeboxSong> DISC_HORIZON_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(AzusCommunityMod.MOD_ID, "disc_horizon"));
    public static final RegistryKey<JukeboxSong> DISC_CLOUDS_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(AzusCommunityMod.MOD_ID, "disc_blue"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(AzusCommunityMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void initialize() {}
}
