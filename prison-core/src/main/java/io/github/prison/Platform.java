/*
 *  Prison is a Minecraft plugin for the prison game mode.
 *  Copyright (C) 2016 The Prison Team
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.prison;

import io.github.prison.internal.Player;
import io.github.prison.internal.World;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Represents a platform that Prison has been implemented for.
 *
 * @author SirFaizdat
 * @since 3.0
 */
public interface Platform {

    /**
     * Returns the world with the specified name.
     */
    World getWorld(String name);

    /**
     * Returns the player with the specified name.
     */
    Player getPlayer(String name);

    /**
     * Returns the player with the specified UUID.
     */
    Player getPlayer(UUID uuid);

    /**
     * Returns a list of all online players.
     */
    List<Player> getOnlinePlayers();

    /**
     * Returns the plugin's version.
     */
    String getPluginVersion();

    /**
     * Returns the {@link File} representing the plugin's designated storage folder.
     * This directory must have already been created by the implementation.
     */
    File getPluginDirectory();

}
