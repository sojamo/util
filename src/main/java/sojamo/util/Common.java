package sojamo.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.sql.Date;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings( { "rawtypes" , "unchecked" } ) public class Common {

	/* TODO write tests, especially for the functions mimicking clojure
	 * functions. */

	static public final double PI = Math.PI;
	static public final double HALF_PI = Math.PI / 2;
	static public final double TWO_PI = Math.PI * 2;
	static public final double QUARTER_PI = Math.PI / 4;

	static boolean DEBUG = false;

	static public final String delimiter = " ";
	static public final String pathdelimiter = "/";

	static public Object nil = new Object( );

	static public int[] iarray( final Object o ) {
		return ( o instanceof int[] ) ? ( int[] ) o : new int[ 0 ];
	}

	static public float[] farray( final Object o ) {
		return ( o instanceof float[] ) ? ( float[] ) o : new float[ 0 ];
	}

	static public long[] larray( final Object o ) {
		return ( o instanceof long[] ) ? ( long[] ) o : new long[ 0 ];
	}

	static public double[] darray( final Object o ) {
		return ( o instanceof double[] ) ? ( double[] ) o : new double[ 0 ];
	}

	static public boolean[] barray( final Object o ) {
		return ( o instanceof boolean[] ) ? ( boolean[] ) o : new boolean[ 0 ];
	}

	static public String[] sarray( final Object o ) {
		return ( o instanceof String[] ) ? ( String[] ) o : new String[ 0 ];
	}

	static public byte[] bytes( final Object o ) {
		return ( o != null && o instanceof byte[] ) ? ( byte[] ) o : new byte[ 0 ];
	}

	static public BigInteger I( final Object o ) {
		return I( o , BigInteger.valueOf( Long.MIN_VALUE ) );
	}

	static public BigInteger I( final Object o , final BigInteger theDefault ) {
		return ( o instanceof BigInteger ) ? ( BigInteger ) ( o ) : theDefault;
	}

	static public BigInteger I( Map m , String thePath ) {
		return I( m , thePath , BigInteger.valueOf( Long.MIN_VALUE ) );
	}

	static public BigInteger I( Map m , String thePath , BigInteger theDefault ) {
		Object o = getValueFromPath( m , thePath );
		return I( o , theDefault );
	}

	static public BigInteger I( List l , int theIndex ) {
		return I( l , theIndex , BigInteger.valueOf( Long.MIN_VALUE ) );
	}

	static public BigInteger I( List l , int theIndex , BigInteger theDefault ) {
		Object o = value( l , theIndex );
		return I( o , theDefault );
	}

	static public int i( final Object o ) {
		return i( o , Integer.MIN_VALUE );
	}

	static public int i( final Object o , final int theDefault ) {
		return ( o instanceof Number ) ? ( ( Number ) o ).intValue( ) : ( o instanceof String ) ? i( s( o ) ) : theDefault;
	}

	static public int i( final String o ) {
		return i( o , Integer.MIN_VALUE );
	}

	static public int i( final String o , final int theDefault ) {
		return isNumeric( o ) ? Integer.parseInt( o ) : theDefault;
	}

	static public int i( Map m , String thePath ) {
		return i( m , thePath , Integer.MIN_VALUE );
	}

	static public int i( Map m , String thePath , int theDefault ) {
		Object o = getValueFromPath( m , thePath );
		return i( o , theDefault );
	}

	static public int i( List l , int theIndex ) {
		return i( l , theIndex , Integer.MIN_VALUE );
	}

	static public int i( List l , int theIndex , int theDefault ) {
		Object o = value( l , theIndex );
		return i( o , theDefault );
	}

	static public float f( final Object o ) {
		return f( o , Float.MIN_VALUE );
	}

	static public float f( final Object o , final float theDefault ) {
		return ( o instanceof Number ) ? ( ( Number ) o ).floatValue( ) : ( o instanceof String ) ? f( s( o ) ) : theDefault;
	}

	static public float f( final String o ) {
		return f( o , Float.MIN_VALUE );
	}

	static public float f( final String o , final float theDefault ) {
		return isNumeric( o ) ? Float.parseFloat( o ) : theDefault;
	}

	static public float f( Map m , String thePath ) {
		return f( m , thePath , Float.MIN_VALUE );
	}

	static public float f( Map m , String thePath , float theDefault ) {
		Object o = getValueFromPath( m , thePath );
		return f( o , theDefault );
	}

	static public float f( List l , int theIndex ) {
		return f( l , theIndex , Float.MIN_VALUE );
	}

	static public float f( List l , int theIndex , float theDefault ) {
		Object o = value( l , theIndex );
		return f( o , theDefault );
	}

	static public int c( final String o , final char theDefault ) {
		return hex( o , theDefault );
	}

	static public int c( final Object o , final int theDefault ) {
		return o == null ? theDefault : hex( o.toString( ) , theDefault );
	}

	static public double d( final Object o ) {
		return d( o , Double.MIN_VALUE );
	}

	static public double d( final Object o , final double theDefault ) {
		return ( o instanceof Number ) ? ( ( Number ) o ).doubleValue( ) : ( o instanceof String ) ? d( s( o ) ) : theDefault;
	}

	static public double d( final String o ) {
		return d( o , Double.MIN_VALUE );
	}

	static public double d( final String o , final double theDefault ) {
		return isNumeric( o ) ? Double.parseDouble( o ) : theDefault;
	}

	static public double d( Map m , String thePath ) {
		return d( m , thePath , Double.MIN_VALUE );
	}

	static public double d( Map m , String thePath , double theDefault ) {
		Object o = getValueFromPath( m , thePath );
		return d( o , theDefault );
	}

	static public double d( List l , int theIndex ) {
		return d( l , theIndex , Double.MIN_VALUE );
	}

	static public double d( List l , int theIndex , double theDefault ) {
		Object o = value( l , theIndex );
		return d( o , theDefault );
	}

	static public long l( final Object o ) {
		return l( o , Long.MIN_VALUE );
	}

	static public long l( final Object o , final long theDefault ) {
		return ( o instanceof Number ) ? ( ( Number ) o ).longValue( ) : ( o instanceof String ) ? l( s( o ) ) : theDefault;
	}

	static public long l( Map m , String thePath ) {
		return l( m , thePath , Long.MIN_VALUE );
	}

	static public long l( Map m , String thePath , long theDefault ) {
		Object o = getValueFromPath( m , thePath );
		return l( o , theDefault );
	}

	static public long l( List l , int theIndex ) {
		return l( l , theIndex , Long.MIN_VALUE );
	}

	static public long l( List l , int theIndex , long theDefault ) {
		Object o = value( l , theIndex );
		return l( o , theDefault );
	}

	static public String s( final Object o ) {
		return ( o != null ) ? o.toString( ) : "";
	}

	static public String s( final Number o , int theDec ) {
		return ( o != null ) ? String.format( "%." + theDec + "f" , o.floatValue( ) ) : "";
	}

	static public String s( final Object o , final String theDefault ) {
		return ( o != null ) ? o.toString( ) : theDefault;
	}

	static public String s( Map m , String thePath ) {
		return s( m , thePath , "" );
	}

	static public String s( Map m , String thePath , String theDefault ) {
		Object o = getValueFromPath( m , thePath );
		return s( o , theDefault );
	}

	static public String s( List l , int theIndex ) {
		return s( l , theIndex , "" );
	}

	static public String s( List l , int theIndex , String theDefault ) {
		Object o = value( l , theIndex );
		return s( o , theDefault );
	}

	static public boolean b( final Object o ) {
		return b( o , false );
	}

	static public boolean b( final Object o , final boolean theDefault ) {
		return ( o instanceof Boolean ) ? ( ( Boolean ) o ).booleanValue( ) : ( o instanceof Number ) ? ( ( Number ) o ).intValue( ) == 0 ? false : true : theDefault;
	}

	static public boolean b( final String o ) {
		return b( o , false );
	}

	static public boolean b( final String o , final boolean theDefault ) {
		return o.equalsIgnoreCase( "true" ) ? true : o.equalsIgnoreCase( "false" ) ? false : theDefault;
	}

	static public boolean b( Map m , String thePath ) {
		return b( m , thePath , false );
	}

	static public boolean b( Map m , String thePath , boolean theDefault ) {
		Object o = getValueFromPath( m , thePath );
		return b( o , theDefault );
	}

	static public boolean b( List l , int theIndex ) {
		return b( l , theIndex , false );
	}

	static public boolean b( List l , int theIndex , boolean theDefault ) {
		Object o = value( l , theIndex );
		return b( o , theDefault );
	}

	static public < T > T o( final Class< T > theClass , final Object o1 , final T o2 ) {
		if ( o1 == null ) {
			return o2;
		}
		if ( theClass.isAssignableFrom( o1.getClass( ) ) ) {
			return ( T ) o1;
		}
		return o2;
	}

	/**
	 * Translates a hex formatted string into an int. currently only supports 24
	 * and 16 bit hex format.
	 */
	static public int hex( final String o , final int theDefault ) {
		try {
			BigInteger hex = new BigInteger( o , 16 );
			int c = hex.intValue( );
			int a = o.length( ) == 6 ? 255 : ( c >> 24 & 0xff );
			int r = ( c >> 16 & 0xff );
			int g = ( c >> 8 & 0xff );
			int b = ( c >> 0 & 0xff );
			return 0x00000000 | a << 24 | r << 16 | g << 8 | b << 0;
		} catch ( NumberFormatException e ) {
			return theDefault;
		}
	}

	static public Object getValueFromPath( final Map m , final String[] thePath ) {
		if ( thePath.length == 1 ) {
			return m.get( thePath[ 0 ] );
		} else {
			String key = thePath[ 0 ];
			if ( m.get( key ) instanceof Map ) {
				Map m1 = ( Map ) m.get( key );
				return getValueFromPath( m1 , Arrays.copyOfRange( thePath , 1 , thePath.length ) );
			}
		}
		return null;
	}

	/* Note to self: clojure: get-in; thePath is cursor to the location of the value we want;
	 * changing a value inside the data-structure is called update-in; see http://vimeo.com/92689149 ~7:00 */
	static public Object getValueFromPath( final Map m , final String thePath ) {
		return getValueFromPath( m , thePath.split( " " ) );
	}

	static public Map getMapFromPath( final Map m , final String[] thePath ) {
		if ( thePath.length == 1 ) {
			return ( Map ) m.get( thePath[ 0 ] );
		} else {
			String key = thePath[ 0 ];
			if ( m.get( key ) instanceof Map ) {
				Map m1 = ( Map ) m.get( key );
				return getMapFromPath( m1 , Arrays.copyOfRange( thePath , 1 , thePath.length ) );
			}
		}
		return Collections.emptyMap( );
	}

	static public Map getMapFromPath( final Map m , final String thePath ) {
		return getMapFromPath( m , thePath.split( " " ) );
	}

	static public void putValue( final Map m , final String thePath , final Object theValue ) {
		putValue( m , thePath.split( " " ) , theValue );
	}

	static public void putValue( final Map m , final String[] thePath , final Object theValue ) {
		int n = thePath.length - 1;
		String[] path = Arrays.copyOfRange( thePath , 0 , n );
		Map m1 = path.length == 0 ? m : getMapFromPath( m , Arrays.copyOfRange( thePath , 0 , thePath.length - 1 ) );
		try {
			m1.put( thePath[ n ] , theValue );
		} catch ( Exception ex ) {
			/* in case the path does not exist, create it with assocIn */
			assocIn( m , toPath( thePath ) , theValue );
		}
	}

	static public Map toMap( final String s ) {
		/* similar to mapFrom(Object ... args) but with type (Number,String)
		 * sensitivity */
		String[] arr = s.trim( ).split( delimiter );
		Map m = new LinkedHashMap( );
		if ( arr.length % 2 == 0 ) {
			for ( int i = 0 ; i < arr.length ; i += 2 ) {
				String s1 = arr[ i + 1 ];
				m.put( arr[ i ] , isNumeric( s1 ) ? s1.indexOf( "." ) == -1 ? i( s1 ) : f( s1 ) : s1 );
			}
		}
		return m;
	}

	/**
	 * creates a map from a series of object, number of arguments must be
	 * multiple of 2, otherwise an empty map will be returned.
	 * 
	 * @param args
	 *            must be multiple of 2
	 * @return Map
	 */
	static public Map toMap( final Object ... args ) {
		Map m = new LinkedHashMap( );
		if ( args.length % 2 == 0 ) {
			for ( int i = 0 ; i < args.length ; i += 2 ) {
				m.put( args[ i ] , args[ i + 1 ] );
			}
		}
		return m;
	}

	static public Map toMap( final List args ) {
		Map m = new LinkedHashMap( );
		if ( args.size( ) % 2 == 0 ) {
			for ( int i = 0 ; i < args.size( ) ; i += 2 ) {
				m.put( args.get( i ) , args.get( i + 1 ) );
			}
		}
		return m;
	}

	static public Map toMap( final Object o ) {
		return o != null ? ( o instanceof Map ) ? ( Map ) o : Collections.emptyMap( ) : Collections.emptyMap( );
	}

	static public Map notEmpty( final Map m , Map theDefault ) {
		return m.equals( Collections.EMPTY_MAP ) ? theDefault : m;
	}

	/**
	 * creates a nested map from a series of object, number of arguments must be
	 * multiple of 2, otherwise an empty map will be returned.
	 * 
	 * @param args
	 *            must be multiple of 2
	 * @return Map
	 */
	static public Map nestedMapFrom( final Object ... args ) {
		Map m = new LinkedHashMap( );
		if ( args.length % 2 == 0 ) {
			for ( int i = 0 ; i < args.length ; i += 2 ) {
				if ( args[ i ].toString( ).indexOf( delimiter ) < 0 ) {
					m.put( args[ i ] , Duplicate.invoke( args[ i + 1 ] ) );
				} else {
					assocIn( m , toList( args[ i ].toString( ) ) , args[ i + 1 ] );
				}
			}
		} else {
			printerr( "nestedMapFrom" , "error" , args.length );
		}
		return m;
	}

	static public List toList( final Object ... args ) {
		List l = new ArrayList( );
		Collections.addAll( l , args );
		return l;
	}

	static public List toList( final Object o ) {
		return o != null ? ( o instanceof List ) ? ( List ) o : ( o instanceof String ) ? toList( o.toString( ) ) : Collections.emptyList( ) : Collections.emptyList( );
	}

	static public List toListWithDelimiter( final String o , final String theDelimiter ) {
		List l = new ArrayList( );
		Collections.addAll( l , o.split( theDelimiter ) );
		return l;
	}

	static public List toList( final String o ) {
		return toListWithDelimiter( o , delimiter );
	}

	static public Set toSet( final Object o ) {
		return o != null ? ( o instanceof Set ) ? ( Set ) o : Collections.emptySet( ) : Collections.emptySet( );
	}

	static public Set toSet( final Object ... args ) {
		Set s = new LinkedHashSet( );
		Collections.addAll( s , args );
		return s;
	}

	static public boolean isNumeric( final Object o ) {
		return isNumeric( o.toString( ) );
	}

	static public boolean isNumeric( final String str ) {
		return str.matches( "(-|\\+)?\\d+(\\.\\d+)?" );
	}

	static public boolean isHex( final String str ) {
		if ( str.length( ) < 6 ) {
			return false;
		}
		try {
			BigInteger hex = new BigInteger( str , 16 );
		} catch ( NumberFormatException e ) {
			return false;
		}
		return true;
	}

	static public Number toNumber( final Object o ) {
		return ( o instanceof Number ) ? ( Number ) o : Integer.MIN_VALUE;
	}

	static public boolean inside( final float theX0 , final float theY0 , final float theX1 , final float theY1 , final float theW , final float theH ) {
		return theX0 >= theX1 && theX0 <= theX1 + theW && theY0 >= theY1 && theY0 <= theY1 + theH;
	}

	static public void print( final Object ... strs ) {
		for ( Object str : strs ) {
			System.out.print( str + " " );
		}
	}

	static public void println( final Object ... strs ) {
		for ( Object str : strs ) {
			System.out.print( str + " " );
		}
		System.out.println( );
	}

	static public void debug( final Object ... strs ) {
		if ( DEBUG ) {
			println( strs );
		}
	}

	static public void printerr( final Object ... strs ) {
		for ( Object str : strs ) {
			System.err.print( str + " " );
		}
		System.err.println( );
	}

	static public void printSystemProperties( ) {
		java.util.Properties p = System.getProperties( );
		Enumeration keys = p.keys( );
		while ( keys.hasMoreElements( ) ) {
			String key = ( String ) keys.nextElement( );
			String value = ( String ) p.get( key );
			println( key , ": " , value );
		}
	}

	static public final float mapValue( final float theValue , final float theStart0 , final float theStop0 , final float theStart1 , final float theStop1 ) {
		return theStart1 + ( theStop1 - theStart1 ) * ( ( theValue - theStart0 ) / ( theStop0 - theStart0 ) );
	}

	static public final double mapValue( final double theValue , final double theStart0 , final double theStop0 , final double theStart1 , final double theStop1 ) {
		return theStart1 + ( theStop1 - theStart1 ) * ( ( theValue - theStart0 ) / ( theStop0 - theStart0 ) );
	}

	static public final float constrainValue( final float theValue , final float theMin , final float theMax ) {
		return theValue < theMin ? theMin : ( theValue > theMax ? theMax : theValue );
	}

	static public final double constrainValue( final double theValue , final double theMin , final double theMax ) {
		return theValue < theMin ? theMin : ( theValue > theMax ? theMax : theValue );
	}

	static public final int constrainValue( final int theValue , final int theMin , final int theMax ) {
		return theValue < theMin ? theMin : ( theValue > theMax ? theMax : theValue );
	}

	static Map< Class< ? > , Class< ? >> classmap = new HashMap< Class< ? > , Class< ? >>( ) {
		{
			put( Integer.class , int.class );
			put( Float.class , float.class );
			put( Double.class , double.class );
			put( Boolean.class , boolean.class );
			put( Character.class , char.class );
			put( Long.class , long.class );
		}
	};

	static public Object invoke( final Object theObject , final String theMember , final Object ... theParams ) {

		Class[] cs = new Class[ theParams.length ];

		for ( int i = 0 ; i < theParams.length ; i++ ) {
			Class c = theParams[ i ].getClass( );
			cs[ i ] = classmap.containsKey( c ) ? classmap.get( c ) : c;
		}
		try {
			final Field f = theObject.getClass( ).getDeclaredField( theMember );
			/* TODO check super */
			f.setAccessible( true );
			Object o = theParams[ 0 ];
			Class cf = o.getClass( );
			if ( cf.equals( Integer.class ) ) {
				f.setInt( theObject , i( o ) );
			} else if ( cf.equals( Float.class ) ) {
				f.setFloat( theObject , f( o ) );
			} else if ( cf.equals( Long.class ) ) {
				f.setLong( theObject , l( o ) );
			} else if ( cf.equals( Double.class ) ) {
				f.setDouble( theObject , d( o ) );
			} else if ( cf.equals( Boolean.class ) ) {
				f.setBoolean( theObject , b( o ) );
			} else if ( cf.equals( Character.class ) ) {
				f.setChar( theObject , ( char ) i( o ) );
			} else {
				f.set( theObject , o );
			}
		} catch ( NoSuchFieldException e1 ) {
			try {
				final Method m = theObject.getClass( ).getDeclaredMethod( theMember , cs );
				/* TODO check super */
				m.setAccessible( true );
				try {
					return m.invoke( theObject , theParams );
				} catch ( IllegalArgumentException e ) {
					System.err.println( e );
				} catch ( IllegalAccessException e ) {
					System.err.println( e );
				} catch ( InvocationTargetException e ) {
					System.err.println( e );
				}

			} catch ( SecurityException e ) {
				System.err.println( e );
			} catch ( NoSuchMethodException e ) {
				System.err.println( e );
			}
		} catch ( IllegalArgumentException e ) {
			System.err.println( e );
		} catch ( IllegalAccessException e ) {
			System.err.println( e );
		}
		return null;
	}

	static public Map putAll( Map m1 , Map ... maps ) {
		for ( Map map : maps ) {
			m1.putAll( map );
		}
		return m1;
	}

	static public void setValuesFor( Object theObject , Map< Object , Object > theParams ) {
		if ( theObject instanceof Map ) {
			toMap( theObject ).putAll( theParams );
		} else {
			for ( Map.Entry entry : theParams.entrySet( ) ) {
				invoke( theObject , entry.getKey( ).toString( ) , entry.getValue( ) );
			}
		}
	}

	static public void merge( final Map m1 , final Map m2 ) {
		/* mimics clojure's merge but modifies m2 instead of returning a new
		 * map. This strategy disregards immutability in favor of avoiding deep
		 * copies (for now). */
		for ( Object o : m1.keySet( ) ) {
			if ( !m2.containsKey( o ) ) {
				m2.put( o , Duplicate.invoke( m1.get( o ) ) );
			} else if ( m1.get( o ) instanceof Map ) {
				merge( toMap( m1.get( o ) ) , toMap( m2.get( o ) ) );
			}
		}
	}

	/* assocIn, dissocIn, getIn work well for Maps but are not beneficial for
	 * AMap or AController since we want to update observers if a value has
	 * changed which is only possible when calling AController.put(). Therefore
	 * consider to keep assocIn, dissocIn, getIn invisible for now. */

	/**
	 * if a path-entry does not exist for the given data structure, it is
	 * created if the data structure is modifiable.
	 * 
	 * keep invisible, force user to use AController put instead.
	 * 
	 * @param theSource
	 * @param thePath
	 * @param theValue
	 */
	/* TODO assocIn does not support nested data structures (as in nested Maps
	 * and Lists) yet. */
	/* TODO optimize, add a version which checks validity of the path. */
	static void assocIn( final Map theSource , final List thePath , final Object theValue ) {
		Map m1 = theSource;
		if ( thePath.isEmpty( ) ) {
			return;
		} else if ( thePath.size( ) == 1 ) {
			try {
				m1.put( thePath.get( 0 ) , Duplicate.invoke( theValue ) );
			} catch ( UnsupportedOperationException e ) {
				printerr( Common.class.getCanonicalName( ) , "assocIn" , "UnsupportedOperationException:" , "incorrect path " , thePath , "element" , thePath.get( 0 ) , "does not exist and destination map is protected." );
				return;
			}
		} else {
			int len = thePath.size( ) - 1;
			for ( int i = 0 ; i < len ; i++ ) {
				Object o = thePath.get( i );
				if ( !m1.containsKey( o ) ) {
					try {
						Map m2 = new LinkedHashMap( );
						m1.put( o , m2 );
						m1 = m2;
					} catch ( UnsupportedOperationException e ) {
						printerr( Common.class.getCanonicalName( ) , "assocIn" , "UnsupportedOperationException:" , "incorrect path " , thePath , "element" , o , "does not exist and destination map is protected." );
						return;
					}
				} else if ( m1.get( o ) instanceof Map ) {
					m1 = toMap( m1.get( o ) );
				} else {
					return;
				}
			}
			m1.put( thePath.get( len ) , Duplicate.invoke( theValue ) );
		}
	}

	static public void dissocIn( final Map theSource , final List thePath , final Object theKey ) {
		/* TODO */
	}

	static public List toPath( final String args ) {
		return toList( args.split( pathdelimiter ) );
	}

	static public List toPath( final String ... args ) {
		return toList( args );
	}

	static public Object getIn( final Map m , final String thePath ) {
		/* mimics clojure's get-in */
		return getIn( m , thePath , null );
	}

	static public Object getIn( final Map m , final List thePath ) {
		/* mimics clojure's get-in */
		return getIn( m , thePath , null );
	}

	static public Object getIn( final Map m , final List thePath , final Object theDefault ) {
		/* mimics clojure's get-in */
		Map m1 = m;
		for ( int i = 0 ; i < thePath.size( ) - 1 ; i++ ) {
			m1 = toMap( m1.get( thePath.get( i ) ) );
		}
		return m1.get( thePath.get( thePath.size( ) - 1 ) );
	}

	/**
	 * returns a value of a nested data structure if available otherwise returns
	 * the default value, the 3rd argument. This operation is performance
	 * consuming since string is evaluated against numeric values as well.
	 * Should only be used if path contains numeric elements used as list index.
	 * Otherwise, use path if traversing a nested map.
	 * 
	 * TODO if last element of path is numeric and nested Value is a List,
	 * theDefault is returned but should return the first element of List.
	 * 
	 * TODO argument m should be final
	 * 
	 * @param m
	 *            List or Map
	 * @param thePath
	 *            String delimited by 'delimiter'
	 * @param theDefault
	 *            returned if path-traversal is unsuccessful.
	 * @return Object
	 */
	static public Object getIn( Object m , final String thePath , final Object theDefault ) {
		/* mimics clojure's get-in */
		String[] strs = thePath.split( delimiter );
		int n = strs.length - 1;
		for ( int i = 0 ; i < n ; i++ ) {
			if ( isNumeric( strs[ i ] ) ) {
				m = value( toList( m ) , i( strs[ i ] ) );
			} else {
				m = value( toMap( m ) , strs[ i ] );
			}
		}
		return toMap( m ).get( strs[ n ] ) != null ? toMap( m ).get( strs[ n ] ) : theDefault;
	}

	/* add map() and reduce() */

	static public Object value( final List l , final Number i ) {
		if ( i.intValue( ) < l.size( ) ) {
			return l.get( i.intValue( ) );
		}
		return null;
	}

	static public Object value( final List l , final Number i , final Object d ) {
		Object o = value( l , i );
		return o == null ? d : o;
	}

	static public Object value( final Map m , final Object key ) {
		return m.get( key );
	}

	static public Object value( final Map m , final Object key , final Object d ) {
		Object o = m.get( key );
		return o == null ? d : o;
	}

	static public boolean notNull( final Object o ) {
		return o != null;
	}

	static public boolean notNull( final Object ... os ) {
		for ( Object o : os ) {
			if ( o == null ) {
				return false;
			}
		}
		return true;
	}

	static public Object notNull( final Object o , final Object d ) {
		return o == null ? d : o;
	}

	static List< Map > unmodifiableList( final List< Map > input ) {
		return Collections.unmodifiableList( new AbstractList< Map >( ) {
			protected List< Map > delegate( ) {
				return Collections.unmodifiableList( input );
			}

			@Override public Map get( int index ) {
				return Collections.unmodifiableMap( delegate( ).get( index ) );
			}

			@Override public int size( ) {
				return input.size( );
			}
		} );
	}

	static public final boolean same( final Class< ? extends Object > o0 , final Class< ? extends Object > o1 ) {
		return ( o0 == o1 || o0.getSuperclass( ) == o0.getSuperclass( ) );
	}

	static public Map retainKeys( final Map m , final String ... s ) {
		Map m1 = new HashMap( m );
		m1.keySet( ).retainAll( new HashSet( Arrays.asList( s ) ) );
		return m1;
	}

	static public List valueAsList( final Map m , final Object theKey , final Object theValue ) {
		Object o = m.get( theKey );
		List l;
		if ( notNull( o ) ) {
			l = toList( m.get( theKey ) );
		} else {
			l = new ArrayList( );
		}
		l.add( theValue );
		return l;
	}

	static public String mapToJSONFormattedString( Map m ) {
		String s = m.toString( ).replaceAll( "=" , " : " );
		s = s.replaceAll( "([a-zA-Z0-9\\-\\_.?@]+)" , "\"$1\"" );
		s = s.replaceAll( "\"([\\d.-]+)\"" , "$1" );
		return s;
	}

	static public String toJSON( Map m ) {
		return mapToJSONFormattedString( m );
	}

	static public boolean is( final int theState , final int theValue ) {
		return ( theState & theValue ) > 0;
	}

	static public boolean is( final Object theState , final int theValue ) {
		return is( i( theState ) , theValue );
	}

	/* Controlpanel related static methods */

	static public long dif( long t0 , long t1 ) {
		return t0 - t1;
	}

	static public long dif( Date t0 , Date t1 ) {
		return t0.getTime( ) - t1.getTime( );
	}

	static public Number dx( Map theData ) {
		double x = d( theData.get( "x" ) );
		double px = d( theData.get( "px" ) );
		return ( x - px );
	}

	static public Number dy( Map theData ) {
		double y = d( theData.get( "y" ) );
		double py = d( theData.get( "py" ) );
		return ( y - py );
	}

	static public void sleep( long theMillis ) {
		try {
			Thread.sleep( theMillis );
		} catch ( Exception e ) {}
	}

	static public boolean addLibraryPath( String pathToAdd ) throws Exception {

		Field usrPathsField = ClassLoader.class.getDeclaredField( "usr_paths" );
		usrPathsField.setAccessible( true );
		String[] paths = ( String[] ) usrPathsField.get( null );

		for ( String path : paths )
			if ( path.equals( pathToAdd ) ) {
				return true;
			}

		String[] newPaths = java.util.Arrays.copyOf( paths , paths.length + 1 );
		newPaths[ newPaths.length - 1 ] = pathToAdd;
		usrPathsField.set( null , newPaths );
		return true;
		/* also see:
		 * http://www.chilkatsoft.com/java-loadLibrary-MacOSX.asp
		 * http://blog.cedarsoft.com/2010/11/setting-java-library-path-programmatically/ */
	}

	static public Object first( Object o ) {
		if ( o instanceof List ) {
			List l = toList( o );
			if ( !l.isEmpty( ) ) {
				return l.get( 0 );
			}
		}
		return null;
	}

	static public Object nth( Object o , int theIndex ) {
		return nth( o , theIndex , null );
	}

	static public Object nth( Object o , int theIndex , Object notFound ) {
		if ( o instanceof List ) {
			List l = toList( o );
			if ( ! ( theIndex < 0 && l.size( ) >= theIndex ) ) {
				return l.get( theIndex );
			}
		}
		return notFound;
	}

	static public Object rest( Object o ) {
		if ( o instanceof List ) {
			List l = toList( o );
			if ( l.size( ) > 1 ) {
				return l.subList( 1 , l.size( ) );
			}
		}
		return null;
	}

}
