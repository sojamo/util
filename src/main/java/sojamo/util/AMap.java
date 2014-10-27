package sojamo.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class AMap< K , V > extends Observable implements Map< K , V > {

	private final Map< K , V > delegate = new LinkedHashMap< K , V >( );

	@Override public String toString( ) {
		return delegate.toString( );
	}

	@Override public void clear( ) {
		delegate.clear( );
	}

	@Override public boolean containsKey( Object key ) {
		return delegate.containsKey( key );
	}

	@Override public boolean containsValue( Object value ) {
		return delegate.containsValue( value );
	}

	@Override public Set< Map.Entry< K , V >> entrySet( ) {
		return delegate.entrySet( );
	}

	@Override public boolean equals( Object o ) {
		return delegate.equals( o );
	}

	@Override public int hashCode( ) {
		return delegate.hashCode( );
	}

	@Override public boolean isEmpty( ) {
		return delegate.isEmpty( );
	}

	@Override public Set< K > keySet( ) {
		return delegate.keySet( );
	}

	@Override public V remove( Object key ) {
		return delegate.remove( key );
	}

	@Override public int size( ) {
		return delegate.size( );
	}

	@Override public Collection< V > values( ) {
		return delegate.values( );
	}

	@Override public void putAll( Map arg0 ) {
		delegate.putAll( arg0 );
	}

	@Override public V get( Object key ) {
		return delegate.get( key );
	}

	@Override public V put( K key , V value ) {
		// TODO Auto-generated method stub
		return delegate.put( key , value );
	}
}
