package fr.ayfri.mod.items

import fr.ayfri.mod.utils.getFullID
import net.minecraft.block.BlockState
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.MiningToolItem
import net.minecraft.item.ToolMaterial
import net.minecraft.tag.BlockTags
import net.minecraft.util.registry.Registry


class DoubleAxeSettings(var attackDamage: Float = 1f, var attackSpeed: Float = 1f) : Item.Settings() {
}

open class DoubleAxeItem(override val id: String, material: ToolMaterial, settings: DoubleAxeSettings) :
	MiningToolItem(settings.attackDamage, settings.attackSpeed, material, BlockTags.AXE_MINEABLE, settings), IItem {
	override val fullID: String
		get() = getFullID(id)
	
	override fun getMiningSpeedMultiplier(stack: ItemStack?, state: BlockState?): Float {
		return super.getMiningSpeedMultiplier(stack, state) * 0.7f
	}
	
	override fun register() {
		Registry.register(Registry.ITEM, fullID, this)
		println("Added item $fullID !")
	}
}
