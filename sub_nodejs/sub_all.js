var zmq = require('zeromq'),
    subscriber = zmq.socket('sub');
 
subscriber.subscribe('');
 
subscriber.on('message', function(message) {
  var pieces      = message.toString().split(' ')
    , exchange    = pieces[0]
    , update       = pieces[1];
  
  console.log('exchange: ', exchange, ' update: ', update);
});

subscriber.connect('tcp://127.0.0.1:8001');
subscriber.connect('tcp://127.0.0.1:8002');

console.log('subscriber connected to ports 8001 & 8002');
console.log('receiving messages...');
