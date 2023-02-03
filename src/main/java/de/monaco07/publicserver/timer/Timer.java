package de.monaco07.publicserver.timer;

import de.monaco07.publicserver.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {
    private boolean running; // läuft oder nicht
    private int time;


    public Timer(boolean running, int time) {
        this.running = running;
        this.time = time;



        run();
    }

    public String timeString(int time){
        String seconds;
        String minutes;

        int secondsNow = time % 60;
        int minutesAll = (time - secondsNow)/60;
        int minutesNow = minutesAll % 60;
        int hoursAll = (minutesAll - minutesNow) % 60;

        // Sekunden
        if(secondsNow < 10){
            seconds = "0" + secondsNow;
        }else{
            seconds = secondsNow + "";
        }

        // Minuten
        if(minutesNow < 10){
            minutes = "0" + minutesNow;
        }else {
            minutes = minutesNow + "";
        }


        if(hoursAll == 0){
            return (ChatColor.GOLD.toString() + ChatColor.BOLD + minutes + " : " + seconds);
        } else
            return (ChatColor.GOLD.toString() + ChatColor.BOLD + hoursAll + " : " + minutes + " : " + seconds);

    }

    public void sendActionBar() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!isRunning()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + "Pause"));
                continue;
            }
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(timeString(getTime())));


        }
    }


    private void run(){
        new BukkitRunnable(){
            @Override
            public void run(){
                sendActionBar();

                if(!isRunning()) {
                    return;
                }

                setTime(getTime() + 1);
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


}