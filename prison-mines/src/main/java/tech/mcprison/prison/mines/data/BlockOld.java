/*
 * Prison is a Minecraft plugin for the prison game mode.
 * Copyright (C) 2017 The Prison Team
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

package tech.mcprison.prison.mines.data;

import tech.mcprison.prison.internal.block.PrisonBlockStatusData;
import tech.mcprison.prison.util.BlockType;

/**
 * Represents a block in a mine
 */
public class BlockOld
	extends PrisonBlockStatusData {

    /**
     * The {@link BlockType} represented by this {@link BlockOld}
     */
    private BlockType type; // = BlockType.AIR;
    /**
     * The chance of this block appearing in it's associated mine
     */
    private double chance; // = 100.0d;

    /**
     * Assigns the type and chance
     */
    public BlockOld(BlockType block, double chance, long blockCountTotal) {
    	super(block.name(), chance, blockCountTotal);
    			
        this.type = block;
        this.chance = chance;
    }

    public BlockOld(String blockType, double chance, long blockCountTotal) {
    	super(blockType, chance, blockCountTotal);
    	
    	this.chance = chance;
    	
    	BlockType block = BlockType.fromString( blockType );
    	this.type = block;
    	// Update blockName since mapping to BlockType may result in a different name:
    	setBlockName( block.name() );
    	
    }
    
	@Override
	public String toString() {
		return getType().name() + " " + Double.toString( getChance() );
	}

	public BlockType getType()
	{
		return type;
	}
	public void setType( BlockType type )
	{
		this.type = type;
	}

	public double getChance()
	{
		return chance;
	}
	public void setChance( double chance )
	{
		this.chance = chance;
	}
}
