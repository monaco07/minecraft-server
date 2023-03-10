package de.monaco07.publicserver.commands;

import de.monaco07.publicserver.Main;
import de.monaco07.publicserver.timer.Timer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sendUsage(sender);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "resume" -> {
                Timer timer = Main.getInstance().getTimer();

                if (timer.isRunning()) {
                    sender.sendMessage(ChatColor.RED + "Der Timer läuft bereits.");
                    break;
                }

                timer.setRunning(true);
                sender.sendMessage(ChatColor.GRAY + "Der Timer wurde gestartet.");
            }
            case "stop", "pause" -> {
                Timer timer = Main.getInstance().getTimer();

                if (!timer.isRunning()) {
                    sender.sendMessage(ChatColor.RED + "Der Timer läuft nicht.");
                    break;
                }

                timer.setRunning(false);
                sender.sendMessage(ChatColor.GRAY + "Der Timer wurde gestoppt.");
            }
            case "time", "set" -> {
                if (args.length != 2) {
                    sender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE +
                            "/timer set <Zeit>");
                    return true;
                }

                try {
                    Timer timer = Main.getInstance().getTimer();

                    timer.setRunning(false);
                    timer.setTime(Integer.parseInt(args[1]));
                    sender.sendMessage(ChatColor.GRAY + "Die Zeit wurde auf " + args[1] + " gesetzt.");
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "Dein Parameter 2 muss eine Zahl sein.");
                }
            }
            case "clear", "reset" -> {
                Timer timer = Main.getInstance().getTimer();

                timer.setRunning(false);
                timer.setTime(0);
                sender.sendMessage(ChatColor.GRAY + "Der Timer wurde zurückgesetzt.");
            }
            default -> sendUsage(sender);
        }
        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE +
                "/timer resume, /timer pause, /timer set <Zeit>, /timer reset");
    }

}
