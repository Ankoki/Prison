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

import java.math.MathContext;

import com.earth2me.essentials.api.Economy;

import tech.mcprison.prison.integration.EconomyIntegration;
import tech.mcprison.prison.internal.Player;

/**
 * Integrates with Essentials Economy.
 *
 * @author Faizaan A. Datoo
 */
public class EssentialsEconomy 
	extends EconomyIntegration {

	private EssEconomyWrapper wrapper = null;

    public EssentialsEconomy() {
    	super( "EssentialsX", "Essentials" );
    	
    }
	
    /**
     * <p>This is tied to the plugin name Essentials, which is broadly covering many
     * possible behaviors, but we are interested in if Essentials Economy is being
     * used.  The easiest way to ensure it is active, is to try to access the 
     * Economy singleton, if it throws a NoClassDefFoundError then it has not 
     * been loaded.
     * </p>
     * 
     * <p>Had inconsistent luck with using a classloader to check to see if the
     * Economy class has been loaded, since there could be many different instances
     * of class loaders, and you have to use the right now.  The default that was
     * being tried was the System class loader, which was not successful at all.
     * To pick and chose one would be a crap-shot at best (gambling), so the 
     * safest way is to just try and use it. Plain and simple, without extra overhead
     * of hunting down the correct classloader.
     * </p>
     */
	@Override
	public void integrate() {
		if ( isRegistered() // && classLoaded 
				) {
			try {
				@SuppressWarnings( "unused" )
				MathContext mathCtx = Economy.MATH_CONTEXT;

				wrapper = new EssEconomyWrapper();
			}
			catch ( java.lang.NoClassDefFoundError | Exception e )
			{
				e.printStackTrace();
			}
		}
	}

    @Override 
    public double getBalance(Player player) {
        return wrapper.getBalance(player);
    }

    @Override 
    public void setBalance(Player player, double amount) {
        wrapper.setBalance(player, amount);
    }

    @Override 
    public void addBalance(Player player, double amount) {
        setBalance(player, getBalance(player) + amount);
    }

    @Override 
    public void removeBalance(Player player, double amount) {
        setBalance(player, getBalance(player) - amount);
    }

    @Override 
    public boolean canAfford(Player player, double amount) {
        return getBalance(player) >= amount;
    }
    
    @Override 
    public boolean hasIntegrated() {
        return wrapper != null;
    }

	@Override
	public String getPluginSourceURL() {
		return "https://www.spigotmc.org/resources/essentialsx.9089/";
	}

}
