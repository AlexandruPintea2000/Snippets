public class Main
{
	public static void main(String[] args) {
		int l;
		System.out.println( square_diagonal( 1 ) );
		System.out.println( rectangle_diagonal( 1, 2 ) );
		System.out.println( sum( 5 ) );
		System.out.println( median_line( 5 ) );
		System.out.println( circle_part_1( 5, 60 ) );
		System.out.println( circle_part_2( 5, 60 ) );
		System.out.println( det_2( 1, 2, 2, 1 ) );
		System.out.println( det_3( 1, 2, 3, 1, 2, 3, 1, 2, 3 ) );
	}
	
	public static float square_diagonal ( float l )
	{
	    return l * (float) Math.sqrt( 2 );
	}
	
	public static float rectangle_diagonal ( float l1, float l2 )
	{
	    return (float) Math.sqrt( l1 * l2 );
	}
	
	public static int sum ( int l )
	{
	    return l * ( l + 1 ) / 2;
	}
	
	public static float median_line ( float l )
	{
	    return l / 2;
	}
	
	public static float circle_part_1 ( float radius, float angle )
	{
	    return (float) 2 * (float) 3.14 * (float) 360 * (float) radius / (float) angle;
	}

    public static float to_radians ( float angle )
    {
        return (float) 3.14 / (float) 180 * (float) angle;
    }

    public static float to_deg ( float angle )
    {
        return (float) 180 / (float) 3.14 * (float) angle;
    }

	public static float circle_part_2 ( float radius, float angle )
	{
	    return (float) Math.sqrt( 2 * radius * radius * (float) ( 1 - Math.cos( to_radians( angle ) ) ) );
	}
	
	public static float det_2 ( float l_11, float l_12, float l_21, float l_22 )
	{
	    return l_11 * l_22 - l_12 * l_21;
	}

	public static float det_3 ( float l_11, float l_12, float l_13, float l_21, float l_22, float l_23, float l_31, float l_32, float l_33 )
	{
	    return l_11 * l_22 * l_33 + l_12 * l_23 * l_31 + l_21 * l_32 * l_13 - l_13 * l_22 * l_31 - l_11 * l_23 * l_32 - l_33 * l_21 * l_12;
	}
}
