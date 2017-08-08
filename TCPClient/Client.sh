mvn package

if [ -z "$1" ] && [ -z "$2" ]
	then
		echo 'Client is sending default request'
		java -jar ./target/TCPClient-1.0-SNAPSHOT.jar
	else
		echo 'Client sending requst to port : ' $1
		java -jar ./target/TCPClient-1.0-SNAPSHOT.jar $1 $2
	fi

