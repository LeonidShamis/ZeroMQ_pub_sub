## ZeroMQ_pub_sub

### Testing pub-sub with ZeroMQ - Node.JS, Python and Java

Demostrating publishing messages using ZeroMQ from (two) Node.js publishers and subscribing using ZeroMQ from subscribers implemented using Node.JS, Python and Java.

----------

**Get the project:**

Git clone the repository:
```
git clone https://github.com/LeonidShamis/ZeroMQ_pub_sub.git
cd ZeroMQ_pub_sub
```

**Install dependencies / compile/package:**

Node.js publishers and subscriber:
```
cd pub_nodejs
npm install

cd ../sub_nodejs
npm install
```
Python subscriber:
```
cd ../sub_python
pip install -r requirements.txt
```
Java subscriber:
```
cd ../sub_java
mvn clean package
```

**Run publishers and subscribers (*one at a time*):**

From the main project directory open 5 terminal/command windows, change to respective subdirectories and run each program as following:

1) Node.js publisher 1
```
cd pub_nodejs
node pub_bitstamp.js
```
2) Node.js publisher 2
```
cd pub_nodejs
node pub_gdax.js
```
3) Node.js subscriber

NOTE: ensure that no other subsriber is already running
```
cd sub_nodejs
node sub_all.js
```
CTRL+C to stop subscriber 
4) Java subscriber

NOTE: ensure that no other subsriber is already running
```
cd sub_java
mvn exec:java
```
CTRL+C to stop subscriber 
5) Python subscriber

NOTE: ensure that no other subsriber is already running
```
cd sub_python
python sub_all.py
```
CTRL+C to stop subscriber 




