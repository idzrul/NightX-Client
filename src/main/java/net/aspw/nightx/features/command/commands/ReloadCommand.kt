package net.aspw.nightx.features.command.commands

import net.aspw.nightx.NightX
import net.aspw.nightx.features.command.Command
import net.aspw.nightx.features.command.CommandManager
import net.aspw.nightx.ui.client.clickgui.newVer.NewUi
import net.aspw.nightx.ui.font.Fonts
import net.aspw.nightx.utils.misc.sound.TipSoundManager

class ReloadCommand : Command("reload", arrayOf("configreload")) {
    /**
     * Execute commands with provided [args]
     */
    override fun execute(args: Array<String>) {
        chat("Reloading...")
        NightX.commandManager = CommandManager()
        NightX.commandManager.registerCommands()
        NightX.isStarting = true
        NightX.scriptManager.disableScripts()
        NightX.scriptManager.unloadScripts()
        for (module in NightX.moduleManager.modules)
            NightX.moduleManager.generateCommand(module)
        NightX.scriptManager.loadScripts()
        NightX.scriptManager.enableScripts()
        Fonts.loadFonts()
        NightX.tipSoundManager = TipSoundManager()
        NightX.fileManager.loadConfig(NightX.fileManager.modulesConfig)
        NightX.isStarting = false
        NightX.fileManager.loadConfig(NightX.fileManager.valuesConfig)
        NightX.fileManager.loadConfig(NightX.fileManager.accountsConfig)
        NightX.fileManager.loadConfig(NightX.fileManager.friendsConfig)
        NightX.fileManager.loadConfig(NightX.fileManager.xrayConfig)
        NightX.fileManager.loadConfig(NightX.fileManager.hudConfig)
        NewUi.resetInstance()
        NightX.isStarting = false
        chat("Reloaded!")
    }
}