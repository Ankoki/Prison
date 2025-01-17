package tech.mcprison.prison.spigot.nbt;

import org.bukkit.inventory.ItemStack;

import de.tr7zw.changeme.nbtapi.NBT;
import de.tr7zw.changeme.nbtapi.iface.ReadWriteNBT;
import tech.mcprison.prison.output.Output;

/**
 * <p>This class manages the use of NBTs within prison so it's a common interface
 * that is consistent and works properly.
 * </p>
 * 
 * <p>This class has debug logging, but by default it is turned off to keep it from 
 * getting to be too verbose in the logs.  The idea is that once a section of code
 * is working then it does not need to have debugging enabled.  So this is used
 * more for testing new sections of code.
 * </p>
 * 
 * <p>References:</p>
 * https://github.com/tr7zw/Item-NBT-API/wiki/Using-the-NBT-API
 * 
 * 
 * @author Blue
 *
 */
public class PrisonNBTUtil {

	private static boolean enableDebugLogging = false;
	
	
	public static boolean hasNBTString( ItemStack bukkitStack, String key ) {
		String results = null;
		
		results = getNBTString( bukkitStack, key );
		
		return results != null && results.trim().length() > 0;
	}
	
	public static String getNBTString( ItemStack bukkitStack, String key ) {
		String results = null;
		
		results = NBT.get(bukkitStack, nbt -> nbt.getString(key));
		
		return results;
	}

	public static void setNBTString( ItemStack bukkitStack, String key, String value ) {
	
		NBT.modify(bukkitStack, nbt -> {
			nbt.setString(key, value);
		});
			 
		if ( isEnableDebugLogging() ) {
			nbtDebugLog( bukkitStack, "setNBTString" );
		}
	}
	
	public static boolean getNBTBoolean( ItemStack bukkitStack, String key ) {
		boolean results = false;
		
		results = NBT.get(bukkitStack, nbt -> nbt.getBoolean(key));
		
		return results;
	}
	
	public static void setNBTBoolean( ItemStack bukkitStack, String key, boolean value ) {
		
		NBT.modify(bukkitStack, nbt -> {
			nbt.setBoolean(key, value);
		});
		
		if ( isEnableDebugLogging() ) {
			nbtDebugLog( bukkitStack, "setNBTBoolean" );
		}
	}

	
	public static void nbtDebugLog( ItemStack bukkitStack, String desc ) {
		if ( Output.get().isDebug() ) {
			
			String nbtDebug = nbtDebugString( bukkitStack );
			
			int sysId = System.identityHashCode(bukkitStack);
			
			String message = Output.stringFormat( 
					"NBT %s ItemStack for %s: %s  sysId: %d", 
					desc,
					bukkitStack.hasItemMeta() && bukkitStack.getItemMeta().hasDisplayName() ? 
							bukkitStack.getItemMeta().getDisplayName() :
								bukkitStack.getType().name(),
								nbtDebug,
								sysId );
			
			Output.get().logInfo( message );
			
			//Output.get().logInfo( "NBT: " + new NBTItem( getBukkitStack() ) );
			
		}
	}
	
	public static String nbtDebugString( ItemStack bukkitStack ) {
		
		ReadWriteNBT nbtItem = NBT.itemStackToNBT(bukkitStack);
		return nbtItem.toString();
	}
	
//    public NBTItem getNBT( ItemStack bukkitStack ) {
//    	NBTItem nbtItemStack = null;
//    	
//    	if ( bukkitStack != null && bukkitStack.getType() != Material.AIR  ) {
//    		try {
//				nbtItemStack = new NBTItem( bukkitStack, true );
//				
//				if ( isEnableDebugLogging() ) {
//					nbtDebugLog( nbtItemStack, "getNbt" );
//				}
//				
//			} catch (Exception e) {
//				// ignore - the bukkit item stack is not compatible with the NBT library
//			}
//    	}
//    	
//    	return nbtItemStack;
//    }
    
    
//    private void nbtDebugLog( NBTItem nbtItem, String desc ) {
//		if ( Output.get().isDebug() ) {
//			org.bukkit.inventory.ItemStack iStack = nbtItem.getItem();
//			
//			int sysId = System.identityHashCode(iStack);
//			
//			String message = Output.stringFormat( 
//					"NBT %s ItemStack for %s: %s  sysId: %d", 
//					desc,
//					iStack.hasItemMeta() && iStack.getItemMeta().hasDisplayName() ? 
//							iStack.getItemMeta().getDisplayName() :
//							iStack.getType().name(),
//					nbtItem.toString(),
//					sysId );
//			
//			Output.get().logInfo( message );
//			
//			//Output.get().logInfo( "NBT: " + new NBTItem( getBukkitStack() ) );
//			
//		}
//    }
    
    
//    public boolean hasNBTKey( NBTItem nbtItem, String key ) {
//    	boolean results = false;
//    	
//    	if ( nbtItem != null ) {
//    		results = nbtItem.hasKey( key );
//    	}
//    	
//    	return results;
//    }
    
//    private String getNBTString( NBTItem nbtItem, String key ) {
//    	String results = null;
//    	
//    	if ( nbtItem != null ) {
//    		results = nbtItem.getString( key );
//    	}
//    	return results;
//    }
    
//    private void setNBTString( NBTItem nbtItem, String key, String value ) {
//
//    	if ( nbtItem != null ) {
//    		nbtItem.setString( key, value );
//    		
//    		if ( isEnableDebugLogging() ) {
//    			nbtDebugLog( nbtItem, "setNBTString" );
//    		}
//    	}
//    }


	public static boolean isEnableDebugLogging() {
		return enableDebugLogging;
	}
	public static void setEnableDebugLogging(boolean enableDebugLogging) {
		PrisonNBTUtil.enableDebugLogging = enableDebugLogging;
	}
    
}
