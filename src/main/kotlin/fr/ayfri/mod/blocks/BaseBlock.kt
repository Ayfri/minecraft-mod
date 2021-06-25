package fr.ayfri.mod.blocks

import fr.ayfri.mod.utils.IDOwner
import fr.ayfri.mod.utils.customID
import fr.ayfri.mod.utils.getFullID
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.MapColor
import net.minecraft.block.Material
import net.minecraft.util.registry.Registry

open class BaseBlock(override val id: String, settings: FabricBlockSettings) : Block(settings), IDOwner {
	constructor(id: String, material: Material, color: MapColor) : this(id, FabricBlockSettings.of(material).mapColor(color))
	constructor(id: String, material: Material) : this(id, FabricBlockSettings.of(material))
	
	override val fullID
		get() = getFullID(id)
	
	override fun register() {
		Registry.register(Registry.BLOCK, customID(id), this)
		println("Added block '$fullID' !")
	}
}
