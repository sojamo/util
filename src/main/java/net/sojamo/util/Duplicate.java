package net.sojamo.util;

import static net.sojamo.util.Common.println;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Duplicate {

	static public Float invoke( Float theValue ) {
		return new Float( theValue.floatValue( ) );
	}

	static public Integer invoke( Integer theValue ) {
		return new Integer( theValue.intValue( ) );
	}

	static public Double invoke( Double theValue ) {
		return new Double( theValue.doubleValue( ) );
	}

	static public Character invoke( Character theValue ) {
		return new Character( theValue.charValue( ) );
	}

	static public Boolean invoke( Boolean theValue ) {
		return new Boolean( theValue.booleanValue( ) );
	}

	static public String invoke( String theValue ) {
		return new String( theValue.toString( ) );
	}

	static public Long invoke( Long theValue ) {
		return new Long( theValue.longValue( ) );
	}

	static public Byte invoke( Byte theValue ) {
		return new Byte( theValue.byteValue( ) );
	}

	static public Map invoke( Map theValue ) {
		Map m = new LinkedHashMap( );
		for ( Object o : theValue.keySet( ) ) {
			m.put( o , Duplicate.invoke( theValue.get( o ) ) );
		}
		return m;
	}

	static public List invoke( List theValue ) {
		List l = new ArrayList( );
		for ( Object o : theValue ) {
			l.add( Duplicate.invoke( o ) );
		}
		return l;
	}

	/* TODO implement set, Cloneable */

	static public Object invoke( Object theValue ) {
		if ( theValue == null ) {
			return theValue;
		}
		if ( theValue instanceof Integer ) {
			return invoke( ( Integer ) theValue );
		} else if ( theValue instanceof Float ) {
			return invoke( ( Float ) theValue );
		} else if ( theValue instanceof Double ) {
			return invoke( ( Double ) theValue );
		} else if ( theValue instanceof Character ) {
			return invoke( ( Character ) theValue );
		} else if ( theValue instanceof String ) {
			return invoke( ( String ) theValue );
		} else if ( theValue instanceof Boolean ) {
			return invoke( ( Boolean ) theValue );
		} else if ( theValue instanceof Long ) {
			return invoke( ( Long ) theValue );
		} else if ( theValue instanceof Byte ) {
			return invoke( ( Byte ) theValue );
		}
		//		else if ( theValue instanceof Controller ) {
		//			return invoke( ( Controller ) theValue );
		//		} 
		else if ( theValue instanceof Map ) {
			return invoke( ( Map ) theValue );
		} else if ( theValue instanceof List ) {
			return invoke( ( List ) theValue );
		} else if ( theValue.getClass( ).isArray( ) ) {
			if ( theValue instanceof boolean[] ) {
				List l = new ArrayList( ( ( boolean[] ) theValue ).length );
				for ( boolean o : ( boolean[] ) theValue ) {
					l.add( o );
				}
				return l;
			} else if ( theValue instanceof byte[] ) {
				List l = new ArrayList( ( ( byte[] ) theValue ).length );
				for ( byte o : ( byte[] ) theValue ) {
					l.add( o );
				}
				return l;
			} else if ( theValue instanceof short[] ) {
				List l = new ArrayList( ( ( short[] ) theValue ).length );
				for ( short o : ( short[] ) theValue ) {
					l.add( o );
				}
				return l;
			} else if ( theValue instanceof char[] ) {
				List l = new ArrayList( ( ( char[] ) theValue ).length );
				for ( char o : ( char[] ) theValue ) {
					l.add( o );
				}
				return l;
			} else if ( theValue instanceof int[] ) {
				List l = new ArrayList( ( ( int[] ) theValue ).length );
				for ( int o : ( int[] ) theValue ) {
					l.add( o );
				}
				return l;
			} else if ( theValue instanceof long[] ) {
				List l = new ArrayList( ( ( long[] ) theValue ).length );
				for ( long o : ( long[] ) theValue ) {
					l.add( o );
				}
				return l;
			} else if ( theValue instanceof float[] ) {
				List l = new ArrayList( ( ( float[] ) theValue ).length );
				for ( float o : ( float[] ) theValue ) {
					l.add( o );
				}
				return l;
			} else if ( theValue instanceof double[] ) {
				List l = new ArrayList( ( ( double[] ) theValue ).length );
				for ( double o : ( double[] ) theValue ) {
					l.add( o );
				}
				return l;
			} else if ( theValue instanceof Object[] ) {
				List l = new ArrayList( ( ( Object[] ) theValue ).length );
				for ( Object o : ( Object[] ) theValue ) {
					l.add( invoke( o ) );
				}
				return l;
			}
		} else {
			if ( theValue instanceof Cloneable ) {
				/* TODO return cloned version of theValue */
				println( "is cloneable, but not yet implemented" );
			}
			return theValue;
		}
		return theValue;
	}
}
