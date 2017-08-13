'use strict'

var zmq = require('zeromq'),
    publisher = zmq.socket('pub');
 
publisher.bindSync('tcp://127.0.0.1:8002');
console.log('publisher bound to port 8002');
console.log('sending messages...');
var progress = 0;
 
setInterval(function(){
  publisher.send('gdax 3111,0.5,3112,0.7,' + (new Date).getTime());
  progress++;
  if ((progress % 20) == 0)
    console.log('.');
}, 300);
