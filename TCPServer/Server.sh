mvn package

if [ -z "$1" ] && [ -z "$2" ] && [ -z "$3" ] && [ -z "$4" ]
	then
		echo 'Server is running with default configs'
		java -jar ./target/TCPServer-1.0-SNAPSHOT.jar
	else
		echo 'Client sending requst to port : ' $1
		java -jar ./target/TCPClient-1.0-SNAPSHOT.jar $1 $2 $3 $4
	fi

