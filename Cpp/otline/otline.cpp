#include <string.h>
#include <fstream>
#include <iostream>
#include <string>


using namespace std;


ofstream file;
fstream num;
int choice;

string invert_string (string a)
{
	int len = a.length();
	string r = "";

	for (int i=len-1; i>=0; i=i-1)
	{
		r = r + a[i];
	}

	return r;
}

string int_string (int a)
{
	string r = "";

	while (a != 0)
	{		
		r = r + (char) (a%10 + 48);
		a=a/10;
	}

	r = invert_string(r);

	return r;
}

void apology ()
{
	string strings[4] ={ "name", "reason", "place" };

	string responses[4];

	file << "Good day,\n\n";
	cout << "Good day,\n\n";

	cout << "I will not be able to attend the ";
	file << "I will not be able to attend the ";
	
	cout << "(" << strings[2] << "): ";
	std::getline(cin, responses[2]);
	std::getline(cin, responses[2]);
	file << responses[2];
	cout << endl;

	cout << " since ";
	file << " since ";

	cout << "(" << strings[1] << "): ";
	std::getline(cin, responses[1]);
	file << responses[1];
	cout << endl;

	cout << ".\nI want to apologise and hope this will not happen in the future.\n\nYours,\n";
	file << ".\nI want to apologise and hope this will not happen in the future.\n\nYours,\n";

	cout << "(" << strings[0] << "): ";
	std:getline(cin, responses[0]);
	file << responses[0];
	cout << endl;
}

void thanks ()
{
	string strings[3] ={ "name", "reason" };

	string responses[3];

	file << "Good day,\n\n";
	cout << "Good day,\n\n";

	cout << "I want to thank you very much for ";
	file << "I want to thank you very much for ";
	
	cout << "(" << strings[1] << "): ";
	std::getline(cin, responses[1]);
	std::getline(cin, responses[1]);
	file << responses[1];
	cout << endl;

	cout << ".\nYou have made my day!\n\nYours,\n";
	file << ".\nYou have made my day!\n\nYours,\n";

	cout << "(" << strings[0] << "): ";
	std:getline(cin, responses[0]);
	file << responses[0];
	cout << endl;
}


int main ()
{
	num.open( "num.txt" );

	cout << int_string(14);

	cout << "Select a file:\n";
	cout << "1. apology\n";
	cout << "2. thanks\n";

	cout << "\nEnter your choice: ";

	cin >> choice;

	cout << "\n\n";

	string filename;

	int id;

	num >> id;

	num.close();

	num.open("num.txt", std::ofstream::out | std::ofstream::trunc);
	num.close();

	num.open("num.txt");

	if ( choice == 1 )
	{
		filename = "apology_" + int_string( id ) + ".txt";

		file.open(filename);	

		apology();
	}
	if ( choice == 2 )
	{
		filename = "thanks_" + int_string( id )+ ".txt";
		file.open(filename);
		thanks();
	}

	num << id + 1;

	file.close();
	num.close();

	return 0;	
}
