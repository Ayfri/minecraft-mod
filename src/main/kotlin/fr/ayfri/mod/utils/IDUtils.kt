package fr.ayfri.mod.utils

import fr.ayfri.mod.mod_id
import net.minecraft.util.Identifier

fun customID(name: String) = Identifier(mod_id, name)

fun getFullID(id: String) = "$mod_id:$id"
