package com.smithsmodding.smithscore.client.gui.management;

import com.smithsmodding.smithscore.client.gui.components.core.*;
import net.minecraftforge.fluids.*;

import java.util.*;

/**
 * Created by Orion
 * Created on 01.12.2015
 * 18:11
 * <p/>
 * Copyrighted according to Project specific license
 */
public class TileStorageBasedGUIManager implements IGUIManager{

    private ArrayList<UUID> watchingPlayers = new ArrayList<UUID>();

    /**
     * Method called when a player closed the linked UI.
     *
     * @param playerId The unique ID of the player that opens the UI.
     */
    @Override
    public void onGuiOpened(UUID playerId) {
        if (watchingPlayers.contains(playerId)) {
            return;
        }

        watchingPlayers.add(playerId);
    }

    /**
     * Method called when a player closes the linked UI.
     *
     * @param playerID The unique ID of the player that closed the UI.
     */
    @Override
    public void onGUIClosed(UUID playerID) {
        if (!watchingPlayers.contains(playerID)) {
            return;
        }

        watchingPlayers.remove(playerID);
    }

    /**
     * Method used by components that support overriding tooltips to grab the new tooltip string.
     *
     * @param component The component requesting the override.
     *
     * @return A string displayed as tooltip for the IGUIComponent during rendering.
     */
    @Override
    public String getCustomToolTipDisplayString (IGUIComponent component) {
        return "";
    }

    /**
     * Method to get the value for a progressbar. RAnged between 0 and 1.
     *
     * @param component The component to get the value for
     *
     * @return A float between 0 and 1 with 0 meaning no progress on the specific bar and 1 meaning full.
     */
    @Override
    public float getProgressBarValue (IGUIComponent component) {
        return 0F;
    }

    /**
     * Method used by the rendering system to dynamically update a Label.
     *
     * @param component The component requesting the content.
     *
     * @return THe string that should be displayed.
     */
    @Override
    public String getLabelContents (IGUIComponent component) {
        return "";
    }

    @Override
    public ArrayList<FluidStack> getTankContents (IGUIComponent component) {
        return new ArrayList<FluidStack>();
    }

    @Override
    public int getTotalTankContents (IGUIComponent component) {
        return 0;
    }

    /**
     * Method called by GUI's that are tab based when the active Tab changed.
     *
     * @param newActiveTabId The new active Tabs ID.
     */
    @Override
    public void onTabChanged (String newActiveTabId) {
        return;
    }
}