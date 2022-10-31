/**
 * PacketWrapper - ProtocolLib wrappers for Minecraft packets
 * Copyright (C) dmulloy2 <http://dmulloy2.net>
 * Copyright (C) Kristian S. Strangeland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.CombatEventType;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayServerDeathCombatEvent extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Server.PLAYER_COMBAT_KILL;

    public WrapperPlayServerDeathCombatEvent() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }

    public WrapperPlayServerDeathCombatEvent(PacketContainer packet) {
        super(packet, TYPE);
    }

    /**
     * Retrieve Player ID.
     *
     * @return The current Player ID
     */
    public int getPlayerID() {
        return handle.getIntegers().read(0);
    }

    /**
     * Set Player ID.
     *
     * @param value - the player's id to send the death screen to (should match client's id)
     */
    public void setPlayerId(int value) {
        handle.getIntegers().write(0, value);
    }

    /**
     * Retrieve Entity ID.
     *
     * @return The current Entity ID
     */
    public int getEntityID() {
        return handle.getIntegers().read(1);
    }

    /**
     * Set Entity ID.
     *
     * @param value - the killer's entity id (-1 if no obvious killer)
     */
    public void setEntityId(int value) {
        handle.getIntegers().write(1, value);
    }

    /**
     * Retrieve Message.
     *
     * @return The current Message
     */
    public WrappedChatComponent getMessage() {
        return handle.getChatComponents().read(0);
    }

    /**
     * Set Message.
     *
     * @param value - the message shown on the death screen
     */
    public void setMessage(WrappedChatComponent value) {
        handle.getChatComponents().write(0, value);
    }
}