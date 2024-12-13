package io.github.potarodev.skdoc

import ch.njol.skript.Skript
import ch.njol.skript.SkriptAddon
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class SkriptDocsExtractor : JavaPlugin(), CommandExecutor {

    override fun onEnable() {
        this.getCommand("dump")?.setExecutor(this)
    }

    override fun onDisable() {

    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (label != "dump") return false
        val addons = getSkriptAddons()
        println(addons)
        return true
    }

    fun getSkriptAddons(): List<SkriptAddon> {
        val addons = mutableListOf(Skript.getAddonInstance())
        addons.addAll(Skript.getAddons())
        return addons.toList()
    }
}
