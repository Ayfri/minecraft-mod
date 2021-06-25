package fr.ayfri.mod.items

import net.minecraft.item.ItemGroup
import net.minecraft.item.ToolMaterials

val ITEMS = mutableMapOf<String, IItem>()

fun initItems() {
	addItem(DoubleAxeItem("iron_double_axe", ToolMaterials.IRON, DoubleAxeSettings().apply {
		attackDamage = 8f
		attackSpeed = -3.2f
		maxDamage(300)
		group(ItemGroup.TOOLS)
	}))
	
	register()
}

fun addItem(item: IItem) = ITEMS.put(item.id, item)

fun register() = ITEMS.values.forEach(IItem::register)
