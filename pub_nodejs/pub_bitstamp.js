'use strict'

var zmq = require('zeromq'),
    publisher = zmq.socket('pub');
 
publisher.bindSync('tcp://127.0.0.1:8001');
console.log('publisher bound to port 8001');
console.log('sending messages...');
var progress = 0;
 
setInterval(function(){
  publisher.send('bitstamp 3222,0.6,3224,0.4,' + (new Date).getTime());
  progress++;
  if ((progress % 30) == 0)
    console.log('.');
}, 200);
