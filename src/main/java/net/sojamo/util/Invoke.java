package net.sojamo.util;

import java.util.Map;

@SuppressWarnings( { "rawtypes" } ) public interface Invoke {

	public Object invoke( Map m );

	public String desc( );
}