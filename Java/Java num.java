public class Main
{
	public static void main(String[] args) {
    	// does not return validly
		System.out.println( is_prime( 5 ) );
		System.out.println( is_odd( 5 ) );
		System.out.println( is_square( 9 ) );
		System.out.println( is_cube( 125 ) );
		
		int[] divs = divisors( 162 );
		for ( int i = 0; i < length( divs ); i = i + 1 )
		{
    		System.out.print( divs[ i ] );
    		System.out.print( " " );
		}
    	System.out.print( "\n" );
		
    	// does not return validly
		divs = divisors_prime( 24 );
		for ( int i = 0; i < length( divs ); i = i + 2 )
		{
    		System.out.print( divs[ i ] );
    		System.out.print( " " );
    		System.out.print( divs[ i = 1 ] );
    		System.out.print( "\n" );
		}
		
		System.out.println( is_fibo( 8 ) );
			
		// make for pow
		
		System.out.println( is_pos( 5 ) );
		System.out.println( is_triangle( 4, 2, 5 ) );
		System.out.println( is_square_triangle( 4, 2, 5 ) );
		System.out.println( is_equi_triangle( 5, 5, 5 ) );
		System.out.println( is_isos_triangle( 4, 2, 2 ) );
		
		System.out.println( fct( 3 ) );
		System.out.println( aranj( 4, 2 ) );
		System.out.println( comb( 4, 2 ) );
		
		System.out.println( circle_area( 5 ) );
		System.out.println( circle_circumference( 5 ) );

		System.out.println( lc( 5, 15 ) );
		System.out.println( gc( 5, 15 ) );

	}
	
	// does not return validly
	public static boolean is_prime ( int l )
	{
	    if ( l == 1 )
	        return false;
	    
	    if ( l == 2 )
	        return true;
	    
	    if ( l % 2 == 0 )
	        return false;
	    
	    for ( int d = 3; d * d < l; d = d + 2 )
	        if ( l % d == 0 )
	            return false;
	            
	    return true;
	}
	
	public static boolean is_odd ( int l )
	{
	    if ( l % 2 == 0 )
	        return true;
	        
	    return false;
	}
	
	public static boolean is_square ( int l )
	{
	    if ( l == 1 )
	        return true;
	    
	    for ( int d = 2; d * d <= l; d = d + 1 )
	        if ( d * d == l )
	            return true;
	            
	    return false;
	}
	
	public static boolean is_cube ( int l )
	{
	    if ( l == 1 )
	        return true;
	    
	    for ( int d = 2; d * d * d <= l; d = d + 1 )
	        if ( d * d * d == l )
	            return true;
	            
	    return false;
	}
	
	public static int length ( int[] l )
	{
	    int i = 0;
	    while ( l[i] != 0 )
	        i = i + 1;
	    return i;
	}
	
	public static boolean is_in_ints ( int[] ints, int l )
	{
	    int lngth = length( ints );
	    
	    for ( int i = 0; i < lngth; i = i + 1 )
	        if ( ints[i] == l )
	            return true;
	            
	    return false;
	}
	
	public static int[] sort ( int[] ints )
	{
        for ( int i = 0; i < length( ints ) - 1; i = i + 1 )
            for ( int l = i + 1; l < length( ints ); l = l + 1 )
                if ( ints[ i ] > ints[ l ] )
                {
                    int swp = ints[i];
                    ints[i] = ints[l];
                    ints[l] = swp;
                }
                
        return ints;
	}
	
	public static int[] divisors ( int l )
	{
	    int[] divs = new int[1000];
	    divs[0] = 1;
        int divs_iter = 1;

        for ( int d = 2; d * d <= l; d = d + 1 )
            if ( l % d == 0 )
            {
                if ( ! is_in_ints( divs, d ) )
                {
                    divs[ divs_iter ] = d;
                    divs_iter = divs_iter + 1;
                }
                if ( ! is_in_ints( divs, l / d ) )
                {
                    divs[ divs_iter ] = l / d;
                    divs_iter = divs_iter + 1;
                }
            }

        divs[ divs_iter ] = l;
        
        divs = sort( divs );
        
        return divs;
	}
	
	// does not return validly
	public static int[] divisors_prime ( int l )
	{
	    int[] divs = new int[1000];

        for ( int d = 2; d * d <= l; d = d + 1 )
        {
            if ( is_prime ( d ) )
                while ( l % d == 0 )
                {
                    divs[ d ] = divs[ d ] + 1;
                    System.out.println ( d );
                    l = l / d;
                }
            if ( is_prime ( l / d ) )
                while ( l % ( l / d ) == 0 )
                {
                    divs[ l / d ] = divs[ l / d ] + 1;
                    l = l / ( l / d );
                }
        }

        int[] result = new int[1000];
        int result_iter =0;

        for ( int d = 0; d < 1000; d = d + 1 )
            if ( divs[ d ] != 0 )
            {
                result[ result_iter ] = d;
                result_iter = result_iter + 1;
                result[ result_iter ] = divs[ d ];
                result_iter = result_iter + 1;
            }

        return result;
	}

    public static boolean is_fibo ( int l )
    {
        int[] fib = new int[1000];
        
        fib[ 0 ] = 0;
        fib[ 1 ] = 1;
        
        for ( int i = 2; i < 1000; i = i + 1 )
            fib[ i ] = fib[ i - 1 ] + fib[ i - 2 ];
            
        for ( int i = 0; i < 1000; i = i + 1 )
            if ( fib[ i ] == l )
                return true;
                
        return false;
    }
    
    public static int get_fibo_iter ( int l )
    {
        int[] fib = new int[1000];
        
        fib[ 0 ] = 0;
        fib[ 1 ] = 1;
        
        for ( int i = 2; i < 1000; i = i + 1 )
            fib[ i ] = fib[ i - 1 ] + fib[ i - 2 ];
            
        for ( int i = 0; i < 1000; i = i + 1 )
            if ( fib[ i ] == l )
                return i;
                
        return -1;
    }
    
    public static boolean is_pos ( int l )
    {
        if ( l >= 0 )
            return true;
            
        return false;
    }
    
    public static boolean is_triangle ( float l1, float l2, float l3 )
    {
        if ( l1 + l2 <= l3 )
            return false;
        if ( l2 + l3 <= l2 )
            return false;
        if ( l3 + l2 <= l1 )
            return false;
            
        return true;
    }
    
    public static boolean is_square_triangle ( float l1, float l2, float l3 )
    {
        if ( l1 * l1 + l2 * l2 == l3 * l3 )
            return true;
        if ( l3 * l3 + l1 * l1 == l2 * l2 )
            return true;
        if ( l3 * l3 + l2 * l2 == l1 * l1 )
            return true;
        return false;
    }
    
    public static boolean is_equi_triangle ( float l1, float l2, float l3 )
    {
        if ( l1 == l2 && l1 == l3 )
            return true;
            
        return false;
    }

    public static boolean is_isos_triangle ( float l1, float l2, float l3 )
    {
        if ( l1 == l2 )
            return true;
        if ( l1 == l3 )
            return true;
        if ( l2 == l3 )
            return true;

        return false;
    }
    
    public static int fct ( int l )
    {
        if ( l < 0 )
            return -1;
            
        int prod = 1;
            
        for ( int i = 1; i <= l; i = i + 1 )
            prod = prod * i;
            
        return prod;
    }
    
    public static int comb ( int n, int k )
    {
        if ( k < 0 )
            return -1;
            
        if ( n < 0 )
            return -1;
            
        if ( n < k )
            return -1;
            
        int prod = 1;
        
        for ( int i = n - k + 1; i <= n; i = i + 1 )
            prod = prod * i;
            
        return prod / fct( n - k );
    }
    
    public static int aranj ( int n, int k )
    {
        if ( k < 0 )
            return -1;
            
        if ( n < 0 )
            return -1;
            
        if ( n < k )
            return -1;
            
        int prod = 1;
        
        for ( int i = k + 1; i <= n; i = i + 1 )
            prod = prod * i;
            
        return prod;
    }
    
    public static float circle_area ( float r )
    {
        return (float) 3.14 * r * r;
    }
    
    public static float circle_circumference ( float r )
    {
        return (float) 3.14 * 2 * r;
    }
    
    public static int lc ( int l1, int l2 )
    {
        while ( l1 != 0 && l2 != 0 )
        {
            if ( l1 > l2 )
                l1 = l1 % l2;
            else
                l2 = l2 % l1;
        }
        
        if ( l1 == 0 )
            return l2;
        else
            return l1;
    }
    
    public static int gc ( int l1, int l2 )
    {
        return l1 * l2 / lc ( l1, l2 );
    }
    
    public static float[] prog_ar ( float l0, float r, int lngth )
    {
        float[] result = new float[lngth];
        result[0] = l0;
        
        for ( int i = 1; i < lngth; i = i + 1 )
            result[i] = result[i-1] + r;
            
        return result;
    }
    
    public static float[] prog_gm ( float l0, float r, int lngth )
    {
        float[] result = new float[lngth];
        result[0] = l0;
        
        for ( int i = 1; i < lngth; i = i + 1 )
            result[i] = result[i-1] * r;
            
        return result;
    }
    
    public static float prog_ar_last ( float l0, float r, int lngth )
    {
        return l0 + r * lngth;
    }
    
    public static float prog_gm_last ( float l0, float r, int lngth )
    {
        float result = l0;
        
        for ( int i = 0; i < lngth; i = i + 1 )
            result = result * r;
            
        return result;
    }

	public static int length ( float[] l )
	{
	    int i = 0;
	    while ( l[i] != 0 )
	        i = i + 1;
	    return i;
	}
    
    // also make with sort
    public static boolean is_prog_ar ( float[] floats )
    {
        int lngth = length( floats );
        
        if ( lngth < 2 )
            return false;
        
        float r = floats[1] - floats[0];
        
        for ( int i = 2; i < lngth; i = i + 1 )
            if ( floats[ i ] - floats[ i - 1 ] != r )
                return false;
                
        return true;
    }
    
    // also make with sort
    public static boolean is_prog_gm ( float[] floats )
    {
        int lngth = length( floats );
        
        if ( lngth < 2 )
            return false;
        
        float r = floats[1] / floats[0];
        
        for ( int i = 2; i < lngth; i = i + 1 )
            if ( floats[ i ] / floats[ i - 1 ] != r )
                return false;
                
        return true;
    }

    // also make with sort
    public static float get_prog_ar_ratio ( float[] floats )
    {
        int lngth = length( floats );
        
        if ( lngth < 2 )
            return 0;
        
        if ( ! is_prog_ar( floats ) )
            return 0;
        
        return floats[1] - floats[0];
    }
    
    // also make with sort
    public static float get_prog_gm_ratio ( float[] floats )
    {
        int lngth = length( floats );
        
        if ( lngth < 2 )
            return 0;
        
        if ( ! is_prog_gm( floats ) )
            return 0;
        
        return floats[1] / floats[0];

    }
    
    public static float square_area ( float l )
    {
        return l * l;
    }

    public static float square_perimeter ( float l )
    {
        return l * 4;
    }

    public static float rectangle_area ( float l1, float l2 )
    {
        return l1 * l2;
    }

    public static float rectangle_perimeter ( float l1, float l2 )
    {
        return ( l1 + l2 ) * 2;
    }
    
    // also for trapez

    // does not return validly
    public static float sqrt ( float l )
    {
        return -1;
    }

    // does not return validly
    public static float triangle_area ( float l1, float l2, float l3 )
    {
        float p = ( l1 + l2 + l3 ) / 2;
        
        return sqrt( p * ( p - l1 ) * ( p - l2 ) * ( p - l3 ) );
    }
    
    // does not return validly
    public static float sqrt_3 ( float l )
    {
        return -1;
    }

}
