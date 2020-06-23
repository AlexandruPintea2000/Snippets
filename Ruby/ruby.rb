puts "Welcome to ruby!";
# Comments in ruby

puts __FILE__; # puts "ruby.rb";
puts __LINE__; # puts "5";

def sum ( a, b )
    result = a + b; # returns the last variable
end

puts sum( 1, 0 );



def block
    puts "In block 1";
    yield
    puts "In block 2";
    yield
end
block { puts "In block subprogram" };


for i in 0..9
	puts "i = #{i}";
end



puts test(?r, "ruby.rb" )   # if file has r permissions: true
puts test(?w, "ruby.rb" )   # if file has w permissions: true
puts test(?x, "ruby.rb" )   # if file has x permissions: true












def even ( a )
    if a % 2 == 0
        result = true
    else
        result = false
    end
end

def odd ( a )
    if a % 2 == 0
        result = false
    else
        result = true
    end
end

def positive ( a )
    if a >= 0
        result = true
    else
        result = false
    end
end

def negative ( a )
    if a < 0
        result = true
    else
        result = false
    end
end


def least_common ( a, b )
    while ( a != 0 and b != 0 ) do
    	if a > b
    		a = a%b;
        end
    	if b > a
    		b = b%a;
        end
    end

	result = a;
end

def greatest_common ( a, b )
	result = a * b / least_common( a, b );
end

def permuts ( a )
    @p = 1;
    for i in (1..a)
        @p = @p * i;
    end
    result = @p;
end

def combins ( a, k )
    if a >= k
        result = permuts(a) / ( permuts( a - k ) * permuts( k ) );
    else
        result = -1;
    end
end

def arnjs ( a, k )
    if a >= k
        result = permuts(a) / permuts( a - k );
    else
        result = -1;
    end
end

class Interval
	@@num = 0;
	def initialize ( a, b )
		@a = a;
		@b = b;
	end
	
	def is_in ( l )
	    if @a <= l and @b >= l
	        result = true;
	    else
	        result = false;
	    end
	end
end



puts least_common( 15, 25 );
puts greatest_common( 15, 25 );
puts even( 2 );
puts odd( 2 );
puts permuts( 2 );
puts combins( 4, 2 );
puts arnjs( 4, 2 );
intl = Interval. new( 0, 9 );
puts intl.is_in( 5 );


def get_file ( filename )
	file = File.new( filename , "r")
	if file
		content = file.sysread(20)
	else
		content = "";
	end
end

def set_file ( filename, content )
	file = File.new( filename , "r+")
	if file
		file.syswrite( content )
	else
		puts "File invalid.";
	end
end
