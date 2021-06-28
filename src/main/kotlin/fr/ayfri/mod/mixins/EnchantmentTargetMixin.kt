package fr.ayfri.mod.mixins

import fr.ayfri.mod.items.DoubleAxeItem
import net.minecraft.item.Item
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

@Mixin(targets = ["net.minecraft.enchantment.EnchantmentTarget$11"])
abstract class EnchantmentTargetMixin {
	@Inject(method = ["isAcceptableItem"], at = [At("HEAD")], cancellable = true)
	fun changeWeaponCondition(item: Item, cir: CallbackInfoReturnable<Boolean>) {
		if (item is DoubleAxeItem) cir.returnValue = true
	}
}
