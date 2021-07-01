package fr.ayfri.mod.client

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment

@Environment(EnvType.CLIENT)
class AyModClient : ClientModInitializer {
	override fun onInitializeClient() = println("AyClient initialized")
}
