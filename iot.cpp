#include <iostream>
#include <string>

using namespace std;

string iot_name[1000] = { "iot1", "iot2", "iot3", "iot4"};
int ip[1000] = { 0, 1, 2, 3};

int ip1[1000] = { 0, 3, 1, 3};
int ip2[1000] = { 1, 0, 2, 0};;
string information[1000] = { "information1", "information2", "information3", "information4" };

int main()
{
    for ( int i = 0; i < 4; i = i + 1 )
        cout << iot_name[ ip1[ i ]] << " " << iot_name[ ip2[ i ]] << " " << information[ i ] << '\n';

    return 0;
}
