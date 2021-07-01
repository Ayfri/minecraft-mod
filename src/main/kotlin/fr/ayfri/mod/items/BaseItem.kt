package fr.ayfri.mod.items

import fr.ayfri.mod.utils.IDOwner
import fr.ayfri.mod.utils.getFullID
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

interface IItem : IDOwner

open class BaseItem(override val id: String, settings: Settings) : Item(settings), IItem {
	override val fullID
		get() = getFullID(id)
	
	override fun register() {
		Registry.register(Registry.ITEM, fullID, this)
		println("Added item '$fullID' !")
	}
}
