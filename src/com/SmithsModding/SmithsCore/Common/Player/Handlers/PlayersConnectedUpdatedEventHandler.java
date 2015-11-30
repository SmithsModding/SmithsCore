/*
 * Copyright (c) 2015.
 *
 * Copyrighted by SmithsModding according to the project License
 */

package com.SmithsModding.SmithsCore.Common.Player.Handlers;

import com.SmithsModding.SmithsCore.Common.Player.Event.PlayersConnectedUpdatedEvent;
import com.SmithsModding.SmithsCore.Common.Player.Management.PlayerManager;
import com.SmithsModding.SmithsCore.SmithsCore;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;

public class PlayersConnectedUpdatedEventHandler {

    //Automatically Registers this to the NetworkEventBus when the system is running on the Client Side
    static {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            SmithsCore.getRegistry().getNetworkBus().register(new PlayersConnectedUpdatedEventHandler());
        }
    }

    /**
     * Method for handling the Network event when it arrives on the client side.
     *
     * @param event
     */
    @SubscribeEvent
    public void onPlayersConnectedUpdated(PlayersConnectedUpdatedEvent event) {
        PlayerManager.getInstance().setCommonSidedJoinedMap(event.getCommonSidedJoinedMap());
    }
}