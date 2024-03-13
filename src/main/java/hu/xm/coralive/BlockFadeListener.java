package hu.xm.coralive;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

import java.util.EnumSet;

public class BlockFadeListener implements Listener {

    private static final EnumSet<Material> corals = EnumSet.of(
            Material.BRAIN_CORAL,
            Material.BRAIN_CORAL_BLOCK,
            Material.BRAIN_CORAL_FAN,
            Material.BRAIN_CORAL_WALL_FAN,
            Material.BUBBLE_CORAL,
            Material.BUBBLE_CORAL_BLOCK,
            Material.BUBBLE_CORAL_FAN,
            Material.BUBBLE_CORAL_WALL_FAN,
            Material.FIRE_CORAL,
            Material.FIRE_CORAL_BLOCK,
            Material.FIRE_CORAL_FAN,
            Material.FIRE_CORAL_WALL_FAN,
            Material.TUBE_CORAL,
            Material.TUBE_CORAL_BLOCK,
            Material.TUBE_CORAL_FAN,
            Material.TUBE_CORAL_WALL_FAN,
            Material.HORN_CORAL,
            Material.HORN_CORAL_BLOCK,
            Material.HORN_CORAL_FAN,
            Material.HORN_CORAL_WALL_FAN
    );

    @EventHandler
    public void onBlockFade(BlockFadeEvent e) {
        if(corals.contains(e.getBlock().getType())) {
            e.setCancelled(true);
        }
    }

}
