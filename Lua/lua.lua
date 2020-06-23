a = 9
b = 5


function positive ( a )
    if ( a >= 0 )
    then
        return true;
    else
        return false;
    end
end

function negative ( a )
    if ( a < 0 )
    then
        return true;
    else
        return false;
    end
end

function even ( a )
    if ( a % 2 == 0 )
    then
        return true;
    else
        return false;
    end
end

function odd ( a )
    if ( a % 2 == 1 )
    then
        return true;
    else
        return false;
    end
end

function get_file ( filename )

	file = io.open(filename, "r")
	io.input(file) -- sets the default input file

	file_get = "";
	temp = "file";
	while ( temp )
	do
        temp = io.read()
        file_get = file_get..temp.."\n";
    end

	io.close(file)

	return file_get;

end

function set_file ( filename, content )

	file = io.open(filename, "r") -- clears file
	io.input(file) 
	io.close(file)

	file = io.open(filename, "a")
	io.output(file)
	io.write(content)
	io.close(file)

end



Interval = { a = 0, b = 0 }

function Interval:new ( o, a, b )

	o = o or {}
	setmetatable(o, self)
	self.__index = self
	self.a = a or 0
	self.b = b or 0

	return o;
end

function Interval:is_in ( l )

	if ( l >= self.a and l <= self.b )
	then
		return true;
	else
		return false;
	end

end




print( "a - b + 1 = ", a - b + 1  )

intl = Interval:new( null, 0, 9 );
print( intl:is_in( 5 ) );


ary = { 1, 2, 3, 4, 5 }; -- i = 1, 5

for i = 1, 5 do
    print( ary[ i ] );
end

print( positive( 9 ) );
print( negative( -1 ) );
print( even( 5 ) );
print( odd( -1 ) );
