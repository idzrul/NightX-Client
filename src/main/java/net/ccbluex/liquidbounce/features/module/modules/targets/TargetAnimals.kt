package net.ccbluex.liquidbounce.features.module.modules.targets

import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.utils.EntityUtils

@ModuleInfo(name = "TargetAnimals", category = ModuleCategory.TARGETS, array = false)
class TargetAnimals : Module() {
    override fun onEnable() {
        super.onEnable()
        EntityUtils.targetAnimals = true
    }

    override fun onDisable() {
        super.onDisable()
        EntityUtils.targetAnimals = false
    }

    init {
        state = true
    }
}