/*
 *  Prison is a Minecraft plugin for the prison game mode.
 *  Copyright (C) 2017 The Prison Team
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

package tech.mcprison.prison.spigot.economies;

import org.bukkit.Bukkit;
import tech.mcprison.prison.integration.EconomyIntegration;
import tech.mcprison.prison.internal.Player;

/**
 * Integrates with Essentials Economy.
 *
 * @author Faizaan A. Datoo
 */
public class EssentialsEconomy implements EconomyIntegration {

    public static final String PROVIDER_NAME = "Essentials";
    public static final String PROVIDER_DISPLAY_NAME = "EssentialsX";
    
	private EssEconomyWrapper wrapper = null;

    public EssentialsEconomy() {
    	super();
    }
	
	@Override
	public void integrate() {
		if (Bukkit.getPluginManager().isPluginEnabled(PROVIDER_NAME)) {
			wrapper = new EssEconomyWrapper();
		}
	}

    @Override public double getBalance(Player player) {
        return wrapper.getBalance(player);
    }

    @Override public void setBalance(Player player, double amount) {
        wrapper.setBalance(player, amount);
    }

    @Override public void addBalance(Player player, double amount) {
        setBalance(player, getBalance(player) + amount);
    }

    @Override public void removeBalance(Player player, double amount) {
        setBalance(player, getBalance(player) - amount);
    }

    @Override public boolean canAfford(Player player, double amount) {
        return getBalance(player) >= amount;
    }

    @Override public String getProviderName() {
        return PROVIDER_DISPLAY_NAME;
    }
    
    @Override
    public String getKeyName() {
    	return PROVIDER_NAME;
    }
    
    @Override public boolean hasIntegrated() {
        return wrapper != null;
    }

}
