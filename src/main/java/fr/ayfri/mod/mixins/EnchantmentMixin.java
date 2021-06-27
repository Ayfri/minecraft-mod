package fr.ayfri.mod.mixins;

import fr.ayfri.mod.items.DoubleAxeItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {
	@Shadow @Final public EnchantmentTarget type;

	// add code to 'isAcceptableItem' function at HEAD
	@Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
	private void includeDoubleAxe(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
		if (itemStack.getItem() instanceof DoubleAxeItem && type == EnchantmentTarget.WEAPON) cir.setReturnValue(true);
	}
}
