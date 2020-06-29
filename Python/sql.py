import MySQLdb

# Open database connection
conn = MySQLdb.connect("localhost","root","","db" )

# prepare a cursor object using cursor() method
db = conn.cursor()

# execute SQL query using execute() method.
db.execute("SELECT VERSION()")

# Fetch a single row using fetchone() method.
data = db.fetchone()
print "Database version : %s " % data

# disconnect from server
db.close()
