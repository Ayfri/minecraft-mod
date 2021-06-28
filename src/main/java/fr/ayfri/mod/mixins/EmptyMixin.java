package fr.ayfri.mod.mixins;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;

/**
 * An empty mixin so that the Mixin annotation processor will generate a refmap for the Kotlin Mixins
 */
@Mixin(MinecraftServer.class)
class EmptyMixin {}
