package tech.mcprison.prison.internal.block;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * <p>This class is a new way of dealing with blocks within prison.
 * All blocks will be stored and used as string values.
 * </p>
 *
 */
public class PrisonBlockTypes {
	
	private List<PrisonBlock> blockTypes;
	private TreeMap<String, PrisonBlock> blockTypesByName;
	
	public enum InternalBlockTypes {
		AIR,
		IGNORE,
		NULL_BLOCK
	}

	public PrisonBlockTypes() {
		super();
		
		this.blockTypes = new ArrayList<>();
		
		this.blockTypesByName = new TreeMap<>();
		
		initializeBlockTypes();
	}
	
	private void initializeBlockTypes() {
		
		// First clear the blockTypes:
		getBlockTypes().clear();
		
		getBlockTypes().add( PrisonBlock.IGNORE );

		// Map all available blocks to the blockTypesByName map:
		for ( PrisonBlock pb : getBlockTypes() ) {
			getBlockTypesByName().put( pb.getBlockName().toLowerCase(), pb );
		}
	}
	
	
	public void addBlockTypes( List<PrisonBlock> blockTypes ) {
		
		// Map all available blocks to the blockTypesByName map:
		for ( PrisonBlock pb : blockTypes ) {
			getBlockTypesByName().put( pb.getBlockName().toLowerCase(), pb );
			getBlockTypes().add( pb );
		}
	}

	public List<PrisonBlock> getBlockTypes() {
		return blockTypes;
	}
	public void setBlockTypes( List<PrisonBlock> blockTypes ) {
		this.blockTypes = blockTypes;
	}

	public TreeMap<String, PrisonBlock> getBlockTypesByName() {
		return blockTypesByName;
	}
	public void setBlockTypesByName( TreeMap<String, PrisonBlock> blockTypesByName ) {
		this.blockTypesByName = blockTypesByName;
	}
	
}
